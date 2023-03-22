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
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import containers.AnimalMapAccess;
import entities.Animal;

/**
 * The panel for the operations involving animals. There is a button to add a new
 * animal, a field to access a specific animal, a field and button to search display animals by type,
 * a button to list all animals, and an exit button to hide the window with this frame.
 */
public class AnimalOperationsPanel extends JPanel
{
    /**
     * Create the panel for the operations involving animals. There is a button to add a new
     * animal, a field to access a specific animal, a field and button to search display animals by type,
     * a button to list all animals, and an exit button to hide the window with this frame.
     */
    public AnimalOperationsPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to add a new animal
        JButton addButton = new JButton("Add animal");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                AnimalAddFrame frame = new AnimalAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a panel with a field to access a specific animal
        AnimalAccessPanel accessPanel = new AnimalAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());

        // add a panel with a field to show all animals by type
        AnimalTypePanel animalsByTypePanel = new AnimalTypePanel();
        add(animalsByTypePanel);
        add(Box.createVerticalGlue());

        // add a button to display all the animals
        JButton listAllButton = new JButton("List all animals");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Collection<Animal> allAnimals = AnimalMapAccess.getInstance().values();
                String animalsToShow = "";
                for (Animal a : allAnimals)
                {
                    animalsToShow = animalsToShow + a + "\n";
                }
                if (animalsToShow.equals(""))
                    animalsToShow = "None";
                JOptionPane.showMessageDialog(null, animalsToShow);
            }
        });
        add(Box.createVerticalGlue());


        // add a button to exit from the window containing this panel
        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }

    public static final long serialVersionUID = 1;
}
