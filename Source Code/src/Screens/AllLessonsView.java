/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.Statistics;
import Data.User;
import Lesson.LessonView;
import Tools.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * AllLessonsView Class
 * @author Anton
 */
public class AllLessonsView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private User userDetails;
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
     * Construct a lesson view.
     * @param masterFrame, the main JFrame.
     * @param userDetails, the logged in user details.
     */
    public AllLessonsView(JFrame masterFrame, User userDetails) {

        //Loads new user, sets up view.
        super(null);
        userDetails = Utilities.loadUser(userDetails.getUsername());
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        setOpaque(false);
        masterFrame.setTitle("Poker Coach - Lesson Center");
        setupButtons();
        setupDetails();
    }

    /**
     * Construct a lesson view.
     * @param masterFrame, the main JFrame.
     * @param userDetails, the logged in user details.
     * @param achievements, the unlocked achievements after taking a lesson.
     */
    public AllLessonsView(JFrame masterFrame, User userDetails, ArrayList<String> achievements) {

        super(null);
        userDetails = Utilities.loadUser(userDetails.getUsername());
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        this.achievements = achievements;
        setOpaque(false);
        masterFrame.setTitle("Poker Coach - Lesson Center");
        setupButtons();
        setupDetails();
        checkAchievements();
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
     * Sets up the buttons.
     */
    private void setupButtons() {

        JButton back = new JButton("Back");
        JButton lessonOne = new JButton("Take Lesson");
        JButton lessonTwo = new JButton("Take Lesson");
        JButton lessonThree = new JButton("Take Lesson");
        JButton lessonFour = new JButton("Take Lesson");
        JButton lessonFive = new JButton("Take Lesson");
        JButton lessonSix = new JButton("Take Lesson");

        back.addActionListener(this);
        lessonOne.addActionListener(this);
        lessonTwo.addActionListener(this);
        lessonThree.addActionListener(this);
        lessonFour.addActionListener(this);
        lessonFive.addActionListener(this);
        lessonSix.addActionListener(this);

        back.setActionCommand("Back");
        lessonOne.setActionCommand("Lesson One");
        lessonTwo.setActionCommand("Lesson Two");
        lessonThree.setActionCommand("Lesson Three");
        lessonFour.setActionCommand("Lesson Four");
        lessonFive.setActionCommand("Lesson Five");
        lessonSix.setActionCommand("Lesson Six");

        add(back);
        add(lessonOne);
        add(lessonTwo);
        add(lessonThree);
        add(lessonFour);
        add(lessonFive);
        add(lessonSix);

        back.setBounds(5, 605, 160, 50);
        lessonOne.setBounds(9 + (171 / 2), 295, 160, 40);
        lessonTwo.setBounds(347 + (171 / 2), 295, 160, 40);
        lessonThree.setBounds(685 + (171 / 2), 295, 160, 40);
        lessonFour.setBounds(9 + (171 / 2), 543, 160, 40);
        lessonFive.setBounds(347 + (171 / 2), 543, 160, 40);
        lessonSix.setBounds(685 + (171 / 2), 543, 160, 40);

    }

    /**
     * Explains what users will learn from each lesson.
     */
    private void setupDetails() {

        JLabel lessonOneDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 1</center></b></p><p><b><center>Introduction</center></b></p><p>"
                + "This lesson will introduce you to the rules of poker, you will learn about hand categories and how certain situations are handled."
                + "</p></html>");
        lessonOneDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonOneDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonOneDetails.setForeground(Color.WHITE);
        lessonOneDetails.setOpaque(false);
        add(lessonOneDetails);
        lessonOneDetails.setBounds(15, 110, 320, 200);

        JLabel lessonTwoDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 2</center></b></p><p><b><center>Hand Strength</center></b></p><p>"
                + "This lesson will teach you how to evaluate the strength of your hole cards, to enable you to make appropriate decisions at the pre-flop stage."
                + "</p></html>");
        lessonTwoDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonTwoDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonTwoDetails.setForeground(Color.WHITE);
        lessonTwoDetails.setOpaque(false);
        add(lessonTwoDetails);
        lessonTwoDetails.setBounds(353, 110, 320, 200);

        JLabel lessonThreeDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 3</center></b></p><p><b><center>Bluffing</center></b></p><p>"
                + "This lesson will teach you about bluffing. You will learn what it is, why it is useful and when it is appropriate to bluff. The lesson will also make you aware of the risks associated with bluffing."
                + "</p></html>");
        lessonThreeDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonThreeDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonThreeDetails.setForeground(Color.WHITE);
        lessonThreeDetails.setOpaque(false);
        add(lessonThreeDetails);
        lessonThreeDetails.setBounds(691, 110, 320, 200);

        JLabel lessonFourDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 4</center></b></p><p><b><center>Slow Play and All In</center></b></p><p>"
                + "This lesson will teach you about slow playing. You will learn what it is, why it is useful, when you are able to slow play and what the associated risks are."
                + "This lesson will also teach you when an appropriate time to go all in would be."
                + "</p></html>");
        lessonFourDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonFourDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonFourDetails.setForeground(Color.WHITE);
        lessonFourDetails.setOpaque(false);
        add(lessonFourDetails);
        lessonFourDetails.setBounds(15, 358, 320, 200);

        JLabel lessonFiveDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 5</center></b></p><p><b><center>Post Flop Strategy</center></b></p><p>"
                + "In this lesson you will be guided through 5 hands, with detailed commentary on the thought process you should undertake in order to take appropriate actions."
                + "</p></html>");
        lessonFiveDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonFiveDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonFiveDetails.setForeground(Color.WHITE);
        lessonFiveDetails.setOpaque(false);
        add(lessonFiveDetails);
        lessonFiveDetails.setBounds(353, 358, 320, 200);

        JLabel lessonSixDetails = new JLabel("<html><p style='font-size:110%'><b><center>Lesson 6</center></b></p><p><b><center>Position</center></b></p><p>"
                + "In this lesson you will learn about the importance of position in poker. You will learn why late position is better than early position and why your position should have a heavy influence on the action you take."
                + "</p></html>");
        lessonSixDetails.setVerticalAlignment(SwingConstants.TOP);
        lessonSixDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        lessonSixDetails.setForeground(Color.WHITE);
        lessonSixDetails.setOpaque(false);
        add(lessonSixDetails);
        lessonSixDetails.setBounds(691, 358, 320, 200);
    }

    /**
     * Sets the current achievement to show.
     * Creates a new timer with code adapted from: http://www.leepoint.net/notes-java/other/10time/20timer.html
     * @param name, the achievement name.
     */
    public void setAchievement(String name) {

        if (achievementName.equals("")) {

            if (name.equals("Beginner")) {
                achievementName = "Beginner";
                iconPath = "Images/Achievements/optimised/1.png";
                waitTime = 1200;
            } else if (name.equals("Amateur")) {
                achievementName = "Amateur";
                iconPath = "Images/Achievements/optimised/amateur.png";
                waitTime = 1200;
            } else if (name.equals("Pro")) {
                achievementName = "Pro";
                iconPath = "Images/Achievements/optimised/pro.png";
                waitTime = 1200;
            } else if (name.equals("100%")) {
                achievementName = "100%";
                iconPath = "Images/Achievements/optimised/%.png";
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
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/main.png"));
            g.drawImage(img, 0, 0, this);

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(122, 122, 122, 80));

            //Drawing of the lesson squares
            RoundRectangle2D rect = new RoundRectangle2D.Double(9, 105, 331, 242, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(347, 105, 331, 242, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(685, 105, 331, 242, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(9, 353, 331, 242, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(347, 353, 331, 242, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(685, 353, 331, 242, 20, 20);
            g2.fill(rect);


            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 18));
            FontMetrics f = g.getFontMetrics();

            //Display users previous best scores.
            Statistics userStats = userDetails.getStatistics();

            if (userStats.getLessonOneScore() > 0) {
                String s = "Best Score: " + userStats.getLessonOneScore() + "%";
                g2.drawString(s, ((9 + ((331 - (f.stringWidth(s))) / 2))), 288);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((9 + ((331 - (f.stringWidth(s))) / 2))), 288);

            }

            if (userStats.getLessonTwoScore() > 0) {
                String s = "Best Score: " + userStats.getLessonTwoScore() + "%";
                g2.drawString(s, ((347 + ((331 - (f.stringWidth(s))) / 2))), 288);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((347 + ((331 - (f.stringWidth(s))) / 2))), 288);

            }

            if (userStats.getLessonThreeScore() > 0) {
                String s = "Best Score: " + userStats.getLessonThreeScore() + "%";
                g2.drawString(s, ((685 + ((331 - (f.stringWidth(s))) / 2))), 288);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((685 + ((331 - (f.stringWidth(s))) / 2))), 288);

            }

            if (userStats.getLessonFourScore() > 0) {
                String s = "Best Score: " + userStats.getLessonFourScore() + "%";
                g2.drawString(s, ((9 + ((331 - (f.stringWidth(s))) / 2))), 536);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((9 + ((331 - (f.stringWidth(s))) / 2))), 536);

            }

            if (userStats.getLessonFiveScore() > 0) {
                String s = "Best Score: " + userStats.getLessonFiveScore() + "%";
                g2.drawString(s, ((347 + ((331 - (f.stringWidth(s))) / 2))), 536);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((347 + ((331 - (f.stringWidth(s))) / 2))), 536);

            }

            if (userStats.getLessonSixScore() > 0) {
                String s = "Best Score: " + userStats.getLessonSixScore() + "%";
                g2.drawString(s, ((685 + ((331 - (f.stringWidth(s))) / 2))), 536);
            } else {
                String s = "Best Score: --";
                g2.drawString(s, ((685 + ((331 - (f.stringWidth(s))) / 2))), 536);

            }

            g2.setFont(new Font("Arial", Font.BOLD, 30));
            f = g.getFontMetrics();
            String homeLabel = "Lesson Center";
            g2.setColor(Color.WHITE);
            g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 90);

        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }

        paintAchievement(g2);
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Free Play")) {
            masterFrame.remove(this);
            masterFrame.add(new FreeplaySetupView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Back")) {
            masterFrame.remove(this);
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson One")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 1));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson Two")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 2));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson Three")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 3));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson Four")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 4));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson Five")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 5));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Lesson Six")) {
            masterFrame.remove(this);
            masterFrame.add(new LessonView(masterFrame, userDetails, 4000, 7, 2, 0, 6));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Exit")) {
            System.exit(0);
        }
    }
}
