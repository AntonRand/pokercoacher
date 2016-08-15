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

/*
 * Slow Play and All In Lesson
 * M-Ratio took from: http://www.sitandgoplanet.com/multitable/mtt_strategy/Dan_Harrington_Poker_M_Zone.html
 * @author Anton
 */
public class LessonFour {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Four<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When you know you have the strongest <u>hand</u>, how should you play it? Should you raise or check?"
                + "<br><br>This lesson will teach you about the concept of slow playing, which is essentially the opposite of bluffing. "
                + "<br><br>Instead of making people think you have a strong hand, you want them to think you have a weak hand so they will be more likely to bet against you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will teach you how to effectively slow play, so that you can exploit aggressive players tendencies of raising, to maximise your chip gains.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.hand(67, 70));
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Four<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will also teach you how to play hands depending on your chip balance. It focuses on when the best time to go all in is as determined by a formula known as the M-Ratio.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The lesson will teach you how to calculate your M-Ratio and explain how you should act based on this calculated value.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Why is it useful?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When you know you have the best hand you need to think carefully about how to act in order to maximise chip gains.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you bet or raise, other players will be put off calling you because of the confidence you have shown in your hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">By only checking and calling, the other players will notice that you are playing the hand <u>passively</u>, leading them to believe you have a weak hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.passive(356, 364));
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Why is it useful?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When players believe you have a weak hand they are more likely to bet, to try to encourage you to fold so that they can win the pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When players begin raising you it is important to only call these bets and not raise further, as you don't want to give away the fact you have a strong hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once you have reached the river you can re-raise any bets because players will be now be reluctant to fold after committing so much into the pot and it doesn't matter if they realise you have a strong hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This is why slow playing is useful, you can earn more chips out of hands than you would by playing aggessively.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing Conditions<br>Strongest Hand</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Slow playing can only be done if you have the strongest hand, otherwise it is pointless as you will lose chips.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Example:</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hole Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">K<font color=red style='font-size:140%'>♥</font> Q<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Community Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">Q<font color=red style='font-size:140%'>♥</font> K<font color=red style='font-size:140%'>♦</font> K<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You know you have the strongest hand. Nobody other than you can get four of a kind, and a straight flush isn't possible.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing Conditions<br>Raising will cause folds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You should only slow play if you have reason to believe that betting or raising will cause players to fold.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This might apply if you are playing against passive players who are still waiting for a good hand, they will fold if you raise them.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If there are scare cards on the board raising could persuade aggressive players to fold. They will see calling as too risky given the show of strength from your raise.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you believe your raises will be called (not cause folds) you shouldn't slow play, this is because raising will provide more profit than checking.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp Slow Playing Conditions<br>Resiliant Hand</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You should only slow play if you are confident that the community cards dealt on the turn and river will not weaken the strength of your hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If there is a liklihood of your cards weakening you should bet to put players off seeing the next card/s, otherwise you'd be giving them a chance to beat your hand without them having to commit anything to see the next card/s.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp Slow Playing Conditions<br>Resiliant Hand</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Example:</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hole Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">10<font color=red style='font-size:140%'>♥</font> J<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Community Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">Q<font color=black style='font-size:140%'>♣</font> K<font color=red style='font-size:140%'>♦</font> A<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You have flopped a straight and have the best hand, but there are 2 clubs in the community cards. If another club comes out on the turn you cannot rule out the possibility of a player hitting a flush and beating you."
                + "<br><br>You need to bet here because your hand stands a significant chance of weakening.</p><br>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Vulnerable Players</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Aggressive players are particularly vulnerable to being slow played. They often misinterpret players who are slow playing as playing passively, and as they take more risks than other players this is to their disadvantage in the case of slow playing.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Aggressive players will often try to bully you out of the pot by betting large amounts, making them ideal players to profiteer off.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">It is important to keep disciplined however and only call aggressive players raises because this will frustrate them and make them likely to bet even more, allowing you to increase winnings.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Problems</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The main disadvantage of slow playing is that if you check and everybody else does then the other players have been given a chance to hit a stronger hand without any increase in the pot size.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This contradicts the aim of slow playing, but sadly there isn't much you can do to stop this happening. You are always relying on one of the other players deciding to bet.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Problems</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If there haven't been any bets after the river and you believe everybody will check again, you should bet the minimum amount in the hope of a player calling, because it is the last stage it doesn't matter if all the players fold as they weren't going to commit"
                + " to the pot anyway, so you have nothing to lose.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You are rarely priviliged with knowing you have the best hand, so it is important to make it count. Don't waste your hand by checking at the final stage if you feel other players won't raise you.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Underbetting</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">An alternative strategy to take when you have the strongest hand is called underbetting.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Underbetting is similar to slow playing as the aim is to maximise chip gains.<br><br>"
                + "The key difference is that you bet a small amount hoping that more people will call, as the bet isn't enough to encourage them to fold.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When many players call this small amount the pot size still builds up to a substantial amount.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Underbetting</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Underbetting is useful if in a hand:</p><br>"
                + "<hr><p style=\"font-family:arial;color:white;font-size:10px;\">1 person would call if you raised to $200</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">BUT</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">2 people would call if your raise was $150</p>"
                + "<br><hr><p style=\"font-family:arial;color:white;font-size:10px;\">By betting less you have added $300 to the pot instead of $200.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">It is often useful to mix underbetting with slow playing, it will make you less predictable as a player.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Test Yourself 1/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This test requires you to input 2 actions.<br><br>"
                + "You go in a hand against Alan. You believe he is an aggressive player and he confirms this by raising pre-flop.<br><br>"
                + "You flop a full house, and you are first to act.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Choose the appropriate action.</p>"
                + "</html>");
        stage.addGame(21, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "1. If you check will aggressive players be tempted to", "raise?", "2. The player has fell for your slow play, call them."));
        allStages.add(stage);

        //Message 15
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Test Yourself 2/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You go in a hand with Michael, whom you believe is a passive player.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Evaluate the strength of your hand, and choose the appropriate action.</p>"
                + "</html>");
        stage.addGame(22, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Do your cards stand a significant chance of", "weakening?"));
        allStages.add(stage);

        //Message 16
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Test Yourself 3/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You go into another hand with Michael, who you have successfully identified as a passive player.<br><br>"
                + "Evaluate the strength of your hand, and choose the appropriate action.</p>"
                + "</html>");
        stage.addGame(23, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Will Michael fold if you raise? If so you should check."));
        allStages.add(stage);

        //Message 17
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Slow Playing<br>Test Yourself 4/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This time you go into a hand with Emily as you were the big blind.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You chose to check on the flop but Emily raises.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Choose the appropriate action.</p>"
                + "</html>");
        stage.addGame(24, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "You need to have the strongest cards to slow play.", "Do you have the strongest cards?"));
        allStages.add(stage);

        //Message 18
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Underbetting<br>Test Yourself 5/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You go into a hand with Andy and Louise, in the last few hands you have observed that Andy has not been put off by high raises, but Louise has been reluctant to call high raises.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You need to decide whether to bet $400 or $250, what should you bet to maximise the pot amount?</p>"
                + "</html>");
        stage.addGame(25, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Is 2 times $250 more than $400?"));
        allStages.add(stage);

        //Message 19
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>Why go All In?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When your chip stack falls below a certain level, you have less influence on the game. Your ability to put players off with raises is reduced because you can't raise by a high enough amount.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Professional player Paul Magriel devised a formula to give you an indication of whether you should go all in or not.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This formula is known as the 'M-ratio'.</p>"
                + "</html>");
        stage.addGame(25, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 20
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>M-Ratio</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">To determine whether to go all in or not you must first determine your M-Ratio.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This is calculated as follows where:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp &nbsp &nbsp Chip Balance<br>M = ――――――――――――<br>&nbsp &nbsp &nbsp &nbsp Small Blind + Big Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The value of M represents the number of times the button can fully rotate around the table before you have no remaining chips.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">As the number of players still involved in the tornament varies the M value needs to be scaled to take this into account. This is done by multiplying the value of M by the ratio of players still involved in the game:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">M-Ratio = M x (Players Left / Total Players)</p>"
                + "</html>");
        stage.addGame(25, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 21
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">M-Ratio Zones</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There are 5 zones indicating how you should be playing your hands. Depending on the value of your M-Ratio.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#00ff00>Green Zone - M ≥ 20</font></b></center><br>You have the choice to play passive or aggressive.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffff00>Yellow Zone - 10 ≤ M < 20</font></b></center><br>You must take more risks.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffa500>Orange Zone - 6 ≤ M < 10</font></b></center><br>You don't necessarily have to go all in, but you should play very aggressively.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ff0000>Red Zone - 1 ≤ M < 6</font></b></center><br>You should to go all in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b>Dead Zone - M &lt 1</b></center><br>You need to be lucky to stay in the hand.</p>"
                + "</html>");
        stage.addGame(25, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 22
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you find yourself in the red zone you need to go all in for the next hand you decide is strong enough.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the ideal world you would be dealt strong cards to go all in with but as this doesn't happen often you should take more risks. It is acceptable to go all in with average hands, depending on your position.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you decide to go all in you should either have strong cards or be one of the first players to act. If you are the last to act and everybody has called it is likely that other players will match your raise.</p>"
                + "</html>");
        stage.addGame(25, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 23
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>Test Yourself 6/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Analyse your M-Ratio for the following hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp &nbsp &nbsp Chip Balance<br>M = ――――――――――――<br>&nbsp &nbsp &nbsp &nbsp Small Blind + Big Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#00ff00>Green Zone - M ≥ 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffff00>Yellow Zone - 10 ≤ M < 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffa500>Orange Zone - 6 ≤ M < 10</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ff0000>Red Zone - 1 ≤ M < 6</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b>Dead Zone - M &lt 1</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Decide whether you should be going all in with your hole cards, as determined by your M-Ratio.</p>"
                + "</html>");
        stage.addGame(26, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "You have strong cards and a low M-ratio so you", "should go all in."));
        allStages.add(stage);

        //Message 24
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>Test Yourself 7/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Analyse your M-Ratio for the following hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp &nbsp &nbsp Chip Balance<br>M = ――――――――――――<br>&nbsp &nbsp &nbsp &nbsp Small Blind + Big Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#00ff00>Green Zone - M ≥ 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffff00>Yellow Zone - 10 ≤ M < 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffa500>Orange Zone - 6 ≤ M < 10</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ff0000>Red Zone - 1 ≤ M < 6</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b>Dead Zone - M &lt 1</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Decide whether you should be going all in with your hole cards, as determined by your M-Ratio.</p>"
                + "</html>");
        stage.addGame(27, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Your influence is weak, you need to go all in before", "it gets weaker."));
        allStages.add(stage);

        //Message 25
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>Test Yourself 8/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Analyse your M-Ratio for the following hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp &nbsp &nbsp Chip Balance<br>M = ――――――――――――<br>&nbsp &nbsp &nbsp &nbsp Small Blind + Big Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#00ff00>Green Zone - M ≥ 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffff00>Yellow Zone - 10 ≤ M < 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffa500>Orange Zone - 6 ≤ M < 10</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ff0000>Red Zone - 1 ≤ M < 6</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b>Dead Zone - M &lt 1</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Decide whether you should be going all in with your hole cards, as determined by your M-Ratio.</p>"
                + "</html>");
        stage.addGame(28, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "What should you do with an M-ratio between 1 and 6?"));
        allStages.add(stage);

        //Message 26
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">All In<br>Test Yourself 9/9</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Analyse your M-Ratio for the following hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">&nbsp &nbsp &nbsp Chip Balance<br>M = ――――――――――――<br>&nbsp &nbsp &nbsp &nbsp Small Blind + Big Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#00ff00>Green Zone - M ≥ 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffff00>Yellow Zone - 10 ≤ M < 20</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ffa500>Orange Zone - 6 ≤ M < 10</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b><font color=#ff0000>Red Zone - 1 ≤ M < 6</font></b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;\"><b>Dead Zone - M &lt 1</b></center></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Decide whether you should be going all in with your hole cards, as determined by your M-Ratio.</p>"
                + "</html>");
        stage.addGame(29, v.getUserDetails(), 0);
        stage.setAction("StartEnd");
        stage.addHint(new Definition(1, 34, "Hint", "You are in the green zone. You can play however", "you like."));
        allStages.add(stage);

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;
    }
}
