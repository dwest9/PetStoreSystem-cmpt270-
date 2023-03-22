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

public class DropAssociation implements Command
{
    /**
     * Executes the command - Remove the animal-staff association
     */
    public void execute()
    {
        String animalID = IOAccess.getInstance().readString("-------Removing staff-animal association-------\nEnter the animalID of the animal: ");

        // check if animal exists in system
        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("No such animal with ID " + animalID);
        }

        String staffID = IOAccess.getInstance().readString("Enter the employee number of the staff member: ");

        // check if the staff exists in the system
        StaffMember staffMember = StaffMapAccess.getInstance().get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff member with ID " + staffID);
        }

        // make sure returned animal's ID matches input animal ID
        String returnedAnimalsID = anim.getAnimalID();
        if (!animalID.equals(returnedAnimalsID))
        {
            throw new IllegalStateException("Animal IDs are not equal: " + animalID + " " + returnedAnimalsID);
        }

        // check if the staff member is assigned to the animal
        if (!staffMember.hasAnimal(returnedAnimalsID))
        {
            throw new IllegalStateException("Staff Member is not associated with animal:" + returnedAnimalsID);
        }

        // check if the animal is assigned to the staff member
        if (!anim.hasStaff(staffID))
        {
            throw new IllegalStateException("Animal is not associated with staff member:" + staffID);
        }

        // Animal and staff member are both properly associated, so remove the association
        anim.removeStaff(staffID);
        staffMember.removeAnimal(animalID);
    }
}
