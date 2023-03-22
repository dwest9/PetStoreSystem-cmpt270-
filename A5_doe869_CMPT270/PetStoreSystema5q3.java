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
public class PetStoreSystema5q3
{
    /**
     * One Scanner for all methods
     */
    private static InputOutputInterface consoleIn = new DialogIO();

    /**
     * The keyed dictionary of all animals in the system
     */
    private Map<String, Animal> animals;

    /**
     * The keyed dictionary of all staff in the system
     */
    private Map<String, StaffMember> staff;

    /**
     * The pet store that will be managed
     */
    private PetStore petStore;


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
    public PetStoreSystema5q3()
    {

        animals = new TreeMap<String, Animal>();
        staff = new TreeMap<String, StaffMember>();

        // get the required pet store info
        consoleIn.outputString("-------Getting Pet Store information-------");

        String name = consoleIn.readString("Enter the name of the store: ");

        int firstKennelNumber = consoleIn.readInt("Enter the integer label for the first kennel: ");

        int lastKennelNumber = consoleIn.readInt("Enter the integer label for the last kennel: ");

        petStore = new PetStore(name, firstKennelNumber, lastKennelNumber);
    }

    /**
     * Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void addAnimal()
    {
        consoleIn.outputString("-------Adding Animal to PetStore-------");

        String name = consoleIn.readString("Enter the name of the animal: ");

        String animalID = consoleIn.readString("Enter the animal ID of the animal: ");

        String animalType = consoleIn.readString("Enter the type of animal: ");

        if (animals.containsKey(animalID))
        {
            throw new IllegalStateException("Animal with ID " + animalID + " already exists");
        }

        Animal anim = new Animal(name, animalID, animalType);
        Animal result = animals.put(animalID, anim);

        // checking to make sure insertion into the Map worked
        if (result != null)
        {
            animals.put(animalID, result);  // put the original animal back in
            throw new IllegalStateException("Animal was already in dictionary, even though containsKey failed. Animal " + name + " not entered.");
        }
    }

    /**
     * Read info for a new staff member, and add them to dictionary of all staff
     */
    public void addStaff()
    {
        consoleIn.outputString("-------Adding Staff to Store-------");

        String fName = consoleIn.readString("Enter the staff member's first name: ");

        String lName = consoleIn.readString("Enter the staff member's last name: ");

        String staffSIN = consoleIn.readString("Enter the staff member's SIN: ");

        String staffID = consoleIn.readString("Enter the staff member's employee ID: ");
        if (staff.containsKey(staffID))
        {
            throw new IllegalStateException("Staff not added. Already have staff with employee number " + staffID);
        }

        String response = consoleIn.readString("Is the staff member a manager? (yes or no): ");

        StaffMember newStaff;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
        {
            newStaff = new Manager(fName, lName, staffSIN, staffID);
        } else
        {
            newStaff = new StaffMember(fName, lName, staffSIN, staffID);
        }

        // check to make sure the staff employee ID doesn't already exist
        StaffMember result = staff.put(staffID, newStaff);
        if (result != null)
        {
            // if put() returns a reference, then a manager was already stored with the same EN,
            // so put it back, and signal an error.
            staff.put(staffID, result); // put the original manager back
            throw new IllegalStateException("Staff was already in dictionary, even though containsKey failed. Staff " + fName + " " + lName + " not entered.");
        }
    }

    /**
     * Assign a staff member to an animal, and the animal to the staff member
     */
    public void assignStaffToAnimal()
    {
        consoleIn.outputString("-------Assigning staff to an animal-------");
        String animalID = consoleIn.readString("Enter the animalID of the animal: ");

        Animal anim = animals.get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is no such animal with ID  " + animalID);
        }

        String staffID = consoleIn.readString("Enter the employee number of the staff member: ");
        StaffMember staffMember = this.staff.get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff with employee ID " + staffID);
        } else
        {
            anim.addStaff(staffMember);
            staffMember.assignAnimal(anim);
        }
    }

    /**
     * Assign an animal to a kennel
     */
    public void assignKennel()
    {
        consoleIn.outputString("-------Assigning a kennel to an animal-------");
        String animalID = consoleIn.readString("Enter the animalID of the animal: ");

        Animal anim = animals.get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is such animal with ID " + animalID);
        }

        if (anim.getAssignedKennel() != -1)
        {
            throw new IllegalStateException("Animal " + animalID + " is already assigned a kennel");
        }

        int kennelNumber = consoleIn.readInt("Enter the kennel label for the animal: ");

        if (kennelNumber < petStore.getMinKennelLabel() || kennelNumber > petStore.getMaxKennelLabel())
        {
            throw new IllegalArgumentException(kennelNumber + " is not a valid value. Must be between " + petStore.getMinKennelLabel() + " and " + petStore.getMaxKennelLabel());
        }

        if (petStore.isOccupied(kennelNumber))
        {
            throw new IllegalStateException("Kennel is already assigned to an animal");
        } else
        {
            anim.setAssignedKennel(kennelNumber);
            petStore.assignAnimalToKennel(anim, kennelNumber);
        }
    }

    /**
     * Remove the animal-staff association
     */
    public void dropAssociation()
    {
        consoleIn.outputString("-------Removing staff-animal association-------");
        String animalID = consoleIn.readString("Enter the animalID of the animal: ");

        // check if animal exists in system
        Animal anim = animals.get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("No such animal with ID " + animalID);
        }

        String staffID = consoleIn.readString("Enter the employee number of the staff member: ");

        // check if the staff exists in the system
        StaffMember staffMember = staff.get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff member with ID " + staffID);
        }

        // make sure returned animal's ID matches input animal ID
        String returnedAnimalsID = anim.getAnimalID();
        if (!animalID.equals(returnedAnimalsID))
        {
            throw new IllegalStateException("Animal IDs are not equal: " + animalID + " " + returnedAnimalsID);
        }

        // check if the staff member is assigned to the animal
        if (!staffMember.hasAnimal(returnedAnimalsID))
        {
            throw new IllegalStateException("Staff Member is not associated with animal:" + returnedAnimalsID);
        }

        // check if the animal is assigned to the staff member
        if (!anim.hasStaff(staffID))
        {
            throw new IllegalStateException("Animal is not associated with staff member:" + staffID);
        }

        // Animal and staff member are both properly associated, so remove the association
        anim.removeStaff(staffID);
        staffMember.removeAnimal(animalID);
    }

    /**
     * Display the current state of the system
     */
    public void systemState()
    {
        consoleIn.outputString(this.toString());
    }

    /**
     * Display all empty kennels in the store
     */
    public void showEmptyKennels()
    {
        // TODO: implement
        consoleIn.outputString("TODO: The following are the available kennels");
        LinkedList<Integer>kennels = petStore.availableKennels();

        if (kennels.size() == 0){
            consoleIn.outputString("Empty");
        }
        else {
            for (Integer kennelLabel : kennels) {
                consoleIn.outputString("kennel# " + kennelLabel);
            }
        }
    }


    /**
     * Release an animal from the store
     */
    public void releaseAnimal()
    {
        // TODO: implement

        String animalID = consoleIn.readString("Enter the animals ID: ");

        Animal animal = animals.get(animalID);

        if(animal == null){  //this checks if the animal id is valid
            throw new NoSuchElementException("There is no animal with such an ID %s".formatted(animalID));
        }

        petStore.freeKennel(animal.getAssignedKennel());
        animal.setAssignedKennel(-1);

    }

    /**
     * Return a string representation of the PetStoreSystem
     * @return a string representation of the PetStoreSystem
     */
    public String toString()
    {
        String result = "\nThe animals in the system are:";
        Collection<Animal> animalsCollection = animals.values();
        for (Animal anim : animalsCollection)
        {
            result = result + anim;
        }

        result = result + "\n-------\nThe staff members in the system are:";
        Collection<StaffMember> staffCollection = staff.values();
        for (StaffMember stf : staffCollection)
        {
            result = result + stf;
        }
        result = result + "\n-------\nThe store is " + petStore;
        return result;
    }

    /**
     * Run the residence management system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int systemCmd = -1;
        PetStoreSystema5q5 sys;

        consoleIn.outputString("-------Initializing-------");


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
                consoleIn.outputString(e.getMessage());
            }
        }

        consoleIn.outputString("-------System terminated-------");
    }
}