/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 * PaintTask Class.
 * @author Anton
 */
import Abstract.View;
import java.awt.geom.RoundRectangle2D;
import java.util.TimerTask;

public class PaintTask extends TimerTask {

    public boolean repaint;
    public RoundRectangle2D[] theRectangles;
    private View thePanel;
    private int blindsTime;
    private int timeRemaining;
    private boolean blindsIncreased = false;
    private boolean paintBlinds;
    private int x;

    /**
     * PaintTask constructor for FreeplayView. Uses blinds.
     * @param thePanel
     * @param blindsTime
     */
    public PaintTask(View thePanel, int blindsTime) {
        this.thePanel = thePanel;
        this.blindsTime = blindsTime;
        this.timeRemaining = blindsTime;
        paintBlinds = true;

        if (thePanel.isLessonView()) {
            x = -50;
        } else {
            x = 0;
        }

        initialiseRectangles();
        repaint = false;
    }

    /**
     * PaintTask constructor for LessonView. Doesn't use blinds.
     * @param thePanel
     */
    public PaintTask(View thePanel) {
        this.thePanel = thePanel;
        this.timeRemaining = blindsTime;
        paintBlinds = false;

        if (thePanel.isLessonView()) {
            x = -50;
        } else {
            x = 0;
        }

        initialiseRectangles();
        repaint = false;
    }

    /**
     * Sets up the rectangles so that new instances aren't constantly created.
     */
    private void initialiseRectangles() {

        theRectangles = new RoundRectangle2D[thePanel.getGame().getPlayers().size()];

        for (int i = 0; i < thePanel.getGame().getPlayers().size(); i++) {

            switch (i) {
                case -1:
                    break;
                case 0:
                    theRectangles[i] = new RoundRectangle2D.Double(406 + x, 490, 120, 60, 20, 20);
                    break;
                case 1:
                    theRectangles[i] = new RoundRectangle2D.Double(216 + x, 470, 120, 60, 20, 20);
                    break;
                case 2:
                    theRectangles[i] = new RoundRectangle2D.Double(55 + x, 300, 120, 60, 20, 20);
                    break;
                case 3:
                    theRectangles[i] = new RoundRectangle2D.Double(216 + x, 60, 120, 60, 20, 20);
                    break;
                case 4:
                    theRectangles[i] = new RoundRectangle2D.Double(406 + x, 40, 120, 60, 20, 20);
                    break;
                case 5:
                    theRectangles[i] = new RoundRectangle2D.Double(601 + x, 60, 120, 60, 20, 20);
                    break;
                case 6:
                    theRectangles[i] = new RoundRectangle2D.Double(691 + x, 300, 120, 60, 20, 20);
                    break;
                case 7:
                    theRectangles[i] = new RoundRectangle2D.Double(601 + x, 470, 120, 60, 20, 20);
                    break;
            }
        }
    }

    /**
     * Freeplay games need to acknowledge that it is time for the blinds to
     * be increased.
     */
    public void increaseAcknowledged() {
        blindsIncreased = false;
        timeRemaining = blindsTime;
    }

    public boolean blindsIncreased() {
        return blindsIncreased;
    }

    public int getTimeLeft() {
        return timeRemaining;
    }

    @Override
    public void run() {

        try {
            if (repaint) {

                //Draw Rectangle highlighting players turn.
                thePanel.repaint();
                repaint = false;

            } else {
                thePanel.repaint();
                repaint = true;
            }

            if (paintBlinds) {
                //Paint Blinds
                if (timeRemaining > 0) {
                    timeRemaining -= 500;
                } else if (blindsIncreased == false) {
                    thePanel.getGame().getGameDetails().increaseBlind();
                    blindsIncreased = true;
                }
                //Only Repaint the Area where the timer appears on screen
                thePanel.repaint(1170, 50, 150, 30);
            }
        } catch (Exception e) {
            System.out.println("Timer Error Occured - Timer Cancelled");
            this.cancel();
        }
    }
}
