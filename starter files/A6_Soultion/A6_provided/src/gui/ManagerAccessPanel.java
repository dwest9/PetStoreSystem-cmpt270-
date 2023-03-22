package gui;

import containers.ManagerMapAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to get the information for a manager and then
 *  access that manager if it exsists in the system.
 */
public class ManagerAccessPanel extends JPanel {
    /**
     * The text field for the entry of the manager's name.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If the manager exsists
     * in the system a new window is created with the managers's data and operations.
     */
    public ManagerAccessPanel() {
        JLabel promptLabel = new JLabel("Access manager with EN");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String mEN = textField.getText();

                if (mEN != null && mEN.length() > 0) {
                    // if the manager is not in the system
                    if (!ManagerMapAccess.getInstance().containsKey(mEN)) {
                        textField.setText("manager is not in the system: " + textField.getText());
                        textField.revalidate();
                        return;
                    }

                    ManagerFrame frame = null;
                    try {
                        frame = new ManagerFrame(mEN);
                    } catch (RuntimeException e) {
                        textField.setText("manager is not in the system: " + textField.getText());
                        textField.revalidate();
                        return;
                    }

                    frame.setLocation(300, 300);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setVisible(true);
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
