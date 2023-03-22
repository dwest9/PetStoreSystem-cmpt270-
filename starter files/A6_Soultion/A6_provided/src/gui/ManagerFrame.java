package gui;

import containers.ManagerMapAccess;
import entities.Manager;

import javax.swing.*;

/**
 * The frame to display manager information and operations.
 */
public class ManagerFrame extends JFrame {

    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information and operations for a manager.
     *
     * @param name the name of the manager
     */
    public ManagerFrame(String name) {
        Manager manager = ManagerMapAccess.getInstance().get(name);
        if (manager != null) {
            setTitle(manager.getName());
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            ManagerPanel panel = new ManagerPanel(manager);
            add(panel);
        } else
            throw new RuntimeException("Invalid manager name " + name);
    }

    public static final long serialVersionUID = 1;
}
