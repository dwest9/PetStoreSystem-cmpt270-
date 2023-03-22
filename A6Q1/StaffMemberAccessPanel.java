
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import containers.StaffMapAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to get the information for a staff member and then
 *  access that staff member if it exists in the system.
 */
public class StaffMemberAccessPanel extends JPanel {
    /**
     * The text field for the entry of the staff member's names.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If the staff member exists
     * in the system a new window is created with the staff member's data and operations.
     */
    public StaffMemberAccessPanel() {
        JLabel promptLabel = new JLabel("Access staff member with employee id");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String employeeid = textField.getText();

                if (employeeid != null && employeeid.length() > 0) {
                    // if the manager is not in the system
                    if (!StaffMapAccess.getInstance().containsKey(employeeid)) {
                        textField.setText("staff member is not in the system: " + textField.getText());
                        textField.revalidate();
                        return;
                    }

                    StaffMemberFrame stf = null;
                    try {
                        stf = new StaffMemberFrame(employeeid);
                        // this catches the error if the staff member entered is not in the system
                    } catch (RuntimeException e) {
                        textField.setText("staff member is not in the system: " + textField.getText());
                        textField.revalidate();
                        return;
                    }

                    stf.setLocation(300, 300);
                    stf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    stf.setVisible(true);
                    textField.setText("");
                    textField.revalidate();
                } else {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                }
            }
        });
    }

    public static final long serialVersionUID = 1;
}
