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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.ho.yaml.Yaml;

/**
 * ForgotPasswordView Class.
 * @author Anton
 */
public class ForgotPasswordView extends JPanel implements ActionListener {

    private JFrame theFrame;
    private JTextField usernameField;
    private JLabel feedbackMessage;
    private JEditorPane feedbackOne = new JEditorPane();
    private JEditorPane feedbackTwo = new JEditorPane();
    private JLabel usernameLabel; //passwordLabel;
    private User userDetails;
    //Forgotton Password Fields
    private JTextField answer;
    private JPasswordField newPassword, confirmedPassword;
    private JLabel resetPasswordLabel, secretQuestionTitleLabel;
    private JEditorPane secretQuestionLabel = new JEditorPane();
    private JLabel answerLabel, newPasswordLabel, confirmedPasswordLabel;
    private JButton backButton, getQuestionButton, changePasswordButton;

    /**
     * Construct the view.
     * @param masterFrame, the JFrame the panel is on.
     */
    public ForgotPasswordView(JFrame masterFrame) {

        //Setup the view.
        super(null);
        this.theFrame = masterFrame;
        setOpaque(false);
        theFrame.setTitle("Welcome to Poker Coach - Forgotton Password");
        setupLabels();
        setupButtons();
        setupTextFields();
        setupPasswordFields();
        setupFeedback();
    }

    public final void setupLabels() {

        feedbackMessage = Utilities.boldLabel("", 15);
        resetPasswordLabel = Utilities.boldLabel("Reset Password", 36);
        secretQuestionTitleLabel = Utilities.boldLabel("Secret Question", 26);
        usernameLabel = Utilities.plainLabel("Username:", 26);
        answerLabel = Utilities.plainLabel("Answer:", 26);
        newPasswordLabel = Utilities.plainLabel("New Password:", 26);
        confirmedPasswordLabel = Utilities.plainLabel("Confirm Password:", 26);

        secretQuestionLabel.setContentType("text/html");
        secretQuestionLabel.setOpaque(false);

        add(feedbackMessage);
        add(resetPasswordLabel);
        add(secretQuestionTitleLabel);
        add(secretQuestionLabel);
        add(usernameLabel);
        add(answerLabel);
        add(newPasswordLabel);
        add(confirmedPasswordLabel);

        secretQuestionTitleLabel.setAlignmentX(SwingConstants.LEFT);
        resetPasswordLabel.setAlignmentX(SwingConstants.LEFT);

        resetPasswordLabel.setBounds(504, 125, 300, 100);
        secretQuestionTitleLabel.setBounds(465, 270, 300, 100);
        secretQuestionLabel.setBounds(515, 320, 465, 50);
        usernameLabel.setBounds(500, 205, 300, 40);
        answerLabel.setBounds(500, 347, 300, 100);
        newPasswordLabel.setBounds(500, 347 + 42, 300, 100);
        confirmedPasswordLabel.setBounds(500, 347 + 84, 300, 100);

        secretQuestionTitleLabel.setVisible(false);
        secretQuestionLabel.setVisible(false);
        answerLabel.setVisible(false);
        newPasswordLabel.setVisible(false);
        confirmedPasswordLabel.setVisible(false);
    }

    private void setupFeedback() {

        feedbackOne.setContentType("text/html");
        feedbackOne.setEditable(false);
        feedbackOne.setOpaque(false);
        add(feedbackOne);
        feedbackOne.setBounds(505, 300, 480, 70);

        feedbackTwo.setContentType("text/html");
        feedbackTwo.setEditable(false);
        feedbackTwo.setOpaque(false);
        add(feedbackTwo);
        feedbackTwo.setBounds(505, 560, 480, 70);
    }

    public final void setupButtons() {

        backButton = new JButton("Back");
        getQuestionButton = new JButton("Retrieve question");
        changePasswordButton = new JButton("Change password");

        backButton.addActionListener(this);
        getQuestionButton.addActionListener(this);
        changePasswordButton.addActionListener(this);

        backButton.setActionCommand("Back");
        getQuestionButton.setActionCommand("Retrieve Question");
        changePasswordButton.setActionCommand("Change Password");

        add(backButton);
        add(getQuestionButton);
        add(changePasswordButton);

        backButton.setBounds(5, 605, 160, 50);
        getQuestionButton.setBounds(820, 251, 160, 50);
        changePasswordButton.setBounds(820, 506, 160, 50);

        changePasswordButton.setVisible(false);
    }

    public final void setupTextFields() {

        usernameField = new JTextField(15);
        answer = new JTextField(30);

        add(usernameField);
        add(answer);

        usernameField.setBounds(820, 209, 160, 35);
        answer.setBounds(820, 380, 160, 35);

        answer.setVisible(false);

        detectChanges();
    }

    /**
     * Detects when a change is made to the user text field, so that I can hide the
     * reset fields and prevent users changing another users password.
     * 
     * Uses a document listener with code took from:
     * http://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
     */
    private void detectChanges() {

        usernameField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                reset();
            }

            public void reset() {
                //Hides the relevant fields.
                secretQuestionTitleLabel.setVisible(false);
                secretQuestionLabel.setVisible(false);
                answer.setVisible(false);
                answerLabel.setVisible(false);
                newPassword.setVisible(false);
                newPasswordLabel.setVisible(false);
                confirmedPassword.setVisible(false);
                confirmedPasswordLabel.setVisible(false);
                changePasswordButton.setVisible(false);
                resetMessage();
            }
        });
    }

    public final void setupPasswordFields() {

        newPassword = new JPasswordField(15);
        confirmedPassword = new JPasswordField(15);

        add(newPassword);
        add(confirmedPassword);

        newPassword.setBounds(820, 422, 160, 35);
        confirmedPassword.setBounds(820, 464, 160, 35);

        newPassword.setVisible(false);
        confirmedPassword.setVisible(false);
    }

    /**
     * Once a user enters correct details, displays the information needed to reset
     * password.
     */
    public final void displayQuestion() {

        secretQuestionTitleLabel.setVisible(true);
        secretQuestionLabel.setVisible(true);

        secretQuestionLabel.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:left;\">" + userDetails.getSecretQuestion() + "</p>"
                + "</html>");

        answer.setVisible(true);
        answerLabel.setVisible(true);
        newPassword.setVisible(true);
        newPasswordLabel.setVisible(true);
        confirmedPassword.setVisible(true);
        confirmedPasswordLabel.setVisible(true);
        changePasswordButton.setVisible(true);
        resetMessage();
    }

    @Override
    public void paint(Graphics g) {

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

        //Drawing of the background square
        RoundRectangle2D rect = new RoundRectangle2D.Double(495, 150, 500, 480, 20, 20);
        g2.fill(rect);

        super.paint(g);
    }

    /**
     * The following methods are used to display error messages.
     */
    public void noUser() {
        feedbackOne.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Username not found on records</p>"
                + "</html>");
    }

    public void usernameFormat() {
        feedbackOne.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Usernames must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    public void passwordFormat() {
        feedbackOne.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Passwords must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    public void resetMessage() {
        feedbackOne.setText("");
        feedbackTwo.setText("");
    }

    public void passwordFormatTwo() {
        feedbackTwo.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Passwords must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    public void answerFormat() {
        feedbackTwo.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Answers must be between 5 and 30 characters long</p>"
                + "</html>");
    }

    public void incorrectPasswordChange() {
        feedbackTwo.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Passwords do not match</p>"
                + "</html>");
    }

    public void incorrectAnswerChange() {
        feedbackTwo.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Error</b>: Incorrect answer</p>"
                + "</html>");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Retrieve Question")) {
            retrieveQuestion();
        } else if (ae.getActionCommand().matches("Change Password")) {
            changePassword();
        } else if (ae.getActionCommand().matches("Back")) {
            theFrame.remove(this);
            theFrame.add(new LoginView(theFrame, 0));
            theFrame.getComponent(0).validate();
        } else {
            //Exit
            System.exit(0);
        }
    }

    /**
     * Changes password if all conditions met.
     * Loading and saving of JYAML files was taken from the website API.
     * Password encryption method took from another website.
     */
    public void changePassword() {

        String encryptedAnswer = userDetails.getSecretAnswer();
        String newPass = newPassword.getText();

        try {

            //Answer must be between 5 and 30 characters.
            if (!Utilities.between(answer.getText(), 5, 30)) {
                answerFormat();
                //Passwords must be between 5 and 30 characters.
            } else if (!Utilities.between(newPass, 5, 30)) {
                passwordFormatTwo();
            } else {
                //If the answers match.
                if (encryptedAnswer.equals(Utilities.encrypt(answer.getText()))) {
                    if (newPass.equals(confirmedPassword.getText())) {

                        //Load List
                        ArrayList<User> userList = new ArrayList<User>();
                        try {
                            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
                        } catch (Exception e) {
                            System.out.println("Error, could not find data file.");
                        }

                        //Alter Users Password
                        for (User user : userList) {
                            if (usernameField.getText().equals(userDetails.getUsername())) {
                                user.setPassword(Utilities.encrypt(newPass));
                            }
                        }
                        //Save List
                        try {
                            Yaml.dump(userList, new File("users.yml"));
                            //Take the user back to the log in screen.
                            theFrame.remove(this);
                            theFrame.add(new LoginView(theFrame, 2));
                            theFrame.getComponent(0).validate();
                        } catch (FileNotFoundException ex) {
                            System.out.println("Could not change");
                        }
                    } else {
                        incorrectPasswordChange();
                    }
                } else {
                    incorrectAnswerChange();
                }
            }
        } catch (Exception e) {
            System.out.println("Error - Could Not Change Password");
        }
    }

    /**
     * Displays secret question if username correct.
     */
    public void retrieveQuestion() {

        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        //Username must be between 5 and 30 characters.
        if (!Utilities.between(usernameField.getText(), 5, 30)) {
            usernameFormat();
        } else {

            boolean usernameExists = false;

            for (User user : userList) {

                //If the username is found on the database.
                if (usernameField.getText().matches(user.getUsername())) {
                    usernameExists = true;
                    userDetails = user;
                    displayQuestion();
                    feedbackOne.setText("");
                    break;
                }
            }

            if (!usernameExists) {
                noUser();
            }
        }
    }
}
