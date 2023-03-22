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
import containers.ResidenceAccess;
import containers.StudentMapAccess;
import entities.Manager;
import entities.Student;
import interfaces.IOAccess;

import java.util.Collection;

public class SystemState implements Command {

    /**
     * Displays the system state
     */
    public void execute() {
        String result = "\nThe students in the system are \n";
        Collection<Student> studentsColl = StudentMapAccess.getInstance().values();
        for (Student p : studentsColl)
            result = result + p;
        result = result + "\nThe managers in the system are \n";
        Collection<Manager> managersColl = ManagerMapAccess.getInstance().values();
        for (Manager mgr : managersColl)
            result = result + mgr;
        result = result + "\nThe residence is " + ResidenceAccess.getInstance();
        IOAccess.getInstance().outputString(result);
    }
}
