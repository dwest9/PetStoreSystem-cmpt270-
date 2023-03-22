
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import entities.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




/**
* button to initiate kennel assignment op window
* button to initiate animal op window
* button to initiate staff member op window
* button to terminate the Operations
 */
public class MainMenuPanel extends JPanel {

    public MainMenuPanel(){

        setLayout(new FlowLayout());
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        //button to access animal operations
        JButton animalOpsButton = new JButton("Animal Operations");
        animalOpsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        animalOpsButton.setMaximumSize(animalOpsButton.getPreferredSize());
        add(animalOpsButton);

        animalOpsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalOperationsFrame frame = new AnimalOperationsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        add(Box.createVerticalGlue());


        //button for staff member operations
        JButton staffmemberOpsButton = new JButton("Staff Member Operations");
        staffmemberOpsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        staffmemberOpsButton.setMaximumSize(animalOpsButton.getPreferredSize());
        add(staffmemberOpsButton);

        staffmemberOpsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffMemberOpsFrame frame = new StaffMemberOpsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());


        //button for kennel assignment operations
        JButton kennelOpButton = new JButton("kennel Assignment");
        kennelOpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        kennelOpButton.setMaximumSize(kennelOpButton.getPreferredSize());
        add(kennelOpButton);
        kennelOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PetStoreFrame frame = new PetStoreFrame();
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setLocation(300, 300);
                frame.setVisible(true);

            }
        });


        //button to exist the operations
        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
                System.exit(0);
            }
        });
        add(Box.createVerticalGlue());

        //the added buttons to be displayed
        add(animalOpsButton);
        add(staffmemberOpsButton);
        add(kennelOpButton);
        add(exitButton);
    }
    public static final long serialVersionUID = 1;

}
