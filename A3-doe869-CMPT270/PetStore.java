// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


public class PetStore {
/**
 * This is a class for a petstore that has a particular
 * number of kennels and labels to it
 */

    /**
     * the pet store name
     */
    private String store_name;

    /**
     * the label of the first kennel in petstore.
     */

    private int firstkennel_label;


    /**
     * the label of the last kennel in petstore.
     */

    private int lastkennel_label;

    /**
     * this shows the kennels in the store in an array if kennel is empty or an animal in it.
     */

    private Animal[] kennel;


    /**
     * Initialize the petstore with the name given, and with kennel those labels are
     * the consecutive integers from firstkennel_label to lastkennel_label.
     * @param storename the store name
     * @param f_kennel the first kennel label in the store
     * @param l_kennel the last kennel label in the store
     */
    public PetStore(String storename, int f_kennel, int l_kennel) {
        this.store_name = storename;
        this.firstkennel_label = f_kennel;
        this.lastkennel_label = l_kennel;
        this.kennel = new Animal[lastkennel_label - firstkennel_label + 1];
    }

    /**
     * this returns the name of the store.
     */

    public String getStore_name() {
        return store_name;
    }

    /**
     * this returns the first label for a kennel in the store.
     */

    public int getFirstkennel_label() {
        return firstkennel_label;
    }

    /**
     * this returns the last label for a kennel in the store.
     */

    public int getLastkennel_label() {
        return lastkennel_label;
    }

    /**
     * this returns the label index of the kennel corresponding to the label.
     * @param label the label of a kennel from the index
     * @return the internal/array index of the bed corresponding to the external label
     */

    private int labelToindex(int label) {

        return label - firstkennel_label;
    }


    /**
     * this returns the index label of the kennel leading to the label index.
     * @param index the index of a location in the kennel array
     */

    private int indexTolabel(int index) {
        if (index < 0 || index >= kennel.length)
            throw new IllegalArgumentException("The value " + index +
                    " is not a valid index of length " + kennel.length + ".");

        return index + firstkennel_label;
    }


    /**
     * this checks if a particular kennel is occupied
     * @param label  the label of the kennel to be tested for being occupied
     * @return  this checks if a particular kennel is occupied
     */

    public boolean iskenneloccupied(int label) {

        return kennel[labelToindex(label)] != null;
    }

    /**
     * this returns an animal in particular kennel
     */

    public Animal getAnimal(int label) {

        return kennel[labelToindex(label)];
    }

    /**
     * this assigns the particular animal to a  particular kennel
     */

    public void assignAnimal(int label, Animal animal) {
        //check if a bed is occupied

        if (!iskenneloccupied(label)) {
            this.kennel[labelToindex(label)] = animal;
        } else {
            System.out.println("kennel not assigned.");
        }

    }


    /**
     * this returns a String representation of the properties of the pet store.
     */

    public String toString() {
        String to_string = "PetStore %s contains %d kennel \n"
                .formatted(store_name, kennel.length);
        for (int index = 0; index < kennel.length; index++) {
            if (kennel[index] != null) {
                to_string = to_string + "kennel #" +indexTolabel(index) + " with "
                        + getAnimal(indexTolabel(index)) + " ID number.\n";
            }
            else {
                to_string = to_string + "kennel #" + indexTolabel(index) + "\n";
            }
        }
        return to_string;
    }


    /**
     * this is a method to test the petstore class
     */
    public static void main(String[] args) {

        PetStore R = new PetStore("Spruce Store", 51, 80);
        if (!R.getStore_name().equals("Spruce Store")) {
            System.out.println("Error found in the getStore_name() method");
        }
        if (R.getFirstkennel_label() != 51) {
            System.out.println("Error found in the gerFirst_label() method ");
        }
        if (R.getLastkennel_label() != 80) {
            System.out.println("Error found in the getLast_label() method");
        }
        if (R.labelToindex(65) != 14 || R.labelToindex(51) != 0) {
            System.out.println("Error found in the labelToindex() method");
        }
        if (R.iskenneloccupied(51)) {
            System.out.println("Error found in iskenneloccupied() method");
        }
        Animal d = new Animal("Randy", "Dog", "123456789");
        R.assignAnimal(55, d);

        if (!R.getAnimal(51).toString().equals("Randy Dog")) {
            System.out.println("Error found in R.assignAnimal() and R.getAnimal()");
        }
        if(!R.iskenneloccupied(55)){
            System.out.println("Error found in iskenneloccupied() method");
        }

        Animal s = new Animal("Andy", "Dog", "987654321");
        R.assignAnimal(50, s);

        String c = R.toString();
        String kennel = "bed";
        if(!c.equals("PetStore Spruce Store contains 29 kennels \n" +
                kennel + " #51\n" +
                kennel + " #52\n" +
                kennel + " #53\n" +
                kennel + " #54\n" +
                kennel + " #55\n" +
                kennel + " #56\n" +
                kennel + " #57\n" +
                kennel + " #58\n" +
                kennel + " #59\n" +
                kennel + " #60\n" +
                kennel + " #61\n" +
                kennel + " #62\n" +
                kennel + " #63\n" +
                kennel + " #64\n" +
                kennel + " #65\n" +
                kennel + " #66\n" +
                kennel + " #67\n" +
                kennel + " #68\n" +
                kennel + " #69\n" +
                kennel + " #70\n" +
                kennel + " #71\n" +
                kennel + " #72\n" +
                kennel + " #73\n" +
                kennel + " #74\n" +
                kennel + " #75\n" +
                kennel + " #76\n" +
                kennel + " #77\n" +
                kennel + " #78\n" +
                kennel + " #79\n" +
                kennel + " #80\n")){
            System.out.println("Error found in toString() method");
        }
        System.out.println("Test completed");
    }
}

