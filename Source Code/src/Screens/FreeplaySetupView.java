/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.User;
import Freeplay.FreeplayView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Dictionary;
import javax.imageio.ImageIO;
import javax.swing.*;
import Tools.Utilities;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import org.ho.yaml.Yaml;

/**
 * FreeplaySetupView Class.
 * @author Anton
 */
public class FreeplaySetupView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private JSlider numberOfPlayersSlider, startingChipsSlider, difficultySlider, blindTimeSlider;
    private User userDetails;

    /**
     * Constructor for FreeplaySetupView
     * @param masterFrame, the JFrame the panel is on
     * @param userDetails, the logged in user details.
     */
    public FreeplaySetupView(JFrame masterFrame, User userDetails) {

        super(null);
        this.masterFrame = masterFrame;
        this.userDetails = userDetails;
        masterFrame.setTitle("Poker Coach - Set up game");
        setOpaque(false);

        setupLabels();
        setupButtons();
        setupSliders();
    }

    /**
     * Sets up the labels for the parameters.
     */
    public final void setupLabels() {

        JLabel customLabel = Utilities.boldLabel("Custom Tournament", 36);
        JLabel usernameLabel = Utilities.plainLabel("Starting Chips:", 24);
        JLabel blindSpeedLabel = Utilities.plainLabel("Blind Speed (Minutes):", 24);
        JLabel difficultyLabel = Utilities.plainLabel("Difficulty:", 24);
        JLabel numberOfPlayersLabel = Utilities.plainLabel("Opponents:", 24);

        add(customLabel);
        add(usernameLabel);
        add(blindSpeedLabel);
        add(difficultyLabel);
        add(numberOfPlayersLabel);

        customLabel.setBounds(445, 125, 500, 100);

        usernameLabel.setAlignmentX(SwingConstants.RIGHT);
        blindSpeedLabel.setAlignmentX(SwingConstants.RIGHT);
        difficultyLabel.setAlignmentX(SwingConstants.RIGHT);
        numberOfPlayersLabel.setAlignmentX(SwingConstants.RIGHT);

        usernameLabel.setBounds(270, 235 - 60, 500, 100);
        blindSpeedLabel.setBounds(270, 315 - 60, 500, 50);
        difficultyLabel.setBounds(270, 375 - 60, 500, 50);
        numberOfPlayersLabel.setBounds(270, 440 - 60, 500, 50);
    }

    /**
     * Sets up the buttons.
     */
    public final void setupButtons() {

        JButton playButton = new JButton("Play");
        JButton backButton = new JButton("Back");

        playButton.addActionListener(this);
        backButton.addActionListener(this);

        playButton.setActionCommand("Play");
        backButton.setActionCommand("Back");

        add(playButton);
        add(backButton);

        playButton.setBounds(820, 460, 160, 50);
        backButton.setBounds(5, 605, 160, 50);
    }

    /**
     * Sets up the sliders, allowing users to pick preset values.
     * Learnt how to set labels for Easy, Normal and Hard from:
     * http://stackoverflow.com/questions/1125619/change-displayable-labels-for-a-jslider
     */
    public final void setupSliders() {

        numberOfPlayersSlider = new JSlider(1, 7, 4);
        numberOfPlayersSlider.setMajorTickSpacing(1);
        numberOfPlayersSlider.setPaintTicks(true);
        numberOfPlayersSlider.setSnapToTicks(true);
        numberOfPlayersSlider.setFont(new Font("Arial", Font.BOLD, 10));
        numberOfPlayersSlider.setForeground(Color.WHITE);
        numberOfPlayersSlider.setPaintLabels(true);
        numberOfPlayersSlider.setOpaque(false);

        difficultySlider = new JSlider(0, 2, 1);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setSnapToTicks(true);
        difficultySlider.setFont(new Font("Arial", Font.BOLD, 36));
        difficultySlider.setForeground(Color.WHITE);
        difficultySlider.setPaintLabels(true);
        difficultySlider.setOpaque(false);


        Dictionary difficultyLabels = difficultySlider.getLabelTable();
        JLabel easy = Utilities.boldLabel("Easy", 10);
        JLabel medium = Utilities.boldLabel("Normal", 10);
        JLabel hard = Utilities.boldLabel("Hard", 10);
        difficultyLabels.put(0, easy);
        difficultyLabels.put(1, medium);
        difficultyLabels.put(2, hard);
        difficultySlider.setLabelTable(difficultyLabels);

        blindTimeSlider = new JSlider(0, 3, 2);
        blindTimeSlider.setMajorTickSpacing(1);
        blindTimeSlider.setPaintTicks(true);
        blindTimeSlider.setSnapToTicks(true);
        blindTimeSlider.setFont(new Font("Arial", Font.BOLD, 36));
        blindTimeSlider.setForeground(Color.WHITE);
        blindTimeSlider.setPaintLabels(true);
        blindTimeSlider.setOpaque(false);

        Dictionary blindTimeLabels = blindTimeSlider.getLabelTable();
        JLabel one = Utilities.boldLabel("2", 10);
        JLabel two = Utilities.boldLabel("4", 10);
        JLabel three = Utilities.boldLabel("6", 10);
        JLabel four = Utilities.boldLabel("8", 10);
        blindTimeLabels.put(0, one);
        blindTimeLabels.put(1, two);
        blindTimeLabels.put(2, three);
        blindTimeLabels.put(3, four);
        blindTimeSlider.setLabelTable(blindTimeLabels);

        startingChipsSlider = new JSlider(1, 4, 3);
        startingChipsSlider.setMajorTickSpacing(1);
        startingChipsSlider.setPaintTicks(true);
        startingChipsSlider.setSnapToTicks(true);
        startingChipsSlider.setFont(new Font("Arial", Font.BOLD, 36));
        startingChipsSlider.setForeground(Color.WHITE);
        startingChipsSlider.setPaintLabels(true);
        startingChipsSlider.setOpaque(false);

        Dictionary startingChipsLabels = startingChipsSlider.getLabelTable();
        JLabel startingOne = Utilities.boldLabel("$1000", 10);
        JLabel startingTwo = Utilities.boldLabel("$2000", 10);
        JLabel startingThree = Utilities.boldLabel("$3000", 10);
        JLabel startingFour = Utilities.boldLabel("$4000", 10);
        startingChipsLabels.put(1, startingOne);
        startingChipsLabels.put(2, startingTwo);
        startingChipsLabels.put(3, startingThree);
        startingChipsLabels.put(4, startingFour);
        startingChipsSlider.setLabelTable(startingChipsLabels);

        add(numberOfPlayersSlider);
        add(difficultySlider);
        add(blindTimeSlider);
        add(startingChipsSlider);

        numberOfPlayersSlider.setBounds(785, 425 - 60, 200, 100);
        difficultySlider.setBounds(785, 360 - 60, 200, 100);
        blindTimeSlider.setBounds(785, 300 - 60, 200, 100);
        startingChipsSlider.setBounds(785, 240 - 60, 200, 100);
    }

    @Override
    public void paint(Graphics g) {

        //Draw the background.
        try {
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/startup.png"));
            g.drawImage(img, 0, 0, this);
        } catch (Exception e) {
            System.out.println("Error - Could not Draw Background");
        }


        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(122, 122, 122, 80));

        //Drawing of the background square.
        RoundRectangle2D rect = new RoundRectangle2D.Double(495, 150, 500, 390, 20, 20);

        g2.fill(rect);
        super.paint(g);
    }

    /**
     * Loading and saving uses code from the JYAML API.
     */
    public void updateEarnings() {

        try {
            //Load List
            ArrayList<User> userList = new ArrayList<User>();
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);

            for (User user : userList) {
                if (user.getUsername().equals(userDetails.getUsername())) {
                    //Make them pay at the start of the tournament, so that if they cancel
                    //their loss is still registered.
                    int costs = user.getStatistics().getTournamentCosts();
                    user.getStatistics().setTournamentCosts(costs + (startingChipsSlider.getValue() * 1000));
                    userDetails = user;
                }
            }
            //Save List
            Yaml.dump(userList, new File("users.yml"));
        } catch (Exception e) {
            System.out.println("Error, could not find data file....");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Back")) {
            masterFrame.remove(this);
            masterFrame.add(new HomeView(masterFrame, userDetails));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Play")) {
            masterFrame.remove(this);
            updateEarnings();
            masterFrame.add(new FreeplayView(masterFrame, userDetails, (startingChipsSlider.getValue() * 1000), numberOfPlayersSlider.getValue(), blindTimeSlider.getValue(), difficultySlider.getValue()));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Exit")) {
            System.exit(0);
        }
    }
}
