/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.Achievements;
import Data.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Achievements Panel
 * @author Anton
 */
public class AchievementsView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private User userDetails;

    /**
     * Constructs the Achievements Panel.
     * @param masterFrame, the JFrame to put the panel on.
     * @param userDetails, the logged in users details.
     */
    public AchievementsView(JFrame masterFrame, User userDetails) {

        super(null);
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        setOpaque(false);
        masterFrame.setTitle("Poker Coach - My Achievements");
        setupLabels();
        setupButtons();
    }

    /**
     * Sets up labels explaining how to unlock each achievement.
     */
    private void setupLabels() {


        JLabel achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Register a Poker Coach account.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 130, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win a freeplay tournament.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 130, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win 5 freeplay tournaments.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 130, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Make $10,000 profit from freeplay tournaments.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 212, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Make $100,000 profit from freeplay tournaments.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 212, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Make $1,000,000 profit from freeplay tournaments.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 212, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win 5 hands with high valued connected cards at the showdown stage in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 294, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Successfully slow play 5 different hands in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 294, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Successfully bluff 5 different hands in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 294, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pass your first lesson. You need to get 70% or more to pass a lesson.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 376, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pass your third lesson. You need to get 70% or more to pass a lesson.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 376, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pass all 6 lessons. You need to get 70% or more to pass a lesson.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 376, 230, 50);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Get a score of 100% for all lessons.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 458, 230, 60);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win with a Royal Flush in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 458, 230, 60);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win with a Straight Flush in freeplay mode. (Includes Royal Flush)</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 458, 230, 60);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win with a Four of a Kind in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(90, 540, 230, 60);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win with a Full House in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(428, 540, 230, 60);

        achievementDetails = new JLabel("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Win with a Flush in freeplay mode.</p>"
                + "</html>");
        achievementDetails.setVerticalAlignment(SwingConstants.TOP);
        add(achievementDetails);
        achievementDetails.setBounds(766, 540, 230, 60);

    }

    private void setupButtons() {
        JButton back = new JButton("Back");
        back.addActionListener(this);
        back.setActionCommand("Back");
        add(back);
        back.setBounds(5, 605, 160, 50);
    }

    /**
     * Draws the achievement based on the following parameters.
     * @param g, the graphics to draw with.
     * @param x, the x coordinate to draw from.
     * @param y, the y coordinate to draw from.
     * @param achievementTitle, the name of the achievement.
     * @param file, the achievement image.
     */
    private void drawAchievement(Graphics g, int x, int y, String achievementTitle, String file) {

        try {
            Graphics2D g2 = (Graphics2D) g;
            FontMetrics f = g.getFontMetrics();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(122, 122, 122, 80));

            RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, 335, 78, 20, 20);
            g2.fill(rect);

            g2.setFont(new Font("Arial", Font.BOLD, 18));
            f = g.getFontMetrics();
            g2.setColor(Color.WHITE);

            g2.drawString(achievementTitle, (((255 - f.stringWidth(achievementTitle)) / 2) + 80 + x), y + 20);

            BufferedImage img1;

            img1 = ImageIO.read(new File(file));
            g.drawImage(img1, x, y - 1, this);

        } catch (IOException ex) {
            System.out.println("AchievementsView Exception: Could not draw achievement");
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


            //Displays the unlocked achievements.
            Achievements userAchievements = userDetails.getAchievements();

            if (userAchievements.isNewcomer() == true) {
                drawAchievement(g, 6, 105, "Newcomer", "Images/Achievements/Newcomer.png");
            } else {
                drawAchievement(g, 6, 105, "Newcomer", "Images/Achievements/greenLock.png");
            }

            if (userAchievements.isFirstWin() == true) {
                drawAchievement(g, 344, 105, "First Win", "Images/Achievements/1.png");
            } else {
                drawAchievement(g, 344, 105, "First Win", "Images/Achievements/greenLock.png");
            }

            if (userAchievements.isFifthWin() == true) {
                drawAchievement(g, 682, 105, "Fifth Win", "Images/Achievements/FifthWin.png");
            } else {
                drawAchievement(g, 682, 105, "Fifth Win", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isTenThousand() == true) {
                drawAchievement(g, 6, 187, "$10,000", "Images/Achievements/10k.png");
            } else {
                drawAchievement(g, 6, 187, "$10,000", "Images/Achievements/greenLock.png");
            }

            if (userAchievements.isHundredThousand() == true) {
                drawAchievement(g, 344, 187, "$100,000", "Images/Achievements/100k.png");
            } else {
                drawAchievement(g, 344, 187, "$100,000", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isMillion() == true) {
                drawAchievement(g, 682, 187, "Millionaire", "Images/Achievements/Millionaire.png");
            } else {
                drawAchievement(g, 682, 187, "Millionaire", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isTightPlayer() == true) {
                drawAchievement(g, 6, 269, "Tight Player", "Images/Achievements/TightPlayer.png");
            } else {
                drawAchievement(g, 6, 269, "Tight Player", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isSlowPlayer() == true) {
                drawAchievement(g, 344, 269, "Slow Player", "Images/Achievements/SlowPlay.png");
            } else {
                drawAchievement(g, 344, 269, "Slow Player", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isBluffer() == true) {
                drawAchievement(g, 682, 269, "Bluffer", "Images/Achievements/Bluffer.png");
            } else {
                drawAchievement(g, 682, 269, "Bluffer", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isBeginner() == true) {
                drawAchievement(g, 6, 351, "Beginner", "Images/Achievements/1.png");
            } else {
                drawAchievement(g, 6, 351, "Beginner", "Images/Achievements/greenLock.png");
            }

            if (userAchievements.isAmateur() == true) {
                drawAchievement(g, 344, 351, "Amateur", "Images/Achievements/Amateur.png");
            } else {
                drawAchievement(g, 344, 351, "Amateur", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isPro() == true) {
                drawAchievement(g, 682, 351, "Pro", "Images/Achievements/Pro.png");
            } else {
                drawAchievement(g, 682, 351, "Pro", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isHundredPercent() == true) {
                drawAchievement(g, 6, 433, "100%", "Images/Achievements/%.png");
            } else {
                drawAchievement(g, 6, 433, "100%", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isRoyalFlush() == true) {
                drawAchievement(g, 344, 433, "Royal Flush", "Images/Achievements/RoyalFlush.png");
            } else {
                drawAchievement(g, 344, 433, "Royal Flush", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isStraightFlush() == true) {
                drawAchievement(g, 682, 433, "Straight Flush", "Images/Achievements/StraightFlush.png");
            } else {
                drawAchievement(g, 682, 433, "Straight Flush", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isFourOfAKind() == true) {
                drawAchievement(g, 6, 515, "Four of a Kind", "Images/Achievements/FourOfAKind.png");
            } else {
                drawAchievement(g, 6, 515, "Four of a Kind", "Images/Achievements/redLock.png");
            }

            if (userAchievements.isFullHouse() == true) {
                drawAchievement(g, 344, 515, "Full House", "Images/Achievements/FullHouse.png");
            } else {
                drawAchievement(g, 344, 515, "Full House", "Images/Achievements/yellowLock.png");
            }

            if (userAchievements.isFlush() == true) {
                drawAchievement(g, 682, 515, "Flush", "Images/Achievements/Flush.png");
            } else {
                drawAchievement(g, 682, 515, "Flush", "Images/Achievements/greenLock.png");
            }


            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            FontMetrics f = g.getFontMetrics();
            String homeLabel = "My Achievements";
            g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 90);

        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //If the user clicked on the back button.
        if (ae.getActionCommand().matches("Back")) {
            masterFrame.remove(this);
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        }
    }
}
