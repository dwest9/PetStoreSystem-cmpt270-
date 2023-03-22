package containers;/*
  CMPT 270 Course Material
  Copyright (c) 2021
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.


 */

import entities.Manager;

import java.util.TreeMap;

public class ManagerMapAccess {
    private static TreeMap<String, Manager> instance = null;

    private ManagerMapAccess() {
    }

    public static TreeMap<String, Manager> getInstance() {
        if (instance == null)
            instance = new TreeMap<String, Manager>();
        return instance;
    }

}
