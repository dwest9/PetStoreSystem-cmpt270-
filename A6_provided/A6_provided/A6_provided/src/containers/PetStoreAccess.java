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

import entities.PetStore;

/**
 * Singleton class for managing access to the PetStore
 */
public class PetStoreAccess
{
    /**
     * The single instance of the PetStore class
     */
    private static PetStore storeInstance = null;

    /**
     * This method initializes the store with the required values
     * @param storeName - the name of the PetStore
     * @param fLabel    - the first kennel label of the store
     * @param lLabel    - the last kennel label of the store
     */
    public static void initialize(String storeName, int fLabel, int lLabel)
    {
        if (storeInstance != null)
        {
            throw new IllegalStateException("Not allowed to reinitialize the pet store");
        }
        storeInstance = new PetStore(storeName, fLabel, lLabel);
    }

    /**
     * Empty and private constructor
     */
    private PetStoreAccess()
    {
    }

    /**
     * THis method return the single instance of the PetStore
     * @return the instance of the PetStore
     */
    public static PetStore getInstance()
    {
        if (storeInstance == null)
        {
            throw new IllegalStateException("Pet store has not yet been initialized.");
        }

        return storeInstance;
    }

}

