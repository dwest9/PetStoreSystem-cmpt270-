/*
  CMPT 270 Course material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to a person
  not registered in CMPT 270, constitutes Academic Misconduct, according
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 3 Question 3
 */

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
     * Initializes an Animal with a name, ID number and type
     * @param animName the name of the animal being created
     * @param animID   the alphanumeric ID of the animal being created
     * @param animType the type of animal as a string
     */
    public Animal(String animName, String animID, String animType)
    {
        this.name = animName;
        this.animalID = animID;
        this.animalType = animType;
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
        return "Name: " + this.name + ", Type: " + this.animalType
                + ", ID: " + this.animalID;
    }

    /**
     * A method to test the ANimal class.
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


        System.out.println("*** Testing Complete ***");

    }
}
