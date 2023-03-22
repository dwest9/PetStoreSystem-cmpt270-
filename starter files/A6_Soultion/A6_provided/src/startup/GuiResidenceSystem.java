package startup;

import gui.CreateResidenceFrame;

import javax.swing.JFrame;
import java.util.Scanner;

/**
 * A simple residence system with only one ward. students and managers can be created, and students
 * assigned to a manager and/or placed in a bed of the ward. Input and output is done by a graphical
 * user interface.
 */
public class GuiResidenceSystem {
    /**
     * Start up the residence application.
     */
    public static void main(String[] args) {


        CreateResidenceFrame frame = new CreateResidenceFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
