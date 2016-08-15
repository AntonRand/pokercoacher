/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.Achievements;
import Data.User;
import Tools.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.ho.yaml.Yaml;

/**
 * HomeView Class.
 * @author Anton
 */
public class HomeView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private JLabel statsLabel, achievementsLabel, lessonsLabel, freePlayLabel;
    private User theUser;
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
     * Constructor for HomeView, which allows users to navigate.
     * @param masterFrame, the JFrame the panel is on
     * @param userDetails, the logged in user details.
     */
    public HomeView(JFrame masterFrame, User userDetails) {

        super(null);
        this.masterFrame = masterFrame;
        this.theUser = userDetails;
        setOpaque(false);
        masterFrame.setTitle("Poker Coach - Home");

        setupLabels();
        setupButtons();



        //Detect whether the user is new or not.

        //Load List
        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        //Add Winnings and Increment Win Total.
        for (User user : userList) {
            if (user.getUsername().equals(userDetails.getUsername())) {

                Achievements a = user.getAchievements();


                if (!a.isNewcomer()) {
                    a.setNewcomer(true);
                    theUser = user;
                    setAchievement("Newcomer");

                }






            }
        }

        //Save List
        try {
            Yaml.dump(userList, new File("users.yml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not change");
        }



    }

    public final void setupLabels() {

        statsLabel = Utilities.boldLabel("My Statistics", 24);
        achievementsLabel = Utilities.boldLabel("My Achievements", 24);
        lessonsLabel = Utilities.boldLabel("Lessons", 24);
        freePlayLabel = Utilities.boldLabel("Free Play", 24);

        add(statsLabel);
        add(achievementsLabel);
        add(lessonsLabel);
        add(freePlayLabel);

        statsLabel.setAlignmentX(SwingConstants.CENTER);
        lessonsLabel.setAlignmentX(SwingConstants.CENTER);
        achievementsLabel.setAlignmentX(SwingConstants.CENTER);
        freePlayLabel.setAlignmentX(SwingConstants.CENTER);

        statsLabel.setBounds(185, 80 - 5, 300, 100);
        lessonsLabel.setBounds(525, 80 - 5, 300, 100);
        achievementsLabel.setBounds(185, 320 - 10, 300, 100);
        freePlayLabel.setBounds(525, 320 - 10, 300, 100);
    }

    /**
     *
     * Creates the menu buttons.
     *
     * Images are open source and taken from:
     *
     * Statistics - http://www.freeclipartnow.com/money-business/
     * Lessons -    http://mrskrivolavek.com/wp-content/uploads/2011/07/books-clipart.jpg
     * Achievements - http://en.clipart-fr.com/clipart_pictures.php?id=13221
     * Free play - http://www.imageenvision.com/150/29394-royalty-free-cartoon-clip-art-of-a-hand-of-red-playing-cards-including-the-ace-of-hearts-10-of-hearts-jack-of-hearts-queen-of-hearts-and-king-of-hearts-by-andy-nortnik.jpg
     */
    public final void setupButtons() {

        ImageIcon statsIcon = new ImageIcon("Images/options/statistics.png");
        ImageIcon lessonIcon = new ImageIcon("Images/options/lessons.png");
        ImageIcon achievementIcon = new ImageIcon("Images/options/achievements.png");
        ImageIcon freePlayIcon = new ImageIcon("Images/options/freeplay.png");

        JButton logOut = new JButton("Log out");
        JButton freePlay = new JButton(freePlayIcon);
        JButton takeLesson = new JButton(lessonIcon);
        JButton stats = new JButton(statsIcon);

        JButton achievementButton = new JButton(achievementIcon);

        logOut.addActionListener(this);
        freePlay.addActionListener(this);
        takeLesson.addActionListener(this);
        stats.addActionListener(this);
        achievementButton.addActionListener(this);

        logOut.setActionCommand("Log Out");
        freePlay.setActionCommand("Free Play");
        takeLesson.setActionCommand("Take Lesson");
        stats.setActionCommand("Statistics");
        achievementButton.setActionCommand("Achievements");

        add(logOut);
        add(freePlay);
        add(takeLesson);
        add(stats);
        add(achievementButton);

        logOut.setBounds(5, 605, 160, 50);
        freePlay.setBounds(525, 390 - 10, 300, 195);
        takeLesson.setBounds(525, 150 - 5, 300, 195);
        stats.setBounds(185, 150 - 5, 300, 195);
        achievementButton.setBounds(185, 390 - 10, 300, 195);
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
    private void setAchievement(String name) {

        if (achievementName.equals("")) {
            if (name.equals("Newcomer")) {
                achievementName = "Newcomer";
                iconPath = "Images/Achievements/optimised/newcomer.png";
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
                System.out.println("HomeView Error: Couldn't find image.");
            }
        }
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw background and title.
        try {
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/main.png"));
            g.drawImage(img, 0, 0, this);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            g2.setColor(Color.WHITE);
            FontMetrics f = g.getFontMetrics();
            String homeLabel = "Welcome back, " + theUser.getForename() + ".";
            g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 90);
        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }

        g2.setColor(new Color(122, 122, 122, 80));

        //Drawing of the background square.
        RoundRectangle2D rect = new RoundRectangle2D.Double(160, 100, 690, 490, 20, 20);
        g2.fill(rect);

        paintAchievement(g2);
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Free Play")) {
            masterFrame.remove(this);
            masterFrame.add(new FreeplaySetupView(masterFrame, theUser));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Log Out")) {
            masterFrame.remove(this);
            masterFrame.add(new LoginView(masterFrame, 0));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Take Lesson")) {
            masterFrame.remove(this);
            masterFrame.add(new AllLessonsView(masterFrame, theUser));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Statistics")) {
            masterFrame.remove(this);
            masterFrame.add(new StatisticsView(masterFrame, theUser));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Achievements")) {
            masterFrame.remove(this);
            masterFrame.add(new AchievementsView(masterFrame, theUser));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Exit")) {
            System.exit(0);
        }
    }
}
