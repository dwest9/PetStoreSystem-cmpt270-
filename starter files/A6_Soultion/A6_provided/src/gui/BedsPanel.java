package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import commands.AssignBed;
import commands.CommandArguments;
import commands.ReleaseStudent;

import containers.ResidenceAccess;
import entities.Residence;
import entities.Student;

/**
 * The panel to layout out the status of each bed in the residence. If the bed is empty, a field is
 * supplied for the user to admit a student into the bed. If a bed is occupied, a button is provided
 * to remove the student from the bed.
 */
public class BedsPanel extends JPanel {
    /**
     * Create the panel to display the status of each bed, and allow the user to change the status.
     */
    public BedsPanel() {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the occupancy of a bed is changed.
         */
        build();
    }

    /**
     * Fill in the panel to display the status of each bed, and allow the user to change the status.
     */
    public void build() {
        setLayout(new GridLayout(0, 3));
        // add headers to label the columns
        add(new JLabel("   Bed"));
        add(new JLabel("Occupant"));
        add(new JLabel("Insert into field"));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel("/remove button"));

        Residence residence = ResidenceAccess.getInstance();
        for (int i = residence.getMinBedLabel(); i <= residence.getMaxBedLabel(); i++) {
            int bed = i;
            add(new JLabel("   " + i));
            if (residence.isOccupied(i)) {
                String sSin = residence.getStudent(i).getSIN();
                bedOccupiedCase(sSin);
            } else
                bedVacantCase(bed);
            // Add a blank row to improve spacing
            add(new JLabel(""));
            add(new JLabel(""));
            add(new JLabel(""));
        }
    }

    /**
     * Display the social insurance number of the student in the current bed, and a button that can be used to
     * remove the student from the bed.
     *
     * @param sSin the social insurance number of the student in the current bed
     */
    private void bedOccupiedCase(final String sSin) {
        add(new JLabel("" + sSin));
        JButton removeButton = new JButton("remove");
        removeButton.setMaximumSize(removeButton.getPreferredSize());
        add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReleaseStudent release = new ReleaseStudent();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN = sSin;
                release.setCommnadArguments( cmdArguments );
                release.execute();
                if (release.wasSuccessful())
                    refreshPanels(sSin);
                else
                    JOptionPane.showMessageDialog(BedsPanel.this, release.getErrorMessage());
            }
        });
    }

    /**
     * Include a blank label to indicate the bed is vacant and a field to allow the user to enter
     * the social insurance number of a student to be assigned the bed.
     *
     * @param bed the bed that can be assigned a student
     */
    private void bedVacantCase(final int bed) {
        add(new JLabel(""));
        final JTextField textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                if (valueAsString == null || valueAsString.length() == 0) {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                    return;
                }

                String sSin = valueAsString;
                AssignBed assignBedCmd = new AssignBed();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN = sSin;
                cmdArguments.bedNum = bed ;
                assignBedCmd.setCommnadArguments(cmdArguments);
                assignBedCmd.execute();

                if (assignBedCmd.wasSuccessful())
                    refreshPanels(sSin);
                else {
                    JOptionPane.showMessageDialog(BedsPanel.this, assignBedCmd.getErrorMessage());
                }
            }
        });
    }

    /**
     * The panel is refreshed have the correct fields and buttons. This is necessary when the status
     * of a student in a bed changes. Also, if the Residence window was created from a studentPanel, the
     * student and the BedPanel for this student are passed in so that they can be updated when the
     * status of the student in the bed changes. This method does this.
     *
     * @param sSin
     */
    private void refreshPanels(String sSin) {
        // recreate the panel as it has changed
        removeAll();
        build();
        revalidate();
        /*
         * If the frame has a BedPanel is recorded for this student, update it.
         */
        Student p = ((ResidenceFrame) getTopLevelAncestor()).student;
        BedPanel panel = ((ResidenceFrame) getTopLevelAncestor()).panelOfStudent;
        if (p != null && p.getSIN() == sSin)
            panel.rebuild(p);
    }

    public static final long serialVersionUID = 1;
}
