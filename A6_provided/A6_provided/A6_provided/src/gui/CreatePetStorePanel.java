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
import commands.CommandArguments;
import commands.CreatePetStore;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * The panel to obtain input to initialize the store, and then it will start the main system.
 */
public class CreatePetStorePanel extends JPanel {
    /**
     * The panel for entering the store name
     */
    ValueEntryPanel namePanel;

    /**
     * The panel for entering the first kennel label
     */
    ValueEntryPanel firstLabelPanel;

    /**
     * The panel for entering the last kennel label
     */
    ValueEntryPanel lastLabelPanel;

    /**
     * A panel for an error message, if an error should occur.
     */
    JTextArea error = null;

    /**
     * Create a panel with a field for the store name, a field for the label of the
     * first kennel, a field for the label of the last kennel, and a submit button to submit the data for
     * the creation of a new store
     */
    public CreatePetStorePanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JLabel prompt = new JLabel("Enter the pet store information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        namePanel = new ValueEntryPanel("Store Name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        firstLabelPanel = new ValueEntryPanel("First kennel label");
        firstLabelPanel.setMaximumSize(firstLabelPanel.getPreferredSize());
        add(firstLabelPanel);
        firstLabelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        lastLabelPanel = new ValueEntryPanel("Last kennel label");
        lastLabelPanel.setMaximumSize(lastLabelPanel.getPreferredSize());
        add(lastLabelPanel);
        lastLabelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The listener for the press of the submit button. When it happens, obtain the data values from
     * the fields, and create the store. Create and make visible the window with the main
     * options for the user.
     */
    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                remove(error); // remove error from previous submission
                error = null;
            }
            String name = namePanel.getValueAsString();
            int firstKennelNum = -1;
            int lastKennelNum = -1;
            try {
                firstKennelNum = firstLabelPanel.getValueAsInt();
                lastKennelNum = lastLabelPanel.getValueAsInt();
            } catch (NumberFormatException e) {
                revalidate(); // getValueAsInt modified the text field, so redraw
                return;
            }
            CreatePetStore createPetStore = new CreatePetStore();
            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.stName = name;
            cmdArguments.minKennelLabel = firstKennelNum;
            cmdArguments.maxKennelLabel = lastKennelNum;
            createPetStore.setCommnadArguments(cmdArguments);
            createPetStore.execute();
            if (createPetStore.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
                getTopLevelAncestor().setVisible(false);
                AnimalOperationsFrame frame = new AnimalOperationsFrame(); // Modified from original code
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            } else {
                /*
                 * Divide the error message into lines short enough to fit in the window, and store
                 * the message in the error text area.
                 */
                error = new JTextArea(SplitString.at(createPetStore.getErrorMessage(), 50));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate();
            }
        }
    }

    public static final long serialVersionUID = 1;
}
