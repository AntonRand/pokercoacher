/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Freeplay;

import Abstract.Hand;
import Abstract.View;
import Data.User;
import Players.Player;
import Primitives.Card;
import Primitives.Stage;
import Tools.GameCalculations.HandComparer;
import Tools.GameCalculations.HandResult;
import Tools.Utilities;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import org.ho.yaml.Yaml;

/**
 * FreeplayHand Class
 * 
 * JYAML load and save code took from website API.
 * @author Anton
 */
public class FreeplayHand extends Hand {

    private ArrayList<Color> colors = new ArrayList<Color>();
    private Timer t = new Timer();
    private HandResult checkAchievementHand;

    /**
     * Constructs a new FreeplayHand.
     * @param players, the players from the game.
     * @param bigBlind, the value of the big blind.
     * @param dealerPosition, the position of the dealer.
     * @param thePanel, the panel to paint on.
     */
    public FreeplayHand(ArrayList<Player> players, int bigBlind, int dealerPosition, View thePanel) {


        super(players, bigBlind, dealerPosition, thePanel);
        setPanel(thePanel);

        //Setup the player colours.
        setupColors();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setColor(colors.remove(0));
        }
    }

    /**
     * List of player colours.
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
        ArrayList<Player> players = super.playHand();
        t.cancel();
        return players;
    }

    /**
     * Method of displaying system messages for freeplay hands.
     * @param message, the message to display.
     * @param c, the colour to use.
     */
    @Override
    public void displaySystemMessage(String message, Color c) {
        getPanel().getDetails().append(c, message);
        getPanel().repaint();
    }

    /**
     * Repaints the screen so the dealt community cards are visible.
     * @param cards 
     */
    @Override
    public void displayStage(ArrayList<Card> cards) {
        //Repaint relevant section.
        getPanel().repaint(313, 250, 260, 90);
    }

    /**
     * Pre-flop Stage of hand
     */
    @Override
    public void preFlop() {

        //Set up the hand.
        displayStage(null);
        setHighestBet(getBigBlind());
        postBlinds();

        //Set the players positions.
        int playerSize = getPlayersInvolved();
        int[] playerPositions = Utilities.getPositions(playerSize);
        int positionIndex = 0;

        //Set the players positions.
        for (int i = 0; i < getPlayers().size(); i++) {
            if (getPlayers().get(i).inGame()) {
                getPlayers().get(((getSmallBlindPosition() + i) % playerSize)).setPosition(playerPositions[positionIndex]);
                positionIndex++;
            } else if (getPlayers().get(i).allIn() && getPlayers().get(i).getOutLastHand() < 1) {
                getPlayers().get(((getSmallBlindPosition() + i) % playerSize)).setPosition(playerPositions[positionIndex]);
                positionIndex++;
            }
        }

        //Let the players know about the other players states.
        for (Player p : getPlayers()) {
            p.setPlayers(getPlayers());
        }

        //Display the strength of the users hand.
        displayStrength();

        int size = getPlayers().size();

        //If the user is in the hand, update their statistics.
        if (getPlayers().get(0).inGame()) {
            increaseHandsDealt();
        }


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
                System.out.println("FreeplayHand: Interrupted Exception");
            }
        } else {
            //If there was a winner.
            //Update Statistics and pay them.
            if (getPlayers().get(0).inHand()) {
                increaseHandsWon(Stage.Preflop);
            }
            paySingleWinner();
        }
    }

    /**
     * Flop stage of the hand
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
        //Display the dealt cards through command line
        displayStage(getCommunityCards());

        displayStrength();

        //If the player is still in the hand, they have seen the flop.
        if (getPlayers().get(0).inHand() == true) {
            increaseFlopsSeen();
            //Record their flop hand.
            checkAchievementHand = new HandComparer(getPlayers().get(0).getCards(), getCommunityCards()).compare();
        }

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
                System.out.println("FreeplayHand: Interrupted Exception 2");
            }
        } else {
            //If there was a winner.
            if (getPlayers().get(0).inHand()) {
                increaseHandsWon(Stage.Flop);
                checkForBluff(remainingPlayers, potSize, checkAchievementHand);
            }
            //Pay them winnings.
            paySingleWinner();
        }
    }

    /**
     * Turn stage of the hand
     */
    @Override
    public void turn() {

        int remainingPlayers = getPlayersInvolved();
        int potSize = getPotsTotal();

        resetMessages();
        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal next card
        getCommunityCards().add(getDeck().dealCard());
        displayTurn();

        HandResult turnHand = new HandComparer(getPlayers().get(0).getCards(), getCommunityCards()).compare();

        //Display the dealt cards through command line
        displayStage(getCommunityCards());
        displayStrength();

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
                System.out.println("FreeplayHand: Interrupted Exception 3");
            }
        } else {
            //If there was a winner.
            //Update Statistics and pay them.
            if (getPlayers().get(0).inHand()) {
                increaseHandsWon(Stage.Turn);
                checkForBluff(remainingPlayers, potSize, turnHand);
            }
            paySingleWinner();
        }
    }

    /**
     * River (Final) stage of the hand
     */
    @Override
    public void river() {

        int remainingPlayers = getPlayersInvolved();
        int potSize = getPotsTotal();

        int playersInitialBalance = getPlayers().get(0).getChipBalance();

        resetMessages();
        //Players are allowed to check at any stage after pre-flop
        setHighestBet(0);

        //Deal next card
        getCommunityCards().add(getDeck().dealCard());

        displayRiver();
        HandResult riverHand = new HandComparer(getPlayers().get(0).getCards(), getCommunityCards()).compare();

        //Display the dealt cards through command line
        displayStage(getCommunityCards());
        displayStrength();


        //Get the actions 
        getPreflopActions();
        getActionsUntilCalled();

        //If the bets have been matched.
        if (getPlayersInvolved() > 1) {
            try {
                ArrayList<String> newAchievements = updateData();

                //Check if they have unlocked any new achievements.
                if (!newAchievements.isEmpty()) {
                    FreeplayView panel = (FreeplayView) super.getPanel();
                    panel.addAchievements(newAchievements);
                }
                Thread.sleep(1000);
                calculatePots();
            } catch (InterruptedException ex) {
                System.out.println("Exception in FreeplayHand 4");
            }

            //No further stage so determine and pay the winners
            for (int i = 0; i < getPlayers().size(); i++) {
                if (getPlayers().get(i).inHand() == true) {
                    getPlayers().get(i).setShow(true);
                }
            }


            int playerAmount = getPlayers().get(0).getChipBalance();

            payWinners();

            //If the player won, update statistics and check for new
            //achievements.
            if (getPlayers().get(0).getChipBalance() > playerAmount) {
                increaseHandsWon(Stage.Showdown);
                ArrayList<String> newAchievements = updateData();
                if (!newAchievements.isEmpty()) {
                    FreeplayView panel = (FreeplayView) super.getPanel();
                    panel.addAchievements(newAchievements);
                }
            }
        } else {
            //If only one player left.
            //Update statistics.
            if (getPlayers().get(0).inHand()) {
                increaseHandsWon(Stage.River);
                checkForBluff(remainingPlayers, potSize, riverHand);
            }

            paySingleWinner();
        }

        int endBalance = getPlayers().get(0).getChipBalance();

        //If the player won.
        if (playersInitialBalance < endBalance) {
            checkForTightOrSlowPlay();
        }
    }

    //Checks for best hand
    public ArrayList<String> updateData() {

        ArrayList<String> newAchievements = new ArrayList<String>();

        //If user is in the hand
        if (getPlayers().get(0).inHand() == true) {

            //Calculate users current hand.
            HandResult currentHand = new HandComparer(getPlayers().get(0).getCards(), getCommunityCards()).compare();

            //Load List - Took from YAML API
            ArrayList<User> userList = new ArrayList<User>();

            try {
                userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
            } catch (Exception e) {
                System.out.println("Error, could not find data file....");
            }

            boolean update = false;
            User userDetails = getPanel().getUserDetails();

            //Alter Users Best Hand, If better.
            for (User user : userList) {

                //Get the logged in user.
                if (user.getUsername().equals(userDetails.getUsername())) {

                    //Get their strongest hand.
                    String hand = user.getStatistics().getStrongestHand();

                    //If the hand was better than their historical best, update.
                    if (hand == null) {
                        update = true;
                        user.getStatistics().setStrongestHand(currentHand.getStringRepresentation());
                        getPanel().setUserDetails(user);
                    } else {
                        HandResult bestHand = new HandComparer(Utilities.parseHand(hand)).compare();
                        if (Utilities.getBestHand(currentHand, bestHand) != null && Utilities.getBestHand(currentHand, bestHand).equals(currentHand)) {
                            update = true;
                            user.getStatistics().setStrongestHand(currentHand.getStringRepresentation());
                            getPanel().setUserDetails(user);
                        }
                    }

                    //Check for new achievements.
                    newAchievements = user.getAchievements().getNewFreeplayUnlocked(currentHand, user.getStatistics());
                }
            }

            //If changes to user class were made, save to file.
            if (update == true || newAchievements.size() > 0) {
                //Save List
                try {
                    Yaml.dump(userList, new File("users.yml"));
                } catch (FileNotFoundException ex) {
                    System.out.println("Could not change");
                }
            }
        }
        return newAchievements;
    }

    //Checks for Tight Plays and Slow Plays
    public void checkForTightOrSlowPlay() {

        boolean increaseTightPlays = false;
        boolean increaseSlowPlays = false;

        //CHECKS FOR HIGH VALUED CONNECTED CARDS

        //If they won with high valued connected cards.
        if (getPlayers().get(0).getCards()[0].getValue() >= 10 && getPlayers().get(0).getCards()[1].getValue() >= 10) {
            //Update high value connected cards value.
            increaseTightPlays = true;
        }


        //CHECKS FOR SLOW PLAY
        ArrayList<String> actions = getPlayers().get(0).getActions();

        //If they didn't raise or go all in.
        if (!actions.contains("Raised") && !actions.contains("All In")) {
            //But they called at least twice, meaning someone must of raised.
            if (actions.contains("Called")) {
                actions.remove("Called");
                if (actions.contains("Called")) {
                    //And they had a strong hand from the flop.
                    if (checkAchievementHand.getHandCategory() > 2) {
                        increaseSlowPlays = true;
                    }
                }
            }
        }

        if (increaseSlowPlays || increaseTightPlays) {
            //Load List
            ArrayList<User> userList = new ArrayList<User>();

            try {
                userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
            } catch (Exception e) {
                System.out.println("Error, could not find data file....");
            }

            User userDetails = getPanel().getUserDetails();

            for (User user : userList) {
                if (user.getUsername().equals(userDetails.getUsername())) {

                    if (increaseTightPlays) {

                        user.getStatistics().setTightPlays(user.getStatistics().getTightPlays() + 1);
                    }

                    if (increaseSlowPlays) {
                        user.getStatistics().setSlowPlays(user.getStatistics().getSlowPlays() + 1);
                    }
                    getPanel().setUserDetails(user);
                }
            }

            //Save List
            try {
                Yaml.dump(userList, new File("users.yml"));
            } catch (FileNotFoundException ex) {
                System.out.println("Could not change");
            }
        }
    }

    public void increaseHandsDealt() {

        //Load List
        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file....");
        }

        User userDetails = getPanel().getUserDetails();

        for (User user : userList) {

            if (user.getUsername().equals(userDetails.getUsername())) {
                //Increase Hands Dealt.
                user.getStatistics().setHandsDealt(user.getStatistics().getHandsDealt() + 1);
                getPanel().setUserDetails(user);
            }
        }

        //Save List
        try {
            Yaml.dump(userList, new File("users.yml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not change");
        }
    }

    public void increaseFlopsSeen() {

        //Load List
        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file....");
        }

        User userDetails = getPanel().getUserDetails();

        for (User user : userList) {

            if (user.getUsername().equals(userDetails.getUsername())) {
                //Increase Flops Seen
                user.getStatistics().setFlopsSeen(user.getStatistics().getFlopsSeen() + 1);
                getPanel().setUserDetails(user);
            }
        }

        //Save List
        try {
            Yaml.dump(userList, new File("users.yml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not change");
        }
    }

    public void increaseHandsWon(Stage s) {

        //Load List
        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file....");
        }

        User userDetails = getPanel().getUserDetails();

        for (User user : userList) {
            if (user.getUsername().equals(userDetails.getUsername())) {

                //Increase hands won at correct stage.
                if (s.equals(Stage.Preflop)) {
                    user.getStatistics().setPreflopsWon(user.getStatistics().getPreflopsWon() + 1);

                } else if (s.equals(Stage.Flop)) {
                    user.getStatistics().setFlopsWon(user.getStatistics().getFlopsWon() + 1);

                } else if (s.equals(Stage.Turn)) {
                    user.getStatistics().setTurnsWon(user.getStatistics().getTurnsWon() + 1);

                } else if (s.equals(Stage.River)) {
                    user.getStatistics().setRiversWon(user.getStatistics().getRiversWon() + 1);

                } else if (s.equals(Stage.Showdown)) {
                    user.getStatistics().setShowdownsWon(user.getStatistics().getShowdownsWon() + 1);

                } else {
                    getPanel().setUserDetails(user);
                }
            }
        }

        //Save List
        try {
            Yaml.dump(userList, new File("users.yml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not change");
        }
    }

    public void checkForBluff(int remainingPlayers, int potSize, HandResult hand) {

        //If the player won the hand.
        //If there were 3 or less players in the hand.
        //They bet the right amount for a bluff
        //They only had a high card.
        if (remainingPlayers <= 3) {
            if (getPlayers().get(0).getAmountCalled() >= (0.5 * potSize)) {
                if (getPlayers().get(0).getAmountCalled() < potSize) {
                    if (hand.getHandCategory() == 1) {
                        //Bluff = true.
                        //Load List
                        ArrayList<User> userList = new ArrayList<User>();

                        try {
                            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
                        } catch (Exception e) {
                            System.out.println("Error, could not find data file....");
                        }

                        User userDetails = getPanel().getUserDetails();

                        for (User user : userList) {

                            if (user.getUsername().equals(userDetails.getUsername())) {

                                user.getStatistics().setBluffs(user.getStatistics().getBluffs() + 1);
                                getPanel().setUserDetails(user);
                            }
                        }

                        //Save List
                        try {
                            Yaml.dump(userList, new File("users.yml"));
                        } catch (FileNotFoundException ex) {
                            System.out.println("Could not change");
                        }
                    }
                }
            }
        }
    }

    public void displayStrength() {

        //Finds the strength of a players cards.
        FreeplayView theView = (FreeplayView) getPanel();
        if (getPlayers().get(0).inHand() && !theView.isStrengthCollapsed()) {
            Utilities.updateStrength(this, theView.getStrengthPane());
        }
    }
}
