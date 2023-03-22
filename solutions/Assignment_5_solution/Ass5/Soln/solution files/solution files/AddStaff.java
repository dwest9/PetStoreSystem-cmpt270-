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

public class AddStaff implements Command
{
    /**
     * Executes the command - Reads info for a new staff member, and adds them to dictionary of all staff
     */
    public void execute()
    {
        String fName = IOAccess.getInstance().readString("-------Adding Staff to Store-------\nEnter the staff member's first name: ");
        String lName = IOAccess.getInstance().readString("Enter the staff member's last name: ");
        String staffSIN = IOAccess.getInstance().readString("Enter the staff member's SIN: ");
        String staffID = IOAccess.getInstance().readString("Enter the staff member's employee ID: ");
        if (StaffMapAccess.getInstance().containsKey(staffID))
        {
            throw new IllegalStateException("Staff not added. Already have staff with employee number " + staffID);
        }


        String[] yesNoChoices = {"Yes","No"};
        IOAccess.getInstance().outputString("Is the staff member a manager?");
        int selection = IOAccess.getInstance().readChoice(yesNoChoices);

        StaffMember newStaff;
        if (selection == 0)
        {
            newStaff = new Manager(fName, lName, staffSIN, staffID);
        } else
        {
            newStaff = new StaffMember(fName, lName, staffSIN, staffID);
        }

        // check to make sure the staff employee ID doesn't already exist
        StaffMember result = StaffMapAccess.getInstance().put(staffID, newStaff);
        if (result != null)
        {
            // if put() returns a reference, then a manager was already stored with the same EN,
            // so put it back, and signal an error.
            StaffMapAccess.getInstance().put(staffID, result); // put the original manager back
            throw new IllegalStateException("Staff was already in dictionary, even though containsKey failed. Staff " + fName + " " + lName + " not entered.");
        }
    }

    /**
     * Main method for performing simple testing of the command
     * @param args not used
     */
    public static void main(String[] args) {
        Command addStaff = new AddStaff();
        addStaff.execute();
        for (StaffMember stf: StaffMapAccess.getInstance().values()) {
            IOAccess.getInstance().outputString(stf.toString());
        }
    }
}
