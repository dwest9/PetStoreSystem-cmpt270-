// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import javax.swing.*;

/**
 * The frame to display the main menu of the petstore system.
 */
public class MainMenuFrame extends JFrame {
    /** The width for the frame. */
    public static final int DEFAULT_WIDTH = 250;

    /** The height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * This Creates the main menu frame.
     */
    public MainMenuFrame() {
        setTitle("Main menu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuPanel panel = new MainMenuPanel();
        add(panel);
    }

    public  static void main(String[]args){

        MainMenuFrame menuFrame = new MainMenuFrame();
        menuFrame.setLocation(300, 300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);


    }

    public static final long serialVersionUID = 1;
}
