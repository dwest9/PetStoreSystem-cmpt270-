package gui;

import javax.swing.*;

/**
 * The frame to obtain input and add a manager to the system.
 */
public class ManagerAddFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame to add a manager.
     */
    public ManagerAddFrame() {
        setTitle("manager Addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ManagerAddPanel panel = new ManagerAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
