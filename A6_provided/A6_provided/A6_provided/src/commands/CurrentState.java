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

import containers.StaffMapAccess;
import containers.PetStoreAccess;
import containers.AnimalMapAccess;

import java.util.Collection;

import entities.StaffMember;
import entities.Animal;

/**
 * Command to obtain a String representation of the current state of the system. The current state
 * is placed in the curState field.
 */
public class CurrentState extends CommandStatus implements Command
{
    /**
     * A string containing the current state of the system.
     */
    private String curState;

    /**
     * Obtain the current state of the system and place the string in curState.
     */
    public void findCurState()
    {
        curState = "\nThe animals in the system are \n";
        Collection<Animal> animals = AnimalMapAccess.getInstance().values();
        for (Animal anim : animals)
        {
            curState = curState + anim;
        }
        curState = curState + "\nThe staff in the system are \n";
        Collection<StaffMember> staff = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staff)
        {
            curState = curState + stf;
        }
        curState = curState + "\nThe pet store is " + PetStoreAccess.getInstance();
        successful = true;
    }

    /**
     * Return a string containing the state of the system.
     * @return a string containing the state of the system
     * @precond wasSuccessful()
     */
    public String getCurState()
    {
        if (!wasSuccessful())
        {
            throw new RuntimeException("The method findCurState() must be "
                    + "invoked before this method");
        }
        return curState;
    }

    @Override
    public void execute()
    {
        curState = "\nThe animals in the system are \n";
        Collection<Animal> animals = AnimalMapAccess.getInstance().values();
        for (Animal anim : animals)
        {
            curState = curState + anim;
        }
        curState = curState + "\nThe staff in the system are \n";
        Collection<StaffMember> staff = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staff)
        {
            curState = curState + stf;
        }
        curState = curState + "\nThe store is " + PetStoreAccess.getInstance();
        successful = true;
    }
}
