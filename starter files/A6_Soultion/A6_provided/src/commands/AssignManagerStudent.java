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

public class AssignManagerStudent extends  CommandStatus implements Command {

    /**
     * Assign a manager to take care of a student.
     */
    public void execute() {


        Student st = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        if (st == null) {
            successful = false;
            errorMessage = "There is no student with social insurance number " + cmdArgument.sSIN;
        }

        Manager mgr = ManagerMapAccess.getInstance().get(cmdArgument.mEN);

        if (mgr == null) {
            successful=false;
            errorMessage= "There is no manager with the employee id " + cmdArgument.mEN;
        }
        else {
            st.addManager(mgr);
            mgr.addStudent(st);
            successful=true;
        }
    }


}
