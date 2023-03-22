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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class with the I/O methods to read a String, an integer, output a message, and
 * display a list of choices from which the user must select the index of a choice. The input and
 * output is done via the console.
 */
public class ConsoleIO implements InputOutputInterface
{
    /**
     * The Scanner used to scanner the characters entered at the console.
     */
    final private Scanner consoleIn = new Scanner(System.in);

    /**
     * Display a prompt and read the string entered.
     * @param prompt the string to be displayed as a prompt
     * @return the next line of input from the console
     */
    public String readString(String prompt)
    {
        System.out.print(prompt);
        return consoleIn.nextLine();
    }

    /**
     * Display a prompt and read the int entered.
     * @param prompt the string to be displayed as a prompt
     * @return the int obtained from the console
     */
    public int readInt(String prompt)
    {
        int result = 0; // must be initialized
        boolean validInput;
        do
        {
            validInput = true;
            try
            {
                System.out.print(prompt);
                result = consoleIn.nextInt();
            }
            catch (InputMismatchException e)
            {
                validInput = false;
                String faultyInput = consoleIn.nextLine();
                System.out.print("Invalid Input: '" + faultyInput + "' Please try again\n");
            }
        } while (!validInput);
        consoleIn.nextLine(); // discard the remainder of the line
        return result;
    }

    /**
     * Displays a list of options and reads an integer which is the index of one of the options, starting at index zero.
     * @param options an array with the options that are presented to the user
     * @return the int specifying the array index for the option selected by the user
     */
    public int readChoice(String[] options)
    {
        String prompt = "\nPlease select an option: ";
        for (int i = 0; i < options.length; i++)
        {
            prompt = prompt + "\n[" + i + "]: " + options[i];
        }
        prompt = prompt + "\nEnter the number of your selection: ";
        int result = readInt(prompt);
        if (result < 0 || result >= options.length)
        {
            outputString("You entered " + result + " that is not between 0 and "
                    + (options.length - 1) + "\nPlease try again.  ");
            return readChoice(options);
        } else
        {
            return result;
        }
    }

    /**
     * Output the String parameter to the screen.
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString)
    {
        System.out.print(outString);
    }

    /**
     * Main method used for testing the ConsoleIO class
     * @param args unused
     */
    public static void main(String[] args)
    {
        InputOutputInterface testConsoleIO = new ConsoleIO();
        testConsoleIO.outputString("*** Testing input/output methods for ConsoleIO ***\n");

        // Test reading a string
        String sResult = testConsoleIO.readString("Please enter a string: ");
        testConsoleIO.outputString("The string read was: '" + sResult + "'\n");

        // Test reading an integer
        int i = testConsoleIO.readInt("Please enter an integer value: ");
        testConsoleIO.outputString("The integer read was: " + i + "\n");

        // Test displaying a choice prompt, and reading a selection
        String[] options = {"Option 1", "Option 2", "Option 3"};
        int intOption = testConsoleIO.readChoice(options);
        testConsoleIO.outputString("The option you selected was: '" + options[intOption] + "'\n");
    }
}
