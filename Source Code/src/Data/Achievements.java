/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Tools.GameCalculations.HandResult;
import java.util.ArrayList;

/**
 * Represents the achievements a player has unlocked.
 * @author Anton
 */
public class Achievements {

    private boolean newcomer;
    private boolean firstWin;
    private boolean fifthWin;
    private boolean tenThousand;
    private boolean hundredThousand;
    private boolean million;
    private boolean tightPlayer;
    private boolean slowPlayer;
    private boolean bluffer;
    private boolean beginner;
    private boolean amateur;
    private boolean pro;
    private boolean hundredPercent;
    private boolean royalFlush;
    private boolean straightFlush;
    private boolean fourOfAKind;
    private boolean fullHouse;
    private boolean flush;

    //All achievements are initially false.
    public Achievements() {
    }

    /**
     * Detects new achievements unlocked.
     * @param s, the players statistics.
     * @return, the names of unlocked achievements.
     */
    public ArrayList<String> getNewLessonUnlocked(Statistics s) {

        ArrayList<String> newAchievements = new ArrayList<String>();

        if (!isBeginner() && s.getLessonsPassed() == 1) {
            newAchievements.add("Beginner");
            setBeginner(true);
        }

        if (!isAmateur() && s.getLessonsPassed() == 3) {
            newAchievements.add("Amateur");
            setAmateur(true);
        }

        if (!isPro() && s.getLessonsPassed() == 6) {
            newAchievements.add("Pro");
            setPro(true);
        }

        if (!isHundredPercent() && s.getLessonsPassed() == 6 && s.getAverageScore() == 100) {
            newAchievements.add("100%");
            setHundredPercent(true);
        }
        return newAchievements;
    }

    /**
     * Detects new achievements unlocked.
     * @param hand, the hand the player won with.
     * @param s, the players statistics.
     * @return, the names of unlocked achievements.
     */
    public ArrayList<String> getNewFreeplayUnlocked(HandResult hand, Statistics s) {

        ArrayList<String> newAchievements = new ArrayList<String>();

        int category = hand.getHandCategory();

        if (!flush && category == 6) {
            setFlush(true);
            newAchievements.add("Flush");
        }

        if (!fullHouse && category == 7) {
            setFullHouse(true);
            newAchievements.add("Full House");
        }

        if (!fourOfAKind && category == 8) {
            setFourOfAKind(true);
            newAchievements.add("Four of a Kind");
        }

        if (!straightFlush && category == 9) {
            setStraightFlush(true);
            newAchievements.add("Straight Flush");
        }

        //Must be a straight flush with the first card being an ace.
        if (!royalFlush && category == 9 && hand.getFirstValue() == 14) {
            setRoyalFlush(true);
            newAchievements.add("Royal Flush");
        }

        if (!bluffer && s.getBluffs() == 5) {
            setBluffer(true);
            newAchievements.add("Bluffer");
        }

        if (!tightPlayer && s.getTightPlays() == 5) {
            setTightPlayer(true);
            newAchievements.add("Tight Player");
        }

        if (!slowPlayer && s.getSlowPlays() == 5) {
            setSlowPlayer(true);
            newAchievements.add("Slow Player");
        }

        return newAchievements;
    }

    /**
     * Detects new achievements unlocked.
     * @param s, the players statistics.
     * @return, the names of unlocked achievements.
     */
    public ArrayList<String> getNewSummaryUnlocked(Statistics s) {

        ArrayList<String> newAchievements = new ArrayList<String>();

        if (!firstWin && s.getTournamentsWon() == 1) {
            setFirstWin(true);
            newAchievements.add("First Win");
        }

        if (!fifthWin && s.getTournamentsWon() == 5) {
            setFifthWin(true);
            newAchievements.add("Fifth Win");
        }

        if (!tenThousand && (s.getTournamentWinnings() - s.getTournamentCosts()) >= 10000) {
            setTenThousand(true);
            newAchievements.add("$10,000");
        }

        if (!hundredThousand && (s.getTournamentWinnings() - s.getTournamentCosts()) >= 100000) {
            setHundredThousand(true);
            newAchievements.add("$100,000");
        }

        if (!million && (s.getTournamentWinnings() - s.getTournamentCosts()) >= 1000000) {
            setMillion(true);
            newAchievements.add("Millionaire");
        }

        return newAchievements;
    }

    public boolean isAmateur() {
        return amateur;
    }

    public boolean isBeginner() {
        return beginner;
    }

    public boolean isBluffer() {
        return bluffer;
    }

    public boolean isFifthWin() {
        return fifthWin;
    }

    public boolean isFirstWin() {
        return firstWin;
    }

    public boolean isFlush() {
        return flush;
    }

    public boolean isFourOfAKind() {
        return fourOfAKind;
    }

    public boolean isFullHouse() {
        return fullHouse;
    }

    public boolean isHundredPercent() {
        return hundredPercent;
    }

    public boolean isHundredThousand() {
        return hundredThousand;
    }

    public boolean isMillion() {
        return million;
    }

    public boolean isNewcomer() {
        return newcomer;
    }

    public boolean isPro() {
        return pro;
    }

    public boolean isRoyalFlush() {
        return royalFlush;
    }

    public boolean isSlowPlayer() {
        return slowPlayer;
    }

    public boolean isStraightFlush() {
        return straightFlush;
    }

    public boolean isTenThousand() {
        return tenThousand;
    }

    public boolean isTightPlayer() {
        return tightPlayer;
    }

    public void setAmateur(boolean amateur) {
        this.amateur = amateur;
    }

    public void setBeginner(boolean beginner) {
        this.beginner = beginner;
    }

    public void setBluffer(boolean bluffer) {
        this.bluffer = bluffer;
    }

    public void setFifthWin(boolean fifthWin) {
        this.fifthWin = fifthWin;
    }

    public void setFirstWin(boolean firstWin) {
        this.firstWin = firstWin;
    }

    public void setFlush(boolean flush) {
        this.flush = flush;
    }

    public void setFourOfAKind(boolean fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
    }

    public void setFullHouse(boolean fullHouse) {
        this.fullHouse = fullHouse;
    }

    public void setHundredPercent(boolean hundredPercent) {
        this.hundredPercent = hundredPercent;
    }

    public void setHundredThousand(boolean hundredThousand) {
        this.hundredThousand = hundredThousand;
    }

    public void setMillion(boolean million) {
        this.million = million;
    }

    public void setNewcomer(boolean newcomer) {
        this.newcomer = newcomer;
    }

    public void setPro(boolean pro) {
        this.pro = pro;
    }

    public void setRoyalFlush(boolean royalFlush) {
        this.royalFlush = royalFlush;
    }

    public void setSlowPlayer(boolean slowPlayer) {
        this.slowPlayer = slowPlayer;
    }

    public void setStraightFlush(boolean straightFlush) {
        this.straightFlush = straightFlush;
    }

    public void setTenThousand(boolean tenThousand) {
        this.tenThousand = tenThousand;
    }

    public void setTightPlayer(boolean tightPlayer) {
        this.tightPlayer = tightPlayer;
    }

    public void setAll(boolean value) {

        newcomer = value;
        firstWin = value;
        fifthWin = value;
        tenThousand = value;
        hundredThousand = value;
        million = value;
        tightPlayer = value;
        slowPlayer = value;
        bluffer = value;
        beginner = value;
        amateur = value;
        pro = value;
        hundredPercent = value;
        royalFlush = value;
        straightFlush = value;
        fourOfAKind = value;
        fullHouse = value;
        flush = value;

    }

    /**
     * @return, The number of unlocked achievements.
     */
    public int totalUnlocked() {

        int count = 0;

        if (newcomer) {
            count++;
        }
        if (firstWin) {
            count++;
        }
        if (fifthWin) {
            count++;
        }
        if (tenThousand) {
            count++;
        }
        if (hundredThousand) {
            count++;
        }
        if (million) {
            count++;
        }
        if (tightPlayer) {
            count++;
        }
        if (slowPlayer) {
            count++;
        }
        if (bluffer) {
            count++;
        }
        if (beginner) {
            count++;
        }
        if (amateur) {
            count++;
        }
        if (pro) {
            count++;
        }
        if (hundredPercent) {
            count++;
        }
        if (royalFlush) {
            count++;
        }
        if (straightFlush) {
            count++;
        }
        if (fourOfAKind) {
            count++;
        }
        if (fullHouse) {
            count++;
        }
        if (flush) {
            count++;
        }
        return count;
    }
}
