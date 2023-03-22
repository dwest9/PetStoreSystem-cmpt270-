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
public class PetStoreSystema5q5 {
    /**
     * One Scanner for all methods
     */
    private static InputOutputInterface consoleIn = IOAccess.getInstance();


    /**
     * Displays the list of all choices to the console.
     */
    private static String[] task_option = {
            "\tQuit",
            "\tAdd a new animal to system",
            "\tAdd a new staff member to system",
            "\tAssign a staff member to an animal",
            "\tDisplay the empty kennels in the store",
            "\tAssign an animal to a kennel",
            "\tRelease an animal",
            "\tRemove staff-animal association",
            "\tShow current system state",
    };


    /**
     * Initialize an instance of the store management system - relies on user-input
     */
    public PetStoreSystema5q5()
    {


        // get the required pet store info
        consoleIn.outputString("-------Getting Pet Store information-------");
        consoleIn.outputString("-------Initializing-------");


        String name = consoleIn.readString("Enter the name of the store: ");

        int firstKennelNumber = consoleIn.readInt("Enter the integer label for the first kennel: ");

        int lastKennelNumber = consoleIn.readInt("Enter the integer label for the last kennel: ");

        PetStoreAccess.intialize(name, firstKennelNumber, lastKennelNumber);
    }

    /**
     * Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void addAnimal()
    {
        Command con = new AddAnimal();
        con.execute();
    }

    /**
     * Read info for a new staff member, and add them to dictionary of all staff
     */
    public void addStaff()
    {
        Command con = new AddStaff();
        con.execute();
    }

    /**
     * Assign a staff member to an animal, and the animal to the staff member
     */
    public void assignStaffToAnimal()
    {
       Command con = new AssignStaffToAnimal();
       con.execute();
    }

    /**
     * Assign an animal to a kennel
     */
    public void assignKennel()
    {
        Command con = new AssignKennel();
        con.execute();
    }

    /**
     * Remove the animal-staff association
     */
    public void dropAssociation()
    {
        Command con = new DropAssociation();
        con.execute();
    }

    /**
     * Display the current state of the system
     */
    public void systemState()
    {
        Command con = new SystemState();
        con.execute();

    }

    /**
     * Display all empty kennels in the store
     */
    public void showEmptyKennels()
    {
        Command con = new ShowEmptyKennels();
        con.execute();

    }


    /**
     * Release an animal from the store
     */
    public void releaseAnimal()
    {
        Command con = new ReleaseAnimal();
        con.execute();


    }

    /**
     * Return a string representation of the PetStoreSystem
     * @return a string representation of the PetStoreSystem
     */
    public String toString()
    {
        String result = "\nThe animals in the system are:";
        Collection<Animal> animalsCollection = AnimalMapAccess.getInstance().values();
        for (Animal anim : animalsCollection)
        {
            result = result + anim;
        }

        result = result + "\n-------\nThe staff members in the system are:";
        Collection<StaffMember> staffCollection = StaffMapAccess.getInstance().values();
        for (StaffMember stf : staffCollection)
        {
            result = result + stf;
        }
        result = result + "\n-------\nThe store is " + PetStoreAccess.getInstance();
        return result;
    }

    /**
     * Run the petstoresystem.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int systemCmd = -1;
        PetStoreSystema5q5 sys;


        while (true)
        {
            // keep collection input until entered correctly
            try
            {
                sys = new PetStoreSystema5q5();
                break;
            }
            catch (RuntimeException e)
            {
                consoleIn.outputString(e.getMessage());
            }
        }

        consoleIn.outputString("-------System running-------");
        while (systemCmd != 0) {
            try {
                consoleIn.outputString("Options: ");

                systemCmd = consoleIn.readChoice(task_option);

                if (systemCmd == 0)
                {
                    sys.systemState();
                } else if (systemCmd == 1)
                {
                    sys.addAnimal();
                } else if (systemCmd == 2)
                {
                    sys.addStaff();
                } else if (systemCmd == 3)
                {
                    sys.assignStaffToAnimal();
                } else if (systemCmd == 4)
                {
                    sys.showEmptyKennels();
                } else if (systemCmd == 5)
                {
                    sys.assignKennel();
                } else if (systemCmd == 6)
                {
                    sys.releaseAnimal();
                } else if (systemCmd == 7)
                {
                    sys.dropAssociation();
                } else if (systemCmd == 8)
                {
                    sys.systemState();
                } else
                {
                    consoleIn.outputString("Invalid option, try again.");
                }
            }

            catch (RuntimeException e)
            {
                // No matter what other exception is thrown, this catches it
                // Dealing with it means discarding whatever went wrong
                // and starting the loop over.  Easy for the programmer,
                // tedious for the user.
                consoleIn.outputString(e.getMessage());
            }
        }

        consoleIn.outputString("-------System terminated-------");
    }
}