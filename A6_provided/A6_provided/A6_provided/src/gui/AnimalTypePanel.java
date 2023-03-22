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

import containers.AnimalMapAccess;
import entities.Animal;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.*;

/**
 * The panel for the searching animals by type. It has a prompt label, and a text field for the
 * entry of the animal's type, as well as a search button. When the button key is pressed, a
 * dialog box is created displaying all animals in the system with a matching type.
 */
public class AnimalTypePanel extends JPanel
{
    /**
     * The text field for the entry of an animal type to search for
     */
    JTextField textField;

    /**
     * Create the panel with a prompt label and text field. A dialog box is displayed after the Search button is pressed
     * listing all animals in the system with a type that matches the type entered into the textfield
     */
    public AnimalTypePanel()
    {
        JLabel promptLabel = new JLabel("Show all animals by type:");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        // add a button to display all the animals
        JButton getAnimalsByTypeButton = new JButton("Search");
        getAnimalsByTypeButton.setMaximumSize(getAnimalsByTypeButton.getPreferredSize());
        add(getAnimalsByTypeButton);
        getAnimalsByTypeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        getAnimalsByTypeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                // get al animals and display animals that match the type
                String inputType = textField.getText().trim().toLowerCase();
                Collection<Animal> animals = AnimalMapAccess.getInstance().values();
                String animalsToShow = "";
                for (Animal a : animals)
                {
                    if (a.getAnimalType().toLowerCase().equals(inputType))
                        animalsToShow = animalsToShow + a + "\n";
                }
                if (animalsToShow.equals(""))
                    animalsToShow = "None";
                JOptionPane.showMessageDialog(null, animalsToShow);

                textField.setText("");
                textField.revalidate();
            }
        });

    }

    public static final long serialVersionUID = 1;
}