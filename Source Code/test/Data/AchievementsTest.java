/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Tools.GameCalculations.HandResult;
import Tools.GameCalculations.HandComparer;
import Primitives.Suit;
import Primitives.Card;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class AchievementsTest {

    public AchievementsTest() {
    }

    @Test
    public void testgetNewLessonAchievements() {

        //Method tests the detection of the 4 lesson achievements.

        //Construct the Achievements and Statistics
        Achievements a = new Achievements();
        Statistics s = new Statistics();


        //Check that the user doesn't unlock anything initially.
        ArrayList<String> achievements = a.getNewLessonUnlocked(s);
        assertTrue(achievements.isEmpty());


        //User fails a test, check no achievements registered.
        s.setLessonOneScore(60);
        achievements = a.getNewLessonUnlocked(s);
        assertTrue(achievements.isEmpty());

        //User then passes the first test, check they unlock only 'Beginner'.
        s.setLessonOneScore(70);
        achievements = a.getNewLessonUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertEquals(achievements.get(0), "Beginner");

        assertTrue(a.isBeginner());
        assertFalse(a.isAmateur());
        assertFalse(a.isPro());
        assertFalse(a.isHundredPercent());

        //User passes second test, check no new achievements unlocked.
        s.setLessonTwoScore(70);
        achievements = a.getNewLessonUnlocked(s);
        assertTrue(achievements.isEmpty());

        assertTrue(a.isBeginner());
        assertFalse(a.isAmateur());
        assertFalse(a.isPro());
        assertFalse(a.isHundredPercent());

        //User passes third test, check they unlock only 'Amateur'.
        s.setLessonThreeScore(100);
        achievements = a.getNewLessonUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertEquals(achievements.get(0), "Amateur");

        //Check the achievements are still correct.
        assertTrue(a.isBeginner());
        assertTrue(a.isAmateur());
        assertFalse(a.isPro());
        assertFalse(a.isHundredPercent());

        //User passes fourth and fifth lesson, check no new achievements unlocked.
        s.setLessonFourScore(100);
        s.setLessonFiveScore(100);
        achievements = a.getNewLessonUnlocked(s);
        assertTrue(achievements.isEmpty());

        //Check state of achievements is correct.
        assertTrue(a.isBeginner());
        assertTrue(a.isAmateur());
        assertFalse(a.isPro());
        assertFalse(a.isHundredPercent());

        //User passes final lesson, check they unlock only 'Pro'.
        s.setLessonSixScore(100);
        achievements = a.getNewLessonUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertEquals(achievements.get(0), "Pro");

        assertTrue(a.isBeginner());
        assertTrue(a.isAmateur());
        assertTrue(a.isPro());
        assertFalse(a.isHundredPercent());

        //User gets 100% in the first 2 lessons, check they unlock the 100% achievment.
        s.setLessonOneScore(100);
        s.setLessonTwoScore(100);
        achievements = a.getNewLessonUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertEquals(achievements.get(0), "100%");

        assertTrue(a.isBeginner());
        assertTrue(a.isAmateur());
        assertTrue(a.isPro());
        assertTrue(a.isHundredPercent());

    }

    @Test
    public void testgetNewFreeplayAchievements() {

        //Method tests the detection of the 8 freeplay achievements.

        //Construct the Achievements and Statistics
        Achievements a = new Achievements();
        Statistics s = new Statistics();

        //Check that no initial achievements have been unlocked.
        assertFalse(a.isRoyalFlush());
        assertFalse(a.isStraightFlush());
        assertFalse(a.isFourOfAKind());
        assertFalse(a.isFullHouse());
        assertFalse(a.isFlush());
        assertFalse(a.isBluffer());
        assertFalse(a.isTightPlayer());
        assertFalse(a.isSlowPlayer());



        //Use the hand results from HandComparerTest.java
        ArrayList<Card> board = new ArrayList<Card>();
        Card[] players = new Card[2];

        //Construct a royal flush.
        board.add(new Card(10, Suit.Spades));
        board.add(new Card(11, Suit.Spades));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(13, Suit.Spades));
        board.add(new Card(14, Suit.Spades));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Diamonds);

        HandResult h = new HandComparer(players, board).compare();



        //Check that the user unlocks Royal Flush and Straight Flush.
        ArrayList<String> achievements = a.getNewFreeplayUnlocked(h, s);
        assertEquals(achievements.size(), 2);

        assertTrue(achievements.contains("Royal Flush"));
        assertTrue(achievements.contains("Straight Flush"));

        //Check that the other achievements are still false.
        assertTrue(a.isRoyalFlush());
        assertTrue(a.isStraightFlush());
        assertFalse(a.isFourOfAKind());
        assertFalse(a.isFullHouse());
        assertFalse(a.isFlush());
        assertFalse(a.isBluffer());
        assertFalse(a.isTightPlayer());
        assertFalse(a.isSlowPlayer());


        //Set up four of a kind.
        board = new ArrayList<Card>();
        players = new Card[2];

        board.add(new Card(10, Suit.Spades));
        board.add(new Card(10, Suit.Clubs));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(10, Suit.Hearts));
        board.add(new Card(10, Suit.Diamonds));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Diamonds);

        h = new HandComparer(players, board).compare();



        //Check that the user unlocks Four of a Kind.
        achievements = a.getNewFreeplayUnlocked(h, s);
        assertEquals(achievements.size(), 1);

        assertTrue(achievements.contains("Four of a Kind"));


        assertTrue(a.isRoyalFlush());
        assertTrue(a.isStraightFlush());
        assertTrue(a.isFourOfAKind());
        assertFalse(a.isFullHouse());
        assertFalse(a.isFlush());
        assertFalse(a.isBluffer());
        assertFalse(a.isTightPlayer());
        assertFalse(a.isSlowPlayer());




        //Set up a full house.
        board = new ArrayList<Card>();
        players = new Card[2];

        board.add(new Card(10, Suit.Spades));
        board.add(new Card(10, Suit.Clubs));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(10, Suit.Hearts));
        board.add(new Card(12, Suit.Diamonds));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Diamonds);

        h = new HandComparer(players, board).compare();



        //Check that the user unlocks Full House.
        achievements = a.getNewFreeplayUnlocked(h, s);
        assertEquals(achievements.size(), 1);

        assertTrue(achievements.contains("Full House"));


        assertTrue(a.isRoyalFlush());
        assertTrue(a.isStraightFlush());
        assertTrue(a.isFourOfAKind());
        assertTrue(a.isFullHouse());
        assertFalse(a.isFlush());
        assertFalse(a.isBluffer());
        assertFalse(a.isTightPlayer());
        assertFalse(a.isSlowPlayer());



        //Create a Flush Hand
        board = new ArrayList<Card>();
        players = new Card[2];

        board.add(new Card(10, Suit.Spades));
        board.add(new Card(4, Suit.Spades));
        board.add(new Card(12, Suit.Spades));
        board.add(new Card(9, Suit.Hearts));
        board.add(new Card(7, Suit.Spades));
        players[0] = new Card(07, Suit.Clubs);
        players[1] = new Card(02, Suit.Spades);

        h = new HandComparer(players, board).compare();



        //Check that the user unlocks Flush.
        achievements = a.getNewFreeplayUnlocked(h, s);
        assertEquals(achievements.size(), 1);

        assertTrue(achievements.contains("Flush"));


        assertTrue(a.isRoyalFlush());
        assertTrue(a.isStraightFlush());
        assertTrue(a.isFourOfAKind());
        assertTrue(a.isFullHouse());
        assertTrue(a.isFlush());
        assertFalse(a.isBluffer());
        assertFalse(a.isTightPlayer());
        assertFalse(a.isSlowPlayer());


        //Check that no additional unlocks when tested again.
        achievements = a.getNewFreeplayUnlocked(h, s);
        assertTrue(achievements.isEmpty());

        //Set the Tight Plays, Bluffs and Slow Plays to acceptable level.
        s.setTightPlays(5);
        s.setBluffs(5);
        s.setSlowPlays(5);

        achievements = a.getNewFreeplayUnlocked(h, s);
        assertEquals(achievements.size(), 3);

        //Check that the 3 achievements unlocked.
        assertTrue(achievements.contains("Bluffer"));
        assertTrue(achievements.contains("Tight Player"));
        assertTrue(achievements.contains("Slow Player"));

        //All achievements should now be unlocked.
        assertTrue(a.isRoyalFlush());
        assertTrue(a.isStraightFlush());
        assertTrue(a.isFourOfAKind());
        assertTrue(a.isFullHouse());
        assertTrue(a.isFlush());
        assertTrue(a.isBluffer());
        assertTrue(a.isTightPlayer());
        assertTrue(a.isSlowPlayer());

    }

    @Test
    public void testgetNewResultAchievements() {

        //Method tests the detection of the 4 lesson achievements.

        //Construct the Achievements and Statistics
        Achievements a = new Achievements();
        Statistics s = new Statistics();


        //Check that the user doesn't unlock anything initially.
        ArrayList<String> achievements = a.getNewSummaryUnlocked(s);
        assertTrue(achievements.isEmpty());

        //Check that no achievements have been unlocked.
        assertFalse(a.isFirstWin());
        assertFalse(a.isFifthWin());
        assertFalse(a.isTenThousand());
        assertFalse(a.isHundredThousand());
        assertFalse(a.isMillion());

        //User wins their first tournament.
        s.setTournamentsWon(1);
        achievements = a.getNewSummaryUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertTrue(achievements.contains("First Win"));

        achievements = a.getNewSummaryUnlocked(s);
        assertTrue(achievements.isEmpty());

        //Check that achievement recognised.
        assertTrue(a.isFirstWin());
        assertFalse(a.isFifthWin());
        assertFalse(a.isTenThousand());
        assertFalse(a.isHundredThousand());
        assertFalse(a.isMillion());

        //User wins their fifth tournament.
        s.setTournamentsWon(5);
        achievements = a.getNewSummaryUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertTrue(achievements.contains("Fifth Win"));

        //Check that achievement recognised.
        assertTrue(a.isFirstWin());
        assertTrue(a.isFifthWin());
        assertFalse(a.isTenThousand());
        assertFalse(a.isHundredThousand());
        assertFalse(a.isMillion());

        //User makes $10,000 earnings.
        s.setTournamentWinnings(10000);

        achievements = a.getNewSummaryUnlocked(s);
        assertEquals(achievements.size(), 1);
        assertTrue(achievements.contains("$10,000"));

        //Check that achievement recognised.
        assertTrue(a.isFirstWin());
        assertTrue(a.isFifthWin());
        assertTrue(a.isTenThousand());
        assertFalse(a.isHundredThousand());
        assertFalse(a.isMillion());

        //User makes $1 Million earnings, check that achievement's unlocked.
        s.setTournamentWinnings(1000000);

        achievements = a.getNewSummaryUnlocked(s);
        assertEquals(achievements.size(), 2);
        assertTrue(achievements.contains("$100,000"));
        assertTrue(achievements.contains("Millionaire"));

        assertTrue(a.isFirstWin());
        assertTrue(a.isFifthWin());
        assertTrue(a.isTenThousand());
        assertTrue(a.isHundredThousand());
        assertTrue(a.isMillion());


    }

    @Test
    public void testTotalUnlocked() {

        Achievements a = new Achievements();

        //Check that it is correctly counting the amount of unlocked achievements.
        assertEquals(a.totalUnlocked(), 0);

        //Set all to be true.
        a.setAll(true);
        assertEquals(a.totalUnlocked(), 18);


        a.setFourOfAKind(false);
        a.setBeginner(false);
        a.setFlush(false);

        assertEquals(a.totalUnlocked(), 15);

    }
}
