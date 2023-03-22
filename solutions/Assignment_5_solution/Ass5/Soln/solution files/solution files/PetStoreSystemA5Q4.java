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
public class PetStoreSystemA5Q4
{

    /**
     * The consoleIO object used for console commands
     */
    private InputOutputInterface storeSystemIO = IOAccess.getInstance();

    /**
     * Initialize an instance of the store management system - relies on user-input
     */
    public PetStoreSystemA5Q4()
    {        // get the required pet store info
        storeSystemIO.outputString("-------Getting Pet Store information-------\n");
        String name = storeSystemIO.readString("Enter the name of the store: ");
        int firstKennelNumber = storeSystemIO.readInt("Enter the integer label for the first kennel: ");
        int lastKennelNumber = storeSystemIO.readInt("Enter the integer label for the last kennel: ");

        PetStoreAccess.initialize(name, firstKennelNumber, lastKennelNumber);
    }

    /**
     * Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void addAnimal()
    {
        storeSystemIO.outputString("-------Adding Animal to Store-------\n");
        String name = storeSystemIO.readString("Enter the name of the animal: ");
        String animalID = storeSystemIO.readString("Enter the animal ID of the animal: ");
        String animalType = storeSystemIO.readString("Enter the type of animal: ");

        if (AnimalMapAccess.getInstance().containsKey(animalID))
        {
            throw new IllegalStateException("Animal with ID " + animalID + " already exists");
        }

        Animal anim = new Animal(name, animalID, animalType);
        Animal result = AnimalMapAccess.getInstance().put(animalID, anim);

        // checking to make sure insertion into the Map worked
        if (result != null)
        {
            AnimalMapAccess.getInstance().put(animalID, result);  // put the original animal back in
            throw new IllegalStateException("Animal was already in dictionary, even though containsKey failed. Animal " + name + " not entered.");
        }
    }

    /**
     * Read info for a new staff member, and add them to dictionary of all staff
     */
    public void addStaff()
    {
        storeSystemIO.outputString("-------Adding Staff to Store-------\n");
        String fName = storeSystemIO.readString("Enter the staff member's first name: ");
        String lName = storeSystemIO.readString("Enter the staff member's last name: ");
        String staffSIN = storeSystemIO.readString("Enter the staff member's SIN: ");
        String staffID = storeSystemIO.readString("Enter the staff member's employee ID: ");
        if (StaffMapAccess.getInstance().containsKey(staffID))
        {
            throw new IllegalStateException("Staff not added. Already have staff with employee number " + staffID);
        }


        String[] yesNoChoices = {"Yes","No"};
        storeSystemIO.outputString("Is the staff member a manager?");
        int selection = storeSystemIO.readChoice(yesNoChoices);

        StaffMember newStaff;
        if (selection == 0)
        {
            newStaff = new Manager(fName, lName, staffSIN, staffID);
        } else
        {
            newStaff = new StaffMember(fName, lName, staffSIN, staffID);
        }

        // check to make sure the staff employee ID doesn't already exist
        StaffMember result = StaffMapAccess.getInstance().put(staffID, newStaff);
        if (result != null)
        {
            // if put() returns a reference, then a manager was already stored with the same EN,
            // so put it back, and signal an error.
            StaffMapAccess.getInstance().put(staffID, result); // put the original manager back
            throw new IllegalStateException("Staff was already in dictionary, even though containsKey failed. Staff " + fName + " " + lName + " not entered.");
        }
    }

    /**
     * Assign a staff member to an animal, and the animal to the staff member
     */
    public void assignStaffToAnimal()
    {
        storeSystemIO.outputString("-------Assigning staff to an animal-------\n");
        String animalID = storeSystemIO.readString("Enter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is no such animal with ID  " + animalID);
        }

        String staffID = storeSystemIO.readString("Enter the employee number of the staff member: ");
        StaffMember staffMember = StaffMapAccess.getInstance().get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff with employee ID " + staffID);
        } else
        {
            anim.addStaff(staffMember);
            staffMember.assignAnimal(anim);
        }
    }

    /**
     * Assign an animal to a kennel
     */
    public void assignKennel()
    {
        storeSystemIO.outputString("-------Assigning a kennel to an animal-------\n");
        String animalID = storeSystemIO.readString("Enter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is such animal with ID " + animalID);
        }

        if (anim.getAssignedKennel() != -1)
        {
            throw new IllegalStateException("Animal " + animalID + " is already assigned a kennel");
        }

        int kennelNumber = storeSystemIO.readInt("Enter the kennel label for the animal: ");

        if (kennelNumber < PetStoreAccess.getInstance().getMinKennelLabel() || kennelNumber > PetStoreAccess.getInstance().getMaxKennelLabel())
        {
            throw new IllegalArgumentException(kennelNumber + " is not a valid value. Must be between " + PetStoreAccess.getInstance().getMinKennelLabel() + " and " + PetStoreAccess.getInstance().getMaxKennelLabel());
        }

        if (PetStoreAccess.getInstance().isOccupied(kennelNumber))
        {
            throw new IllegalStateException("Kennel is already assigned to an animal");
        } else
        {
            anim.setAssignedKennel(kennelNumber);
            PetStoreAccess.getInstance().assignAnimalToKennel(anim, kennelNumber);
        }
    }

    /**
     * Remove the animal-staff association
     */
    public void dropAssociation()
    {
        storeSystemIO.outputString("-------Removing staff-animal association-------\n");
        String animalID = storeSystemIO.readString("Enter the animalID of the animal: ");

        // check if animal exists in system
        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("No such animal with ID " + animalID);
        }

        String staffID = storeSystemIO.readString("Enter the employee number of the staff member: ");

        // check if the staff exists in the system
        StaffMember staffMember = StaffMapAccess.getInstance().get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff member with ID " + staffID);
        }

        // make sure returned animal's ID matches input animal ID
        String returnedAnimalsID = anim.getAnimalID();
        if (!animalID.equals(returnedAnimalsID))
        {
            throw new IllegalStateException("Animal IDs are not equal: " + animalID + " " + returnedAnimalsID);
        }

        // check if the staff member is assigned to the animal
        if (!staffMember.hasAnimal(returnedAnimalsID))
        {
            throw new IllegalStateException("Staff Member is not associated with animal:" + returnedAnimalsID);
        }

        // check if the animal is assigned to the staff member
        if (!anim.hasStaff(staffID))
        {
            throw new IllegalStateException("Animal is not associated with staff member:" + staffID);
        }

        // Animal and staff member are both properly associated, so remove the association
        anim.removeStaff(staffID);
        staffMember.removeAnimal(animalID);
    }

    /**
     * Display the current state of the system
     */
    public void systemState()
    {
        storeSystemIO.outputString("-------Showing system state-------\n");
        storeSystemIO.outputString(this.toString());
    }

    /**
     * Display all empty kennels in the store
     */
    public void showEmptyKennels()
    {
        storeSystemIO.outputString("-------Showing available kennels-------\n");
        LinkedList<Integer> kennels = PetStoreAccess.getInstance().availableKennels();

        if (kennels.size() == 0)
        {
            storeSystemIO.outputString("None");
        } else
        {
            for (Integer i : kennels)
            {
                storeSystemIO.outputString(i + " ");
            }
            storeSystemIO.outputString("\n");
        }
    }


    /**
     * Removes an animal-kennel association - does not remove the animal from the pet store system
     */
    public void releaseAnimal()
    {
        storeSystemIO.outputString("-------Releasing an animal from a kennel-------\n");
        String animalID = storeSystemIO.readString("Enter the ID of the animal to release: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        // see if the animalID is valid
        if (anim == null)
        {
            throw new NoSuchElementException("No such animal with ID " + animalID + " exists");
        }

        int kennel = anim.getAssignedKennel();

        // check if the animal is properly assigned a kennel
        if (kennel == -1)
        {
            throw new NoSuchElementException("No kennel was assigned to animal: " + animalID);
        }

        // check if the kennel was properly assigned to the animal
        if (PetStoreAccess.getInstance().getAnimal(kennel) != anim)
        {
            throw new IllegalStateException(animalID + " recorded in kennel " + kennel + ", but different animal " + PetStoreAccess.getInstance().getAnimal(kennel).getAnimalID() + " is there.");
        }

        // free the kennel, and set animals kennel number to -1 (no set kennel)
        PetStoreAccess.getInstance().freeKennel(kennel);
        anim.setAssignedKennel(-1);
    }

    /**
     * Return a string representation of the PetStoreSystem
     * @return a string representation of the PetStoreSystem
     */
    public String toString()
    {
        String result = "\nThe animals in the system are:";
        Collection<Animal> animalsCollection = AnimalMapAccess.getInstance().values();
        for (Animal anim : animalsCollection)
        {
            result = result + anim;
        }

        result = result + "\n-------\nThe staff members in the system are:";
        Collection<StaffMember> staffCollection = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staffCollection)
        {
            result = result + stf;
        }
        result = result + "\n-------\nThe store is " + PetStoreAccess.getInstance();
        return result;
    }

    /**
     * Runs the pet store management system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int systemCmd = -1;
        PetStoreSystemA5Q4 sys;

        while (true)
        {
            // keep collection input until entered corectly
            try
            {
                sys = new PetStoreSystemA5Q4();
                break;
            }
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }

        sys.storeSystemIO.outputString("-------System running-------");
        String[] menuOptions = {"Quit", "Add a new animal to system", "Add a new staff member to system",
                "Assign a staff member to an animal", "Display the empty kennels in the store",
                "Assign an animal to a kennel" ,"Release an animal" ,"Remove staff-animal association",
                "Show current system state"};

        while (systemCmd != 0)
        {
            try
            {
                systemCmd = sys.storeSystemIO.readChoice(menuOptions);

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

        sys.storeSystemIO.outputString("\n-------System terminated-------");
    }
}