/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class CardTest {

    public CardTest() {
    }

    @Test
    public void testToString() {

        //Check that the string representations are correct.
        Card c = new Card(14, Suit.Hearts);
        assertEquals(c.toString(), "A♥");

        c = new Card(13, Suit.Clubs);
        assertEquals(c.toString(), "K♣");

        c = new Card(12, Suit.Diamonds);
        assertEquals(c.toString(), "Q♦");

        c = new Card(11, Suit.Spades);
        assertEquals(c.toString(), "J♠");

        c = new Card(10, Suit.Spades);
        assertEquals(c.toString(), "10♠");

        c = new Card(9, Suit.Diamonds);
        assertEquals(c.toString(), "9♦");

        c = new Card(8, Suit.Diamonds);
        assertEquals(c.toString(), "8♦");

        c = new Card(7, Suit.Diamonds);
        assertEquals(c.toString(), "7♦");

        c = new Card(6, Suit.Diamonds);
        assertEquals(c.toString(), "6♦");

        c = new Card(5, Suit.Diamonds);
        assertEquals(c.toString(), "5♦");

        c = new Card(4, Suit.Diamonds);
        assertEquals(c.toString(), "4♦");

        c = new Card(3, Suit.Diamonds);
        assertEquals(c.toString(), "3♦");

        c = new Card(2, Suit.Diamonds);
        assertEquals(c.toString(), "2♦");

    }

    @Test
    public void testToValue() {

        //Check that the correct value is returned.
        Card c = new Card(14, Suit.Hearts);
        assertEquals(c.toValue(), "Ace");

        c = new Card(13, Suit.Clubs);
        assertEquals(c.toValue(), "King");

        c = new Card(12, Suit.Diamonds);
        assertEquals(c.toValue(), "Queen");

        c = new Card(11, Suit.Spades);
        assertEquals(c.toValue(), "Jack");

        c = new Card(10, Suit.Spades);
        assertEquals(c.toValue(), "10");

        c = new Card(9, Suit.Diamonds);
        assertEquals(c.toValue(), "9");

        c = new Card(8, Suit.Diamonds);
        assertEquals(c.toValue(), "8");

        c = new Card(7, Suit.Diamonds);
        assertEquals(c.toValue(), "7");

        c = new Card(6, Suit.Diamonds);
        assertEquals(c.toValue(), "6");

        c = new Card(5, Suit.Diamonds);
        assertEquals(c.toValue(), "5");

        c = new Card(4, Suit.Diamonds);
        assertEquals(c.toValue(), "4");

        c = new Card(3, Suit.Diamonds);
        assertEquals(c.toValue(), "3");

        c = new Card(2, Suit.Diamonds);
        assertEquals(c.toValue(), "2");

    }

    @Test
    public void testgetSuit() {

        //Check that the correct suit is returned.
        Card c = new Card(14, Suit.Hearts);
        assertEquals(c.getSuit(), Suit.Hearts);

        c = new Card(13, Suit.Clubs);
        assertEquals(c.getSuit(), Suit.Clubs);

        c = new Card(12, Suit.Diamonds);
        assertEquals(c.getSuit(), Suit.Diamonds);

        c = new Card(11, Suit.Spades);
        assertEquals(c.getSuit(), Suit.Spades);


    }

    @Test
    public void testGetValue() {

        //Check that the numeric value is correctly returned.
        Card c = new Card(14, Suit.Hearts);
        assertEquals(c.getValue(), 14);

        c = new Card(13, Suit.Clubs);
        assertEquals(c.getValue(), 13);

        c = new Card(12, Suit.Diamonds);
        assertEquals(c.getValue(), 12);

        c = new Card(11, Suit.Spades);
        assertEquals(c.getValue(), 11);

        c = new Card(10, Suit.Spades);
        assertEquals(c.getValue(), 10);

        c = new Card(9, Suit.Diamonds);
        assertEquals(c.getValue(), 9);

        c = new Card(8, Suit.Diamonds);
        assertEquals(c.getValue(), 8);

        c = new Card(7, Suit.Diamonds);
        assertEquals(c.getValue(), 7);

        c = new Card(6, Suit.Diamonds);
        assertEquals(c.getValue(), 6);

        c = new Card(5, Suit.Diamonds);
        assertEquals(c.getValue(), 5);

        c = new Card(4, Suit.Diamonds);
        assertEquals(c.getValue(), 4);

        c = new Card(3, Suit.Diamonds);
        assertEquals(c.getValue(), 3);

        c = new Card(2, Suit.Diamonds);
        assertEquals(c.getValue(), 2);
    }

    @Test
    public void testHighCardValue() {

        //Check that the high card is correctly returned
        Card c = new Card(14, Suit.Spades);
        assertTrue(c.highCardValue() == 14.4);

        c = new Card(9, Suit.Hearts);
        assertTrue(c.highCardValue() == 9.3);

        c = new Card(5, Suit.Diamonds);
        assertTrue(c.highCardValue() == 5.2);

        c = new Card(2, Suit.Clubs);
        assertTrue(c.highCardValue() == 2.1);

    }
}
