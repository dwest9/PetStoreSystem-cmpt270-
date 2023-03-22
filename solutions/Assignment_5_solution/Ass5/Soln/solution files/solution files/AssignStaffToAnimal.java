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

public class AssignStaffToAnimal implements Command
{
    /**
     * Executes the command - Assign a staff member to an animal, and the animal to the staff member
     */
    public void execute()
    {
        String animalID = IOAccess.getInstance().readString("-------Assigning staff to an animal-------\nEnter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is no such animal with ID  " + animalID);
        }

        String staffID = IOAccess.getInstance().readString("Enter the employee number of the staff member: ");
        StaffMember staffMember = StaffMapAccess.getInstance().get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff with employee ID " + staffID);
        } else
        {
            anim.addStaff(staffMember);
            staffMember.assignAnimal(anim);
        }
    }

}
