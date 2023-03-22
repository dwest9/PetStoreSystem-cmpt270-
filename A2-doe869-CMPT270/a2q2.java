/*
 CMPT 270 Course material
 Copyright (c) 2022
 All rights reserved.
 This document contains resources for homework assigned to students of
 CMPT 270 and shall not be distributed without permission.  Posting this
 file to a public or private website, or providing this file to a person
 not registered in CMPT 270, constitutes Academic Misconduct, according
 to the University of Saskatchewan Policy on Academic Misconduct.
 Synopsis: Starter file for Assignment 2 Q1
*/

//Name: David Emmanuel
//NSID: doe869
//Student: 11298443
//Course: cmpt270
//Lab section: Section T09

import java.util.Scanner;
/**
 * A2Q1: An incomplete VA Language interpreter
 */
public class a2q2 {
    /**
     * Implements the Va language interpreter in Basic Java.
     * param HEAPSIZE: the number of doubles in the heap
     * other commands added to this program LESS, LESSEQ, GREAT, GREATEQ, EQUAL
     * and other modification on STATE command for a complete Va language interpreter
     */
    public static void interpreter(int HEAPSIZE) {
        // the machine's memory model
        double register = 0.0;
//        registration boolean
        boolean reg_bR = false;
        double[] heap = new double[HEAPSIZE];

        // variables for the command values
        String command;
        double value;
        int index;
        Scanner in = new Scanner(System.in);

        // the main interpreter loop
        do {
            // prompt for an input
            System.out.print(">> ");
            // read a command;
            command = in.next();
            if (command.equals("SET")) {
                // set register value
                register = in.nextDouble();
            } else if (command.equals("TELL")) {
                // print current register value and boolean

                System.out.println(register);
                System.out.println(reg_bR);
            } else if (command.equals("STORE")) {
                // move register value to heap
                index = in.nextInt();
                heap[index] = register;
            } else if (command.equals("ADD")) {
                // add passed in value to register value
                value = in.nextDouble();
                register += value;
            } else if (command.equals("SUB")) {
                // subtract passed in value from register value
                value = in.nextDouble();
                register -= value;
            } else if (command.equals("MUL")) {
                value = in.nextDouble();
                register *= value;
            } else if (command.equals("DIV")) {
                value = in.nextDouble();
                register /= value;

                // this ADDI command gets value from the heap and which is then added to the register

            } else if (command.equals("ADDI")) {
                index = in.nextInt();
                register += heap[index];

                //  this SUBI command gets a value from the heap and subtract it from the register

            } else if (command.equals("SUBI")) {
                index = in.nextInt();
                register -= heap[index];

                //   this MULI command gets a value from the heap and then multiplys it

            } else if (command.equals("MULI")) {
                index = in.nextInt();
                register *= heap[index];

                //         this DIVI command gets a value from the heap and divides it in the register

            } else if (command.equals("DIVI")) {
                index = in.nextInt();
                register /= heap[index];
            } else if (command.equals("LOAD")) {
                index = in.nextInt();
                register = heap[index];

//                for the command less than < is executed from the register
            } else if (command.equals("LESS")) {
                value = in.nextDouble();
                reg_bR = register < value;

//                for the command less than or equals to <= is executed from the register
            } else if (command.equals("LESSEQ")) {
                value = in.nextDouble();
                reg_bR = register <= value;

//                for the command equals to ==  is executed from the register
            } else if (command.equals("EQUAL")) {
                value = in.nextDouble();
                reg_bR = register == value;

//                for te command greater than or equals to >= is executed from the register
            } else if (command.equals("GREATEQ")) {
                value = in.nextDouble();
                reg_bR = register >= value;

//                for the command greater than > is executed from the register
            } else if (command.equals("GREAT")) {
                value = in.nextDouble();
                reg_bR = register > value;
            }

            else if (command.equals("HALT")) {
                // Do nothing except avoid the catch-all case below
                /**
                 * this command STATE, takes no arguments,
                 * and displays the content of the virtual machine: the register, and all the values on the heap
                 * and also prints the boolean register either true or false
                 */

            } else if (command.equals("STATE")) {
                System.out.println("State:");
                System.out.println("  register = " + register);
                System.out.println("  bRegister = " + reg_bR);
                for (int i = 0; i < HEAPSIZE; i++) {
                    System.out.println("  heap[" + i + "] = " + heap[i]);
                }
            }

            else {
                String given = in.nextLine();
                System.out.println("Bad command: '" + command + given + "'");
                break;
            }
        } while (!command.equals("HALT"));
    }

    public static void main(String[] args) {
        // run the interpreter with a heap size of 5
        interpreter(5);
    }
}

