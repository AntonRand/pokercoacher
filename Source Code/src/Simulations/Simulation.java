/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulations;

import Primitives.Card;
import Primitives.Deck;
import Tools.GameCalculations.HandComparer;
import Tools.GameCalculations.HandResult;
import Tools.Utilities;
import java.util.ArrayList;

/**
 * Simulation Class.
 * @author Anton
 */
public class Simulation {

    private double handsWon = 0;
    private double handsLost = 0;
    private Card[] playerCards;
    private ArrayList<Integer> playerPositions;
    private ArrayList<Card> communityCards = new ArrayList<Card>();
    private ArrayList<Card[]> allocatedHands = new ArrayList<Card[]>();
    private ArrayList<Card> availableCards = new ArrayList<Card>();

    /**
     * Construct a new simulation when there are community cards.
     * @param playerCards, the players hole cards.
     * @param playerPositions, the other players positions
     * @param availableCards, the community cards.
     */
    public Simulation(Card[] playerCards, ArrayList<Integer> playerPositions, ArrayList<Card> availableCards) {
        this.playerCards = playerCards;
        this.playerPositions = playerPositions;
        this.availableCards = availableCards;
    }

    /**
     * Construct a new simulation for pre-flop.
     * @param playerCards, the players hole cards.
     * @param playerPositions, the other players positions
     */
    public Simulation(Card[] playerCards, ArrayList<Integer> playerPositions) {
        this.playerCards = playerCards;
        this.playerPositions = playerPositions;
        communityCards = new ArrayList<Card>();
    }

    /**
     * Used to run multiple simulations.
     * @param numberToRun, the number of simulations to run.
     */
    public void runSimulations(int numberToRun) {
        for (int i = 0; i < numberToRun; i++) {
            runSimulation();
        }
    }

    /**
     * Runs a single simulation.
     */
    public void runSimulation() {

        //Clear the previous details.
        communityCards.clear();
        allocatedHands.clear();

        //Setup the simulation.
        setupSimulation();


        HandResult playerHand = new HandComparer(playerCards, communityCards).compare();

        boolean handWon = true;

        //Compare hand against other players, log when their hand wins.
        for (Card[] cards : allocatedHands) {
            HandResult opponentHand = new HandComparer(cards, communityCards).compare();

            if (Utilities.getBestHand(playerHand, opponentHand) != null && Utilities.getBestHand(playerHand, opponentHand).equals(opponentHand)) {
                handWon = false;
                break;
            }
        }

        if (handWon) {
            handsWon++;
        } else {
            handsLost++;
        }
    }

    /**
     * Resets the fields from previous simulation and sets fields
     * back up.
     */
    public void setupSimulation() {

        //Create a deck and remove the players hole cards.
        Deck theDeck = new Deck();
        theDeck.remove(playerCards[0]);
        theDeck.remove(playerCards[1]);

        communityCards.clear();

        //Add all the known community cards.
        communityCards.addAll(availableCards);

        //Remove these cards from the deck.
        for (Card c : communityCards) {
            theDeck.remove(c);
        }

        //Make the number of community cards up to 5.
        while (communityCards.size() != 5) {
            communityCards.add(theDeck.dealCard());
        }

        //This looks at the position of players who are in the hand and makes an estimate of what they have.
        for (int position : playerPositions) {
            //If early player
            if (position == 0) {
                ArrayList<int[]> possibleHands = Utilities.getAnyCards();
                generateHand(theDeck, possibleHands);
            } else if (position == 1) {
                //If middle player
                ArrayList<int[]> possibleHands = Utilities.getAnyCards();
                possibleHands.addAll(Utilities.getMiddleCards());
                generateHand(theDeck, possibleHands);
            } else {
                //If late player
                ArrayList<int[]> possibleHands = Utilities.getAnyCards();
                possibleHands.addAll(Utilities.getMiddleCards());
                possibleHands.addAll(Utilities.getLateCards());
                generateHand(theDeck, possibleHands);
            }
        }
    }

    /**
     * @return, The percentage of hands won.
     */
    public double getWinPercent() {

        if (handsWon == 0 && handsLost == 0) {
            return 0;
        } else {
            return (handsWon / (handsWon + handsLost)) * 100;
        }
    }

    /**
     * Allocates cards.
     * @param theDeck, the deck to use.
     * @param possibleHands, the possible hands.
     */
    public void generateHand(Deck theDeck, ArrayList<int[]> possibleHands) {

        Card[] cardArray = new Card[2];
        cardArray[0] = theDeck.dealCard();
        cardArray[1] = theDeck.dealCard();

        allocatedHands.add(cardArray);
    }
}
