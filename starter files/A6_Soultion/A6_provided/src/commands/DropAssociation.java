package commands;/*
  CMPT 270 Course Material
  Copyright (c) 2021
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.


 */

import containers.ManagerMapAccess;
import containers.StudentMapAccess;
import entities.Manager;
import entities.Student;
import interfaces.IOAccess;

import java.util.NoSuchElementException;

public class DropAssociation extends CommandStatus implements Command {

    /**
     * Drop the association between a manager and a student.
     */
    public void execute() {

        //String sSIN = IOAccess.getInstance().readString("Enter the social insurance number of the student: ");

        Student st = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        if (st == null) {
            successful = false;
            errorMessage = "There is no student with social insurance number "
                    + cmdArgument.sSIN ;
//            throw new NoSuchElementException( "There is no student with social insurance number "
//                    + sSIN );
        }
       // String name = IOAccess.getInstance().readString("Enter the name of the manager: ");


            Manager mgr = ManagerMapAccess.getInstance().get( cmdArgument.mEN );
            if (mgr == null) {
                successful = false;
                errorMessage = "There is no manager with name " + cmdArgument.mEN;
                //throw new NoSuchElementException( "There is no manager with name " + name );
                return;
            }


        String pNSID = st.getNSID();
        if (!mgr.hasStudent(pNSID)) {
            successful = false;
            errorMessage = "This manager is not associated with this student.";
//            throw new IllegalStateException( "This manager is not associated with this student." );
            return;
        }
        if (!st.hasManager(cmdArgument.mName)) {
            successful = false;
            errorMessage = "This manager and this student are incorrectly "
                    + "associated.  The manager has the student, "
                    + "but the student does not have the manager";
            return;
        }
        if(mgr.hasStudent(pNSID) && st.hasManager(cmdArgument.mName) ) {
            st.removeManager( cmdArgument.mName );
            mgr.removeStudent( pNSID);
            successful=true;
        }
    }


}
