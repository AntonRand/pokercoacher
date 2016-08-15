/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson.Assessment;

/**
 *
 * This class represents one acceptable action.
 *
 * @author Anton
 */
public class Answer {

    private Action action;
    private int value;

    /**
     * Construct an answer.
     * @param action, the correct answer.
     */
    public Answer(Action action) {
        this.action = action;
    }

    /**
     * Construct an answer.
     * @param action, the answer type.
     * @param value, the value (for amount to call e.t.c.)
     */
    public Answer(Action action, int value) {
        this.action = action;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Action getAction() {
        return action;
    }
}