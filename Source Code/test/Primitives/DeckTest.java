/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class DeckTest {

    public DeckTest() {
    }

    @Test
    public void testRandomDeck() {

        Deck d = new Deck();

        //No Cards should be the same in the Deck.
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());
        assertTrue(d.dealCard() != d.dealCard());




    }

    @Test
    public void testCreatedDeck() {

        //Test that the deck deals the cards out correctly.
        ArrayList<Card> deck = new ArrayList<Card>();

        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Spades));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(8, Suit.Diamonds));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));

        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(5, Suit.Spades));
        deck.add(new Card(6, Suit.Spades));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(8, Suit.Spades));

        Deck d = new Deck(deck);


        Card c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Clubs));
        assertTrue(c.getValue() == 14);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Spades));
        assertTrue(c.getValue() == 2);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Hearts));
        assertTrue(c.getValue() == 3);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Diamonds));
        assertTrue(c.getValue() == 4);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Clubs));
        assertTrue(c.getValue() == 5);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Spades));
        assertTrue(c.getValue() == 6);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Hearts));
        assertTrue(c.getValue() == 7);

        c = d.dealCard();
        assertTrue(c.getSuit().equals(Suit.Diamonds));
        assertTrue(c.getValue() == 8);

    }
}
