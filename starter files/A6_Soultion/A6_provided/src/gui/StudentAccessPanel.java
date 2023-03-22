package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The panel for the access of a specific student. It has a prompt label, and a text field for the
 * entry of the student's social insurance number. When the Enter key is pressed, the social insurance number entered is
 * used to create a new window with the student's data and operations on the student.
 */
public class StudentAccessPanel extends JPanel {
    /**
     * The text field for the entry of the student's social insurance number.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If data is entered into the text field
     * that is not a valid int value, a brief error message is entered at the front of the text
     * field. Otherwise, a new window is created with the student's data and operations on the
     * student.
     */
    public StudentAccessPanel() {
        JLabel promptLabel = new JLabel("Access student with SIN");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                    String sSin = textField.getText();
                    StudentFrame frame = null;
                    try {
                        frame = new StudentFrame(sSin);
                    } catch (RuntimeException e) {
                        textField.setText("Invalid id: " + textField.getText());
                        textField.revalidate();
                        return;
                    }
                    frame.setLocation(300, 300);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setVisible(true);
                    textField.setText("");
                    textField.revalidate();

            }
        });
    }

    public static final long serialVersionUID = 1;
}
