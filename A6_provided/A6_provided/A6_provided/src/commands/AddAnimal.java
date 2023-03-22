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

public class AddAnimal extends CommandStatus implements Command
{
    /**
     * Read the information for a new animal, then adds the animal to the animal map
     */
    public void execute()
    {

        if (cmdArgument.aName == null || cmdArgument.aName.equals(""))
        {
            successful = false;
            errorMessage = "The name of a new animal cannot be null or empty.";
            return;
        }
        if (cmdArgument.aType == null || cmdArgument.aType.equals(""))
        {
            successful = false;
            errorMessage = "The animal type cannot be null or empty.";
            return;
        }
        if (cmdArgument.aPetID == null || cmdArgument.aPetID.equals(""))
        {
            successful = false;
            errorMessage = "The animal ID cannot be null or empty.";
            return;
        }

        // before adding the new animal, check if one exists with the same SIN
        if (AnimalMapAccess.getInstance().containsKey(cmdArgument.aPetID))
        {
            successful = false;
            errorMessage = "Animal with the ID " + cmdArgument.aPetID + " already exists";
        }
        // create the animal object and put it in the AnimalMap
        Animal st = new Animal(cmdArgument.aName, cmdArgument.aPetID, cmdArgument.aType);
        Animal result = AnimalMapAccess.getInstance().put(cmdArgument.aPetID, st);
        // checking to make sure the key was unique
        if (result != null)
        {
            // if put() returns a reference, then an animal was already there with the same ID,
            // so put it back, and signal an error.
            AnimalMapAccess.getInstance().put(cmdArgument.aPetID, result);  // put the original animal back
            successful = false;
            errorMessage = "AnimalID in the animal map even "
                    + "though containsKey failed.  Animal " + cmdArgument.aName + " not entered.";
        } else
        {
            successful = true;
        }
    }


}
