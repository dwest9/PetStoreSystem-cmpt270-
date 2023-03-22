package gui;

import javax.swing.JFrame;


import containers.StudentMapAccess;
import entities.Student;

/**
 * The frame for the window to display the information for a student, and accept operations on the
 * student.
 */
public class StudentFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a student.
     *
     * @param sSin the social insurance number of the student
     * @precond sSIN the SIN of a student
     */
    public StudentFrame(String sSin) {
        Student student = StudentMapAccess.getInstance().get(sSin);
        if (student != null) {
            setTitle(student.getName() + " (" + sSin + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            StudentPanel panel = new StudentPanel(student);
            add(panel);
        } else
            throw new RuntimeException("Invalid SIN number " + sSin);
    }

    public static final long serialVersionUID = 1;
}
