/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.User;
import Tools.Utilities;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.ho.yaml.Yaml;

/**
 *
 * After Initial problems with getting the JFrame to change view I adapted code from
 * http://java.ittoolbox.com/groups/technical-functional/java-l/replacing-one-jpanel-with-another-on-one-frame-99403
 * 
 * I learnt from this that validate is necessary to ensure the new panel is painted, I was getting the same screen
 * without calling this method.
 *
 * LoginView Class.
 *
 * @author Anton
 */
public class LoginView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel newUserLabel, existingUserLabel;
    private JLabel usernameLabel, passwordLabel;
    private JButton loginButton, registerButton, exitButton, forgotPasswordButton;
    private User userDetails;
    private JEditorPane feedback = new JEditorPane();

    /**
     * Constructor for LoginView.
     * @param masterFrame, the JFrame the panel is on
     * @param state, used to display feedback messages.
     */
    public LoginView(JFrame masterFrame, int state) {
        super(null);
        this.masterFrame = masterFrame;
        setOpaque(false);
        this.masterFrame.setTitle("Welcome to Poker Coach - Please Log in or Register");
        setupLabels();
        setupButtons();
        setupTextField();
        setupPasswordField();
        setupFeedback();

        if (state == 1) {
            //User has just registered.
            successfulRegistration();
        } else if (state == 2) {
            //User has just changed their password.
            successfulChange();
        }
    }

    public final void setupLabels() {

        newUserLabel = Utilities.boldLabel("New Users", 36);
        existingUserLabel = Utilities.boldLabel("Existing Users", 36);
        usernameLabel = Utilities.plainLabel("Username:", 26);
        passwordLabel = Utilities.plainLabel("Password:", 26);

        add(newUserLabel);
        add(existingUserLabel);
        add(usernameLabel);
        add(passwordLabel);

        newUserLabel.setAlignmentX(SwingConstants.LEFT);
        existingUserLabel.setAlignmentX(SwingConstants.LEFT);

        newUserLabel.setBounds(485, 437, 240, 100);
        existingUserLabel.setBounds(490, 125, 300, 100);
        usernameLabel.setBounds(500, 205, 300, 40);
        passwordLabel.setBounds(500, 247, 300, 40);
    }

    public final void setupButtons() {

        loginButton = new JButton("Log in");
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");
        forgotPasswordButton = new JButton("Forgotten password?");

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        exitButton.addActionListener(this);
        forgotPasswordButton.addActionListener(this);

        loginButton.setActionCommand("Log In");
        registerButton.setActionCommand("Register");
        exitButton.setActionCommand("Exit");
        forgotPasswordButton.setActionCommand("Forgot Password");

        add(loginButton);
        add(registerButton);
        add(exitButton);
        add(forgotPasswordButton);

        loginButton.setBounds(820, 293, 160, 50);
        registerButton.setBounds(820, 467, 160, 50);
        exitButton.setBounds(5, 605, 160, 50);
        forgotPasswordButton.setBounds(645, 293, 170, 50);
    }

    public final void setupTextField() {

        usernameField = new JTextField(15);
        add(usernameField);
        usernameField.setBounds(820, 209, 160, 35);
    }

    public final void setupPasswordField() {

        passwordField = new JPasswordField(15);
        add(passwordField);
        passwordField.setBounds(820, 251, 160, 35);
    }

    private void setupFeedback() {
        feedback.setContentType("text/html");
        feedback.setEditable(false);
        feedback.setOpaque(false);
        add(feedback);
        feedback.setBounds(505, 350, 480, 70);
    }

    @Override
    public void paint(Graphics g) {

        //Draw background and title.
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

        //Drawing of the background squares
        RoundRectangle2D rect = new RoundRectangle2D.Double(495, 150, 500, 270, 20, 20);
        g2.fill(rect);

        rect = new RoundRectangle2D.Double(495, 440, 500, 100, 20, 20);
        g2.fill(rect);

        super.paint(g);
    }

    /**
     * Following methods are used to display feedback.
     */
    private void successfulRegistration() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Successfully Registered</b>: Please log in</p>"
                + "</html>");
    }

    private void successfulChange() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Password Successfully Changed</b>: Please log in</p>"
                + "</html>");
    }

    private void incorrectPassword() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Incorrect password</p>"
                + "</html>");
    }

    private void noUser() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Username not found on records</p>"
                + "</html>");
    }

    private void usernameFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Usernames must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    private void passwordFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Passwords must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Log In")) {
            login();
        } else if (ae.getActionCommand().matches("Register")) {
            register();
        } else if (ae.getActionCommand().matches("Forgot Password")) {
            forgotPassword();
        } else {
            //Exit
            System.exit(0);
        }
    }

    /**
     * Logs in user or displays error message.
     */
    public void login() {

        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        boolean fieldError = false;

        if (!Utilities.between(usernameField.getText(), 5, 15)) {
            //If the username is too small or too big.
            fieldError = true;
            usernameFormat();
        } else if (!Utilities.between(passwordField.getText(), 5, 15)) {
            //If the password is too small or too big.
            fieldError = true;
            passwordFormat();
        }

        boolean usernameExists = false;

        if (fieldError == false) {
            for (User user : userList) {

                //If the username is found on the database.
                if (usernameField.getText().matches(user.getUsername())) {
                    usernameExists = true;

                    String encryptedPassword = Utilities.encrypt(passwordField.getText());

                    if (encryptedPassword.equals(user.getPassword())) {
                        //If the password is the same.
                        userDetails = user;
                        masterFrame.remove(this);
                        masterFrame.add(new HomeView(masterFrame, userDetails));
                        masterFrame.getComponent(0).validate();
                    } else {
                        //If the password is different.
                        incorrectPassword();
                    }
                    break;
                }
            }
            if (!usernameExists) {
                noUser();
            }
        }
    }

    public void register() {
        masterFrame.setTitle("Registration Screen");
        masterFrame.remove(this);
        masterFrame.add(new RegisterView(masterFrame));
        masterFrame.getComponent(0).validate();
    }

    public void forgotPassword() {
        masterFrame.remove(this);
        masterFrame.add(new ForgotPasswordView(masterFrame));
        masterFrame.getComponent(0).validate();
    }
}
