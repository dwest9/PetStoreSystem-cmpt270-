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

import containers.ResidenceAccess;
import containers.StudentMapAccess;
import entities.Student;
import interfaces.IOAccess;

import java.util.NoSuchElementException;

public class ReleaseStudent extends CommandStatus implements Command {

    /**
     * Checkout a student from the residence.
     */
    public void execute() {

        Student p = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        successful =true;
        // check the SIN is valid
        if (p == null){
            successful = false;
            errorMessage = "There is no student with social insurance number " + cmdArgument.sSIN;
        }

        int bed = p.getBedLabel();
        // check that the student was actually assigned a bed
        if (bed == -1) {
            successful = false;
            errorMessage = "No bed was assigned to student " + cmdArgument.sSIN;
            throw new NoSuchElementException( "No bed was assigned to student "
                    + cmdArgument.sSIN );
        }

        // check that the bed is actually assigned to the student
        if (ResidenceAccess.getInstance().getStudent(bed) != p) {
            successful = false;
            errorMessage = "Student " + cmdArgument.sSIN + " recorded in bed "
                    + bed + ", but Residence has student " + ResidenceAccess.getInstance().getStudent(bed).getSIN() + " there.";
        }

        // free the bed
        ResidenceAccess.getInstance().freeBed(bed);
        p.setBedLabel(-1);
    }

}
