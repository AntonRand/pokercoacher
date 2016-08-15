/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Primitives.Card;
import Simulations.Simulation;
import Tools.Utilities;
import java.util.ArrayList;
import java.util.Collections;

/**
 * AIPlayer Class.
 * @author Anton
 */
public class AdvancedAIPlayer extends Player {

    private int difficulty;

    /**
     * Construct a new AIPlayer
     * @param forename, Players first name
     * @param surname, Players surname
     * @param chipBalance, Players starting balance
     */
    public AdvancedAIPlayer(String forename, String surname, int chipBalance, int guiPosition, int difficulty) {
        super(forename, surname, chipBalance, guiPosition, false);
        this.difficulty = difficulty;
    }

    /**
     * Get the players action.
     * @param amountToCall, the amount to call
     * @param boardCards, the cards on the table
     * @param bigBlind, the big blind, useful for min raising
     * @return the players action
     */
    @Override
    public int getAction(int amountToCall, ArrayList<Card> communityCards, int bigBlind) {

        super.setPlayersTurn(true);

        try {

            //Take between 1.5 and 5 seconds to take action.
            int randomSleep = (int) (1500 + (Math.random() * 2500));
            Thread.sleep(randomSleep);
             

            int randomNumber = (int) (Math.random() * 100);

            if (difficulty == 0) {
                //If easy player.
                //If pre-flop.
                if (communityCards.isEmpty()) {
                    if (randomNumber <= 70) {
                        //Take the easy method 70% of the time.
                        super.setPlayersTurn(false);
                        return easyPreflop(amountToCall, bigBlind);
                    } else if (randomNumber <= 90) {
                        //Take the normal method 20% of the time.
                        super.setPlayersTurn(false);
                        return normalPreflop(amountToCall, bigBlind);
                    } else {
                        //Call 10% of the time.
                        super.setPlayersTurn(false);
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                //If post-flop.
                } else {
                    if (randomNumber <= 70) {
                        //Take the easy method 70% of the time.
                        super.setPlayersTurn(false);
                        return easyPostFlop(communityCards, amountToCall, bigBlind);
                    } else if (randomNumber <= 90) {
                        //Take the normal method 20% of the time.
                        super.setPlayersTurn(false);
                        return normalPostFlop(communityCards, amountToCall, bigBlind);
                    } else {
                        //Call 10% of the time.
                        super.setPlayersTurn(false);
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                }

                
                
            } else if (difficulty == 1) {
                //If average player.
                //If pre-flop.
                if (communityCards.isEmpty()) {
                    super.setPlayersTurn(false);
                    return normalPreflop(amountToCall, bigBlind);
                } else {
                //If post-flop.
                    super.setPlayersTurn(false);
                    return normalPostFlop(communityCards, amountToCall, bigBlind);
                }
                
                               
                
            } else {
                //If difficult player.
                //If pre-flop
                if (communityCards.isEmpty()) {
                    if (randomNumber <= 80) {
                        //Take the hard method 80% of the time.
                        super.setPlayersTurn(false);
                        return hardPreflop(amountToCall, bigBlind);
                    } else if (randomNumber <= 95) {
                        //Take the normal method 15% of the time.
                        super.setPlayersTurn(false);
                        return normalPreflop(amountToCall, bigBlind);
                    } else {
                        //Call anything 5% of the time.
                        super.setPlayersTurn(false);
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                } else {
                //If post-flop
                    if (randomNumber <= 80) {
                        //Take the hard method 80% of the time.
                        super.setPlayersTurn(false);
                        return hardPostFlop(communityCards, amountToCall, bigBlind);
                    } else if (randomNumber <= 95) {
                        //Take the normal method 15% of the time.
                        super.setPlayersTurn(false);
                        return normalPostFlop(communityCards, amountToCall, bigBlind);
                    } else {
                        //Call anything 5% of the time.
                        super.setPlayersTurn(false);
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error - Interrupted: Trying Again");
            super.setPlayersTurn(false);
            return getAction(amountToCall, communityCards, bigBlind);
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
            super.setPlayersTurn(false);
            return -1;
        }
    }

    /**
     * Raises by a multiple.
     */
    public int raise(int raiseTimes, int amountToCall, int bigBlind) {
        if (amountToCall != 0) {
            return betAmount((((amountToCall * raiseTimes))) - super.getAmountCalled());
        } else {
            return betAmount(bigBlind * raiseTimes);
        }
    }

    /**
     * Bets an amount.
     */
    public int betAmount(int amount) {
        if (amount > super.getChipBalance()) {
            return super.getChipBalance();
        } else {
            return amount;
        }
    }

    public boolean evaluateHoleCardsEasy() {

        //The easy player will get the list of cards which should always be played.
        ArrayList<int[]> acceptableCards = Utilities.getAnyCards();

        int randomOne = (int) (Math.random() * 100);
        int randomTwo = (int) (Math.random() * 100);

        //Half the time the list of middle position cards will be added.
        if (randomOne < 50) {
            acceptableCards.addAll(Utilities.getMiddleCards());
        }

        //30% of the time the player will add between 20% and 80% of late position cards.
        if (randomTwo < 30) {
            ArrayList<int[]> lateCards = Utilities.getLateCards();

            int randomThree = (int) ((lateCards.size() / 100) * (20 + (Math.random() * 60)));

            //Add random cards.
            Collections.shuffle(lateCards);

            while (randomThree != 0) {
                acceptableCards.add(lateCards.remove(0));
            }
        }

        //Get their cards.
        int cardOneValue = super.getCards()[0].getValue();
        int cardTwoValue = super.getCards()[1].getValue();
        boolean contained = false;

        //Check if their whole cards are in this list.
        for (int[] card : acceptableCards) {
            if (card[0] == cardOneValue && card[1] == cardTwoValue) {
                contained = true;
                break;
            } else if (card[0] == cardTwoValue && card[1] == cardOneValue) {
                contained = true;
                break;
            }
        }
        return contained;
    }

    public boolean evaluateHoleCardsHard() {

        //The hard player will get the list of cards which should always be played.

        ArrayList<int[]> acceptableCards = Utilities.getAnyCards();

        if (super.getPosition() == 1) {
            acceptableCards.addAll(Utilities.getMiddleCards());

        } else if (super.getPosition() == 2) {
            acceptableCards.addAll(Utilities.getLateCards());
        }

        //Get their cards.
        int cardOneValue = super.getCards()[0].getValue();
        int cardTwoValue = super.getCards()[1].getValue();
        boolean contained = false;

        //Check if their whole cards are in this list.
        for (int[] card : acceptableCards) {
            if (card[0] == cardOneValue && card[1] == cardTwoValue) {
                contained = true;
                break;
            } else if (card[0] == cardTwoValue && card[1] == cardOneValue) {
                contained = true;
                break;
            }
        }
        return contained;
    }

    public int easyPreflop(int amountToCall, int bigBlind) {

        //If their hole cards are considered strong enough or
        //if they haven't been raised.
        if (evaluateHoleCardsEasy() || super.getAmountCalled() > 0) {

            double simulatedWinPercent = simulate(1000);
            double expectedWinPercent = getExpectedWinPercent();

            //If there has been a raise.
            if (amountToCall + getAmountCalled() > bigBlind) {

                if (simulatedWinPercent + 5 > expectedWinPercent && simulatedWinPercent > 45) {

                    //Re-raise if simulatedWinPercent is better than expected and odds are
                    //better than 55%
                    if (simulatedWinPercent > 65) {
                        return raise(2, amountToCall, bigBlind);
                    } else {
                        //Call if simulatedWinPercent is better than expected.
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                } else if (simulatedWinPercent > expectedWinPercent) {
                    //Call if simulatedWinPercent is better than expected.
                    return betAmount(amountToCall - super.getAmountCalled());
                } else {
                    //Otherwise Fold.
                    return 0;
                }

            } else {
                //If there hasn't been a raise.

                if (simulatedWinPercent + 5 > expectedWinPercent && simulatedWinPercent > 40) {
                    //Raise if simulatedWinPercent is better than expected and odds are
                    //better than 55%
                    if (simulatedWinPercent > 50) {

                        if (amountToCall == 0) {
                            return betAmount(bigBlind * 3);
                        } else {
                            return raise(3, amountToCall, bigBlind);
                        }
                    } else {

                        if (amountToCall == 0) {
                            return betAmount(bigBlind);
                        } else {
                            return raise(1, amountToCall, bigBlind);
                        }
                    }

                } else if (simulatedWinPercent > expectedWinPercent) {

                    int randomFour = (int) (Math.random() * 100);
                    //Half the time the list of middle position cards will be added.
                    if (randomFour < 20) {

                        if (amountToCall == 0) {
                            return betAmount(bigBlind);
                        } else {
                            return raise(1, amountToCall, bigBlind);
                        }
                    } else {
                        //Call if simulatedWinPercent is better than expected.
                        return betAmount(amountToCall - super.getAmountCalled());
                    }
                } else {
                    //Otherwise Fold.
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }

    public int normalPreflop(int amountToCall, int bigBlind) {

        int randomOne = (int) (Math.random() * 100);

        if (randomOne <= 70) {
            //Be a good player 70% most of the time.
            return hardPreflop(amountToCall, bigBlind);
        } else if (randomOne <= 75) {
            //Take a chance 5% of the time.
            return betAmount(amountToCall - super.getAmountCalled());
        } else {
            //Be a poor player 25% of the time.
            return easyPreflop(amountToCall, bigBlind);
        }
    }

    public int hardPreflop(int amountToCall, int bigBlind) {

        //If their hole cards are contained in this generated list they will call
        //if they haven't been raised.
        if (evaluateHoleCardsHard() || super.getAmountCalled() > 0) {
            return hardPostFlop(new ArrayList<Card>(), amountToCall, bigBlind);
        } else {
            return 0;
        }
    }

    public int easyPostFlop(ArrayList<Card> communityCards, int amountToCall, int bigBlind) {

        //Work out the percentages.
        double simulatedWinPercent = simulate(communityCards, 100);
        double expectedWinPercent = getExpectedWinPercent();

        //If there has been a raise.
        if (amountToCall + getAmountCalled() > bigBlind) {

            if (simulatedWinPercent > expectedWinPercent && simulatedWinPercent > 60) {
                //Re-raise if simulatedWinPercent is better than expected and odds are
                //better than 70%
                if (simulatedWinPercent > 70) {
                    return raise(3, amountToCall, bigBlind);
                } else if (simulatedWinPercent > 60) {
                    return raise(2, amountToCall, bigBlind);
                } else {
                    return betAmount(amountToCall - super.getAmountCalled());
                }

            } else if (simulatedWinPercent > expectedWinPercent) {
                //Call if simulatedWinPercent is much better than expected.
                //Find out how much the raise was.
                double bigBlinds = amountToCall / bigBlind;

                //Determine whether to call based on the size of raise and hand strength.
                if (bigBlinds == 1) {
                    return betAmount(amountToCall - super.getAmountCalled());
                } else if (bigBlinds > 1 && bigBlinds <= 2) {

                    if (simulatedWinPercent > expectedWinPercent + 5) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                } else if (bigBlinds > 2 && bigBlinds <= 3) {
                    if (simulatedWinPercent > expectedWinPercent + 8) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                } else if (bigBlinds > 3) {
                    if (simulatedWinPercent > expectedWinPercent + 10) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                }
                return betAmount(amountToCall - super.getAmountCalled());
            } else {
                //Otherwise Fold.
                return 0;
            }
        } else {
            //If there wasn't a raise.
            if (simulatedWinPercent > expectedWinPercent && simulatedWinPercent > 50) {
                //Raise 2x if simulatedWinPercent is better than expected and odds are
                //better than 70%
                if (simulatedWinPercent > 60) {

                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 2);
                    } else {
                        return raise(2, amountToCall, bigBlind);
                    }
                } else {
                    //Bet the size of the big blind is the simulatedWinPercent is
                    //between 56% and 70%
                    if (amountToCall == 0) {
                        return betAmount(bigBlind);
                    } else {
                        return raise(1, amountToCall, bigBlind);
                    }
                }
            } else if (simulatedWinPercent > expectedWinPercent) {
                int randomFour = (int) (Math.random() * 100);
                //Raise 3 x the big blind 2 percent of the time.
                if (randomFour > 16 && randomFour <= 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 3);
                    } else {
                        return raise(3, amountToCall, bigBlind);
                    }
                    //Raise 2 x the big blind 5 percent of the time.
                } else if (randomFour > 12 && randomFour <= 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 2);
                    } else {
                        return raise(2, amountToCall, bigBlind);
                    }
                    //Bet the big blind 13 % of the time 
                } else if (randomFour < 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind);
                    } else {
                        return raise(1, amountToCall, bigBlind);
                    }
                } else {

                    //Call if simulatedWinPercent is better than expected.
                    return betAmount(amountToCall - super.getAmountCalled());
                }
            } else {
                //Otherwise Fold.
                return 0;
            }
        }
    }

    public int normalPostFlop(ArrayList<Card> communityCards, int amountToCall, int bigBlind) {

        int randomOne = (int) (Math.random() * 100);

        if (randomOne <= 70) {
            //Be a good player 65% most of the time.
            return hardPostFlop(communityCards, amountToCall, bigBlind);
        } else if (randomOne <= 75) {
            //Take a chance 5% of the time.
            return betAmount(amountToCall - super.getAmountCalled());
        } else {
            //Be a poor player 25% of the time.
            return easyPostFlop(communityCards, amountToCall, bigBlind);
        }
    }

    public int hardPostFlop(ArrayList<Card> communityCards, int amountToCall, int bigBlind) {
        //Work out the percentages.
        double simulatedWinPercent = simulate(communityCards, 1000);
        double expectedWinPercent = getExpectedWinPercent();

        //If there has been a raise.
        if (amountToCall + getAmountCalled() > bigBlind) {

            if (simulatedWinPercent > expectedWinPercent && simulatedWinPercent > 70) {

                //Re-raise if simulatedWinPercent is better than expected and odds are
                //better than 70%
                if (simulatedWinPercent > 80) {
                    return raise(3, amountToCall, bigBlind);
                } else if (simulatedWinPercent > 70) {
                    return raise(2, amountToCall, bigBlind);
                } else {
                    return betAmount(amountToCall - super.getAmountCalled());
                }

            } else if (simulatedWinPercent > expectedWinPercent + 10) {
                //Call if simulatedWinPercent is much better than expected.
                //Find out how much the raise was.
                double bigBlinds = amountToCall / bigBlind;

                //Determine whether to call based on the size of raise and hand strength.
                if (bigBlinds == 1) {
                    return betAmount(amountToCall - super.getAmountCalled());
                } else if (bigBlinds > 1 && bigBlinds <= 2) {
                    if (simulatedWinPercent > expectedWinPercent + 15) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                } else if (bigBlinds > 2 && bigBlinds <= 3) {
                    if (simulatedWinPercent > expectedWinPercent + 20) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                } else if (bigBlinds > 3) {
                    if (simulatedWinPercent > expectedWinPercent + 25) {
                        return betAmount(amountToCall - super.getAmountCalled());
                    } else {
                        return 0;
                    }
                }
                return betAmount(amountToCall - super.getAmountCalled());
            } else {
                //Otherwise Fold.
                return 0;
            }
        } else {
            //If there wasn't a raise.
            if (simulatedWinPercent > expectedWinPercent && simulatedWinPercent > 55) {
                //Raise 2x if simulatedWinPercent is better than expected and odds are
                //better than 70%
                if (simulatedWinPercent > 70) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 2);
                    } else {
                        return raise(2, amountToCall, bigBlind);
                    }
                } else {
                    //Bet the size of the big blind is the simulatedWinPercent is
                    //between 56% and 70%
                    if (amountToCall == 0) {
                        return betAmount(bigBlind);
                    } else {
                        return raise(1, amountToCall, bigBlind);
                    }
                }
            } else if (simulatedWinPercent > expectedWinPercent) {
                int randomFour = (int) (Math.random() * 100);
                //Raise 3 x the big blind 2 percent of the time.
                if (randomFour > 17 && randomFour <= 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 3);
                    } else {
                        return raise(3, amountToCall, bigBlind);
                    }
                    //Raise 2 x the big blind 5 percent of the time.
                } else if (randomFour > 14 && randomFour <= 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind * 2);
                    } else {
                        return raise(2, amountToCall, bigBlind);
                    }
                    //Bet the big blind 13 % of the time 
                } else if (randomFour < 20) {
                    if (amountToCall == 0) {
                        return betAmount(bigBlind);
                    } else {
                        return raise(1, amountToCall, bigBlind);
                    }
                } else {
                    //Call if simulatedWinPercent is better than expected.
                    return betAmount(amountToCall - super.getAmountCalled());
                }
            } else {
                //Otherwise Fold.
                return 0;
            }
        }
    }

    /**
     * Run simulations on community cards.
     */
    public double simulate(ArrayList<Card> communityCards, int numberOfSimulations) {

        ArrayList<Integer> playerPositions = new ArrayList<Integer>();

        for (Player p : getPlayers()) {
            if (p.inHand() && !p.equals(this)) {
                playerPositions.add(p.getPosition());
            }
        }

        Simulation s = new Simulation(getCards(), playerPositions, communityCards);
        s.runSimulations(numberOfSimulations);
        return s.getWinPercent();
    }

    /**
     * Run simulations.
     */
    public double simulate(int numberOfSimulations) {

        ArrayList<Integer> playerPositions = new ArrayList<Integer>();

        for (Player p : getPlayers()) {
            if (p.inHand() && !p.equals(this)) {
                playerPositions.add(p.getPosition());
            }
        }

        Simulation s = new Simulation(getCards(), playerPositions);
        s.runSimulations(numberOfSimulations);
        return s.getWinPercent();
    }

    public double getExpectedWinPercent() {

        //Get the number of players in the hand.
        double involvedPlayers = 0;

        for (Player p : super.getPlayers()) {
            if (p.inHand() == true) {
                involvedPlayers++;
            }
        }
        //Get expected percent:
        //If there were 4 players, you would hope to win 25% of the time.
        //If there were 2 players, you would hope to win 50% of the time.
        double expectedPercent = 0;
        if (involvedPlayers != 0) {
            expectedPercent = 100 / involvedPlayers;
        }
        return expectedPercent;
    }

    /**
     * Allows players to be sorted depending on the amount of chips committed (Ascending)
     * @param t, the player object to compare against
     * @return, integer representing more than, equal to or less than
     */
    @Override
    public int compareTo(Object t) {
        if (super.getAmountCalled() > ((Player) t).getAmountCalled()) {
            return -1;
        } else if (this.getAmountCalled() == ((Player) t).getAmountCalled()) {
            return 0;
        } else {
            return 1;
        }
    }
}
