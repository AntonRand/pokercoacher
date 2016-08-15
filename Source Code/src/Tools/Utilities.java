/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Abstract.Hand;
import Data.User;
import Players.Player;
import Primitives.*;
import Tools.GameCalculations.*;
import java.awt.Color;
import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JLabel;
import sun.misc.BASE64Encoder;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import org.ho.yaml.Yaml;

/**
 * Utilities Class.
 * @author Anton
 */
public class Utilities {

    /**
     * Create a label.
     * @param text, the labels text.
     * @param size, the size of the label.
     * @return, the JLabel.
     */
    public static JLabel plainLabel(String text, int size) {

        JLabel j = new JLabel(text);
        j.setHorizontalAlignment(SwingConstants.RIGHT);
        j.setForeground(Color.WHITE);
        j.setFont(new Font("Arial", Font.PLAIN, size));
        return j;
    }

    /**
     * Create a bold label.
     * @param text, the labels text.
     * @param size, the size of the label.
     * @return, the JLabel.
     */
    public static JLabel boldLabel(String text, int size) {

        JLabel j = new JLabel(text, 0);
        j.setForeground(Color.WHITE);
        j.setFont(new Font("Arial", Font.BOLD, size));
        return j;
    }

    /**
     * Checks whether a word is between a specified limit.
     * @param theText, the word.
     * @param minimum, smallest size.
     * @param maximum, biggest size.
     * @return, boolean if meets criteria.
     */
    public static boolean between(String theText, int minimum, int maximum) {

        if (theText == null || theText.length() > maximum || theText.length() < minimum) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Used to encrypt passwords and answers.
     * This method is not mine and was taken from:
     * http://www.devbistro.com/articles/Java/Password-Encryption
     *
     * Modified to salt strings.
     * @param plaintext, the text to encrypt.
     * @return, the encrypted text.
     */
    public static synchronized String encrypt(String plaintext) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA"); //step 2
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error - Couldn't Find Algorithm");
        }
        try {
            String saltedString = "adioeiodj239042" + plaintext + "doiaaioe93i4q3jids";
            md.update(saltedString.getBytes("UTF-8")); //step 3
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error - Unsupported Encoding");

        }
        byte raw[] = md.digest(); //step 4
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash; //step 6
    }

    /**
     * @param chips, the amount to be split.
     * @return, array of integers showing how many chips for each value.
     */
    public static int[] splitChips(int chips) {

        int tenThousands = 0;
        int fiveThousands = 0;
        int twoThousandFiveHundreds = 0;
        int oneThousands = 0;
        int fiveHundreds = 0;
        int twoHundredFifties = 0;
        int oneHundreds = 0;
        int fifties = 0;
        int twentyFives = 0;
        int fives = 0;
        int ones = 0;

        int value = chips;


        while (value >= 10000) {
            tenThousands++;
            value -= 10000;
        }
        while (value >= 5000) {
            fiveThousands++;
            value -= 5000;
        }
        while (value >= 2500) {
            twoThousandFiveHundreds++;
            value -= 2500;
        }
        while (value >= 1000) {
            oneThousands++;
            value -= 1000;
        }
        while (value >= 500) {
            fiveHundreds++;
            value -= 500;
        }
        while (value >= 250) {
            twoHundredFifties++;
            value -= 250;
        }
        while (value >= 100) {
            oneHundreds++;
            value -= 100;
        }
        while (value >= 50) {
            fifties++;
            value -= 50;
        }
        while (value >= 25) {
            twentyFives++;
            value -= 25;
        }
        while (value >= 5) {
            fives++;
            value -= 5;
        }
        while (value >= 1) {
            ones++;
            value -= 1;
        }

        int[] array = new int[11];

        array[0] = ones;
        array[1] = fives;
        array[2] = twentyFives;
        array[3] = fifties;
        array[4] = oneHundreds;
        array[5] = twoHundredFifties;
        array[6] = fiveHundreds;
        array[7] = oneThousands;
        array[8] = twoThousandFiveHundreds;
        array[9] = fiveThousands;
        array[10] = tenThousands;

        return array;
    }

    /**
     * @param remainingPlayerSize, the amount of players in the hand.
     * @return, array of integers representing players positions.
     */
    public static int[] getPositions(int remainingPlayerSize) {

        int[] playerPositions = new int[remainingPlayerSize];

        switch (remainingPlayerSize) {
            case 2:
                playerPositions[0] = 1;
                playerPositions[1] = 2;
                break;
            case 3:
                playerPositions[0] = 0;
                playerPositions[1] = 1;
                playerPositions[2] = 2;
                break;
            case 4:
                playerPositions[0] = 0;
                playerPositions[1] = 1;
                playerPositions[2] = 1;
                playerPositions[3] = 2;
                break;
            case 5:
                playerPositions[0] = 0;
                playerPositions[1] = 0;
                playerPositions[2] = 1;
                playerPositions[3] = 1;
                playerPositions[4] = 2;
                break;
            case 6:
                playerPositions[0] = 0;
                playerPositions[1] = 0;
                playerPositions[2] = 1;
                playerPositions[3] = 1;
                playerPositions[4] = 2;
                playerPositions[5] = 2;
                break;
            case 7:
                playerPositions[0] = 0;
                playerPositions[1] = 0;
                playerPositions[2] = 1;
                playerPositions[3] = 1;
                playerPositions[4] = 1;
                playerPositions[5] = 2;
                playerPositions[6] = 2;
                break;
            case 8:
                playerPositions[0] = 0;
                playerPositions[1] = 0;
                playerPositions[2] = 0;
                playerPositions[3] = 1;
                playerPositions[4] = 1;
                playerPositions[5] = 1;
                playerPositions[6] = 2;
                playerPositions[7] = 2;
                break;
        }
        return playerPositions;
    }

    /**
     * Returns a list of acceptable cards. Based on:
     * http://www.freepokermoney.com/pages/hand-charts
     * @return, list of acceptable hole cards.
     */
    public static ArrayList<int[]> getAnyCards() {

        ArrayList<int[]> cardList = new ArrayList<int[]>();
        int[] cardsOne = {14, 14};
        int[] cardsTwo = {14, 13};
        int[] cardsThree = {13, 12};
        int[] cardsFour = {12, 11};
        int[] cardsFive = {11, 10};
        int[] cardsSix = {10, 9};
        int[] cardsSeven = {13, 13};
        int[] cardsEight = {14, 12};
        int[] cardsNine = {13, 11};
        int[] cardsTen = {12, 10};
        int[] cardsEleven = {11, 9};
        int[] cardsTwelve = {12, 12};
        int[] cardsThirteen = {14, 11};
        int[] cardsFourteen = {13, 10};
        int[] cardsFifteen = {11, 11};
        int[] cardsSixteen = {14, 10};
        int[] cardsSeventeen = {10, 10};
        int[] cardsEighteen = {9, 9};
        int[] cardsNineteen = {8, 8};
        int[] cardsTwenty = {7, 7};

        cardList.add(cardsOne);
        cardList.add(cardsTwo);
        cardList.add(cardsThree);
        cardList.add(cardsFour);
        cardList.add(cardsFive);
        cardList.add(cardsSix);
        cardList.add(cardsSeven);
        cardList.add(cardsEight);
        cardList.add(cardsNine);
        cardList.add(cardsTen);
        cardList.add(cardsEleven);
        cardList.add(cardsTwelve);
        cardList.add(cardsThirteen);
        cardList.add(cardsFourteen);
        cardList.add(cardsFifteen);
        cardList.add(cardsSixteen);
        cardList.add(cardsSeventeen);
        cardList.add(cardsEighteen);
        cardList.add(cardsNineteen);
        cardList.add(cardsTwenty);

        return cardList;
    }

    /**
     * Returns a list of acceptable middle position cards. Based on:
     * http://www.freepokermoney.com/pages/hand-charts
     * @return, list of acceptable hole cards.
     */
    public static ArrayList<int[]> getMiddleCards() {

        ArrayList<int[]> cardList = new ArrayList<int[]>();
        int[] cardsOne = {9, 8};
        int[] cardsTwo = {10, 8};
        int[] cardsThree = {11, 8};
        int[] cardsFour = {12, 9};
        int[] cardsFive = {12, 8};
        int[] cardsSix = {13, 9};
        int[] cardsSeven = {14, 9};
        int[] cardsEight = {14, 8};
        int[] cardsNine = {14, 7};
        int[] cardsTen = {14, 6};
        int[] cardsEleven = {6, 6};
        int[] cardsTwelve = {5, 5};

        cardList.add(cardsOne);
        cardList.add(cardsTwo);
        cardList.add(cardsThree);
        cardList.add(cardsFour);
        cardList.add(cardsFive);
        cardList.add(cardsSix);
        cardList.add(cardsSeven);
        cardList.add(cardsEight);
        cardList.add(cardsNine);
        cardList.add(cardsTen);
        cardList.add(cardsEleven);
        cardList.add(cardsTwelve);

        return cardList;
    }

    /**
     * Returns a list of acceptable late position cards. Based on:
     * http://www.freepokermoney.com/pages/hand-charts
     * @return, list of acceptable hole cards.
     */
    public static ArrayList<int[]> getLateCards() {

        ArrayList<int[]> cardList = new ArrayList<int[]>();
        int[] cardsOne = {5, 4};
        int[] cardsTwo = {6, 5};
        int[] cardsThree = {7, 6};
        int[] cardsFour = {7, 5};
        int[] cardsFive = {8, 7};
        int[] cardsSix = {8, 6};
        int[] cardsSeven = {9, 7};
        int[] cardsEight = {9, 6};
        int[] cardsNine = {10, 7};
        int[] cardsTen = {11, 7};
        int[] cardsEleven = {13, 8};
        int[] cardsTwelve = {13, 7};
        int[] cardsThirteen = {13, 6};
        int[] cardsFourteen = {13, 5};
        int[] cardsFifteen = {13, 4};
        int[] cardsSixteen = {13, 3};
        int[] cardsSeventeen = {13, 2};
        int[] cardsEighteen = {14, 5};
        int[] cardsNineteen = {14, 4};
        int[] cardsTwenty = {14, 3};
        int[] cardsTwentyOne = {14, 2};
        int[] cardsTwentyTwo = {4, 4};
        int[] cardsTwentyThree = {3, 3};
        int[] cardsTwentyFour = {2, 2};

        cardList.add(cardsOne);
        cardList.add(cardsTwo);
        cardList.add(cardsThree);
        cardList.add(cardsFour);
        cardList.add(cardsFive);
        cardList.add(cardsSix);
        cardList.add(cardsSeven);
        cardList.add(cardsEight);
        cardList.add(cardsNine);
        cardList.add(cardsTen);
        cardList.add(cardsEleven);
        cardList.add(cardsTwelve);
        cardList.add(cardsThirteen);
        cardList.add(cardsFourteen);
        cardList.add(cardsFifteen);
        cardList.add(cardsSixteen);
        cardList.add(cardsSeventeen);
        cardList.add(cardsEighteen);
        cardList.add(cardsNineteen);
        cardList.add(cardsTwenty);
        cardList.add(cardsTwentyOne);
        cardList.add(cardsTwentyTwo);
        cardList.add(cardsTwentyThree);
        cardList.add(cardsTwentyFour);

        return cardList;
    }

    /**
     * @param index, of the player to point to.
     * @param colorOne, arrow colour one.
     * @param colorTwo, arrow colour two.
     * @return, arrow pointing to that players button/blind.
     */
    public static Arrow getArrow(int index, Color colorOne, Color colorTwo) {

        switch (index) {
            case 0:
                int[] thePoints = {376, 390};
                return new Arrow(colorOne, colorTwo, thePoints, false);
            case 1:
                int[] thePointsOne = {186, 370};
                return new Arrow(colorOne, colorTwo, thePointsOne, false);
            case 2:
                int[] thePointsTwo = {132, 270};
                return new Arrow(colorOne, colorTwo, thePointsTwo, false);
            case 3:
                int[] thePointsThree = {156, 255};
                return new Arrow(colorOne, colorTwo, thePointsThree, true);
            case 4:
                int[] thePointsFour = {326, 165};
                return new Arrow(colorOne, colorTwo, thePointsFour, false);
            case 5:
                int[] thePointsFive = {526, 185};
                return new Arrow(colorOne, colorTwo, thePointsFive, false);
            case 6:
                int[] thePointsSix = {590, 315};
                return new Arrow(colorOne, colorTwo, thePointsSix, false);
            case 7:
                int[] thePointsSeven = {530, 385};
                return new Arrow(colorOne, colorTwo, thePointsSeven, true);
        }
        return null;
    }

    /**
     * @param index, of the player to point to.
     * @param colorOne, arrow colour one.
     * @param colorTwo, arrow colour two.
     * @return, arrow pointing to that players hole cards.
     */
    public static Arrow getCardArrow(int index, Color colorOne, Color colorTwo) {

        switch (index) {



            case 0:
                int[] thePoints = {403, 414};
                return new Arrow(colorOne, colorTwo, thePoints, false);
            case 1:
                int[] thePointsOne = {440, 414};
                return new Arrow(colorOne, colorTwo, thePointsOne, false);
            case 2:
                int[] thePointsTwo = {132, 265};
                return new Arrow(colorOne, colorTwo, thePointsTwo, false);
            case 3:
                int[] thePointsThree = {156, 255};
                return new Arrow(colorOne, colorTwo, thePointsThree, true);
            case 4:
                int[] thePointsFour = {326, 165};
                return new Arrow(colorOne, colorTwo, thePointsFour, false);
            case 5:
                int[] thePointsFive = {526, 185};
                return new Arrow(colorOne, colorTwo, thePointsFive, false);
            case 6:
                int[] thePointsSix = {590, 315};
                return new Arrow(colorOne, colorTwo, thePointsSix, false);
            case 7:
                int[] thePointsSeven = {530, 385};
                return new Arrow(colorOne, colorTwo, thePointsSeven, true);
        }
        return null;
    }

    /**
     * Returns HTML for players hand strength.
     * @param handCategory, the category of hand Straight, Flush e.t.c.
     * @return, HTML for strength meter.
     */
    public static String getHTML(int handCategory) {

        String html;

        switch (handCategory) {

            case 1:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "<font color=#ff0000>High Card</font></p></html>";
                return html;
            case 2:
                html = html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "<font color=#ff4000>Pair</font><br>"
                        + "High Card</p></html>";
                return html;
            case 3:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "<font color=#ff8000>Two Pair</font><br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 4:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "<font color=#ffbf00>Three of a Kind</font><br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 5:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "<font color=#ffff00>Straight</font><br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 6:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "<font color=#bfff00>Flush</font><br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 7:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "Four of a Kind<br>"
                        + "<font color=#80ff00>Full House</font><br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 8:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                        + "<font color=#40ff00>Four of a Kind</font><br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            case 9:
                html = "<html>"
                        + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><font color=#00ff00>Straight Flush</font><br>"
                        + "Four of a Kind<br>"
                        + "Full House<br>"
                        + "Flush<br>"
                        + "Straight<br>"
                        + "Three of a Kind<br>"
                        + "Two Pair<br>"
                        + "Pair<br>"
                        + "High Card</p></html>";
                return html;
            default:
                return "";
        }
    }

    /**
     * @param s, Players suit.
     * @return, suits symbol
     */
    public static String getSuit(Suit s) {
        if (s == Suit.Hearts) {
            return "♥";
        } else if (s == Suit.Diamonds) {
            return "♦";
        } else if (s == Suit.Clubs) {
            return "♣";
        } else if (s == Suit.Spades) {
            return "♠";
        }
        return "";
    }

    /**
     * Loads a user through JYAML
     * @param username, the username to return.
     * @return, username of null if not found.
     */
    public static User loadUser(String username) {

        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        for (User user : userList) {

            //If the username is found on the database.
            if (username.matches(user.getUsername())) {
                return user;
            }
        }

        return null;
    }


    /**
     * Updates Strength Meter.
     * @param theHand, the current hand.
     * @param thePane, the pane to update.
     */
    public static void updateStrength(Hand theHand, JEditorPane thePane) {

        String category = "";

        if (theHand != null) {

            Player guiPlayer = theHand.getPlayers().get(0);

            if (guiPlayer.guiPlayer() == true) {

                if (guiPlayer.inHand() == true && theHand.getCommunityCards() == null) {
                    if (guiPlayer.getCards()[0].getValue() == guiPlayer.getCards()[1].getValue()) {
                        category = Utilities.getHTML(2);
                    }
                } else if (guiPlayer.inHand() == true && theHand.getCommunityCards() != null) {
                    HandComparer currentHand = new HandComparer(guiPlayer.getCards(), theHand.getCommunityCards());
                    category = Utilities.getHTML(currentHand.compare().getHandCategory());
                }
            }
        }
        thePane.setText(category);
    }

    /**
     * Determines which hand is the strongest
     */
    public static HandResult getBestHand(HandResult firstHand, HandResult secondHand) {


        if (firstHand.getHandCategory() > secondHand.getHandCategory()) {
            return firstHand;
        } else if (secondHand.getHandCategory() > firstHand.getHandCategory()) {
            return secondHand;
        } else {
            //Find out what type of hand we are comparing.
            int category = firstHand.getHandCategory();

            if (category == 9 || category == 5) {
                //Straight or Straight Flush.
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else {
                    //Indicates same strength.
                    return null;
                }

            } else if (category == 6) {
                //Flush.
                //Check First Cards
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else {
                    //Check Second Cards
                    if (firstHand.getSecondValue() > secondHand.getSecondValue()) {
                        return firstHand;
                    } else if (secondHand.getSecondValue() > firstHand.getSecondValue()) {
                        return secondHand;
                    } else {
                        //Check Third Cards
                        if (firstHand.getThirdValue() > secondHand.getThirdValue()) {
                            return firstHand;
                        } else if (secondHand.getThirdValue() > firstHand.getThirdValue()) {
                            return secondHand;
                        } else {
                            //Check Fourth Cards
                            if (firstHand.getFourthValue() > secondHand.getFourthValue()) {
                                return firstHand;
                            } else if (secondHand.getFourthValue() > firstHand.getFourthValue()) {
                                return secondHand;
                            } else {
                                //Check Fifth Cards
                                if (firstHand.getFifthValue() > secondHand.getFifthValue()) {
                                    return firstHand;
                                } else if (secondHand.getFifthValue() > firstHand.getFifthValue()) {
                                    return secondHand;
                                } else {
                                    //Indicates same strength.
                                    return null;
                                }
                            }
                        }
                    }
                }
            } else if (category == 8 || category == 7) {
                //Full House or Four of a Kind
                //Check if there is a difference in the first cards, if there isn't
                //check for a difference in Kicker/Pair.
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else if (firstHand.getFifthValue() > secondHand.getFifthValue()) {
                    return firstHand;
                } else if (secondHand.getFifthValue() > firstHand.getFifthValue()) {
                    return secondHand;
                } else {
                    //Indicates same strength.
                    return null;
                }
            } else if (category == 4 || category == 3) {
                //Three of a Kind and Two Pair
                //Three of a Kind - Check for difference in three of a kind.
                //Two Pair - Check for difference in first pair.
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else {
                    //Three of a Kind - Check for difference in first kicker.
                    //Two Pair - Check for difference in second pair.
                    if (firstHand.getFourthValue() > secondHand.getFourthValue()) {
                        return firstHand;
                    } else if (secondHand.getFourthValue() > firstHand.getFourthValue()) {
                        return secondHand;
                    } else {
                        //Check for difference with last kicker.
                        if (firstHand.getFifthValue() > secondHand.getFifthValue()) {
                            return firstHand;
                        } else if (secondHand.getFifthValue() > firstHand.getFifthValue()) {
                            return secondHand;
                        } else {
                            //Indicates same strength.
                            return null;
                        }
                    }
                }
            } else if (category == 2) {
                //Pair
                //Check for difference in pair.
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else {
                    //Check for difference with first kicker
                    if (firstHand.getThirdValue() > secondHand.getThirdValue()) {
                        return firstHand;
                    } else if (secondHand.getThirdValue() > firstHand.getThirdValue()) {
                        return secondHand;
                    } else {
                        //Check for difference with second kicker
                        if (firstHand.getFourthValue() > secondHand.getFourthValue()) {
                            return firstHand;
                        } else if (secondHand.getFourthValue() > firstHand.getFourthValue()) {
                            return secondHand;
                        } else {
                            //Check for difference with last kicker
                            if (firstHand.getFifthValue() > secondHand.getFifthValue()) {
                                return firstHand;
                            } else if (secondHand.getFifthValue() > firstHand.getFifthValue()) {
                                return secondHand;
                            } else {
                                //Indicates same strength.
                                return null;
                            }
                        }
                    }
                }
            } else if (category == 1) {
                //High Card
                //Check for difference with first kicker.
                if (firstHand.getFirstValue() > secondHand.getFirstValue()) {
                    return firstHand;
                } else if (secondHand.getFirstValue() > firstHand.getFirstValue()) {
                    return secondHand;
                } else {
                    //Check for difference with second kicker.
                    if (firstHand.getSecondValue() > secondHand.getSecondValue()) {
                        return firstHand;
                    } else if (secondHand.getSecondValue() > firstHand.getSecondValue()) {
                        return secondHand;
                    } else {
                        //Check for difference with third kicker.
                        if (firstHand.getThirdValue() > secondHand.getThirdValue()) {
                            return firstHand;
                        } else if (secondHand.getThirdValue() > firstHand.getThirdValue()) {
                            return secondHand;
                        } else {
                            //Check for difference with fourth kicker.
                            if (firstHand.getFourthValue() > secondHand.getFourthValue()) {
                                return firstHand;
                            } else if (secondHand.getFourthValue() > firstHand.getFourthValue()) {
                                return secondHand;
                            } else {
                                //Check for difference with last kicker
                                if (firstHand.getFifthValue() > secondHand.getFifthValue()) {
                                    return firstHand;
                                } else if (secondHand.getFifthValue() > firstHand.getFifthValue()) {
                                    return secondHand;
                                } else {
                                    //Indicates same strength.
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
        }
        //If difference could not be detected.
        return null;
    }

    /**
     * Converts String into ArrayList of Cards.
     * @param hand, the hand to parse.
     * @return, the converted cards.
     */
    public static ArrayList<Card> parseHand(String hand) {

        if (hand == null) {
            return null;
        }

        String[] theHand = hand.split(",");
        ArrayList<Card> parsedCards = new ArrayList<Card>();

        for (int i = 0; i < theHand.length; i++) {
            String[] theCard = theHand[i].split(" ");

            if (theCard[1].equals("H")) {
                parsedCards.add(new Card(Integer.parseInt(theCard[0]), Suit.Hearts));
            } else if (theCard[1].equals("D")) {
                parsedCards.add(new Card(Integer.parseInt(theCard[0]), Suit.Diamonds));
            } else if (theCard[1].equals("C")) {
                parsedCards.add(new Card(Integer.parseInt(theCard[0]), Suit.Clubs));
            } else if (theCard[1].equals("S")) {
                parsedCards.add(new Card(Integer.parseInt(theCard[0]), Suit.Spades));
            }
        }
        return parsedCards;
    }

    public static void main(String[] args) {
        /*
        ArrayList<Card> listOne = new ArrayList<Card>();
        ArrayList<Card> listTwo = new ArrayList<Card>();

        listOne.add(new Card(14, Suit.Hearts));
        listOne.add(new Card(13, Suit.Hearts));
        listOne.add(new Card(12, Suit.Hearts));
        listOne.add(new Card(5, Suit.Hearts));
        listOne.add(new Card(3, Suit.Hearts));

        listTwo.add(new Card(14, Suit.Hearts));
        listTwo.add(new Card(13, Suit.Hearts));
        listTwo.add(new Card(12, Suit.Hearts));
        listTwo.add(new Card(5, Suit.Hearts));
        listTwo.add(new Card(2, Suit.Hearts));


        HandResult one = new HandComparer(listOne).compare();
        HandResult two = new HandComparer(listTwo).compare();

        HandResult winner = getBestHand(one, two);

        if (winner.equals(one)) {
        System.out.println("One");
        } else {
        System.out.println("Two");
        }

        parseHand(one.getStringRepresentation());
         */
    }
}
