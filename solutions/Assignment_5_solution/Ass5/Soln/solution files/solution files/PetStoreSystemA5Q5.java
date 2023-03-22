/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 5 Question 5
 */

import java.util.Collection;
import java.util.InputMismatchException;

/**
 * A simple pet store management system with a single store.  Animals and staff can be created,
 * and animals assigned to a staff member and/or assigned a kennel in the store
 */
public class PetStoreSystemA5Q5
{
    /**
     * The I/O object used for user interaction
     */
    private InputOutputInterface systemIO = IOAccess.getInstance();

    /**
     * Initialize an instance of the store management system - relies on user-input
     */
    public PetStoreSystemA5Q5()
    {
        // get the required pet store info
        String name = systemIO.readString("-------Getting Pet Store information-------\nEnter the name of the store: ");
        int firstKennelNumber = systemIO.readInt("Enter the integer label for the first kennel: ");
        int lastKennelNumber = systemIO.readInt("Enter the integer label for the last kennel: ");

        PetStoreAccess.initialize(name, firstKennelNumber, lastKennelNumber);
    }

    /**
     * Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void addAnimal()
    {
        Command cmd = new AddAnimal();
        cmd.execute();
    }

    /**
     * Read info for a new staff member, and add them to dictionary of all staff
     */
    public void addStaff()
    {
        Command cmd = new AddStaff();
        cmd.execute();
    }

    /**
     * Assign a staff member to an animal, and the animal to the staff member
     */
    public void assignStaffToAnimal()
    {
        Command cmd = new AssignStaffToAnimal();
        cmd.execute();
    }

    /**
     * Assign an animal to a kennel
     */
    public void assignKennel()
    {
        Command cmd = new AssignKennel();
        cmd.execute();
    }

    /**
     * Remove the animal-staff association
     */
    public void dropAssociation()
    {
        Command cmd = new DropAssociation();
        cmd.execute();
    }

    /**
     * Display the current state of the system
     */
    public void systemState()
    {
        Command cmd = new SystemState();
        cmd.execute();
    }

    /**
     * Display all empty kennels in the store
     */
    public void showEmptyKennels()
    {
        Command cmd = new ShowEmptyKennels();
        cmd.execute();
    }


    /**
     * Removes an animal-kennel association - does not remove the animal from the pet store system
     */
    public void releaseAnimal()
    {
        Command cmd = new ReleaseAnimal();
        cmd.execute();
    }

    /**
     * Return a string representation of the PetStoreSystem
     * @return a string representation of the PetStoreSystem
     */
    public String toString()
    {
        String result = "\nThe animals in the system are:\n";
        Collection<Animal> animalsCollection = AnimalMapAccess.getInstance().values();
        for (Animal anim : animalsCollection)
        {
            result = result + anim + "\n";
        }

        result = result + "-------\nThe staff members in the system are:\n";
        Collection<StaffMember> staffCollection = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staffCollection)
        {
            result = result + stf + "\n";
        }
        result = result + "-------\nThe store is " + PetStoreAccess.getInstance();
        return result;
    }

    /**
     * Runs the pet store management system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int systemCmd = -1;
        PetStoreSystemA5Q5 sys;

        while (true)
        {
            // keep collection input until entered corectly
            try
            {
                sys = new PetStoreSystemA5Q5();
                break;
            }
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }

        sys.systemIO.outputString("-------System running-------");
        String[] menuOptions = {"Quit", "Add a new animal to system", "Add a new staff member to system",
                "Assign a staff member to an animal", "Display the empty kennels in the store",
                "Assign an animal to a kennel" ,"Release an animal" ,"Remove staff-animal association",
                "Show current system state"};

        while (systemCmd != 0)
        {
            try
            {
                systemCmd = sys.systemIO.readChoice(menuOptions);

                if (systemCmd == 0)
                {
                    sys.systemState();
                } else if (systemCmd == 1)
                {
                    sys.addAnimal();
                } else if (systemCmd == 2)
                {
                    sys.addStaff();
                } else if (systemCmd == 3)
                {
                    sys.assignStaffToAnimal();
                } else if (systemCmd == 4)
                {
                    sys.showEmptyKennels();
                } else if (systemCmd == 5)
                {
                    sys.assignKennel();
                } else if (systemCmd == 6)
                {
                    sys.releaseAnimal();
                } else if (systemCmd == 7)
                {
                    sys.dropAssociation();
                } else if (systemCmd == 8)
                {
                    sys.systemState();
                }
            }
            catch (InputMismatchException e)
            {
                // thrown by the Scanner if the user types something unexpected
                System.out.println("Use an integer to choose a menu item!");

            }
            catch (RuntimeException e)
            {
                // No matter what other exception is thrown, this catches it
                // Dealing with it means discarding whatever went wrong 
                // and starting the loop over.  Easy for the programmer,
                // tedious for the user.
                System.out.println(e.getMessage());
            }
        }

        sys.systemIO.outputString("\n-------System terminated-------");
    }
}