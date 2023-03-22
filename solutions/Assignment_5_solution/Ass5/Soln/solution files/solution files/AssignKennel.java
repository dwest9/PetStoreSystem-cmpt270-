/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 5 Question 5
 */

import java.util.NoSuchElementException;

public class AssignKennel implements Command
{
    /**
     * Executes the command - Assign an animal to a kennel
     */
    public void execute()
    {
        String animalID = IOAccess.getInstance().readString("-------Assigning a kennel to an animal-------\nEnter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is such animal with ID " + animalID);
        }

        if (anim.getAssignedKennel() != -1)
        {
            throw new IllegalStateException("Animal " + animalID + " is already assigned a kennel");
        }

        int kennelNumber = IOAccess.getInstance().readInt("Enter the kennel label for the animal: ");

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
}
