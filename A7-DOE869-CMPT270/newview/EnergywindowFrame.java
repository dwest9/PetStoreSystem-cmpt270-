// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



package newview;

import javax.swing.JFrame;

import model.GameInfoProvider;

public class EnergywindowFrame extends JFrame {
    /**
     * The width for the frame.
     */
    public static final int DEFAULT_WIDTH = 300;

    /**
     * The height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * This Creates the frame to add a newview
     */
    public EnergywindowFrame()
    {
        setTitle("Energy state");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        EnergywindowPanel panel = new EnergywindowPanel();
        add(panel);
    }
}