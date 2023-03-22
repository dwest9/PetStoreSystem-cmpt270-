package gui;
/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Starter file for Assignment 6
 */

import javax.swing.JFrame;

/**
 * The frame for the window to display the operations that involve animals.
 */
public class AnimalOperationsFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 400;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve animals.
     */
    public AnimalOperationsFrame()
    {
        setTitle("Animal operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        AnimalOperationsPanel panel = new AnimalOperationsPanel();
        add(panel);
    }

    /**
     * A main to run the GUI version of the store system that only involves animal operations
     */
    public static void main(String[] args)
    {
        AnimalOperationsFrame frame = new AnimalOperationsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static final long serialVersionUID = 1;
}
