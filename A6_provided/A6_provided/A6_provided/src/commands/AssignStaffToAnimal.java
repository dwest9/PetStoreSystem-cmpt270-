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

public class AssignStaffToAnimal extends CommandStatus implements Command
{
    /**
     * Executes the command - Assign a staff member to an animal, and the animal to the staff member
     */
    public void execute()
    {
        Animal anim = AnimalMapAccess.getInstance().get(cmdArgument.aPetID);
        if (anim == null)
        {
            successful = false;
            errorMessage = "There is no animal with ID " + cmdArgument.aPetID;
            return;
        }

        StaffMember staff = StaffMapAccess.getInstance().get(cmdArgument.sID);
        if (staff == null)
        {
            successful = false;
            errorMessage = "There is no staff with the ID " + cmdArgument.sID;
            return;
        }

        if (anim.hasStaff(staff.getEmployeeID()) || staff.hasAnimal(anim.getAnimalID()))
        {
            successful = false;
            errorMessage = "Association already exists between  " + cmdArgument.sID + " and " + cmdArgument.aPetID;
        }
        else
        {
            anim.addStaff(staff);
            staff.assignAnimal(anim);
            successful = true;
        }
    }

}
