/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.text.DecimalFormat;

/**
 * Represents how well a player has been doing.
 * @author Anton
 */
public class Statistics {

    private int lessonOneScore;
    private int lessonTwoScore;
    private int lessonThreeScore;
    private int lessonFourScore;
    private int lessonFiveScore;
    private int lessonSixScore;
    private String strongestHand;
    private int tournamentCosts;
    private int tournamentWinnings;
    private int tournamentsWon;
    private int handsDealt;
    private int flopsSeen;
    private int preflopsWon;
    private int flopsWon;
    private int turnsWon;
    private int riversWon;
    private int showdownsWon;
    private int tightPlays;
    private int slowPlays;
    private int bluffs;

    public Statistics() {
        lessonOneScore = 0;
        lessonTwoScore = 0;
        lessonThreeScore = 0;
        lessonFourScore = 0;
        lessonFiveScore = 0;
        lessonSixScore = 0;
        tournamentCosts = 0;
        tournamentWinnings = 0;
        tournamentsWon = 0;
        handsDealt = 0;
        flopsSeen = 0;
        preflopsWon = 0;
        flopsWon = 0;
        turnsWon = 0;
        riversWon = 0;
        showdownsWon = 0;
    }

    public int getLessonFiveScore() {
        return lessonFiveScore;
    }

    public int getLessonFourScore() {
        return lessonFourScore;
    }

    public int getLessonOneScore() {
        return lessonOneScore;
    }

    public int getLessonSixScore() {
        return lessonSixScore;
    }

    public int getLessonThreeScore() {
        return lessonThreeScore;
    }

    public int getLessonTwoScore() {
        return lessonTwoScore;
    }

    public int getHandsDealt() {
        return handsDealt;
    }

    /**
     * @return, The number of lessons with scores of 70 or above. 
     */
    public int getLessonsPassed() {
        int passed = 0;

        if (getLessonOneScore() >= 70) {
            passed++;
        }
        if (getLessonTwoScore() >= 70) {
            passed++;
        }
        if (getLessonThreeScore() >= 70) {
            passed++;
        }
        if (getLessonFourScore() >= 70) {
            passed++;
        }
        if (getLessonFiveScore() >= 70) {
            passed++;
        }
        if (getLessonSixScore() >= 70) {
            passed++;
        }
        return passed;
    }

    /**
     * @return, The number of lessons with scores above 0.
     */
    public int getLessonsAttempted() {
        int attempted = 0;

        if (getLessonOneScore() > 0) {
            attempted++;
        }
        if (getLessonTwoScore() > 0) {
            attempted++;
        }
        if (getLessonThreeScore() > 0) {
            attempted++;
        }
        if (getLessonFourScore() > 0) {
            attempted++;
        }
        if (getLessonFiveScore() > 0) {
            attempted++;
        }
        if (getLessonSixScore() > 0) {
            attempted++;
        }

        return attempted;
    }

    public int getTournamentsWon() {
        return tournamentsWon;
    }

    public int getTournamentCosts() {
        return tournamentCosts;
    }

    public int getTournamentWinnings() {
        return tournamentWinnings;
    }

    public int getFlopsSeen() {
        return flopsSeen;
    }

    public int getFlopsWon() {
        return flopsWon;
    }

    public int getPreflopsWon() {
        return preflopsWon;
    }

    public int getRiversWon() {
        return riversWon;
    }

    public int getShowdownsWon() {
        return showdownsWon;
    }

    public int getTurnsWon() {
        return turnsWon;
    }

    public int getHandsWon() {
        return preflopsWon + flopsWon + turnsWon + riversWon + showdownsWon;
    }

    /**
     * @return, The average score of the lessons took.
     */
    public double getAverageScore() {

        if (getLessonsAttempted() == 0) {
            return 0;
        }


        int cumulativeScore = 0;

        cumulativeScore += getLessonOneScore();
        cumulativeScore += getLessonTwoScore();
        cumulativeScore += getLessonThreeScore();
        cumulativeScore += getLessonFourScore();
        cumulativeScore += getLessonFiveScore();
        cumulativeScore += getLessonSixScore();

        //http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
        DecimalFormat formattedDouble = new DecimalFormat("#.##");
        return Double.valueOf(formattedDouble.format((cumulativeScore + 0.0) / getLessonsAttempted()));
    }

    public String getStrongestHand() {
        return strongestHand;
    }

    public int getBluffs() {
        return bluffs;
    }

    public int getSlowPlays() {
        return slowPlays;
    }

    public int getTightPlays() {
        return tightPlays;
    }

    public void setHandsDealt(int handsDealt) {
        this.handsDealt = handsDealt;
    }

    public void setLessonFiveScore(int lessonFiveScore) {
        this.lessonFiveScore = lessonFiveScore;
    }

    public void setLessonFourScore(int lessonFourScore) {
        this.lessonFourScore = lessonFourScore;
    }

    public void setLessonOneScore(int lessonOneScore) {
        this.lessonOneScore = lessonOneScore;
    }

    public void setLessonSixScore(int lessonSixScore) {
        this.lessonSixScore = lessonSixScore;
    }

    public void setLessonThreeScore(int lessonThreeScore) {
        this.lessonThreeScore = lessonThreeScore;
    }

    public void setLessonTwoScore(int lessonTwoScore) {
        this.lessonTwoScore = lessonTwoScore;
    }

    public void setStrongestHand(String strongestHand) {
        this.strongestHand = strongestHand;
    }

    public void setTournamentCosts(int tournamentCosts) {
        this.tournamentCosts = tournamentCosts;
    }

    public void setTournamentWinnings(int tournamentWinnings) {
        this.tournamentWinnings = tournamentWinnings;
    }

    public void setTournamentsWon(int tournamentsWon) {
        this.tournamentsWon = tournamentsWon;
    }

    public void setFlopsSeen(int flopsSeen) {
        this.flopsSeen = flopsSeen;
    }

    public void setFlopsWon(int flopsWon) {
        this.flopsWon = flopsWon;
    }

    public void setPreflopsWon(int preflopsWon) {
        this.preflopsWon = preflopsWon;
    }

    public void setRiversWon(int riversWon) {
        this.riversWon = riversWon;
    }

    public void setShowdownsWon(int showdownsWon) {
        this.showdownsWon = showdownsWon;
    }

    public void setTurnsWon(int turnsWon) {
        this.turnsWon = turnsWon;
    }

    public void setBluffs(int bluffs) {
        this.bluffs = bluffs;
    }

    public void setSlowPlays(int slowPlays) {
        this.slowPlays = slowPlays;
    }

    public void setTightPlays(int tightPlays) {
        this.tightPlays = tightPlays;
    }
}
