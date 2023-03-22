package commands;

import containers.ResidenceAccess;
import entities.Residence;

/**
 * The command to create and initialize the one instance of Ward.
 */
public class CreateResidence extends CommandStatus implements Command{

    @Override
    public void execute() {

        if (cmdArgument.rName == null || cmdArgument.rName.equals("")) {
            successful = false;
            errorMessage = "The name of a ward cannot be null or empty.  " + "It is " + cmdArgument.rName;
            return;
        }
        if (cmdArgument.minBedLabel < 0 || cmdArgument.maxBedLabel < cmdArgument.minBedLabel) {
            successful = false;
            errorMessage =
                    "The bed indices " + cmdArgument.minBedLabel + " and " + cmdArgument.maxBedLabel
                            + " are invalid as they cannot be negative "
                            + "and include at least one bed.";
            return;
        }

        try {
            ResidenceAccess.initialize(cmdArgument.rName, cmdArgument.minBedLabel, cmdArgument.maxBedLabel);
            successful = true;
        } catch (RuntimeException e) {
            successful = false;
            errorMessage = e.getMessage();
        }

    }


}
