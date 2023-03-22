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
 * The frame for the window to enter data for a new animal, and cause the creation of the animal.
 */
public class AnimalAddFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 220;

    /**
     * Create the frame to add a new animal
     */
    public AnimalAddFrame()
    {
        setTitle("Animal addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        AnimalAddPanel panel = new AnimalAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
