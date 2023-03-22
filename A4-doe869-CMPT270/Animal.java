/*
  CMPT 270 Course material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to a person
  not registered in CMPT 270, constitutes Academic Misconduct, according
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Starter file for Assignment 4
 */

// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.ArrayList;
import java.util.*;


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
     * The integer label of the kennel occupied by an animal.
     * value of -1 indicates no kennel available at this time.
     */
    private int newKennelLabel;

    /**
     * The animals ID number.
     */
    private String animalID;

    /**
     * The animal type (Dog, cat, etc...)
     */
    private String animalType;

    /**
     * An ArrayList of staff's for the animals.
     */
    private ArrayList<StaffMember> staffmember;


    /**
     * Initializes an Animal with a name, ID number and type
     * @param animName    the name of the animal being created
     * @param animID   the alphanumeric ID of the animal being created
     * @param animType the type of animal as a string
     */

    public Animal(String animName, String animID, String animType)
    {
        this.name = animName;
        this.animalID = animID;
        this.animalType = animType;

        newKennelLabel = -1;
        staffmember = new ArrayList<StaffMember>();
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
     * Return the integer label of the kennel occupied by the animal.
     *
     * @return the integer label of the kennel occupied by the animal
     */
    public int getAssignedKennel() {
        return newKennelLabel;
    }

    /**
     * Assign the animal to the kennel passed in as a parameter.
     *
     * @param newKennelLabel the integer label of the kennel for the animal
     */
    public void setAssignedKennel(int newKennelLabel) {
        this.newKennelLabel = newKennelLabel;
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


    /**
     * Adding another staff to the list of staffs of animals.
     *
     * @param stf the new staff to be added for this animal
     * @precond !hasStaff(stf.getEmployeeId())
     */
    public void addStaff(StaffMember stf) {
        if (hasStaff(stf.getEmployeeID()))
            throw new IllegalStateException(stf.getEmployeeID() + " is already a staff member");
        staffmember.add(stf);
    }


    /**
     * this removes the staff specified by the name parameter
     *
     * @param employeeID the employee ID of the staff to be removed from the staffmember's list
     * @precond hasStaff(employeeID)
     */
    public void removeStaff(String employeeID) {
        Iterator<StaffMember> iter = staffmember.iterator();
        while (iter.hasNext()) {
            StaffMember str = iter.next();
            if (str.getEmployeeID().equals(employeeID)) {
                iter.remove();
            }
        }
    }

    /**
     * @param employeeId the employee ID of a staff
     */
    public boolean hasStaff(String employeeId) {
        Iterator<StaffMember> iter = staffmember.iterator();
        while (iter.hasNext()) {
            StaffMember s = iter.next();
            if (s.getEmployeeID().equals(employeeId))
                return true;
        }
        return false;
    }

    /**
     * @return an ArrayList of the staff member employee numbers for the animal
     */
    public ArrayList<String>recent_staff_member() {
        ArrayList<String> strs = new ArrayList<>();

        for (StaffMember s : staffmember) {
            strs.add(s.getEmployeeID());
        }
        return strs;
    }


    public String toString()
    {
        return "Name: " + this.name + ", Type: " + this.animalType + ", ID: " + this.animalID;
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

        // test all of the methods with this instance
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

        reason = "Testing toString()";
        result = animal.toString();
        expected = "Name: Rufus, Type: elephant, ID: spk123";
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }


        /* Testing all methods again with another animal instance */


        reason = "Constructor + getName()";
        name = "Peanut";
        type = "cat";
        animalID = "pea321";

        // test all of the methods with this instance
        Animal animal2 = new Animal(name, animalID, type);
        result = animal2.getName();
        expected = name;

        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getName()";
        result = animal2.getName();
        expected = name;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getAnimalID()";
        result = animal2.getAnimalID();
        expected = animalID;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing getAnimalType()";
        result = animal2.getAnimalType();
        expected = type;
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setName()";
        expected = "Pickles";
        animal2.setName(expected);
        result = animal2.getName();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing setType()";
        expected = "guinea pig";
        animal2.setAnimalType(expected);
        result = animal2.getAnimalType();
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }

        reason = "Testing toString()";
        result = animal2.toString();
        expected = "Name: Pickles, Type: guinea pig, ID: pea321";
        if (!result.equals(expected))
        {
            System.out.println("Error: Expected: " + expected + " Obtained: " + result
                    + " (" + reason + ")");
        }


        Animal stud = new Animal("Blue", "bb771","dog");

        //Test getAssignKennel()
        if(stud.getAssignedKennel() != -1){
            System.out.println("Error in getAssignKennel()");
        }
        //Test setAssignKennel()
        stud.setAssignedKennel(15);
        if(stud.getAssignedKennel() == -1){
            System.out.println("Error in setAssignedKennel()");
        }

        //Test addStaff() and hasStaff()
        StaffMember s = new StaffMember("Andrew","Jones", "12345", "Drew15");
        stud.addStaff(s);

        if(!stud.hasStaff("Drew15")){
            System.out.println("Error in addStaff() and hasStaff");
        }

        StaffMember m1 = new StaffMember("Chris", "rogers", "9886", "Crog89");
        StaffMember m2 = new StaffMember("Tony", "stark", "6789", "Iron45");
        StaffMember m3 = new StaffMember("Bruce", "banner", "11456", "Hulk11");

        //Test removeStaff
        stud.addStaff(m1); stud.addStaff(m2); stud.addStaff(m3);
        stud.removeStaff("Drew15");

        if(stud.hasStaff("Drew15")){
            System.out.println("Error in removeStaff()");
        }

        System.out.println("*** Testing Complete ***");

    }

}
