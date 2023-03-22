package gui;

import containers.ManagerMapAccess;
import containers.ManagerMapAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to display manager operations.
 */
public class ManagerOpsPanel extends JPanel {

    /**
     * Create the panel for the operations involving managers.
     */
    public ManagerOpsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to add a new manager
        JButton addButton = new JButton("Add manager");
        addButton.setMaximumSize(addButton.getPreferredSize());

        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ManagerAddFrame frame = new ManagerAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a panel with a field to access a specific manager
        ManagerAccessPanel accessPanel = new ManagerAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());

        // add a button to display all the managers
        JButton listAllButton = new JButton("List all");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, ManagerMapAccess.getInstance().values());
            }
        });
        add(Box.createVerticalGlue());

        // add a button to exit from the window containing this panel
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
