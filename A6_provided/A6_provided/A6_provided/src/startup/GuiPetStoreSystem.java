package startup;
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

import gui.CreatePetStoreFrame;

import javax.swing.JFrame;

/**
 * A simple pet store system with a single store. Animals and staff can be created, and animals
 * assigned to a staff member or manager and/or assigned a kennel of the store. Input and output is done by a graphical
 * user interface.
 */
public class GuiPetStoreSystem
{
    /**
     * Start up the store application.
     */
    public static void main(String[] args)
    {


        CreatePetStoreFrame frame = new CreatePetStoreFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
