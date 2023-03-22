package entities;
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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The model of an animal with a name, animal type, and an animalID number
 * that cannot be changed.
 */
public class Animal
{

    /**
     * The name of the animal
     */
    private String name;

    /**
     * The animals ID number.
     */
    private String animalID;

    /**
     * The animal type (Dog, cat, etc...)
     */
    private String animalType;

    /**
     * The currently assigned kennel label (-1 if no kennel is assigned)
     */
    private int assignedKennel;

    /**
     * The list of assigned staff to this animal
     */
    private LinkedList<StaffMember> assignedStaff;

    /**
     * Initializes an Animal with a name, ID number and type
     * @param wName    the name of the animal being created
     * @param animID   the alphanumeric ID of the animal being created
     * @param animType the type of animal as a string
     */
    public Animal(String wName, String animID, String animType)
    {
        this.name = wName;
        this.animalID = animID;
        this.animalType = animType;
        this.assignedKennel = -1;
        this.assignedStaff = new LinkedList<StaffMember>();
    }

    /**
     * Adds a staff member to the list of staff assigned to this animal
     * @param stf the staff member to be assigned
     */
    public void addStaff(StaffMember stf)
    {
        if (this.hasStaff(stf.getEmployeeID()))
        {
            throw new IllegalStateException(stf.getFirstName() + " " + stf.getLastName() + " is already assigned to this animal");
        }
        assignedStaff.add(stf);
    }

    /**
     * Returns the animals list of currently assigned staff
     */
    public LinkedList<StaffMember> getAssignedStaff()
    {
        return this.assignedStaff;
    }

    /**
     * Removes an assigned staff member from this animal
     * @param staffID the staff member to remove
     */
    public void removeStaff(String staffID)
    {
        if (!this.hasStaff(staffID))
        {
            throw new NoSuchElementException(staffID + " is not assigned to this animal");
        }

        Iterator<StaffMember> iter = assignedStaff.iterator();
        while (iter.hasNext())
        {
            StaffMember stf = iter.next();
            if (stf.getEmployeeID().equals(staffID))
            {
                iter.remove();
            }
        }
    }

    public boolean hasStaff(String staffID)
    {
        Iterator<StaffMember> iter = assignedStaff.iterator();
        while (iter.hasNext())
        {
            StaffMember stf = iter.next();
            if (stf.getEmployeeID().equals(staffID))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This sets the animals currently assigned kennel label
     * @param newKennelLabel the new kennel label
     */
    public void setAssignedKennel(int newKennelLabel)
    {
        this.assignedKennel = newKennelLabel;
    }

    /**
     * This method returns the currently assigned kennel label
     * @return returns the currently assigned kennel label
     */
    public int getAssignedKennel()
    {
        return this.assignedKennel;
    }


    /**
     * Return the animals name
     * @return the name of the animal
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Return the animals type
     * @return the type of the animal
     */
    public String getAnimalType()
    {
        return this.animalType;
    }

    /**
     * Changes the animals type
     * @param newType the new type of animal
     */
    public void setAnimalType(String newType)
    {
        this.animalType = newType;
    }

    /**
     * Return the animals ID
     * @return the ID of the animal
     */
    public String getAnimalID()
    {
        return this.animalID;
    }

    /**
     * Change the animals name
     * @param newName the new name of the animal
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Return a string representation of the animal.
     * @return a string representation of the animal
     */
    public String toString()
    {
        String result = "Name: " + this.name + ", Type: " + this.animalType + ", ID: " + this.animalID + ", Kennel: ";
        if (this.assignedKennel == -1)
        {
            result = result + "none";
        } else
        {
            result = result + this.assignedKennel;
        }
        result = result + ", Assigned Staff: ";
        for (BasicStaff stf : assignedStaff)
        {
            result = result + stf.getEmployeeID() + ", ";
        }
        return result;
    }

    /**
     * A method to test the Animal class.
     */
    public static void main(String[] args)
    {

        /* For testing the Animal class */

        String reason = "Constructor + getName()";
        String name = "Sparky";
        String type = "dog";
        String animalID = "spk123";

        // test all methods with this instance
        Animal animal = new Animal(name, animalID, type);
        String result = animal.getName();
        String expected = name;

        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getName()";
        result = animal.getName();
        expected = name;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getAnimalID()";
        result = animal.getAnimalID();
        expected = animalID;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getAnimalType()";
        result = animal.getAnimalType();
        expected = type;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getAssignedKennel()";
        int kennelResult = animal.getAssignedKennel();
        if (kennelResult != -1)
        {
            System.out.println("Error: Expected: -1, Obtained: " + kennelResult
                    + " (" + reason + ")");
        }

        reason = "Testing setAssignedKennel()";
        animal.setAssignedKennel(5);
        kennelResult = animal.getAssignedKennel();
        if (kennelResult != 5)
        {
            System.out.println("Error: Expected: 5, Obtained: " + kennelResult
                    + " (" + reason + ")");
        }

        reason = "Testing assignedStaff list after constructor";
        int staffResult = animal.assignedStaff.size();
        if (staffResult != 0)
        {
            System.out.println("Error: Expected: , Obtained: " + staffResult
                    + " (" + reason + ")");
        }

        reason = "Testing setName()";
        expected = "Rufus";
        animal.setName(expected);
        result = animal.getName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setType()";
        expected = "elephant";
        animal.setAnimalType(expected);
        result = animal.getAnimalType();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        // test addStaff, removeStaff, hasStaff, setAssignedKennel, getAssignedKennel

        // test with staff instance
        StaffMember testStaff = new StaffMember("Joe", "Example", "12345", "abc123");

        reason = "Testing addStaff()";
        expected = "abc123";
        animal.addStaff(testStaff);
        result = animal.assignedStaff.get(0).getEmployeeID();
        if (!expected.equals(result))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }


        reason = "Testing hasStaff()";
        expected = "abc123";
        boolean bResult = animal.hasStaff(expected);
        if (!bResult)
        {
            System.out.println("Error: Expected: True, Obtained: False" + " (" + reason + ")");
        }

        reason = "Testing removeStaff()";
        expected = "abc123";
        animal.removeStaff(expected);
        bResult = animal.assignedStaff.isEmpty();
        if (!bResult)
        {
            System.out.println("Error: Expected: True, Obtained: False" + " (" + reason + ")");
        }

        reason = "Testing toString()";
        result = animal.toString();
        expected = "Name: Rufus, Type: elephant, ID: spk123";
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        System.out.println("*** Testing Complete ***");

    }
}
