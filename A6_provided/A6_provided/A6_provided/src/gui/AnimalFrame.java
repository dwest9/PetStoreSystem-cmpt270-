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


import containers.AnimalMapAccess;
import entities.Animal;

/**
 * The frame for the window to display the information for an animal, and accept operations on the
 * animal.
 */
public class AnimalFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for an animal.
     * @param animID the ID of the animal
     * @precond ID of an animal
     */
    public AnimalFrame(String animID)
    {
        Animal animal = AnimalMapAccess.getInstance().get(animID);
        if (animal != null)
        {
            setTitle(animal.getName() + " (" + animID + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            AnimalPanel panel = new AnimalPanel(animal);
            add(panel);
        } else
        {
            throw new RuntimeException("Invalid ID " + animID);
        }
    }

    public static final long serialVersionUID = 1;
}
