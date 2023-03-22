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

public class Manager extends StaffMember
{
    /**
     * Creates an instance of a Manager
     * @param fName the Managers first name
     * @param lName the Managers last name
     * @param sin   the social insurance number of the Manager
     * @param empID the employee ID of the Manager
     */
    public Manager(String fName, String lName, String sin, String empID)
    {
        super(fName, lName, sin, empID);
    }

    /**
     * Returns a string representation of the Manager
     * @return a string representing the Manager
     */
    public String toString()
    {
        return "Manager: " + super.toString();
    }

    public static void main(String[] args)
    {
        /* Test Driver for testing the class Manager */

        String reason = "Test Constructor + getFirstName()";
        String fname = "Fred";
        String lname = "Winters";
        String sin = "12345";
        String employeeID = "asd123";

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

        // test assignAnimal, hasAnimal and removeAnimal
        Animal testAnimal = new Animal("Penny", "pen123", "rat");

        reason = "Test assignAnimal";
        staff.assignAnimal(testAnimal);
        result = staff.assignedAnimals.get(0).getAnimalID();
        expected = "pen123";
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Test hasAnimal()";
        bResult = staff.hasAnimal("pen123");
        if (!bResult)
        {
            System.out.println("Expected: True, Obtained: False" + ", (" + reason + ")");
        }

        reason = "Test removeAnimal()";
        staff.removeAnimal("pen123");
        bResult = staff.hasAnimal("pen123");
        if (bResult)
        {
            System.out.println("Expected: False, Obtained: True" + ", (" + reason + ")");
        }

        System.out.println("*** Testing Complete ***");
    }
}
