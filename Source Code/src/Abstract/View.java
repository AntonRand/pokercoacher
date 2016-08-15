/*
 * 
 * Super class for representing view in both lesson and free play mode. 
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

import Data.User;
import Players.GUILessonPlayer;
import Screens.HomeView;
import Tools.ColorPane;
import Players.Player;
import Tools.BoardGraphics;
import Tools.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Tools.BoardGraphics.*;
import Tools.Score;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities.*;

/**
 *
 * @author Anton
 */
public abstract class View extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private JButton checkCallButton, foldButton, homeButton, raiseButton;
    private JTextField raiseField;
    private JScrollPane scrollPane;
    private JLabel dollars, title;
    private ColorPane gameDetails;
    private int raiseAmount, minimumAmount;
    private User userDetails;
    private Game theGame = null;
    private Score score = new Score();

    /**
     * Super constructor for both lesson and free play views.
     * 
     * @param masterFrame, the JFrame to put the panel onto.
     * @param userDetails, the details of the user logged in.
     * @param startingChips, the amount of chips each player should start with.
     * @param numberOfPlayers, the number of players in the game.
     * @param blindSpeed, the speed for the blinds to increase.
     */
    public View(JFrame masterFrame, User userDetails, int startingChips, int numberOfPlayers, int blindSpeed) {

        super(null);
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        setOpaque(false);

    }

    /**
     * Sets up a new game.
     * @param theGame, the new game to use.
     */
    public void setupGame(Game theGame) {

        //Cannot set up game if it hasn't been initialised yet.
        if (theGame != null) {

            //If there is a game currently running, stop execution.
            if (this.theGame != null) {
                this.theGame.stopThread();
            }

            //Then set up the new game and play it.
            this.theGame = theGame;

            setupLabel();
            setupButtons();
            setupScrollPane();
            setupTextField();

            this.theGame.playGame();
        }
    }

    public JFrame getMasterFrame() {
        return masterFrame;
    }

    public Score getScore() {
        return score;
    }

    public JTextField getCustomRaiseField() {
        return raiseField;
    }

    public ColorPane getDetails() {
        return gameDetails;
    }

    public Game getGame() {
        return theGame;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public Hand getGUIHand() {
        return theGame.getCurrentHand();
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    /**
     * Allows the user details to be updated.
     * @param user, the updated user record.
     */
    public void setUserDetails(User user) {
        userDetails = user;
    }

    /**
     * Set's up the JButtons.
     */
    private void setupButtons() {

        //Checks that buttons haven't already been set up, if they have no need
        //to set them up again.
        if (checkCallButton == null) {

            //Create the buttons, set up the action commands, and position on panel.

            checkCallButton = new JButton("Check");
            foldButton = new JButton("Fold");
            homeButton = new JButton("Home");
            raiseButton = new JButton("Raise");

            checkCallButton.addActionListener(this);
            foldButton.addActionListener(this);
            homeButton.addActionListener(this);
            raiseButton.addActionListener(this);

            checkCallButton.setActionCommand("Check");
            foldButton.setActionCommand("Fold");
            homeButton.setActionCommand("Home");
            raiseButton.setActionCommand("Raise");

            add(checkCallButton);
            add(foldButton);
            add(raiseButton);
            add(homeButton);

            checkCallButton.setBounds(570, 558, 150, 50);
            foldButton.setBounds(570, 608, 150, 50);
            raiseButton.setBounds(720, 558, 150, 100);
            homeButton.setBounds(0, 558, 150, 100);
        }
    }

    /**
     * Called for each new game.
     */
    private void setupScrollPane() {

        //If gameDetails has already been initialised, reset the content.
        if (gameDetails != null) {
            gameDetails.setText("");
            gameDetails.append(Color.BLACK, "New Game Started\n");
        } else {

            //Constructs the ColorPane for gameDetails.
            gameDetails = new ColorPane();
            gameDetails.setSize(10, 150);
            gameDetails.setFont(new Font("Arial", Font.BOLD, 12));
            gameDetails.append(Color.BLACK, "New Game Started\n");

            //Code from the API, ensures content automatically scrolls down for users.
            scrollPane = new JScrollPane(gameDetails);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            add(scrollPane);

            scrollPane.setBounds(150, 558, 420, 100);
        }
    }

    private void setupTextField() {

        //Only needs setting up the first time.
        if (raiseField == null) {

            raiseField = new JTextField(5);

            //The following code is used so that users can press enter instead of clicking
            //the enter button. It was the following two lines were took from: 
            //http://www.coderanch.com/t/338735/GUI/java/make-jButton-respond-Enter-key
            raiseField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "Raise");
            raiseField.getActionMap().put("Raise", detectEnter);

            add(raiseField);
            raiseField.setBounds(905, 595, 80, 50);
            detectChanges();
            disableActionBar();
        }
    }
    //This code was modified from:
    //http://www.coderanch.com/t/338735/GUI/java/make-jButton-respond-Enter-key
    private Action detectEnter = new AbstractAction("Raise") {

        //When a user hits the enter key the action is detected here.
        @Override
        public void actionPerformed(ActionEvent e) {

            //If the raise button wasn't enabled they have no authority to raise.
            if (raiseButton.isEnabled()) {

                //It must follow that it is the players turn.
                if (theGame.getPlayers().get(0).isPlayersTurn() == true) {
                    theGame.getPlayers().get(0).setDecision(raiseAmount);

                    //If the player is a lesson player, the bar should only be disabled if
                    //their action was accepted.
                    if (theGame.getPlayers().get(0).lessonGUIPlayer() == true) {
                        GUILessonPlayer p = (GUILessonPlayer) theGame.getPlayers().get(0);
                        if (p.actionAccepted() == true) {
                            disableActionBar();
                        }
                    }
                }
            }
        }
    };

    private void setupLabel() {

        //Only needs initialising once.

        //Setup and add label.
        if (gameDetails == null) {
            title = Utilities.plainLabel("Type a custom raise below:", 10);
            dollars = Utilities.plainLabel("$", 20);

            add(title);
            add(dollars);

            title.setBounds(835, 540, 170, 80);
            dollars.setBounds(875, 610, 20, 20);
        }
    }

    //Detects changes to the raise text field.
    //Detection code taken from Code Taken from http://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    private void detectChanges() {

        //Add a document listener, call the update field method when changes are detected.
        raiseField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                updateField();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                updateField();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                updateField();
            }
        });
    }

    /**
     * 
     */
    public void updateField() {

        try {

            //Disable the raise button.
            raiseButton.setEnabled(false);

            //Negative integers are not acceptable.
            if (!raiseField.getText().equals("-")) {

                //Attempt to parse the text
                int val = Integer.parseInt(raiseField.getText());

                //If an integer was successfully parsed, check that it meets the minimum amount.
                if (val >= 0 && val < theGame.getPlayers().get(0).getChipBalance()) {
                    int minRaise = minimumAmount - theGame.getPlayers().get(0).getAmountCalled();

                    //Players must raise by at least the big blind.
                    if (minRaise == 0) {
                        if (val >= theGame.getBigBlind()) {
                            raiseButton.setEnabled(true);
                            raiseButton.setText("Raise to $" + (val));
                            raiseAmount = Integer.parseInt(raiseField.getText()) - theGame.getPlayers().get(0).getAmountCalled();
                        }
                    } else {
                        //Players must raise by at least the raise amount here.
                        if (val >= minimumAmount + minRaise) {
                            raiseButton.setEnabled(true);
                            raiseButton.setText("Raise to $" + (val));
                            raiseAmount = Integer.parseInt(raiseField.getText()) - theGame.getPlayers().get(0).getAmountCalled();
                        }
                    }
                } else if (val >= 0 && val == theGame.getPlayers().get(0).getChipBalance()) {
                    //Players are allowed to go all in, this detects if they have gone all in
                    //and changes the text appropriately.
                    raiseButton.setEnabled(true);
                    raiseButton.setText("All In $" + val);
                    raiseAmount = Integer.parseInt(raiseField.getText());
                }
            } else {
                //Disable the button if a negative number was inputted.
                raiseButton.setEnabled(false);
            }
        } catch (Exception e) {

            //If the Integer couldn't be parsed, it was an invalid value and the raise
            //button should be disabled.
            raiseButton.setEnabled(false);
        }
    }

    /**
     * Displays the buttons correctly depending on the amount to call.
     * @param betAmount, the amount to call.
     */
    public void updateButtons(int betAmount) {

        this.minimumAmount = betAmount;

        //If must be the users turn for any buttons to be enabled.
        if (theGame.getPlayers().get(0).isPlayersTurn() == true) {

            //If the player has matched the current bet.
            if ((betAmount - theGame.getPlayers().get(0).getAmountCalled()) == 0) {
                checkCallButton.setText("Check");
                raiseButton.setText("Bet $" + theGame.getBigBlind());
                raiseAmount = theGame.getBigBlind();
                enableActionBar();
            } else {

                //If the amount to call is more than their chip balance.
                if (betAmount - theGame.getPlayers().get(0).getAmountCalled() > theGame.getPlayers().get(0).getChipBalance()) {

                    //They must go all in to match the bet.
                    checkCallButton.setText("All In $" + theGame.getPlayers().get(0).getChipBalance());

                    //They would be unable to raise.
                    checkCallButton.setEnabled(true);
                    raiseButton.setEnabled(false);
                    foldButton.setEnabled(true);
                    raiseField.setEnabled(false);

                } else {

                    //If the user has been raised, they must call, they cannot check.
                    checkCallButton.setText("Call $" + (betAmount - theGame.getPlayers().get(0).getAmountCalled()));
                    if ((betAmount * 2) > theGame.getPlayers().get(0).getChipBalance()) {
                        //Test This
                        raiseButton.setText("All In $" + ((betAmount * 2)));
                        raiseAmount = theGame.getPlayers().get(0).getChipBalance();
                    } else {
                        raiseButton.setText("Raise to $" + ((betAmount * 2)));
                        raiseAmount = betAmount * 2;
                    }
                    enableActionBar();
                }
            }
        } else {
            //The bar can only be enabled if it is the players turn.
            disableActionBar();
        }
    }

    /**
     * Allows the user to click input an action.
     */
    private void enableActionBar() {
        checkCallButton.setEnabled(true);
        raiseButton.setEnabled(true);
        foldButton.setEnabled(true);
        raiseField.setEnabled(true);
    }

    /**
     * Stops a user inputting an action out of turn.
     */
    public void disableActionBar() {

        System.out.print(" ");

        checkCallButton.setEnabled(false);
        raiseButton.setEnabled(false);
        foldButton.setEnabled(false);
        raiseField.setEnabled(false);
    }

    /**
     * Draws the Dealer, Big Blind and Small Blind Chips.
     * @param g, the graphics to draw with.
     * @param lessonView, the lesson view.
     * @throws IOException 
     */
    public void drawButtons(Graphics g, boolean lessonView) throws IOException {
        int dealer = theGame.getCurrentHand().getDealerPosition();
        int bigBlind = theGame.getCurrentHand().getBigBlindPosition();
        int smallBlind = theGame.getCurrentHand().getSmallBlindPosition();

        int shift = 0;

        //One of the players needs moving further left for lesson view.
        if (lessonView) {
            shift = - 85;
        }

        //Load the images.
        BufferedImage dealerChip = ImageIO.read(new File("Images/Buttons/Dealer.png"));
        BufferedImage bigBlindChip = ImageIO.read(new File("Images/Buttons/BigBlind.png"));
        BufferedImage smallBlindChip = ImageIO.read(new File("Images/Buttons/SmallBlind.png"));

        //For when there are only two players in the game.
        if (dealer == smallBlind) {
            smallBlind = -1;
            bigBlind = -1;
        }

        //Draw the dealer in the correct position.
        switch (dealer) {
            case 0:
                g.drawImage(dealerChip, 451 + shift, 395, this);
                break;
            case 1:
                g.drawImage(dealerChip, 261 + shift, 375, this);
                break;
            case 2:
                g.drawImage(dealerChip, 170 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 3:
                g.drawImage(dealerChip, 261 + shift, 191, this);
                break;
            case 4:
                g.drawImage(dealerChip, 451 + shift, 171, this);
                break;
            case 5:
                g.drawImage(dealerChip, 646 + shift, 191, this);
                break;
            case 6:
                g.drawImage(dealerChip, 675 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 7:
                g.drawImage(dealerChip, 646 + shift, 375, this);
                break;
        }


        //Draw the Big Blind in the correct position.
        switch (bigBlind) {
            case 0:
                g.drawImage(bigBlindChip, 451 + shift, 395, this);
                break;
            case 1:
                g.drawImage(bigBlindChip, 261 + shift, 375, this);
                break;
            case 2:
                g.drawImage(bigBlindChip, 170 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 3:
                g.drawImage(bigBlindChip, 261 + shift, 191, this);
                break;
            case 4:
                g.drawImage(bigBlindChip, 451 + shift, 171, this);
                break;
            case 5:
                g.drawImage(bigBlindChip, 646 + shift, 191, this);
                break;
            case 6:
                g.drawImage(bigBlindChip, 675 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 7:
                g.drawImage(bigBlindChip, 646 + shift, 375, this);
                break;
        }

        //Draw the Small Blind in the correct position.
        switch (smallBlind) {
            case 0:
                g.drawImage(smallBlindChip, 451 + shift, 395, this);
                break;
            case 1:
                g.drawImage(smallBlindChip, 261 + shift, 375, this);
                break;
            case 2:
                g.drawImage(smallBlindChip, 170 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 3:
                g.drawImage(smallBlindChip, 261 + shift, 191, this);
                break;
            case 4:
                g.drawImage(smallBlindChip, 451 + shift, 171, this);
                break;
            case 5:
                g.drawImage(smallBlindChip, 646 + shift, 191, this);
                break;
            case 6:
                g.drawImage(smallBlindChip, 675 + shift + (int) (-shift * 0.42), 273, this);
                break;
            case 7:
                g.drawImage(smallBlindChip, 646 + shift, 375, this);
                break;
        }

    }

    /**
     * Displays the amount of chips in the pot
     * @param g2, the graphics to draw with.
     * @param lessonView, boolean representing lessonView or freeplayView.
     */
    public void drawPot(Graphics g2, boolean lessonView) {

        //Only draw the pot if there are chips in the pot.
        if (theGame.getCurrentHand().getPotsTotal() > 0) {

            int x = 410;
            int y = 255;
            if (lessonView) {
                x = 350;
            }

            //Display the Pot Total.
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            g2.setColor(Color.WHITE);
            g2.drawString("Pot Total: $" + String.valueOf(theGame.getCurrentHand().getPotsTotal()), x, y);
        }
    }

    /**
     * Draws each players chips bet.
     * @param g, the graphics to draw with.
     * @param lessonView, boolean representing lessonView or freeplayView.
     * @throws IOException 
     */
    public void drawChips(Graphics g, boolean lessonView) throws IOException {

        //If lesson view, need to position differently.
        int scale = 0;
        if (lessonView) {
            scale = 1;
        }

        //Get the amount of starting players.
        ArrayList<Player> players = theGame.getPlayers();
        int numberOfPlayers = theGame.getPlayers().size();

        //Depending on the number of starting players, attempt to draw their chips.
        //If the player is out it there won't be any chips to paint.
        if (numberOfPlayers > 7) {
            BoardGraphics.paintPlayerChips(621 + (scale * -85), 375, g, players.get(7).getAmountCalled(), this, false, true);
        }
        if (numberOfPlayers > 6) {
            BoardGraphics.paintPlayerChips(649 + (scale * -50), 288, g, players.get(6).getAmountCalled(), this, false, false);
        }
        if (numberOfPlayers > 5) {
            BoardGraphics.paintPlayerChips(613 + (scale * -80), 206, g, players.get(5).getAmountCalled(), this, false, false);
        }
        if (numberOfPlayers > 4) {
            BoardGraphics.paintPlayerChips(481 + (scale * -85), 186, g, players.get(4).getAmountCalled(), this, true, false);
        }
        if (numberOfPlayers > 3) {
            BoardGraphics.paintPlayerChips(291 + (scale * -90), 206, g, players.get(3).getAmountCalled(), this, true, false);
        }
        if (numberOfPlayers > 2) {
            BoardGraphics.paintPlayerChips(195 + (scale * -50), 273, g, players.get(2).getAmountCalled(), this, true, true);
        }
        if (numberOfPlayers > 1) {
            BoardGraphics.paintPlayerChips(287 + (scale * -84), 375, g, players.get(1).getAmountCalled(), this, true, true);
            BoardGraphics.paintPlayerChips(477 + (scale * -84), 395, g, players.get(0).getAmountCalled(), this, true, true);
        }
    }

    public abstract boolean isLessonView();

    @Override
    public synchronized void actionPerformed(ActionEvent ae) {


        if (ae.getActionCommand().matches("Home")) {
            //Take the player to the home screen.
            masterFrame.remove(this);
            theGame.stopThread();
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Check")) {


            //If the player clicked Check, ensure it is their turn.


            if (theGame.getPlayers().get(0).isPlayersTurn() == true) {


                //Calculates the players decision.
                if (minimumAmount - theGame.getPlayers().get(0).getAmountCalled() > theGame.getPlayers().get(0).getChipBalance()) {
                    theGame.getPlayers().get(0).setDecision(theGame.getPlayers().get(0).getChipBalance());
                } else {
                    theGame.getPlayers().get(0).setDecision(minimumAmount - theGame.getPlayers().get(0).getAmountCalled());
                }

                if (theGame.getPlayers().get(0).lessonGUIPlayer() == true) {

                    //If they were a lesson player, ensure they chose a correct action.
                    GUILessonPlayer p = (GUILessonPlayer) theGame.getPlayers().get(0);
                    if (p.actionAccepted() == true) {
                        //Only disable if accepted
                        disableActionBar();
                    }
                }
            }
        } else if (ae.getActionCommand().matches("Raise")) {

            //If the player clicked Raise, ensure it is their turn.

            if (theGame.getPlayers().get(0).isPlayersTurn() == true) {

                //Calculates the players decision.
                theGame.getPlayers().get(0).setDecision(raiseAmount);

                //If they were a lesson player, ensure they chose a correct action.
                if (theGame.getPlayers().get(0).lessonGUIPlayer() == true) {
                    GUILessonPlayer p = (GUILessonPlayer) theGame.getPlayers().get(0);
                    if (p.actionAccepted() == true) {
                        //Only disable if accepted
                        disableActionBar();
                    }
                }
            }
        } else if (ae.getActionCommand().matches("Fold")) {

            //If the player clicked Fold, ensure it is their turn.


            if (theGame.getPlayers().get(0).isPlayersTurn() == true) {

                //-1 indicates fold. 0 indicates check.
                theGame.getPlayers().get(0).setDecision(-1);

                //If they were a lesson player, ensure they chose a correct action.
                if (theGame.getPlayers().get(0).lessonGUIPlayer() == true) {
                    GUILessonPlayer p = (GUILessonPlayer) theGame.getPlayers().get(0);
                    if (p.actionAccepted() == true) {
                        //Only disable if accepted
                        disableActionBar();
                    }
                }
            }
        }
    }
}
