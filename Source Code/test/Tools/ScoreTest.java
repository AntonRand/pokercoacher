/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class ScoreTest {

    public ScoreTest() {
    }

    @Test
    public void testScore() {

        //Score was difficult to test, mainly tested by usability.
        //Ensure Score was initialised correctly.
        Score s = new Score();

        assertEquals(s.calculateScore(), 0);
        assertFalse(s.showFeedback());
        assertFalse(s.showHint());
    }
}
