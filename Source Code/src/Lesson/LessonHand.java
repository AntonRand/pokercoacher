/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import Abstract.Hand;
import Abstract.View;
import Players.Player;
import Primitives.Card;
import Primitives.Deck;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;

/**
 * LessonHand Class
 * @author Anton
 */
public class LessonHand extends Hand {

    private ArrayList<Color> colors = new ArrayList<Color>();
    private Timer t = new Timer();
    private volatile boolean beginHand = false;

    /**
     * Constructs a Lesson Hand
     * @param players, the starting players in the game.
     * @param bigBlind, the current big blind
     * @param dealerPosition, the position of the dealer.
     * @param deck, the deck to use.
     * @param thePanel, the panel to paint with.
     */
    public LessonHand(ArrayList<Player> players, int bigBlind, int dealerPosition, Deck deck, View thePanel) {

        super(players, bigBlind, dealerPosition, deck, thePanel);
        setupColors();

        for (int i = 0; i < players.size(); i++) {
            players.get(i).setColor(colors.remove(0));
        }
    }

    /**
     * Constructs a Lesson Hand
     * @param players, the starting players in the game.
     * @param bigBlind, the current big blind
     * @param dealerPosition, the position of the dealer.
     * @param thePanel, the panel to paint with.
     */
    public LessonHand(ArrayList<Player> players, int bigBlind, int dealerPosition, View thePanel) {
        super(players, bigBlind, dealerPosition, thePanel);
        setPanel(thePanel);

        setupColors();

        for (int i = 0; i < players.size(); i++) {
            players.get(i).setColor(colors.remove(0));
        }

    }

    /**
     * List of colours.
     */
    private void setupColors() {
        colors.add(new Color(255, 0, 0));
        colors.add(new Color(0, 0, 160));
        colors.add(new Color(183, 65, 128));
        colors.add(new Color(255, 165, 0));
        colors.add(new Color(0, 128, 0));
        colors.add(new Color(59, 185, 255));
        colors.add(new Color(127, 70, 44));
        colors.add(new Color(115, 106, 255));
    }

    /**
     * Stops the timer from repainting/running.
     */
    public void cancelTimers() {
        t.cancel();
    }

    /**
     * After a hand has finished playing the timer is cancelled.
     * (Calls Super Method)
     * @return, the players after the hand.
     */
    @Override
    public ArrayList<Player> playHand() {

        //Set up as normal.
        LessonView theView = (LessonView) super.getPanel();

        try {
            theView.getCurrentMessage().setQuestionsAnsweredTally(0);
        } catch (Exception e) {
            System.out.println("Exception: Message Not Loaded");
        }

        resetMessages();
        dealCards();
        assignBlinds(getDealerPosition());

        //Wait till instructed to start.
        while (!beginHand) {
        }

        //Play the hand.
        preFlop();

        //When the hand has finished allow users to go to next hand.
        theView.enableNext();
        return super.getPlayers();
    }

    /**
     * Starts the hand.
     */
    public void start() {
        beginHand = true;
    }

    @Override
    public void preFlop() {

        //Assign and post the blinds.
        assignBlinds(getDealerPosition());
        postBlinds();
        //Print the information for the player to understand
        displayStage(null);

        setHighestBet(getBigBlind());

        //Minimum bet is the big blind at this stage.
        int size = getPlayers().size();


        for (int i = 0; i < getPlayers().size(); i++) {
            //If there is more than one player in the hand we need to get the other players actions
            if (getPlayersInvolved() > 1) {
                //Allows one round of play where we start from the left of the...
                //Big Blind.
                if (getPlayers().get((i + getBigBlindPosition() + 1) % getPlayers().size()).allIn() == false && getPlayers().get((i + getBigBlindPosition() + 1) % getPlayers().size()).inHand() == true) {

                    //Get the players bet and add it to the pot
                    int bet = determineAction(getPlayers().get((i + getBigBlindPosition() + 1) % size), getHighestBet(), getCommunityCards());
                    //If they bet less than 0, fold them.
                    if (bet < 0) {
                        getPlayers().get((i + getBigBlindPosition() + 1) % size).fold();
                    } else {
                        addToPot(bet);
                    }

                    //If they have raised then we should update the amount to call (highestBet)
                    if (((getPlayers().get((i + getBigBlindPosition() + 1) % size).getAmountCalled())) > getHighestBet()) {
                        setHighestBet(getPlayers().get((i + getBigBlindPosition() + 1) % size).getAmountCalled());
                        //If they haven't called the amount, and have entered 0 when they needed to call more
                        //that player is then folded so we don't take them into consideration next time.
                    } else if (bet == 0 && (getHighestBet() - (getPlayers().get((i + getBigBlindPosition() + 1) % size).getAmountCalled()) > 0)) {
                        getPlayers().get((i + getBigBlindPosition() + 1) % size).fold();
                    }
                }
            }
        }
        //Keep looping until all the players have matched each others bets
        getActionsUntilCalled();

        //If the bets have been matched.
        if (getPlayersInvolved() > 1) {
            setLastHandBet(getHighestBet());
            try {
                Thread.sleep(1000);
                calculatePots();
                //Proceed to flop.
                flop();
            } catch (InterruptedException ex) {
            }
        } else {
            //If there was a winner.
            paySingleWinner();
        }
    }

    /**
     * Flop stage of the hand
     */
    @Override
    public void flop() {


        resetMessages();

        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal the three cards
        getCommunityCards().add(getDeck().dealCard());
        getCommunityCards().add(getDeck().dealCard());
        getCommunityCards().add(getDeck().dealCard());

        displayFlop();
        //Display the dealt cards through command line
        displayStage(getCommunityCards());

        //Get the actions 
        getPreflopActions();
        getActionsUntilCalled();

        //If the bets have been matched.
        if (getPlayersInvolved() > 1) {
            setLastHandBet(getHighestBet());
            try {
                Thread.sleep(1000);
                calculatePots();
                //Proceed to turn.
                turn();
            } catch (InterruptedException ex) {
            }
        } else {
            //If there was a winner.
            paySingleWinner();
        }
    }

    /**
     * Turn stage of the hand
     */
    @Override
    public void turn() {

        resetMessages();

        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal next card
        getCommunityCards().add(getDeck().dealCard());

        displayTurn();

        //Display the dealt cards through command line
        displayStage(getCommunityCards());

        //Get the actions 
        getPreflopActions();
        getActionsUntilCalled();

        //If the bets have been matched.
        if (getPlayersInvolved() > 1) {

            setLastHandBet(getHighestBet());

            try {
                Thread.sleep(1000);
                calculatePots();
                //Proceed to river.
                river();
            } catch (InterruptedException ex) {
            }
        } else {
            //If there was a winner.
            paySingleWinner();
        }
    }

    /**
     * River (Final) stage of the hand
     */
    @Override
    public void river() {

        resetMessages();
        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal next card
        getCommunityCards().add(getDeck().dealCard());

        displayRiver();

        //Display the dealt cards through command line
        displayStage(getCommunityCards());

        //Get the actions 
        getPreflopActions();
        getActionsUntilCalled();

        //If the hand has been called
        if (getPlayersInvolved() > 1) {

            try {
                Thread.sleep(1000);
                calculatePots();
            } catch (InterruptedException ex) {
            }
            
            //No further stage so determine and pay the winners
            for (int i = 0; i < getPlayers().size(); i++) {
                if (getPlayers().get(i).inHand() == true) {
                    getPlayers().get(i).setShow(true);
                }
            }
            
            payWinners();
        } else {
            //If there was a winner.
            paySingleWinner();
        }
    }

    @Override
    public void displayStage(ArrayList<Card> cards) {
        getPanel().repaint();
    }

    @Override
    public void displaySystemMessage(String message, Color c) {
        getPanel().getDetails().append(c, message);
        getPanel().repaint();
    }
}
