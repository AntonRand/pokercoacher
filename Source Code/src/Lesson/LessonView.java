/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import Content.Text.*;
import Primitives.Arrow;
import Abstract.View;
import Data.User;
import Players.Player;
import Primitives.Definition;
import Screens.AllLessonsView;
import Tools.BoardGraphics;
import javax.swing.*;
import Tools.BoardGraphics.*;
import java.awt.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities.*;
import org.ho.yaml.Yaml;

/**
 * LessonView class.
 * @author Anton
 */
public final class LessonView extends View implements ActionListener, MouseListener, MouseMotionListener {

    private JFrame masterFrame;
    private Lesson lessonContent;
    private JEditorPane lessonDetails = new JEditorPane();
    private JEditorPane lessonFeedback = new JEditorPane();
    private JButton nextButton, replayButton, startButton;
    private int mouseX = 0, mouseY = 0;
    private Definition d = null;
    private boolean paint = false;
    private int lessonNumber;

    public LessonView(JFrame masterFrame, User userDetails, int startingChips, int numberOfPlayers, int blindSpeed, int difficulty, int lessonNumber) {

        //Construct GameView
        super(masterFrame, userDetails, startingChips, numberOfPlayers, blindSpeed);

        //Load the correct lesson
        switch (lessonNumber) {
            case 1:
                lessonContent = LessonOne.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Introduction");
                break;
            case 2:
                lessonContent = LessonTwo.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Hand Strength");
                break;
            case 3:
                lessonContent = LessonThree.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Bluffing");
                break;
            case 4:
                lessonContent = LessonFour.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Slow Play and All In");
                break;
            case 5:
                lessonContent = LessonFive.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Post Flop Strategy");
                break;
            case 6:
                lessonContent = LessonSix.getContent(this);
                super.getMasterFrame().setTitle("Lesson Mode - Position");
                break;
        }

        //Setup the rest of the frame.
        super.setupGame(new LessonGame(startingChips, numberOfPlayers, difficulty, blindSpeed, userDetails, this));
        setupButton();
        setupLabel();
        this.masterFrame = masterFrame;
        this.lessonNumber = lessonNumber;
        lessonContent.displayStep();
        addMouseListener(this);

        if (lessonContent.getCurrentStep().getAction().equals("Start")) {
            startButton.setVisible(true);
            replayButton.setVisible(true);
        } else {
            startButton.setVisible(false);
            replayButton.setVisible(false);
        }
    }

    public JEditorPane getLabel() {
        return lessonDetails;
    }

    public LessonStep getCurrentMessage() {
        return lessonContent.getCurrentStep();
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        try {

            //Draw the background.
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/lesson.png"));
            g.drawImage(img, 0, 0, this);

            g2.setColor(new Color(122, 122, 122, 80));

            //Drawing of the Lesson Square
            RoundRectangle2D rect = new RoundRectangle2D.Double(765, 45, 240, 505, 20, 20);
            g2.fill(rect);

            super.drawButtons(g, true);
            super.drawChips(g, true);

            g2.setFont(new Font("Arial", Font.BOLD, 15));
            g2.setColor(Color.WHITE);
            g2.drawString("Lesson Score: " + super.getScore().calculateScore() + "%", 10, 20);
        } catch (Exception e) {
        } finally {

            super.paint(g);

            //Draw the players who are in the hand.
            for (int i = 0; i < getGame().getPlayers().size(); i++) {
                if (getGame().getPlayers().get(i).inGame()) {
                    BoardGraphics.paintPlayer(getGame().getPlayers().get(i), g, this, -95);
                } else {
                    if (getGame().getPlayers().get(i).allIn() && getGame().getPlayers().get(i).getOutLastHand() < 1) {
                        BoardGraphics.paintPlayer(getGame().getPlayers().get(i), g, this, -95);
                    }
                }
            }

            //Paint the community cards.
            if (getGame().getCurrentHand() != null) {
                BoardGraphics.paintCommunityCards(getGame().getCurrentHand().getCommunityCards(), g, this, true);
            }

            drawPot(g2, true);

            ArrayList<Arrow> theArrows = lessonContent.getCurrentStep().getArrows();

            if (theArrows != null) {
                for (Arrow a : theArrows) {
                    a.drawArrow(g);
                }
            }
        }

        //Draw the players turn, flashes so they can see it's their turn.
        if (getGame() != null) {
            if (getGame().getRepainter() != null) {

                int turn = getGUIHand().getPlayersTurn();

                if (turn != -1 && getGame().getRepainter().repaint) {
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setStroke(new BasicStroke(2));
                    g2.setColor(Color.WHITE);
                    g2.draw(getGame().getRepainter().theRectangles[turn]);
                }
            }
        }


        //Draws definitions.
        if (paint == true && d != null) {
            g.setColor(new Color(255, 255, 255, 230));

            RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(mouseX - 300, mouseY - 90, 300, 70, 20, 20);
            Polygon triangle = new Polygon();
            triangle.addPoint(mouseX, mouseY);
            triangle.addPoint(mouseX, mouseY - 30);
            triangle.addPoint(mouseX - 20, mouseY - 30);

            //Creates the Speech Bubble.
            Area a = new Area(roundRectangle);
            Area as = new Area(triangle);
            as.subtract(a);
            as.add(a);

            //Draw the Speech Bubble.
            g2.fill(as);

            //Draw Word
            g2.setFont(new Font("Arial", Font.BOLD, 16));
            FontMetrics f = g.getFontMetrics();
            g2.setColor(Color.BLACK);
            g2.drawString(d.getTitle(), (mouseX - 300 + (300 - (f.stringWidth(d.getTitle()))) / 2), mouseY - 72);

            //Meaning Line 1
            g2.setFont(new Font("Arial", Font.PLAIN, 11));
            f = g.getFontMetrics();
            g2.setColor(Color.BLACK);
            g2.drawString(d.getDefinitionOne(), mouseX - 290, mouseY - 60);

            //Meaning Line 2
            g2.drawString(d.getDefinitionTwo(), mouseX - 290, mouseY - 48);

            //Meaning Line 3
            g2.drawString(d.getDefinitionThree(), mouseX - 290, mouseY - 36);
        }

        //Draw the hint feedback.
        if (getScore().showHint() == true) {

            g2.setColor(new Color(255, 255, 255));

            //Drawing of feedback square.
            RoundRectangle2D rect = new RoundRectangle2D.Double(772, 432, 226, 40, 20, 20);
            g2.fill(rect);

            lessonFeedback.setText("<html>"
                    + "<p style=\"font-family:arial;color:red;font-size:11px;text-align:center;font-weight:bold;\">Incorrect, Scroll over for a hint</p>"
                    + "</hmtl>");
            g2.setFont(new Font("Arial", Font.BOLD, 13));
            g2.setColor(Color.RED);
            g2.drawString("Incorrect, Scroll over for a hint.", 780, 458);

        } else {
            //If the answer was correct.
            if (getScore().showFeedback() == true) {
                if (getScore().lastAttemptCorrect() == true) {

                    lessonFeedback.setText("<html>"
                            + "<p style=\"font-family:arial;color:#00FF00;font-size:15px;text-align:center;font-weight:bold;\">Correct</p>"
                            + "</hmtl>");
                } else {
                    //If the answer was incorrect less than 3 times.
                    g2.setColor(new Color(255, 255, 255));

                    //Drawing of feedback square
                    RoundRectangle2D rect = new RoundRectangle2D.Double(772, 432, 226, 40, 20, 20);
                    g2.fill(rect);

                    lessonFeedback.setText("<html>"
                            + "<p style=\"font-family:arial;color:red;font-size:15px;text-align:center;font-weight:bold;\">Incorrect</p>"
                            + "</hmtl>");

                    g2.setFont(new Font("Arial", Font.BOLD, 15));
                    g2.setColor(Color.RED);
                    g2.drawString("Incorrect", 850, 458);
                }
            } else {
                lessonFeedback.setText("");
            }
        }
    }

    /**
     * Enables the next button.
     */
    public void enableNext() {
        nextButton.setEnabled(true);
        lessonContent.getCurrentStep().setCompleted(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        super.actionPerformed(ae);

        //Next Button.
        if (ae.getActionCommand().matches("Next")) {
            lessonContent.displayNextStep();
            if (lessonContent.getCurrentStep().getAction().contains("Start")) {
                startButton.setVisible(true);
                replayButton.setVisible(true);
                replayButton.setEnabled(false);
                if (lessonContent.getCurrentStep().isCompleted()) {
                    nextButton.setEnabled(true);
                } else {
                    nextButton.setEnabled(false);
                }
                startButton.setText("Start");
                startButton.setActionCommand("Start");
            } else {
                startButton.setVisible(false);
                replayButton.setVisible(false);
                nextButton.setEnabled(true);
            }
            if (lessonContent.getCurrentStep().getAction().contains("End")) {
                nextButton.setActionCommand("End");
                nextButton.setText("Finish");
            }

        //Back Button.
        } else if (ae.getActionCommand().matches("Back")) {
            lessonContent.displayPreviousStep();
            nextButton.setText("Next");
            nextButton.setActionCommand("Next");
            startButton.setText("Start");
            startButton.setActionCommand("Start");

            if (lessonContent.getCurrentStep().getAction().contains("Start")) {
                startButton.setVisible(true);
                replayButton.setVisible(true);

                if (lessonContent.getCurrentStep().isCompleted()) {
                    nextButton.setEnabled(true);
                } else {
                    nextButton.setEnabled(false);
                }

            } else {
                startButton.setVisible(false);
                replayButton.setVisible(false);
                nextButton.setEnabled(true);
            }
        //Finish Button.
        } else if (ae.getActionCommand().matches("End")) {

            ArrayList<String> theAchievements = updateData();

            getGame().stopThread();

            masterFrame.remove(this);
            masterFrame.add(new AllLessonsView(masterFrame, getUserDetails(), theAchievements));
            masterFrame.getComponent(0).validate();
        //Replay Button
        } else if (ae.getActionCommand().matches("Replay")) {

            lessonContent.displayStep();

            replayButton.setEnabled(true);

            if (lessonContent.getCurrentStep().getAction().contains("Start")) {
                LessonHand lh = (LessonHand) super.getGame().getCurrentHand();
                lh.start();
            }

            startButton.setText("Pause");
            startButton.setActionCommand("Pause");

        //Start Button.
        } else if (ae.getActionCommand().matches("Start")) {
            lessonContent.displayStep();

            replayButton.setEnabled(true);

            if (lessonContent.getCurrentStep().getAction().contains("Start")) {
                LessonHand lh = (LessonHand) super.getGame().getCurrentHand();
                lh.start();
            }

            startButton.setText("Pause");
            startButton.setActionCommand("Pause");

        //Pause Button.
        } else if (ae.getActionCommand().matches("Pause")) {

            //Get and Pause Players
            ArrayList<Player> players = super.getGame().getPlayers();

            for (Player player : players) {
                player.changePaused();
            }

            startButton.setText("Continue");
            startButton.setActionCommand("Resume");

        //Resume Button.
        } else if (ae.getActionCommand().matches("Resume")) {

            //Get and Pause Players
            ArrayList<Player> players = super.getGame().getPlayers();

            for (Player player : players) {
                player.changePaused();
            }

            startButton.setText("Pause");
            startButton.setActionCommand("Pause");
        //Quit Button.
        } else if (ae.getActionCommand().matches("Quit")) {

            getGame().stopThread();

            masterFrame.remove(this);
            masterFrame.add(new AllLessonsView(masterFrame, getUserDetails()));
            masterFrame.getComponent(0).validate();
        }
    }

    public void setupButton() {

        super.getHomeButton().setText("Quit Lesson");
        super.getHomeButton().setActionCommand("Quit");

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setActionCommand("Next");
        add(nextButton);

        JButton backButton = new JButton("Previous");
        backButton.addActionListener(this);
        backButton.setActionCommand("Back");
        add(backButton);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setActionCommand("Start");
        add(startButton);

        replayButton = new JButton("Replay");
        replayButton.addActionListener(this);
        replayButton.setActionCommand("Replay");
        add(replayButton);

        startButton.setBounds(888, 480, 110, 30);
        replayButton.setBounds(772, 480, 110, 30);
        backButton.setBounds(772, 515, 110, 30);
        nextButton.setBounds(888, 515, 110, 30);
    }

    public void setupLabel() {

        lessonFeedback.setContentType("text/html");
        lessonFeedback.setEditable(false);
        lessonFeedback.setOpaque(false);
        lessonFeedback.addMouseMotionListener(this);
        lessonFeedback.addMouseListener(this);
        add(lessonFeedback);

        lessonFeedback.setBounds(770, 425, 230, 50);

        lessonDetails.setContentType("text/html");
        lessonDetails.setEditable(false);
        lessonDetails.setOpaque(false);
        lessonDetails.addMouseMotionListener(this);
        lessonDetails.addMouseListener(this);
        add(lessonDetails);
        lessonDetails.setBounds(770, 32, 230, 445);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
        repaint(mouseX - 300, mouseY - 90, 300, 120);
        paint = false;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    /**
     * Uses code taken from - http://stackoverflow.com/questions/1180390/how-to-convert-from-a-mouse-position-to-a-character-position-in-a-jeditorpane-in
     * to detect which word the mouse is hovering over.
     * @param e 
     */
    @Override
    public void mouseMoved(MouseEvent e) {

        JEditorPane theObject = (JEditorPane) e.getSource();

        if (theObject.equals(lessonDetails)) {

            //3 Lines are from - http://stackoverflow.com/questions/1180390/how-to-convert-from-a-mouse-position-to-a-character-position-in-a-jeditorpane-in
            Point pt = new Point(e.getX(), e.getY());
            int characterIndex = lessonDetails.viewToModel(pt);
            d = lessonContent.getCurrentStep().getDefinition(characterIndex);

            //If the character matches the definition characters.
            if (d != null) {
                paint = true;
                repaint(mouseX - 300, mouseY - 90, 300, 120);
                mouseX = e.getX() + lessonDetails.getLocation().x;
                mouseY = e.getY() + lessonDetails.getLocation().y;
            } else {
                //Don't paint the definition.
                paint = false;
                repaint(mouseX - 300, mouseY - 90, 300, 120);
            }
        } else {
            
            //If hovered over the hint.
            
            Point pt = new Point(e.getX(), e.getY());

            if (getScore().showHint() == true) {
                d = lessonContent.getCurrentStep().getHint();
            } else {
                d = null;
            }

            //If the character matches the definition characters.
            if (d != null) {
                paint = true;
                repaint(mouseX - 300, mouseY - 90, 300, 120);
                mouseX = e.getX() + lessonFeedback.getLocation().x;
                mouseY = e.getY() + lessonFeedback.getLocation().y;
            } else {
                paint = false;
                repaint(mouseX - 300, mouseY - 90, 300, 120);
            }
        }
    }

    private ArrayList<String> updateData() {

        //Load List
        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        ArrayList<String> achievements = new ArrayList<String>();

        //Update Score
        for (User user : userList) {
            if (user.getUsername().equals(getUserDetails().getUsername())) {

                int previousScore;

                //If the score was better than previously.
                switch (lessonNumber) {
                    case 1:
                        previousScore = user.getStatistics().getLessonOneScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonOneScore(super.getScore().calculateScore());
                        }
                        break;
                    case 2:
                        previousScore = user.getStatistics().getLessonTwoScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonTwoScore(super.getScore().calculateScore());
                        }
                        break;
                    case 3:
                        previousScore = user.getStatistics().getLessonThreeScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonThreeScore(super.getScore().calculateScore());
                        }
                        break;
                    case 4:
                        previousScore = user.getStatistics().getLessonFourScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonFourScore(super.getScore().calculateScore());
                        }
                        break;
                    case 5:
                        previousScore = user.getStatistics().getLessonFiveScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonFiveScore(super.getScore().calculateScore());
                        }
                        break;
                    case 6:
                        previousScore = user.getStatistics().getLessonSixScore();
                        if (super.getScore().calculateScore() > previousScore) {
                            user.getStatistics().setLessonSixScore(super.getScore().calculateScore());
                        }
                        break;
                }

                //Get Achievements
                achievements = user.getAchievements().getNewLessonUnlocked(user.getStatistics());
            }
        }

        //Save List
        try {
            Yaml.dump(userList, new File("users.yml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not change");
        }
        return achievements;
    }

    @Override
    public boolean isLessonView() {
        return true;
    }
}
