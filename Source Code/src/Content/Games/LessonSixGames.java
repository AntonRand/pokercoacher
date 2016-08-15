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
 * Contains the games used in Lesson 6.
 * @author Anton
 */
public class LessonSixGames {

    //Test Yourself 1 - Under the gun, Strong Cards
    public static LessonGame getGameOne(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Hearts));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(11, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(-1);
        emily.add(-1);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(-1);
        ashley.add(-1);
        ashley.add(-1);
        ashley.add(-1);
        ashley.add(-1);
        ashley.add(-1);
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(-1);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Call)));
        acceptList.add(new AnswerList(new Answer(Action.Raise)));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1235, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 5);

    }

    //Test Yourself 2 - Under the gun, Average Cards
    public static LessonGame getGameTwo(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(11, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(-1);
        emily.add(-1);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(-1);
        ashley.add(100);
        ashley.add(200);
        ashley.add(-1);
        ashley.add(-1);
        ashley.add(-1);
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(-1);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        guiActions.add(new AllAnswers(fold));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1235, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 5);

    }

    //Test Yourself 3 - Late Position, Average Cards
    public static LessonGame getGameThree(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(9, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(9, Suit.Spades));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(9, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(-1);
        andy.add(-1);
        andy.add(-1);
        andy.add(-1);
        andy.add(-1);
        andy.add(-1);
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(-1);
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Call)));
        acceptList.add(new AnswerList(new Answer(Action.Raise)));

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 3440, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 4 - Under the gun, Strong Cards
    public static LessonGame getGameFour(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(9, Suit.Spades));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(9, Suit.Clubs));

        //Create Player Actions
        Deck d = new Deck(deck);
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(-1);
        andy.add(200);
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(-1);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        guiActions.add(new AllAnswers(new AnswerList(new Answer(Action.Fold))));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 3440, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 5 - Middle Position, Strong Cards
    public static LessonGame getGameFive(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(11, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(-1);
        ArrayList<Integer> harry = new ArrayList<Integer>();
        harry.add(-1);
        harry.add(-1);

        //Setup Test Conditions
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Call)));
        acceptList.add(new AnswerList(new Answer(Action.Raise)));
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));
        guiActions.add(new AllAnswers(acceptList));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2190, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, harry));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 3);
    }

    //Test Yourself 6 - Middle Position, Average Cards
    public static LessonGame getGameSix(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Hearts));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(11, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(250);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        guiActions.add(new AllAnswers(fold));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2310, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 3);
    }
}
