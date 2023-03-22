package containers;
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

import entities.StaffMember;

import java.util.TreeMap;

public class StaffMapAccess
{
    /**
     * The single instance of the treemap that holds the staff
     */
    private static TreeMap<String, StaffMember> instance = null;

    /**
     * The empty and private constructor for this class
     */
    private StaffMapAccess()
    {
    }

    /**
     * THis method returns the single instance of the staff treemap
     * @return the instance of the staff treemap
     */
    public static TreeMap<String, StaffMember> getInstance()
    {
        if (instance == null)
        {
            instance = new TreeMap<String, StaffMember>();
        }
        return instance;
    }
}
