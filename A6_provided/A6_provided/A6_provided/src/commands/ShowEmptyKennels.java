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

import interfaces.*;
import containers.*;

import java.util.LinkedList;

public class ShowEmptyKennels extends CommandStatus implements Command
{
    /**
     * Executes the command - Display all empty kennels in the store
     */
    public void execute()
    {
        LinkedList<Integer> kennels = PetStoreAccess.getInstance().availableKennels();

        if (kennels.size() == 0)
        {
            IOAccess.getInstance().outputString("No kennels available!");
        } else
        {
            IOAccess.getInstance().outputString("Available kennels: " + PetStoreAccess.getInstance().availableKennels());
        }
    }
}
