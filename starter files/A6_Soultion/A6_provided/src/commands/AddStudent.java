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

import containers.StudentMapAccess;
import entities.Student;

public class AddStudent extends CommandStatus implements Command {

    /**
     * Read the information for a new student and then add the student
     * to the dictionary of all students.
     */
    public void execute() {
        // before adding the student, check if one exists with the same SIN

        if (StudentMapAccess.getInstance().containsKey(cmdArgument.sSIN)) {
            successful=false;
            errorMessage= "Student with the social insurance number " + cmdArgument.sSIN + " already exists";
        }
        // create the Student object and put it in the StudentMap
        Student st = new Student(cmdArgument.sName, cmdArgument.sSIN, cmdArgument.sNSID);
        Student result = StudentMapAccess.getInstance().put(cmdArgument.sSIN, st);
        // checking to make sure the key was unique
        if (result != null) {
            // if put() returns a reference, then a student was already stored with the same SIN,
            // so put it back, and signal an error.
            StudentMapAccess.getInstance().put(cmdArgument.sSIN, result);  // put the original student back
            successful=false;
            errorMessage = "SIN in the student dictionary even "
                    + "though containsKey failed.  Student " + cmdArgument.sName + " not entered.";
        }else
            successful=true;
    }

}
