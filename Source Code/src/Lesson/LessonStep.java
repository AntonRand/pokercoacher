/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import Data.User;
import Content.Games.*;
import Primitives.*;
import java.util.ArrayList;

/**
 *
 * This is the Individual Step
 * 
 * @author Anton
 */
public class LessonStep {

    private LessonView theLesson;
    private String text;
    private ArrayList<Arrow> theArrows;
    private LessonGame theGame = null;
    private String action = "";
    private User userDetails;
    private int number;
    private int dealerPosition;
    private ArrayList<Definition> definitions = new ArrayList<Definition>();
    private Definition hint = null;
    private boolean completed = false;
    private int questionsAnswered = 0;
    private int questionsAnsweredTally = 0;

    /**
     * Construct a lesson stage, using the lesson panel and the message.
     * @param theLesson, the view to get the editor from.
     * @param theMessage, the lesson message.
     */
    public LessonStep(LessonView theLesson, String theMessage) {
        this.theLesson = theLesson;
        this.text = theMessage;
        this.theArrows = new ArrayList<Arrow>();
    }

    /**
     * @return, boolean representing if question has been answered before.
     */
    public boolean newQuestion() {
        if (questionsAnswered == questionsAnsweredTally) {
            return true;
        }
        return false;
    }

    /**
     * Updates the amount of questions answered for that stage.
     */
    public void updateQuestionsAnswered() {
        questionsAnswered++;
        updateTally();
    }

    public void updateTally() {
        questionsAnsweredTally++;
    }

    /**
     * @param a, the arrow to add to the lesson.
     */
    public void addArrow(Arrow a) {
        theArrows.add(a);
    }

    /**
     * @param d, the definition to add to the lesson.
     */
    public void addDefinition(Definition d) {
        definitions.add(d);
    }

    /**
     * Adds a hint for lessons with tests.
     * @param d 
     */
    public void addHint(Definition d) {
        hint = d;
    }

    public Definition getHint() {
        return hint;
    }

    /**
     * @param characterIndex, the character index the user is hovering over.
     * @return, a definition if there is one added for that index.
     */
    public Definition getDefinition(int characterIndex) {

        for (Definition d : definitions) {
            if (d.draw(characterIndex) == true) {
                return d;
            }
        }
        return null;
    }

    /**
     * Adds a game to the lesson.
     * @param number, the game number to add.
     * @param userDetails, the user details.
     * @param dealerPosition, the dealers position.
     */
    public void addGame(int number, User userDetails, int dealerPosition) {
        this.number = number;
        this.userDetails = userDetails;
        this.dealerPosition = dealerPosition;


        switch (number) {

            //Lesson One Games
            case 1:
                theGame = LessonOneGames.getGameOne(userDetails, theLesson, dealerPosition);
                break;
            case 2:
                theGame = LessonOneGames.getGameTwo(userDetails, theLesson);
                break;
            case 3:
                theGame = LessonOneGames.getGameThree(userDetails, theLesson, dealerPosition);
                break;
            case 4:
                theGame = LessonOneGames.getGameFour(userDetails, theLesson);
                break;
            case 5:
                theGame = LessonOneGames.getGameFive(userDetails, theLesson);
                break;
            case 6:
                theGame = LessonOneGames.getGameSix(userDetails, theLesson);
                break;
            case 7:
                theGame = LessonOneGames.getGameSeven(userDetails, theLesson);
                break;
            case 8:
                theGame = LessonOneGames.getGameEight(userDetails, theLesson);
                break;
            case 9:
                theGame = LessonOneGames.getGameNine(userDetails, theLesson);
                break;
            case 10:
                theGame = LessonOneGames.getGameTen(userDetails, theLesson);
                break;
            //Lesson Two Games
            case 11:
                theGame = LessonTwoGames.getGameOne(userDetails, theLesson);
                break;
            case 12:
                theGame = LessonTwoGames.getGameTwo(userDetails, theLesson);
                break;
            case 13:
                theGame = LessonTwoGames.getGameThree(userDetails, theLesson);
                break;
            case 14:
                theGame = LessonTwoGames.getGameFour(userDetails, theLesson);
                break;
            case 15:
                theGame = LessonTwoGames.getGameFive(userDetails, theLesson);
                break;
            //Lesson Three Games
            case 16:
                theGame = LessonThreeGames.getGameOne(userDetails, theLesson);
                break;
            case 17:
                theGame = LessonThreeGames.getGameTwo(userDetails, theLesson);
                break;
            case 18:
                theGame = LessonThreeGames.getGameThree(userDetails, theLesson);
                break;
            case 19:
                theGame = LessonThreeGames.getGameFour(userDetails, theLesson);
                break;
            case 20:
                theGame = LessonThreeGames.getGameFive(userDetails, theLesson);
                break;
            //Lesson Four Games
            case 21:
                theGame = LessonFourGames.getGameOne(userDetails, theLesson);
                break;
            case 22:
                theGame = LessonFourGames.getGameTwo(userDetails, theLesson);
                break;
            case 23:
                theGame = LessonFourGames.getGameThree(userDetails, theLesson);
                break;
            case 24:
                theGame = LessonFourGames.getGameFour(userDetails, theLesson);
                break;
            case 25:
                theGame = LessonFourGames.getGameFive(userDetails, theLesson);
                break;
            case 26:
                theGame = LessonFourGames.getGameSix(userDetails, theLesson);
                break;
            case 27:
                theGame = LessonFourGames.getGameSeven(userDetails, theLesson);
                break;
            case 28:
                theGame = LessonFourGames.getGameEight(userDetails, theLesson);
                break;
            case 29:
                theGame = LessonFourGames.getGameNine(userDetails, theLesson);
                break;
            //Lesson Five Games
            case 30:
                theGame = LessonFiveGames.getGameOne(userDetails, theLesson);
                break;
            case 31:
                theGame = LessonFiveGames.getGameTwo(userDetails, theLesson);
                break;
            case 32:
                theGame = LessonFiveGames.getGameThree(userDetails, theLesson);
                break;
            case 33:
                theGame = LessonFiveGames.getGameFour(userDetails, theLesson);
                break;
            case 34:
                theGame = LessonFiveGames.getGameFive(userDetails, theLesson);
                break;
            //Lesson Six Games
            case 35:
                theGame = LessonSixGames.getGameOne(userDetails, theLesson);
                break;
            case 36:
                theGame = LessonSixGames.getGameTwo(userDetails, theLesson);
                break;
            case 37:
                theGame = LessonSixGames.getGameThree(userDetails, theLesson);
                break;
            case 38:
                theGame = LessonSixGames.getGameFour(userDetails, theLesson);
                break;
            case 39:
                theGame = LessonSixGames.getGameFive(userDetails, theLesson);
                break;
            case 40:
                theGame = LessonSixGames.getGameSix(userDetails, theLesson);
                break;
        }

    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public final void display() {
        displayMessage();
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }

    public int getQuestionsAnsweredTally() {
        return questionsAnsweredTally;
    }

    public void setQuestionsAnswered(int questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public void setQuestionsAnsweredTally(int questionsAnsweredTally) {
        this.questionsAnsweredTally = questionsAnsweredTally;
    }

    /**
     * @return, boolean representing whether lesson stage completed or not.
     */
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<Arrow> getArrows() {
        return theArrows;
    }

    public LessonGame getGame() {
        return theGame;
    }

    /**
     * Sets the text in the JEditor.
     */
    private void displayMessage() {


        theLesson.getLabel().setText(text);

        theLesson.getScore().hideFeedback();

        if (theGame != null) {
            addGame(number, userDetails, dealerPosition);
            theLesson.setupGame(theGame);
        }
    }
}
