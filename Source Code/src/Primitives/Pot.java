/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Players.Player;
import java.util.ArrayList;

/**
 * Pot Class.
 * @author Anton
 */
public class Pot {

    private int amountEach;
    private int potTotal = 0;
    private int total;
    private ArrayList<Player> playerList = new ArrayList<Player>();
    
    /**
     * Pot Constructor.
     * @param amountEach, the amount each player must commit to the pot.
     */
    public Pot(int amountEach) {
        this.amountEach = amountEach;
        potTotal += amountEach;
        total = potTotal;
    }

    /**
     * Pot Constructor.
     * @param amountEach, the amount each player must commit to the pot.
     * @param player, the player to add to the pot.
     */
    public Pot(int amountEach, Player player) {
        this.amountEach = amountEach;
        playerList.add(player);
        player.reduceAmountCalled(amountEach);
        potTotal += amountEach;
        total = potTotal;
    }

    /**
     * Add a player to the pot.
     * @param player, the player to add to the pot.
     */
    public void add(Player player) {
        playerList.add(player);
        player.reduceAmountCalled(amountEach);
        potTotal += amountEach;
        total = potTotal;
    }

    /**
     * Add an amount without adding a player.
     * @param i, the amount to add to the pot.
     */
    public void add(int i) {
        potTotal += i;
        total = potTotal;
    }

    /**
     * @return, the amount each player must commit to the pot.
     */
    public int getAmountEach() {
        return amountEach;
    }

    /**
     * @param p, the player to remove from the pot.
     */
    public void remove(Player p) {
        playerList.remove(p);
    }

    public ArrayList<Player> getPotPlayers() {
        return playerList;
    }

    public int getPotTotal() {
        return potTotal;
    }

    public int getTotal() {
        return total;
    }

    /**
     * @param p, the player to award the pot to.
     */
    public void awardToPlayer(Player p) {

        p.addWinnings(total);
        total = 0;
        potTotal = 0;
        playerList.clear();
    }

    /*
     * Splits the pot between the players.
     */
    public void splitPot() {

        double each = (potTotal * 1.0) / playerList.size();

        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).addWinnings((int) each);
            potTotal -= (int) each;
        }

        int amountLeft = potTotal;

        //If the amount cannot be split wholely, add the winnings to the player
        //with the strongest hole card.
        getStrongestCard().addWinnings(amountLeft);
        
        //Removes remainder from pot when winner of that remainder has been decided
        potTotal = 0;   
    }

    /**
     * @return, the player with the strongest card, deserving of unsplittable chips.
     */
    public Player getStrongestCard() {

        double highCardValue = 0;
        Player p = null;

        //Find player with highest value card.
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            if (playersHighestCard(player).highCardValue() > highCardValue) {
                p = playerList.get(i);
                highCardValue = playersHighestCard(p).highCardValue();
            }
        }
        return p;
    }

    /**
     * Returns the strongest hole card.
     */
    public Card playersHighestCard(Player p) {
        if (p.getCards()[0].highCardValue() > p.getCards()[1].highCardValue()) {
            return p.getCards()[0];
        } else {
            return p.getCards()[1];
        }
    }

    @Override
    public String toString() {
        String players = "";
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            players += "Name: " + p.getName() + ", Amount Committed: " + amountEach + "\n";

        }
        return players + "Total: " + total + "\n";
    }
}
