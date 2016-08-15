/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Screens.LoginView;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

/**
 * RunGUI class uses code from:
 * http://weblogs.java.net/blog/zixle/archive/2005/09/customizing_oce_1.html
 * http://stackoverflow.com/questions/4458982/repaint-swing-button-with-different-gradient
 * To change the button gradient.
 * @author Anton
 */
public class RunGUI extends JFrame {

    public RunGUI() {
        try {

            //Use the same look for all operating systems.
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());

            //This code was taken from http://stackoverflow.com/questions/4458982/repaint-swing-button-with-different-gradient
            //http://weblogs.java.net/blog/zixle/archive/2005/09/customizing_oce_1.html
            //Change look of buttons.
            Object grad = UIManager.get("Button.gradient");
            List gradient;
            if (grad instanceof List) {
                gradient = (List) grad;
                gradient.set(2, new ColorUIResource(238, 238, 238));
                gradient.set(3, new ColorUIResource(208, 208, 208));
                gradient.set(4, new ColorUIResource(188, 188, 188));
            }

            //Setup the frame, add starting panel.
            setTitle("Poker Coach - Please Log In or Register");
            LoginView bgp = new LoginView(this, 0);
            add(bgp);
            setSize(1024, 688);
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            System.out.println("RunGUI - Exception Occurred.");
        }
    }

    public static void main(String[] args) {
        new RunGUI();
    }
}
