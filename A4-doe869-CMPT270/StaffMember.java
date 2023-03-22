// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



import java.util.ArrayList;
import java.util.*;


public class StaffMember extends BasicStaff {
    /**
     * An arraylist of all animals in the staff list.
     */
    protected ArrayList<Animal> animals;



    /**
     * this startup's an instance with the information of the staff member
     * @param fName first name of the staff member
     * @param lName last name of the staff member
     * @param sin social insurance number of the staff member
     * @param employeeID the staff member employmentID
     */
    public StaffMember(String fName, String lName, String sin, String employeeID) {
        super(fName, lName, sin, employeeID);

        animals = new ArrayList<>();
    }

    /**
     * Assigning an animal to the list of animal for the staff member
     * @param a the animal to be added to the staff's list
     */
    public void assignAnimal(Animal a) {
        if (hasAnimal(a.getAnimalID()))
            throw new IllegalStateException("Animal " + a.getAnimalID() + " is already assigned ");
        animals.add(a);
    }

    /**
     * Removing the animal with the specified AnimalID
     * from the list of those being treated by this Staff member
     * @param animal_ID the AnimalID of an animal
     * @precond hasAnimal(animal_ID)
     */
    public void removeAnimal(String animal_ID) {
        if (!hasAnimal(animal_ID))
            throw new NoSuchElementException("Staff member does not have an animal with animalID " + animal_ID);

        Iterator<Animal> iter = animals.iterator();
        while (iter.hasNext()) {
            Animal a = iter.next();
            if (a.getAnimalID().equals(animal_ID)) {
                iter.remove();
                return;
            }
        }
    }

    /**
     * @param animal_ID the AnimalID of the animal to be checked
     * @return is the Animal with the specified AnimalID of this staff member?
     */
    public boolean hasAnimal(String animal_ID) {
        Iterator<Animal> iter = animals.iterator();
        while (iter.hasNext()) {
            Animal a = iter.next();
            if (a.getAnimalID().equals(animal_ID))
                return true;
        }
        return false;
    }


    /**
     * @return a string representation of the staff member
     */

    public String toString() {
        return super.toString();
    }

    /**
     * method to test the class
     * @param args none used
     */
    public static void main(String[] args){
        int numErrors = 0;

        StaffMember m = new StaffMember("Andrew", "Mike", "8765", "Drew15");

        String animal1 = "Kevin";
        String a1_ID = "kvg129";
        String animal2 = "Charlotte";
        String a2_ID = "ctj888";

        Animal s1 = new Animal(animal1, a1_ID, "dog");
        Animal s2 = new Animal(animal2, a2_ID, "dog");

        //TEST assignAnimal() and hasAnimal()
        m.assignAnimal(s1);
        m.assignAnimal(s2);

        if (!m.hasAnimal(a1_ID) || !m.hasAnimal(a2_ID)){
            System.out.println("Error in hasAnimal(): returned false");
            numErrors++;
        }

        //TEST removeAnimal()
        m.removeAnimal(a1_ID);
        if(m.hasAnimal(a1_ID)){
            System.out.println("Error in removeAnimal()");
            numErrors++;
        }

        Animal s3 = new Animal("Blue", "jsb771", "cat");
        Animal s4 = new Animal("Smith", "jst000", "dog");
        Animal s5 = new Animal("Eyo", "eey342", "cat");
        m.assignAnimal(s3); m.assignAnimal(s4); m.assignAnimal(s5);

        System.out.println("The number of errors: " + numErrors);
        System.out.println("*** Test Completed ***");
    }
}




