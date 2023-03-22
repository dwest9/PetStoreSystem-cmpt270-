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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddAnimal;
import commands.CommandArguments;

/**
 * The panel to obtain data for the creation of a new animal, and to cause the animal to be created.
 */
public class AnimalAddPanel extends JPanel
{
    /* Declare the components of the panel needed by inner classes. */

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new animal.
     */
    ValueEntryPanel namePanel;

    /**
     * A panel for the entry of the animals type
     */
    ValueEntryPanel typePanel;

    /**
     * A panel for the entry of the animals ID
     */
    ValueEntryPanel animIDPanel;

    /**
     * Create the panel to obtain data for the creation of an animal, and to cause the animal to be created.
     */
    public AnimalAddPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the animal info
        JLabel prompt = new JLabel("Enter Animal Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the animals name
        namePanel = new ValueEntryPanel("Name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the animals type
        typePanel = new ValueEntryPanel("Animal type");
        typePanel.setMaximumSize(typePanel.getPreferredSize());
        add(typePanel);
        typePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the animals ID
        animIDPanel = new ValueEntryPanel("Animal ID");
        animIDPanel.setMaximumSize(animIDPanel.getPreferredSize());
        add(animIDPanel);
        typePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a button to submit the information and create the animal
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name and ID number entered
     * and uses them to add a new animal to the system.
     */
    private class SubmitListener implements ActionListener
    {
        /**
         * When the submit button is pressed, access the name and ID entered, and use them to create a new animal
         */
        public void actionPerformed(ActionEvent event)
        {
            if (error != null)
            {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String name = namePanel.getValueAsString();
            String type = typePanel.getValueAsString();
            String animalID = animIDPanel.getValueAsString();
            AddAnimal addAnimal = new AddAnimal();

            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.aName = name;
            cmdArguments.aType = type;
            cmdArguments.aPetID = animalID;
            addAnimal.setCommnadArguments(cmdArguments);
            addAnimal.execute();

            if (addAnimal.wasSuccessful())
            {
                getTopLevelAncestor().setVisible(false);
            } else
            {
                error = new JTextArea(SplitString.at(addAnimal.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
    }

    public static final long serialVersionUID = 1;
}
