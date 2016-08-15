/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Freeplay;

import Abstract.Game;
import Abstract.View;
import Data.User;
import Tools.PaintTask;
import java.util.Timer;

/**
 * FreeplayGame class
 * @author Anton
 */
public class FreeplayGame extends Game {

    public FreeplayGame(int startingChips, int numberOfPlayers, int difficulty, int blindSpeed, User userDetails, View thePanel) {
        super(startingChips, numberOfPlayers, difficulty, blindSpeed, userDetails, thePanel);
    }

    @Override
    public void playGame() {
        gameThread = new Thread() {

            @Override
            public void run() {

                //Start the timer and set the hand to be first.
                setScheduler(new Timer());
                int handNumber = 1;

                //Setup the repainter to repaint every 0.5 seconds.
                setRepainter(new PaintTask(getPanel(), (getBlindSpeed() * 60000)));
                getScheduler().schedule(getRepainter(), 0, 500);

                //Play the game until a winner is found.
                while (gameOver() != true) {
                    
                    //Check for Blind Increases.
                    if (getRepainter().blindsIncreased() == true) {
                        getCurrentHand().displayMessage(true, "Blinds have been increased to " + getGameDetails().getBigBlind() + "/" + (getBigBlind() / 2) + "\n", null);
                        getRepainter().increaseAcknowledged();
                    }
                    
                    //Create a new hand.
                    setCurrentHand(new FreeplayHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), getPanel()));

                    //Display the current hand number.
                    if (handNumber < 10) {
                        getCurrentHand().displayMessage(true, "--------------------- Hand " + handNumber + " ---------------------\n", null);
                    } else if (handNumber >= 10 && handNumber < 100) {
                        getCurrentHand().displayMessage(true, "--------------------- Hand " + handNumber + " --------------------\n", null);
                    } else {
                        getCurrentHand().displayMessage(true, "-------------------- Hand " + handNumber + " --------------------\n", null);
                    }

                    //Play the hand and rotate the dealer ready for next hand.
                    getGameDetails().setAllPlayers(getCurrentHand().playHand());
                    getGameDetails().removePlayers();
                    getGameDetails().rotateDealer();
                    handNumber++;
                }
                
                //When the game is over, cancel the timer.
                getScheduler().cancel();

                if (gameOver() == true) {
                    FreeplayView thePanel = (FreeplayView) getPanel();
                    
                    //Wait for all the achievements to be displayed
                    while (!thePanel.allAchievementsDisplayed()) {
                    }
                    //Show the players final positions.
                    getGameDetails().removePlayers();
                    getGameDetails().displaySummary(getPanel().getMasterFrame(), getPanel());
                }
            }
        };
        //Start the game.
        gameThread.start();
    }
}
