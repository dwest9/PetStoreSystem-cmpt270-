// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09




public class Animal {
/**
 * This is a class of an animal that has an attribute of a name, type and ID number
 * that cannot be changed.
 */

    /**
     * first attribute for the animal name.
     */
    private String Animal_name;
    /**
     * second attribute for the specie of the animal.
     */
    private String Animal_type;
    /**
     * third attribute for the animal's ID number.
     */
    private String Animal_ID_number;
    /**
     * this initiate the animal's name, type and ID number
     *
     * @param A_name the animal's name
     * @param A_type the animal's type
     * @param A_ID_num the animal's ID number
     */
    public Animal(String A_name, String A_type, String A_ID_num) {
        this.Animal_name = A_name;
        this.Animal_type = A_type;
        this.Animal_ID_number = A_ID_num;
    }
    /**
     * returns the name of the animal.
     *
     */
    public String getAnimal_name() {
        return Animal_name;
    }

    /**
     * returns the animal type
     */

    public String getAnimal_type() {
        return Animal_type;
    }

    /**
     * returns the animals ID number
     */

    public String getAnimal_ID_number() {
        return Animal_ID_number;
    }

    /**
     * this changes the name of the animal.
     */

    public void setAnimal_name(String animal_name) {
        Animal_name = animal_name;
    }

    public void setAnimal_type(String animal_type) {
        Animal_type = animal_type;
    }

    public void setAnimal_ID_number(String animal_ID_number) {
        Animal_ID_number = animal_ID_number;
    }


    /**
     * this returns a String representation of the properties of the Animal.
     */

    public String toString() {
        return Animal_name + " " + Animal_type + " " + Animal_ID_number;
    }

    /**
     * A method to test the Animal class.
     */
    public static void main(String[] args) {

        /**
         *  testing the methods with first testing of the animal
         */
        int numErrors = 0;
        // testing all the methods with one instance of a Animal
        Animal pet = new Animal("Hally", "Cat", "54321");
        if (!pet.getAnimal_name().equals("Hally")) {
            System.out.println("the constructor for getAnimal_name failed");
            numErrors++;
        }
        if (!pet.getAnimal_type().equals("Cat")) {
            System.out.println("the constructor for getAnimal_type failed");
            numErrors++;
        }
        if (pet.getAnimal_ID_number() != "54321") {
            System.out.println("the constructor for getAnimal_ID_number failed");
            numErrors++;
        }
        pet.setAnimal_name("Sally");
        if(! pet.getAnimal_name().equals("Sally")) {
            System.out.println("the constructor for setAnimal_name failed");
            numErrors++;
        }

        String expected = "Sally" + " " + "Cat" + " " + "54321";
        if(!pet.toString().equals(expected)) {
            System.out.println("the constructor or toString failed");
            numErrors++;
        }

        /**
         *  testing the methods with second sample of the animal
         */
        pet = new Animal("Billy", "Dog", "87655");
        if(! pet.getAnimal_name().equals("Billy")){
            System.out.println("the constructor for getAnimal_name failed");
            numErrors++;
        }
        if(! pet.getAnimal_type().equals("Dog")){
            System.out.println("the constructor for getAnimal_type failed");
            numErrors++;
        }
        if(pet.getAnimal_ID_number() != "87655"){
            System.out.println("the constructor for getAnimal_ID_number failed");
            numErrors++;
        }
        pet.setAnimal_name("Jack");
        if(! pet.getAnimal_name().equals("Jack")){
            System.out.println("the constructor for setAnimal_name failed");
            numErrors++;
        }
        expected = "Jack" + " " + "Dog" + " " + "87655";
        if (!pet.toString().equals(expected)) {
            System.out.println("the constructor for toString failed");
            numErrors++;
        }
        System.out.println("The number of errors found is " + numErrors);
        System.out.println("*** Test complete **");
    }

}