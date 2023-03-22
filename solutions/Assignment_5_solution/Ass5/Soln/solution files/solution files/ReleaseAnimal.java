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

public class ReleaseAnimal implements Command
{
    /**
     * Executes the command - Removes an animal-kennel association - does not remove the animal from the pet store system
     */
    public void execute()
    {
        String animalID = IOAccess.getInstance().readString("-------Releasing an animal from a kennel-------\nEnter the ID of the animal to release: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        // see if the animalID is valid
        if (anim == null)
        {
            throw new NoSuchElementException("No such animal with ID " + animalID + " exists");
        }

        int kennel = anim.getAssignedKennel();

        // check if the animal is properly assigned a kennel
        if (kennel == -1)
        {
            throw new NoSuchElementException("No kennel was assigned to animal: " + animalID);
        }

        // check if the kennel was properly assigned to the animal
        if (PetStoreAccess.getInstance().getAnimal(kennel) != anim)
        {
            throw new IllegalStateException(animalID + " recorded in kennel " + kennel + ", but different animal " + PetStoreAccess.getInstance().getAnimal(kennel).getAnimalID() + " is there.");
        }

        // free the kennel, and set animals kennel number to -1 (no set kennel)
        PetStoreAccess.getInstance().freeKennel(kennel);
        anim.setAssignedKennel(-1);
    }
}
