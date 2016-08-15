/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Players.Player;
import Primitives.Card;
import Primitives.Suit;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * BoardGraphics Class.
 * @author Anton
 */
public class BoardGraphics {

    /**
     * Displays a player on the GUI.
     * @param p, the player to paint.
     * @param g, the graphics to paint with.
     * @param i, the image observer to drawImage.
     * @param xTransform, transform for lesson/freeplay.
     */
    public static void paintPlayer(Player p, Graphics g, ImageObserver i, int xTransform) {

        int furtherTransform = 0;
        if (xTransform < 0) {
            furtherTransform = -70;
        }

        switch (p.getGuiPosition()) {
            case 1:
                paintUp(p, g, i, 451 + xTransform, 490);
                break;
            case 2:
                paintUp(p, g, i, 261 + xTransform, 470);
                break;
            case 3:
                paintUp(p, g, i, 100 + xTransform, 300);
                break;
            case 4:
                paintDown(p, g, i, 261 + xTransform, 60);
                break;
            case 5:
                paintDown(p, g, i, 451 + xTransform, 40);
                break;
            case 6:
                paintDown(p, g, i, 646 + xTransform, 60);
                break;
            case 7:
                paintUp(p, g, i, 806 + xTransform + furtherTransform, 300);
                break;
            case 8:
                paintUp(p, g, i, 646 + xTransform, 470);
                break;
        }
    }

    /**
     * Draws a player with cards pointing up.
     * @param p, the player to paint.
     * @param g, the graphics to paint with.
     * @param i, the image observer to drawImage.
     * @param x, the x coordinate to draw from.
     * @param y, the y coordinate to draw from.
     */
    public static void paintUp(Player p, Graphics g, ImageObserver i, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0, 0, 255, 80));
        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, 120, 60, 20, 20);
        g2.fill(rect);

        g2.setFont(new Font("Arial", Font.BOLD, 11));
        FontMetrics f = g.getFontMetrics();
        g2.setColor(Color.WHITE);
        g2.drawString(p.getName(), (x + (120 - f.stringWidth(p.getName())) / 2), y + 18);
        g2.setFont(new Font("Arial", Font.PLAIN, 11));
        f = g.getFontMetrics();
        g2.drawString("$" + String.valueOf(p.getChipBalance()), (x + (120 - f.stringWidth("$" + String.valueOf(p.getChipBalance()))) / 2), y + 35);

        if (p.getAction() != null) {
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            f = g.getFontMetrics();
            g2.drawString(p.getAction(), (x + (120 - f.stringWidth(p.getAction())) / 2), y + 52);
        }

        try {
            if (p.getShow() == true) {
                if (p.getCards()[0] != null && p.getCards()[1] != null && p.inHand() == true) {
                    paintCard(p.getCards()[0], i, g, x + 16 - 3, y - 69);
                    paintCard(p.getCards()[1], i, g, x + 63 - 3, y - 69);
                }
            } else {
                if (p.getCards()[0] != null && p.getCards()[1] != null && p.inHand() == true) {
                    paintCard(null, i, g, x + 16 - 3, y - 69);
                    paintCard(null, i, g, x + 63 - 3, y - 69);
                }
            }
        } catch (Exception e) {
            System.out.println("Could not draw " + getCard(p.getCards()[0]) + " or " + getCard(p.getCards()[1]));
        }
    }

    /**
     * Draws a player with cards pointing down.
     * @param p, the player to paint.
     * @param g, the graphics to paint with.
     * @param i, the image observer to drawImage.
     * @param x, the x coordinate to draw from.
     * @param y, the y coordinate to draw from.
     */
    public static void paintDown(Player p, Graphics g, ImageObserver i, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0, 0, 255, 80));

        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, 120, 60, 20, 20);
        g2.fill(rect);

        g2.setFont(new Font("Arial", Font.BOLD, 11));
        FontMetrics f = g.getFontMetrics();
        g2.setColor(Color.WHITE);
        g2.drawString(p.getName(), (x + (120 - f.stringWidth(p.getName())) / 2), y + 18);
        g2.setFont(new Font("Arial", Font.PLAIN, 11));
        f = g.getFontMetrics();
        g2.drawString("$" + String.valueOf(p.getChipBalance()), (x + (120 - f.stringWidth("$" + String.valueOf(p.getChipBalance()))) / 2), y + 35);

        if (p.getAction() != null) {
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            f = g.getFontMetrics();
            g2.drawString(p.getAction(), (x + (120 - f.stringWidth(p.getAction())) / 2), y + 52);
        }


        try {
            if (p.getShow() == true) {
                if (p.getCards()[0] != null && p.getCards()[1] != null && p.inHand() == true) {
                    paintCard(p.getCards()[0], i, g, x + 16 - 3, y + 61);
                    paintCard(p.getCards()[1], i, g, x + 63 - 3, y + 61);
                }
            } else {
                if (p.getCards()[0] != null && p.getCards()[1] != null && p.inHand() == true) {
                    paintCard(null, i, g, x + 16 - 3, y + 60);
                    paintCard(null, i, g, x + 63 - 3, y + 60);
                }
            }
        } catch (Exception e) {
            System.out.println("Could not draw " + getCard(p.getCards()[0]) + " or " + getCard(p.getCards()[1]));
        }
    }

    /**
     * Gets the file path of the card to draw.
     * @param c, the card to draw.
     * @return, the file path.
     */
    public static String getCard(Card c) {

        String cardRepresentation;

        cardRepresentation = "Images/Cards/" + String.valueOf(c.getValue());

        if (c.getSuit() == Suit.Hearts) {
            cardRepresentation += "H.png";
        } else if (c.getSuit() == Suit.Diamonds) {
            cardRepresentation += "D.png";
        } else if (c.getSuit() == Suit.Clubs) {
            cardRepresentation += "C.png";
        } else if (c.getSuit() == Suit.Spades) {
            cardRepresentation += "S.png";
        }
        return cardRepresentation;
    }

    /**
     * Draws a card on the screen.
     * @param c, the card to draw.
     * @param i, the image observer to drawImage.
     * @param g, the graphics to paint with.
     * @param x, the x coordinate to draw from.
     * @param y, the y coordinate to draw from.
     */
    public static void paintCard(Card c, ImageObserver i, Graphics g, int x, int y) {

        try {
            if (c == null) {
                //If card was null it is not yet visible to the user.
                BufferedImage img1 = ImageIO.read(new File("Images/Cards/hidden.png"));
                g.drawImage(img1, x, y, i);
            } else {
                BufferedImage img1 = ImageIO.read(new File(getCard(c)));
                g.drawImage(img1, x, y, i);
            }
        } catch (Exception e) {
            System.out.println("Could not draw Cards");
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param theCards, the cards to paint.
     * @param g, the graphics to paint with.
     * @param i, the image observer to drawImage.
     * @param lessonView, represents where to position cards.
     */
    public static void paintCommunityCards(ArrayList<Card> theCards, Graphics g, ImageObserver i, boolean lessonView) {

        int x = 0;

        if (lessonView) {
            x = -60;
        }

        if (theCards != null) {
            if (theCards.size() > 2) {
                paintCard(theCards.get(0), i, g, 320 + x, 260);
                paintCard(theCards.get(1), i, g, 370 + x, 260);
                paintCard(theCards.get(2), i, g, 420 + x, 260);
            }
            if (theCards.size() > 3) {
                paintCard(theCards.get(3), i, g, 470 + x, 260);
            }
            if (theCards.size() > 4) {
                paintCard(theCards.get(4), i, g, 520 + x, 260);
            }
        }
    }

    /**
     *
     * @param x1, starting x coordinate.
     * @param y1,  starting y coordinate.
     * @param g, the graphics to paint with.
     * @param chips, the amount to draw.
     * @param i, the image observer to drawImage.
     * @param drawRight, additional stacks drawn to the left or right?
     * @param drawUp, draw the chips up from coordinates or down?
     */
    public static void paintPlayerChips(int x1, int y1, Graphics g, int chips, ImageObserver i, boolean drawRight, boolean drawUp) {


        if (chips > 0) {
            int[] chips1 = Utilities.splitChips(chips);
            int x = x1;
            int y = y1;
            int count = 0;
            final int MAX = 10;
            final int X_INCREMENT = 23;
            int right = 1;
            boolean maxReached = false;

            if (drawRight) {
                right = 1;
            } else {
                right = -1;
            }

            if (drawUp) {
            } else {
                y += getChipSize(chips) * 2;
            }

            try {
                while (chips1[0] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/1.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[0]--;
                    count++;
                }
                while (chips1[1] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/5.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[1]--;
                    count++;
                }
                while (chips1[2] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/25.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[2]--;
                    count++;
                }
                while (chips1[3] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/50.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[3]--;
                    count++;
                }
                while (chips1[4] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/100.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[4]--;
                    count++;
                }
                while (chips1[5] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/250.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[5]--;
                    count++;
                }
                while (chips1[6] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/500.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[6]--;
                    count++;
                }
                while (chips1[7] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/1000.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[7]--;
                    count++;
                }
                while (chips1[8] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/2500.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[8]--;
                    count++;
                }
                while (chips1[9] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/5000.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[9]--;
                    count++;
                }
                while (chips1[10] != 0) {
                    if (count == MAX) {
                        count = 0;
                        x += (X_INCREMENT * right);
                        maxReached = true;
                    }
                    BufferedImage img = ImageIO.read(new File("Images/Chips/10000.png"));
                    g.drawImage(img, x, y - (2 * count), i);
                    chips1[10]--;
                    count++;
                }
                if (maxReached) {
                    count = MAX;
                }
                g.setFont(new Font("Arial", Font.BOLD, 11));
                g.setColor(Color.WHITE);

                //If one stack.
                if (x == x1) {
                    g.drawString("$" + String.valueOf(chips), x1 - 3, y - (2 * count));
                } else {
                    //If multiple stack.
                    if (right == 1) {
                        g.drawString("$" + String.valueOf(chips), x1 + 5, y - (2 * count));
                    } else {
                        g.drawString("$" + String.valueOf(chips), x1 - 20, y - (2 * count));
                    }
                }

            } catch (Exception e) {
                System.out.println("Exception Occured - Drawing Chips");
            }
        }
    }

    /**
     * Determines how many chips are needed to represent an amount.
     * @param chips, the amount of chips.
     * @return, the amount needed to represent.
     */
    public static int getChipSize(int chips) {

        if (chips > 0) {
            int[] chips1 = Utilities.splitChips(chips);

            int count = 0;
            final int MAX = 10;

            while (chips1[0] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[0]--;
                count++;
            }
            while (chips1[1] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[1]--;
                count++;
            }
            while (chips1[2] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[2]--;
                count++;
            }
            while (chips1[3] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[3]--;
                count++;
            }
            while (chips1[4] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[4]--;
                count++;
            }
            while (chips1[5] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[5]--;
                count++;
            }
            while (chips1[6] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[6]--;
                count++;
            }
            while (chips1[7] != 0) {
                if (count == MAX) {
                    return MAX;
                }
                chips1[7]--;
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }
}
