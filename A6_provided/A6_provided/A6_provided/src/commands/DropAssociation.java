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

public class DropAssociation extends CommandStatus implements Command
{
    /**
     * Executes the command - Remove the animal-staff association
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
            errorMessage = "There is no staff with ID " + cmdArgument.sID;
            return;
        }

        String animalID = anim.getAnimalID();
        if (!staff.hasAnimal(animalID))
        {
            successful = false;
            errorMessage = "This staff member is not associated with this animal.";
            return;
        }
        if (!anim.hasStaff(cmdArgument.sID))
        {
            successful = false;
            errorMessage = "This staff member and this animal are incorrectly associated. (Association mismatch)";
            return;
        }
        if (staff.hasAnimal(animalID) && anim.hasStaff(cmdArgument.sID))
        {
            anim.removeStaff(cmdArgument.sID);
            staff.removeAnimal(cmdArgument.aPetID);
            successful = true;
        }
    }
}
