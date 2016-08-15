/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.GameCalculations;

import java.util.ArrayList;
import Primitives.Card;
import Primitives.Suit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Checks extreme, edge and standard cases for each category.
 * 
 * 
 * @author Anton
 */
public class HandComparerTest {
    
    public HandComparerTest() {
    }

    @Test
    public void testStraightFlush() {

        //Edge Cases
        //Royal Flush - Highest
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
        assertEquals(h.compare().getHandCategory(), 9);


        //Lowest Straight Flush
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(4, Suit.Spades));
        board.add(new Card(5, Suit.Spades));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);

        //Lowest Straight Flush with 3 Ace's - Check it only takes one
        //ace into consideration
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(4, Suit.Spades));
        board.add(new Card(5, Suit.Spades));
        players[0] = new Card(14, Suit.Clubs);
        players[1] = new Card(02, Suit.Spades);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);


        //Straight Flush with 3 7's - Check it only takes one
        //ace into consideration
        board.clear();
        board.add(new Card(5, Suit.Spades));
        board.add(new Card(6, Suit.Spades));
        board.add(new Card(7, Suit.Diamonds));
        board.add(new Card(8, Suit.Spades));
        board.add(new Card(9, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(7, Suit.Spades);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);
        
        
                //Straight Flush with 3 7's - Check it only takes one
        //ace into consideration
        board.clear();
        board.add(new Card(5, Suit.Hearts));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(8, Suit.Hearts));
        board.add(new Card(9, Suit.Hearts));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(7, Suit.Spades);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);

        //7 Card Flush, Check Highest Five are picked. (Highest Card should be 9,
        //lowest card should be 5.
        board.clear();
        board.add(new Card(3, Suit.Diamonds));
        board.add(new Card(4, Suit.Diamonds));
        board.add(new Card(5, Suit.Diamonds));
        board.add(new Card(6, Suit.Diamonds));
        board.add(new Card(7, Suit.Diamonds));
        players[0] = new Card(8, Suit.Diamonds);
        players[1] = new Card(9, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);
        assertEquals(h.compare().getBestFive().get(0).getValue(), 9);
        assertEquals(h.compare().getBestFive().get(4).getValue(), 5);

        //Typical Cases
        board.clear();
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(3, Suit.Hearts));
        board.add(new Card(9, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(5, Suit.Hearts);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);

        board.clear();
        board.add(new Card(8, Suit.Diamonds));
        board.add(new Card(6, Suit.Diamonds));
        board.add(new Card(1, Suit.Spades));
        board.add(new Card(7, Suit.Diamonds));
        board.add(new Card(5, Suit.Diamonds));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(4, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 9);
        
        
        //Check for False Positives
        board.clear();
        board.add(new Card(1, Suit.Clubs));
        board.add(new Card(7, Suit.Spades));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(5, Suit.Spades));
        board.add(new Card(1, Suit.Hearts));
        players[0] = new Card(6, Suit.Spades);
        players[1] = new Card(2, Suit.Spades);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 9);

        board.clear();
        board.add(new Card(5, Suit.Spades));
        board.add(new Card(6, Suit.Spades));
        board.add(new Card(7, Suit.Diamonds));
        board.add(new Card(8, Suit.Spades));
        board.add(new Card(9, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(7, Suit.Hearts);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 9);


    }

    @Test
    public void testQuads() {
        //Edge Cases
        //4 Ace's and 3 K's.
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
        assertEquals(h.compare().getHandCategory(), 8);

        //Low Four of a Kind 2's
        board.clear();
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(3, Suit.Hearts));
        players[0] = new Card(2, Suit.Clubs);
        players[1] = new Card(5, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 8);


        //Two Three of a Kinds should be false
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Spades));
        board.add(new Card(13, Suit.Hearts));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(12, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 8);

        //Four of a kind K's
        board.clear();
        board.add(new Card(11, Suit.Spades));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(13, Suit.Spades));
        board.add(new Card(13, Suit.Hearts));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 8);
        //Four Cards Should be Kings
        assertTrue(h.compare().getBestFive().get(0).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 13);
        //HighCard Should be Ace
        assertTrue(h.compare().getBestFive().get(4).getValue() == 14);


        //Typical Cases
        //Four of a kind 4's
        board.clear();
        board.add(new Card(11, Suit.Spades));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(9, Suit.Clubs));
        board.add(new Card(4, Suit.Clubs));
        board.add(new Card(4, Suit.Diamonds));
        players[0] = new Card(5, Suit.Clubs);
        players[1] = new Card(4, Suit.Spades);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 8);
        //Four Cards Should be 4's
        assertTrue(h.compare().getBestFive().get(0).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 4);
        //HighCard Should be Jack
        assertTrue(h.compare().getBestFive().get(4).getValue() == 11);

        //Four of a kind 2's
        board.clear();
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(7, Suit.Spades));
        board.add(new Card(4, Suit.Spades));
        board.add(new Card(2, Suit.Clubs));
        board.add(new Card(5, Suit.Spades));
        players[0] = new Card(2, Suit.Hearts);
        players[1] = new Card(2, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 8);
        //Four Cards Should be 2's
        assertTrue(h.compare().getBestFive().get(0).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 2);
        //HighCard Should be 7
        assertTrue(h.compare().getBestFive().get(4).getValue() == 7);


        //Four of a kind Jacks
        board.clear();
        board.add(new Card(11, Suit.Spades));
        board.add(new Card(11, Suit.Hearts));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(6, Suit.Diamonds));
        board.add(new Card(11, Suit.Diamonds));
        players[0] = new Card(2, Suit.Clubs);
        players[1] = new Card(3, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 8);
        //Four Cards Should be Jacks
        assertTrue(h.compare().getBestFive().get(0).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 11);
        //HighCard Should be 6
        assertTrue(h.compare().getBestFive().get(4).getValue() == 6);

    }

    @Test
    public void testFullHouse() {
        //Edge Cases
        //Ace's over Kings
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        //Aces over Kings.
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(02, Suit.Clubs));
        board.add(new Card(13, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);
        assertEquals(h.compare().getHandCategory(), 7);

        //Three Aces
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 14);
        //2 Kinds
        assertTrue(h.compare().getBestFive().get(3).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 13);

        //3's over 2's. Where both have 3
        board.clear();
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(3, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(5, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 7);

        //Check 3's over 2's. Not other way
        assertTrue(h.compare().getBestFive().get(0).getValue() == 3);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 3);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 3);
        //2's
        assertTrue(h.compare().getBestFive().get(3).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 2);

        //Low 2's over 5's. Should ignore 3 pair.
        board.clear();
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(3, Suit.Hearts));
        players[0] = new Card(5, Suit.Clubs);
        players[1] = new Card(5, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 7);

        //Check 2's
        assertTrue(h.compare().getBestFive().get(0).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 2);
        //Check 5's and not 3's.
        assertTrue(h.compare().getBestFive().get(3).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);

        //Check Full house isn't true when stronger hand exists.
        board.clear();
        board.add(new Card(5, Suit.Spades));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(3, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(3, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(5, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 7);


        //Typical Hands
        //Check 6's over 3's
        board.clear();
        board.add(new Card(6, Suit.Spades));
        board.add(new Card(3, Suit.Diamonds));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(6, Suit.Hearts));
        players[0] = new Card(2, Suit.Clubs);
        players[1] = new Card(8, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 7);

        //Check 6's
        assertTrue(h.compare().getBestFive().get(0).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 6);

        //Check 2's
        assertTrue(h.compare().getBestFive().get(3).getValue() == 3);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 3);


        //Queens over Ace's
        board.clear();
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(12, Suit.Diamonds));
        board.add(new Card(10, Suit.Hearts));
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(5, Suit.Hearts));
        players[0] = new Card(14, Suit.Clubs);
        players[1] = new Card(12, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 7);

        //Check Three Queens.
        assertTrue(h.compare().getBestFive().get(0).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 12);
        //2 Ace's
        assertTrue(h.compare().getBestFive().get(3).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 14);


        //Low Four of a Kind 2's
        board.clear();
        board.add(new Card(5, Suit.Spades));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(7, Suit.Hearts));
        players[0] = new Card(2, Suit.Clubs);
        players[1] = new Card(5, Suit.Diamonds);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 7);

        //Check 3's over 2's. Not other way
        assertTrue(h.compare().getBestFive().get(0).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 5);
        //2 Kinds
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);

    }

    @Test
    public void testFlush() {

        //Edge Cases
        //7 of the Same Suit
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
        assertEquals(h.compare().getHandCategory(), 6);

        //Check the best five are the highest five
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 6);

        //6 of the same suit
        board.clear();
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(3, Suit.Hearts));
        board.add(new Card(9, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(10, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);
        
        
         //6 of the same suit
        board.clear();
        board.add(new Card(7, Suit.Clubs));
        board.add(new Card(4, Suit.Clubs));
        board.add(new Card(2, Suit.Clubs));
        board.add(new Card(3, Suit.Clubs));
        board.add(new Card(9, Suit.Clubs));
        players[0] = new Card(3, Suit.Hearts);
        players[1] = new Card(10, Suit.Clubs);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);
        
        
         //6 of the same suit
        board.clear();
        board.add(new Card(7, Suit.Spades));
        board.add(new Card(4, Suit.Spades));
        board.add(new Card(2, Suit.Spades));
        board.add(new Card(3, Suit.Spades));
        board.add(new Card(9, Suit.Spades));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(10, Suit.Spades);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 10);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 3);

        //6 of the same suit, almost a straight
        board.clear();
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(9, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(2, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 4);

        //6 of the same suit, straight flush
        board.clear();
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(3, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(2, Suit.Hearts);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 6);


        //Typical Cases

        //5 of the same suit, almost a straight
        board.clear();
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(5, Suit.Diamonds));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(9, Suit.Hearts));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(2, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 2);


        //Typical Cases
        //5 of the same suit, 
        board.clear();
        board.add(new Card(10, Suit.Hearts));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(8, Suit.Diamonds));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        players[0] = new Card(4, Suit.Clubs);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 10);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 3);


        //5 of the same suit
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(13, Suit.Hearts));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(12, Suit.Hearts));
        board.add(new Card(10, Suit.Hearts));
        players[0] = new Card(14, Suit.Clubs);
        players[1] = new Card(2, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 6);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 10);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 2);


    }

    @Test
    public void testStraight() {


        //Edge Cases
        //Straight flush should not return straight result.
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Diamonds));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(10, Suit.Diamonds));
        players[0] = new Card(9, Suit.Diamonds);
        players[1] = new Card(8, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 5);

        //7 Card Straight
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(13, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(9, Suit.Clubs);
        players[1] = new Card(8, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 5);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 10);


        //5 Card Straight
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(13, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(2, Suit.Clubs);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 5);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 10);

        //Typical Cases

        //Low straight
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(2, Suit.Clubs));
        board.add(new Card(3, Suit.Clubs));
        board.add(new Card(4, Suit.Diamonds));
        board.add(new Card(5, Suit.Spades));
        players[0] = new Card(9, Suit.Clubs);
        players[1] = new Card(8, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 5);

        //Check highest five in correct order (Ace should be low)
        assertTrue(h.compare().getBestFive().get(0).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 3);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 1);



        //Middle Straight
        board.clear();
        board.add(new Card(3, Suit.Clubs));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(4, Suit.Diamonds));
        board.add(new Card(4, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        players[0] = new Card(6, Suit.Clubs);
        players[1] = new Card(7, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 5);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 4);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 3);



        //Middle Value Straight
        board.clear();
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(7, Suit.Clubs));
        board.add(new Card(8, Suit.Diamonds));
        board.add(new Card(5, Suit.Hearts));
        board.add(new Card(6, Suit.Spades));
        players[0] = new Card(14, Suit.Clubs);
        players[1] = new Card(2, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 5);


        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);
    }

    @Test
    public void testTrips() {

        //Edge Cases
        //Full House should not return trips.
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Clubs));
        players[0] = new Card(9, Suit.Spades);
        players[1] = new Card(8, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 4);


        //Highest Trips
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(14, Suit.Spades));
        players[0] = new Card(9, Suit.Clubs);
        players[1] = new Card(8, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 4);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 11);


        //Typical Cases
        //Lowest Trips
        board.clear();
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(2, Suit.Clubs));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(5, Suit.Clubs);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 4);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 10);


        //Mid level trips
        board.clear();
        board.add(new Card(3, Suit.Clubs));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(4, Suit.Diamonds));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        players[0] = new Card(6, Suit.Clubs);
        players[1] = new Card(9, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 4);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 6);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);



        //Mid Level Trips
        board.clear();
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(3, Suit.Clubs));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(7, Suit.Hearts));
        board.add(new Card(8, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(7, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 4);


        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 8);
    }

    @Test
    public void testTwoPair() {

        //Edge Cases
        //Full house should not return two pair.
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Clubs));
        players[0] = new Card(9, Suit.Spades);
        players[1] = new Card(8, Suit.Diamonds);

        HandComparer h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 3);


        //Highest Two Pair
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Spades));
        players[0] = new Card(11, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);
        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 12);


        //Three pairs
        board.clear();
        board.add(new Card(5, Suit.Clubs));
        board.add(new Card(5, Suit.Hearts));
        board.add(new Card(9, Suit.Diamonds));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(10, Suit.Hearts));
        players[0] = new Card(10, Suit.Clubs);
        players[1] = new Card(4, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);
        //Check highest five in correct order (10's and 9's, Ignore pair of 5's)
        assertTrue(h.compare().getBestFive().get(0).getValue() == 10);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 10);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);



        //3 pairs
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(12, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 12);



        //Typical Cases
        //8's and 7's
        board.clear();
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(7, Suit.Clubs));
        board.add(new Card(8, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(8, Suit.Hearts));
        players[0] = new Card(7, Suit.Hearts);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 11);

        //9's and 5's
        board.clear();
        board.add(new Card(5, Suit.Clubs));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(4, Suit.Diamonds));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(5, Suit.Hearts));
        players[0] = new Card(6, Suit.Clubs);
        players[1] = new Card(4, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 5);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 6);



        //Queen's and 2's
        board.clear();
        board.add(new Card(12, Suit.Hearts));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(2, Suit.Diamonds));
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(5, Suit.Spades));
        players[0] = new Card(4, Suit.Clubs);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 3);


        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 2);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 5);
    }

    @Test
    public void testPair() {


        //Edge Cases
        //Full House should not return pair.
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(13, Suit.Clubs));
        players[0] = new Card(9, Suit.Spades);
        players[1] = new Card(8, Suit.Diamonds);
        HandComparer h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 2);


        //Highest Pair
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(4, Suit.Clubs));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Spades));
        players[0] = new Card(3, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 2);
        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 11);



        //Two Pair should not return pair
        board.clear();
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(12, Suit.Clubs));
        board.add(new Card(12, Suit.Diamonds));
        board.add(new Card(10, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 2);


        //Typical Case
        //Mid Pair
        board.clear();
        board.add(new Card(2, Suit.Hearts));
        board.add(new Card(6, Suit.Clubs));
        board.add(new Card(8, Suit.Clubs));
        board.add(new Card(11, Suit.Diamonds));
        board.add(new Card(8, Suit.Hearts));
        players[0] = new Card(7, Suit.Hearts);
        players[1] = new Card(3, Suit.Hearts);
        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 2);

        //Check highest five in correct order
        assertTrue(h.compare().getBestFive().get(0).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 7);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 6);


        //High Card should not return pair
        board.clear();
        board.add(new Card(10, Suit.Hearts));
        board.add(new Card(8, Suit.Clubs));
        board.add(new Card(7, Suit.Diamonds));
        board.add(new Card(6, Suit.Hearts));
        board.add(new Card(2, Suit.Spades));
        players[0] = new Card(14, Suit.Clubs);
        players[1] = new Card(13, Suit.Hearts);
        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 2);


    }

    @Test
    public void testHigh() {

        //Edge Cases
        //Royal Flush should not return High Card
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
        assertFalse(h.compare().getHandCategory() == 1);

        //Quads should not return High card
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(14, Suit.Diamonds));
        board.add(new Card(14, Suit.Hearts));
        board.add(new Card(14, Suit.Clubs));
        board.add(new Card(13, Suit.Spades));
        players[0] = new Card(13, Suit.Clubs);
        players[1] = new Card(13, Suit.Diamonds);

        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 1);

        //Close straight should return Ace high card.
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Hearts));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(8, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(6, Suit.Diamonds);

        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 1);
        //Correct ordering
        assertTrue(h.compare().getBestFive().get(0).getValue() == 14);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 12);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 8);

        //Typical Case
        //King High
        board.clear();
        board.add(new Card(9, Suit.Spades));
        board.add(new Card(13, Suit.Spades));
        board.add(new Card(3, Suit.Hearts));
        board.add(new Card(11, Suit.Clubs));
        board.add(new Card(8, Suit.Spades));
        players[0] = new Card(7, Suit.Spades);
        players[1] = new Card(6, Suit.Diamonds);

        h = new HandComparer(players, board);
        assertTrue(h.compare().getHandCategory() == 1);
        assertTrue(h.compare().getBestFive().get(0).getValue() == 13);
        assertTrue(h.compare().getBestFive().get(1).getValue() == 11);
        assertTrue(h.compare().getBestFive().get(2).getValue() == 9);
        assertTrue(h.compare().getBestFive().get(3).getValue() == 8);
        assertTrue(h.compare().getBestFive().get(4).getValue() == 7);

        //Pair should not return high card
        board.clear();
        board.add(new Card(14, Suit.Spades));
        board.add(new Card(13, Suit.Diamonds));
        board.add(new Card(12, Suit.Hearts));
        board.add(new Card(10, Suit.Clubs));
        board.add(new Card(8, Suit.Spades));
        players[0] = new Card(7, Suit.Clubs);
        players[1] = new Card(8, Suit.Diamonds);

        h = new HandComparer(players, board);
        assertFalse(h.compare().getHandCategory() == 1);
    }
}
