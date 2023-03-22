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
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The panel to display the store information and allow the user to change the occupancy of kennels.
 */
public class PetStorePanel extends JPanel
{
    /**
     * Create the panel to display the store information and allow the user to change the occupancy
     * of kennels.
     */
    public PetStorePanel()
    {
        setLayout(new BorderLayout());

        KennelsPanel kennelsPanel = new KennelsPanel();
        add(kennelsPanel, BorderLayout.CENTER);

        JPanel pageEndPanel = new JPanel();
        JButton exitButton = new JButton("Exit");
        pageEndPanel.add(exitButton);
        add(pageEndPanel, BorderLayout.PAGE_END);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                getTopLevelAncestor().setVisible(false);
            }
        });
    }

    public static final long serialVersionUID = 1;
}
