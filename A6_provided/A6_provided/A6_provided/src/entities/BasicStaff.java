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

/**
 * The model of a Staff Member who has a first name and a last name.
 */

public class BasicStaff extends Person
{

    /**
     * The employee ID of the BasicStaff member
     */
    private String employeeID;

    /**
     * Initialize an instance of a BasicStaff.
     * @param fName the staff members first name
     * @param lName the staff members last name
     */
    public BasicStaff(String fName, String lName, String sin, String empID)
    {
        super(fName, lName, sin);
        this.employeeID = empID;
    }

    /**
     * Returns the employee ID
     * @return the employee ID
     */
    public String getEmployeeID()
    {
        return employeeID;
    }

    /**
     * Return a string representation of the staff member.
     * @return a string representation of the staff member
     */
    public String toString()
    {
        return super.toString() + ", EmployeeID: " + this.employeeID;
    }


    /**
     * A method to test the BasicStaff class.
     */
    public static void main(String[] args)
    {

        /* For testing the class BasicStaff */

        String reason = "Constructor + getFirstName()";
        String fname = "Abby";
        String lname = "Wallace";
        String sin = "12345";
        String employeeID = "abc123";

        // testing all the methods with one instance of a BasicStaff
        BasicStaff staff = new BasicStaff(fname, lname, sin, employeeID);
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

        reason = "Testing toString()";
        result = staff.toString();
        expected = "Last Name: Wallace, First Name: Abby, SIN: 12345, EmployeeID: abc123";
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        System.out.println("*** Testing complete ***");


    }
}
