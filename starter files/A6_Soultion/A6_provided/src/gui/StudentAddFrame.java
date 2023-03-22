package gui;

import javax.swing.JFrame;

/**
 * The frame for the window to enter data for a new student, and cause the creation of the student.
 */
public class StudentAddFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame to add a student.
     */
    public StudentAddFrame() {
        setTitle("student Addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StudentAddPanel panel = new StudentAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
