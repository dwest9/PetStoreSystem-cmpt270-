package gui;

import javax.swing.JFrame;

import containers.ResidenceAccess;
import entities.Residence;
import entities.Student;

import java.awt.*;

/**
 * The frame for the window to display the ward information, and allow the user to change the
 * occupancy of beds.
 */
public class ResidenceFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 1000;

    /**
     * Create the frame for the information on the ward and ward operations.
     */
    public ResidenceFrame() {
        Residence residence = ResidenceAccess.getInstance();
        setTitle(residence.getName() + " Residence");
        int height;
        height =
                Math.min(DEFAULT_HEIGHT,
                        30 + 50 * (residence.getMaxBedLabel() - residence.getMinBedLabel() + 1));
        setSize(DEFAULT_WIDTH, height);
        ResidencePanel panel = new ResidencePanel();
        add(panel);
    }

    /**
     * When the creation of the residence window is invoked from a studentPanel, the student is passed in
     * and recorded in this field.
     */
    protected Student student;

    /**
     * When the creation of the residence window is invoked from a StudentPanel, the BedPanel displaying
     * the bed information of the student is passed in and recorded in this field so that the panel
     * can be updated if the bed occupancy of the student changes.
     */
    protected BedPanel panelOfStudent;

    /**
     * Create the frame for the information on the residence and residence operations. When the creation of
     * the residence window is invoked from a StudentPanel, the student and BedPanel displaying the bed
     * information of the student are passed in and recorded so that the panel can be updated if the
     * bed occupancy of the student changes.
     */
    public ResidenceFrame(Student student, BedPanel panel) {
        this();
        this.student = student;
        panelOfStudent = panel;
    }

    public static final long serialVersionUID = 1;
}
