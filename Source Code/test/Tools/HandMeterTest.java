/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Tools.GameCalculations.HandComparer;
import Primitives.Suit;
import Primitives.Card;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class HandMeterTest {

    public HandMeterTest() {
    }

    @Test
    public void testStraightFlush() {


        //Straight Flush Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(10, Suit.Spades));
        board.add(new Card(11, Suit.Spades));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(13, Suit.Spades));
        board.add(new Card(14, Suit.Spades));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><font color=#00ff00>Straight Flush</font><br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);



    }

    @Test
    public void testFourOfAKind() {


        //Four of a Kind Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(13, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "<font color=#40ff00>Four of a Kind</font><br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);


    }

    @Test
    public void testFullHouse() {


        //Full House Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(02, Suit.Clubs));
        board.add(new Card(13, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "<font color=#80ff00>Full House</font><br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);


    }

    @Test
    public void testFlush() {


        //Flush Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(7, Suit.Diamonds));
        board.add(new Card(6, Suit.Diamonds));
        board.add(new Card(9, Suit.Diamonds));
        players[0] = new Card(4, Suit.Diamonds);
        players[1] = new Card(11, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "<font color=#bfff00>Flush</font><br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);


    }

    @Test
    public void testStraight() {


        //Straight Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(13, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(9, Suit.Clubs);
        players[1] = new Card(8, Suit.Hearts);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "<font color=#ffff00>Straight</font><br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);


    }

    @Test
    public void testThreeOfAKind() {


        //Three of a Kind Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(14, Suit.Spades));
        players[0] = new Card(9, Suit.Clubs);
        players[1] = new Card(8, Suit.Hearts);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "<font color=#ffbf00>Three of a Kind</font><br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);

    }

    @Test
    public void testTwoPair() {


        //Two Pair Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Spades));
        players[0] = new Card(11, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "<font color=#ff8000>Two Pair</font><br>"
                + "Pair<br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);

    }

    @Test
    public void testPair() {

        //Pair Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(4, Suit.Clubs));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Spades));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "<font color=#ff4000>Pair</font><br>"
                + "High Card</p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);

    }

    @Test
    public void testHighCard() {


        //High Card Test
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Spades));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Hearts));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(8, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(6, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);

        String expectedResult = "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\">Straight Flush<br>"
                + "Four of a Kind<br>"
                + "Full House<br>"
                + "Flush<br>"
                + "Straight<br>"
                + "Three of a Kind<br>"
                + "Two Pair<br>"
                + "Pair<br>"
                + "<font color=#ff0000>High Card</font></p></html>";

        assertEquals(Utilities.getHTML(h.compare().getHandCategory()), expectedResult);

    }
}
