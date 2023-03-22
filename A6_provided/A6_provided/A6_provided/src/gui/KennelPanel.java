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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.CommandArguments;
import commands.ReleaseAnimal;

import entities.Animal;

/**
 * A panel to display the kennel status for an animal. If the animal is in a kennel, a button is provided
 * to remove the animal from the kennel. If the animal is not in a kennel, a button is provided to open
 * the PetStore window. From within the PetStore window, any animal can be assigned a kennel.
 */
public class KennelPanel extends JPanel
{
    /**
     * Construct the kennelPanel for the kennel associated with this animal.
     * @param animal the animal whose kennel association is to be displayed
     */
    public KennelPanel(Animal animal)
    {
        rebuild(animal);
    }

    /**
     * Build the kennelPanel for the kennel associated with this animal. To accommodate the panel being
     * changed, remove previous contents before adding the new content and revalidate the panel.
     * @param animal the animal whose kennel association is to be displayed
     */
    protected void rebuild(final Animal animal)
    {
        removeAll();
        final int kennel = animal.getAssignedKennel();
        if (kennel != -1)
        {
            add(new JLabel("Kennel: " + kennel));
            JButton removeButton = new JButton("Remove");
            add(removeButton);
            removeButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {

                    ReleaseAnimal release = new ReleaseAnimal();

                    CommandArguments cmdArguments = new CommandArguments();
                    cmdArguments.aType = animal.getAnimalType();
                    cmdArguments.aPetID = animal.getAnimalID();
                    cmdArguments.aName = animal.getName();
                    release.setCommnadArguments(cmdArguments);
                    release.execute();
                    rebuild(animal);
                }
            });
        } else
        {
            add(new JLabel("Kennel: " + "none"));
            JButton assignButton = new JButton("Assign");
            add(assignButton);
            assignButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    PetStoreFrame frame = new PetStoreFrame(animal, KennelPanel.this);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLocation(300, 300);
                    frame.setVisible(true);
                }
            });
        }
        revalidate();
    }

    public static final long serialVersionUID = 1;
}
