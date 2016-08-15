/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Abstract.View;
import Primitives.Card;
import java.util.ArrayList;

/**
 * GUIPlayer Class.
 * @author Anton
 */
public class GUIPlayer extends Player {

    private View thePanel;

    /**
     * Create a new GUIPlayer.
     * @param forename, the players forename.
     * @param surname, the players surname.
     * @param chipBalance, the starting chip balance.
     * @param guiPosition, their position.
     * @param thePanel, the panel to draw with.
     */
    public GUIPlayer(String forename, String surname, int chipBalance, int guiPosition, View thePanel) {
        super(forename, surname, chipBalance, guiPosition, true);
        this.thePanel = thePanel;
    }

    /**
     * Gets the players action.
     * @param amountToCall, the amount they need to call.
     * @param communityCards, the community cards.
     * @param bigBlind, the big blind.
     * @return the players action.
     */
    @Override
    public synchronized int getAction(int amountToCall, ArrayList<Card> communityCards, int bigBlind) {

        super.setPlayersTurn(true);

        thePanel.getCustomRaiseField().setText("");
        thePanel.updateButtons(amountToCall);

        //Wait for a decision to be made.
        while (super.getDecision() < -1) {

            //Stops overusage of CPU
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
        }

        //Set the decision and return it.
        int dec = super.getDecision();
        super.setPlayersTurn(false);
        return dec;
    }

    /**
     * @return, boolean representing if GUI player or not.
     */
    @Override
    public boolean guiPlayer() {
        return true;
    }

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
