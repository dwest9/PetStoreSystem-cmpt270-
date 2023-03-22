package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.CommandArguments;
import commands.ReleaseStudent;

import commands.ReleaseStudent;
import entities.Student;
import entities.Student;

/**
 * A panel to display the bed status for a student. If the student is in a bed, a button is provided
 * to remove the student from the bed. If the student is not in a bed, a button is provided to open
 * the ward window. From within the ward window, any student can be assigned a bed.
 */
public class BedPanel extends JPanel {
    /**
     * Construct the bedPanel for the bed associated with this student.
     *
     * @param student the student whose bed association is to be displayed
     */
    public BedPanel(Student student) {
        rebuild(student);
    }

    /**
     * Build the bedPanel for the bed associated with this student. To accommodate the panel being
     * changed, remove previous contents before adding the new content and revalidate the panel.
     *
     * @param student the student whose bed association is to be displayed
     */
    protected void rebuild(final Student student) {
        removeAll();
        final int bed = student.getBedLabel();
        if (bed != -1) {
            add(new JLabel("Bed: " + bed));
            JButton removeButton = new JButton("remove");
            add(removeButton);
            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    ReleaseStudent release = new ReleaseStudent();

                    CommandArguments cmdArguments = new CommandArguments();
                    cmdArguments.sSIN = student.getSIN();
                    release.setCommnadArguments(cmdArguments);
                    release.execute();

                }
            });
        } else {
            add(new JLabel("Bed: " + "none"));
            JButton assignButton = new JButton("assign");
            add(assignButton);
            assignButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    ResidenceFrame frame = new ResidenceFrame(student, BedPanel.this);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLocation(300, 300);
                    frame.setVisible(true);
                }
            });
        }
        revalidate();
    }

    public static final long serialVersionUID = 1;
}
