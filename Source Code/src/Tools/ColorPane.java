/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/*
 *
 * This is not my class, it has been took from...
 *
 * Java Swing, 2nd Edition
 * By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
 * ISBN: 0-596-00408-7
 * Publisher: O'Reilly
 *
 * ColorPane.java
 * A simple extension of JTextPane that allows the user to easily append
 * colored text to the document.
 */
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.*;

public class ColorPane extends JTextPane {

    public void append(final Color c, final String s) { // better implementation--uses

        // StyleContext
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.Foreground, c);

        int len = getDocument().getLength();
        setCaretPosition(len); // place caret at the end (with no selection)
        setCharacterAttributes(aset, false);
        replaceSelection(s); // there is no selection, so inserts at caret
        setOpaque(false);
    }
}
