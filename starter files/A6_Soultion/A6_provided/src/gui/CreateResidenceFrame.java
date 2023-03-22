package gui;

import javax.swing.JFrame;

/**
 * The frame to obtain input to initialize the ward, and then it will start the main system.
 */
public class CreateResidenceFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the entry of the ward information.
     */
    public CreateResidenceFrame() {
        setTitle("Residence Creation");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        CreateResidencePanel panel = new CreateResidencePanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
