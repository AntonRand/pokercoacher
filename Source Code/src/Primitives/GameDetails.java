/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import Abstract.View;
import Data.Statistics;
import Data.User;
import Players.*;
import Screens.ResultView;
import Tools.PlayerComparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.ho.yaml.Yaml;

/**
 * GameDetails Class.
 * @author Anton
 */
public class GameDetails {

    private ArrayList<Player> allPlayers = new ArrayList<Player>();
    private ArrayList<Player> eliminatedPlayers = new ArrayList<Player>();
    private int numberOfPlayers;
    private int dealer = 0;
    private int bigBlind = 50;
    private int difficulty = 0;
    private int startingChips;
    private User userDetails;
    private View thePanel;

    /**
     * Constructs a GameDetails class.
     * @param startingChips, the amount of starting chips for each player.
     * @param numberOfPlayers, the number of starting players.
     * @param difficulty, the game difficulty.
     * @param userDetails, the logged in user details.
     * @param thePanel, the panel to paint with.
     */
    public GameDetails(int startingChips, int numberOfPlayers, int difficulty, User userDetails, View thePanel) {
        this.startingChips = startingChips;
        this.numberOfPlayers = numberOfPlayers;
        this.userDetails = userDetails;
        this.thePanel = thePanel;
        this.difficulty = difficulty;
        initialisePlayers();
    }

    /**
     * Constructs a GameDetails class.
     * @param startingChips, the amount of starting chips for each player.
     * @param userDetails, the logged in user details.
     * @param thePanel, the panel to paint with.
     * @param thePlayers, the players in the game.
     */
    public GameDetails(int startingChips, User userDetails, View thePanel, ArrayList<Player> thePlayers) {
        this.startingChips = startingChips;
        this.numberOfPlayers = thePlayers.size();
        this.userDetails = userDetails;
        this.thePanel = thePanel;
        this.allPlayers = thePlayers;
    }

    /**
     * Constructs a GameDetails class.
     * @param startingChips, the amount of starting chips for each player.
     * @param userDetails, the logged in user details.
     * @param thePanel, the panel to paint with.
     * @param thePlayers, the players in the game.
     * @param dealerPosition, the dealer position.
     */
    public GameDetails(int startingChips, User userDetails, View thePanel, ArrayList<Player> thePlayers, int dealerPosition) {
        this.startingChips = startingChips;
        this.numberOfPlayers = thePlayers.size();
        this.userDetails = userDetails;
        this.thePanel = thePanel;
        this.allPlayers = thePlayers;
        this.dealer = dealerPosition;
    }

    /**
     * Sets up a list of players if no players constructed.
     */
    private void initialisePlayers() {

        ArrayList<String> forenames = getForenames();
        ArrayList<String> surnames = getSurnames();

        allPlayers.add(new GUIPlayer(userDetails.getForename(), userDetails.getSurname(), startingChips, 1, thePanel));

        ArrayList<Integer> difficulties = new ArrayList<Integer>();

        //Create random list of player difficulties.
        
        if (difficulty == 0) {
            //Easy
            if (numberOfPlayers > 6) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 5) {
                difficulties.add(0);
            }
            if (numberOfPlayers > 4) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 3) {
                difficulties.add(0);
            }
            if (numberOfPlayers > 2) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 1) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 0) {
                difficulties.add(0);
            }

        } else if (difficulty == 1) {
            //Normal
            if (numberOfPlayers > 6) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 5) {
                difficulties.add(0);
            }
            if (numberOfPlayers > 4) {
                difficulties.add(2);
            }
            if (numberOfPlayers > 3) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 2) {
                difficulties.add(2);
            }
            if (numberOfPlayers > 1) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 0) {
                difficulties.add(0);
            }
        } else if (difficulty == 2) {
            //Hard
            if (numberOfPlayers > 6) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 5) {
                difficulties.add(2);
            }
            if (numberOfPlayers > 4) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 3) {
                difficulties.add(2);
            }
            if (numberOfPlayers > 2) {
                difficulties.add(1);
            }
            if (numberOfPlayers > 1) {
                difficulties.add(2);
            }
            if (numberOfPlayers > 0) {
                difficulties.add(2);
            }
        }

        Collections.shuffle(difficulties);

        //Assign difficulties.
        for (int i = 0; i != numberOfPlayers; i++) {
            allPlayers.add(new AdvancedAIPlayer(forenames.remove(0), surnames.remove(0), startingChips, (Integer.parseInt(String.valueOf(i)) + 2), difficulties.get(i)));
        }
    }

    /**
     * @return, A list of forenames.
     */
    private ArrayList<String> getForenames() {
        ArrayList<String> forenames = new ArrayList<String>();
        forenames.add("Jack");
        forenames.add("Harry");
        forenames.add("Thomas");
        forenames.add("Alfie");
        forenames.add("Oliver");
        forenames.add("Emily");
        forenames.add("Grace");
        forenames.add("Lily");
        Collections.shuffle(forenames);
        return forenames;
    }

    /**
     * @return, A list of surnames.
     */
    private ArrayList<String> getSurnames() {
        ArrayList<String> surnames = new ArrayList<String>();
        surnames.add("Smith");
        surnames.add("Jones");
        surnames.add("Taylor");
        surnames.add("Williams");
        surnames.add("Brown");
        surnames.add("Davies");
        surnames.add("Edwards");
        surnames.add("Wilson");
        Collections.shuffle(surnames);
        return surnames;
    }

    public void rotateDealer() {
        dealer = ((dealer + 1) % (numberOfPlayers + 1));
    }

    public ArrayList<Player> getPlayers() {
        return allPlayers;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public void increaseBlind() {
        bigBlind = bigBlind * 2;
    }

    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(ArrayList<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public ArrayList<Player> getEliminatedPlayers() {
        return eliminatedPlayers;
    }

    //Set out of game players.
    public void setEliminatedPlayers(ArrayList<Player> outOfGamePlayers) {
        this.eliminatedPlayers = outOfGamePlayers;
    }

    public void displaySummary(JFrame masterFrame, JPanel currentPanel) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).inGame() == true) {
                eliminatedPlayers.add(allPlayers.get(i));
            }
        }

        Collections.reverse(eliminatedPlayers);
        ArrayList<String> userAchievements = new ArrayList<String>();

        if (allPlayers.get(0).equals(eliminatedPlayers.get(0))) {
            //Increase Career Winnings and Increase Tournaments Won.

            //Load List
            ArrayList<User> userList = new ArrayList<User>();

            try {
                userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
            } catch (Exception e) {
                System.out.println("Error, could not find data file.");
            }

            //Add Winnings and Increment Win Total.
            for (User user : userList) {
                if (user.getUsername().equals(userDetails.getUsername())) {

                    Statistics s = user.getStatistics();
                    s.setTournamentsWon(s.getTournamentsWon() + 1);
                    s.setTournamentWinnings(s.getTournamentWinnings() + (startingChips * allPlayers.size()));
                    userAchievements = user.getAchievements().getNewSummaryUnlocked(s);
                    userDetails = user;
                }
            }

            //Save List
            try {
                Yaml.dump(userList, new File("users.yml"));
            } catch (FileNotFoundException ex) {
                System.out.println("Could not change");
            }
        }

        //Show results screen.
        masterFrame.remove(currentPanel);
        masterFrame.add(new ResultView(masterFrame, userDetails, eliminatedPlayers, userAchievements));
        masterFrame.getComponent(0).validate();
    }

    public boolean gameOver() {

        int counter = 0;
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).inGame() == true) {
                counter++;
            }
        }
        if (counter == 1) {
            //If we have only counted 1 player in game, the game is over.
            return true;
        }
        return false;
    }

    public void removePlayers() {

        ArrayList<Player> outPlayers = new ArrayList<Player>();

        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).inGame() == false) {
                outPlayers.add(allPlayers.get(i));
                allPlayers.get(i).incrementHandsOut();
            }
        }

        Collections.sort(outPlayers, new PlayerComparator());

        for (int i = 0; i < outPlayers.size(); i++) {
            if (!eliminatedPlayers.contains(outPlayers.get(i))) {
                eliminatedPlayers.add(outPlayers.get(i));
            }
        }
    }

    public int getDealer() {
        return dealer;
    }
}
