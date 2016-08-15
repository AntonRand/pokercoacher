/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.GameCalculations;

import Players.Player;

/**
 * PlayerResult Class.
 * @author Anton
 */
public class PlayerResult {

    private Player player;
    private HandResult handResult;

    /**
     * PlayerResult Constructor, represents a player and their result.
     * @param player, the player.
     * @param handResult, the players hand.
     */
    public PlayerResult(Player player, HandResult handResult) {

        this.player = player;
        this.handResult = handResult;

    }

    public HandResult getHandResult() {
        return handResult;
    }

    public Player getPlayer() {
        return player;
    }
}
