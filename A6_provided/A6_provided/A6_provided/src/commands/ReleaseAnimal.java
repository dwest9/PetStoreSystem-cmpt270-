package commands;
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

import containers.*;
import entities.*;

import java.util.NoSuchElementException;

public class ReleaseAnimal extends CommandStatus implements Command
{
    /**
     * Executes the command - Removes an animal-kennel association - does not remove the animal from the pet store system
     */
    public void execute()
    {

        Animal animal = AnimalMapAccess.getInstance().get(cmdArgument.aPetID);
        successful = true;
        // check the ID is valid
        if (animal == null)
        {
            successful = false;
            errorMessage = "There is no animal with ID " + cmdArgument.aPetID;
        }

        int kennel = animal.getAssignedKennel();
        // check that the animal was actually assigned to a kennel
        if (kennel == -1)
        {
            successful = false;
            errorMessage = "No kennel was assigned to the animal " + cmdArgument.aPetID;
            throw new NoSuchElementException("No kennel was assigned to animal " + cmdArgument.aPetID);
        }

        // check that the kennel is actually assigned to the animal
        if (PetStoreAccess.getInstance().getAnimal(kennel) != animal)
        {
            successful = false;
            errorMessage = "Animal " + cmdArgument.aPetID + " recorded in kennel " + kennel + ", but store has animal " + PetStoreAccess.getInstance().getAnimal(kennel).getAnimalID() + " there.";
        }

        // free the kennel
        PetStoreAccess.getInstance().freeKennel(kennel);
        animal.setAssignedKennel(-1);
    }
}
