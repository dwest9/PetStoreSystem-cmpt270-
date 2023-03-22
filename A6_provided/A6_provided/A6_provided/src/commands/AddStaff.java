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

public class AddStaff extends CommandStatus implements Command
{
    /**
     * Executes the command - Reads info for a new staff member, and adds them to dictionary of all staff
     */
    public void execute()
    {

        if (cmdArgument.sFirstName == null || cmdArgument.sFirstName.equals(""))
        {
            successful = false;
            errorMessage = "The first name of a new staff member cannot be null or empty.";
            return;
        }
        if (cmdArgument.sLastName == null || cmdArgument.sLastName.equals(""))
        {
            successful = false;
            errorMessage = "The last name of a new staff member cannot be null or empty.";
            return;
        }
        if (cmdArgument.sSIN == null || cmdArgument.sSIN.equals(""))
        {
            successful = false;
            errorMessage = "The staff members SIN cannot be null or empty.";
            return;
        }
        if (cmdArgument.sID == null || cmdArgument.sID.equals(""))
        {
            successful = false;
            errorMessage = "The staff members employee ID cannot be null or empty.";
            return;
        }

        // before adding the staff member, check if one exists with the same employee ID
        if (StaffMapAccess.getInstance().containsKey(cmdArgument.sID))
        {
            successful = false;
            errorMessage = "Staff not added as there already is a staff member with the Employee Number " + cmdArgument.sID;
        }

        StaffMember stf;
        if (cmdArgument.response.charAt(0) == 'y' || cmdArgument.response.charAt(0) == 'Y')
        {
            stf = new Manager(cmdArgument.sFirstName, cmdArgument.sLastName, cmdArgument.sSIN, cmdArgument.sID);
        } else
        {
            stf = new StaffMember(cmdArgument.sFirstName, cmdArgument.sLastName, cmdArgument.sSIN, cmdArgument.sID);
        }

        // put the staff member in the map
        StaffMember sameIDStaff = StaffMapAccess.getInstance().put(cmdArgument.sID, stf);
        if (sameIDStaff != null)
        {
            // if put() returns a reference, then a staff member was already stored with the same EN,
            // so put it back, and signal an error.
            StaffMapAccess.getInstance().put(cmdArgument.sID, sameIDStaff); // put the original manager back
            successful = false;
            errorMessage = "Employee number in the staff dictionary already even though containsKey failed.  Staff " + cmdArgument.sFirstName + " not entered.";
        } else
        {
            successful = true;
        }
    }

}
