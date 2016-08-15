/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Content.Text;

import Lesson.Lesson;
import Lesson.LessonView;
import Lesson.LessonStep;
import Primitives.Definition;
import java.util.ArrayList;

/**
 * Bluffing Lesson
 * Explanation of some terms from - http://www.pokerschoolonline.com/articles/Glossary
 * @author Anton
 */
public class LessonSix {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Six<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Why is position important and how should it effect how we play our hands?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will teach you why position is important, explaining how being in a bad position weakens your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The lesson will introduce numerous terms including: early, middle and late position. It will explain the advantages and disadvantages of each one.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">After completing the lesson you will understand the importance of position and make better decisions, position is important and many beginners tend to ignore it. The slightest bit of additional information can have a big influence on the decision you should take.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position Types</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There are 3 different terms to describe your position on the table.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Early, middle and late position.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Early, middle and late position is usually split evenly. So if there are 9 players you would have 3 players in each position.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As the dealer is rotated after each hand, the positions are evenly distributed over the course of the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Position is more important when there are a large amount of players still in the game. If you play heads up (against one opponent) you should pay less attention to position.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Early Position</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players who are first to act are said to be in an 'early position', meaning that they need to make a decision earlier than most other players.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The big blind and small blind are early position players, because they are first to act post flop and although they are last to act pre flop they placed a forced bet from the start.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If the number of players still left in the game is high the player to the left of the big blind is also said to be in 'early position'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The player to the left of the big blind is the first person to act pre flop. This player is said to be 'under the gun'</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Late Position</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players who are last to act are said to be in an 'late position', meaning that they get to see the other players actions before they need to act.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The dealer is a late position player, because they will always be last to act post flop and they are the last person to act pre flop without posting a blind.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Depending on the amount of players remaining the first one or two players to the right of the dealer are also said to be in a late position.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Middle Position</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The remaining players are said to be in 'middle position'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">They are neither first or last to act.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The advantages and disadvantages of each position will now be explained...</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Early Position Advantages/Disadvantages</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><u>Early position</u> is the worst position to be in. This is because you do not know the actions that the other players will take.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As you do not know what actions the <u>middle</u> and <u>late</u> players will take you should only play hands where raises will not cause you to fold. You should only go in with really strong hole cards, the lack of information makes your hole cards weaker.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You should typically only play pocket pairs from Ace's to 10's when you are in early position as well as AK, AQ or AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The only advantage you have in early position is that any raises you make are taken more seriously because you have show confidence in your hand without information available to you.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.earlyposition(42, 54));
        stage.addDefinition(Definitions.middleposition(203, 207));
        stage.addDefinition(Definitions.lateposition(213, 216));
        allStages.add(stage);

        //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Middle Position Advantages/Disadvantages</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Middle position is neither the worst or best position to be in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You have the advantage of seeing what action the early position players take, but you don't know what the action the late position players will take.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">With this added degree of confidence you should be less strict on which cards to play, so any high valued connected cards are playable.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">A disadvantage of being in the middle position is that you are at risk of being 'squeeze played'. This is when you call the bet of an early position player but a late position player raises further in an attempt to persuade you to fold.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Late Position Advantages/Disadvantages</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Late position is the best position to be in, you know the actions of the other players so you can analyse this to take an appropriate action.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In late position you can play slightly weaker cards than you would in middle position. You can play connected cards with values of 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Another advantage of being in a late position is that it is the only suitable position for bluffing, as explained in lesson 3.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You have more power over the pot, you have the opportunity to 'squeeze play' other players and raise the amount to call after they have already committed chips.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 1/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>"
                + "</html>");
        stage.addGame(35, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Do you have any of the early position hands?"));
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 2/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>" + "</html>");
        stage.addGame(36, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Do you have any of the early position hands?"));
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 3/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>" + "</html>");
        stage.addGame(37, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Do you have connected cards 9 or above?"));
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 4/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>" + "</html>");
        stage.addGame(38, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Do you have connected cards 9 or above?"));
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 5/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>" + "</html>");
        stage.addGame(39, v.getUserDetails(), 0);
        stage.setAction("Start");
        allStages.add(stage);
        stage.addHint(new Definition(1, 34, "Hint", "Do you have high valued connected cards?"));

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Position<br>Test Yourself 6/6</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to determine what position you are in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In early position you should only go in with AA, KK, QQ, JJ, 10 10, AK, AQ, AJ.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In middle position you should only go in with high valued connected cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">- In late position you should only go in with connected cards 9 or above.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have determined your position, take the appropriate action.</p>" + "</html>");
        stage.addGame(40, v.getUserDetails(), 0);
        stage.setAction("StartEnd");
        allStages.add(stage);
        stage.addHint(new Definition(1, 34, "Hint", "Do you have high valued connected cards?"));

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;

    }
}
