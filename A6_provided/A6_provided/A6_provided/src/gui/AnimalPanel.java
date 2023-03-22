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

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import commands.AssignStaffToAnimal;
import commands.CommandArguments;
import commands.DropAssociation;
import entities.BasicStaff;
import entities.Animal;


/**
 * The panel to display the information for an animal, and accept operations on the animal. The
 * panel gives the animal's name and ID. If the animal has a kennel in the store, it is given
 * and the user has the option to remove the animal from the kennel. If the animal does not have a
 * kennel,  the animal can be added to an empty kennel. The staff of the animal are given, and the user
 * has the option to add another staff member or remove them.
 */
public class AnimalPanel extends JPanel
{
    /**
     * Create the panel to display the animal's information and accept operations on the animal.
     * @param anim the animal whose information is to be displayed and on whom operations can be done
     */
    public AnimalPanel(Animal anim)
    {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the staff information of the animal is changed.
         */
        build(anim);
    }

    /**
     * Fill in the panel to display the animal's information and accept operations on the animal.
     * @param animal the animal whose information is to be displayed and on whom operations can be done
     */
    private void build(Animal animal)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " + animal.getName()));
        add(new JLabel("Animal Type: " + animal.getAnimalType()));
        add(new JLabel("Animal ID: " + animal.getAnimalID()));

        KennelPanel kennelPanel = new KennelPanel(animal);
        add(kennelPanel);
        kennelPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        kennelPanel.setMaximumSize(kennelPanel.getPreferredSize());

        add(new JLabel("  ")); // blank line in the panel for spacing
        add(new JLabel("Assigned Staff"));
        for (BasicStaff staff : animal.getAssignedStaff())
        {
            JPanel p = listStaffPanel(staff, animal);
            add(p);
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        // add an empty panel to force the add staff and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addStaffPanel = addStaffPanel(animal);
        add(addStaffPanel);
        addStaffPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addStaffPanel.setMaximumSize(addStaffPanel.getPreferredSize());

        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to display the assigned staff members ID for the animal. A button is provided to remove
     * the association of this staff member with the animal
     * @param staff  an assigned staff member of this animal
     * @param animal the current animal
     * @return the panel to display the name of the staff member, with a button to remove the animal-staff association
     */
    private JPanel listStaffPanel(final BasicStaff staff, final Animal animal)
    {
        JPanel staffPanel = new JPanel();
        staffPanel.add(new JLabel("  "));
        staffPanel.add(new JLabel(staff.getFirstName() + ", " + staff.getLastName()));
        JButton removeButton = new JButton("remove");
        staffPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DropAssociation dropAssoc = new DropAssociation();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sFirstName = staff.getFirstName();
                cmdArguments.sLastName = staff.getLastName();
                cmdArguments.sID = staff.getEmployeeID();
                cmdArguments.aType = animal.getAnimalType();
                cmdArguments.aPetID = animal.getAnimalID();
                cmdArguments.aName = animal.getName();
                dropAssoc.setCommnadArguments(cmdArguments);
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful())
                {
                    // recreate the panel as it has changed
                    removeAll();
                    build(animal);
                    revalidate();
                } else
                {
                    JOptionPane.showMessageDialog(AnimalPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return staffPanel;
    }

    /**
     * A panel to add a staff-animal association for this staff member. The panel as a prompt to enter
     * the staff member's name, and a field to enter the name.
     * @param animal the current animal
     * @return a panel to associate a new staff member with this animal
     */
    private JPanel addStaffPanel(final Animal animal)
    {
        JPanel addStaffPanel = new JPanel();
        addStaffPanel.add(new JLabel("Add staff member with Employee ID"));
        final JTextField textField = new JTextField(10);
        addStaffPanel.add(textField);
        textField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String sID = textField.getText();
                AssignStaffToAnimal addAssoc = new AssignStaffToAnimal();

                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.aType = animal.getAnimalType();
                cmdArguments.aPetID = animal.getAnimalID();
                cmdArguments.sID = sID;
                addAssoc.setCommnadArguments(cmdArguments);
                addAssoc.execute();
                if (addAssoc.wasSuccessful())
                {
                    // recreate the panel as it has changed
                    removeAll();
                    build(animal);
                    revalidate();
                } else
                {
                    JOptionPane.showMessageDialog(AnimalPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addStaffPanel;
    }

    public static final long serialVersionUID = 1;
}
