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

public class AssignKennel extends CommandStatus implements Command
{
    /**
     * Executes the command - Assign an animal to a kennel
     */
    public void execute()
    {

        Animal anim = AnimalMapAccess.getInstance().get(cmdArgument.aPetID);
        if (anim == null)
        {
            successful = false;
            errorMessage = "There is no animal with ID " + cmdArgument.aPetID;
        } else if (anim.getAssignedKennel() != -1)
        {
            successful = false;
            errorMessage = " Animal " + anim + " is already in a kennel, so cannot be assigned to one.";
        } else if (cmdArgument.kennelNum < PetStoreAccess.getInstance().getMinKennelLabel() || cmdArgument.kennelNum > PetStoreAccess.getInstance().getMaxKennelLabel())
        {
            successful = false;
            errorMessage = "Kennel label " + cmdArgument.kennelNum + " is not valid, as the value must be between " + PetStoreAccess.getInstance().getMinKennelLabel()
                    + " and " + PetStoreAccess.getInstance().getMaxKennelLabel();
        } else if (PetStoreAccess.getInstance().isOccupied(cmdArgument.kennelNum))
        {
            successful = false;
            errorMessage = "There is already another animal in that kennel.";
        } else
        {
            anim.setAssignedKennel(cmdArgument.kennelNum);
            PetStoreAccess.getInstance().assignAnimalToKennel(anim, cmdArgument.kennelNum);
            successful = true;
        }
    }
}
