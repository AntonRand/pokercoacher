/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.GameCalculations;

import Primitives.Card;
import Primitives.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * HandComparer Class.
 * @author Anton
 */
public class HandComparer {

    private ArrayList<Card> combinedCards = new ArrayList<Card>();

    /**
     * Construct a Hand Comparer containing all of the cards the player can combine
     * @param playerCards, The cards only available to the player
     * @param boardCards , The cards available to all players
     */
    public HandComparer(Card[] playerCards, ArrayList<Card> boardCards) {
        if (playerCards != null && playerCards.length == 2) {
            combinedCards.addAll(boardCards);
            combinedCards.addAll(Arrays.asList(playerCards));
            Collections.sort(combinedCards);
        } else {
            //Do not allow blank comparers to be constructed
        }
    }

    public HandComparer(ArrayList<Card> combinedCards) {
        if (combinedCards.size() >= 5) {
            this.combinedCards = combinedCards;
            Collections.sort(combinedCards);
        } else {
        }
    }

    /**
     * Check for each hand, starting with the strongest. Keep checking until
     * the result isn't null. That way the strongest hand will always be returned.
     * @return HandResult representing the best 5 cards for that player and the type of hand.
     */
    public HandResult compare() {


        if (straightFlush() != null) {
            return straightFlush();
        } else if (fourOfAKind() != null) {
            return fourOfAKind();
        } else if (fullHouse() != null) {
            return fullHouse();
        } else if (flush() != null) {
            return flush();
        } else if (straight() != null) {
            return straight();
        } else if (threeOfAKind() != null) {
            return threeOfAKind();
        } else if (twoPair() != null) {
            return twoPair();
        } else if (pair() != null) {
            return pair();
        } else {
            //High Card will never return a null HandResult
            return highCard();
        }
    }

    /**
     * @return 'null' If a Straight Flush didn't occur, otherwise return HandResult
     * representing the Straight Flush
     */
    private HandResult straightFlush() {

        ArrayList<Card> toCheck = getFlushList();
        //If there are at least 5 cards of the same suit and there is a straight
        //We also have a straight flush
        if (toCheck != null && toCheck.size() >= 5 && (checkStraight(toCheck) != null)) {
            return new HandResult(9, checkStraight(toCheck).getBestFive());
        }
        return null;
    }

    /**
     * @return 'null' If a Four Of A Kind didn't occur, otherwise return HandResult
     * representing the Four Of A Kind
     */
    private HandResult fourOfAKind() {

        if (combinedCards.size() > 4) {

            Collections.sort(combinedCards);

            //We can only have a maximum of 7 cards, therefore there should be 4 cards
            //in one of these lists if there is a four of a kind.
            ArrayList<Card> valueOne = new ArrayList<Card>();
            ArrayList<Card> valueTwo = new ArrayList<Card>();
            ArrayList<Card> valueThree = new ArrayList<Card>();
            ArrayList<Card> valueFour = new ArrayList<Card>();
            valueOne.add(combinedCards.get(0));
            for (int i = 1; i < combinedCards.size(); i++) {
                //Determine where to put each card determined by value
                if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                    valueOne.add(combinedCards.get(i));
                } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                    valueTwo.add(combinedCards.get(i));
                } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                    valueThree.add(combinedCards.get(i));
                } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                    valueFour.add(combinedCards.get(i));
                }
            }
            //If we have 4 cards, they must be the same value because of the code above
            //so return a hand result to show four of a kind has occurred.
            if (valueOne.size() == 4) {
                valueOne.add(valueTwo.get(0));
                return new HandResult(8, valueOne);
            } else if (valueTwo.size() == 4) {
                valueTwo.add(valueOne.get(0));
                return new HandResult(8, valueTwo);
            } else if (valueThree.size() == 4) {
                valueThree.add(valueOne.get(0));
                return new HandResult(8, valueThree);
            } else if (valueFour.size() == 4) {
                valueFour.add(valueOne.get(0));
                return new HandResult(8, valueFour);
            }
            return null;
        } else {
            return null;
        }

    }

    /**
     * @return 'null' If a Full House didn't occur, otherwise return HandResult
     * representing the Full House
     */
    private HandResult fullHouse() {


        if (combinedCards.size() > 4) {


            Collections.sort(combinedCards);

            ArrayList<Card> valueOne = new ArrayList<Card>();
            ArrayList<Card> valueTwo = new ArrayList<Card>();
            ArrayList<Card> valueThree = new ArrayList<Card>();
            ArrayList<Card> valueFour = new ArrayList<Card>();
            ArrayList<Card> valueFive = new ArrayList<Card>();
            ArrayList<Card> valueSix = new ArrayList<Card>();
            ArrayList<Card> threeCard = null;
            ArrayList<Card> pairCard = null;

            valueOne.add(combinedCards.get(0));

            //Add Cards of the same value to the same list
            //Highest Values are added first
            for (int i = 1; i < combinedCards.size(); i++) {
                if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                    valueOne.add(combinedCards.get(i));
                } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                    valueTwo.add(combinedCards.get(i));
                } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                    valueThree.add(combinedCards.get(i));
                } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                    valueFour.add(combinedCards.get(i));
                } else if (valueFive.isEmpty() == true || combinedCards.get(i).getValue() == valueFive.get(0).getValue()) {
                    valueFive.add(combinedCards.get(i));
                } else if (valueSix.isEmpty() == true || combinedCards.get(i).getValue() == valueSix.get(0).getValue()) {
                    valueFive.add(combinedCards.get(i));
                }
            }

            //If we have three of a kind set the variable accordingly, otherwise check for
            //pair
            if (valueOne.size() == 3) {
                threeCard = valueOne;
            } else if (valueOne.size() == 2) {
                pairCard = valueOne;
            }

            //If we have three of a kind and the first list hasn't already initialised the variable
            //we can set it to be three of a kind.
            if (valueTwo.size() == 3 && threeCard == null) {
                threeCard = valueTwo;
                //If we have three of a kind and the first list was also three of a kind we set this
                //to be the pair card. If we just have a pair and the pair variable hasn't been initialised
                //we can set it to be the pair. The same applies to all the other lists. We check the highest values
                //first because AAAKK is better than KKKAA
            } else if (valueTwo.size() >= 2 && pairCard == null) {
                pairCard = valueTwo;
            }
            if (valueThree.size() == 3 && threeCard == null) {
                threeCard = valueThree;
            } else if (valueThree.size() >= 2 && pairCard == null) {
                pairCard = valueThree;
            }
            if (valueFour.size() == 3 && threeCard == null) {
                threeCard = valueFour;
            } else if (valueFour.size() >= 2 && pairCard == null) {
                pairCard = valueFour;
            }
            if (valueFive.size() == 3 && threeCard == null) {
                threeCard = valueFive;
            } else if (valueFive.size() >= 2 && pairCard == null) {
                pairCard = valueFive;
            }
            if (valueSix.size() == 3 && threeCard == null) {
                threeCard = valueSix;
            } else if (valueSix.size() >= 2 && pairCard == null) {
                pairCard = valueSix;
            }

            //If the three of a kind and pair values have been initialised a full house
            //has occurred.
            if (threeCard != null && pairCard != null) {
                ArrayList<Card> finalList = new ArrayList<Card>();
                finalList.addAll(threeCard);
                finalList.addAll(pairCard);
                return new HandResult(7, finalList);
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * @return 'null' If a Flush didn't occur, otherwise return HandResult
     * representing the Flush
     */
    private HandResult flush() {

        ArrayList<Card> cards = getFlushList();
        if (cards == null) {
            return null;
        } else {
            //if we have more than 5 remove the lowest cards
            while (cards.size() != 5) {
                cards.remove(cards.size() - 1);
            }
            //Return the 5 highest cards from the list
            return new HandResult(6, cards);
        }
    }

    /**
     * @return 'null' If a Straight didn't occur, otherwise return HandResult
     * representing the Straight
     */
    private HandResult straight() {
        //We use a calling rule here because we also need to check for straights
        //in straight flushes where we don't necessarily check against the combined
        //cards.
        if (combinedCards.size() > 4) {

            return checkStraight(singleValuedness());
        } else {
            return null;
        }

    }

    /**
     * Do I need to sort again after adding the 1?
     * 
     * 
     * Check for Straight with given cards
     * @param cardList, The list of cards to check against.
     * @return HandResult representing wether a straight has occured or not.
     */
    private HandResult checkStraight(ArrayList<Card> cardList) {
        Collections.sort(cardList);


        boolean straight = true;
        int count = 0;

        //Straight cannot occur if we haven't got 5 cards minumum
        if (cardList.size() >= 5) {
            for (int i = 0; i < cardList.size() - 4; i++) {
                //A straight is initially possible
                straight = true;
                //Aces can be high or low, so temporarily add a card of value 1 so that
                //we can have A-4 straight.
                if (cardList.get(i).getValue() == 14) {
                    cardList.add(new Card(1, cardList.get(i).getSuit()));
                    count++;
                }
                for (int j = i; j != (i + 4); j++) {
                    if (cardList.get(j).getValue() != (cardList.get(j + 1).getValue() + 1)) {
                        straight = false;
                    }
                }

                //If the straight variable is still true here we have a straight and
                //add the best five cards.
                if (straight == true) {
                    ArrayList<Card> bestFive = new ArrayList<Card>();
                    bestFive.add(cardList.get(i));
                    bestFive.add(cardList.get(i + 1));
                    bestFive.add(cardList.get(i + 2));
                    bestFive.add(cardList.get(i + 3));
                    bestFive.add(cardList.get(i + 4));
                    //Remove the Ace before returning.
                    while (count != 0) {
                        cardList.remove(cardList.size() - 1);
                        count--;
                    }
                    return new HandResult(5, bestFive);
                }
            }
            while (count != 0) {
                cardList.remove(cardList.size() - 1);
                count--;
            }
        }
        return null;
    }

    private ArrayList<Card> singleValuedness() {


        ArrayList<Card> valueOne = new ArrayList<Card>();
        ArrayList<Card> valueTwo = new ArrayList<Card>();
        ArrayList<Card> valueThree = new ArrayList<Card>();
        ArrayList<Card> valueFour = new ArrayList<Card>();
        ArrayList<Card> valueFive = new ArrayList<Card>();
        ArrayList<Card> valueSix = new ArrayList<Card>();
        ArrayList<Card> valueSeven = new ArrayList<Card>();
        ArrayList<Card> valueEight = new ArrayList<Card>();

        valueOne.add(combinedCards.get(0));

        for (int i = 1; i < combinedCards.size(); i++) {
            //Determine where to put each card determined by value
            if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                valueOne.add(combinedCards.get(i));
            } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                valueTwo.add(combinedCards.get(i));
            } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                valueThree.add(combinedCards.get(i));
            } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                valueFour.add(combinedCards.get(i));
            } else if (valueFive.isEmpty() == true || combinedCards.get(i).getValue() == valueFive.get(0).getValue()) {
                valueFive.add(combinedCards.get(i));
            } else if (valueSix.isEmpty() == true || combinedCards.get(i).getValue() == valueSix.get(0).getValue()) {
                valueSix.add(combinedCards.get(i));
            } else if (valueSeven.isEmpty() == true || combinedCards.get(i).getValue() == valueSeven.get(0).getValue()) {
                valueSeven.add(combinedCards.get(i));
            } else if (valueEight.isEmpty() == true || combinedCards.get(i).getValue() == valueEight.get(0).getValue()) {
                valueEight.add(combinedCards.get(i));
            }
        }




        ArrayList<Card> singleList = new ArrayList<Card>();


        while (valueOne.size() > 1) {
            valueOne.remove(0);
        }
        while (valueTwo.size() > 1) {
            valueTwo.remove(0);
        }
        while (valueThree.size() > 1) {
            valueThree.remove(0);
        }
        while (valueFour.size() > 1) {
            valueFour.remove(0);
        }
        while (valueFive.size() > 1) {
            valueFive.remove(0);
        }
        while (valueSix.size() > 1) {
            valueSix.remove(0);
        }
        while (valueSeven.size() > 1) {
            valueSeven.remove(0);
        }
        while (valueEight.size() > 1) {
            valueEight.remove(0);
        }

        singleList.addAll(valueOne);
        singleList.addAll(valueTwo);
        singleList.addAll(valueThree);
        singleList.addAll(valueFour);
        singleList.addAll(valueFive);
        singleList.addAll(valueSix);
        singleList.addAll(valueSeven);
        singleList.addAll(valueEight);

        return singleList;
    }

    /**
     * Get all the cards of the same suit if there are 5 or more.
     * @return, The list of cards of the same suit. Null if there is no chance of a flush.
     */
    private ArrayList<Card> getFlushList() {

        if (combinedCards.size() > 4) {


            ArrayList<Card> clubCards = new ArrayList<Card>();
            ArrayList<Card> heartCards = new ArrayList<Card>();
            ArrayList<Card> diamondCards = new ArrayList<Card>();
            ArrayList<Card> spadeCards = new ArrayList<Card>();

            //Go through all the cards and add each card to the correct suit pile
            for (int i = 0; i < combinedCards.size(); i++) {
                if (combinedCards.get(i).getSuit() == Suit.Clubs) {
                    clubCards.add(combinedCards.get(i));
                } else if (((Suit) (combinedCards.get(i).getSuit())) == Suit.Hearts) {
                    heartCards.add(combinedCards.get(i));
                } else if (combinedCards.get(i).getSuit() == Suit.Diamonds) {
                    diamondCards.add(combinedCards.get(i));
                } else {
                    spadeCards.add(combinedCards.get(i));
                }

            }

            //If there are at least 5 cards in one of the lists we can return the list

            //Note: It is impossible for 2 lists to have 5 cards or more
            if (clubCards.size() >= 5) {
                return clubCards;
            } else if (heartCards.size() >= 5) {
                return heartCards;
            } else if (spadeCards.size() >= 5) {
                return spadeCards;
            } else if (diamondCards.size() >= 5) {
                return diamondCards;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @return 'null' If a Three of a Kind didn't occur, otherwise return HandResult
     * representing the Three of a Kind
     */
    private HandResult threeOfAKind() {

        if (combinedCards.size() > 4) {
            //Similar to Full House Implementation
            Collections.sort(combinedCards);

            ArrayList<Card> valueOne = new ArrayList<Card>();
            ArrayList<Card> valueTwo = new ArrayList<Card>();
            ArrayList<Card> valueThree = new ArrayList<Card>();
            ArrayList<Card> valueFour = new ArrayList<Card>();
            ArrayList<Card> valueFive = new ArrayList<Card>();

            valueOne.add(combinedCards.get(0));
            for (int i = 1; i < combinedCards.size(); i++) {
                if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                    valueOne.add(combinedCards.get(i));
                } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                    valueTwo.add(combinedCards.get(i));
                } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                    valueThree.add(combinedCards.get(i));
                } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                    valueFour.add(combinedCards.get(i));
                } else if (valueFive.isEmpty() == true || combinedCards.get(i).getValue() == valueFive.get(0).getValue()) {
                    valueFive.add(combinedCards.get(i));
                }
            }
            ArrayList<Card> allCards = new ArrayList<Card>();

            if (valueOne.size() == 3) {
                allCards.addAll(valueTwo);
                allCards.addAll(valueThree);
                valueOne.add(allCards.get(0));
                valueOne.add(allCards.get(1));
                return new HandResult(4, valueOne);
            } else if (valueTwo.size() == 3) {
                allCards.addAll(valueOne);
                allCards.addAll(valueThree);
                valueTwo.add(allCards.get(0));
                valueTwo.add(allCards.get(1));
                return new HandResult(4, valueTwo);
            } else if (valueThree.size() == 3) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                valueThree.add(allCards.get(0));
                valueThree.add(allCards.get(1));
                return new HandResult(4, valueThree);
            } else if (valueFour.size() == 3) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                valueFour.add(allCards.get(0));
                valueFour.add(allCards.get(1));
                return new HandResult(4, valueFour);
            } else if (valueFive.size() == 3) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                valueFive.add(allCards.get(0));
                valueFive.add(allCards.get(1));
                return new HandResult(4, valueFive);
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * @return 'null' If a Two Pair didn't occur, otherwise return HandResult
     * representing the Two Pair
     */
    private HandResult twoPair() {

        if (combinedCards.size() > 4) {


            //Similar to Full House Implementation
            Collections.sort(combinedCards);

            ArrayList<Card> valueOne = new ArrayList<Card>();
            ArrayList<Card> valueTwo = new ArrayList<Card>();
            ArrayList<Card> valueThree = new ArrayList<Card>();
            ArrayList<Card> valueFour = new ArrayList<Card>();
            ArrayList<Card> valueFive = new ArrayList<Card>();
            ArrayList<Card> valueSix = new ArrayList<Card>();

            valueOne.add(combinedCards.get(0));
            for (int i = 1; i < combinedCards.size(); i++) {
                if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                    valueOne.add(combinedCards.get(i));
                } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                    valueTwo.add(combinedCards.get(i));
                } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                    valueThree.add(combinedCards.get(i));
                } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                    valueFour.add(combinedCards.get(i));
                } else if (valueFive.isEmpty() == true || combinedCards.get(i).getValue() == valueFive.get(0).getValue()) {
                    valueFive.add(combinedCards.get(i));
                } else if (valueSix.isEmpty() == true || combinedCards.get(i).getValue() == valueSix.get(0).getValue()) {
                    valueSix.add(combinedCards.get(i));
                }

            }
            ArrayList<Card> pairedCards = new ArrayList<Card>();
            ArrayList<Card> otherCards = new ArrayList<Card>();

            if (valueOne.size() == 2) {
                pairedCards.addAll(valueOne);
            } else {
                otherCards.addAll(valueOne);
            }
            if (valueTwo.size() == 2) {
                pairedCards.addAll(valueTwo);
            } else {
                otherCards.addAll(valueTwo);
            }
            if (valueThree.size() == 2 && pairedCards.size() != 4) {
                pairedCards.addAll(valueThree);
            } else {
                otherCards.addAll(valueThree);
            }
            if (valueFour.size() == 2 && pairedCards.size() != 4) {
                pairedCards.addAll(valueFour);
            } else {
                otherCards.addAll(valueFour);
            }
            if (valueFive.size() == 2 && pairedCards.size() != 4) {
                pairedCards.addAll(valueFive);
            } else {
                otherCards.addAll(valueFive);
            }
            if (valueSix.size() == 2 && pairedCards.size() != 4) {
                pairedCards.addAll(valueSix);
            } else {
                otherCards.addAll(valueSix);
            }
            if (pairedCards.size() == 4) {
                pairedCards.add(otherCards.get(0));
                return new HandResult(3, pairedCards);
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * @return 'null' If a Pair didn't occur, otherwise return HandResult
     * representing the Pair
     */
    private HandResult pair() {

        if (combinedCards.size() > 3) {
            //Similar to Full House Implementation
            Collections.sort(combinedCards);

            ArrayList<Card> valueOne = new ArrayList<Card>();
            ArrayList<Card> valueTwo = new ArrayList<Card>();
            ArrayList<Card> valueThree = new ArrayList<Card>();
            ArrayList<Card> valueFour = new ArrayList<Card>();
            ArrayList<Card> valueFive = new ArrayList<Card>();
            ArrayList<Card> valueSix = new ArrayList<Card>();


            //Add the first card
            valueOne.add(combinedCards.get(0));


            for (int i = 1; i < combinedCards.size(); i++) {
                if (combinedCards.get(i).getValue() == valueOne.get(0).getValue()) {
                    valueOne.add(combinedCards.get(i));
                } else if (valueTwo.isEmpty() == true || combinedCards.get(i).getValue() == valueTwo.get(0).getValue()) {
                    valueTwo.add(combinedCards.get(i));
                } else if (valueThree.isEmpty() == true || combinedCards.get(i).getValue() == valueThree.get(0).getValue()) {
                    valueThree.add(combinedCards.get(i));
                } else if (valueFour.isEmpty() == true || combinedCards.get(i).getValue() == valueFour.get(0).getValue()) {
                    valueFour.add(combinedCards.get(i));
                } else if (valueFive.isEmpty() == true || combinedCards.get(i).getValue() == valueFive.get(0).getValue()) {
                    valueFive.add(combinedCards.get(i));
                } else if (valueSix.isEmpty() == true || combinedCards.get(i).getValue() == valueSix.get(0).getValue()) {
                    valueSix.add(combinedCards.get(i));
                }

            }
            ArrayList<Card> allCards = new ArrayList<Card>();
            ArrayList<Card> otherCards = new ArrayList<Card>();


            if (valueOne.size() == 2) {
                allCards.addAll(valueTwo);
                allCards.addAll(valueThree);
                allCards.addAll(valueFour);

                valueOne.add(allCards.get(0));
                valueOne.add(allCards.get(1));
                valueOne.add(allCards.get(2));

                return new HandResult(2, valueOne);
            } else if (valueTwo.size() == 2) {
                allCards.addAll(valueOne);
                allCards.addAll(valueThree);
                allCards.addAll(valueFour);
                valueTwo.add(allCards.get(0));
                valueTwo.add(allCards.get(1));
                valueTwo.add(allCards.get(2));

                return new HandResult(2, valueTwo);
            } else if (valueThree.size() == 2) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                allCards.addAll(valueFour);
                valueThree.add(allCards.get(0));
                valueThree.add(allCards.get(1));
                valueThree.add(allCards.get(2));

                return new HandResult(2, valueThree);
            } else if (valueFour.size() == 2) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                allCards.addAll(valueThree);
                valueFour.add(allCards.get(0));
                valueFour.add(allCards.get(1));
                valueFour.add(allCards.get(2));

                return new HandResult(2, valueFour);
            } else if (valueFive.size() == 2) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                allCards.addAll(valueThree);
                valueFive.add(allCards.get(0));
                valueFive.add(allCards.get(1));
                valueFive.add(allCards.get(2));

                return new HandResult(2, valueFive);
            } else if (valueSix.size() == 2) {
                allCards.addAll(valueOne);
                allCards.addAll(valueTwo);
                allCards.addAll(valueThree);
                valueSix.add(allCards.get(0));
                valueSix.add(allCards.get(1));
                valueSix.add(allCards.get(2));

                return new HandResult(2, valueSix);
            }
            return null;
        }
        return null;
    }

    /**
     * @return HandResult representing the High Card
     */
    private HandResult highCard() {

        Collections.sort(combinedCards);

        if (combinedCards.size() < 5) {
            return new HandResult(1, combinedCards);
        }


        ArrayList<Card> copy = (ArrayList) combinedCards.clone();
        while (copy.size() != 5) {
            copy.remove(copy.size() - 1);
        }
        return new HandResult(1, copy);
    }

    @Override
    public String toString() {
        return combinedCards.toString();
    }
}
