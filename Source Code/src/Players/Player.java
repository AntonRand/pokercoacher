/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Tools.GameCalculations.HandComparer;
import Tools.GameCalculations.HandResult;
import Primitives.Card;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Abstract Player Class, all Player's must extend this class.
 * Players can be compared by the amount called (Ascending)
 * 
 * @author Anton
 */
public abstract class Player implements Comparable {

    private String forename;
    private String surname;
    private boolean inHand = true;
    private boolean inGame = true;
    private int balance;
    private int amountCalled;
    private Card[] holeCards = new Card[2];
    private int amountToAdd = 0;
    private int guiPosition;
    private int position;
    private boolean showCards;
    private volatile boolean makingDecision = false;
    private volatile int decision = -3;
    private String lastAction = null;
    private Color playerColour;
    private int amountLastCommitted = 0;
    private int outLastHand = 0;
    private volatile boolean paused = false;
    private ArrayList<String> handActions = new ArrayList<String>();
    private ArrayList<Player> thePlayers;

    /**
     * Construct a new Player.
     * @param forename, Players First name
     * @param surname, Players Last name
     * @param chipBalance, Starting Chip Balance.
     */
    public Player(String forename, String surname, int chipBalance, int guiPosition, boolean showCards) {
        this.forename = forename;
        this.surname = surname;
        this.balance = chipBalance;
        this.guiPosition = guiPosition;
        amountCalled = 0;
        this.showCards = showCards;
        amountLastCommitted = chipBalance;
    }

    public void setAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public void addActionToList(String action) {
        handActions.add(action);
    }

    public ArrayList<String> getActions() {
        return handActions;
    }

    public void setColor(Color c) {
        playerColour = c;
    }

    public int getDecision() {
        return decision;
    }

    public void setDecision(int d) {
        decision = d;
    }

    public String getAction() {
        return lastAction;
    }

    public boolean isPaused() {
        return paused;
    }

    public void changePaused() {
        if (paused == true) {
            paused = false;
        } else {
            paused = true;
        }
    }

    public boolean getShow() {
        return showCards;
    }

    public void setShow(boolean showCards) {
        this.showCards = showCards;
    }

    public void setPosition(int position) {
        //0 = Early
        //1 = Middle
        //2 = Late
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    /**
     * Add chips that the player just won
     * @param i, the amount to add.
     */
    public void addWinnings(int i) {
        amountToAdd += i;
    }

    public int getGuiPosition() {
        return guiPosition;
    }

    public boolean isPlayersTurn() {
        //It is the players turn in decision is -2.
        if (decision == -2) {
            return true;
        } else {
            return false;
        }
    }

    public void setPlayersTurn(boolean playersTurn) {
        if (playersTurn == true) {
            decision = -2;
        } else {
            decision = -3;
        }
    }

    public int getOutLastHand() {
        //1 = Still in Hand
        //0 = Out Last Hand
        //-1 = Out Several Hands Ago
        return outLastHand;
    }

    public void setPlayers(ArrayList<Player> thePlayers) {
        this.thePlayers = thePlayers;
    }

    public ArrayList<Player> getPlayers() {
        return thePlayers;
    }

    public void incrementHandsOut() {
        outLastHand++;
    }

    /**
     * Add the winnings to the chip balance, if the value was more than 0
     * display the amount the player won.
     * @return True -> If more than 0 chips added, otherwise False.
     */
    public int addWinnings() {
        if (amountToAdd > 0) {
            int am = amountToAdd;
            balance += amountToAdd;
            amountToAdd = 0;
            return am;
        } else {
            return 0;
        }
    }

    /**
     * Get the result containing information on the players hand
     * @param boardCards, the cards on the table
     * @return HandResult containing Hand Information
     */
    public HandResult getResult(ArrayList<Card> boardCards) {
        return new HandComparer(holeCards, boardCards).compare();
    }

    /**
     * @return The Players cards
     */
    public Card[] getCards() {
        return holeCards;
    }

    /**
     * Print the players cards using command line.
     */
    public void printCards() {
        System.out.println(holeCards[0] + " " + holeCards[1]);
    }

    /**
     * Set the players first card equal to the card given
     * @param cardOne The card dealt
     */
    public void dealFirstCard(Card cardOne) {
        holeCards[0] = cardOne;
    }

    /**
     * Set the players second card equal to the card given
     * @param cardTwo The card dealt
     */
    public void dealSecondCard(Card cardTwo) {
        holeCards[1] = cardTwo;
    }

    /**
     * @return The players current chip balance
     */
    public int getChipBalance() {
        return balance;
    }

    /**
     * Set the players Chip Balance
     * @param chipBalance, Amount to set
     */
    public void setChipBalance(int chipBalance) {
        this.balance = chipBalance;
    }

    /**
     * Bet a given amount so that the chips are no longer listed with their balance
     * but as the amount called.
     * 
     * Return the amount bet, ensuring a player cannot bet more than they have.
     * @param chipsToBet, the amount for the player to bet.
     * @return The amount of chips the player bet.
     */
    public int bet(int chipsToBet) {

        if (chipsToBet > balance) {
            int i = balance;
            amountCalled += balance;
            balance = 0;
            return i;
        } else {
            balance -= chipsToBet;
            amountCalled += chipsToBet;
            return chipsToBet;
        }
    }

    /**
     * Check whether the player is all in.
     * @return result of all in check
     */
    public boolean allIn() {
        if (balance == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return The Players Forename + Surname
     */
    public String getName() {
        return forename + " " + surname;
    }

    /**
     * 
     * Main method to get a players action
     * 
     * @param amountToCall, the amount of chips required to call.
     * @param boardCards, the cards on the table.
     * @param bigBlind, the big blind (Useful for Min-Raises)
     * @return The players action (Amount Bet)
     */
    public abstract int getAction(int amountToCall, ArrayList<Card> boardCards, int bigBlind);

    /**
     * @return Combined Card Value
     */
    public int getCardsValue() {
        return holeCards[0].getValue() + holeCards[1].getValue();
    }

    /**
     * @return, True if both player cards are the same value, otherwise false.
     */
    public boolean pocketPair() {
        if (holeCards[0].getValue() == holeCards[1].getValue()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return The amount a player has called. 
     */
    public int getAmountCalled() {
        return amountCalled;
    }

    /**
     * Fold a player from the current hand.
     */
    public void fold() {
        inHand = false;
    }

    /**
     * Add a given amount of chips to the players balance.
     * @param i, the amount to add to the players balance
     */
    public void addToBalance(int i) {
        balance += i;
    }

    /**
     * Reduce the amount of chips a player has called.
     * @param i, The amount to reduce by.
     */
    public void reduceAmountCalled(int i) {
        amountCalled -= i;
    }

    /**
     * Refund an amount of chips back to the balance
     * Useful when a player overcommits chips in all in situations.
     * @param i, the amount to subtract from commited chips and to add back to balance.
     */
    public void refund(int i) {
        amountCalled -= i;
        addToBalance(i);
    }

    /**
     * Reset the initial values ready for new hand, ensures previous information
     * cannot be carried forward.
     */
    public void resetValues() {
        inHand = inGame();
        amountCalled = 0;
        holeCards[0] = null;
        holeCards[1] = null;
        amountToAdd = 0;
        setShow(false);
        amountLastCommitted = balance;
        handActions.clear();
    }

    /**
     * @return, the inHand field representing wether the player is still in the hand or not.
     */
    public boolean inHand() {
        return inHand;
    }

    /**
     * @return Boolean representing wether the player is still in the game or has been knocked out.
     */
    public boolean inGame() {
        if (balance == 0 && amountCalled == 0) {
            inGame = false;
            return false;
        }
        inGame = true;
        return true;
    }

    public boolean guiPlayer() {
        return false;
    }

    public boolean lessonGUIPlayer() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ", " + balance + ", " + holeCards[0] + ", " + holeCards[1];

    }

    public Color getColour() {
        return playerColour;
    }

    public int getAmountLastCommitted() {
        return amountLastCommitted;
    }

    
    class PlayerComparator implements Comparator {

        @Override
        public int compare(Object playerOne, Object playerTwo) {

            int playerOneCommitted = ((Player) playerOne).amountLastCommitted;
            int playerTwoCommitted = ((Player) playerTwo).amountLastCommitted;

            if (playerOneCommitted > playerTwoCommitted) {
                return 1;
            } else if (playerOneCommitted < playerTwoCommitted) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
