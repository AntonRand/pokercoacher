/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson.Assessment;

import java.util.ArrayList;

/**
 *
 * This class is for when there are several acceptable actions in a hand, Such as Raising or Folding.
 *
 * @author axr712
 */
public class AnswerList {

    public ArrayList<Answer> acceptableActions = new ArrayList<Answer>();

    /**
     * Construct a new list of answers.
     * @param acceptableActions, the list of correct answers.
     */
    public AnswerList(ArrayList<Answer> acceptableActions) {
        this.acceptableActions = acceptableActions;
    }

    /**
     * Construct a new list of answers.
     * @param acceptableAction, the only correct action.
     */
    public AnswerList(Answer acceptableAction) {
        acceptableActions.add(acceptableAction);
    }

    /**
     * @return, the list of correct actions.
     */
    public ArrayList<Answer> getActions() {
        return acceptableActions;
    }

    /**
     * Checks if an action is in the list.
     * @param action, the action to check.
     * @return, returns the answer if contained.
     */
    public Answer contains(Action action) {
        
        for (Answer acceptableAction : acceptableActions) { 
            if (acceptableAction.getAction() == action) {
                return acceptableAction;
            }
        }
        return null;
    }
}
