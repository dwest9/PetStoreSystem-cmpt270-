import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GarageUi ui = new GarageUi();

        while (true) {
            ui.showMainMenu();
        }
    }

    public void example2() {
        // This is how you would do it on a CLI
        // String userInputCLI = new Scanner(System.in).nextLine();
        String num1String = JOptionPane.showInputDialog("Enter the first number");
        double num1 = Double.parseDouble(num1String);
        String num2String = JOptionPane.showInputDialog("Enter the second number");
        double num2 = Double.parseDouble(num2String);

        String[] options = {"add", "sub", "mul", "div"};
        String option = (String) JOptionPane.showInputDialog(
                null,
                "Select the operation",
                "Op Select",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        double result;
        if (option.equals("add")) {
            result = num1 + num2;
        } else if (option.equals("sub")) {
            result = num1 - num2;
        } else if (option.equals("mul")) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }

        JOptionPane.showMessageDialog(null, "Your result is " + result);
    }

    public void example1() {

            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setTitle("My cool Swing UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            JButton button = new JButton("Click Me!");
            JTextField textField = new JTextField(20);
            JTextArea textArea = new JTextArea("Nothing has happened");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    textArea.setText(text);
                }
            });
//        button.addActionListener(e -> System.out.println("We are in the action listener 4"));

            panel.add(button);
            panel.add(textField);
            panel.add(textArea);
            frame.add(panel);

            frame.setVisible(true);
    }
}