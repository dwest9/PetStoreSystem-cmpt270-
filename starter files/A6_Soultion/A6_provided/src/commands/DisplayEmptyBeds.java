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
import interfaces.IOAccess;

import java.util.LinkedList;

public class DisplayEmptyBeds extends CommandStatus implements Command {
    /**
     * Display the empty beds for the residence.
     */
    public void execute() {
        LinkedList<Integer> beds = ResidenceAccess.getInstance().availableBeds();

        if (beds.size() == 0) {

            IOAccess.getInstance().outputString("No beds available!");
        } else {
            IOAccess.getInstance().outputString("Available beds: " + ResidenceAccess.getInstance().availableBeds());
        }
    }

    public static void main(String[] args) {
        Command cmd = new DisplayEmptyBeds();
        cmd.execute();
    }
}
