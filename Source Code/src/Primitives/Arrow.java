/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitives;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Arrow Class.
 * @author Anton
 */
public class Arrow {

    private Color colorOne;
    private Color colorTwo;
    private int x1, y1;
    private boolean up;

    /**
     * Construct a new arrow instance.
     * @param colorOne, the first colour.
     * @param colorTwo, the second colour.
     * @param coordinates, the coordinates to draw it.
     * @param up, draw the arrow up or down.
     */
    public Arrow(Color colorOne, Color colorTwo, int[] coordinates, boolean up) {
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
        this.up = up;
        this.x1 = coordinates[0];
        this.y1 = coordinates[1];
    }

    /**
     * Draws the arrow on the panel.
     * @param g, the graphics to draw with.
     */
    public void drawArrow(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(4F));

        g2.setPaint(new GradientPaint(0, 0, colorOne, 10, 10, colorTwo, true));

        //Draws the arrow up.
        if (up == true) {
            g.drawLine(x1, y1, x1, y1 + 25);
            g.drawLine(x1, y1, x1 - 10, y1 + 8);
            g.drawLine(x1, y1, x1 + 10, y1 + 8);
        } else {
            //Draws the arrow down.
            g.drawLine(x1, y1, x1, y1 - 25);
            g.drawLine(x1, y1, x1 - 10, y1 - 8);
            g.drawLine(x1, y1, x1 + 10, y1 - 8);
        }

    }
}
