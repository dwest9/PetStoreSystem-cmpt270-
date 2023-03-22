/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 5 Question 4
 */

import java.util.*;

/**
 * A simple pet store management system with a single store.  Animals and staff can be created,
 * and animals assigned to a staff member and/or assigned a kennel in the store
 */
public class PetStoreSystem
{

    /**
     * Initialize an instance of the store management system - relies on user-input
     */
    public PetStoreSystem()
    {
        // get the required pet store info
        String name = IOAccess.getInstance().readString("-------Getting Pet Store information-------\nEnter the name of the store: ");
        int firstKennelNumber = IOAccess.getInstance().readInt("Enter the integer label for the first kennel: ");
        int lastKennelNumber = IOAccess.getInstance().readInt("Enter the integer label for the last kennel: ");

        PetStoreAccess.initialize(name, firstKennelNumber, lastKennelNumber);
    }

    /**
     * Runs the pet store management system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int systemCmd = -1;
        PetStoreSystem sys;

        while (true)
        {
            // keep collection input until entered corectly
            try
            {
                sys = new PetStoreSystem();
                break;
            }
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }

        Command[] commands = new Command[9];   // an array of commands
        String[] menuOptions = {"Quit", "Add a new animal to system", "Add a new staff member to system",
                "Assign a staff member to an animal", "Display the empty kennels in the store",
                "Assign an animal to a kennel" ,"Release an animal" ,"Remove staff-animal association",
                "Show current system state"};
        // set up the commands!
        commands[0] = new SystemState();
        commands[1] = new AddAnimal();
        commands[2] = new AddStaff();
        commands[3] = new AssignStaffToAnimal();
        commands[4] = new ShowEmptyKennels();
        commands[5] = new AssignKennel();
        commands[6] = new ReleaseAnimal();
        commands[7] = new DropAssociation();
        commands[8] = new SystemState();

        IOAccess.getInstance().outputString("-------System running-------");
        while (systemCmd != 0)
        {
            try
            {
                systemCmd = IOAccess.getInstance().readChoice(menuOptions);
                commands[systemCmd].execute();
            }
            catch (RuntimeException e)
            {
                // Catches all exceptions
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }

        IOAccess.getInstance().outputString("\n-------System terminated-------");
    }
}