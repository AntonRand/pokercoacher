/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck Class.
 * @author Anton
 */
public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    /**
     * Construct a new deck with a predetermined card order.
     * @param deck, the predetermined deck.
     */
    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * Constructor for a new deck of shuffled cards.
     */
    public Deck() {

        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(3, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
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
        deck.add(new Card(9, Suit.Spades));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(13, Suit.Spades));

        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Hearts));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(9, Suit.Hearts));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(13, Suit.Hearts));

        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(3, Suit.Diamonds));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(6, Suit.Diamonds));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(8, Suit.Diamonds));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(10, Suit.Diamonds));
        deck.add(new Card(11, Suit.Diamonds));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Diamonds));

        Collections.shuffle(deck);
    }

    /**
     * @return First Card on deck, remove from deck.
     */
    public Card dealCard() {
        return deck.remove(0);
    }

    /**
     * Sort Deck in Descending order.
     */
    public void sortByValue() {
        Collections.sort(deck);
    }

    public void remove(Card c) {
        deck.remove(c);
    }

    public Card getCard(int value) {

        for (Card card : deck) {
            if (card.getValue() == value) {
                return card;
            }
        }
        return null;
    }

    /**
     * @return String representation of deck.
     */
    @Override
    public String toString() {
        String s = "";
        //Add each card to the string on seperate line.
        for (int i = 0; i < deck.size(); i++) {
            s = s + deck.get(i).toString() + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Deck());
    }
}
