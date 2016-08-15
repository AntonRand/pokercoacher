/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import CommandLine.CommandLineHand;
import Players.Player;
import Players.AIPlayer;
import Players.AdvancedAIPlayer;
import java.util.ArrayList;

/**
 *
 * @author Anton
 */
public class CommandLineGame {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> finalPosition = new ArrayList<Player>();
    private int handNumber = 1;

    /**
     * Create a new command line game.
     * @param players, The players in the game
     * @param bigBlind, Initial Big blind
     * @param dealer, Initial Dealer
     */
    public CommandLineGame(ArrayList<Player> players, int bigBlind, int dealer) {

        this.players = players;

        //Keep playing new hands until game over condition reached.
        while (gameOver() != true) {

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).inGame() == false) {
                    //Display when players are out of the game.
                    System.out.println("\t" + players.get(i).getName() + " Out, Position: " + (players.size() - finalPosition.size()));
                    finalPosition.add(players.remove(i));
                }
            }
            
            //Display the hand number.
            System.out.println("\n\n\nHand " + handNumber);

            //Creates a new hand until game over detected.
            players = new CommandLineHand(players, bigBlind, dealer).playHand();
            dealer++;
            handNumber++;
        }

        //Show when the last player is out.
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inGame() == false) {
                //Display when final player is out.
                System.out.println("\t" + players.get(i).getName() + " Out, Position: " + (players.size() - finalPosition.size() + 1));
                finalPosition.add(players.remove(i));
            }
        }

        //Display who the winner is
        System.out.println("Game Over, Winner Is: " + players.get(0).getName());
        System.out.println(players.get(0).getChipBalance());
    }

    /**
     * @return True if the game is over otherwise false.
     */
    public boolean gameOver() {

        int counter = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).inGame() == true) {
                counter++;
            }
        }
        if (counter == 1) {
            //If we have only counted 1 player in game, the game is over.
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new AdvancedAIPlayer("Michael", "Rand", 1500, 1, 2));
        players.add(new AIPlayer("Anton", "Rand", 1500, 2, 2));

        CommandLineGame game = new CommandLineGame(players, 50, 1);
    }
}
