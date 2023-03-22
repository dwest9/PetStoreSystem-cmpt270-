package commands;

/**
 * The common ancestor for all commands that records whether the last execution of the command was
 * successful, and if not, records the error message.
 */

public class CommandStatus {

    /** An object that holds values of the arguments  of a command */

     protected CommandArguments cmdArgument;

    /** Specification of whether or not the command was successfully executed. */
    protected boolean successful = false;

    /** If the command was not successful, an appropriate error message. */
    protected String errorMessage;

    /**
     * Was the last execution of this command successful?
     *
     * @return the successful status from the last execution
     */
    public boolean wasSuccessful() {
        return successful;
    }

    /**
     * Return the error message from the last execution of the command.
     *
     * @precond ! wasSuccessful()
     * @return the errorMessage
     */
    public String getErrorMessage() {
        if (wasSuccessful())
            throw new RuntimeException("The last execution must have been "
                    + "unsuccessful in order to retrieve its error message.");
        return errorMessage;
    }

    /**
     * Sets the values of the command arguments for its execution .
     *
     * @param commandArguments contains the values of the arguments of a command
     */

    public void setCommnadArguments(CommandArguments commandArguments) {

        this.cmdArgument = new CommandArguments();

//For adding mamager
        if (commandArguments.mName != null)
            cmdArgument.mName = commandArguments.mName;
        if (commandArguments.mSIN != null)
            cmdArgument.mSIN = commandArguments.mSIN;
        if (commandArguments.mEN != null)
            cmdArgument.mEN = commandArguments.mEN;
        if (commandArguments.response != null)
            cmdArgument.response = commandArguments.response;
//for adding student
        if (commandArguments.sName != null)
            cmdArgument.sName = commandArguments.sName;
        if (commandArguments.sSIN != null)
            cmdArgument.sSIN = commandArguments.sSIN;
        if (commandArguments.sNSID != null)
            cmdArgument.sNSID = commandArguments.sNSID;
//for creating residence

        if (commandArguments.rName != null)
            cmdArgument.rName = commandArguments.rName;
        if (commandArguments.maxBedLabel != 0)
            cmdArgument.maxBedLabel = commandArguments.maxBedLabel;
        if (commandArguments.minBedLabel != 0)
            cmdArgument.minBedLabel = commandArguments.minBedLabel;
        if (commandArguments.bedNum != 0)
            cmdArgument.bedNum = commandArguments.bedNum;

    }
}
