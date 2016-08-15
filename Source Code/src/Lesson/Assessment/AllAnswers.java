/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson.Assessment;

import java.util.ArrayList;

/**
 *
 * This class represents all of the acceptable actions for an entire hand, it could be the
 * case that there are no acceptableActions in the list, meaning that any action is acceptable.
 *
 * @author axr712
 */
public class AllAnswers {

    public ArrayList<AnswerList> acceptableActions = new ArrayList<AnswerList>();

    /**
     * Construct AllAnswers.
     * @param acceptableActions, the list of actions that are correct.
     */
    public AllAnswers(ArrayList<AnswerList> acceptableActions) {
        this.acceptableActions = acceptableActions;
    }

    /**
     * Construct AllAnswers.
     * @param acceptableActions, the action that is correct.
     */
    public AllAnswers(AnswerList acceptableAction) {
        this.acceptableActions.add(acceptableAction);
    }

    /**
     * @return, the list of actions that are correct.
     */
    public ArrayList<AnswerList> getAllActions() {
        return acceptableActions;
    }
}
