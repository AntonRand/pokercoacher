/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Primitives.Card;
import java.util.ArrayList;

/**
 * LessonPlayerClass.
 * @author Anton
 */
public class LessonPlayer extends Player {

    private ArrayList<Integer> actions;

    /**
     * Construct a new AIPlayer
     * @param forename, Players first name
     * @param surname, Players surname
     * @param chipBalance, Players starting balance
     */
    public LessonPlayer(String forename, String surname, int chipBalance, int guiPosition, boolean showCards, ArrayList<Integer> actions) {
        super(forename, surname, chipBalance, guiPosition, showCards);
        this.actions = actions;
    }

    /**
     * Get the players action.
     * @param amountToCall, the amount to call
     * @param boardCards, the cards on the table
     * @param bigBlind, the big blind, useful for min raising
     * @return the players action
     */
    @Override
    public int getAction(int amountToCall, ArrayList<Card> boardCards, int bigBlind) {

        try {
            super.setPlayersTurn(true);
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
        }

        //Wait while paused.
        while (super.isPaused() == true) {
        }

        super.setPlayersTurn(false);

        if (actions.size() > 0) {
            int result = actions.remove(0);
            if (result == -1) {
                if (amountToCall > super.getChipBalance()) {
                    return super.getChipBalance();
                } else {
                    return amountToCall - super.getAmountCalled();
                }
            } else {
                return result;
            }

        } else {
            return 0;
        }
    }

    /**
     * Allows players to be sorted depending on the amount of chips committed (Ascending)
     * @param t, the player object to compare against
     * @return, integer representing more than, equal to or less than
     */
    @Override
    public int compareTo(Object t) {
        if (super.getAmountCalled() > ((Player) t).getAmountCalled()) {
            return -1;
        } else if (this.getAmountCalled() == ((Player) t).getAmountCalled()) {
            return 0;
        } else {
            return 1;
        }
    }
}
