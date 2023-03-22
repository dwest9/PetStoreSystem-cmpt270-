
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import javax.swing.*;
import java.awt.*;

/**
 * The frame to display staff member operations.
 */
public class StaffMemberOpsFrame extends JFrame {
    /** The width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    public StaffMemberOpsFrame() {
        setTitle("staff member Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffMemberOpsPanel panel = new StaffMemberOpsPanel();
        add(panel);
    }

    /**
     * A main to run the GUI version of the store system that only involves staff member operations
     */
    public static void main(String[] args)
    {
        StaffMemberOpsFrame frame = new StaffMemberOpsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }


    public static final long serialVersionUID = 1;
}
