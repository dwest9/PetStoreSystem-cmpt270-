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

import containers.PetStoreAccess;
import entities.PetStore;
import entities.Animal;

/**
 * The frame for the window to display the PetStore information, and allow the user to change the
 * occupancy of kennels
 */
public class PetStoreFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 1000;

    /**
     * Create the frame for the information on the store and the store operations.
     */
    public PetStoreFrame()
    {
        PetStore store = PetStoreAccess.getInstance();
        setTitle(store.getName() + " - Store");
        int height;
        height =
                Math.min(DEFAULT_HEIGHT,
                        30 + 50 * (store.getMaxKennelLabel() - store.getMinKennelLabel() + 1));
        setSize(DEFAULT_WIDTH, height);
        PetStorePanel panel = new PetStorePanel();
        add(panel);
    }

    /**
     * When the creation of the store window is invoked from an animalPanel, the snimal is passed in
     * and recorded in this field.
     */
    protected Animal animal;

    /**
     * When the creation of the store window is invoked from a animalPanel, the kennelPanel displaying
     * the kennel information of the animal is passed in and recorded in this field so that the panel
     * can be updated if the kennel occupancy of the animal changes.
     */
    protected KennelPanel panelOfAnimal;

    /**
     * Create the frame for the information on the store and store operations. When the creation of
     * the store window is invoked from a animalPanel, the animal and kennelPanel displaying the kennel
     * information of the animal are passed in and recorded so that the panel can be updated if the
     * kennel occupancy of the animal changes.
     */
    public PetStoreFrame(Animal animal, KennelPanel panel)
    {
        this();
        this.animal = animal;
        panelOfAnimal = panel;
    }

    public static final long serialVersionUID = 1;
}
