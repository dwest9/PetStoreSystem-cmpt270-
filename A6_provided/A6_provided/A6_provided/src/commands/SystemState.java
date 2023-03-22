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
import entities.*;

import java.util.Collection;

public class SystemState extends CommandStatus implements Command
{
    /**
     * Executes the command - Display the current state of the system
     */
    public void execute()
    {
        String result = "\nThe animals in the system are \n";
        Collection<Animal> animalCollection = AnimalMapAccess.getInstance().values();
        for (Animal animal : animalCollection)
        {
            result = result + animal;
        }
        result = result + "\nThe staff in the system are \n";
        Collection<StaffMember> staffMemberCollection = StaffMapAccess.getInstance().values();
        for (StaffMember staff : staffMemberCollection)
        {
            result = result + staff;
        }
        result = result + "\nThe store is " + PetStoreAccess.getInstance();
        IOAccess.getInstance().outputString(result);
    }
}
