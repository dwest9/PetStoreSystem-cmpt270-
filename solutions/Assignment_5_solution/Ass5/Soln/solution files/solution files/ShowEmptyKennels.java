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

import java.util.LinkedList;

public class ShowEmptyKennels implements Command
{
    /**
     * Executes the command - Display all empty kennels in the store
     */
    public void execute()
    {
        LinkedList<Integer> kennels = PetStoreAccess.getInstance().availableKennels();

        String result = "";
        if (kennels.size() == 0)
        {
            result = "No Empty Kennels";
        } else
        {
            for (Integer i : kennels)
            {
                result = result + i + " ";
            }
            result = result + "\n";
        }

        IOAccess.getInstance().outputString("-------Showing available kennels-------\n" + result);
    }
}
