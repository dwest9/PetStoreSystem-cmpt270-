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
 * The frame to obtain input to initialize the new pet store, and then it will start the main system.
 */
public class CreatePetStoreFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the entry of the store info
     */
    public CreatePetStoreFrame()
    {
        setTitle("New Store Creation");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        CreatePetStorePanel panel = new CreatePetStorePanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
