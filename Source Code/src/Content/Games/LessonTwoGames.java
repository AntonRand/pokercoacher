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
 * Contains the games used in Lesson 2.
 * @author axr712
 */
public class LessonTwoGames {

    //Test Yourself 1
    public static LessonGame getGameOne(User userDetails, View thePanel) {

        ArrayList<Card> deck = new ArrayList<Card>();

        int highPair = 4;

        //Generate Deck
        Deck newDeck = new Deck();
        newDeck.remove(new Card(highPair, Suit.Clubs));
        newDeck.remove(new Card(highPair, Suit.Spades));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(highPair, Suit.Clubs));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(highPair, Suit.Spades));
        //Community Cards
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        Answer fold = new Answer(Action.Fold);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
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
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(14, Suit.Spades));
        cards.add(new Card(14, Suit.Clubs));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(12, Suit.Clubs));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(13, Suit.Diamonds));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(3, Suit.Hearts));
        cards.add(new Card(14, Suit.Hearts));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(12, Suit.Hearts));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(1, Suit.Clubs));
        cards.add(new Card(13, Suit.Clubs));
        //Community Cards
        cards.add(new Card(6, Suit.Spades));
        cards.add(new Card(11, Suit.Clubs));
        cards.add(new Card(11, Suit.Diamonds));
        cards.add(new Card(10, Suit.Spades));
        cards.add(new Card(14, Suit.Diamonds));

        Deck d = new Deck(cards);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        Answer call = new Answer(Action.Call);
        Answer raise = new Answer(Action.Raise);
        ArrayList<Answer> acceptableList = new ArrayList<Answer>();
        acceptableList.add(call);
        acceptableList.add(raise);
        AnswerList allActions = new AnswerList(acceptableList);
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 3
    public static LessonGame getGameThree(User userDetails, View thePanel) {

        ArrayList<Card> deck = new ArrayList<Card>();

        //Generate Deck
        int high = 13;
        int low = 10;
        Deck newDeck = new Deck();
        newDeck.remove(new Card(high, Suit.Hearts));
        newDeck.remove(new Card(low, Suit.Spades));
        deck.add(newDeck.dealCard());
        deck.add(new Card(12, Suit.Diamonds));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(high, Suit.Hearts));
        deck.add(newDeck.dealCard());
        deck.add(new Card(10, Suit.Clubs));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(low, Suit.Spades));
        //Community Cards
        deck.add(new Card(5, Suit.Diamonds));
        deck.add(new Card(12, Suit.Clubs));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(7, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        Answer call = new Answer(Action.Call);
        Answer raise = new Answer(Action.Raise);
        ArrayList<Answer> acceptableList = new ArrayList<Answer>();
        acceptableList.add(call);
        acceptableList.add(raise);
        AnswerList allActions = new AnswerList(acceptableList);
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 4
    public static LessonGame getGameFour(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        int high = 14;
        int low = 11;
        Deck newDeck = new Deck();
        newDeck.remove(new Card(high, Suit.Hearts));
        newDeck.remove(new Card(low, Suit.Hearts));
        deck.add(newDeck.dealCard());
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(high, Suit.Hearts));
        deck.add(newDeck.dealCard());
        deck.add(new Card(10, Suit.Clubs));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(low, Suit.Hearts));
        //Community Cards
        deck.add(new Card(9, Suit.Diamonds));
        deck.add(new Card(8, Suit.Clubs));
        deck.add(new Card(3, Suit.Hearts));
        deck.add(new Card(14, Suit.Diamonds));
        deck.add(new Card(7, Suit.Clubs));

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);


        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        Answer call = new Answer(Action.Call);
        Answer raise = new Answer(Action.Raise);
        ArrayList<Answer> acceptableList = new ArrayList<Answer>();
        acceptableList.add(call);
        acceptableList.add(raise);
        AnswerList allActions = new AnswerList(acceptableList);
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }

    //Test Yourself 5
    public static LessonGame getGameFive(User userDetails, View thePanel) {

        //Generate Deck
        ArrayList<Card> deck = new ArrayList<Card>();
        int high = 2;
        int low = 9;
        Deck newDeck = new Deck();
        newDeck.remove(new Card(high, Suit.Clubs));
        newDeck.remove(new Card(low, Suit.Clubs));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(high, Suit.Clubs));
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(new Card(low, Suit.Clubs));
        //Community Cards
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());
        deck.add(newDeck.dealCard());

        Deck d = new Deck(deck);

        //Create Player Actions
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> actions = new ArrayList<Integer>();
        actions.add(0);

        //Setup Test Conditions
        ArrayList<AllAnswers> guiActions = new ArrayList<AllAnswers>();
        Answer fold = new Answer(Action.Fold);
        AnswerList allActions = new AnswerList(fold);
        guiActions.add(new AllAnswers(allActions));

        //Create Players
        players.add(new GUILessonPlayer(userDetails.getForename(), userDetails.getSurname(), guiActions, 1000, 1, thePanel));
        players.add(new LessonPlayer("Harry", "Richards", 1000, 2, false, actions));
        players.add(new LessonPlayer("Michael", "Michaels", 1000, 3, false, actions));
        players.add(new LessonPlayer("Andy", "Jones", 1000, 4, false, actions));
        players.add(new LessonPlayer("Louise", "Johnson", 1000, 5, false, actions));
        players.add(new LessonPlayer("Emily", "Mills", 1000, 6, false, actions));
        players.add(new LessonPlayer("Alan", "Murray", 1000, 7, false, actions));
        players.add(new LessonPlayer("Ashley", "Jeavons", 1000, 8, false, actions));
        return new LessonGame(1000, 1, userDetails, thePanel, players, d, 0);
    }
}
