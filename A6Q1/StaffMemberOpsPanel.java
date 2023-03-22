
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import containers.StaffMapAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to display staff member operations.
 */
public class StaffMemberOpsPanel extends JPanel {

    /**
     * This Creates the panel for the operations involving staff member.
     */
    public StaffMemberOpsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // a button to add a new staff member
        JButton addButton = new JButton("Add staff member");
        addButton.setMaximumSize(addButton.getPreferredSize());

        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                StaffMemberAddFrame frame = new StaffMemberAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // a panel to access a specific staff member
        StaffMemberAccessPanel accessPanel = new StaffMemberAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());

        // a button to display all the staff member
        JButton listAllButton = new JButton("List all");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, StaffMapAccess.getInstance().values());
            }
        });
        add(Box.createVerticalGlue());

        // button to exit from the window containing this panel
        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }
    public static final long serialVersionUID = 1;
}
