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
 * Contains the games used in Lesson 5.
 * @author Anton
 */
public class LessonFiveGames {

    //Scenario 1
    public static LessonGame getGameOne(User userDetails, View thePanel) {

        //Creates the Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(10, Suit.Diamonds));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(3, Suit.Diamonds));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> louise = new ArrayList<Integer>();
        louise.add(50);
        louise.add(50);
        louise.add(400);
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(50);
        emily.add(50);
        emily.add(400);
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();

        //Setup Test Conditions
        AnswerList raiseOne = new AnswerList(new Answer(Action.ForceAction, 50));
        AnswerList raiseTwo = new AnswerList(new Answer(Action.ForceAction, 200));
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(raiseTwo));
        guiActions.add(new AllAnswers(fold));

                //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, louise));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Scenario 2
    public static LessonGame getGameTwo(User userDetails, View thePanel) {

        //Creates the Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        //Community Cards
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(9, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(50);
        emily.add(100);


        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList raiseOne = new AnswerList(new Answer(Action.ForceAction, 100));
        AnswerList fold = new AnswerList(new Answer(Action.Raise));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(fold));

               //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 3);
    }

    //Scenario 3
    public static LessonGame getGameThree(User userDetails, View thePanel) {

        //Creates the Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(8, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        //Community Cards
        deck.add(new Card(13, Suit.Spades));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(9, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(50);
        ArrayList<Integer> louise = new ArrayList<Integer>();
        louise.add(25);
        louise.add(50);
        louise.add(50);
        louise.add(150);


        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList raiseOne = new AnswerList(new Answer(Action.ForceAction, 50));
        AnswerList call = new AnswerList(new Answer(Action.Call));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(call));

                //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, louise));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 3);
    }

    //Scenario 4
    public static LessonGame getGameFour(User userDetails, View thePanel) {

        //Creates the Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        //Community Cards
        deck.add(new Card(13, Suit.Spades));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(9, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(50);
        ArrayList<Integer> louise = new ArrayList<Integer>();
        louise.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList raiseOne = new AnswerList(new Answer(Action.ForceAction, 25));
        AnswerList call = new AnswerList(new Answer(Action.Raise));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(call));

                //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, louise));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 7);
    }

    //Scenario 5
    public static LessonGame getGameFive(User userDetails, View thePanel) {

        //Creates the Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(8, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        //Community Cards
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(13, Suit.Diamonds));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> harry = new ArrayList<Integer>();
        harry.add(100);
        harry.add(100);
        harry.add(100);
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(100);
        michael.add(100);
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(100);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(75);
        alan.add(0);
        alan.add(100);
        alan.add(0);
        alan.add(100);
        alan.add(100);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList raiseOne = new AnswerList(new Answer(Action.ForceAction, 100));
        AnswerList call = new AnswerList(new Answer(Action.Call));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(raiseOne));
        guiActions.add(new AllAnswers(call));

                //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, harry));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 5);
    }
}
