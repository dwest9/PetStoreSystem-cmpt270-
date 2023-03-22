/*
  CMPT 270 Course material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to a person
  not registered in CMPT 270, constitutes Academic Misconduct, according
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 3 Question 2
 */

/**
 * The model of a Staff Member who has a first name and a last name.
 */

public class BasicStaff
{

    /**
     * The first name of the staff member.
     */
    private String firstName;

    /**
     * The last name of the staff member.
     */
    private String lastName;

    /**
     * The BasicStaff Social Insurance Number.
     */
    private String socInsNum;

    /**
     * The BasicStaff Employee ID number.
     */
    private String employeeID;

    /**
     * Initialize an instance of a BasicStaff.
     * @param fName the staff members first name
     * @param lName the staff members last name
     */
    public BasicStaff(String fName, String lName, String sin, String employeeID)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.socInsNum = sin;
        this.employeeID = employeeID;
    }

    /**
     * Return the first name of the staff member.
     * @return the first name of the staff member
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Return the last name of the staff member.
     * @return the last name of the staff member
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Change the first name of the staff member.
     * @param newFirstName the name of the staff member
     */
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    /**
     * Change the last name of the staff member.
     * @param newLastName the name of the staff member
     */
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    /**
     * Returns the social insurance number of the BasicStaff member
     * @return the SIN
     */
    public String getSocInsNum()
    {
        return this.socInsNum;
    }

    /**
     * Returns the employee ID number of the BasicStaff member
     * @return the employee ID
     */
    public String getEmployeeID()
    {
        return this.employeeID;
    }

    /**
     * Return a string representation of the staff member.
     * @return a string representation of the staff member
     */
    public String toString()
    {
        return "Name: " + this.lastName + ", " + this.firstName;
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
        String empID = "qwe123";

        // testing all the methods with one instance of a BasicStaff
        BasicStaff staff = new BasicStaff(fname, lname, sin, empID);
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


        reason = "Constructor + setFirstName()";
        expected = "Agatha";
        staff.setFirstName(expected);
        result = staff.getFirstName();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + setLastName()";
        expected = "Christie";
        staff.setLastName(expected);
        result = staff.getLastName();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + getSocInsNum()";
        expected = "12345";
        result = staff.getSocInsNum();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + getEmpID()";
        expected = "qwe123";
        result = staff.getEmployeeID();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + toString()";
        expected = "Name: Christie, Agatha";
        result = staff.toString();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        // testing all the methods with another instance of a BasicStaff

        reason = "2 Constructor + getFirstName()";
        fname = "Abby";
        lname = "Hester";
        sin = "54321";
        empID = "asd123";
        BasicStaff staff2 = new BasicStaff(fname, lname, sin, empID);

        result = staff2.getFirstName();
        expected = fname;
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + getLastName()";
        result = staff2.getLastName();
        expected = lname;
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + setFirstName()";
        expected = "Amelia";
        staff2.setFirstName(expected);
        result = staff2.getFirstName();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + setLastName()";
        expected = "Frey";
        staff2.setLastName(expected);
        result = staff2.getLastName();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }

        reason = "Constructor + getSocInsNum()";
        expected = "54321";
        result = staff2.getSocInsNum();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + getEmpID()";
        expected = "asd123";
        result = staff2.getEmployeeID();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        reason = "Constructor + toString()";
        expected = "Name: Frey, Amelia";
        result = staff2.toString();
        if (!result.equals(expected))
        {
            System.out.println("Expected: " + expected + ", Obtained: " + result
                    + ", (" + reason + ")");
        }


        System.out.println("*** Testing complete ***");


    }
}
