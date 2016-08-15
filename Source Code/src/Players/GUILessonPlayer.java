/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Abstract.View;
import Primitives.Card;
import Lesson.Assessment.*;
import java.util.ArrayList;

/**
 * LessonGUIPlayer Class.
 * @author Anton
 */
public class GUILessonPlayer extends Player {

    private View thePanel;
    private ArrayList<AllAnswers> acceptableActions = new ArrayList<AllAnswers>();
    private boolean accepted = false;

    /**
     * Construct a LessonGUIPlayer
     * @param forename, the players first name.
     * @param surname, the players last name.
     * @param actions, the list of actions to take.
     * @param chipBalance, their starting balance.
     * @param guiPosition, their position.
     * @param thePanel, the panel to draw with.
     */
    public GUILessonPlayer(String forename, String surname, ArrayList<AllAnswers> actions, int chipBalance, int guiPosition, View thePanel) {
        //Call super constuctor.
        super(forename, surname, chipBalance, guiPosition, true);
        this.thePanel = thePanel;
        this.acceptableActions.addAll(actions);
    }

    @Override
    public int getAction(int amountToCall, ArrayList<Card> boardCards, int bigBlind) {

        //The action has not yet been accepted by comparing the acceptable actions.
        accepted = false;

        //If there is an action for this hand
        if (!acceptableActions.isEmpty()) {

            //Get the current actions which can be used for this hand.
            AnswerList currentActions = acceptableActions.get(0).acceptableActions.get(0);
            Answer theAction;

            //Check for a forced action - where the computer carries out the action for the user.
            theAction = currentActions.contains(Action.ForceAction);
            //If theAction is not null then there was a forced action.
            if (theAction != null) {
                try {
                    //Wait for 2.5 seconds and then return the value of the action
                    super.setPlayersTurn(true);
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                }
                int dec = theAction.getValue();
                super.setPlayersTurn(false);
                acceptableActions.remove(0);
                return dec;
            }

            //If there wasn't a forced action, find the action the player must take and await input.
            return findAction(amountToCall, boardCards, bigBlind);
        } else {
            try {
                //If there wasn't an action, the player checks/folds as default.
                super.setPlayersTurn(true);
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
            }
            super.setPlayersTurn(false);
            return 0;
        }
    }

    
    public int regetAction(int amountToCall, ArrayList<Card> boardCards, int bigBlind) {
        setDecision(-2);
        return findAction(amountToCall, boardCards, bigBlind);
    }

    private int findAction(int amountToCall, ArrayList<Card> boardCards, int bigBlind) {

        super.setPlayersTurn(true);

        thePanel.getCustomRaiseField().setText("");
        thePanel.updateButtons(amountToCall);

        while (super.getDecision() < -1) {
        }

        if (!acceptableActions.isEmpty()) {

            ArrayList<AnswerList> currentActions = acceptableActions.get(0).acceptableActions;

            int playersDecision = super.getDecision();
            int totalCalled = super.getAmountCalled() + playersDecision;
            Answer theAction;


            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.BluffBounds);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a bluff action.
            if (theAction != null) {
                if ((totalCalled >= ((thePanel.getGame().getCurrentHand().getPotAmount() + 0.0) / 2)) && (totalCalled <= thePanel.getGame().getCurrentHand().getPotAmount())) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    //thePanel.disableBar();
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.Call);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.Call);
                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a call action.
            if (theAction != null) {
                if (totalCalled == amountToCall) {
                    //Successfully Return
                    int dec = super.getDecision();
                    thePanel.disableActionBar();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    System.out.println("Called");
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.Check);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.Check);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a check action.
            if (theAction != null) {
                if (super.getDecision() == 0) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.Raise);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.Raise);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a raise action.
            if (theAction != null) {
                if (totalCalled > amountToCall) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.RaiseTimes);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.RaiseTimes);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a raiseTimes action.
            if (theAction != null) {
                if (totalCalled == (amountToCall * theAction.getValue())) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.RaiseTo);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.RaiseTo);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a raise to action.
            if (theAction != null) {
                if (totalCalled == theAction.getValue()) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }
            //theAction = currentActions.contains(Action.Fold);
            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.Fold);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was a fold action.
            if (theAction != null) {
                if (super.getDecision() == -1) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }

            theAction = null;
            for (AnswerList acceptableActions : currentActions) {
                theAction = acceptableActions.contains(Action.AllIn);

                if (theAction != null) {
                    break;
                }
            }
            
            //If there was an all in action.
            if (theAction != null) {
                if (super.getDecision() == super.getChipBalance()) {
                    //Successfully Return
                    int dec = super.getDecision();
                    super.setPlayersTurn(false);
                    thePanel.getScore().correctAttempt(thePanel);
                    acceptableActions.remove(0);
                    accepted = true;
                    thePanel.disableActionBar();
                    return dec;
                }
            }

            //Unsucessful
            thePanel.getScore().incorrectAttempt(thePanel);
            return regetAction(amountToCall, boardCards, bigBlind);
        } else {
            //If there are no actions, the game is played as normal.
            int dec = super.getDecision();
            super.setPlayersTurn(false);
            accepted = true;
            thePanel.disableActionBar();
            return dec;
        }

    }

    public boolean actionAccepted() {
        return accepted;
    }

    @Override
    public boolean guiPlayer() {
        return true;
    }

    @Override
    public boolean lessonGUIPlayer() {
        return false;
    }

    public double getScore() {
        return thePanel.getScore().calculateScore();
    }

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
