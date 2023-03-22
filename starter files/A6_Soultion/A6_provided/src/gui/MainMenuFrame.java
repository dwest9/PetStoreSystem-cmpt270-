package gui;

import javax.swing.*;

/**
 * The frame to display the main menu of the hospital system.
 */
public class MainMenuFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 200;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * Create the main emnu frame.
     */
    public MainMenuFrame() {
        setTitle("Main menu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuPanel panel = new MainMenuPanel();
        add(panel);
    }

    public  static void main(String[]args){

        MainMenuFrame frame = new MainMenuFrame(); // Modified from original code
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public static final long serialVersionUID = 1;
}
