/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Starter file for Assignment 5
 */

/**
 * Run the tests for the classes in the system
 */
public class RunTests {

    public static void main(String[] args) {
        System.out.print("Testing class Person...\t");
        Person.main(args);
        System.out.print("Testing class BasicStaff...\t");
        BasicStaff.main(args);
        System.out.print("Testing class Animal...\t");
        Animal.main(args);
        System.out.print("Testing class Manager...\t");
        Manager.main(args);
        System.out.print("Testing class StaffMember...\t");
        StaffMember.main(args);
        System.out.print("Testing class PetStore...\t");
        PetStore.main(args);
        System.out.println("Done!");
    }
}
