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
 * Contains the games used in Lesson 1.
 * @author Anton
 */
public class LessonOneGames {

    //Default Hand
    public static LessonGame getGameOne(User userDetails, View thePanel, int dealerPosition) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(3, Suit.Clubs));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(5, Suit.Clubs));
        deck.add(new Card(6, Suit.Clubs));
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(9, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(5, Suit.Spades));
        deck.add(new Card(6, Suit.Spades));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(8, Suit.Spades));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);

        //Create Players
        players.add(new LessonPlayer(userDetails.getForename(), userDetails.getSurname(), 1000, 1, true, actions));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, dealerPosition);
    }

    //Edge Cases - All In
    public static LessonGame getGameTwo(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(14, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> emilyActions = new ArrayList<Integer>();
        emilyActions.add(100);
        emilyActions.add(200);
        emilyActions.add(600);
        emilyActions.add(356);
        ArrayList<Integer> davidActions = new ArrayList<Integer>();
        davidActions.add(100);
        davidActions.add(400);
        davidActions.add(400);
        davidActions.add(1000);

                //Create Players
        players.add(new LessonPlayer("David", "Smith", 2500, 1, true, davidActions));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, true, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, true, actions));
        players.add(new LessonPlayer("Andy", "Jones", 239, 4, true, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1352, 5, true, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, true, emilyActions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, true, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, true, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d);
    }

    //Edge Cases - All In Posting Blind
    public static LessonGame getGameThree(User userDetails, View thePanel, int dealerPosition) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(14, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(11, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> emilyActions = new ArrayList<Integer>();
        emilyActions.add(100);
        emilyActions.add(200);
        emilyActions.add(600);
        emilyActions.add(356);
        ArrayList<Integer> davidActions = new ArrayList<Integer>();
        davidActions.add(100);
        davidActions.add(400);
        davidActions.add(400);
        davidActions.add(1000);

        //Create Players
        players.add(new LessonPlayer("David", "Smith", 2500, 1, true, davidActions));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, true, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, true, actions));
        players.add(new LessonPlayer("Andy", "Jones", 239, 4, true, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 10, 5, true, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, true, emilyActions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, true, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, true, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, dealerPosition);
    }

    //Edge Cases - Dead Blind
    public static LessonGame getGameFour(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(14, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(11, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> emilyActions = new ArrayList<Integer>();
        emilyActions.add(100);
        emilyActions.add(200);
        emilyActions.add(600);
        emilyActions.add(356);
        ArrayList<Integer> davidActions = new ArrayList<Integer>();
        davidActions.add(100);
        davidActions.add(400);
        davidActions.add(400);
        davidActions.add(1000);

        //Create Players
        players.add(new LessonPlayer("David", "Smith", 2500, 1, false, davidActions));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 239, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 10, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, emilyActions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 3);
    }

    //Edge Cases - Dead Blind 2
    public static LessonGame getGameFive(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(7, Suit.Clubs));
        deck.add(new Card(3, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(6, Suit.Hearts));
        deck.add(new Card(12, Suit.Spades));
        deck.add(new Card(4, Suit.Clubs));
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(2, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(13, Suit.Clubs));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(14, Suit.Diamonds));
        //Community Cards
        deck.add(new Card(11, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(14, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> emilyActions = new ArrayList<Integer>();
        emilyActions.add(100);
        emilyActions.add(200);
        emilyActions.add(600);
        emilyActions.add(356);
        ArrayList<Integer> davidActions = new ArrayList<Integer>();
        davidActions.add(100);
        davidActions.add(400);
        davidActions.add(400);
        davidActions.add(1000);

        //Create Players
        players.add(new LessonPlayer("David", "Smith", 2500, 1, false, davidActions));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 239, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 10, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, emilyActions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, actions));


        players.get(5).setChipBalance(0);
        players.get(5).resetValues();
        players.get(5).incrementHandsOut();
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 4);
    }

    //Edge Cases - High Card
    public static LessonGame getGameSix(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(7, Suit.Diamonds));
        deck.add(new Card(2, Suit.Clubs));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(14, Suit.Clubs));
        deck.add(new Card(9, Suit.Hearts));
        deck.add(new Card(10, Suit.Diamonds));
        deck.add(new Card(2, Suit.Spades));
        deck.add(new Card(4, Suit.Diamonds));
        deck.add(new Card(6, Suit.Diamonds));
        deck.add(new Card(5, Suit.Hearts));
        deck.add(new Card(3, Suit.Diamonds));
        deck.add(new Card(3, Suit.Clubs));
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(13, Suit.Diamonds));
        deck.add(new Card(2, Suit.Hearts));
        deck.add(new Card(3, Suit.Spades));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Hearts));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> andyActions = new ArrayList<Integer>();
        andyActions.add(250);
        andyActions.add(0);
        andyActions.add(0);
        andyActions.add(50);
        ArrayList<Integer> louiseActions = new ArrayList<Integer>();
        louiseActions.add(250);
        louiseActions.add(0);
        louiseActions.add(50);
        
        //Create Players
        players.add(new LessonPlayer("David", "Smith", 2500, 1, true, actions));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, true, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, true, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, true, andyActions));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, true, louiseActions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, true, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, true, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, true, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 1
    public static LessonGame getGameSeven(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        //Community Cards
        deck.add(new Card(7, Suit.Hearts));
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> harry = new ArrayList<Integer>();
        harry.add(50);
        harry.add(0);
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(50);
        andy.add(0);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        alan.add(0);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(25);
        ashley.add(100);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList check = new AnswerList(new Answer(Action.Check));
        AnswerList fold = new AnswerList(new Answer(Action.Fold));
        ArrayList<AnswerList> acceptList = new ArrayList<AnswerList>();
        acceptList.add(new AnswerList(new Answer(Action.Call)));
        acceptList.add(new AnswerList(new Answer(Action.Raise)));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(fold));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2500, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, harry));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Test Yourself 2
    public static LessonGame getGameEight(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(13, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        //Community Cards
        deck.add(new Card(10, Suit.Hearts));
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> michael = new ArrayList<Integer>();
        michael.add(50);
        michael.add(0);
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(50);
        andy.add(0);
        ArrayList<Integer> emily = new ArrayList<Integer>();
        emily.add(25);
        emily.add(0);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(50);
        ashley.add(50);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        alan.add(100);

                //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.Call));
        AnswerList raise = new AnswerList(new Answer(Action.RaiseTo, 150));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(raise));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2500, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, michael));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, emily));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 4);
    }

    //Test Yourself 3
    public static LessonGame getGameNine(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(8, Suit.Spades));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(7, Suit.Spades));
        deck.add(new Card(8, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        //Community Cards
        deck.add(new Card(4, Suit.Hearts));
        deck.add(new Card(8, Suit.Diamonds));
        deck.add(new Card(4, Suit.Spades));
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(10, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        ArrayList<Integer> harry = new ArrayList<Integer>();
        harry.add(50);
        harry.add(0);
        ArrayList<Integer> andy = new ArrayList<Integer>();
        andy.add(50);
        andy.add(0);
        ArrayList<Integer> alan = new ArrayList<Integer>();
        alan.add(50);
        alan.add(0);
        ArrayList<Integer> ashley = new ArrayList<Integer>();
        ashley.add(25);
        ashley.add(100);
        ashley.add(200);
        ashley.add(100);
        ashley.add(100);
        ashley.add(100);

                //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList check = new AnswerList(new Answer(Action.Check));
        AnswerList raise = new AnswerList(new Answer(Action.RaiseTo, 300));
        AnswerList betOne = new AnswerList(new Answer(Action.ForceAction, 100));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(betOne));
        guiActions.add(new AllAnswers(betOne));
        guiActions.add(new AllAnswers(betOne));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 2500, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, harry));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, alan));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, ashley));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 6);
    }

    //Test Yourself 4
    public static LessonGame getGameTen(User userDetails, View thePanel) {


        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(10, Suit.Clubs));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(14, Suit.Hearts));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(12, Suit.Hearts));
        deck.add(new Card(1, Suit.Clubs));
        deck.add(new Card(1, Suit.Hearts));
        deck.add(new Card(1, Suit.Diamonds));
        deck.add(new Card(11, Suit.Spades));
        deck.add(new Card(1, Suit.Spades));
        //Community Cards
        deck.add(new Card(11, Suit.Hearts));
        deck.add(new Card(13, Suit.Spades));
        deck.add(new Card(11, Suit.Clubs));
        deck.add(new Card(14, Suit.Spades));
        deck.add(new Card(11, Suit.Diamonds));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);
        ArrayList<Integer> andy = new ArrayList<Integer>();
        ArrayList<Integer> louise = new ArrayList<Integer>();
        louise.add(50);
        louise.add(0);
        louise.add(0);
        louise.add(200);
        louise.add(600);
        louise.add(150);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        AnswerList call = new AnswerList(new Answer(Action.Call));
        AnswerList check = new AnswerList(new Answer(Action.Check));
        AnswerList raise = new AnswerList(new Answer(Action.RaiseTo, 200));
        AnswerList betOne = new AnswerList(new Answer(Action.RaiseTo, 750));
        guiActions.add(new AllAnswers(call));
        guiActions.add(new AllAnswers(check));
        guiActions.add(new AllAnswers(raise));
        guiActions.add(new AllAnswers(betOne));

        //Create Players
        players.add(new GUILessonPlayer("David", "Smith", guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1392, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 9012, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 3319, 4, false, andy));
        players.add(new LessonPlayer("Louise", "Johnson", 1130, 5, false, louise));
        players.add(new LessonPlayer("Emily", "Mills", 1256, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 5325, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 5454, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 1);
    }
}
