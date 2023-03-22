package gui;

import commands.AssignManagerStudent;
import commands.CommandArguments;
import commands.DropAssociation;
import commands.DropAssociation;
import containers.StudentMapAccess;
import entities.Manager;
import entities.Consultant;
import entities.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to display manager information and operations.
 */
public class ManagerPanel extends JPanel {

    /**
     * The panel to display the information for a manager, and accept operations on the manager.
     */
    public ManagerPanel(Manager manager) {
        build(manager);
    }

     /** Fill in the panel to display the managers's information and accept operations on the manager.
            *
            * @param manager the manager whose information is to be displayed and on whom operations can be
     *        done
     */
    private void build(Manager manager) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        if(manager instanceof Consultant) {
            add(new JLabel("Consultant: " + manager.getName()));
        } else {
            add(new JLabel("Manager: " + manager.getName()));
        }
        // add a panel for adding a student to the managers list of students
        JPanel addPanel = addstudentPanel(manager);
        add(addPanel);
        addPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with a field to access a specific student
        JPanel accessPanel = accessstudent(manager);
        add(accessPanel);
        add(Box.createVerticalGlue());

        // add a panel to remove a student from the managers list of students
        JPanel dropPanel = dropstudent(manager);
        add(dropPanel);
        add(Box.createVerticalGlue());

        // add an empty panel to force the add manager and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to access a student of the manager.
     *
     * @param manager a manager with the student
     * @return the panel to access the student of the manager
     */
    private JPanel accessstudent(final Manager manager) {
        JPanel accessPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        accessPanel.add(textField);
        JButton accessButton = new JButton("Access student with SIN");
        accessPanel.add(accessButton);
        accessButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String sSIN = textField.getText();

                        if (sSIN != null) {
                           String sNSID = StudentMapAccess.getInstance().get(sSIN).getNSID();
                            if (manager.hasStudent(sNSID)) {
                                StudentFrame frame = null;
                                try {
                                    frame = new StudentFrame( sSIN );
                                } catch (RuntimeException e) {
                                    textField.setText( "Invalid id: " + textField.getText() );
                                    textField.revalidate();
                                    return;
                                }
                                frame.setLocation( 300, 300 );
                                frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
                                frame.setVisible( true );
                                textField.setText( "" );
                                textField.revalidate();
                            } else {
                                textField.setText( textField.getText() + "is not a student of this manager" );
                                textField.revalidate();
                            }
                        } else {
                            textField.setText( "Empty field: " + textField.getText() );
                            textField.revalidate();
                        }
                    }
                }
        );
        return accessPanel;
    }

    /**
     * A panel to drop a manager-student association.
     *
     * @param manager a manager with the student
     * @return the panel to drop a manager-student association
     */
    private JPanel dropstudent(final Manager manager) {
        JPanel managerPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        managerPanel.add(textField);
        JButton removeButton = new JButton("Remove student");
        managerPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DropAssociation dropAssoc = new DropAssociation();
                String sSIN = textField.getText();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN= sSIN;
                cmdArguments.mEN = manager.getEmployeeId();
                dropAssoc.setCommnadArguments( cmdArguments );
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(manager);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( ManagerPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return managerPanel;
    }

    /**
     * A panel to add a student of the manager's list of student.
     *
     * @param manager a manager with the student student
     * @return the panel to add a student to the manager's list of students
     */
    private JPanel addstudentPanel(final Manager manager) {
        JPanel addmanagerPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        addmanagerPanel.add(textField);
        JButton addButton = new JButton("Add student with SIN");
        addmanagerPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String sSIN = textField.getText();

                AssignManagerStudent addAssoc = new AssignManagerStudent();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN= sSIN;
                cmdArguments.sNSID = StudentMapAccess.getInstance().get( sSIN).getNSID();
                cmdArguments.mEN = manager.getEmployeeId();
                cmdArguments.mName= manager.getName();
                addAssoc.setCommnadArguments( cmdArguments);
                addAssoc.execute();
                if (addAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(manager);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( ManagerPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addmanagerPanel;
    }

    public static final long serialVersionUID = 1;
}
