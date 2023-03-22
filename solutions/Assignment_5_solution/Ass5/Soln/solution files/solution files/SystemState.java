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

import java.util.Collection;

public class SystemState implements Command
{
    /**
     * Executes the command - Display the current state of the system
     */
    public void execute()
    {
        String result = "\nThe animals in the system are:\n";
        Collection<Animal> animalsCollection = AnimalMapAccess.getInstance().values();
        for (Animal anim : animalsCollection)
        {
            result = result + anim + "\n";
        }

        result = result + "-------\nThe staff members in the system are:\n";
        Collection<StaffMember> staffCollection = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staffCollection)
        {
            result = result + stf + "\n";
        }
        result = result + "-------\nThe store is " + PetStoreAccess.getInstance();

        IOAccess.getInstance().outputString("-------Showing system state-------\n" + result);
    }
}
