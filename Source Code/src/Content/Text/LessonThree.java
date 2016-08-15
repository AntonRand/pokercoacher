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
 * @author Anton
 */
public class LessonThree {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson Three<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will introduce you to the concept of bluffing, something that every player needs to carry out to improve their chances of winning tournaments.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You will learn what the risks and best conditions for bluffing are, so you can maximise the chances of your bluffs being successful.</p> "
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">After taking the lesson you will understand why players choose to bluff, what the types of bluffing are and you will have learnt how to make sensible decisions on when to bluff.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>What is Bluffing?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Bluffing is a strategy which when applied correctly can lead to significant chip gains. If you do not bluff you're unlikely to win tournaments because you rarely have a strong <u>hand</u>, so you have to make your own luck.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Bluffing involves betting a large amount of chips to deceive other players into thinking you have a strong hand, when in reality you have a weak hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The aim of bluffing is to make all of the other players fold so that you win the <u>pot</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">It can backfire on you if another player calls your bluff, as your weak cards are highly unlikely to win.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.hand(205, 207));
        stage.addDefinition(Definitions.pot(478, 479));
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Types of Bluff<br>Pure Bluff</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There are two different types of bluff, the first is known as the pure bluff.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">A pure bluff is when you have a poor hand which has little or no chance of improving in future stages such as the <u>turn</u> or <u>river</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">An example of a pure bluff is if the player decides to <u>raise</u> in the following situation:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hole Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Community Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> Q<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.turn(220, 222));
        stage.addDefinition(Definitions.river(228, 232));
        stage.addDefinition(Definitions.raise(290, 293));
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Types of Bluff<br>Pure Bluff</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♦</font> | "
                + "A<font color=red style='font-size:140%'>♥</font> Q<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Why is this a pure bluff?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The player only has a <u>high card</u>, there is no chance of them getting a <u>flush</u> or <u>straight</u> and all of the community cards are higher than the players hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">It is very likely one of the other players has a stronger hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This is why it is an example of a pure bluff, it's highly unlikely that the player's hand will get any stronger on the turn or river.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.highcard(93, 101));
        stage.addDefinition(Definitions.flush(141, 145));
        stage.addDefinition(Definitions.straight(150, 157));
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Types of Bluff<br>Semi Bluff</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The second type of bluff is known as the semi bluff.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">A semi bluff is when you have a weak hand that stands a reasonable chance of improving in future stages.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">An example of a semi bluff is if the player decides to raise in the following situation:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hole Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 4<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Community Cards:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">6<font color=red style='font-size:140%'>♥</font> 8<font color=red style='font-size:140%'>♦</font> Q<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Types of Bluff<br>Semi Bluff</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 4<font color=red style='font-size:140%'>♦</font> | "
                + "6<font color=red style='font-size:140%'>♥</font> 8<font color=red style='font-size:140%'>♦</font> Q<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">What is this a semi bluff?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Although the player doesn't have anything yet there is a chance of a 5 coming up on the turn or river.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a 5 comes up the player will have a <u>straight</u>, which is a strong hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This is why it is an example of a semi bluff, there is a chance that the player's hand could get stronger on the turn or river, because they are only one card away from making the strong hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.straight(213, 220));
        allStages.add(stage);

       //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Analyse the Situation</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">To determine whether or not you are in a suitable situation to bluff you need to consider several possible conditions.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Before explaining the conditions it is important to firstly emphasise that you should constantly be analysing the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You should think about how players are likely to react to your raises, if you notice for instance that a player has been calling other peoples raises frequently with average hands you should be wary of bluffing them, because they may call your bluff.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing Conditions<br>Position</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The first and most important condition you should consider is <u>position</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you are one of the first to act (in an <u>early position</u>) you should not consider bluffing, because you do not know what actions the other players will take. The player to act after you may have a strong hand and be about to raise, so bluffing is too risky.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you are the last person to act (in a <u>late position</u>) you should consider bluffing depending on other conditions.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.position(92, 99));
        stage.addDefinition(Definitions.earlyposition(145, 157));
        stage.addDefinition(Definitions.lateposition(401, 412));
        allStages.add(stage);

       //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing Conditions<br>Few Opponents</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The second condition you should consider is the amount of opponents left in the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Even if you are in a <u>late position</u> you should only consider bluffing if there are only 1 or 2 other players involved in the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This is because with a high number of participating players it is more likely a player will have a stronger hand than you and call/raise your bluff.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">With more players involved there is even a chance that one of them could try to bluff you.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.lateposition(143, 154));
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing Conditions<br>Uncommitted Players</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The third condition you should consider is the type of players involved in the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players who are reluctant to commit chips and check until they hit a strong hand are known as passive players.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Passive players often fold hands if you bet aggressively against them, taking away their chance to hit a strong hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have identified the other players in the hand as being passive, bluffing would be a good strategy because their reluctance to commit chips is likely to win you the pot.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing Conditions<br>Pot Size</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The fourth condition you should consider is the size of the <u>pot</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players who have committed a moderate amount of chips into a pot will often be reluctant to fold. They will usually call any bet in the hope of winning because they are too stubborn to fold and lose the chips they have already bet.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If the pot is large, players will be less willing to fold and let you win the pot, so you shouldn't bluff in these circumstances, because their medicore hand will still beat your weak hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.pot(91, 92));
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">How Much To Bluff By?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There is no universal method or formula to work out how much to bluff by.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">A general rule would be to bet more than half of the pot but no more than the pot. More than half so that the bet is aggressive enough to put players off, but less than the pot because you don't want to be seen as being too aggressive or players might get suspicious.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The more you bet the more likely you are to put players off, but the more damaging it will be if your bluff gets called.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">There are no guarantees when bluffing, but if you take all the different conditions set out in this lesson into account, you should find yourself making less errors when deciding to bluff.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Test Yourself 1/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Now that you have learnt the main conditions for bluffing, think about whether you could bluff in the following scenario.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">After going in the hand with strong hole cards, you have been raised on the flop. What should you do?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Remember to bluff you need to bet more than half the size of the pot but less than the whole pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand and make your decision...</b></p>"
                + "</html>");
        stage.addGame(16, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Michaels raise shows confidence, do you think he would be", "put off by a raise after already raising himself?"));
        allStages.add(stage);

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Test Yourself 2/5"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You went into the hand because you were the big blind, not because you had strong cards. 3 other players chose to call and the action starts on you after the flop.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Remember to bluff you need to bet more than half the size of the pot but less than the whole pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand and make your decision...</b></p>"
                + "</html>");
        stage.addGame(17, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "Your position makes it unwise to bluff, but you shouldn't", "fold if you have the option to check."));
        allStages.add(stage);

        //Message 15
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Test Yourself 3/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You called with high valued connected cards but the flop hasn't been good to you. However, you have identified Emily and Michael as passive players and they both decide to check, the action is on you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Remember to bluff you need to bet more than half the size of the pot but less than the whole pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand and make your decision...</b></p>"
                + "</html>");
        stage.addGame(18, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "You have the benefit of late position, and there are only two", "players in the hand. Bluffing is very effective against these two", "'passive' players.."));
        allStages.add(stage);

        //Message 16
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Test Yourself 4/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You rather foolishly went into the hand with weak cards and called a bet on the flop even though you had nothing. The action is on you with $50 to call, should you bluff, call or fold?</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Remember to bluff you need to bet more than half the size of the pot but less than the whole pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand and make your decision...</b></p>"
                + "</html>");
        stage.addGame(19, v.getUserDetails(), 0);
        stage.setAction("Start");
        stage.addHint(new Definition(1, 34, "Hint", "There are too many people in the hand to bluff and the odds", "are that somebody has you beat. It's not worth being in", "the hand."));
        allStages.add(stage);

        //Message 17
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Bluffing<br>Test Yourself 5/5</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You made another bad judgement and went into the hand with weak cards. You called a bet on the flop as you were one away from a straight. The turn card wasn't good to you but both players check, the action is on you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Remember to bluff you need to bet more than half the size of the pot but less than the whole pot.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand and make your decision...</b></p>"
                + "</html>");
        stage.addGame(20, v.getUserDetails(), 0);
        stage.setAction("StartEnd");
        stage.addHint(new Definition(1, 34, "Hint", "You are only one card away from a straight, the pot is small", "and there are only 2 other players involved so a bluff", "would be a good option here."));
        allStages.add(stage);

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;
    }
}