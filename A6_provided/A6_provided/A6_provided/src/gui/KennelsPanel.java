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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import commands.AssignKennel;
import commands.CommandArguments;
import commands.ReleaseAnimal;

import containers.PetStoreAccess;
import entities.PetStore;
import entities.Animal;

/**
 * The panel to layout out the status of each kennel in the PetStore. If the kennel is empty, a field is
 * supplied for the user to assign an animal to the kennel. If a kennel is occupied, a button is provided
 * to remove the animal from the kennel.
 */
public class KennelsPanel extends JPanel
{
    /**
     * Create the panel to display the status of each kennel, and allow the user to change it
     */
    public KennelsPanel()
    {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the occupancy of a kennel is changed.
         */
        build();
    }

    /**
     * Fill in the panel to display the status of each kennel, and allow the user to change the status.
     */
    public void build()
    {
        setLayout(new GridLayout(0, 3));
        // add headers to label the columns
        add(new JLabel("  Kennel"));
        add(new JLabel("Occupant"));
        add(new JLabel("Insert with ID"));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel("/ remove button"));

        PetStore petStore = PetStoreAccess.getInstance();
        for (int i = petStore.getMinKennelLabel(); i <= petStore.getMaxKennelLabel(); i++)
        {
            int kennel = i;
            add(new JLabel("   " + i));
            if (petStore.isOccupied(i))
            {
                String aID = petStore.getAnimal(i).getAnimalID();
                kennelOccupiedCase(aID);
            } else
            {
                kennelVacantCase(kennel);
            }
            // Add a blank row to improve spacing
            add(new JLabel(""));
            add(new JLabel(""));
            add(new JLabel(""));
        }
    }

    /**
     * Display the ID of the animal in the current kennel, and a button that can be used to
     * remove the animal from the kennel.
     * @param animalID the ID of the animal in the kennel
     */
    private void kennelOccupiedCase(final String animalID)
    {
        add(new JLabel("" + animalID));
        JButton removeButton = new JButton("Remove");
        removeButton.setMaximumSize(removeButton.getPreferredSize());
        add(removeButton);
        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                ReleaseAnimal release = new ReleaseAnimal();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.aPetID = animalID;
                release.setCommnadArguments(cmdArguments);
                release.execute();
                if (release.wasSuccessful())
                {
                    refreshPanels(animalID);
                } else
                {
                    JOptionPane.showMessageDialog(KennelsPanel.this, release.getErrorMessage());
                }
            }
        });
    }

    /**
     * Include a blank label to indicate the kennel is vacant and a field to allow the user to enter
     * the ID of an animal to be assigned the kennel.
     * @param kennel the kennel that can be assigned an animal
     */
    private void kennelVacantCase(final int kennel)
    {
        add(new JLabel(""));
        final JTextField textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String valueAsString = textField.getText();
                if (valueAsString == null || valueAsString.length() == 0)
                {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                    return;
                }

                String animalID = valueAsString;
                AssignKennel assignKennel = new AssignKennel();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.aPetID = animalID;
                cmdArguments.kennelNum = kennel;
                assignKennel.setCommnadArguments(cmdArguments);
                assignKennel.execute();

                if (assignKennel.wasSuccessful())
                {
                    refreshPanels(animalID);
                } else
                {
                    JOptionPane.showMessageDialog(KennelsPanel.this, assignKennel.getErrorMessage());
                }
            }
        });
    }

    /**
     * The panel is refreshed have the correct fields and buttons. This is necessary when the status
     * of a kennel changes. Also, if the Store window was created from an animalPanel, the
     * animal and the KennelPanel for this animal are passed in so that they can be updated when the
     * status of the animal in the kennel changes. This method does this.
     * @param animID
     */
    private void refreshPanels(String animID)
    {
        // recreate the panel as it has changed
        removeAll();
        build();
        revalidate();
        /*
         * If the frame has a KennelPanel recorded for this animal, update it.
         */
        Animal anim = ((PetStoreFrame) getTopLevelAncestor()).animal;
        KennelPanel panel = ((PetStoreFrame) getTopLevelAncestor()).panelOfAnimal;
        if (anim != null)
        {
            panel.rebuild(anim);
        }
    }

    public static final long serialVersionUID = 1;
}
