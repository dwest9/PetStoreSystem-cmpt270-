package gui;

import entities.Residence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to display the main menu.
 */
public class MainMenuPanel extends JPanel  {

    /**
     * The panel to display the main menu.
     */
    public MainMenuPanel() {
        setLayout(new FlowLayout());

        // create the buttons
        JButton studentOpsButton = new JButton(" Operations");
        studentOpsButton.setMaximumSize(studentOpsButton.getPreferredSize());

        JButton managerOpsButton = new JButton("manager Operations");
        managerOpsButton.setMaximumSize(managerOpsButton.getPreferredSize());

        JButton wardInfoButton = new JButton("Ward Information");
        wardInfoButton.setMaximumSize(wardInfoButton.getPreferredSize());

        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());

        // add listners to each button
        studentOpsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                StudentOpsFrame frame = new StudentOpsFrame();
                frame.setVisible(true);
            }
        });

        managerOpsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ManagerOpsFrame frame = new ManagerOpsFrame();
                frame.setVisible(true);
            }
        });

        wardInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ResidenceFrame frame = new ResidenceFrame();
                frame.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // add buttons to panel
        add(studentOpsButton);
        add(managerOpsButton);
        add(wardInfoButton);
        add(exitButton);
    }

    public static final long serialVersionUID = 1;
}
