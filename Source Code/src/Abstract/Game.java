/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

import Data.User;
import Tools.PaintTask;
import Primitives.GameDetails;
import Players.Player;
import java.util.ArrayList;
import java.util.Timer;

/**
 * 
 * Super class for representing poker games.
 * 
 * 
 * @author Anton
 */
public abstract class Game {

    public Thread gameThread;
    private int blindTimeRemaining;
    private Hand currentHand;
    private View thePanel;
    private PaintTask repainter;
    private GameDetails gameDetails;
    private Timer scheduler = new Timer();

    /**
     * Construct a new Game Instance
     * @param startingChips, Each Players Starting Amount
     * @param numberOfPlayers, The number of players
     * @param difficulty, the AI player difficulty
     * @param blindSpeed, the speed of the blinds.
     * @param userDetails, the logged in users details.
     * @param thePanel, the game panel.
     */
    public Game(int startingChips, int numberOfPlayers, int difficulty, int blindSpeed, User userDetails, View thePanel) {

        gameDetails = new GameDetails(startingChips, numberOfPlayers, difficulty, userDetails, thePanel);

        this.thePanel = thePanel;
        this.blindTimeRemaining = 2 + (2 * blindSpeed);

    }

    /**
     * Construct a new Game Instance
     * @param startingChips, Each Players Starting Amount
     * @param blindSpeed, the speed of the blinds.
     * @param userDetails, the logged in users details.
     * @param thePanel, the game panel.
     * @param thePlayers, the players in the game.
     * @param dealerPosition, the starting position of the dealer
     */
    public Game(int startingChips, int blindSpeed, User userDetails, View thePanel, ArrayList<Player> thePlayers, int dealerPosition) {

        gameDetails = new GameDetails(startingChips, userDetails, thePanel, thePlayers, dealerPosition);
        this.thePanel = thePanel;
        this.blindTimeRemaining = 2 + (2 * blindSpeed);

    }

    /**
     * Construct a new Game Instance
     * @param startingChips, Each Players Starting Amount
     * @param blindSpeed, the speed of the blinds.
     * @param userDetails, the logged in users details.
     * @param thePanel, the game panel.
     * @param thePlayers, the players in the game.
     */
    public Game(int startingChips, int blindSpeed, User userDetails, View thePanel, ArrayList<Player> thePlayers) {

        gameDetails = new GameDetails(startingChips, userDetails, thePanel, thePlayers);
        this.thePanel = thePanel;
        this.blindTimeRemaining = 2 + (2 * blindSpeed);

    }

    public abstract void playGame();

    public View getPanel() {
        return thePanel;
    }

    public GameDetails getGameDetails() {
        return gameDetails;
    }

    public PaintTask getRepainter() {
        return repainter;
    }

    public Hand getCurrentHand() {
        return currentHand;
    }

    public int getDealer() {
        return gameDetails.getDealer();
    }

    public Timer getScheduler() {
        return scheduler;
    }

    public int getBlindSpeed() {
        return blindTimeRemaining;
    }

    /*
     * Returns the list of all players originally involved in the game.
     */
    public ArrayList<Player> getPlayers() {
        return getGameDetails().getPlayers();
    }

    /**
     * @return, The value of the current big blind.
     */
    public int getBigBlind() {
        return getGameDetails().getBigBlind();
    }

    public void setScheduler(Timer t) {
        scheduler = t;
    }

    public void setRepainter(PaintTask p) {
        repainter = p;
    }

    public void setCurrentHand(Hand p) {
        currentHand = p;
    }

    /**
     * Stops the thread and timer, so that the game doesn't continue
     * once a player quits.
     */
    public void stopThread() {
        scheduler.cancel();
        scheduler = new Timer();
        gameThread.stop();
    }

    //Used to check if the game is over, if it is no need
    //to play another hand.
    public boolean gameOver() {
        return gameDetails.gameOver();
    }
}
