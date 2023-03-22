package gui;

import commands.AddManager;
import commands.CommandArguments;
import commands.AddManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to get the information for a manager and then
 *  add it to the system.
 */
public class ManagerAddPanel extends JPanel {
    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new student.
     */
    ValueEntryPanel namePanel;

    /**
     * A panel for the entry of the name of a new student.
     */
    ValueEntryPanel mENPanel;

    /**
     * A panel for the entry of the name of a new student.
     */
    ValueEntryPanel mSINPanel;


    /**
     * A panel for the entry of wether or not the manager is a consultant.
     */
    ValueEntryPanel consultantPanel;

    /**
     * Create the panel to obtain data for the creation of a manager, and to cause the manager to be
     * created.
     */
    public ManagerAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the manager data
        JLabel prompt = new JLabel("Enter manager Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the manager's name
        namePanel = new ValueEntryPanel("name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the manager's employee id
        mENPanel = new ValueEntryPanel("Employment ID");
        mENPanel.setMaximumSize(mENPanel.getPreferredSize());
        add(mENPanel);
        mENPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a panel with the field for the entry of the manager's SIN
        mSINPanel = new ValueEntryPanel("Employee SIN");
        mSINPanel.setMaximumSize(mSINPanel.getPreferredSize());
        add(mSINPanel);
        mSINPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the specialty
        consultantPanel = new ValueEntryPanel("Consultant? (Y/N)");
        consultantPanel.setMaximumSize(consultantPanel.getPreferredSize());
        add(consultantPanel);
        consultantPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
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
     * The class listening for the press of the submit button. It accesses the name and
     * specialization entered and uses them to add a new manager to the system.
     */
    private class SubmitListener implements ActionListener {
        /**
         * When the submit button is pressed, access the name and health number entered, and use
         * them to add a new student to the system.
         */
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String mName = namePanel.getValueAsString();
            String mEN = mENPanel.getValueAsString();
            String mSIN = mSINPanel.getValueAsString();
            String cons = consultantPanel.getValueAsString();

            AddManager cmd = new AddManager();
            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.mName = namePanel.getValueAsString();
            cmdArguments.mEN = mENPanel.getValueAsString();
            cmdArguments.mSIN = mSINPanel.getValueAsString();
            cmdArguments.response = consultantPanel.getValueAsString();
            cmd.setCommnadArguments( cmdArguments );
            cmd.execute();

            if (cmd.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea( SplitString.at(cmd.getErrorMessage(), 40));
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
