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
 * Contains the games used in Lesson 4.
 * @author Anton
 */
public class LessonFourGames {

    //Slow Play Test 1
    public static LessonGame getGameOne(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(50);
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(50);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(200);
        alan.add(200);
        alan.add(200);
        alan.add(400);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.ForceAction, 150));
        AnswerList check = new AnswerList(new Answer(Action.Check));
        AnswerList betOne = new AnswerList(new Answer(Action.ForceAction, 200));
        AnswerList betTwo = new AnswerList(new Answer(Action.ForceAction, 0));
        AnswerList betThree = new AnswerList(new Answer(Action.ForceAction, 200));
        AnswerList betFour = new AnswerList(new Answer(Action.ForceAction, 0));
        AnswerList betFive = new AnswerList(new Answer(Action.Call, 400));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(betOne));
        guiActions.add(new AllAnswers(betTwo));
        guiActions.add(new AllAnswers(betThree));
        guiActions.add(new AllAnswers(betFour));
        guiActions.add(new AllAnswers(betFive));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Slow Play Test 2
    public static LessonGame getGameTwo(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(3, Suit.Diamonds));
        deck.add(new Card(5, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.ForceAction, 0));
        AnswerList check = new AnswerList(new Answer(Action.Raise));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(check));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Slow Play Test 3
    public static LessonGame getGameThree(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(9, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(50);
        michael.add(0);
        michael.add(0);
        michael.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.ForceAction, 0));
        AnswerList check = new AnswerList(new Answer(Action.Check));
        ArrayList<AnswerList> accept = new ArrayList<AnswerList>();
        accept.add(new AnswerList(new Answer(Action.Raise)));
        accept.add(new AnswerList(new Answer(Action.Call)));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(accept));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Slow Play Test 4
    public static LessonGame getGameFour(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(9, Suit.Hearts));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(9, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(50);
        emily.add(50);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.ForceAction, 0));
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Fold)));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(acceptList));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Underbetting Test 1
    public static LessonGame getGameFive(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(13, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));
        //Community Cards
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> louise = new ArrayList<Integer>();
        louise.add(50);
        louise.add(0);
        louise.add(250);
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(50);
        andy.add(0);
        andy.add(250);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.ForceAction, 0));
        AnswerList check = new AnswerList(new Answer(Action.RaiseTo, 250));
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Fold)));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(check));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, louise));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Dead Zone Test
    public static LessonGame getGameSix(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(9, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
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
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(50);
        emily.add(200);
        ArrayList<Integer> ashley = new ArrayList<Integer>();

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList check = new AnswerList(new Answer(Action.AllIn));
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.AllIn)));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(fold));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 40, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 5);
    }

    //Red Zone Test
    public static LessonGame getGameSeven(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Hearts));
        //Community Cards
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(5, Suit.Hearts));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(6, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(200);
        michael.add(50);
        michael.add(100);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        alan.add(150);
        alan.add(50);
        alan.add(100);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList allIn = new AnswerList(new Answer(Action.AllIn));
        guiActions.add(new AllAnswers(allIn));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 200, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1240, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1250, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 2);
    }

    //Red Zone Test
    public static LessonGame getGameEight(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Diamonds));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(12, Suit.Hearts));
        //Community Cards
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(6, Suit.Diamonds));
        deck.add(new Card(5, Suit.Hearts));
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
        ArrayList<Integer> harry = new ArrayList<Integer>();
        harry.add(-1);
        andy.add(-1);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList raise = new AnswerList(new Answer(Action.Raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(raise));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 450, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 2250, 2, false, harry));
        players.add(new LessonPlayer("Michael", "Michaels", 8190, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 10500, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 900, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1250, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1700, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 1);
    }

    //Green Zone Test
    public static LessonGame getGameNine(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(13, Suit.Hearts));
        deck.add(new Card(10, Suit.Diamonds));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(5, Suit.Spades));
        deck.add(new Card(5, Suit.Hearts));
        //Community Cards
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(3, Suit.Diamonds));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(8, Suit.Spades));
        Deck d = new Deck(deck);

        ArrayList<Player> players = new ArrayList<Player>();

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.Call));
        AnswerList raise = new AnswerList(new Answer(Action.Raise));
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        AnswerList check = new AnswerList(new Answer(Action.Check));
        ArrayList<AnswerList> complete = new ArrayList<AnswerList>();
        complete.add(call);
        complete.add(raise);
        complete.add(fold);
        complete.add(check);
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(complete));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(fold));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2500, 1, thePanel));
        players.add(new AdvancedAIPlayer("Harry", "Richards", 1392, 2, 0));
        players.add(new AdvancedAIPlayer("Michael", "Michaels", 9012, 3, 0));
        players.add(new AdvancedAIPlayer("Andy", "Jones", 3319, 4, 0));
        players.add(new AdvancedAIPlayer("Louise", "Johnson", 1130, 5, 0));
        players.add(new AdvancedAIPlayer("Emily", "Mills", 1256, 6, 0));
        players.add(new AdvancedAIPlayer("Alan", "Murray", 5325, 7, 0));
        players.add(new AdvancedAIPlayer("Ashley", "Jeavons", 5454, 8, 0));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 1);
    }
}
