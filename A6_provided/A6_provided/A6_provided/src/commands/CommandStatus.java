package commands;
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

/**
 * The common ancestor for all commands that records whether the last execution of the command was
 * successful, and if not, records the error message.
 */
public class CommandStatus
{

    /**
     * An object that holds values of the arguments  of a command
     */
    protected CommandArguments cmdArgument;

    /**
     * Specification of whether or not the command was successfully executed.
     */
    protected boolean successful = false;

    /**
     * If the command was not successful, an appropriate error message.
     */
    protected String errorMessage;

    /**
     * Was the last execution of this command successful?
     * @return the successful status from the last execution
     */
    public boolean wasSuccessful()
    {
        return successful;
    }

    /**
     * Return the error message from the last execution of the command.
     * @return the errorMessage
     * @precond ! wasSuccessful()
     */
    public String getErrorMessage()
    {
        if (wasSuccessful())
        {
            throw new RuntimeException("The last execution must have been "
                    + "unsuccessful in order to retrieve its error message.");
        }
        return errorMessage;
    }

    /**
     * Sets the values of the command arguments for its execution .
     * @param commandArguments contains the values of the arguments of a command
     */

    public void setCommnadArguments(CommandArguments commandArguments)
    {

        this.cmdArgument = new CommandArguments();

        //For adding a new member of the staff
        if (commandArguments.sFirstName != null)
        {
            cmdArgument.sFirstName = commandArguments.sFirstName;
        }
        if (commandArguments.sLastName != null)
        {
            cmdArgument.sLastName = commandArguments.sLastName;
        }
        if (commandArguments.sSIN != null)
        {
            cmdArgument.sSIN = commandArguments.sSIN;
        }
        if (commandArguments.sID != null)
        {
            cmdArgument.sID = commandArguments.sID;
        }
        if (commandArguments.response != null)
        {
            cmdArgument.response = commandArguments.response;
        }

        //for adding a new animal
        if (commandArguments.aName != null)
        {
            cmdArgument.aName = commandArguments.aName;
        }
        if (commandArguments.aType != null)
        {
            cmdArgument.aType = commandArguments.aType;
        }
        if (commandArguments.aPetID != null)
        {
            cmdArgument.aPetID = commandArguments.aPetID;
        }

        //for creating a new store
        if (commandArguments.stName != null)
        {
            cmdArgument.stName = commandArguments.stName;
        }
        if (commandArguments.maxKennelLabel != 0)
        {
            cmdArgument.maxKennelLabel = commandArguments.maxKennelLabel;
        }
        if (commandArguments.minKennelLabel != 0)
        {
            cmdArgument.minKennelLabel = commandArguments.minKennelLabel;
        }
        if (commandArguments.kennelNum != 0)
        {
            cmdArgument.kennelNum = commandArguments.kennelNum;
        }

    }
}
