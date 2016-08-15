/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Content.Text;

import Primitives.Definition;

/**
 * Contains methods which create definitions based on the following phrases.
 * @author Anton
 */
public class Definitions {

    public static Definition allIn(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "All In", "This is when a player bets all of their remaining chips.");
    }

    public static Definition bigBlind(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Big Blind", "A forced bet. Players who choose to raise when they", "have the option to check must bet the size of the big blind", "as a minimum.");
    }

    public static Definition check(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Check", "To refrain from betting, can only be done when there", "is no bet to match.");
    }

    public static Definition call(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Call", "To match the amount needed to stay in the hand.", "");
    }

    public static Definition communityCards(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Community Cards", "The cards on the table visible to all players.");
    }

    public static Definition connectedcards(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Connected Cards", "This is when you can combine your hole cards with 3", "other cards to form a straight.");
    }

    public static Definition dealer(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Dealer/Button", "The player who deals the cards and is last", "to act.");
    }

    public static Definition earlyposition(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Early Position", "Players who are the first to act, usually the big blind,", "small blind and player to the left of the small blind.");
    }

    public static Definition flop(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Flop", "The round of betting after pre-flop, where 3", "community cards are dealt and made visible to all", "players.");
    }

    public static Definition flush(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Flush", "A combination of 5 cards of the same suit.", "");
    }

    public static Definition fold(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Fold", "To end participation of the current hand.", "");
    }

    public static Definition fourofakind(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Four of a Kind", "A combination of 5 cards including 4 which have the same value.", "");
    }

    public static Definition fullhouse(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Full House", "A combination of 5 cards including a pair and a three of a kind.", "");
    }

    public static Definition hand(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Hand", "1. The best 5 card combination you can make.", "2. The action that takes place between each deal.");
    }

    public static Definition highcard(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "High Card", "The highest 5 card combination you can make.");
    }

    public static Definition highvaluecards(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "High Value Cards", "This is when your hole cards lowest value card is", "10 or above.");
    }

    public static Definition holeCards(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Hole Cards", "These are the cards that are dealt to players.", "Only that player can see their hole cards.");
    }

    public static Definition kicker(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Kicker", "Kickers are used when two players have the same", "category. If two players have the same value pair, the", "player with the highest card unrelated to that pair wins.");
    }

    public static Definition lateposition(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Late Position", "Players who are the last to act, usually the dealer and", "the player to the right of the dealer.");
    }

    public static Definition middleposition(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Middle Position", "Players who are inbetween the early and late position", "players.");
    }

    public static Definition pair(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Pair", "A combination of 5 cards including 2 cards of", "the same value.");
    }

    public static Definition passive(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Passive Play", "When a player is reluctant to bet or call until they", "develop a strong hand.");
    }

    public static Definition pocketpair(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Pocket Pair", "This is when both of your hole cards are the same", "value.");
    }

    public static Definition pokerHand(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Poker Hand", "Poker games are made up of hands, each hand starts", "with the blinds being posted and the cards dealt.");
    }

    public static Definition position(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Position", "The place you are currently sat at the table with respect", "to the dealer button.");
    }

    public static Definition pot(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Pot", "When players bet chips they are all placed into the", "middle of the table, known as the pot.");
    }

    public static Definition preflop(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Pre-flop", "The round of betting that takes place before", "any community cards are shown.");
    }

    public static Definition raise(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Raise", "To bet more than required to stay in the hand, raising the ", "amount other players need to call.");
    }

    public static Definition river(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "River", "The final round of betting, which takes place after the turn.", "A 5th community card is dealt.");
    }

    public static Definition showdown(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Showdown", "If multiple players have made it past the river, players show", "their cards in the showdown stage and a winner", "is determined.");
    }

    public static Definition smallBlind(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Small Blind", "A forced bet usually equal to half of the big blind.");
    }

    public static Definition straight(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Straight", "A combination of 5 cards where the values all", "succeed each other.");
    }

    public static Definition straightflush(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Straight Flush", "A combination of 5 cards of the same suit where the values all", "succeed each other.");
    }

    public static Definition suitedcards(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Suited Cards", "This is when both of your hole cards are of the same", "suit.");
    }

    public static Definition threeofakind(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Three of a Kind", "A combination of 5 cards including 3 of the same value.", "");
    }

    public static Definition turn(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Turn", "The round of betting which takes place after the flop.", "A 4th community card is dealt.");
    }

    public static Definition twopair(int characterStartIndex, int characterEndIndex) {
        return new Definition(characterStartIndex, characterEndIndex, "Two Pair", "A combination of 5 cards including 2 pairs.", "");
    }
}