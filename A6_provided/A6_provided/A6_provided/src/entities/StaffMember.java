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

public class StaffMember extends BasicStaff
{

    /**
     * The list of assigned animals to the StaffMember
     */
    public LinkedList<Animal> assignedAnimals;

    /**
     * Creates an instance of StaffMember, with an empty list of assigned animals
     * @param fName the staff members first name
     * @param lName the staff members last name
     * @param sin   the social insurance number
     * @param empID the employee ID
     */
    public StaffMember(String fName, String lName, String sin, String empID)
    {
        super(fName, lName, sin, empID);
        assignedAnimals = new LinkedList<Animal>();
    }

    /**
     * Assigns an animal to this StaffMember
     * @param a the animal that is assigned
     * @precond Cannot already be assigned an animal with the same animalID
     */
    public void assignAnimal(Animal a)
    {
        if (hasAnimal(a.getAnimalID()))
        {
            throw new IllegalStateException("Animal: " + a.getAnimalID() + " is already assigned to employee " + this.getEmployeeID());
        }

        assignedAnimals.add(a);
    }

    /**
     * Removes an animal from the list of assigned animals
     * @param animalID the ID of the animal to be removed
     */
    public void removeAnimal(String animalID)
    {
        if (!this.hasAnimal(animalID))
        {
            throw new NoSuchElementException("Staff member " + this.getEmployeeID() + " is not assigned animal " + animalID);
        }

        Iterator<Animal> iter = assignedAnimals.iterator();
        while (iter.hasNext())
        {
            Animal anim = iter.next();
            if (anim.getAnimalID().equals(animalID))
            {
                iter.remove();
                return;
            }
        }
    }

    /**
     * Returns the animals list of currently assigned staff
     */
    public LinkedList<Animal> getAssignedAnimals()
    {
        return this.assignedAnimals;
    }

    /**
     * Checks if a specific animal is assigned to this StaffMember, returns true if it is, false otherwise
     * @param animalID the ID of the animal to check for
     * @return true if the animal with the specified animalID is assigned, false otherwise
     */
    public boolean hasAnimal(String animalID)
    {
        Iterator<Animal> iter = assignedAnimals.iterator();
        while (iter.hasNext())
        {
            Animal anim = iter.next();
            if (anim.getAnimalID().equals(animalID))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the StaffMember instance
     * @return a string representing the StaffMember
     */
    public String toString()
    {
        String result = super.toString() + ", Assigned Animals: ";
        for (Animal a : assignedAnimals)
        {
            result = result + a.getAnimalID() + ", ";
        }
        return result;
    }

    public static void main(String[] args)
    {
        /* Test Driver for testing the class StaffMember */

        String reason = "Test Constructor + getFirstName()";
        String fname = "Benny";
        String lname = "Hill";
        String sin = "12345";
        String employeeID = "abc123";

        // testing all the methods with one instance of a StaffMember
        StaffMember staff = new StaffMember(fname, lname, sin, employeeID);
        String result = staff.getFirstName();
        String expected = fname;

        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + getLastName()";
        result = staff.getLastName();
        expected = lname;
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + getSocInsNum()";
        result = staff.getSocInsNum();
        expected = sin;
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + getEmployeeID()";
        result = staff.getEmployeeID();
        expected = employeeID;
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + assignedAnimals is empty to start";
        boolean bResult = staff.assignedAnimals.isEmpty();
        if (!bResult)
        {
            System.out.println("Expected: True Obtained: False" + ", (" + reason + ")");
        }

        // test assign, has and remove animal
        Animal testAnimal = new Animal("Pepper", "pep123", "cat");

        reason = "Test assignAnimal";
        staff.assignAnimal(testAnimal);
        result = staff.assignedAnimals.get(0).getAnimalID();
        expected = "pep123";
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Test hasAnimal()";
        bResult = staff.hasAnimal("pep123");
        if (!bResult)
        {
            System.out.println("Expected: True, Obtained: False" + ", (" + reason + ")");
        }

        reason = "Test removeAnimal()";
        staff.removeAnimal("pep123");
        bResult = staff.hasAnimal("pep123");
        if (bResult)
        {
            System.out.println("Expected: False, Obtained: True" + ", (" + reason + ")");
        }

        System.out.println("*** Testing Complete ***");

    }
}
