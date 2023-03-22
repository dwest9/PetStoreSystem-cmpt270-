// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.TreeMap;

public class StaffMapAccess {

    /**
     * Singleton dictionary container for all StaffMember's map.
     */
    private static TreeMap<String, StaffMember> dictionary;

    /**
     * The Private Constructor
     */
    private StaffMapAccess(){}

    /**Returns the dictionary containing the singleton StaffMember's objects
     *
     * @return the dictionary containing the singleton StaffMember's objects
     */
    public static TreeMap<String, StaffMember> getInstance(){

        if(dictionary == null){
            dictionary = new TreeMap<String, StaffMember>();
        }

        return dictionary;
    }
}

