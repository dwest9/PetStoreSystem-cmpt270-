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


import entities.Residence;

public class ResidenceAccess {
    private static Residence instance = null;

    private ResidenceAccess() {
    }

    public static Residence getInstance() {
        if (instance == null)
            throw new IllegalStateException("Singleton residence accessed before initialization");
        return instance;
    }

    public static void initialize(String name, int minBedLabel, int maxBedLabel) {
        if (instance != null) {
            throw new IllegalStateException("Not allowed to reinitialize the residence");
        }
        instance = new Residence(name, minBedLabel, maxBedLabel);
    }
}
