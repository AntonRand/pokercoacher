/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Content.Text;

import Lesson.Lesson;
import Lesson.LessonView;
import Lesson.LessonStep;
import Primitives.Definition;
import Tools.Utilities;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Introductory Lesson
 * @author Anton
 */
public class LessonOne {

    public static Lesson getContent(LessonView v) {

        ArrayList<LessonStep> allStages = new ArrayList<LessonStep>();

        //Message 1
        LessonStep stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Lesson One<br>Lesson Overview</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This lesson will explain the basics of Texas hold 'em poker. It will teach you the aim of the game, as well as explain the rules.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">You will be taught how to distinguish between the different <u>hand</u> categories and you will learn what happens in numerous edge case scenarios so that you won't be confused if they occur to you in tournaments.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">At the end of the lesson you will be tested by playing numerous <u>hands</u> to get you used to playing.</p>"
                + "</html>");
        stage.addDefinition(Definitions.hand(219, 221));
        stage.addDefinition(Definitions.hand(429, 433));
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 2
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>The Aim</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The aim of Texas hold 'em is to maximise your chip balance by betting tactically against other players.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">A game is made up of numerous <u>hands</u>. The game is over when there is only one player remaining, who is crowned the winner.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players are knocked out of the game when they go <u>all in</u> and do not win.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.hand(156, 160));
        stage.addDefinition(Definitions.allIn(298, 302));
        allStages.add(stage);

        //Message 3
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>The Aim</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players are dealt 2 randomly shuffled cards each hand, these are only visible to that player and are called the hole cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <font color=#FFFF33>yellow</font> arrows point to your hole cards for this hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players bet on the strength of their hand, which is made up of the best 5 cards available to them out of their hole cards and up to 5 <u>community cards</u>, which every player can see.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a players bet isn't matched the hand is over and they win the <u>pot</u>. If all bets were matched the winner is decided by the player with the best 5 card combination out of the 7 available to them.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addArrow(Utilities.getCardArrow(0, new Color(255, 255, 51), new Color(230, 230, 0)));
        stage.addArrow(Utilities.getCardArrow(1, new Color(255, 255, 51), new Color(230, 230, 0)));
        stage.addDefinition(Definitions.communityCards(339, 352));
        stage.addDefinition(Definitions.pot(448, 451));
        allStages.add(stage);

        //Message 4
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>The Button</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Each hand has a dealer, otherwise known as the button.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The dealer is termed as being 'on the button'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The dealer is responsible for dealing the cards and they are normally the last player to make a decision in a hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">After each hand the button moves one place clockwise.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <font color=#FF0000>red</font> arrow shows the position of the <u>button</u> for the current hand.</p>"
                + "</html>");
        stage.addArrow(Utilities.getArrow(0, new Color(255, 0, 0), new Color(128, 0, 0)));
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.dealer(331, 336));
        allStages.add(stage);

        //Message 5
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>The Blinds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The players to the left of the <u>dealer</u> must post forced bets known as the <u>small blind</u> and <u>big blind</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The purpose of posting these blinds is to ensure the game will eventually end. If no blinds were posted players could fold every hand "
                + " and they would never be knocked out of the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Blinds encourage players to participate in hands to try to recouperate the chips they lost when they posted their blinds.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <font color=#CC33FF>purple</font> arrow shows the current position of the small blind and the "
                + "<font color=#FFFF33>yellow</font> arrow shows the current position of the big blind.</p>"
                + "</html>");

        stage.addDefinition(Definitions.smallBlind(91, 101));
        stage.addDefinition(Definitions.bigBlind(108, 115));
        stage.addDefinition(Definitions.dealer(50, 55));
        stage.addArrow(Utilities.getArrow(2, new Color(255, 255, 51), new Color(230, 230, 0)));
        stage.addArrow(Utilities.getArrow(1, new Color(204, 51, 255), new Color(172, 0, 230)));
        stage.addGame(1, v.getUserDetails(), 0);
        allStages.add(stage);

        //Message 6
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>The Blinds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Blinds also help to control the length of games.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As each game has it's blinds raised at regular intervals, the blinds get bigger more quickly the shorter the interval is.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Bigger blinds mean that players have to commit more to participate in hands, eventually the blinds will catch up with players and will put pressure on them to go all in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">With a higher risk of players being knocked out the game from going <u>all in</u>, the game will end sooner.</p>"
                + "</html>");
        stage.addDefinition(Definitions.allIn(427, 432));
        allStages.add(stage);

        //Message 7
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>The Blinds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Just like the button the blinds are also rotated clockwise after each hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">So in the next hand:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b><u>Big Blind</u></b> will be <b>Andy Jones</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b><u>Small Blind</u></b> will be <b>Michael Michaels</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b><u>Dealer</u></b> will be <b>Harry Richards</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">Click 'Next' to see the button and blinds for the next hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 0);
        stage.addDefinition(Definitions.bigBlind(119, 127));
        stage.addDefinition(Definitions.smallBlind(152, 162));
        stage.addDefinition(Definitions.dealer(193, 198));
        allStages.add(stage);

        //Message 8
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>The Blinds</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The button and blinds are rotated clockwise again for the succeeding hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">So in the next hand:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b>Big Blind</b> will be <b>Louise Johnson</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b>Small Blind</b> will be <b>Andy Jones</b></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The <b>Dealer</b> will be <b>Michael Michaels</b></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 9
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Betting Options<br>Check</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players have 4 possible options during betting stages, the first option is to check.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have already matched the current bet or there is nothing to call then you may check.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Checking is equivalent to betting nothing. If all players choose to check they reach the next stage without committing anything.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you check but another player chooses to bet, the action will continue clockwise and come back to you. However, you can no longer check so you need to either fold, call or raise.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 10
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Betting Options<br>Fold</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The second option is to fold, the only option which you can always take.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you don't feel that your hand is strong you should fold.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">By folding a hand you lose the opportunity to win anything from that hand, but your balance will not decrease any further because you play no further part in the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have the option to check, you should always do this instead of folding, because you have nothing to lose from seeing the next stage, your hand may get stronger and you will still be eligible to win the hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 11
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Betting Options<br>Call</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The third option is to call.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a bet has been made you must match that bet by calling to stay in the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have less than the amount to call you must go 'all in' to remain in the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When you go all in you bet all that you have, you are not eligible to win any more than the amount you bet from each player.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 12
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Betting Options<br>Raise</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The fourth option is to raise.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If you have strong cards or want to discourage opponents from staying in a hand then you may bet or raise.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If there is nothing to call you have the option to bet, the minimum bet is the value of the big blind or all in if you don't have that much.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If another player has decided to bet you have the option to raise them. The minimum raise is twice the value of the previous raise or all in if you don't have that much.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 13
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>Betting</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Once the hole cards have been dealt and the blinds posted betting can begin. The first stage of betting is known as the <u>'pre-flop'</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Pre-flop betting begins with the player to the left of the big blind, with the action going around each player clockwise until the big blind has made their decision.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If another player chooses to <u>raise</u> before reaching the the big blind, the big blind will have the option to <u>call</u>, <u>fold</u> or raise. If nobody chooses to raise the big blind can either <u>check</u>, fold or raise.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If the big blind chooses to raise the action goes round each player again who is still in the hand until all bets are matched.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        stage.addDefinition(Definitions.check(495, 498));
        stage.addDefinition(Definitions.call(422, 425));
        stage.addDefinition(Definitions.fold(428, 431));
        stage.addDefinition(Definitions.raise(343, 347));
        stage.addDefinition(Definitions.preflop(136, 144));
        allStages.add(stage);

        //Message 14
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>Betting</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The stages after the pre-flop are known as the <u>flop</u>, <u>turn</u> and <u>river</u>.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Betting takes place at each of these stages, with the player to the dealers left being first to decide their action.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">3 <u>community cards</u> are revealed during the flop, with one additional community card revealed on the turn and river.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">All five community cards are visible on the river, so each player will know their best card combination.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Action continues at each stage until all bets are matched, if bets are not matched the action goes around each player again.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        stage.addDefinition(Definitions.flop(63, 66));
        stage.addDefinition(Definitions.turn(69, 72));
        stage.addDefinition(Definitions.river(78, 82));
        stage.addDefinition(Definitions.communityCards(204, 218));
        allStages.add(stage);

        //Message 15
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Rules<br>Betting</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">All bets go into a <u>pot</u>, if a player goes all in their entitlement goes into one pot and additional bets go into a seperate pot which they aren't eligible to win.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a player doesn't have their bet matched in a hand they win the pot without having to show their cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If bets are matched during the river we proceed to the <u>showdown</u> stage, where players reveal their cards and the winners"
                + " receive their share from the pot.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        stage.addDefinition(Definitions.pot(35, 37));
        stage.addDefinition(Definitions.showdown(339, 346));
        allStages.add(stage);

        //Message 16
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Introduction</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Winning hands are determined by the player with the strongest hand category out of the 9 possible.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players with the same category do not always split the winnings, each category has different strengths and ties are settled by '<u>kickers</u>' which are explained later.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">This section aim's to teach you how to determine the strength and category of your hand.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        stage.addDefinition(Definitions.kicker(257, 263));
        allStages.add(stage);

        //Message 17
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Straight Flush</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The strongest category you can get is a Straight Flush, which is made up of 5 cards of the same suit which all succeed each other.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Aces can be both the highest or lowest card, so:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♦</font> 2<font color=red style='font-size:140%'>♦</font> 3<font color=red style='font-size:140%'>♦</font> 4<font color=red style='font-size:140%'>♦</font> 5<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Would be an example of a 5 high Straight Flush, whereas:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">10<font color=black style='font-size:140%'>♠</font> J<font color=black style='font-size:140%'>♠</font> Q<font color=black style='font-size:140%'>♠</font> K<font color=black style='font-size:140%'>♠</font> A<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Would be an example of an Ace high Straight Flush, also known as a 'Royal Flush'.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 18
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Straight Flush</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">An Ace High Straight Flush beats a 7 High, because the highest card is bigger, in the event of equal Straight Flushes winnings are split.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 19
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Four of a Kind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 2<sup>nd</sup> strongest category is a Four of a Kind, which is made up of 4 cards holding the same value.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♦</font> A<font color=red style='font-size:140%'>♥</font> A<font color=black style='font-size:140%'>♣</font> A<font color=black style='font-size:140%'>♠</font> 4<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">3<font color=black style='font-size:140%'>♣</font> 3<font color=black style='font-size:140%'>♠</font> 3<font color=red style='font-size:140%'>♥</font> 3<font color=red style='font-size:140%'>♦</font> 10<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 7<font color=red style='font-size:140%'>♦</font> 7<font color=black style='font-size:140%'>♠</font> 2<font color=red style='font-size:140%'>♥</font> 7<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If two players have a Four of a Kind, otherwise known as 'quads' it first comes down to who has the highest value Four of a Kind to determine the winner, where Ace is the highest and 2 is the lowest.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 20
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Four of a Kind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If both players have the same Four of a Kind value the winner is the player with the highest 5<sup>th</sup> card, known as the 'kicker'.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If two or more players have the same Four of a Kind and kicker the pot is split equally between them.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 21
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Full House</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 3<sup>rd</sup> strongest category is a Full House, which is made up of three cards of the same value (Three of a Kind) and two cards of the same value (Pair), where the value of the Three of a Kind cards differs to the value of the Pair cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♦</font> A<font color=red style='font-size:140%'>♥</font> A<font color=black style='font-size:140%'>♣</font> 10<font color=black style='font-size:140%'>♣</font> 10<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">2<font color=black style='font-size:140%'>♣</font> 2<font color=black style='font-size:140%'>♠</font> 2<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♣</font> 9<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=black style='font-size:140%'>♠</font> 7<font color=red style='font-size:140%'>♦</font> 7<font color=red style='font-size:140%'>♥</font> 6<font color=red style='font-size:140%'>♦</font> 6<font color=black style='font-size:140%'>♠</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 22
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Full House</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have a Full House the player with the highest Three of a Kind cards wins.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have the same Three of a Kind value then the player with the highest Pair wins the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players also have the same Pair the pot is evenly split between them.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 23
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Flush</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 4<sup>th</sup> strongest category is a Flush, which is made up of 5 cards of the same suit that do not succeed each other.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♥</font> Q<font color=red style='font-size:140%'>♥</font> 9<font color=red style='font-size:140%'>♥</font> 4<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">10<font color=black style='font-size:140%'>♠</font> 9<font color=black style='font-size:140%'>♠</font> 8<font color=black style='font-size:140%'>♠</font> 7<font color=black style='font-size:140%'>♠</font> 4<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">K<font color=red style='font-size:140%'>♦</font> 9<font color=red style='font-size:140%'>♦</font> 7<font color=red style='font-size:140%'>♦</font> 6<font color=red style='font-size:140%'>♦</font> 5<font color=red style='font-size:140%'>♦</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 24
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Flush</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a player has 6 or 7 cards of the same suit available then their 5 highest cards of that suit are chosen.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have Flushes the winner is the player with the highest card.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have the same highest card the next highest cards are checked, and so on until a winner is decided.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The pot is split evenly between players if their 5 highest flush cards are all of the same value.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 25
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Straight</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 5<sup>th</sup> strongest category is a Straight, which is made up of 5 cards which all succeed each other that are not all the same suit.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If a player has 6 or 7 cards succeeding each other the 5 highest succeeding cards are chosen.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Aces can be both the highest or lowest card, so:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♦</font> 2<font color=black style='font-size:140%'>♠</font> 3<font color=black style='font-size:140%'>♠</font> 4<font color=black style='font-size:140%'>♣</font> 5<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Is a 5 high Straight, whereas:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">10<font color=red style='font-size:140%'>♦</font> J<font color=red style='font-size:140%'>♥</font> Q<font color=black style='font-size:140%'>♣</font> K<font color=black style='font-size:140%'>♠</font> A<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Is an Ace high Straight.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 26
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Straight</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If an Ace is used in a straight It can only be used as the Highest or Lowest Card, so:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">J<font color=red style='font-size:140%'>♥</font> Q<font color=black style='font-size:140%'>♠</font> K<font color=black style='font-size:140%'>♣</font> A<font color=red style='font-size:140%'>♦</font> 2<font color=black style='font-size:140%'>♣</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">does not count as a straight.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have Straights the winner is the player with the highest straight, the pot is evenly split in the event of a tie.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 27
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Three of a Kind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 6<sup>th</sup> strongest category is a Three of a Kind, which is made up of 3 cards holding the same value along with the 2 highest remaining cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">K<font color=black style='font-size:140%'>♣</font> K<font color=black style='font-size:140%'>♠</font> K<font color=red style='font-size:140%'>♥</font> 4<font color=black style='font-size:140%'>♣</font> 2<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">2<font color=red style='font-size:140%'>♦</font> 2<font color=black style='font-size:140%'>♣</font> 2<font color=black style='font-size:140%'>♠</font> 7<font color=black style='font-size:140%'>♣</font> 4<font color=red style='font-size:140%'>♥</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">9<font color=black style='font-size:140%'>♠</font> 9<font color=red style='font-size:140%'>♦</font> 9<font color=red style='font-size:140%'>♥</font> 6<font color=black style='font-size:140%'>♠</font> 5<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 28
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Three of a Kind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have a Three of a Kind the winner is the player who has the highest value set of 3.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same value set of 3 their kickers are compared. The winner is the player with the highest kicker in their hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If both players have the same kicker the final card is compared.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same values for their 5 cards the pot is split evenly between them.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 29
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Two Pair</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 7<sup>th</sup> strongest category is a Two Pair, which is made up of 2 'Pairs' of cards along with the highest remaining card.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=black style='font-size:140%'>♣</font> A<font color=red style='font-size:140%'>♥</font> K<font color=black style='font-size:140%'>♣</font> K<font color=black style='font-size:140%'>♠</font> 4<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">3<font color=black style='font-size:140%'>♣</font> 3<font color=black style='font-size:140%'>♠</font> 2<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♥</font> 7<font color=red style='font-size:140%'>♦</font> 4<font color=black style='font-size:140%'>♠</font> 4<font color=red style='font-size:140%'>♥</font> A<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 30
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Two Pair</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have a Two Pair the winner is the player who has the highest pair.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same value highest pair the player with the highest second pair wins.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same value second pair the player with the highest kicker wins the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If the players also have the same value kicker the pot is evenly split.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 31
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Pair</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The 8<sup>th</sup> strongest category is a Pair, which is made up of 2 cards of the same value along with the 3 highest remaining cards.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">A<font color=black style='font-size:140%'>♣</font> A<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♣</font> 4<font color=black style='font-size:140%'>♠</font> 3<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">7<font color=red style='font-size:140%'>♦</font> 7<font color=red style='font-size:140%'>♥</font> A<font color=black style='font-size:140%'>♠</font> K<font color=red style='font-size:140%'>♦</font> J<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">2<font color=red style='font-size:140%'>♥</font> 2<font color=red style='font-size:140%'>♦</font> 10<font color=black style='font-size:140%'>♠</font> 9<font color=black style='font-size:140%'>♣</font> 7<font color=red style='font-size:140%'>♥</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 21
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Pair</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have a Pair the winner is the player with the highest pair.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same Pair their next highest card known as the 'kicker' is compared, the player with the highest kicker wins the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If players have the same value kickers their next cards are compared, and so on until a winner is decided.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The pot is split evenly between players if their 5 highest cards are all of the same value.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 32
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>High Card</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The weakest category is a High Card, which is made up of the 5 highest cards the player has.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Examples include:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:11px;text-align:center;font-size:120%;\">A<font color=red style='font-size:140%'>♦</font> 10<font color=black style='font-size:140%'>♣</font> 7<font color=black style='font-size:140%'>♣</font> 4<font color=black style='font-size:140%'>♠</font> 3<font color=red style='font-size:140%'>♦</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">9<font color=red style='font-size:140%'>♥</font> 8<font color=black style='font-size:140%'>♠</font> 7<font color=red style='font-size:140%'>♥</font> 3<font color=red style='font-size:140%'>♦</font> 2<font color=black style='font-size:140%'>♠</font></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-size:120%;\">J<font color=red style='font-size:140%'>♥</font> 10<font color=red style='font-size:140%'>♦</font> 9<font color=black style='font-size:140%'>♠</font> 8<font color=red style='font-size:140%'>♥</font> 5<font color=black style='font-size:140%'>♣</font></p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 33
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>High Card</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If no player has a category better than a High Card the player with the highest card wins the hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have the same valued high card, their next highest card is checked, and so on until a winner is found.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">If multiple players have the same valued 5 cards the pot is split evenly amongst them.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        allStages.add(stage);

        //Message 34
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Hand Categories<br>Rules</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">It may be the case that you may be able to make multiple categories out of the cards available to you.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The strongest category is always chosen, so if you could make a <u>Flush</u> or a <u>Straight</u> out of a hand the cards making the Flush would always be chosen.</p>"
                + "</html>");
        stage.addGame(1, v.getUserDetails(), 1);
        stage.addDefinition(Definitions.flush(191, 195));
        stage.addDefinition(Definitions.straight(201, 209));
        allStages.add(stage);

        //Message 35
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Edge Cases<br>All in Players</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The following scenario shows a player going all in. All cards are visible so you can understand the players actions.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Emily plays her hand aggressively because she has a pair in her hole cards, David stays in the hand and raises Emily to all in.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Note:</b> When Emily went all in with $356, David rose to $1000. David recieves $644 back because it wasn't matched by anyone.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Result:</b> David Smith won with a Full House with Ace's over 2's and therefore Emily is knocked out of the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to play this scenario, and 'Replay' to start from the beginning</b></p>"
                + "</html>");
        stage.addGame(2, v.getUserDetails(), 1);
        stage.setAction("Start");
        allStages.add(stage);

        //Message 36
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Edge Cases<br>All In Posting Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Players who do not have enough chips to post their blind have to go all in. In this example Louise goes all in because she can't post the $25 small blind.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Emily and David both call the big blind and reach the flop.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As Louise could only post $10 this goes into a pot along with Emily and David's $10. Another pot is used for Emily and Davids additional calls.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When Emily folds David takes the winnings from the pot that just involved him and Emily. "
                + "The remaining cards are dealt and Louise won the pot containing $30.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">Click 'Start' to begin the scenario.</p>"
                + "</html>");
        stage.addGame(3, v.getUserDetails(), 3);
        stage.setAction("Start");
        allStages.add(stage);

        //Message 37
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Edge Cases<br>Dead Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">The following scenario shows the small blind becoming 'dead', meaning that no player is assigned that blind or button.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If the big blind goes all in and loses, the small blind is dead during the next hand, and the button dead for the hand after.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">If the small blind goes all in and loses, the button is dead during the next hand.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">Dead blinds can only occur when the big or small blind is knocked out of the game.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:9px;\">There is always a big blind, which is rotated to the next available player to the left of the previous big blind.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">Click Next to see the state of play should Emily go all in and lose.</p>"
                + "</html>");
        stage.addGame(4, v.getUserDetails(), 5);
        allStages.add(stage);

        //Message 38
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Edge Cases<br>Dead Blind</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">When Emily went all in and lost the small blind became dead. It was positioned to where she was sitting but no players posted a small blind.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the next hand the button will be dead. Once the button has passed through the player that was knocked out, they will no longer cause dead blinds.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Remember that there must always be a big blind and that dead blinds or buttons only occur when the big or small blind goes all in and loses.</p>"
                + "</html>");
        stage.addGame(5, v.getUserDetails(), 5);
        allStages.add(stage);

        //Message 39
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Edge Cases<br>High Card</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The following scenario shows how a pot is split when 2 players have the same best 5 card combination for High Card.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">$675 cannot be divided evenly between 2 players because the smallest chip is $1.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The player with the highest hole card wins the leftover chip/s. In a tie, Suit is taken into account:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">Strongest Suit: Spades<br>2nd Strongest: Hearts<br>3rd Strongest: Diamonds<br>Weakest Suit: Clubs</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">As Diamonds beats Clubs Andy took the remaining chip in this scenario.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the scenario.</b></p>"
                + "</html>");
        stage.addGame(6, v.getUserDetails(), 7);
        stage.setAction("Start");
        allStages.add(stage);

        //Message 40
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>Test Yourself 1/4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">The following simple tests are designed to get you used to the interface.</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the following hand, you should take the following actions in the following order:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">1. Check</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">2. Fold</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand.</b></p>"
                + "</html>");
        stage.addGame(7, v.getUserDetails(), 7);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "You either need to click check or fold"));
        allStages.add(stage);

        //Message 41
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>Test Yourself 2/4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the following hand, you should take the following actions in the following order:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">1. Call</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">2. Raise to $150</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand.</b></p>" + "</html>");
        stage.addGame(8, v.getUserDetails(), 7);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "You either need to click call or bet $150"));
        allStages.add(stage);

        //Message 42
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>Test Yourself 3/4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the following hand, you should take the following actions in the following order:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">1. Check</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">2. Raise 3 times the current bet</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand.</b></p>" + "</html>");
        stage.addGame(9, v.getUserDetails(), 7);
        stage.setAction("Start");
        stage.addHint(new Definition(0, 50, "Hint", "You either need to click check or bet $300"));
        allStages.add(stage);

        //Message 43
        stage = new LessonStep(v, "<html>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;text-align:center;font-weight:bold;\">Introduction<br>Test Yourself 4/4</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\">In the following hand, you should take the following actions in the following order:</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">1. Call</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">2. Check</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">3. Raise to $200</p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;font-weight:bold;\">4. <u>All in</u></p>"
                + "<p style=\"font-family:arial;color:white;font-size:10px;\"><b>Click 'Start' to begin the hand.</b></p>" 
                + "</html>");
        stage.addGame(10, v.getUserDetails(), 7);
        stage.addDefinition(Definitions.allIn(154, 158));
        stage.addHint(new Definition(0, 50, "Hint", "You either need to call, check, bet $200 or bet $750"));
        stage.setAction("StartEnd");
        allStages.add(stage);

        Lesson completeLesson = new Lesson(allStages);
        return completeLesson;
    }
}
