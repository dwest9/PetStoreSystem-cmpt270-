package gui;

import javax.swing.*;

/**
 * The frame to display manager operations.
 */
public class ManagerOpsFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    public ManagerOpsFrame() {
        setTitle("manager Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ManagerOpsPanel panel = new ManagerOpsPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
