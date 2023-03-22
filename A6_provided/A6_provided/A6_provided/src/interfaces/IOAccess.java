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

public class IOAccess {

    /**
     * The IO object that will manage the IO - console or dialog boxes
     */
    private static InputOutputInterface io;

    /**
     * private and empty constructor
     */
    private IOAccess() {
    }

    /**
     * Returns the instance of the io object. If not initialized, creates io object based on user input to console
     * @return the instance of the io object
     */
    public static InputOutputInterface getInstance() {
        if (io == null) {
            InputOutputInterface con = new DialogIO();
            String[] chooseIO = {"Use Console", "Use Dialog"};
            int choice = con.readChoice(chooseIO);
            if (choice == 0) {
                io = new ConsoleIO();
            } else {
                io = con;
            }
        }
        return io;
    }
}
