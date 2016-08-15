/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Freeplay;

import Abstract.View;
import Data.User;
import Tools.BoardGraphics;
import Tools.Utilities;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * FreeplayView Class.
 * @author Anton
 */
public final class FreeplayView extends View implements ActionListener {

    private FreeplayGame theGame;
    private JEditorPane theTime = new JEditorPane();
    private JEditorPane strengthPane = new JEditorPane();
    private int currentBlind;
    private boolean strengthCollapsed = false;
    private JLabel handStrengthLabel = Utilities.boldLabel("Hand Strength Meter", 14);
    private RoundRectangle2D collapsed = new RoundRectangle2D.Double(835, 125, 180, 190, 20, 20);
    private RoundRectangle2D expanded = new RoundRectangle2D.Double(835, 125, 180, 30, 20, 20);
    //Achievement Fields
    private int yCoordinate = - 120;
    private String achievementName = "";
    private String iconPath = "";
    private RoundRectangle2D notification = new RoundRectangle2D.Double(5, yCoordinate, 200, 80, 20, 20);
    private int waitTime = 1000;
    private javax.swing.Timer t;
    private boolean complete = false;
    private ArrayList<String> achievements = new ArrayList<String>();

    /**
     * Constructs a FreeplayView.
     * @param masterFrame, the JFrame.
     * @param userDetails, the logged in user details.
     * @param startingChips, the amount of starting chips.
     * @param numberOfPlayers, the number of players in the hand.
     * @param blindSpeed, the speed at which the blinds are increased.
     * @param difficulty, the game difficulty.
     */
    public FreeplayView(JFrame masterFrame, User userDetails, int startingChips, int numberOfPlayers, int blindSpeed, int difficulty) {

        super(masterFrame, userDetails, startingChips, numberOfPlayers, blindSpeed);

        //Set up the basics.
        this.theGame = new FreeplayGame(startingChips, numberOfPlayers, difficulty, blindSpeed, userDetails, this);
        super.setupGame(theGame);
        setupStrengthPane();
        currentBlind = theGame.getBigBlind();
        setupPane();
        setupLabel();

        super.getHomeButton().setText("Leave Tournament");
        super.getMasterFrame().setTitle("Playing Freeplay Tournament");

        //We add a mouse listener here to detect whether to expand or collapse
        //the strength meter.
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                if (x >= 845 && x <= 859 & y >= 136 && y <= 149) {
                    if (strengthCollapsed) {
                        strengthCollapsed = false;
                    } else {
                        strengthCollapsed = true;
                    }
                }
            }
        });
    }

    /**
     * Sets up the blind details pane.
     */
    public void setupPane() {
        theTime.setContentType("text/html");
        theTime.setEditable(false);
        theTime.setOpaque(false);
        theTime.setForeground(Color.WHITE);
        add(theTime);
        theTime.setBounds(840, 47, 170, 75);
    }

    /*
     * Sets up the strength pane.
     */
    public void setupStrengthPane() {
        strengthPane.setContentType("text/html");
        strengthPane.setEditable(false);
        strengthPane.setOpaque(false);
        strengthPane.setForeground(Color.WHITE);
        add(strengthPane);
        strengthPane.setBounds(840, 148, 170, 170);
    }

    public boolean isStrengthCollapsed() {
        return strengthCollapsed;
    }

    /**
     * Adds the blind details title.
     */
    public void setupLabel() {
        JLabel blindDetails = Utilities.boldLabel("Blind Details", 14);
        add(blindDetails);
        blindDetails.setBounds(851, 28, 150, 50);
        add(handStrengthLabel);
        handStrengthLabel.setBounds(857, 115, 150, 50);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        try {
            //Draw the background.
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/freeplay.png"));
            g.drawImage(img, 0, 0, this);

            super.drawButtons(g, false);
            super.drawChips(g, false);

        } catch (Exception e) {
            System.out.println("PokerGamePanel - Couldn't draw");
        }
        super.paint(g);

        //Draw the players that are in the game.
        for (int i = 0; i < theGame.getPlayers().size(); i++) {
            if (theGame.getPlayers().get(i).inGame()) {
                BoardGraphics.paintPlayer(theGame.getPlayers().get(i), g, this, -45);
            } else {
                if (theGame.getPlayers().get(i).allIn() && theGame.getPlayers().get(i).getOutLastHand() < 1) {
                    BoardGraphics.paintPlayer(theGame.getPlayers().get(i), g, this, -45);
                }
            }
        }

        //Draw the community cards.
        if (theGame.getCurrentHand() != null) {
            BoardGraphics.paintCommunityCards(theGame.getCurrentHand().getCommunityCards(), g, this, false);
        }

        //Draw the pot amount.
        drawPot(g2, false);
        g2.setColor(new Color(122, 122, 122, 80));

        //Drawing of blind square
        RoundRectangle2D rect = new RoundRectangle2D.Double(835, 40, 180, 80, 20, 20);
        g2.fill(rect);


        //If the player is in the game.
        if (theGame.getPlayers().get(0).inGame()) {

            //Draw the correct state of the hand strength.
            if (!theGame.getPlayers().get(0).inHand()) {
                g2.fill(expanded);
                strengthPane.setVisible(false);
                repaint(835, 120, 188, 200);
            } else {
                if (!strengthCollapsed) {
                    g2.fill(collapsed);
                    drawCollapseTriangle(g2);
                    repaint(835, 120, 188, 200);
                    strengthPane.setVisible(true);
                } else {
                    g2.fill(expanded);
                    drawExpandTriangle(g2);
                    strengthPane.setVisible(false);
                    repaint(835, 120, 188, 200);
                }
            }

        } else {
            //If the player is all in, draw the hand strength meter.
            if (theGame.getPlayers().get(0).allIn() && theGame.getPlayers().get(0).getOutLastHand() < 1) {
                if (!strengthCollapsed) {
                    g2.fill(collapsed);
                    drawCollapseTriangle(g2);
                    repaint(835, 120, 188, 200);
                    strengthPane.setVisible(true);
                } else {
                    g2.fill(expanded);
                    drawExpandTriangle(g2);
                    strengthPane.setVisible(false);
                    repaint(835, 120, 188, 200);
                }
            } else {
                strengthPane.setVisible(false);
                handStrengthLabel.setVisible(false);
            }
        }


        drawBlindTime();
        paintAchievement(g2);

        //Draw the rectangles.
        int turn = getGUIHand().getPlayersTurn();
        if (turn != -1 && getGame().getRepainter().repaint) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.WHITE);
            g2.draw(getGame().getRepainter().theRectangles[turn]);
        }
    }

    public JEditorPane getStrengthPane() {
        return strengthPane;
    }

    /**
     * Sets the remaining time.
     * @param g 
     */
    public void drawBlindTime() {

        int minutes = ((theGame.getRepainter().getTimeLeft() / 1000) / 60);
        int seconds = ((theGame.getRepainter().getTimeLeft() / 1000) % 60);

        //Formats the time correctly.
        if (minutes == 0 && seconds == 0) {
            theTime.setText("<html>"
                    + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:left;\">Current blinds:&nbsp " + currentBlind + "/" + (currentBlind / 2)
                    + "<br>Next blinds:&nbsp " + (currentBlind * 2) + "/" + (currentBlind)
                    + "<br>Next increase:&nbsp Pending</p>"
                    + "</html>");
        } else if (seconds < 10) {
            theTime.setText("<html>"
                    + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:left;\">Current blinds:&nbsp " + currentBlind + "/" + (currentBlind / 2)
                    + "<br>Next blinds:&nbsp " + (currentBlind * 2) + "/" + (currentBlind)
                    + "<br>Next increase:&nbsp " + minutes + ":0" + seconds + "</p>"
                    + "</html>");
        } else {
            currentBlind = theGame.getBigBlind();
            theTime.setText("<html>"
                    + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:left;\">Current blinds:&nbsp " + currentBlind + "/" + (currentBlind / 2)
                    + "<br>Next blinds:&nbsp " + (currentBlind * 2) + "/" + (currentBlind)
                    + "<br>Next increase:&nbsp " + minutes + ":" + seconds + "</p>"
                    + "</html>");
        }
    }

    /**
     * Polygon code adapted from: http://www.programmersheaven.com/mb/java/247058/247058/draw-a-triangle/
     * @param g2, the graphics to draw with.
     */
    public void drawExpandTriangle(Graphics2D g2) {

        //Represents an expanded triangle.
        Point p1 = new Point(845, 145);
        Point p2 = new Point(845, 135);
        Point p3 = new Point(855, 140);

        int[] xs = {p1.x, p2.x, p3.x};
        int[] ys = {p1.y, p2.y, p3.y};
        Polygon triangle = new Polygon(xs, ys, xs.length);

        g2.setColor(Color.WHITE);
        g2.fillPolygon(triangle);
    }

    /**
     * Polygon code adapted from: http://www.programmersheaven.com/mb/java/247058/247058/draw-a-triangle/
     * @param g2, the graphics to draw with.
     */
    public void drawCollapseTriangle(Graphics2D g2) {

        //Represents a collapsed triangle.
        Point p1 = new Point(850, 145);
        Point p2 = new Point(845, 135);
        Point p3 = new Point(855, 135);

        int[] xs = {p1.x, p2.x, p3.x};
        int[] ys = {p1.y, p2.y, p3.y};
        Polygon triangle = new Polygon(xs, ys, xs.length);

        g2.setColor(Color.WHITE);
        g2.fillPolygon(triangle);
    }

    /**
     * Sets the current achievement to show.
     * Creates a new timer with code adapted from: http://www.leepoint.net/notes-java/other/10time/20timer.html
     * @param name, the achievement name.
     */
    public void setAchievement(String name) {

        if (achievementName.equals("")) {

            if (name.equals("Tight Player")) {
                achievementName = "Tight Player";
                iconPath = "Images/Achievements/optimised/tightplayer.png";
                waitTime = 700;
            } else if (name.equals("Slow Player")) {
                achievementName = "Slow Player";
                iconPath = "Images/Achievements/optimised/slowplay.png";
                waitTime = 700;
            } else if (name.equals("Bluffer")) {
                achievementName = "Bluffer";
                iconPath = "Images/Achievements/optimised/bluffer.png";
                waitTime = 700;
            } else if (name.equals("Royal Flush")) {
                achievementName = "Royal Flush";
                iconPath = "Images/Achievements/optimised/royalflush.png";
                waitTime = 700;
            } else if (name.equals("Straight Flush")) {
                achievementName = "Straight Flush";
                iconPath = "Images/Achievements/optimised/straightflush.png";
                waitTime = 700;
            } else if (name.equals("Four of a Kind")) {
                achievementName = "Four of a Kind";
                iconPath = "Images/Achievements/optimised/fourofakind.png";
                waitTime = 700;
            } else if (name.equals("Full House")) {
                achievementName = "Full House";
                iconPath = "Images/Achievements/optimised/fullhouse.png";
                waitTime = 700;
            } else if (name.equals("Flush")) {
                achievementName = "Flush";
                iconPath = "Images/Achievements/optimised/flush.png";
                waitTime = 700;
            }
        }

        //Timer code modified from
        //http://www.leepoint.net/notes-java/other/10time/20timer.html
        t = new javax.swing.Timer(12, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Lower the achievement.
                if (notification.getY() < 3 && waitTime > 0) {
                    yCoordinate += 8;
                    notification.setRoundRect(5, yCoordinate, 200, 80, 20, 20);
                    repaint();
                    //Make the achievement stay still.
                } else if (waitTime > 0) {
                    waitTime -= 6;
                    //Raise the achievement.
                } else if (notification.getY() > - 120) {
                    yCoordinate -= 8;
                    notification.setRoundRect(5, yCoordinate, 200, 80, 20, 20);
                    repaint();
                } else {
                    //Reset the achievement.
                    complete = true;
                    achievementName = "";
                    yCoordinate = - 120;
                    achievementName = "";
                    iconPath = "";
                    notification = new RoundRectangle2D.Double(5, yCoordinate, 200, 80, 20, 20);
                    waitTime = 1000;
                }
            }
        });

        //Start the timer.
        t.start();
    }

    public void addAchievements(ArrayList<String> newAchievements) {
        achievements.addAll(newAchievements);
    }

    /**
     * Check for new achievements to be displayed.
     */
    private void checkAchievements() {
        if (!achievements.isEmpty() && achievementName.equals("")) {
            setAchievement(achievements.remove(0));
        }
    }

    public boolean allAchievementsDisplayed() {
        if (achievements.isEmpty()) {
            return true;
        }
        return false;
    }

    //Draws the achievement square, text and image.
    public void paintAchievement(Graphics2D g2) {

        if (achievementName.equals("") && complete) {
            t.stop();
            achievementName = "";
            checkAchievements();
        } else if (!achievementName.equals("")) {
            //Draw Notification Rectangle
            g2.setColor(new Color(122, 122, 122, 80));
            g2.fill(notification);

            //Draw Title
            g2.setFont(new Font("Arial", Font.BOLD, 16));
            g2.setColor(Color.WHITE);
            g2.drawString("UNLOCKED", 93, yCoordinate + 31);
            //Draw Achievement Name
            g2.setFont(new Font("Arial", Font.PLAIN, 15));
            g2.drawString(achievementName, 93, yCoordinate + 56);

            //Draw Icon
            try {
                BufferedImage img = ImageIO.read(new File(iconPath));
                g2.drawImage(img, 15, yCoordinate + 10, this);
            } catch (IOException ex) {
                System.out.println("FreeplayView Error: Couldn't find image.");
            }
        } else {
            checkAchievements();
        }
    }

    @Override
    public boolean isLessonView() {
        return false;
    }
}
