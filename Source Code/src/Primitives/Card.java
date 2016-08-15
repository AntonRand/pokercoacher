/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

/**
 * Card Class.
 * @author Anton
 */
public class Card implements Comparable {

    private int value;
    private Suit suit;

    /**
     * Constructor for Card Class.
     * @param value, the cards value between 2 and 14
     * @param suit, the cards suit.
     */
    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Display the card in a user friendly manner.
     * @return 
     */
    @Override
    public String toString() {
        String representation = "";

        //Values represented by integers to speed up execution time, the user
        //should be told J|Q|K|A as opposed to 11|12|13|14, suit represented
        //symbolically.
        if (value == 11) {
            representation = "J";
        } else if (value == 12) {
            representation = "Q";
        } else if (value == 13) {
            representation = "K";
        } else if (value == 14 || value == 1) {
            representation = "A";
        } else {
            representation = Integer.toString(value);
        }
        if (suit == Suit.Clubs) {
            return representation + "♣";
        } else if (suit == Suit.Spades) {
            return representation + "♠";
        } else if (suit == Suit.Hearts) {
            return representation + "♥";
        } else if (suit == Suit.Diamonds) {
            return representation + "♦";
        }
        return representation;
    }

    /**
     * @return Card Name
     */
    public String toValue() {
        if (value == 11) {
            return "Jack";
        } else if (value == 12) {
            return "Queen";
        } else if (value == 13) {
            return "King";
        } else if (value == 14) {
            return "Ace";
        } else {
            return "" + value;
        }

    }

    /**
     * Compare two cards, Sorted Descending
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Object t) {
        return ((Card) t).value - this.value;
    }

    /**
     * @return, the Suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return, the numeric value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Return the cards value, used for split pot situations where there is an
     * odd chip. Ace High, if value the same take suit into consideration.
     * @return 
     */
    public double highCardValue() {

        double suitValue = 0;

        if (suit == Suit.Spades) {
            suitValue = 0.4;
        } else if (suit == Suit.Hearts) {
            suitValue = 0.3;
        } else if (suit == Suit.Diamonds) {
            suitValue = 0.2;
        } else if (suit == Suit.Clubs) {
            suitValue = 0.1;
        }
        return value + suitValue;
    }
}
