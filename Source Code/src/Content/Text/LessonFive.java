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
 * This lesson is heavily based on content from:
 * http://www.pokersavvy.com/Texas-holdem/post-flop-strategy.html
 * 
 * I have designed similar examples and the explanations are very similar.
 * @author Anton
 */
public class LessonFive {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Five<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will guide you through 5 hands, providing an insight into what you should look out for after the flop, you should begin to develop an understanding into why players might take the actions that they did during the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The lesson will help you analyse the cards, other players actions and get you to think about the odds of your hand winning.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Combining these 3 key points, you will learn how to make better post flop decisions.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop Strategy</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Deciding what actions to take after the flop is more difficult than for the pre flop. There is an increase in the possible hands the other players have now that the community cards have been dealt, so you should need to analyse the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You can analyse a hand by taking the following 3 points into consideration:<br><br>"
                + "- The strength of your hand<br><br>"
                + "- The percieved strength of other players hands based on their actions<br><br>"
                + "- The probability you have the strongest hand"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop Strategy</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Read through the commentary for each hand, when you are confident you understand why you should take that action you should run the simulation and take the suggested action.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">These simulations are designed to give you a basic understanding of what conditions you should take into account so that you can take a well judged decision on the action to take..</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 1</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You confidently raised with pocket pairs before the flop and Louise and Emily called you.<br><br>After betting on the flop to encourage Louise and Emily to fold you were raised by Louise and Emily called.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The first thing you should analyse is the strength of your hand. Pocket Jack's are easily beatable with this flop, Emily or Louise may have a pair of Queen's or a pair of Ace's which would have you beat.</p>"
                + "</html>");
        stage.addGame(30, v.getUserDetails(), 0);
        stage.setAction("Start");
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 1</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Players Actions</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The second thing to analyse is the actions of the other players.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Louise's re-raise is a sign of strength, it is likely that she has an Ace or a Queen.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Emily's call instead of a raise may indicated she is still looking to hit her hand, she may be one card away from a flush.</p>"
                + "</html>");
        stage.addGame(30, v.getUserDetails(), 0);
        stage.setAction("Start");
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 1</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Odds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">To stand any chance of winning this hand you would need another Jack to be dealt on the turn or river.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The odds of this happening are slim, you have roughly 4% chance of a Jack being dealt on the turn or river, but if the Jack of hearts is dealt, Emily may have hit her flush.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Action</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Fold</b>, the flop was bad, the players actions are discouraging and the odds are not not in your favour.</p>"
                + "</html>");
        stage.addGame(30, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Click the fold button."));
        allStages.add(stage);

        //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 2</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">After confidently raising with high valued connected cards before the flop Emily called. She was first to act after the flop and raised you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Your hand is strong, you have made a pair with the highest card on the flop and if Emily also has a pair of Queen's you stand a good chance of beating her with the Ace as a kicker card.</p><br>"
                + "</html>");
        stage.addGame(31, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 2</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Players Actions</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The raise shows that she has confidence in her hand, but she can't have a flush or straight and it looks highly unlikely that she would get one on the turn or river.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The raise most likely indicates that she has top pair (Queens). So we would have the advantage over her.</p>"
                + "</html>");
        stage.addGame(31, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 2</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Odds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You are the favourite to win this hand. The odds of Emily having a three of a kind or two pair are negligible. It looks like the best hand she has is a pair of Queens with a lower kicker than you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Action</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Re-raise</b>, the community cards were good, Emily only raised you the minimum amount and the odds are in your favour.</p>"
                + "</html>");
        stage.addGame(31, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Type in an amount to bet or click the raise button."));
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 3</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You felt confident with your hole cards so you called to see if you could develop a strong hand on the flop. 4 other players also went into the hand. Being the first to act after the flop Louise raised and the other 3 players all folded.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You didn't develop a strong hand on the flop, but you are 1 card off a flush. With a small chance of hitting a straight.</p>"
                + "</html>");
        stage.addGame(32, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 3</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Players Actions</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The raise suggests Louise has a strong hand, she is likely to have you beat currently, but the raise could be an attempt to make us fold before we get the chance to persue a flush.</p>"
                + "</html>");
        stage.addGame(32, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 3</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Odds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Although the odds of getting a flush in this hand is low (Approx 20%) the bet was small. If Louise had bet much more the decision would be harder to make.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Action</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Call</b>, although the odds are low there are 2 more community cards to be dealt, and the small bet means we don't stand to lose much if we fail to hit the flush.</p>"
                + "</html>");
        stage.addGame(32, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Click the call button."));
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In this hand you have called pre flop with strong hole cards, the flop was the same as the previous example, but this time you are in Louise's position in the previous hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You have have the highest pair, which is fairly strong. The problem is that there are 2 cards of the same suit on the board.</p>"
                + "</html>");
        stage.addGame(33, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Players Actions</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">We do not know about other players actions as we are in early position, as you are the first player to act you cannot base your decision on any information. You know it is unlikely the other players have a stronger hand but in the last example they may be one off a flush.</p>"
                + "</html>");
        stage.addGame(33, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 15
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Odds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">We know the odds of other players getting a flush is fairly low. Other players probably have a pair but you have the top pair, so it is only the flush which is worrying.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Action</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Bet</b>, if you check you give the other players the opportunity to hit a flush, betting will encourage players to fold which will give you the best chance of winning.</p>"
                + "</html>");
        stage.addGame(33, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Type in an amount to bet or click the raise button."));
        allStages.add(stage);

        //Message 16
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You went in this hand and flopped a two pair, you bet at every stage until the river. Where a scare card made you weary, Alan raised you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The flop couldn't have been much better, you flopped a two pair but the strength of your hand was significantly weakened on the river.</p>"
                + "</html>");
        stage.addGame(34, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 17
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Players Actions</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You did your best to encourage players to fold before they had chance to hit a flush but they still called. The bet on the river indicates that Alan may have hit a flush. and Harry is yet to take an action.</p>"
                + "</html>");
        stage.addGame(34, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 18
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Odds</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The odds of one of the other players having a flush is quite high, their actions indicate that they were trying to hit a flush because they were not raising. The odds are not in your favour</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Action</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Call</b>, although the odds are not in your favour you were only raised the minimum amount and the pot is quite large. You still have a strong hand and should call on the off chance that you win. You'd only need to win 1 out of every 20 of these types of hands to earn your money back.</p>"
                + "</html>");
        stage.addGame(34, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Click the call button."));
        allStages.add(stage);

        //Message 19
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Post Flop<br>Example 5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Calling when you know you have probably lost is called a <b>Crying Call</b>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You should only do this in circumstances where the amount to call is low but the potential gain is very high. Usually when you can gain more than 20 times the amount to call.</p>"
                + "</html>");
        stage.addGame(34, v.getUserDetails(), 0);
        stage.setAction("End");
        allStages.add(stage);

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;
    }
}
