// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.TreeMap;
import java.util.Scanner;
import java.util.*;

/**
 * This is a petstore system management for which animals and staff members are created, animals that are assigned,
 * to a staff with either with a kennel or not in the petstore
 */
public class PetStoreSystem {
    /**
     * The petstore referred to the petstoresystem
     */
    private PetStore petstore;


    /**
     * a collection of Staff members identified by their employee ID
     */
    private Map<String, StaffMember> staffmember;


    /**
     * a collection of animal identified by their animal ID
     */
    private Map<String, Animal> animals;

    /**
     * this Scanner works for all the methods implemented
     */
    private static Scanner in = new Scanner(System.in);


    /**
     * The constructor methods for PetStoreSystem with getting user inputs
     */
    public PetStoreSystem() {
        System.out.print("Enter the name of the PetStore: ");
        String name = in.nextLine();

        System.out.print("Enter the integer label of the first kennel: ");
        int firstkennel = in.nextInt();
        in.nextLine();

        System.out.print("Enter the integer label of the last kennel: ");
        int lastkennel = in.nextInt();
        in.nextLine();

        this.petstore = new PetStore(name, firstkennel, lastkennel);
        this.animals = new TreeMap<String, Animal>();
        this.staffmember = new TreeMap<String, StaffMember>();
    }

    /**
     * Adds an animal to petstore and reads the information
     */
    public void addAnimal() {
        System.out.println("** For Adding Animal To Petstore **");
        System.out.print("Enter the animal Name: ");
        String animName = in.nextLine();

        System.out.print("Enter the animalID: ");
        String animID = in.nextLine();

        System.out.print("Enter the animal type: ");
        String animType = in.nextLine();

        if (animals.containsKey(animID)) {
            throw new IllegalStateException("animal with ID " + animID + " already exists");
        }

        Animal a = new Animal(animName, animID, animType);
        animals.put(animID, a);

    }

    /**
     * This adds a staff member to the petstore and then reads the information
     */
    public void addStaff() {
        System.out.println("** For Adding Staff Member To Petstore **");
        System.out.print("Enter the staff's firstname: ");
        String fName = in.nextLine();

        System.out.print("Enter the staff's lastname: ");
        String lName = in.nextLine();

        System.out.print("Enter the staff's SIN: ");
        String sin = in.nextLine();

        System.out.print("Enter the staff's member ID: ");
        String employeeID = in.nextLine();

        if (staffmember.containsKey(employeeID)){
            throw new IllegalStateException("Staff member with employee id already exist " + employeeID);
        }

        System.out.print("Is the employee a staff member ? Y(y) or N(n): ");
        String c_input = in.nextLine();

        StaffMember staffMember;
        if (c_input.charAt(0) == 'y' || c_input.charAt(0) == 'Y') {
            staffMember = new Manager(fName, lName, sin, employeeID);

        }
        else {
            staffMember = new StaffMember(fName, lName, sin, employeeID);
        }

        // check to make sure the manager name doesn't already exist
        staffmember.put(employeeID, staffMember);
    }

    /**
     * Assigning a staff to an animal and add animal to staff list.
     */
    public void assignStaffToAnimal() {
        System.out.println("** For Assigning Staff To Animal **");
        System.out.print("Enter the animal ID : ");
        String animID = in.nextLine();

        //check to make sure an animal exist with the animal id
        if (animals.get(animID) == null) {
            throw new NoSuchElementException("There is no Animal with animID  " + animID);
        }
        Animal a = animals.get(animID);

        System.out.print("Enter the staff member ID: ");
        String employeeID = in.nextLine();

        //this check to make sure staff exist with the employeeID
        if (staffmember.get(employeeID) == null) {
            throw new NoSuchElementException("There is no staff with employee id of " + employeeID);
        }
        StaffMember str = staffmember.get(employeeID);

        a.addStaff(str);
        str.assignAnimal(a);

    }

    /**
     * Assigning an animal to a specific kennel in the petstore.
     */
    public void assignkennel() {
        System.out.println("** For Assigning an animal to kennel **");
        System.out.print("Enter the animal ID of the animal: ");
        String animID = in.nextLine();

        if (animals.get(animID) == null) {
            throw new NoSuchElementException("There is no animal with " + animID);
        }
        Animal a = animals.get(animID);

        if (a.getAssignedKennel() != -1) {
            throw new IllegalStateException("The animal has already been assigned a kennel");
        }

        System.out.print("Enter the kennel number for the animal: ");
        int kennelnumber = in.nextInt();
        in.nextLine();

        if (kennelnumber < petstore.getMinKennelLabel() || kennelnumber > petstore.getMaxKennelLabel()) {
            throw new RuntimeException("kennel label is not a valid one, it is out of range %d - %d"
                    .formatted(petstore.getMinKennelLabel(), petstore.getMaxKennelLabel()));
        }

        // this checking if an animal is already occupying the same kennel
        if (petstore.isOccupied(kennelnumber)) {
            throw new IllegalStateException("There is already a different animal in same kennel.");
        } else {
            a.setAssignedKennel(kennelnumber);
            petstore.assignAnimalToKennel(a, kennelnumber);
        }
    }

    /**
     * this displays the empty kennels in the petstore but just as a stub for now.
     */
    public void showEmptyKennels() {
        System.out.println("Leave this method as a stub");
    }


    /**
     * this releases an animal from petstore but left as stub for now.
     */
    public void releaseAnimal() {
        System.out.println("Leave this method as a stub");

    }


    /**
     * this drops the association between a staff member and animal.
     */
    public void dropAssociation() {
        System.out.println("** For Dropping a new staff to animal Association **");
        System.out.print("Enter the animal id of the animal: ");
        String animID = in.next();

        if (animals.get(animID) == null) {
            throw new NoSuchElementException("There is no animal with " + animID);
        }
        Animal a = animals.get(animID);

        System.out.print("Enter the staff member id: ");
        String employeeID = in.next();

        // this check if the staff member is known already
        if (staffmember.get(employeeID) == null) {
            throw new NoSuchElementException("There is no staff with employee id of " + employeeID);
        }
        StaffMember str = staffmember.get(employeeID);

        String aAnimalID = a.getAnimalID();
        if(!animID.equals(aAnimalID)) {
            throw new IllegalStateException("animID are not equal for a animal: " + animID + " " + aAnimalID);
        }

        // the animal and staff are associated, so we remove each from the other's record
        a.removeStaff(employeeID);
        str.removeAnimal(animID);
    }

    /**
     * this displays the system state of all information
     */
    public void systemState() {
        System.out.println(this.toString());
    }


    /**
     * @return a string representation of the PetStoreSystem
     */
    public String toString() {
        String res = "\nThe animals in the system: ";
        Collection<Animal> animal_col = animals.values();
        for (Animal animal : animal_col)
            res = res + animal;
        res = res + "\n*****************\nThe staff's in the system: ";
        Collection<StaffMember> staff_col = staffmember.values();


        for (StaffMember str : staff_col)
            res = res + str;
        res = res + "\n*****************\nThe PetStore name is " + petstore;
        return res;
    }

    /**
     * this run's the petstore system .
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        int assign = -1;
        PetStoreSystem operation;

        while (true) {
            // this loop goes on till inputs are entered then quits.
            try {
                operation = new PetStoreSystem();
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        while (assign != 1) {
            try {
                //displaying the options list to the console to choose
                System.out.print("Options list:"
                        + "\n1: Quit"
                        + "\n2: Create a new animal in the system"
                        + "\n3: Create a new staff member in the system"
                        + "\n4: Assign an animal to a specific staff member "
                        + "\n5: Show all available kennels in the store"
                        + "\n6: Assign an animal to an empty kennel"
                        + "\n7: Remove the assigned animal from a specific kennel"
                        + "\n8: Drop the staff-animal association "
                        + "\n9: Display current system state"
                        + "\nEnter your selection between numbers 1-9: ");

                assign = in.nextInt();
                in.nextLine();

                if(assign == 1) operation.systemState();
                else if (assign == 2) operation.addAnimal();
                else if (assign == 3) operation.addStaff();
                else if (assign == 4) operation.assignStaffToAnimal();
                else if (assign == 5) operation.showEmptyKennels();
                else if (assign == 6) operation.assignkennel();
                else if (assign == 7) operation.releaseAnimal();
                else if (assign == 8) operation.dropAssociation();
                else if (assign == 9) operation.systemState();
                // else in case the user enters an incorrect choice error message
                else System.out.println("Invalid choice, try again.");
            }
            catch (RuntimeException e) {
                //this catches whatever exception is thrown
                System.out.println(e.getMessage());
            }
        }
        in.close();
        System.out.println("*** PetStoreSystem completed ***");
    }
}