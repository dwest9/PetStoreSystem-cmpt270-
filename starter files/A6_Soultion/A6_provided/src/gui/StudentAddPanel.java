package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddStudent;
import commands.Command;
import commands.CommandArguments;

/**
 * The panel to obtain data for the creation of a student, and to cause the student to be created.
 */
public class StudentAddPanel extends JPanel {
    /* Declare the components of the panel needed by inner classes. */

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new student.
     */
    ValueEntryPanel namePanel;

    /**
     * A panel for the entry of the social insurance number of a new student.
     */
    ValueEntryPanel sinPanel;

    /**
     * A panel for the entry of the nsid of a new student.
     */
    ValueEntryPanel nsidPanel;

    /**
     * Create the panel to obtain data for the creation of a student, and to cause the student to be
     * created.
     */
    public StudentAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the student data
        JLabel prompt = new JLabel("Enter Student Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the student's name
        namePanel = new ValueEntryPanel("name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the student's sin
        sinPanel = new ValueEntryPanel("Student SIN");
        sinPanel.setMaximumSize(sinPanel.getPreferredSize());
        add(sinPanel);
        sinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the student's nsid
        nsidPanel = new ValueEntryPanel("Student NSID");
        nsidPanel.setMaximumSize(nsidPanel.getPreferredSize());
        add(nsidPanel);
        sinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a button to submit the information and create the student
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name and health
     * number entered, and uses them to add a new Student to the system.
     */
    private class SubmitListener implements ActionListener {
        /**
         * When the submit button is pressed, access the name and social insurance number entered, and use
         * them to add a new Student to the system.
         */
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String name = namePanel.getValueAsString();
            String sSin = sinPanel.getValueAsString();
            String nsid = nsidPanel.getValueAsString();
            AddStudent addStudent = new AddStudent();

            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.sName = name;
            cmdArguments.sSIN = sSin;
            cmdArguments.sNSID = nsid;
            addStudent.setCommnadArguments(cmdArguments);
            addStudent.execute();

            if (addStudent.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea(SplitString.at(addStudent.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
    }

    public static final long serialVersionUID = 1;
}
