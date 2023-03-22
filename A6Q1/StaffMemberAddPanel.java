

// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;


import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.AddStaff;
import commands.CommandArguments;


/**
 * This is panel is to get the information for a staff member and then
 *  add it to the system.
 */
public class StaffMemberAddPanel extends JPanel {
    /**
     * A text area to be used to display an error if one is entered.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the first name of a new staff member.
     */
    ValueEntryPanel fnamePanel;

    /**
     * A panel for the entry of the last name of a new staff member.
     */
    ValueEntryPanel lnamePanel;


    /**
     * A panel for the entry of the social security number of the staff member.
     */
    ValueEntryPanel SINPanel;

    /**
     * A panel for the entry of the employee id of the new staff member
     */
    ValueEntryPanel empIDPanel;


    /**
     * A panel for the entry of if the staff member is a manager.
     */
    ValueEntryPanel ismanagerPanel;

    public StaffMemberAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the staff member information
        JLabel prompt = new JLabel("Enter Information for staff member");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the staff member's first name
        fnamePanel = new ValueEntryPanel("First name");
        fnamePanel.setMaximumSize(fnamePanel.getPreferredSize());
        add(fnamePanel);
        fnamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a panel with the field for the entry of the staff member's last name
        lnamePanel = new ValueEntryPanel("Last name");
        lnamePanel.setMaximumSize(lnamePanel.getPreferredSize());
        add(lnamePanel);
        lnamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // the panel for the entry of the staff member's SIN
        SINPanel = new ValueEntryPanel("Employee SIN");
        SINPanel.setMaximumSize(SINPanel.getPreferredSize());
        add(SINPanel);
        SINPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // the panel for the entry of the staff member's id
        empIDPanel = new ValueEntryPanel("Employee ID");
        empIDPanel.setMaximumSize(empIDPanel.getPreferredSize());
        add(empIDPanel);
        empIDPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // the panel for the entry of if is a Manager or not
        ismanagerPanel = new ValueEntryPanel("Manger? (Y/N)");
        ismanagerPanel.setMaximumSize(ismanagerPanel.getPreferredSize());
        add(ismanagerPanel);
        ismanagerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // button that submits the data created
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }


    /**
     * The class listening for the press of the submit button. It accesses the name and
     * specialization entered and uses them to add a new staff member to the system.
     */
    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                // this removes error from the previous submission
                remove(error);
                error = null;
            }
            String fname = fnamePanel.getValueAsString();
            String lname = lnamePanel.getValueAsString();

            String SIN = SINPanel.getValueAsString();
            String empID = empIDPanel.getValueAsString();
            String manager = ismanagerPanel.getValueAsString();

            AddStaff add_staff = new AddStaff();
            CommandArguments command_argument = new CommandArguments();

            command_argument.sFirstName = fname;
            command_argument.sLastName = lname;
            command_argument.sSIN = SIN;
            command_argument.sID = empID;
            command_argument.response = manager;

            add_staff.setCommnadArguments( command_argument );
            add_staff.execute();

            if (add_staff.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea( SplitString.at(add_staff.getErrorMessage(), 40));
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