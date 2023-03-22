// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.*;
/**
 * A simple Pet Store management system with only one store.  Animals and staff can be created,
 * and animals assigned to a staff/managers and/or assigned to a kennel within the store.
 */

public class PetStoreSystema5q6 {

    /**
     * this runs the petstoresystem
     * @param args
     */
    public static void main(String[] args) {
        IOAccess.getInstance().outputString("-------Getting Pet Store information-------");
        IOAccess.getInstance().outputString("Initializing the system...\n");

        Command[] commands = new Command[9];
        String[] choice = new String[9];      // a corresponding array of choices



        while (true) {
            // keep trying until the user enters the data correctly
            try {
                // get the required pet store info

                String name = IOAccess.getInstance().readString("Enter the name of the store: ");

                int firstKennelNumber = IOAccess.getInstance().readInt("Enter the integer label for the first kennel: ");

                int lastKennelNumber = IOAccess.getInstance().readInt("Enter the integer label for the last kennel: ");

                PetStoreAccess.intialize(name, firstKennelNumber, lastKennelNumber);
                break;
            } catch (RuntimeException e) {
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }

        // this sets up the commands!
        choice[0] = "Quit";
        commands[0] = new SystemState();

        choice[1] = "Add a new animal to system";
        commands[1] = new AddAnimal();

        choice[2] = "Add a new staff member to system";
        commands[2] = new AddStaff();

        choice[3] = "Assign a staff member to an animal";
        commands[3] = new AssignStaffToAnimal();

        choice[4] = "Display the empty kennels in the store";
        commands[4] = new ShowEmptyKennels();

        choice[5] = "Assign an animal to a kennel";
        commands[5] = new AssignKennel();

        choice[6] = "Release an animal";
        commands[6] = new ReleaseAnimal();

        choice[7] = "Remove staff-animal association";
        commands[7] = new DropAssociation();

        choice[8] = "Show current system state";
        commands[8] = new SystemState();

        int task = -1;
        while (task != 0) {
            try {
                task = IOAccess.getInstance().readChoice(choice);
                commands[task].execute();
            } catch (RuntimeException e) {
                // No matter what  exception is thrown, this catches it
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }

        IOAccess.getInstance().outputString("-------System terminated-------");


    }


}
