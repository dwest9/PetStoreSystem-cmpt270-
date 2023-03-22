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
 * The model of a person who has a name and a social insurance number
 * that cannot be changed.
 */
public class Person
{

    /**
     * The first name of the person.
     */
    private String firstName;

    /**
     * The last name of the person.
     */
    private String lastName;

    /**
     * The person's Social Insurance Number.
     */
    private String socInsNum;

    /**
     * Initialize an instance of a Person with the given name and social insurance number.
     * @param fName the person's first name
     * @param lName the person's last name
     * @param sin   the person's Social Insurance Number.
     */
    public Person(String fName, String lName, String sin)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.socInsNum = sin;
    }

    /**
     * Return the first name of the person.
     * @return the first name of the person
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Return the last name of the person.
     * @return the last name of the person
     */
    public String getLastName()
    {
        return this.lastName;
    }


    /**
     * Return the Social Insurance Number of the person.
     * @return the Social Insurance Number of the person.
     */
    public String getSocInsNum()
    {
        return this.socInsNum;
    }

    /**
     * Change the first name of the person.
     * @param newFirstName the name of the person
     */
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    /**
     * Change the last name of the person.
     * @param newLastName the name of the person
     */
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    /**
     * Return a string representation of the person.
     * @return a string representation of the person
     */
    public String toString()
    {
        return "Last Name: " + this.lastName + ", First Name: " + this.firstName
                + ", SIN: " + this.socInsNum;
    }


    /**
     * A method to test the Person class.
     */
    public static void main(String[] args)
    {

        /* For testing the Person class */

        String reason = "Constructor + getFirstName()";
        String fname = "Albert";
        String lname = "Roland";
        String sin = "012345";

        // test all of the methods with this instance
        Person person = new Person(fname, lname, sin);
        String result = person.getFirstName();
        String expected = fname;

        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getLastName()";
        result = person.getLastName();
        expected = lname;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getSocInsNum()";
        result = person.getSocInsNum();
        expected = sin;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setFirstName()";
        expected = "Anthony";
        person.setFirstName(expected);
        result = person.getFirstName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setLastName()";
        expected = "Calhoun";
        person.setLastName(expected);
        result = person.getLastName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing toString()";
        expected = "Last Name: Calhoun, First Name: Anthony, SIN: 012345";
        result = person.toString();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }


        /* Testing all methods with another instance of a person */


        reason = "Constructor + getFirstName()";
        fname = "Alastair";
        lname = "Davison";
        sin = "98765";

        // test all methods with this instance
        Person person2 = new Person(fname, lname, sin);
        result = person2.getFirstName();
        expected = fname;

        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getLastName()";
        result = person2.getLastName();
        expected = lname;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getSocInsNum()";
        result = person2.getSocInsNum();
        expected = sin;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setFirstName()";
        expected = "Ashley";
        person2.setFirstName(expected);
        result = person2.getFirstName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setLastName()";
        expected = "Whitaker";
        person2.setLastName(expected);
        result = person2.getLastName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing toString()";
        expected = "Last Name: Whitaker, First Name: Ashley, SIN: 98765";
        result = person2.toString();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }


        System.out.println("*** Testing Complete ***");

    }
}
