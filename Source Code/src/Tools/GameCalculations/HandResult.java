/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.GameCalculations;

import Primitives.Card;
import Primitives.Suit;
import java.util.ArrayList;

/**
 * HandResult Class.
 * @author Anton
 */
public class HandResult {

    private int handCategory;
    private ArrayList<Card> bestFiveCards;

    /**
     * Construct a new HandResult.
     * @param handCategory, the category of the hand.
     * @param bestFiveCards, the hands best 5 cards.
     */
    public HandResult(int handCategory, ArrayList<Card> bestFiveCards) {
        this.handCategory = handCategory;
        this.bestFiveCards = bestFiveCards;
    }

    public ArrayList<Card> getBestFive() {
        return bestFiveCards;
    }

    public void printBestFive() {
        System.out.print(bestFiveCards.get(0).getValue() + ", ");
        System.out.print(bestFiveCards.get(1).getValue() + ", ");
        System.out.print(bestFiveCards.get(2).getValue() + ", ");
        System.out.print(bestFiveCards.get(3).getValue() + ", ");
        System.out.println(bestFiveCards.get(4));
    }

    public int getHandCategory() {
        return handCategory;
    }

    public int getFirstValue() {
        return bestFiveCards.get(0).getValue();
    }

    public int getSecondValue() {
        return bestFiveCards.get(1).getValue();
    }

    public int getThirdValue() {
        return bestFiveCards.get(2).getValue();
    }

    public int getFourthValue() {
        return bestFiveCards.get(3).getValue();
    }

    public int getFifthValue() {
        return bestFiveCards.get(4).getValue();
    }

    public Suit getFirstSuit() {
        return bestFiveCards.get(0).getSuit();
    }

    public Suit getSecondSuit() {
        return bestFiveCards.get(1).getSuit();
    }

    public Suit getThirdSuit() {
        return bestFiveCards.get(2).getSuit();
    }

    public Suit getFourthSuit() {
        return bestFiveCards.get(3).getSuit();
    }

    public Suit getFifthSuit() {
        return bestFiveCards.get(4).getSuit();
    }

    /**
     * @return, String representation of the hand.
     */
    public String getStringRepresentation() {

        return "" + getFirstValue() + " " + getFirstSuit().toString().substring(0, 1) + ","
                + getSecondValue() + " " + getSecondSuit().toString().substring(0, 1) + ","
                + getThirdValue() + " " + getThirdSuit().toString().substring(0, 1) + ","
                + getFourthValue() + " " + getFourthSuit().toString().substring(0, 1) + ","
                + getFifthValue() + " " + getFifthSuit().toString().substring(0, 1) + ",";
    }

    @Override
    public String toString() {

        switch (handCategory) {
            case 9:
                return "Straight Flush";
            case 8:
                return "Four of a kind";
            case 7:
                return "Full House";
            case 6:
                return "Flush";
            case 5:
                return "Straight";
            case 4:
                return "Three of a kind";
            case 3:
                return "Two Pair";
            case 2:
                return "One Pair";
            case 1:
                return "High Card";
            default:
                return "Error: Not a recognised Hand";
        }
    }
}
