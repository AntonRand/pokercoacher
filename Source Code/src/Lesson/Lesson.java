/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import java.util.ArrayList;

/**
 *
 * Lesson Class, constructed of all the steps which make up the
 * lesson.
 * 
 * @author Anton
 */
public class Lesson {

    private ArrayList<LessonStep> steps;
    private int counter = 0;

    public Lesson(ArrayList<LessonStep> steps) {
        this.steps = steps;
    }

    /**
     * Displays the current step the user is on.
     */
    public void displayStep() {
        steps.get(counter).display();
    }

    /**
     * @return, The current lesson stage.
     */
    public LessonStep getCurrentStep() {
        if (steps.isEmpty()) {
            return null;
        }
        return steps.get(counter);
    }

    /**
     * Displays the next lesson step if not at the end of content.
     * @return, boolean representing whether there is a next step or not.
     */
    public Boolean displayNextStep() {

        //If there isn't a next step, return false.
        if (steps.size() == counter + 1) {
            return false;
        } else {
            //Display the next step and return true.
            counter++;
            steps.get(counter).display();
            return true;
        }
    }

    /**
     * Displays the previous step if not at the start of content.
     * @return, boolean representing whether there is a previous step or not.
     */
    public Boolean displayPreviousStep() {

        //If there is a previous step, display it and return true.
        if (counter != 0) {
            counter--;
            steps.get(counter).display();
            return true;
        } else {
            //If there isn't a previous step, return false.
            return false;
        }
    }
}