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
 * Hand Strength Lesson
 * @author Anton
 */
public class LessonTwo {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Two<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">Every player can use the <u>community cards</u> to make their best hand, so it is essential that you give yourself an advantage by only playing hands when your <u>hole cards</u> are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">This lesson will help you understand what makes some hole cards stronger and more likely to win than others.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You will learn how to determine the stength of your hole cards so that you can make better <u>pre-flop</u> decisions which will"
                + " improve your ratio of <u>hands</u> won and prevent you wasting chips on weak hole cards.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.communityCards(54, 68));
        stage.addDefinition(Definitions.holeCards(182, 190));
        stage.addDefinition(Definitions.preflop(405, 412));
        stage.addDefinition(Definitions.hand(457, 461));
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Pocket Pairs</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The first thing you should check is whether you have a pocket pair or not.<br><br>A pocket pair is when both of your hole cards are the same value.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">Typical examples include: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> A<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">4<font color=red style='font-size:140%'>♥</font> 4<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=black style='font-size:140%'>♣</font> 7<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">J<font color=red style='font-size:140%'>♦</font> J<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">2<font color=black style='font-size:140%'>♠</font> 2<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">K<font color=red style='font-size:140%'>♥</font> K<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Pocket Pairs</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As a general rule you should only play <u>pocket pairs</u> that are above 6.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pocket pairs are strong because you know you have at least a pair before any of the <u>community cards</u> are revealed.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have a pocket pair you do not need to consider any of the upcoming conditions.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There are special terms given for specific pocket pairs:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pocket Ace's are commonly known as '<b>Bullets</b>'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pocket Jacks's are commonly known as '<b>Hooks</b>'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pocket 2's are commonly known as '<b>Deuces</b>'.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.pocketpair(68, 78));
        stage.addDefinition(Definitions.communityCards(183, 196));
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>High Valued Cards</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you do not have a <u>pocket pair</u> the next thing you should check is if your hole cards are of a high value.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">High value means 10 or higher, so if your lowest card is below 10 you do not have high valued cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The value of cards is important, If you went in a hand with low value cards and managed to get a <u>pair</u> or <u>two pair</u> the odds are still against you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Example:</b> If you got a pair of 2's on the <u>flop</u> there are 12 higher pairs which can beat your hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Considering that the odd's of a player getting a pair or better is roughly 50% you should see that with 2 other people in a hand one of them is likely to have you beat.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.pocketpair(55, 65));
        stage.addDefinition(Definitions.pair(340, 343));
        stage.addDefinition(Definitions.twopair(348, 355));
        stage.addDefinition(Definitions.flop(430, 433));
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>High Valued Cards</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The suit isn't relevant when taking the value of your cards into consideration.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Typical examples of <u>high valued cards</u> include: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> 10<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">K<font color=red style='font-size:140%'>♦</font> J<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">Q<font color=red style='font-size:140%'>♦</font> K<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">J<font color=black style='font-size:140%'>♠</font> 10<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">K<font color=red style='font-size:140%'>♦</font> 10<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">10<font color=black style='font-size:140%'>♣</font> A<font color=red style='font-size:140%'>♥</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.highvaluecards(134, 149));
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Connected Cards</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The next thing you should check with your hole cards is if they are connected.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">Connected means that it would be possible to combine your hole cards with 3 other cards to form a <u>straight</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">This is why connected cards are beneficial, you are more likely to get a straight because you only need to rely on 3 community cards coming up instead of 4.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">Typical examples include: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> 10<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">2<font color=red style='font-size:140%'>♦</font> 3<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=black style='font-size:140%'>♣</font> 4<font color=red style='font-size:140%'>♥</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.straight(209, 215));
        allStages.add(stage);

        //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Suited Cards</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The final thing you should check is if your hole cards are suited.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Suited means that both your hole cards are the same suit, whereas 'off suit' means the suits of your hole cards are different.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Suited cards are beneficial because it improves the probability of you getting a <u>flush</u>, the value of the cards isn't relevant.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Typical examples include: </p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">7<font color=black style='font-size:140%'>♣</font> 6<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">9<font color=red style='font-size:140%'>♦</font> A<font color=red style='font-size:140%'>♦</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.flush(304, 307));
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Making a Decision</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are now ready to make a decision on whether you should go in the hand or not:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;text-align:center;font-weight:bold;\">Pocket Pairs</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If you have <u>pocket pairs</u> you should only play them if they are above 6.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;text-align:center;font-weight:bold;\">Not Pocket Pairs</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If you don't have pocket pairs you need to analyse if your cards are <u>high valued</u>, <u>connected</u> or <u>suited</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If your cards were high valued and connected you have strong hole cards and should play the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If your cards were high valued, connected and suited you should also play the hand, you have an even better chance of winning.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You should fold any other hands.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.pocketpair(141, 152));
        stage.addDefinition(Definitions.highvaluecards(287, 297));
        stage.addDefinition(Definitions.connectedcards(300, 308));
        stage.addDefinition(Definitions.suitedcards(313, 318));
        allStages.add(stage);

        //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Making a Decision</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Note:</b> <u>high valued</u> and <u>connected cards</u> are very similar, the difference is that all high value cards (not including pocket pairs) are connected, but not all connected cards are high valued.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;font-weight:bold;\">Example:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">4<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">is connected, but it is not high valued.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">It is easy to be tempted with average value cards that are <u>suited</u> and connected but they are likely to lose out to higher cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">It is important to be disciplined and only play high valued cards that are connected to start with until you have enough chips to be able to take risks.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.highvaluecards(39, 49));
        stage.addDefinition(Definitions.connectedcards(56, 69));
        stage.addDefinition(Definitions.suitedcards(308, 313));
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Test Yourself 1/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following tests are designed to see if you have learnt how to analyse your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You need to decide whether to fold because your hole cards are weak or call/raise because your hole cards are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are only assessed on your preflop decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(11, v.getUserDetails(), 0);
          stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "Should you go in the hand if you have pocket pairs", "below 6?"));
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Test Yourself 2/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following tests are designed to see if you have learnt how to analyse your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You need to decide whether to fold because your hole cards are weak or call/raise because your hole cards are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are only assessed on your preflop decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(12, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "Should you go in the hand if you have pocket pairs over 6?"));
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Test Yourself 3/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following tests are designed to see if you have learnt how to analyse your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You need to decide whether to fold because your hole cards are weak or call/raise because your hole cards are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are only assessed on your preflop decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(13, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "Should you go in the hand if you have high valued and", "connected cards?"));
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Test Yourself 4/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following tests are designed to see if you have learnt how to analyse your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You need to decide whether to fold because your hole cards are weak or call/raise because your hole cards are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are only assessed on your preflop decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(14, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "Should you go in the hand if you have high valued,", "suited and connected cards?"));
        allStages.add(stage);

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Strength<br>Test Yourself 5/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following tests are designed to see if you have learnt how to analyse your hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You need to decide whether to fold because your hole cards are weak or call/raise because your hole cards are strong.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">You are only assessed on your preflop decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(15, v.getUserDetails(), 0);
        stage.addHint(new Definition(0, 50, "Hint", "Should you go in the hand if you only have suited", "hole cards?"));
        stage.setAction("StartEnd");
        allStages.add(stage);

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;
    }
}
