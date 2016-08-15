/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Content.Games;

import Abstract.View;
import Data.User;
import Lesson.*;
import Lesson.Assessment.Action;
import Lesson.Assessment.AllAnswers;
import Lesson.Assessment.Answer;
import Lesson.Assessment.AnswerList;
import Players.*;
import Primitives.*;
import java.util.ArrayList;

/**
 * Contains the games used in Lesson 3.
 * @author axr712
 */
public class LessonThreeGames {

    //Test Yourself 1
    public static LessonGame getGameOne(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(3, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(11, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(3, Suit.Clubs));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> michaelActions = new ArrayList<Integer>();
        michaelActions.add(0);
        michaelActions.add(150);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 50));
        Answer fold = new Answer(Action.Fold);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, michaelActions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 2
    public static LessonGame getGameTwo(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(11, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(9, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> callerOne = new ArrayList<Integer>();
        callerOne.add(50);
        callerOne.add(150);
        callerOne.add(50);
        callerOne.add(50);
        ArrayList<Integer> callerTwo = new ArrayList<Integer>();
        callerTwo.add(50);
        callerTwo.add(0);
        ArrayList<Integer> callerThree = new ArrayList<Integer>();
        callerThree.add(50);
        callerThree.add(150);
        callerThree.add(50);
        callerThree.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 0));
        Answer check = new Answer(Action.Check);
        AnswerList allActions = new AnswerList(check);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(allActions));
        guiActions.add(new AllAnswers(firstAction));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, callerOne));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, callerTwo));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, callerThree));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Test Yourself 3
    public static LessonGame getGameThree(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(11, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> callerOne = new ArrayList<Integer>();
        callerOne.add(0);
        ArrayList<Integer> callerTwo = new ArrayList<Integer>();
        callerTwo.add(50);
        callerTwo.add(0);
        ArrayList<Integer> callerThree = new ArrayList<Integer>();
        callerThree.add(50);
        callerThree.add(0);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 50));
        Answer bluff = new Answer(Action.BluffBounds);
        AnswerList allActions = new AnswerList(bluff);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, callerThree));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 4
    public static LessonGame getGameFour(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(5, Suit.Spades));
        //Community Cards
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> callerOne = new ArrayList<Integer>();
        callerOne.add(25);
        ArrayList<Integer> callerThree = new ArrayList<Integer>();
        callerThree.add(50);
        ArrayList<Integer> callerFour = new ArrayList<Integer>();
        callerFour.add(50);
        ArrayList<Integer> callerFive = new ArrayList<Integer>();
        callerFive.add(50);
        ArrayList<Integer> callerSix = new ArrayList<Integer>();
        callerSix.add(50);
        ArrayList<Integer> callerSeven = new ArrayList<Integer>();
        callerSeven.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 50));
        Answer fold = new Answer(Action.Fold);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, callerOne));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, callerThree));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, callerFour));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, callerFive));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, callerSix));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, callerSeven));

        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 5
    public static LessonGame getGameFive(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(7, Suit.Hearts));
        //Community Cards
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> callerOne = new ArrayList<Integer>();
        callerOne.add(25);
        callerOne.add(150);
        callerOne.add(50);
        ArrayList<Integer> callerTwo = new ArrayList<Integer>();
        callerTwo.add(0);
        callerTwo.add(150);
        callerTwo.add(50);
        callerTwo.add(500);
        ArrayList<Integer> callerThree = new ArrayList<Integer>();
        callerThree.add(50);
        callerThree.add(150);
        ArrayList<Integer> callerFour = new ArrayList<Integer>();
        callerFour.add(50);
        callerFour.add(150);
        callerFour.add(50);
        ArrayList<Integer> callerFive = new ArrayList<Integer>();
        callerFive.add(50);
        callerFive.add(150);
        callerFive.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 50));
        AnswerList secondAction = new AnswerList(new Answer(Action.ForceAction, 150));
        Answer fold = new Answer(Action.Fold);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(secondAction));
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, callerOne));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, callerTwo));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, callerThree));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, callerFour));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, callerFive));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));

        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 6
    public static LessonGame getGameSix(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(7, Suit.Hearts));
        //Community Cards
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(8, Suit.Diamonds));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(5, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> callerOne = new ArrayList<Integer>();
        callerOne.add(25);
        callerOne.add(50);
        ArrayList<Integer> callerTwo = new ArrayList<Integer>();
        callerTwo.add(0);
        ArrayList<Integer> callerThree = new ArrayList<Integer>();
        callerThree.add(50);
        ArrayList<Integer> callerFour = new ArrayList<Integer>();
        callerFour.add(50);
        callerFour.add(50);
        callerFour.add(0);
        callerFour.add(-1);
        ArrayList<Integer> callerFive = new ArrayList<Integer>();
        callerFive.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList firstAction = new AnswerList(new Answer(Action.ForceAction, 50));
        AnswerList secondAction = new AnswerList(new Answer(Action.ForceAction, 50));
        Answer fold = new Answer(Action.BluffBounds);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(firstAction));
        guiActions.add(new AllAnswers(secondAction));
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, callerOne));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, callerTwo));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, callerThree));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, callerFour));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, callerFive));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));

        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }
}
