/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Abstract.View;
import Lesson.LessonView;

/**
 * @author Anton
 */
public class Score {

    private double totalAttempts;
    private double correctAttempts;
    private boolean lastAttemptCorrect = true;
    private boolean showFeedback = false;
    public int incorrectAttempts = 0;

    public Score() {
        //Score is initially 0.
        totalAttempts = 0;
        correctAttempts = 0;
    }

    //Used to determine whether or not to display Correct/Incorrect.
    public boolean showFeedback() {
        return showFeedback;
    }

    //If the player has made 3 or more incorrect attempts, show them a hint.
    public boolean showHint() {
        if (incorrectAttempts > 2) {
            return true;
        }
        return false;
    }

    public void correctAttempt(View thePanel) {

        LessonView lv = (LessonView) thePanel;

        //Reset, show last attempt as correct.
        incorrectAttempts = 0;
        lastAttemptCorrect = true;
        showFeedback = true;

        //If they haven't already completed the hand.
        if (!lv.getCurrentMessage().isCompleted()) {

            //If they haven't answered this question before.
            if (lv.getCurrentMessage().newQuestion()) {
                //Take Score into consideration
                totalAttempts++;
                correctAttempts++;
                lv.getCurrentMessage().updateQuestionsAnswered();
            } else {
                //Don't take score into consideration
                lv.getCurrentMessage().updateTally();
            }
        }
    }

    public void incorrectAttempt(View thePanel) {

        LessonView lv = (LessonView) thePanel;

        //Increase the amount of incorrect answers.
        incorrectAttempts++;
        lastAttemptCorrect = false;
        showFeedback = true;

        //If they haven't completed the hand and the question is new, reduce score.
        if (!lv.getCurrentMessage().isCompleted() && lv.getCurrentMessage().newQuestion()) {
            totalAttempts++;
        }
    }

    public boolean lastAttemptCorrect() {
        return lastAttemptCorrect;
    }

    public int calculateScore() {
        if (totalAttempts == 0) {
            //Prevents division by 0.
            return 0;
        } else {
            return (int) Math.round((correctAttempts / totalAttempts) * 100);
        }
    }

    public void hideFeedback() {
        showFeedback = false;
    }
}
