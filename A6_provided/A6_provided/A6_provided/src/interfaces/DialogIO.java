package interfaces;
/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Starter file for Assignment 6
 */
import javax.swing.*;

/**
 * A class with I/O methods to read a String, read an integer, output a message, and display a list of choices where
 * the user selects a choice. In this class the input and output options are performed through dialog boxes
 */
public class DialogIO extends AbstractDialogIO
{

    /**
     * This method reads in a string value presenting a prompt to the user
     * @param prompt the prompt displayed to the user
     * @return the String obtained
     */
    public String readString(String prompt)
    {
        String result = "";
        do
        {
            result = JOptionPane.showInputDialog(null, prompt, "User Input", JOptionPane.QUESTION_MESSAGE);
            if (result.length() == 0)
            {
                outputString("Entered string cannot be empty");
            }
        } while (result.length() == 0);
        return result;
    }

    /**
     * Reads an integer value after presenting a prompt to the user
     * @param prompt the prompt shown to the user
     * @return the integer value read
     */
    public int readInt(String prompt)
    {
        String inputString = JOptionPane.showInputDialog(null, prompt, "User Input", JOptionPane.QUESTION_MESSAGE);
        int integerValue;
        if (inputString != null && inputString.length() > 0)
        {
            try
            {
                integerValue = Integer.parseInt(inputString);
            }
            catch (NumberFormatException e)
            {
                outputString(inputString + " is not a valid integer, please try again");
                integerValue = readInt(prompt);
            }
        } else
        {
            outputString("Entered string cannot be empty");
            integerValue = readInt(prompt);
        }
        return integerValue;
    }

    /**
     * Displays a string via dialog box
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString)
    {
        JOptionPane.showMessageDialog(null, outString, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * For testing the DialogIO methods
     * @param args - unused string arguments
     */
    public static void main(String[] args)
    {
        InputOutputInterface testDialogIO = new DialogIO();
        testDialogIO.outputString("*** Testing input/output methods for DialogIO ***\n");

        // Test reading a string
        String sResult = testDialogIO.readString("Please enter a string: ");
        testDialogIO.outputString("The string read was: '" + sResult + "'\n");

        // Test reading an integer
        int i = testDialogIO.readInt("Please enter an integer value: ");
        testDialogIO.outputString("The integer read was: " + i + "\n");

        // Test displaying a choice prompt, and reading a selection
        String[] options = {"Option 1", "Option 2", "Option 3"};
        int intOption = testDialogIO.readChoice(options);
        testDialogIO.outputString("The option you selected was: '" + options[intOption] + "'\n");
    }
}