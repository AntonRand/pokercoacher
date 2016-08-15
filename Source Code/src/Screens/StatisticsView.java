/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.Statistics;
import Data.User;
import Primitives.Card;
import Primitives.Stage;
import Tools.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * StatisticsView Class.
 * @author Anton
 */
public class StatisticsView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private User userDetails;

    /**
     * @param masterFrame, the JFrame the panel is on
     * @param userDetails, the logged in user details.
     */
    public StatisticsView(JFrame masterFrame, User userDetails) {

        super(null);
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        setOpaque(false);
        masterFrame.setTitle("Poker Coach - My Statistics");
        setupButtons();
        setupDetails();
    }

    private void setupButtons() {

        JButton back = new JButton("Back");
        back.addActionListener(this);
        back.setActionCommand("Back");
        add(back);
        back.setBounds(5, 605, 160, 50);
    }

    /**
     * Researched advanced statistics and loosely based on:
     * http://epokerindex.com/poker_room_review.php?roomId=494
     */
    private void setupDetails() {

        Statistics s = userDetails.getStatistics();

        //Calculate statistics to display,
        int lessonsPassed = s.getLessonsPassed();
        double averageScore = s.getAverageScore();
        int tournamentsWon = s.getTournamentsWon();
        int unlockedAchievements = userDetails.getAchievements().totalUnlocked();

        //Display names.
        JEditorPane lessonOneDetails = new JEditorPane();
        lessonOneDetails.setContentType("text/html");
        lessonOneDetails.setText(
                "<html><p style=\"font-family:arial;color:white;font-size:20px;text-align:center;font-weight:bold;\">General Statistics</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Lessons passed:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Average lesson score:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Strongest hand:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Career earnings:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Tournaments won:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Return on investment:</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Achievements unlocked:</p>"
                + "</html>");

        lessonOneDetails.setEditable(false);
        lessonOneDetails.setOpaque(false);
        lessonOneDetails.setForeground(Color.WHITE);
        add(lessonOneDetails);
        lessonOneDetails.setBounds(15, 90, 484, 479);

        //Display Statistics.
        JEditorPane lessonOneValues = new JEditorPane();
        lessonOneValues.setContentType("text/html");
        lessonOneValues.setText(
                "<html><p style=\"font-family:arial;color:white;font-size:20px;text-align:center;font-weight:bold;\">General Statistics</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + lessonsPassed + "/6</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + averageScore + "%</p><br>"
                + "<br><br><br><p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + formatEarnings() + "</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + tournamentsWon + "</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + formatROI() + "%</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + unlockedAchievements + "/18</p>"
                + "</html>");
        lessonOneValues.setEditable(false);
        lessonOneValues.setOpaque(false);
        lessonOneValues.setForeground(Color.WHITE);
        add(lessonOneValues);
        lessonOneValues.setBounds(15, 90, 484, 479);

        //Display best hand statistic.
        JEditorPane lessonOneValuesTwo = new JEditorPane();
        lessonOneValuesTwo.setContentType("text/html");
        lessonOneValuesTwo.setText(
                "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\"><b>" + formatBestHand() + "</b></p><br>"
                + "</html>");
        lessonOneValuesTwo.setEditable(false);
        lessonOneValuesTwo.setOpaque(false);
        lessonOneValuesTwo.setForeground(Color.WHITE);
        add(lessonOneValuesTwo);
        lessonOneValuesTwo.setBounds(25, 253, 484, 479);

        //Display advanced names.
        JEditorPane lessonTwoDetails = new JEditorPane();
        lessonTwoDetails.setContentType("text/html");
        lessonTwoDetails.setText("<html><p style=\"font-family:arial;color:white;font-size:20px;text-align:center;font-weight:bold;\">Advanced Statistics</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Hands dealt:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Flops seen %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:left;font-weight:bold;\">Hands won: %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:20px;text-align:center;font-weight:bold;\">Winning Hand Statistics</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:left;font-weight:bold;\">Pre-flop win %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:left;font-weight:bold;\">Flop win %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:left;font-weight:bold;\">Turn win %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:left;font-weight:bold;\">River win %:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:left;font-weight:bold;\">Showdown win %:</p>"
                + "</html>");
        lessonTwoDetails.setOpaque(false);
        lessonTwoDetails.setEditable(false);
        add(lessonTwoDetails);
        lessonTwoDetails.setBounds(522, 90, 484, 479);

        //Calculate values.
        int handsDealt = s.getHandsDealt();

        ////Display advanced statistics.
        JEditorPane lessonTwoValues = new JEditorPane();
        lessonTwoValues.setContentType("text/html");
        lessonTwoValues.setText("<html><p style=\"font-family:arial;color:white;font-size:20px;text-align:center;font-weight:bold;\">Advanced Statistics</p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + handsDealt + "</p>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + formatFlopsSeen() + "%</p>"
                + "<p style=\"font-family:arial;color:white;font-size:14px;text-align:right;font-weight:bold;\">" + formatWinPercent() + "%</p>"
                + "<p></p><br>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:right;font-weight:bold;\">" + stageWinPercent(Stage.Preflop) + "%</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:right;font-weight:bold;\">" + stageWinPercent(Stage.Flop) + "%</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:right;font-weight:bold;\">" + stageWinPercent(Stage.Turn) + "%</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:right;font-weight:bold;\">" + stageWinPercent(Stage.River) + "%</p>"
                + "<p style=\"font-family:arial;color:white;font-size:12px;text-align:right;font-weight:bold;\">" + stageWinPercent(Stage.Showdown) + "%</p>"
                + "</html>");
        lessonTwoValues.setOpaque(false);
        lessonTwoValues.setEditable(false);
        add(lessonTwoValues);
        lessonTwoValues.setBounds(522, 90, 484, 479);
    }

    /**
     * @return, HTML representing a players best hand.
     */
    private String formatBestHand() {

        String strongestHand = userDetails.getStatistics().getStrongestHand();
        ArrayList<Card> bestHand = Utilities.parseHand(strongestHand);

        if (strongestHand == null) {
            return "-&nbsp&nbsp";
        } else {

            String[] suits = new String[5];
            String[] cards = new String[5];

            cards[0] = String.valueOf(bestHand.get(0).getValue());
            cards[1] = String.valueOf(bestHand.get(1).getValue());
            cards[2] = String.valueOf(bestHand.get(2).getValue());
            cards[3] = String.valueOf(bestHand.get(3).getValue());
            cards[4] = String.valueOf(bestHand.get(4).getValue());

            suits[0] = bestHand.get(0).getSuit().toString();
            suits[1] = bestHand.get(1).getSuit().toString();
            suits[2] = bestHand.get(2).getSuit().toString();
            suits[3] = bestHand.get(3).getSuit().toString();
            suits[4] = bestHand.get(4).getSuit().toString();

            for (int i = 0; i < suits.length; i++) {

                if (cards[i].equals("14")) {
                    cards[i] = "A";
                } else if (cards[i].equals("13")) {
                    cards[i] = "K";
                } else if (cards[i].equals("12")) {
                    cards[i] = "Q";
                } else if (cards[i].equals("11")) {
                    cards[i] = "J";
                }

                if (suits[i].equals("Hearts")) {
                    suits[i] = "<font color=red style='font-size:150%'>♥</font> ";
                } else if (suits[i].equals("Diamonds")) {
                    suits[i] = "<font color=red style='font-size:150%'>♦</font> ";
                } else if (suits[i].equals("Clubs")) {
                    suits[i] = "<font color=black style='font-size:150%'>♣</font> ";
                } else if (suits[i].equals("Spades")) {
                    suits[i] = "<font color=black style='font-size:150%'>♠</font> ";
                }
            }

            return cards[0] + suits[0] + cards[1] + suits[1] + cards[2] + suits[2]
                    + cards[3] + suits[3] + cards[4] + suits[4];
        }
    }

    /**
     * @return, HTML representing earnings.
     */
    private String formatEarnings() {

        int earnings = userDetails.getStatistics().getTournamentWinnings() - userDetails.getStatistics().getTournamentCosts();
        if (earnings >= 0) {
            return "$" + earnings;
        } else {
            return "<font color=red >$" + earnings + "</font>";
        }
    }

    /**
     * Code for representing double in 2 decimal places was found on:
     * http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
     * @return, HTML representing ROI.
     */
    private String formatROI() {

        int amountSpent = userDetails.getStatistics().getTournamentCosts();
        int amountReceived = userDetails.getStatistics().getTournamentWinnings();

        if (amountSpent != 0) {
            DecimalFormat formattedDouble = new DecimalFormat("#.##");
            double returnOnInvestment = Double.valueOf(formattedDouble.format(((amountReceived - (amountSpent + 0.0)) / amountSpent) * 100));
            return "" + returnOnInvestment;
        } else {
            return "" + 0.0;
        }
    }

    /**
     * Code for representing double in 2 decimal places was found on:
     * http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
     * @return, HTML representing percent of flops seen.
     */
    private String formatFlopsSeen() {

        int handsDealt = userDetails.getStatistics().getHandsDealt();
        int flopsSeen = userDetails.getStatistics().getFlopsSeen();

        if (handsDealt != 0) {
            DecimalFormat formattedDouble = new DecimalFormat("#.##");
            double flopsSeenPercent = Double.valueOf(formattedDouble.format(((flopsSeen + 0.0) / handsDealt) * 100));
            return "" + flopsSeenPercent;
        } else {
            return "" + 0.0;
        }
    }

    /**
     * Code for representing double in 2 decimal places was found on:
     * http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
     * @return, HTML representing win percentages.
     */
    private String stageWinPercent(Stage s) {

        int totalWon = userDetails.getStatistics().getHandsWon();

        //Don't want to divide by 0!
        if (totalWon != 0) {

            if (s.equals(Stage.Preflop)) {

                int preflopsWon = userDetails.getStatistics().getPreflopsWon();
                DecimalFormat formattedDouble = new DecimalFormat("#.##");
                double preflopsWonPercent = Double.valueOf(formattedDouble.format(((preflopsWon + 0.0) / totalWon) * 100));
                return "" + preflopsWonPercent;

            } else if (s.equals(Stage.Flop)) {

                int flopsWon = userDetails.getStatistics().getFlopsWon();
                DecimalFormat formattedDouble = new DecimalFormat("#.##");
                double flopsWonPercent = Double.valueOf(formattedDouble.format(((flopsWon + 0.0) / totalWon) * 100));
                return "" + flopsWonPercent;

            } else if (s.equals(Stage.Turn)) {

                int turnsWon = userDetails.getStatistics().getTurnsWon();
                DecimalFormat formattedDouble = new DecimalFormat("#.##");
                double turnsWonPercent = Double.valueOf(formattedDouble.format(((turnsWon + 0.0) / totalWon) * 100));
                return "" + turnsWonPercent;

            } else if (s.equals(Stage.River)) {

                int riversWon = userDetails.getStatistics().getRiversWon();
                DecimalFormat formattedDouble = new DecimalFormat("#.##");
                double riversWonPercent = Double.valueOf(formattedDouble.format(((riversWon + 0.0) / totalWon) * 100));
                return "" + riversWonPercent;

            } else if (s.equals(Stage.Showdown)) {

                int showdownsWon = userDetails.getStatistics().getShowdownsWon();
                DecimalFormat formattedDouble = new DecimalFormat("#.##");
                double showdownsWonPercent = Double.valueOf(formattedDouble.format(((showdownsWon + 0.0) / totalWon) * 100));
                return "" + showdownsWonPercent;
            }
            return "0.0";
        } else {
            return "0.0";
        }
    }

    /**
     * Code for representing double in 2 decimal places was found on:
     * http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
     * @return, HTML representing win percent.
     */
    private String formatWinPercent() {

        int totalWon = userDetails.getStatistics().getHandsWon();
        int totalDealt = userDetails.getStatistics().getHandsDealt();

        if (totalDealt != 0) {
            DecimalFormat formattedDouble = new DecimalFormat("#.##");
            double showdownsWonPercent = Double.valueOf(formattedDouble.format(((totalWon + 0.0) / totalDealt) * 100));
            return "" + showdownsWonPercent;
        } else {
            return "0.0";
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        try {

            //Draw background and titles.
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/main.png"));
            g.drawImage(img, 0, 0, this);

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(122, 122, 122, 80));

            //Drawing of the Statistic Squares
            RoundRectangle2D rect = new RoundRectangle2D.Double(7, 105, 500, 490, 20, 20);
            g2.fill(rect);

            rect = new RoundRectangle2D.Double(514, 105, 500, 490, 20, 20);
            g2.fill(rect);

            g2.setFont(new Font("Arial", Font.BOLD, 22));

            FontMetrics f = g.getFontMetrics();
            g2.setColor(Color.WHITE);

            g2.setFont(new Font("Arial", Font.BOLD, 30));

            f = g.getFontMetrics();
            String homeLabel = "My Statistics";
            g2.setColor(Color.WHITE);
            g2.drawString(homeLabel, ((512 - (f.stringWidth(homeLabel) / 2))), 90);

        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Back")) {
            masterFrame.remove(this);
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        }
    }
}
