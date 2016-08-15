/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 * PlayerComparator Class.
 * Learnt how to create methods to compare objects through:
 * http://www.javadeveloper.co.in/java-example/java-comparator-example.html
 * @author Anton
 */
import Players.Player;
import java.util.Comparator;

public class PlayerComparator implements Comparator {

    @Override
    public int compare(Object playerOne, Object playerTwo) {

        //Compate players by amount called.
        int playerOneCommitted = ((Player) playerOne).getAmountLastCommitted();
        int playerTwoCommitted = ((Player) playerTwo).getAmountLastCommitted();

        if (playerOneCommitted > playerTwoCommitted) {
            return 1;
        } else if (playerOneCommitted < playerTwoCommitted) {
            return -1;
        } else {
            return 0;
        }
    }
}
