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

import java.util.LinkedList;

/**
 * A pet store with a specified number of animal kennels with consecutive labels.
 */
public class PetStore
{
    /**
     * The name of this pet store.
     */
    private String name;

    /**
     * The (external) label of the first kennel of the store.
     */
    private int minKennelLabel;

    /**
     * The (external) label of the last kennel of the store.
     */
    private int maxKennelLabel;

    /**
     * An array to represent the kennel in the store.  Each kennel is empty (null)
     * or else has an animal in it.
     */
    private Animal[] kennel;

    /**
     * Initialize the store with the name given, and the kennel with the consecutive labels from minKennelLabel to MaxKennelLabel.
     * @param wName           the name of the store
     * @param wMinKennelLabel the label of the first kennel in the store
     * @param wMaxKennelLabel the label of the last kennel in the store
     * @precond wName != null && !wName.equals("") && wMinKennelLabel >= 0 && wMaxKennelLabel >= wMinKennelLabel
     */
    public PetStore(String wName, int wMinKennelLabel, int wMaxKennelLabel)
    {
        if (wName == null || wName.equals(""))
        {
            throw new IllegalArgumentException("The name of a store cannot be null or empty.  "
                    + "It is " + wName);
        }
        if (wMinKennelLabel < 0 || wMaxKennelLabel < wMinKennelLabel)
        {
            throw new IllegalArgumentException("The kennel labels " + wMinKennelLabel + " and " + wMaxKennelLabel
                    + " are invalid as they cannot be negative, and there must be at least one kennel between minimum and maximum values.");
        }

        name = wName;
        minKennelLabel = wMinKennelLabel;
        maxKennelLabel = wMaxKennelLabel;
        kennel = new Animal[wMaxKennelLabel - wMinKennelLabel + 1];
    }

    /**
     * Creates and returns a list of all the non-occupied kennel labels
     * @return a list of available kennels
     */
    public LinkedList<Integer> availableKennels()
    {
        LinkedList<Integer> availableKennelList = new LinkedList<Integer>();
        for (int i = minKennelLabel; i <= maxKennelLabel; i++)
        {
            if (!isOccupied(i))
            {
                availableKennelList.addLast(i);
            }
        }
        return availableKennelList;
    }

    /**
     * Removes an animal from a specific kennel
     * @param kennelLabel the label of the bed from of a student who has checked-out
     * @precond must be a valid label, and kennel must be occupied
     */
    public void freeKennel(int kennelLabel)
    {
        if (!isValidLabel(kennelLabel))
        {
            throw new IllegalArgumentException(kennelLabel + " is not a valid label");
        }

        if (!isOccupied(kennelLabel))
        {
            throw new IllegalStateException(kennelLabel + " is not currently occupied");
        }

        kennel[externalToInternalIndex(kennelLabel)] = null;
    }

    /**
     * Return the name of this store.
     * @return the name of this store
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the smallest label for a kennel on the store.
     * @return the smallest Label for a kennel on the store
     */
    public int getMinKennelLabel()
    {
        return minKennelLabel;
    }

    /**
     * Return the largest label for a kennel on the store.
     * @return the largest label for a kennel on the store
     */
    public int getMaxKennelLabel()
    {
        return maxKennelLabel;
    }

    /**
     * Return the internal/array index of the kennel corresponding to the external label.
     * @param kennelLabel the label of a kennel from the external/user perspective
     * @return the internal/array index of the kennel corresponding to the external label
     * @precond isValidLabel(kennelLabel)
     */
    private int externalToInternalIndex(int kennelLabel)
    {
        if (!isValidLabel(kennelLabel))
        {
            throw new IllegalArgumentException(kennelLabel + " is not a valid label for a kennel in this store.");
        }

        return kennelLabel - minKennelLabel;
    }

    /**
     * Return the external/user label of the kennel corresponding to the internal index.
     * @param arrayIndex the index of a location in the array of kennels
     * @return the external/user label of the kennel corresponding to the internal index
     * @precond 0 <= arrayIndex < kennel.length
     */
    private int internalToExternalLabel(int arrayIndex)
    {
        if (arrayIndex < 0 || arrayIndex >= kennel.length)
        {
            throw new IllegalArgumentException("The value " + arrayIndex +
                    " is not a valid index for an array of length " + kennel.length + ".");
        }

        return arrayIndex + minKennelLabel;
    }

    /**
     * Is the specified kennel occupied?
     * @param kennelLabel the label of the kennel to be checked for being occupied
     * @return True if the kennel is occupied, false otherwise
     * @precond isValidLabel(kennelLabel)
     */
    public boolean isOccupied(int kennelLabel)
    {
        if (!isValidLabel(kennelLabel))
        {
            throw new IllegalArgumentException(kennelLabel + " is not a valid label for a kennel in the store.");
        }

        return kennel[externalToInternalIndex(kennelLabel)] != null;
    }

    /**
     * Return the animal in the specified kennel.
     * @param kennelLabel the label of the kennel that has the animal to be retrieved
     * @return the animal in the specified kennel
     * @precond isValidLabel(kennelLabel) && isOccupied(kennelLabel)
     */
    public Animal getAnimal(int kennelLabel)
    {
        if (!isValidLabel(kennelLabel))
        {
            throw new IllegalArgumentException(kennelLabel + " is not a valid label for a kennel in the store.");
        }
        if (!isOccupied(kennelLabel))
        {
            throw new IllegalStateException("Kennel " + kennelLabel + " is not currently occupied");
        }
        return kennel[externalToInternalIndex(kennelLabel)];
    }

    /**
     * Assign the specified animal to the specified kennel.
     * @param animalToAssign the animal to be assigned to a kennel
     * @param kennelLabel    the label of the kennel that the animal is to be assigned
     * @precond isValidLabel(kennelLabel) && !isOccupied(kennelLabel)
     */
    public void assignAnimalToKennel(Animal animalToAssign, int kennelLabel)
    {
        if (!isValidLabel(kennelLabel))
        {
            throw new IllegalArgumentException(kennelLabel + " is not a valid label for a kennel in the store.");
        }
        if (isOccupied(kennelLabel))
        {
            throw new IllegalStateException("Kennel " + kennelLabel + " is currently occupied by "
                    + kennel[externalToInternalIndex(kennelLabel)]
                    + " so cannot be assigned to another animal");
        }

        kennel[externalToInternalIndex(kennelLabel)] = animalToAssign;
    }

    /**
     * Return a String representation of the properties of the store.
     * @return a String representation of the properties of the store
     */
    public String toString()
    {
        String result = "Store: " + name + "\nNumber of kennels: " + kennel.length + "\nCurrent animals:";
        for (int i = 0; i < kennel.length; i++)
        {
            result = result + "\nKennel #" + internalToExternalLabel(i) + ": ";
            if (kennel[i] != null)
            {
                result = result + kennel[i].getName();
            } else
            {
                result = result + "[none]";
            }
        }
        return result;
    }


    /**
     * Is kennelLabel a valid external label for a kennel?
     * @param kennelLabel an int to be tested to determined whether it is a valid label
     * @return is kennelLabel a valid external label?
     * <p>
     * This is a helper method for testing pre-conditions students were not required to implement it
     */
    public boolean isValidLabel(int kennelLabel)
    {
        return kennelLabel >= minKennelLabel && kennelLabel <= maxKennelLabel;
    }


    /**
     * A method to test the class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        /* For testing the PetStore class */

        String reason = "Testing constructor + getName()";
        String storeName = "Penny's Pets";
        int lowestKennelLabel = 5;
        int highestKennelLabel = 10;

        // test all of the methods with this instance of the PetStore class
        PetStore testStore = new PetStore(storeName, lowestKennelLabel, highestKennelLabel);
        String sResult = testStore.getName();
        String sExpected = storeName;

        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected: " + sExpected + " Obtained: " + sResult
                    + " (" + reason + ")");
        }

        reason = "Testing getMinKennelLabel()";
        int nResult = testStore.getMinKennelLabel();
        int nExpected = lowestKennelLabel;
        if (nResult != nExpected)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing getMaxKennelLabel()";
        nResult = testStore.getMaxKennelLabel();
        nExpected = highestKennelLabel;
        if (nResult != nExpected)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with min label";
        if (!testStore.isValidLabel(lowestKennelLabel))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with max label";
        if (!testStore.isValidLabel(highestKennelLabel))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with min + 2 label";
        if (!testStore.isValidLabel(lowestKennelLabel + 2))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with max label - 2";
        if (!testStore.isValidLabel(highestKennelLabel - 2))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with min + 2 label";
        if (!testStore.isValidLabel(lowestKennelLabel + 2))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with min label - 1 (invalid label)";
        if (testStore.isValidLabel(lowestKennelLabel - 1))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing isValidLabel() with max label + 1 (invalid label)";
        if (testStore.isValidLabel(highestKennelLabel + 1))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing internalToExternalLabel()";
        nExpected = 5;
        nResult = testStore.internalToExternalLabel(0);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing internalToExternalLabel()";
        nExpected = 10;
        nResult = testStore.internalToExternalLabel(5);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing internalToExternalLabel()";
        nExpected = 8;
        nResult = testStore.internalToExternalLabel(3);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing externalToInternalIndex()";
        nExpected = 5;
        nResult = testStore.externalToInternalIndex(10);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing externalToInternalIndex()";
        nExpected = 0;
        nResult = testStore.externalToInternalIndex(5);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing externalToInternalIndex()";
        nExpected = 2;
        nResult = testStore.externalToInternalIndex(7);
        if (nExpected != nResult)
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        /* Testing the assignment of an animal to a kennel */

        Animal testDog = new Animal("Sparky", "spk123", "dog");

        reason = "Testing isOccupied() when all kennels are empty";
        if (testStore.isOccupied(5))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing assignAnimalToKennel()";
        testStore.assignAnimalToKennel(testDog, 5);
        if (!testStore.isOccupied(5))
        {
            System.out.println("Error: Expected: " + nExpected + " Obtained: " + nResult
                    + " (" + reason + ")");
        }

        reason = "Testing getAnimal()";
        Animal returnedAnimal = testStore.getAnimal(5);
        if (!returnedAnimal.toString().equals(testDog.toString()))
        {
            System.out.println("Error: Expected: " + sExpected + " Obtained: " + sResult
                    + " (" + reason + ")");
        }

        reason = "Testing toString()";
        sExpected = "Store: Penny's Pets\nNumber of kennels: 6\nCurrent animals:\nKennel #5: Sparky\nKennel #6: [none]\nKennel #7: [none]\nKennel #8: [none]\nKennel #9: [none]\nKennel #10: [none]";
        sResult = testStore.toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        // Testing added methods availableKennels() and freeKennel()

        reason = "Testing availableKennels()";
        sExpected = "[6, 7, 8, 9, 10]";
        sResult = testStore.availableKennels().toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        reason = "Testing availableKennels()";
        testStore.assignAnimalToKennel(testDog, 7);
        sExpected = "[6, 8, 9, 10]";
        sResult = testStore.availableKennels().toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        reason = "Testing freeKennel()";
        testStore.freeKennel(7);
        sExpected = "[6, 7, 8, 9, 10]";
        sResult = testStore.availableKennels().toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        reason = "Testing assignAnimalToKennel()";
        testStore.assignAnimalToKennel(testDog, 10);
        sExpected = "[6, 7, 8, 9]";
        sResult = testStore.availableKennels().toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        reason = "Testing freeKennel()";
        testStore.freeKennel(10);
        sExpected = "[6, 7, 8, 9, 10]";
        sResult = testStore.availableKennels().toString();
        if (!sResult.equals(sExpected))
        {
            System.out.println("Error: Expected:\n" + sExpected + "\nObtained:\n" + sResult + "\n(" + reason + ")");
        }

        System.out.println("*** Testing Complete ***");


    }
}
