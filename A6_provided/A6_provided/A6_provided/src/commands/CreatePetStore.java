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

import containers.PetStoreAccess;

/**
 * The command that creates and initializes the one instance of a pet store
 */
public class CreatePetStore extends CommandStatus implements Command
{

    /**
     * Executes the command - Creates a new instance of the pet store
     */
    public void execute()
    {

        if (cmdArgument.stName == null || cmdArgument.stName.equals(""))
        {
            successful = false;
            errorMessage = "The name of a new store cannot be null or empty.  " + "It is " + cmdArgument.stName;
            return;
        }
        if (cmdArgument.minKennelLabel < 0 || cmdArgument.maxKennelLabel < cmdArgument.minKennelLabel)
        {
            successful = false;
            errorMessage =
                    "The kennel indices " + cmdArgument.minKennelLabel + " and " + cmdArgument.maxKennelLabel
                            + " are invalid as they cannot be negative and include at least one kennel.";
            return;
        }

        try
        {
            PetStoreAccess.initialize(cmdArgument.stName, cmdArgument.minKennelLabel, cmdArgument.maxKennelLabel);
            successful = true;
        }
        catch (RuntimeException e)
        {
            successful = false;
            errorMessage = e.getMessage();
        }

    }


}
