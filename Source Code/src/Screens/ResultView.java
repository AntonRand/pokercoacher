/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.User;
import Players.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author axr712
 */
public class ResultView extends JPanel implements ActionListener {

    private ArrayList<Player> finalPositions;
    private User userDetails;
    private JFrame masterFrame;
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
     *
     * @param masterFrame, the JFrame the panel is on
     * @param userDetails, the logged in user details.
     * @param finalPositions, the ordered list of player positions.
     * @param achievements, any achievements the player unlocked.
     */
    public ResultView(JFrame masterFrame, User userDetails, ArrayList<Player> finalPositions, ArrayList<String> achievements) {
        super(null);
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        this.finalPositions = finalPositions;
        masterFrame.setTitle("Poker Coach - End of game results");
        setOpaque(false);
        setupLabels();
        setupButtons();
        this.achievements = achievements;
        //Check if any achievements need to be displayed.
        checkAchievements();
    }

    private void setupLabels() {

        JEditorPane lessonOneDetails = new JEditorPane();

        lessonOneDetails.setContentType("text/html");
        lessonOneDetails.setText(setupPosition());
        lessonOneDetails.setEditable(false);
        lessonOneDetails.setOpaque(false);
        lessonOneDetails.setForeground(Color.WHITE);

        add(lessonOneDetails);

        lessonOneDetails.setBounds(250, 145, 592 - 75, 434);
    }

    public final void setupButtons() {

        JButton backButton = new JButton("Home");
        backButton.addActionListener(this);
        backButton.setActionCommand("Home");
        add(backButton);
        backButton.setBounds(5, 605, 160, 50);
    }

    /**
     * @return, HTML representing players final positions.
     */
    public String setupPosition() {

        String formattedPosition = "<html>";

        for (int i = 0; i < finalPositions.size(); i++) {

            if (i == 0) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>1st:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 1) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>2nd:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 2) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>3rd:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 3) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>4th:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 4) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>5th:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 5) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>6th:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 6) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>7th:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            } else if (i == 7) {
                formattedPosition += "<p style=\"font-family:arial;color:white;font-size:14px;text-align:center;font-weight:bold;\"><b>8th:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + finalPositions.get(i).getName() + "</p><br>";
            }
        }
        return formattedPosition + "</html>";
    }

    /**
     * Keeps setting achievements until no more to display.
     */
    private void checkAchievements() {
        if (!achievements.isEmpty()) {
            setAchievement(achievements.remove(0));
        }
    }

    /**
     * Sets the current achievement to show.
     * Creates a new timer with code adapted from: http://www.leepoint.net/notes-java/other/10time/20timer.html
     * @param name, the achievement name.
     */
    public void setAchievement(String name) {

        if (achievementName.equals("")) {

            if (name.equals("First Win")) {

                achievementName = "First Win";
                iconPath = "Images/Achievements/optimised/1.png";
                waitTime = 1200;

            } else if (name.equals("Fifth Win")) {

                achievementName = "Fifth Win";
                iconPath = "Images/Achievements/optimised/fifthwin.png";
                waitTime = 1200;

            } else if (name.equals("$10,000")) {

                achievementName = "$10,000";
                iconPath = "Images/Achievements/optimised/10k.png";
                waitTime = 1200;

            } else if (name.equals("$100,000")) {

                achievementName = "$100,000";
                iconPath = "Images/Achievements/optimised/100k.png";
                waitTime = 1200;

            } else if (name.equals("Millionaire")) {

                achievementName = "Millionaire";
                iconPath = "Images/Achievements/optimised/millionaire.png";
                waitTime = 1200;

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
        }
    }

    @Override
    public void paint(Graphics g) {

        //Draw the background.
        try {
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/main.png"));
            g.drawImage(img, 0, 0, this);
        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(122, 122, 122, 80));

        //Drawing of the Result Square
        RoundRectangle2D rect = new RoundRectangle2D.Double(7 + 200, 105, 1007 - 400, 490, 20, 20);
        g2.fill(rect);

        //Draw Title.
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics f = g.getFontMetrics();
        String homeLabel = "Results";
        g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 90);
        g2.setFont(new Font("Arial", Font.PLAIN, 26));
        f = g.getFontMetrics();
        homeLabel = "Final Positions";
        g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 140);

        paintAchievement(g2);
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Handle button clicks correctly.
        if (e.getActionCommand().matches("Home")) {
            masterFrame.remove(this);
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        }
    }
}
