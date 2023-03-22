package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import commands.AssignManagerStudent;
import commands.CommandArguments;
import commands.DropAssociation;
import entities.BasicManager;
import entities.Student;


/**
 * The panel to display the information for a student, and accept operations on the student. The
 * panel gives the student's name and social insurance number. If the student has bed in the ward, it is given
 * and the user has the option to remove the student from the bed. If the student does not have a
 * bed, a create is created for the ward information, so that the student can be added to an empty
 * bed. The managers of the student are given, and the user has the option to add another manager or
 * remove a manager.
 */
public class StudentPanel extends JPanel {
    /**
     * Create the panel to display the student's information and accept operations on the student.
     *
     * @param student the student whose information is to be displayed and on whom operations can be
     *        done
     */
    public StudentPanel(Student student) {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the manager information of the student is changed.
         */
        build(student);
    }

    /**
     * Fill in the panel to display the student's information and accept operations on the student.
     *
     * @param student the student whose information is to be displayed and on whom operations can be
     *        done
     */
    private void build(Student student) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " + student.getName()));
        add(new JLabel("Stduent's SIN: " + student.getSIN()));
        add(new JLabel("NSID: " + student.getNSID()));
        add(new JLabel("Stduent's NSID: " + student.getNSID()));

        BedPanel bedPanel = new BedPanel(student);
        add(bedPanel);
        bedPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        bedPanel.setMaximumSize(bedPanel.getPreferredSize());

        add(new JLabel("  ")); // blank line in the panel for spacing
        add(new JLabel("Managers"));
        for (BasicManager manager : student.getManagers()) {
            JPanel p = listManagerPanel(manager, student);
            add(p);
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        // add an empty panel to force the add manager and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addManagerPanel = addManagerPanel(student);
        add(addManagerPanel);
        addManagerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addManagerPanel.setMaximumSize(addManagerPanel.getPreferredSize());

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
     * A panel to display the name of a manager for the student. Also, a button is provided to remove
     * the association of this student with the manager.
     *
     * @param manager a manager of this student
     * @param student the current student
     * @return the panel to display the name of the manager, with a button to remove the
     *         student-manager association
     */
    private JPanel listManagerPanel(final BasicManager manager, final Student student) {
        JPanel managerPanel = new JPanel();
        managerPanel.add(new JLabel("  "));
        managerPanel.add(new JLabel(manager.getName()));
        JButton removeButton = new JButton("remove");
        managerPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DropAssociation dropAssoc = new DropAssociation();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.mName = manager.getName();
                cmdArguments.mEN = manager.getEmployeeId();
                cmdArguments.sSIN = student.getSIN();
                cmdArguments.sNSID= student.getNSID();
                dropAssoc.setCommnadArguments(cmdArguments);
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(student);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( StudentPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return managerPanel;
    }

    /**
     * A panel to add a manager-student association for this manager. The panel as a prompt to enter
     * the manager's name, and a field to enter the name.
     *
     * @param student the current student
     * @return a panel to associate a new manager with this student
     */
    private JPanel addManagerPanel(final Student student) {
        JPanel addManagerPanel = new JPanel();
        addManagerPanel.add(new JLabel("Add manager with Employee ID"));
        final JTextField textField = new JTextField(10);
        addManagerPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String mEN = textField.getText();
                AssignManagerStudent addAssoc = new AssignManagerStudent();

                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN = student.getSIN();
                cmdArguments.mEN= mEN;
                addAssoc.setCommnadArguments(cmdArguments);
                //addAssoc.assignManager(managerName, student.getSIN());
                addAssoc.execute();
                if (addAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(student);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( StudentPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addManagerPanel;
    }

    public static final long serialVersionUID = 1;
}
