/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Data.Achievements;
import Data.Statistics;
import Data.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Tools.Utilities;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import org.ho.yaml.Yaml;

/**
 * RegisterView Class.
 * @author Anton
 */
public class RegisterView extends JPanel implements ActionListener {

    private JFrame masterFrame;
    private JTextField username, forename, surname, secretQuestion, secretAnswer;
    private JPasswordField password, confirmPassword;
    private JLabel feedbackLabel;
    private JEditorPane feedback = new JEditorPane();

    /**
     * Constructor for RegisterView.
     * @param masterFrame, the JFrame the panel is on
     */
    public RegisterView(JFrame masterFrame) {

        //Set up the Panel
        super(null);
        this.masterFrame = masterFrame;
        setOpaque(false);

        //Setup all the components
        setupTextFields();
        setupPasswordFields();
        setupButtons();
        setupLabels();
        setupFeedback();
    }

    private void setupTextFields() {

        //Construct Fields
        forename = new JTextField(30);
        username = new JTextField(30);
        surname = new JTextField(30);
        secretQuestion = new JTextField(60);
        secretAnswer = new JTextField(60);

        //Add Fields
        add(forename);
        add(username);
        add(surname);
        add(secretQuestion);
        add(secretAnswer);

        //Position Fields
        forename.setBounds(820, 209, 160, 35);
        surname.setBounds(820, 251, 160, 35);
        username.setBounds(820, 293, 160, 35);
        secretQuestion.setBounds(820, 335, 160, 35);
        secretAnswer.setBounds(820, 377, 160, 35);
    }

    private void setupPasswordFields() {

        //Construct Fields
        password = new JPasswordField(30);
        confirmPassword = new JPasswordField(30);

        //Add Fields
        add(password);
        add(confirmPassword);

        //Position Fields
        password.setBounds(820, 419, 160, 35);
        confirmPassword.setBounds(820, 461, 160, 35);
    }

    private void setupLabels() {

        JLabel registerLabel = Utilities.boldLabel("New User Registration", 36);
        feedbackLabel = Utilities.boldLabel("", 14);
        JLabel usernameLabel = Utilities.plainLabel("Username:", 26);
        JLabel forenameLabel = Utilities.plainLabel("Forename:", 26);
        JLabel surnameLabel = Utilities.plainLabel("Surname:", 26);
        JLabel passwordLabel = Utilities.plainLabel("Password:", 26);
        JLabel confirmPasswordLabel = Utilities.plainLabel("Confirm Password:", 26);
        JLabel secretQuestionLabel = Utilities.plainLabel("Secret Question:", 26);
        JLabel secretAnswerLabel = Utilities.plainLabel("Secret Answer:", 26);

        add(registerLabel);
        add(feedbackLabel);
        add(usernameLabel);
        add(forenameLabel);
        add(surnameLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);
        add(secretQuestionLabel);
        add(secretAnswerLabel);

        registerLabel.setBounds(458, 125, 500, 100);
        feedbackLabel.setBounds(805, 590, 600, 100);

        forenameLabel.setBounds(500, 205, 300, 40);
        surnameLabel.setBounds(500, 247, 300, 40);
        usernameLabel.setBounds(500, 289, 300, 40);
        secretQuestionLabel.setBounds(500, 331, 300, 40);
        secretAnswerLabel.setBounds(500, 373, 300, 40);
        passwordLabel.setBounds(500, 415, 300, 40);
        confirmPasswordLabel.setBounds(500, 457, 300, 40);

        feedbackLabel.setVisible(true);
    }

    private void setupButtons() {

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        registerButton.addActionListener(this);
        backButton.addActionListener(this);

        registerButton.setActionCommand("Register");
        backButton.setActionCommand("Back");

        add(registerButton);
        add(backButton);

        registerButton.setBounds(820, 504, 160, 50);
        backButton.setBounds(5, 605, 160, 50);
    }

    private void setupFeedback() {
        feedback.setContentType("text/html");
        feedback.setEditable(false);
        feedback.setOpaque(false);
        add(feedback);
        feedback.setBounds(505, 550, 480, 70);
    }

    @Override
    public void paint(Graphics g) {


        //Draw Background and rectangle.
        try {
            BufferedImage img = ImageIO.read(new File("Images/Backgrounds/startup.png"));
            g.drawImage(img, 0, 0, this);
        } catch (Exception e) {
            System.out.println("Exception Occured - Painting Background");
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(122, 122, 122, 80));

        //Drawing of the background square.
        RoundRectangle2D rect = new RoundRectangle2D.Double(495, 150, 500, 480, 20, 20);
        g2.fill(rect);
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //Handle button clicks correctly.
        if (ae.getActionCommand().matches("Back")) {
            masterFrame.setTitle("Poker Coach - Startup Screen");
            masterFrame.remove(this);
            masterFrame.add(new LoginView(masterFrame, 0));
            masterFrame.getComponent(0).validate();
        } else if (ae.getActionCommand().matches("Register")) {
            register();
        } else {
            System.exit(0);
        }
    }

    /**
     * Attempts to register user, if failed displays error message.
     * Loads and Saves using YAML API.
     */
    public void register() {

        ArrayList<User> userList = new ArrayList<User>();

        try {
            userList = Yaml.loadType(new File("users.yml"), ArrayList.class);
        } catch (Exception e) {
            System.out.println("Error, could not find data file.");
        }

        //Check for illegal conditions.
        if (duplicateCheck(userList, username.getText())) {
            duplicateUser();
        } else if (emptyFieldCheck()) {
            emptyField();
        } else if (usernameFieldCheck()) {
            usernameFormat();
        } else if (passwordFieldCheck()) {
            passwordFormat();
        } else if (secretQuestionFieldCheck()) {
            questionFormat();
        } else if (secretAnswerFieldCheck()) {
            answerFormat();
        } else if (confirmedPasswordCheck()) {
            incorrectPassword();
        } else {

            //Otherwise create the user.
            User registerUser = new User();
            registerUser.setForename(forename.getText());
            registerUser.setSurname(surname.getText());
            registerUser.setUsername(username.getText());
            registerUser.setPassword(Utilities.encrypt(password.getText()));
            registerUser.setSecretQuestion(secretQuestion.getText());
            registerUser.setSecretAnswer(Utilities.encrypt(secretAnswer.getText()));

            Achievements achievements = new Achievements();
            achievements.setAll(false);
            Statistics statistics = new Statistics();

            registerUser.setAchievements(achievements);
            registerUser.setStatistics(statistics);

            userList.add(registerUser);

            try {

                //Save user.
                Yaml.dump(userList, new File("users.yml"));

                //Load Login Screen.
                masterFrame.remove(this);
                masterFrame.add(new LoginView(masterFrame, 1));
                masterFrame.getComponent(0).validate();
            } catch (FileNotFoundException ex) {
                System.out.println("Could not register");
            }
        }
    }

    /**
     * @param userList, the list of registered users.
     * @param username, the username to register.
     * @return, true if there is already a user with that username.
     */
    public boolean duplicateCheck(ArrayList<User> userList, String username) {

        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return, true if a field hasn't been filled in.
     */
    public boolean emptyFieldCheck() {

        if (forename.getText().length() == 0 || surname.getText().length() == 0
                || username.getText().length() == 0 || secretQuestion.getText().length() == 0
                || secretAnswer.getText().length() == 0 || password.getText().length() == 0
                || confirmPassword.getText().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return, true if length is invalid.
     */
    public boolean usernameFieldCheck() {

        int fieldLength = username.getText().length();

        if (fieldLength < 5 || fieldLength > 15) {
            return true;
        }
        return false;
    }

    /**
     * @return, true if length is invalid.
     */
    public boolean passwordFieldCheck() {

        int fieldLength = password.getText().length();

        if (fieldLength < 5 || fieldLength > 15) {
            return true;
        }
        return false;
    }

    /**
     * @return, true if length is invalid.
     */
    public boolean secretQuestionFieldCheck() {

        int fieldLength = secretQuestion.getText().length();

        if (fieldLength < 5 || fieldLength > 40) {
            return true;
        }
        return false;
    }

    /**
     * @return, true if length is invalid.
     */
    public boolean secretAnswerFieldCheck() {

        int fieldLength = secretAnswer.getText().length();

        if (fieldLength < 5 || fieldLength > 30) {
            return true;
        }
        return false;
    }

    /**
     * @return, true if passwords do not match.
     */
    public boolean confirmedPasswordCheck() {
        if (!password.getText().matches(confirmPassword.getText())) {
            return true;
        }
        return false;
    }

    /**
     * The following methods are used to display and format the feedback.
     */
    public void registered() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Successfully Registered</b></p>"
                + "</html>");

    }

    public void duplicateUser() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Username already taken</p>"
                + "</html>");
    }

    public void passwordFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Passwords must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    public void incorrectPassword() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Passwords do not match</p>"
                + "</html>");
    }

    public void usernameFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Usernames must be between 5 and 15 characters long</p>"
                + "</html>");
    }

    public void emptyField() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: You must fill in all fields</p>"
                + "</html>");
    }

    public void questionFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Questions should be between 5 and 40 characters long</p>"
                + "</html>");

    }

    public void answerFormat() {
        feedback.setText("<html>"
                + "<p style=\"font-family:arial;color:white;font-size:13px;text-align:center;\"><b>Could not register</b>: Answers should be between 5 and 30 characters long</p>"
                + "</html>");
    }
}
