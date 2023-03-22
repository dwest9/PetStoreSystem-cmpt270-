package interfaces;/*
  CMPT 270 Course Material
  Copyright (c) 2021
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.


 */

import javax.swing.*;

/**
 * A class with the input and output methods to read a String, read an int, output a message, and
 * display a list of choices from which the user must select the index of a choice. The input and
 * output is done via dialog boxes.
 */
public class DialogIO extends AbstractDialogIO {

    /*
     * Read in a String using the specified prompt.
     *
     * @param prompt the String to be used to prompt the user
     *
     * @return the String obtained
     */
    public String readString(String prompt) {
        String result = "";

        return result;
    }

    /*
     * Read in an int value using the specified prompt.
     *
     * @param prompt the String to be used to prompt the user
     *
     * @return the int value obtained
     */
    public int readInt(String prompt) {
        String valueAsString = JOptionPane.showInputDialog(null, prompt);

            outputString("You must enter a value into the input field. \n");
            int value = readInt(prompt);

        return value;
    }

    /**
     * Display the String parameter in a dialog box.
     *
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString) {
        JOptionPane.showMessageDialog(null, outString);
    }

    /**
     * Simple tests of the methods.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        InputOutputInterface ioHandler = new DialogIO();
        ioHandler.outputString("This will test the input and output methods.\n");
        String result = ioHandler.readString("Enter a string: ");
        ioHandler.outputString("The string read was " + result + "\n");
        int i = ioHandler.readInt("Enter an integer value: ");
        ioHandler.outputString("The integer read was " + i + "\n");
        String[] options = {"First", "Second", "Third"};
        int intOption = ioHandler.readChoice(options);
        ioHandler.outputString("The option selected was " + options[intOption] + "\n");
    }
}