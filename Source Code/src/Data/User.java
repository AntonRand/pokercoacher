/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 * Represents a registered user.
 * @author axr712
 */
public class User {

    private String forename;
    private String surname;
    private String username;
    private String password;
    private String secretQuestion;
    private String secretAnswer;
    private Achievements achievements;
    private Statistics statistics;

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    @Override
    public String toString() {
        return "Name: " + getForename() + getSurname();
    }
}
