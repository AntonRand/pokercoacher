/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandLine;

import Abstract.Hand;
import Players.Player;
import Primitives.Card;
import Tools.Utilities;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Each Hand only contains players who are still in the game.
 * 
 * @author Anton
 */
public class CommandLineHand extends Hand {

    /**
     * Construct a new command line hand.
     * @param players, The players to be involved in the hand
     * @param bigBlind, The big blind amount
     * @param dealerPosition, The position of the dealer
     */
    public CommandLineHand(ArrayList<Player> players, int bigBlind, int dealerPosition) {
        //Call the super constructor.
        super(players, bigBlind, dealerPosition, null);
    }

    @Override
    public int determineAction(Player p, int currentBet, ArrayList<Card> boardCards) {
        //Find out how much the player needs to call to stay in the hand.
        int minBet = getHighestBet() - p.getAmountCalled();
        setAmountToCall(minBet);

        //Get the players Action
        int playerDecision = p.getAction(getHighestBet(), getCommunityCards(), getBigBlind());
        //We can determine what action the player has took based on the value returned


        //Fold Player if they clicked fold or didn't match the minimum to call amount.
        if (playerDecision == -1 || playerDecision < minBet) {
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Folded\n", Color.BLACK);
            return playerDecision;
        } else if (playerDecision == 0) {
            //If the player chose to check.
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Checked\n", Color.BLACK);
            return playerDecision;
        } else if (playerDecision == p.getChipBalance()) {
            //If the player went all in.
            p.bet(playerDecision);
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Went All In with $" + (p.getAmountCalled()) + "\n", Color.BLACK);
        } else if (playerDecision == minBet) {
            //If the player called.
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Called $" + playerDecision + "\n", Color.BLACK);
            p.bet(playerDecision);
            return playerDecision;
        } else if (playerDecision > minBet) {
            //If the player raised.
            p.bet(playerDecision);
            displayMessage(true, p.getName(), p);
            displaySystemMessage(" Raised to $" + (p.getAmountCalled()) + "\n", Color.BLACK);
            return playerDecision;
        }
        return playerDecision;
    }

    @Override
    public void displayMessage(boolean tab, String message, Player p) {
        //No need for clever formatting, just print the output out.
        System.out.print(message);
    }

    @Override
    public void displayStage(ArrayList<Card> cards) {
        //Displays the stage in a user friendly manner.
        //Shows what community cards have been dealt.
        if (cards == null) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("|\t\t\t\tNew Hand\t\t\t    |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("---------------------------------------------------------------------");
        } else if (cards.size() == 3) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                             Flop                                  |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("|\t\tBoard Cards: " + cards.get(0) + ", " + cards.get(1) + ", " + cards.get(2) + "\t\t\t    |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("---------------------------------------------------------------------");
        } else if (cards.size() == 4) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                             Turn                                  |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("|\t\tBoard Cards: " + cards.get(0) + ", " + cards.get(1) + ", " + cards.get(2) + ", " + cards.get(3) + "\t\t\t    |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("---------------------------------------------------------------------");
        } else if (cards.size() == 5) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                             River                                 |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("|\t\tBoard Cards: " + cards.get(0) + ", " + cards.get(1) + ", " + cards.get(2) + ", " + cards.get(3) + ", " + cards.get(4) + "\t\t    |");
            System.out.println("|\t\t\t\t\t\t\t\t    |");
            System.out.println("---------------------------------------------------------------------");
        }
    }

    @Override
    public void displaySystemMessage(String message, Color c) {
        //No need for clever formatting, just prints the message.
        System.out.print(message);
    }

    /**
     * Pre-flop Stage of hand, Essentially a basic version of FreeplayHand's proFlop method.
     */
    @Override
    public void preFlop() {

        //Print the information for the player to understand
        displayStage(null);

        setHighestBet(getBigBlind());

        postBlinds();

        //Set the players positions.
        int playerSize = getPlayersInvolved();
        int[] playerPositions = Utilities.getPositions(playerSize);
        int positionIndex = 0;


        for (int i = 0; i < getPlayers().size(); i++) {

            if (getPlayers().get(i).inGame()) {
                getPlayers().get(((getSmallBlindPosition() + i) % playerSize)).setPosition(playerPositions[positionIndex]);
                positionIndex++;
            } else if (getPlayers().get(i).allIn() && getPlayers().get(i).getOutLastHand() < 1) {
                getPlayers().get(((getSmallBlindPosition() + i) % playerSize)).setPosition(playerPositions[positionIndex]);
                positionIndex++;
            }
        }

        for (Player p : getPlayers()) {
            p.setPlayers(getPlayers());

        }

        int size = getPlayers().size();


        for (int i = 0; i < getPlayers().size(); i++) {
            //If there are more than one player in the hand we need to get the other players actions
            if (getPlayersInvolved() > 1) {
                //Allows one round of play where we start from the left of the...
                //BigBlind, who is in position + 2, therefore +3.
                if (getPlayers().get((i + getBigBlindPosition() + 1) % getPlayers().size()).allIn() == false && getPlayers().get((i + getBigBlindPosition() + 1) % getPlayers().size()).inHand() == true) {


                    // System.out.println("Determine Action: HighestBet = " + highestBet);
                    //Get the players bet and add it to the pot
                    int bet = determineAction(getPlayers().get((i + getBigBlindPosition() + 1) % size), getHighestBet(), getCommunityCards());


                    if (bet < 0) {
                        getPlayers().get((i + getBigBlindPosition() + 1) % size).fold();
                    } else {
                        addToPot(bet);
                    }

                    //bigBlindPosition NOT dealerPosition
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


        //If the hand has been called
        if (getPlayersInvolved() > 1) {
            setLastHandBet(getHighestBet());
           // try {
                //Thread.sleep(1000);
                calculatePots();
                flop();
           // } catch (InterruptedException ex) {
          //  }
        } else {
            paySingleWinner();
        }
    }

    /**
     * Flop stage of the hand, Essentially a basic version of FreeplayHand's flop method.
     */
    @Override
    public void flop() {


        int remainingPlayers = getPlayersInvolved();
        int potSize = getPotsTotal();


        resetMessages();
        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal the three cards
        getCommunityCards().add(getDeck().dealCard());
        getCommunityCards().add(getDeck().dealCard());
        getCommunityCards().add(getDeck().dealCard());

        displayFlop();

        //  displayMessage(true, sharedCards.get(0)., null);
        //Display the dealt cards through command line
        displayStage(getCommunityCards());

        //Get the actions 
        getPreflopActions();
        getActionsUntilCalled();

        //If the hand has been called
        if (getPlayersInvolved() > 1) {
            setLastHandBet(getHighestBet());
           // try {
          //      Thread.sleep(1000);
                calculatePots();
                turn();
         //   } catch (InterruptedException ex) {
         //   }
        } else {
            paySingleWinner();
        }
    }

    /**
     * Turn stage of the hand, Essentially a basic version of FreeplayHand's turn method.
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

        //If the hand has been called
        if (getPlayersInvolved() > 1) {
            setLastHandBet(getHighestBet());
         //   try {
         //       Thread.sleep(1000);
                calculatePots();
                river();
         //   } catch (InterruptedException ex) {
        //    }
        } else {
            paySingleWinner();
        }
    }

    /**
     * River (Final) stage of the hand, Essentially a basic version of FreeplayHand's river method.
     */
    @Override
    public void river() {
        int playersInitialBalance = getPlayers().get(0).getChipBalance();



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

         //   try {
         //       Thread.sleep(1000);
                calculatePots();
        //    } catch (InterruptedException ex) {
        //        System.out.println("Exception in CommandLineHand");
        //    }

            //No further stage so determing and pay the winners
            for (int i = 0; i < getPlayers().size(); i++) {
                if (getPlayers().get(i).inHand() == true) {
                    getPlayers().get(i).setShow(true);
                }
            }
            payWinners();
        } else {
            paySingleWinner();
        }
    }

    /**
     * Displays the winners through terminal in a user friendly way.
     * @param thePlayers, the players in the hand.
     * @param communityCards, the community cards on the board.
     * @param oneWinner, is there more than one winner.
     */
    @Override
    public void displayWinners(ArrayList<Player> thePlayers, ArrayList<Card> communityCards, boolean oneWinner) {

        //Display the summary in a user friendly way.
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             Summary                               |");
        System.out.println("|\t\t\t\t\t\t\t\t    |");

        //For each of the players.
        for (int i = 0; i < thePlayers.size(); i++) {
            int amount = thePlayers.get(i).addWinnings();
            
            //If they won an amount.
            if (amount > 0) {
                if (oneWinner == false) {
                    //If there were multiple winners they needed to reveal their cards.
                    displayMessage(true, thePlayers.get(i).getName() + " Won $" + amount + " with " + thePlayers.get(i).getResult(communityCards), null);
                } else {
                    //Otherwise just say how much the one winner won.
                    displayMessage(true, thePlayers.get(i).getName() + " Won $" + amount, null);
                }
            }
        }
        
        System.out.println("|\t\t\t\t\t\t\t\t    |");
        System.out.println("---------------------------------------------------------------------");
    }
}
