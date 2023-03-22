// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.TreeMap;

public class AnimalMapAccess {

    /**
     * Singleton dictionary container for all animals map.
     */
    private static TreeMap<String, Animal> dictionary = null;

    /**
     * The Private Constructor
     */
    private AnimalMapAccess(){}

    /**Returns the dictionary containing all the Student objects.
     * @return  A student dictionary container
     */
    public static TreeMap<String, Animal> getInstance() {
        if(dictionary == null){
            dictionary = new TreeMap<String, Animal>();
        }

        return dictionary;
    }

}
