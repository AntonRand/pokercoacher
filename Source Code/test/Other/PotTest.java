/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Primitives.Suit;
import Primitives.Card;
import CommandLine.CommandLineHand;
import Primitives.Pot;
import Players.LessonPlayer;
import Players.Player;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class PotTest {

    public PotTest() {
    }

    @Test
    public void testPot() {

        //Create Some Players.
        ArrayList<Player> players = new ArrayList<Player>();

        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(100);

        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(200);

        ArrayList<Integer> three = new ArrayList<Integer>();
        three.add(300);

        ArrayList<Integer> four = new ArrayList<Integer>();
        four.add(400);



        players.add(new LessonPlayer("Alex", "Smith", 100, 0, false, one));

        //Set their cards.
        players.get(0).dealFirstCard(new Card(14, Suit.Clubs));
        players.get(0).dealSecondCard(new Card(10, Suit.Spades));


        players.add(new LessonPlayer("Ben", "Hughes", 200, 1, false, two));

        players.get(1).dealFirstCard(new Card(13, Suit.Diamonds));
        players.get(1).dealSecondCard(new Card(9, Suit.Hearts));

        players.add(new LessonPlayer("Chris", "Beckham", 300, 2, false, three));
        players.add(new LessonPlayer("Daniel", "Jones", 400, 3, false, four));


        //Create a pot. Add first player to it.
        Pot p = new Pot(100, players.get(0));

        assertTrue(p.getAmountEach() == 100);
        assertTrue(p.getTotal() == 100);

        //Add 201, unattributed to any player.
        p.add(201);

        assertTrue(p.getTotal() == 301);
        //Add another player.
        p.add(players.get(1));

        assertTrue(p.getTotal() == 401);
        //Split the pot.
        p.splitPot();

        assertTrue(p.getPotTotal() == 0);


        //Check that the player took their share and the extra chip.
        players.get(0).addWinnings();
        assertTrue(players.get(0).getChipBalance() == 301);

        //Check that the player took their share.
        players.get(1).addWinnings();
        assertTrue(players.get(1).getChipBalance() == 400);

    }
}
