/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

import Tools.GameCalculations.HandComparer;
import Tools.GameCalculations.HandResult;
import Tools.GameCalculations.PlayerResult;
import Primitives.Pot;
import Players.Player;
import Primitives.Card;
import Primitives.Deck;
import Primitives.Suit;
import Tools.Utilities;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Super class representing a poker hand, games are made up of numerous
 * poker hands.
 * @author Anton
 */
public abstract class Hand {

    private ArrayList<Player> players;
    private int bigBlind;
    private int dealerPosition;
    private int bigBlindPosition;
    private int smallBlindPosition;
    private Deck deck;
    private ArrayList<Card> communityCards = new ArrayList<Card>();
    private int highestBet = 0;
    private int lastHandBet = 0;
    private int pot = 0;
    private View thePanel;
    private ArrayList<Pot> pots = new ArrayList<Pot>();
    //For testing
    private int amountToCall;

    /**
     * Construct a new Hand Instance
     * @param players, The players to be involved in the hand
     * @param bigBlind, The big blind amount
     * @param dealerPosition, The position of the dealer
     */
    public Hand(ArrayList<Player> players, int bigBlind, int dealerPosition, View thePanel) {

        this.players = players;
        this.bigBlind = bigBlind;
        this.dealerPosition = dealerPosition;
        this.thePanel = thePanel;
        deck = new Deck();

        //Ensures that players post their blinds.
        assignBlinds(dealerPosition);
    }

    /**
     * Construct a Hand with a predetermined Deck
     * @param players, The players to be involved in this hand
     * @param bigBlind, The big blind amount
     * @param dealerPosition, The position of the dealer
     * @param deck, The deck of cards to use in the hand
     */
    public Hand(ArrayList<Player> players, int bigBlind, int dealerPosition, Deck deck, View thePanel) {

        this.players = players;
        this.bigBlind = bigBlind;
        this.dealerPosition = dealerPosition;
        this.deck = deck;
        this.thePanel = thePanel;

        //Ensures that players post their blinds.
        assignBlinds(dealerPosition);

    }

    /**
     * Assigns the positions of the next blinds, taking dead blinds into account,
     * @param dealerPos, the current position of the dealer chip.
     */
    public final void assignBlinds(int dealerPos) {


        //If outLastHand equals 1, this is the first hand that player has been out of.
        //Meaning there is a chance one of the blinds is dead.

        //Create an array list for players still in the game and another for
        //players still in the game or recently out (Dead).
        ArrayList<Player> gamePlayers = new ArrayList<Player>();
        ArrayList<Player> gameOrDeadPlayers = new ArrayList<Player>();


        //Populates the gamePlayers array list.
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inGame() == true) {
                //Add players who are still in the game.
                gamePlayers.add(players.get(i));
            }
        }

        //Populates the gameOrDeadPlayers array list.
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inGame() == true || players.get(i).getOutLastHand() < 3) {
                //Add players still in the game or recently out.
                gameOrDeadPlayers.add(players.get(i));
            }
        }

        //Create temporary values.
        int tempDealer = -1;
        int tempSmallBlind = -1;
        int tempBigBlind = -1;

        //When there are at least 3 players in the game. Blinds are handled differently
        //if there are only 2 players.
        if (gamePlayers.size() > 2) {

            //Find the first player in game or recently out, this is where the dealer is.
            for (int i = 0; i < players.size(); i++) {
                //Starts the search at the current index given (Not 0 everytime).
                if (gameOrDeadPlayers.contains(players.get((i + dealerPos) % players.size()))) {
                    tempDealer = (i + dealerPos) % players.size();
                    break;
                }
            }

            //Find the first player eligible to be the small blind.
            for (int i = 0; i < players.size(); i++) {
                //Add +1 because the first position is assigned as dealer.
                if (gameOrDeadPlayers.contains(players.get((i + tempDealer + 1) % players.size()))) {
                    tempSmallBlind = (i + tempDealer + 1) % players.size();
                    break;
                }
            }

            //Find the first player eligible to be the big blind.
            for (int i = 0; i < players.size(); i++) {
                //Add +1 because the first position is small blind.
                //Only look at players still in the game because there MUST be a big blind.
                if (gamePlayers.contains(players.get((i + tempSmallBlind + 1) % players.size()))) {
                    tempBigBlind = (i + tempSmallBlind + 1) % players.size();
                    break;
                }
            }


            //Now that we have the dealer we increment the amount of hands they have been out
            //for. So that once they have been out of 2/3 hands they will no longer be considered
            //as a dead blind.
            Player dealerPlayer = players.get(tempDealer);

            //If they were out the game, increment the amount of hands they are out of.
            if (dealerPlayer.inGame() == false) {
                dealerPlayer.incrementHandsOut();
                dealerPlayer.incrementHandsOut();
            }


        } else {
            //When there are two players, the dealer is the Small Blind,
            //need to avoid displaying both chips as traditionally just the
            //dealer chip is shown.

            //Assign the dealer and the small blind.
            for (int i = 0; i < players.size(); i++) {
                if (gamePlayers.contains(players.get((i + dealerPos) % players.size()))) {
                    tempDealer = (i + dealerPos) % players.size();
                    tempSmallBlind = tempDealer;
                    break;
                }
            }

            //Assign the big blind.
            for (int i = 0; i < players.size(); i++) {
                if (gamePlayers.contains(players.get((i + tempDealer + 1) % players.size()))) {
                    tempBigBlind = (i + tempDealer + 1) % players.size();
                    break;
                }
            }

        }

        //Set the fields to the correct values.
        dealerPosition = tempDealer;
        smallBlindPosition = tempSmallBlind;
        bigBlindPosition = tempBigBlind;

    }

    public View getPanel() {
        return thePanel;
    }

    public void setPanel(View p) {
        thePanel = p;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getHighestBet() {
        return highestBet;
    }

    public void setHighestBet(int bet) {
        highestBet = bet;
    }

    public int getLastHandBet() {
        return lastHandBet;
    }

    public void setAmountToCall(int amount) {
        amountToCall = amount;
    }

    public void setLastHandBet(int lastBet) {
        lastHandBet = lastBet;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /*
     * Returns the total committed to the pot. 
     */
    public synchronized int getPotsTotal() {
        int total = 0;
        for (Pot p : pots) {
            total += p.getPotTotal();
        }
        return total;
    }

    /**
     * @return, Returns the total committed to the pot + all currently 
     * unmatched player bets.
     */
    public synchronized int getPotAmount() {
        int total = getPotsTotal();
        for (Player player : players) {
            total += player.getAmountCalled();
        }
        return total;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public int getDealerPosition() {
        return dealerPosition;
    }

    public int getSmallBlindPosition() {
        return smallBlindPosition;
    }

    public int getBigBlindPosition() {
        return bigBlindPosition;
    }

    /**
     * @return, Returns the community cards on the table
     */
    public ArrayList<Card> getCommunityCards() {
        return communityCards;
    }

    /**
     * @return, The number of players currently involved in that hand.
     */
    public int getPlayersInvolved() {
        int count = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inHand() == true) {
                //Increment the count if that player is in the hand still.
                count++;
            }
        }
        //Return the final value.
        return count;
    }

    /**
     * @return, The player involved in the hand, called when we know there is only
     * one player involved.
     */
    public Player getInvolvedPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inHand() == true) {
                return players.get(i);
            }
        }
        return null;
    }

    /**
     * This gets the initial player actions in the pre-flop stage.
     * Pre-flop actions start to the left of the big blind.
     */
    public void getPreflopActions() {

        //Get the number of players involved.
        int involved = getPlayersInvolved();


        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inHand() == true && players.get(i).allIn() == true) {
                //All in players do not count as involved, they take no further action.
                involved--;
            }
        }

        //If there is more than one player the hand hasn't ended.
        if (involved != 1) {
            int size = players.size();
            for (int i = 0; i < size; i++) {

                //Allows one round of play where we start from the left of the...
                //Big Blind, who is in position + 2, therefore +3.
                if (players.get((i + dealerPosition + 1) % players.size()).allIn() == false && players.get((i + dealerPosition + 1) % players.size()).inHand() == true) {

                    if (getPlayersInvolved() > 1) {


                        //Get the players bet and add it to the pot
                        int bet = determineAction(players.get((i + dealerPosition + 1) % size), highestBet, communityCards);


                        if (bet < 0) {
                            players.get((i + dealerPosition + 1) % size).fold();
                        } else {
                            addToPot(bet);
                        }



                        //If they have raised then we should update the amount to call (highestBet)
                        if (((players.get((i + dealerPosition + 1) % size).getAmountCalled())) > highestBet) {
                            highestBet = players.get((i + dealerPosition + 1) % size).getAmountCalled();
                            //If they haven't called the amount, and have entered 0 when they needed to call more
                            //that player is then folded so we don't take them into consideration next time.
                        } else if (bet == 0 && (highestBet - (players.get((i + dealerPosition + 1) % size).getAmountCalled()) > 0)) {
                            players.get((i + dealerPosition + 1) % size).fold();
                        }
                    }
                }
            }
        }
    }

    /**
     * This loops for all players still in the hand until all bets have been matched
     */
    public void getActionsUntilCalled() {

        //For detailed information see getPreflopActions() method.
        int size = players.size();

        while ((betsMatched(highestBet) == false) && getPlayersInvolved() > 1) {
            for (int i = 0; i < players.size(); i++) {
                if (getPlayersInvolved() > 1) {
                    if (players.get((i + dealerPosition + 1) % players.size()).allIn() == false && players.get((i + dealerPosition + 1) % players.size()).inHand() == true) {
                        if ((highestBet - (players.get((i + dealerPosition + 1) % players.size()).getAmountCalled())) != 0) {

                            if (getPlayersInvolved() > 1) {


                                int bet = determineAction(players.get((i + dealerPosition + 1) % size), highestBet, communityCards);

                                if (bet < 0) {
                                    players.get((i + dealerPosition + 1) % size).fold();
                                } else {
                                    addToPot(bet);
                                }

                                if (((players.get((i + dealerPosition + 1) % size).getAmountCalled())) > highestBet) {
                                    highestBet = players.get((i + dealerPosition + 1) % size).getAmountCalled();
                                } else if (bet == 0 && (highestBet - (players.get((i + dealerPosition + 1) % size).getAmountCalled()) > 0)) {
                                    players.get((i + dealerPosition + 1) % size).fold();
                                }
                                // players.get((i + dealerPosition + 1) % size).printDetails();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Searches through list to see which players turn it is.
     * This is used for displaying the players turn.
     * @return, the index from the player list or -1 if no players turn.
     */
    public int getPlayersTurn() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isPlayersTurn() == true) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param playersToCheck, The list of players to check
     * @return, The list of players with the strongest hand category
     */
    public ArrayList<PlayerResult> getStrongestCategory(ArrayList<Player> playersToCheck) {
        int category = 0;
        ArrayList<PlayerResult> playerList = new ArrayList<PlayerResult>();

        //Go through each player result, If they have a better hand category reset the
        //list and add them to it.

        //If they have the same hand add them to the list, otherwise don't add them to the
        //list.
        for (int i = 0; i < playersToCheck.size(); i++) {
            Player p = playersToCheck.get(i);
            HandResult r = new HandComparer(p.getCards(), communityCards).compare();
            int playerCat = r.getHandCategory();
            if (p.inHand() == true) {
                if (playerCat > category) {
                    category = playerCat;
                    playerList.clear();
                    playerList.add(new PlayerResult(p, r));
                } else if (playerCat == category) {
                    playerList.add(new PlayerResult(p, r));
                }
            }
        }
        return playerList;
    }

    /**
     *
     * @param playersToCheck, The players to check against
     * @return, The player/s who won
     */
    public ArrayList<PlayerResult> getWinners(ArrayList<Player> playersToCheck) {

        /*
         * Although this code looks lengthy it is fairly straightforward.
         *
         * We have a list of results in the same category.
         *
         * We compare to determine which one is the strongest, for example
         * AAAKK beats KKKAA in fullhouse
         * High card comes into play for 2 pair
         * e.t.c
         *
         *
         */


        ArrayList<PlayerResult> list = getStrongestCategory(playersToCheck);
        int category = list.get(0).getHandResult().getHandCategory();
        ArrayList<PlayerResult> r = new ArrayList<PlayerResult>();

        if (list.size() == 1) {
            return list;
        } else {
            refundUnmatched();


            //Add only the highest valued straight/flush/straightflush's into the list of winners.
            if (category == 9 || category == 6 || category == 5) {

                for (int i = 0; i < list.size(); i++) {
                    if (r.isEmpty() || list.get(i).getHandResult().getFirstValue() > r.get(0).getHandResult().getFirstValue()) {
                        r.clear();
                        r.add(list.get(i));
                    } else if (list.get(i).getHandResult().getFirstValue() == r.get(0).getHandResult().getFirstValue()) {
                        r.add(list.get(i));
                    }

                }
            } else if (category == 8 || category == 7) {

                for (int i = 0; i < list.size(); i++) {
                    //If list empty or new quad high found.
                    if (r.isEmpty() || list.get(i).getHandResult().getFirstValue() > r.get(0).getHandResult().getFirstValue()) {
                        r.clear();
                        r.add(list.get(i));
                    } else if (list.get(i).getHandResult().getFirstValue() == r.get(0).getHandResult().getFirstValue()) {
                        //If the kicker is higher than current
                        if (list.get(i).getHandResult().getFifthValue() > r.get(0).getHandResult().getFifthValue()) {
                            r.clear();
                            r.add(list.get(i));
                            //If kicker is the same as current
                        } else if (list.get(i).getHandResult().getFifthValue() == r.get(0).getHandResult().getFifthValue()) {
                            r.add(list.get(i));
                        }
                    }
                }
            } else if (category == 4 || category == 3) {
                //TWO PAIR CHECKING

                for (int i = 0; i < list.size(); i++) {
                    //If list empty or new quad high found.
                    if (r.isEmpty() || list.get(i).getHandResult().getFirstValue() > r.get(0).getHandResult().getFirstValue()) {
                        r.clear();
                        r.add(list.get(i));
                    } else if (list.get(i).getHandResult().getFirstValue() == r.get(0).getHandResult().getFirstValue()) {

                        //If the kicker is higher than current
                        if (list.get(i).getHandResult().getThirdValue() > r.get(0).getHandResult().getThirdValue()) {
                            r.clear();
                            r.add(list.get(i));
                            //If kicker is the same as current
                        } else if (list.get(i).getHandResult().getThirdValue() == r.get(0).getHandResult().getThirdValue()) {
                            if (list.get(i).getHandResult().getFifthValue() > r.get(0).getHandResult().getFifthValue()) {
                                r.clear();
                                r.add(list.get(i));
                                //If kicker is the same as current
                            } else if (list.get(i).getHandResult().getFifthValue() == r.get(0).getHandResult().getFifthValue()) {
                                r.add(list.get(i));
                            }
                        }
                    }
                }
            } else if (category == 2) {

                for (int i = 0; i < list.size(); i++) {
                    if (r.isEmpty() || list.get(i).getHandResult().getFirstValue() > r.get(0).getHandResult().getFirstValue()) {
                        r.clear();
                        r.add(list.get(i));
                    } else if (list.get(i).getHandResult().getFirstValue() == r.get(0).getHandResult().getFirstValue()) {
                        if (list.get(i).getHandResult().getThirdValue() > r.get(0).getHandResult().getThirdValue()) {
                            r.clear();
                            r.add(list.get(i));
                        } else if (list.get(i).getHandResult().getThirdValue() == r.get(0).getHandResult().getThirdValue()) {
                            if (list.get(i).getHandResult().getFourthValue() > r.get(0).getHandResult().getFourthValue()) {
                                r.clear();
                                r.add(list.get(i));
                            } else if (list.get(i).getHandResult().getFourthValue() == r.get(0).getHandResult().getFourthValue()) {
                                if (list.get(i).getHandResult().getFifthValue() > r.get(0).getHandResult().getFifthValue()) {
                                    r.clear();
                                    r.add(list.get(i));
                                } else if (list.get(i).getHandResult().getFifthValue() == r.get(0).getHandResult().getFifthValue()) {
                                    r.add(list.get(i));
                                }
                            }
                        }
                    }
                }
            } else if (category == 1) {

                for (int i = 0; i < list.size(); i++) {

                    if (r.isEmpty() || list.get(i).getHandResult().getFirstValue() > r.get(0).getHandResult().getFirstValue()) {
                        r.clear();
                        r.add(list.get(i));
                    } else if (list.get(i).getHandResult().getFirstValue() == r.get(0).getHandResult().getFirstValue()) {

                        if (list.get(i).getHandResult().getSecondValue() > r.get(0).getHandResult().getSecondValue()) {
                            r.clear();
                            r.add(list.get(i));
                        } else if (list.get(i).getHandResult().getSecondValue() == r.get(0).getHandResult().getSecondValue()) {
                            if (list.get(i).getHandResult().getThirdValue() > r.get(0).getHandResult().getThirdValue()) {
                                r.clear();
                                r.add(list.get(i));
                            } else if (list.get(i).getHandResult().getThirdValue() == r.get(0).getHandResult().getThirdValue()) {

                                if (list.get(i).getHandResult().getFourthValue() > r.get(0).getHandResult().getFourthValue()) {
                                    r.clear();
                                    r.add(list.get(i));
                                } else if (list.get(i).getHandResult().getFourthValue() == r.get(0).getHandResult().getFourthValue()) {

                                    if (list.get(i).getHandResult().getFifthValue() > r.get(0).getHandResult().getFifthValue()) {
                                        r.clear();
                                        r.add(list.get(i));
                                    } else if (list.get(i).getHandResult().getFifthValue() == r.get(0).getHandResult().getFifthValue()) {
                                        r.add(list.get(i));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return r;
    }

    /**
     * @return Players eligible to win the pot (Ones who are in the hand or all in)
     */
    public ArrayList<Player> getEligiblePlayers() {

        ArrayList<Player> inHand = new ArrayList<Player>();

        //Search through all the players
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (p.allIn() == true || p.inHand() == true) {
                if (p.getAmountCalled() > 0) {
                    //If they are eligible add them to the list.
                    inHand.add(p);
                }
            }
        }
        return inHand;
    }

    public int getAmountToCall() {
        return amountToCall;
    }

    /**
     * Play the Hand and return the updated list of players.
     * @return, The current state of players after the hand has been played.
     */
    public ArrayList<Player> playHand() {

        //Sets up the hand and plays it.
        resetMessages();
        dealCards();
        preFlop();


        //After each hand, wait 5 seconds before dealing next hand.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("PokerHand: An exception occurred.");
        }

        //Resets the values for each player. Makes sure no information from
        //previous hands is carried forward.
        for (int i = 0; i < players.size(); i++) {
            players.get(i).resetValues();
        }

        //Always show the computer players cars.
        players.get(0).setShow(true);

        //Return the current list of players.
        return players;
    }

    /**
     * Post the Big and Small Blinds, Note that the bet method will ensure players
     * go all in if they cannot afford the blind amount.
     */
    public void postBlinds() {

        //Post the Big Blind.
        players.get(bigBlindPosition).setAction("BIG BLIND");
        addToPot(players.get(bigBlindPosition).bet(bigBlind));

        //If they couldn't call the amount they went all in.
        if (players.get(bigBlindPosition).getAmountCalled() < bigBlind) {
            displayMessage(true, players.get(bigBlindPosition).getName(), players.get(bigBlindPosition));
            displaySystemMessage(players.get(bigBlindPosition).getName() + " went All-In with $" + players.get(bigBlindPosition).getAmountCalled() + "\n", Color.BLACK);
        } else {
            //Otherwise they just posted the big blind.
            displayMessage(true, players.get(bigBlindPosition).getName(), players.get(bigBlindPosition));
            displaySystemMessage(" posted Big Blind: $" + bigBlind + "\n", Color.BLACK);
        }


        //Post the Small Blind.
        players.get(smallBlindPosition).setAction("SMALL BLIND");
        //If the small blind is still in the game.
        if (players.get(smallBlindPosition).inGame() == true) {

            //Make players post the small blind.
            addToPot(players.get(smallBlindPosition).bet(bigBlind / 2));

            //If they couldn't call the amount they went all in.
            if (players.get(smallBlindPosition).getAmountCalled() < (bigBlind / 2)) {
                displayMessage(true, players.get(smallBlindPosition).getName(), players.get(smallBlindPosition));
                displaySystemMessage(" went All-In with $" + players.get(smallBlindPosition).getAmountCalled() + "\n", Color.BLACK);
            } else {
                //Otherwise they just posted the small blind.
                displayMessage(true, players.get(smallBlindPosition).getName(), players.get(smallBlindPosition));
                displaySystemMessage(" posted Small Blind: $" + (bigBlind / 2) + "\n", Color.BLACK);
            }
        } else {
            //Otherwise explain to users the the small blind is dead.
            displayMessage(true, "The Small Blind is dead\n", null);
        }
        displayMessage(true, "-------------------------------------------------\n", null);
    }

    /**
     * Deal the cards
     */
    public final void dealCards() {

        //Two Loop's maintain the tradition of dealing around instead of just giving a player two cards.
        for (int i = 0; i < players.size(); i++) {
            players.get((i + dealerPosition + 1) % players.size()).dealFirstCard(deck.dealCard());
        }
        for (int i = 0; i < players.size(); i++) {
            players.get((i + dealerPosition + 1) % players.size()).dealSecondCard(deck.dealCard());
        }
    }

    /**
     * Reset player actions on the GUI.
     */
    public void resetMessages() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setAction(null);
        }
    }

    /**
     * If there is only one player in the hand we call this method to pay
     * that player
     */
    public void paySingleWinner() {

        //Firstly add any uncalled amount the player bet.
        for (int i = 0; i < players.size(); i++) {
            getInvolvedPlayer().addWinnings(players.get(i).getAmountCalled());
        }

        pot = 0;

        //Then give the player the contents of the pots.
        for (int i = 0; i < pots.size(); i++) {
            //Add the value of all the pots to the player
            pots.get(i).awardToPlayer(getInvolvedPlayer());
        }

        //Display that the player won.
        displayWinners(players, communityCards, true);
    }

    /**
     * The next stage cannot begin until all bets are matched or we have a winner.
     * @param currentBet, The amount each player is required to call to match the current bet.
     * @return True if all players have matched the bet, Otherwise return false.
     */
    public boolean betsMatched(int currentBet) {

        if (getPlayersInvolved() == 1) {
            //If there is only one player involved the bets have been matched
            return true;
        }

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getAmountCalled() != currentBet && players.get(i).allIn() == false && players.get(i).inHand() == true) {
                //If we come across a player who hasn't folded and isn't all in.
                //If they also haven't matched the bet then the bets haven't been matched.
                return false;
            }
        }
        return true;
    }

    /**
     * Generates the pots at the end of each stage
     * Creates several pots where players are only in pots for money they are entitled to.
     * Uses code for iteration from: http://www.java-examples.com/remove-element-collection-using-java-iterator-example
     */
    public synchronized void calculatePots() {

        //If there are multiple players, set up the pot/s for deciding winner/s.
        ArrayList<Player> possibleWinners = getEligiblePlayers();
        //Sort the winners by maximum called
        Collections.sort(possibleWinners);
        Collections.reverse(possibleWinners);

        //If the player who bet the most didn't have his bet matched, give them
        //back their uncalled bet amount.
        refundUnmatched();

        //Keep a list of all Players
        ArrayList<Player> allPlayers = new ArrayList<Player>();
        allPlayers.addAll(players);


        //While all the players haven't had their money added to the pot.
        while (allPlayers.isEmpty() == false) {

            //Order the list by maximum First
            Collections.sort(allPlayers);
            Collections.reverse(allPlayers);

            Iterator i = allPlayers.iterator();

            //Iterate through each player and remove players who haven't called
            //anything.
            while (i.hasNext()) {
                Player p = (Player) i.next();
                if (p.getAmountCalled() == 0) {
                    i.remove();
                }
            }

            //If there are still players remaining we need to add their money
            //to the pots.
            if (allPlayers.isEmpty() == false) {

                Pot p;

                //If the first player has a chance of winning (still in hand) add them to the pot. Otherwise just add their money.
                if (possibleWinners.contains(allPlayers.get(0))) {
                    p = new Pot(allPlayers.get(0).getAmountCalled(), allPlayers.get(0));
                } else {
                    p = new Pot(allPlayers.get(0).getAmountCalled());
                    //Reduce the amount they called, as it is now in the pot.
                    allPlayers.get(0).reduceAmountCalled(p.getAmountEach());
                }

                //Remove this amount from the pot.
                pot -= p.getAmountEach();

                //Add the same amount for each other player.
                for (int j = 1; j < allPlayers.size(); j++) {
                    if (possibleWinners.contains(allPlayers.get(j))) {
                        p.add(allPlayers.get(j));
                    } else {
                        p.add(p.getAmountEach());
                        allPlayers.get(j).reduceAmountCalled(p.getAmountEach());
                        pot -= p.getAmountEach();
                    }
                }

                //Then add this pot to the list, keep doing this until all pots are created.
                pots.add(p);
            }
        }
    }

    /**
     * @param i, The amount to add to the total pot.
     */
    public void addToPot(int i) {
        pot += i;
        if (i > highestBet) {
            highestBet = i;
        }
    }

    /**
     * Used to split all of the pots and pay the players.
     * This is called when more than one player is eligible to win.
     */
    public void payWinners() {

        //For each of the pots.
        for (int i = 0; i < pots.size(); i++) {

            //Get the players in the pot and the winners of the pot.
            ArrayList<Player> potPlayers = pots.get(i).getPotPlayers();
            ArrayList<PlayerResult> potResult = getWinners(potPlayers);

            ArrayList<Player> potWinners = new ArrayList<Player>();

            //Add the winning players to the list.
            for (int j = 0; j < potResult.size(); j++) {
                potWinners.add(potResult.get(j).getPlayer());
            }

            //Remove losing players from the pot.
            for (int j = 0; j < potPlayers.size(); j++) {
                if (potWinners.contains(potPlayers.get(j)) == false) {
                    pots.get(i).remove(potPlayers.get(j));
                    j--;
                }
            }

            //Compare the winners list with the pot players list, if they are not on the list
            //remove them from the pot. At the end we only have players who have won the pot
            //so we can split it.
            pots.get(i).splitPot();
        }
        displayWinners(players, communityCards, false);
    }

    /**
     * Ensures a player receives any unmatched chips (When all in players haven't
     * been able to call all the value)
     */
    public void refundUnmatched() {
        //Compare Highest amount called with next highest, Refund the difference.

        //Sort by amount called.
        ArrayList<Player> playerListCopy = new ArrayList<Player>(players);
        Collections.sort(playerListCopy);

        //Can only refund if there is more than one player.
        if (playerListCopy.size() > 1) {
            if (playerListCopy.get(0).getAmountCalled() > playerListCopy.get(1).getAmountCalled()) {
                //Compare the difference between the 2 highest bets.
                int difference = playerListCopy.get(0).getAmountCalled() - playerListCopy.get(1).getAmountCalled();
                //Give them the difference back.
                playerListCopy.get(0).refund(difference);
                pot = pot - difference;
                //Display that they received their chips back.
                displayMessage(true, playerListCopy.get(0).getName() + " Is Refunded " + difference + " Uncalled Chips\n", playerListCopy.get(0));
            }
        }
    }

    /**
     * Determines which action the player has took based on the integer returned.
     * @param p, the player whose action needs to be determined.
     * @param highestBet, the current highest amount.
     * @param communityCards, the cards on the board.
     * @return 
     */
    public int determineAction(Player p, int highestBet, ArrayList<Card> communityCards) {

        //Find out how much the player needs to call to stay in the hand.
        int minBet = highestBet - p.getAmountCalled();
        this.amountToCall = minBet;

        //Get the players Action
        int playerDecision = p.getAction(highestBet, communityCards, bigBlind);
        //We can determine what action the player has took based on the value returned


        //Fold Player if they clicked fold or didn't match the minimum to call amount.
        if (playerDecision == -1 || playerDecision < minBet) {
            displayMessage(true, p.getName(), p);
            p.addActionToList("Folded");
            displaySystemMessage(" Folded\n", Color.BLACK);
            p.setAction("FOLD");
            thePanel.repaint();
            return playerDecision;
        } else if (playerDecision == 0) {
            //If the player chose to check.
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Checked\n", Color.BLACK);
            p.addActionToList("Checked");
            p.setAction("CHECK");
            thePanel.repaint();
            return playerDecision;
        } else if (playerDecision == p.getChipBalance()) {
            //If the player went all in.
            p.bet(playerDecision);
            displayMessage(true, p.getName(), p);
            p.addActionToList("All In");
            displaySystemMessage(" Went All In with $" + (p.getAmountCalled()) + "\n", Color.BLACK);
            p.setAction("ALL IN");
            thePanel.repaint();
        } else if (playerDecision == minBet) {
            //If the player called.
            displayMessage(true, p.getName(), p);
            p.addActionToList("Called");
            displaySystemMessage(" Called $" + playerDecision + "\n", Color.BLACK);
            p.setAction("CALL");
            thePanel.repaint();
            p.bet(playerDecision);
            return playerDecision;
        } else if (playerDecision > minBet) {
            //If the player raised.
            p.bet(playerDecision);
            displayMessage(true, p.getName(), p);
            p.addActionToList("Raised");
            displaySystemMessage(" Raised to $" + (p.getAmountCalled()) + "\n", Color.BLACK);
            p.setAction("RAISE");
            thePanel.repaint();
            return playerDecision;
        }
        return playerDecision;
    }

    /**
     * Based on append code from:
     * http://www.coderanch.com/t/329964/GUI/java/JScrollpane-Force-autoscroll-bottom
     * Shows a message based on the player colour.
     * @param tab, should the message be tabbed?
     * @param message, the message to display
     * @param p, the player whose action it was.
     */
    public void displayMessage(boolean tab, String message, Player p) {
        if (p == null) {
            thePanel.getDetails().append(Color.BLACK, message);
            //Not my code - reference.
            thePanel.repaint();
        } else {
            thePanel.getDetails().append(p.getColour(), message);
            thePanel.repaint();
        }
    }

    /**
     * Pre-flop Stage of hand
     */
    public abstract void preFlop();

    /**
     * Flop stage of the hand
     */
    public abstract void flop();

    /**
     * Turn stage of the hand
     */
    public abstract void turn();

    /**
     * River (Final) stage of the hand
     */
    public abstract void river();

    public abstract void displaySystemMessage(String message, Color c);

    public abstract void displayStage(ArrayList<Card> cards);

    /**
     * Displays the cards dealt on the flop.
     */
    public void displayFlop() {

        displaySystemMessage("-------------------------------------------------\n", Color.BLACK);
        displaySystemMessage("Flop: ", Color.BLACK);

        //For each of the cards, get the card and format it correctly.
        for (int i = 0; i < communityCards.size(); i++) {

            Card theCard = communityCards.get(i);

            //Hearts and Diamonds should be Red, Clubs and Spades should be black.
            if (theCard.getSuit() == Suit.Hearts || theCard.getSuit() == Suit.Diamonds) {
                displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
                displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.RED);
            } else {
                displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
                displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.BLACK);
            }
        }

        displaySystemMessage("\n", Color.BLACK);
    }

    /**
     * Displays the cards dealt on the Turn.
     */
    public void displayTurn() {

        displaySystemMessage("-------------------------------------------------\n", Color.BLACK);
        displaySystemMessage("Turn: ", Color.BLACK);

        //Get the turn card.
        Card theCard = communityCards.get(3);

        //Hearts and Diamonds should be Red, Clubs and Spades should be black.
        if (theCard.getSuit() == Suit.Hearts || theCard.getSuit() == Suit.Diamonds) {
            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.RED);
        } else {
            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.BLACK);
        }

        displaySystemMessage("\n", Color.BLACK);
    }

    /**
     * Displays the cards dealt on the River.
     */
    public void displayRiver() {

        displaySystemMessage("-------------------------------------------------\n", Color.BLACK);
        displaySystemMessage("River: ", Color.BLACK);

        //Get the river card.
        Card theCard = communityCards.get(4);

        //Hearts and Diamonds should be Red, Clubs and Spades should be black.
        if (theCard.getSuit() == Suit.Hearts || theCard.getSuit() == Suit.Diamonds) {
            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.RED);
        } else {
            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.BLACK);
        }

        displaySystemMessage("\n", Color.BLACK);
    }

    /**
     * Displays the hands that winners won with.
     * @param players
     * @param sharedCards
     * @param oneWinner 
     */
    public void displayWinners(ArrayList<Player> players, ArrayList<Card> communityCards, boolean oneWinner) {

        displaySystemMessage("-------------------------------------------------\n", Color.BLACK);

        for (int i = 0; i < players.size(); i++) {

            //Add the winnings for each player, after the pots have been split
            //we can find out the total amount the player won.
            int amount = players.get(i).addWinnings();

            //Players only win if they earnt more than $0 from the hand.
            if (amount > 0) {
                if (oneWinner == false) {

                    //Show that the player won.
                    players.get(i).setAction("WON $" + amount);
                    displayMessage(true, players.get(i).getName(), players.get(i));
                    displaySystemMessage(" Won $" + amount + " with " + players.get(i).getResult(communityCards) + ": ", Color.BLACK);

                    //Get the players hand result.
                    HandResult playerResult = players.get(i).getResult(communityCards);

                    //Display their best 5 card combination.
                    for (int j = 0; j < playerResult.getBestFive().size(); j++) {

                        Card theCard = playerResult.getBestFive().get(j);

                        //Hearts and Diamonds should be Red, Clubs and Spades should be black.
                        if (theCard.getSuit() == Suit.Hearts || theCard.getSuit() == Suit.Diamonds) {
                            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
                            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.RED);
                        } else {
                            displaySystemMessage(theCard.toString().substring(0, theCard.toString().length() - 1), Color.BLACK);
                            displaySystemMessage(Utilities.getSuit(theCard.getSuit()) + " ", Color.BLACK);
                        }
                    }

                    displaySystemMessage("\n", Color.BLACK);

                } else {
                    //If there was one winner, no need to show their cards.
                    players.get(i).setAction("WON $" + amount);
                    displayMessage(true, players.get(i).getName() + " Won $" + amount + "\n", players.get(i));
                }
            }
        }
        thePanel.repaint();
    }
}
