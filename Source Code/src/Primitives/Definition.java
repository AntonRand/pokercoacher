/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

/**
 * Definition Class.
 * @author Anton
 */
public class Definition {

    private int startingCharIndex, endCharIndex;
    private String title;
    private String lineOne = "", lineTwo = "", lineThree = "";

    /**
     * Create a one line definition.
     * @param startingChar, the start of the word.
     * @param endChar, the end of the word.
     * @param title, the definition title.
     * @param definitionOne, the first definition line.
     */
    public Definition(int startingChar, int endChar, String title, String definitionOne) {
        this.startingCharIndex = startingChar;
        this.endCharIndex = endChar;
        this.title = title;
        this.lineOne = definitionOne;
    }

    /**
     * Create a two line definition.
     * @param startingChar, the start of the word.
     * @param endChar, the end of the word.
     * @param title, the definition title.
     * @param definitionOne, the first definition line.
     * @param definitionTwo, the second definition line.
     */
    public Definition(int startingChar, int endChar, String title, String definitionOne, String definitionTwo) {
        this.startingCharIndex = startingChar;
        this.endCharIndex = endChar;
        this.title = title;
        this.lineOne = definitionOne;
        this.lineTwo = definitionTwo;
    }

    /**
     * Create a three line definition.
     * @param startingChar, the start of the word.
     * @param endChar, the end of the word.
     * @param title, the definition title.
     * @param definitionOne, the first definition line.
     * @param definitionTwo, the second definition line.
     * @param definitionThree, the third definition line.
     */
    public Definition(int startingChar, int endChar, String title, String definitionOne, String definitionTwo, String definitionThree) {
        this.startingCharIndex = startingChar;
        this.endCharIndex = endChar;
        this.title = title;
        this.lineOne = definitionOne;
        this.lineTwo = definitionTwo;
        this.lineThree = definitionThree;
    }

    /**
     * If the mouse is between the word indexes the definition should be drawn.
     * @param characterIndex, where the mouse is over.
     * @return, true if the definition should be drawn.
     */
    public boolean draw(int characterIndex) {
        if (characterIndex >= startingCharIndex && characterIndex <= endCharIndex) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDefinitionOne() {
        return lineOne;
    }

    public String getDefinitionTwo() {
        return lineTwo;
    }

    public String getDefinitionThree() {
        return lineThree;
    }
}
