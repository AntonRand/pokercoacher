/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import Abstract.Game;
import Abstract.View;
import Data.User;
import Players.Player;
import Primitives.Deck;
import Tools.PaintTask;
import java.util.ArrayList;

/**
 * LessonGame Class
 * @author Anton
 */
public class LessonGame extends Game {

    public Deck d = null;

    public LessonGame(int startingChips, int numberOfPlayers, int difficulty, int blindSpeed, User userDetails, View thePanel) {

        //Call super constrctor
        super(startingChips, numberOfPlayers, blindSpeed, difficulty, userDetails, thePanel);
        setCurrentHand(new LessonHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), thePanel));

    }

    public LessonGame(int startingChips, int blindSpeed, User userDetails, View thePanel, ArrayList<Player> thePlayers, Deck d) {

        super(startingChips, blindSpeed, userDetails, thePanel, thePlayers);
        this.d = d;

        //If we have a predetermined deck, use it.
        if (d == null) {
            setCurrentHand(new LessonHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), thePanel));
        } else {
            setCurrentHand(new LessonHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), d, thePanel));
        }
    }

    public LessonGame(int startingChips, int blindSpeed, User userDetails, View thePanel, ArrayList<Player> thePlayers, Deck d, int dealerPosition) {

        super(startingChips, blindSpeed, userDetails, thePanel, thePlayers, dealerPosition);
        this.d = d;

        //If we have a predetermined deck, use it.
        if (d == null) {
            setCurrentHand(new LessonHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), thePanel));
        } else {
            setCurrentHand(new LessonHand(getGameDetails().getAllPlayers(), getBigBlind(), getDealer(), d, thePanel));
        }
    }

    @Override
    public void playGame() {

        //If there is already a game taking place, end it.
        if (gameThread != null) {
            gameThread.destroy();
        }

        //Create a new thread to play a game.
        gameThread = new Thread() {

            @Override
            public void run() {

                //Notice how LessonGames don't have blind times.
                //and only one hand takes place for each game.
                //Setup the repainter to repaint every 0.5 seconds.
                int handNumber = 1;
                setRepainter(new PaintTask(getPanel()));
                getScheduler().schedule(getRepainter(), 0, 500);

                //Display the current hand number.
                if (handNumber < 10) {
                    getCurrentHand().displayMessage(true, "--------------------- Hand " + handNumber + " ---------------------\n", null);
                } else if (handNumber >= 10 && handNumber < 100) {
                    getCurrentHand().displayMessage(true, "--------------------- Hand " + handNumber + " --------------------\n", null);
                } else {
                    getCurrentHand().displayMessage(true, "-------------------- Hand " + handNumber + " --------------------\n", null);
                }

                //Play the hand, as created in the constructor.
                getGameDetails().setAllPlayers(getCurrentHand().playHand());
            }
        };
        //Start the game.
        gameThread.start();
    }
}
