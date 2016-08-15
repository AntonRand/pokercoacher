/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Primitives.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * CommandLinePlayer Class.
 * @author Anton
 */
public class CommandLinePlayer extends Player {

    /**
     * Construct a new CommandLinePlayer
     * @param forename, Players firstname
     * @param surname, Players surname
     * @param chipBalance, Players starting balance
     */
    public CommandLinePlayer(String forename, String surname, int chipBalance, int guiPosition) {
        super(forename, surname, chipBalance, guiPosition, true);
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

        //Print Hand Information for player
        System.out.print("\n\t********************Your Turn************************"
                + "\n\t*\t          Name: " + super.getName() + "\t            *"
                + "\n\t*\t          Your Cards: " + super.getCards()[0] + ", " + super.getCards()[1] + "\t            *"
                + "\n\t*\t          Chip Balance: " + super.getChipBalance() + "\t            *"
                + "\n\t*\t          Amount to call: " + (amountToCall) + "\t            *\n"
                + "\t*****************************************************"
                + "\n\tEnter Action: ");


        //Create a buffered reader to read in input
        BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
        int action = -1;

        try {

            //Try to parse action into an integer
            String value = bk.readLine();

            if (value.matches("q") || value.matches("quit") || value.matches("Quit")) {
                System.exit(0);
            } else {
                action = Integer.parseInt(value);
            }

            //Don't allow negative values
            if (action < 0) {
                System.out.println("You must enter a positive Value\n\n");
                return getAction(amountToCall, boardCards, bigBlind);
            } else if (amountToCall == 0) {
                //If the user has raised by less than the big blind
                if (action != 0 && action < bigBlind) {
                    System.out.println("Minimum Raise: " + bigBlind + "\n\n");
                    return getAction(amountToCall, boardCards, bigBlind);
                }
                //User can always enter 0 to check or fold
            } else if (action == 0) {
                return action;
                //If the user matches a raise
            } else if ((action + super.getAmountCalled()) == amountToCall) {
                return action;
                //If the action puts the player all in
            } else if (action == super.getChipBalance()) {
                return action;
                //If player calls more than their balance
            } else if (amountToCall > super.getChipBalance() && action != super.getChipBalance()) {
                System.out.println("You must go all in to call this bet\n\n");
                return getAction(amountToCall, boardCards, bigBlind);
                //If the player calls an amount but it is less than the required amount
            } else if (action < amountToCall && action != 0 && action != super.getChipBalance()) {
                System.out.println("You haven't called the required amount\n\n");
                return getAction(amountToCall, boardCards, bigBlind);
                //If the user raises less than double the amount to call
            } else if (action > amountToCall && (action < amountToCall * 2 && action < super.getChipBalance())) {
                System.out.println("Minimum raise is 2 Times Current Bet or All In\n\n");
                return getAction(amountToCall, boardCards, bigBlind);
            } else if (action > super.getChipBalance()) {
                //If the user doesn't call by enough chips
                System.out.println("Insufficient Amount\n\n");
                return getAction(amountToCall, boardCards, bigBlind);
            }
        } catch (IOException ex) {
            //If there was trouble reading the input re-request input
            System.out.println("Invalid Action, Please Try again\n\n");
            return getAction(amountToCall, boardCards, bigBlind);
        } catch (NumberFormatException ex) {
            //If the value couldn't be parsed (because the player didn't enter an integer) display
            //error message and re-request input
            System.out.println("You didn't enter a number!\n\n");
            return getAction(amountToCall, boardCards, bigBlind);
        }
        System.out.println("\t*****************************************************");
        return action;
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
