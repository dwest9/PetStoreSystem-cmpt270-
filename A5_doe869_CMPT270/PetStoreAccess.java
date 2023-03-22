// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09

public class PetStoreAccess {
    /**
     * Singleton attribute
     */
    private static PetStore petStore;

    /**
     * The private constructor
     */
    private PetStoreAccess(){}

    /** Initialize an instance of a PetStore.
     *
     * @param name the petstore name
     * @param firstkennel the firstkennel label
     * @param lastkennel  the lastkennel label
     * @precond
     */
    public static void intialize(String name, int firstkennel, int lastkennel){

        if(name == null){
            throw new RuntimeException("The PetStore name given is empty.");
        }
        if(firstkennel < 0 || firstkennel > lastkennel){
            throw new RuntimeException("The kennel labels given are invalid.");
        }

        if(petStore != null){
            throw new IllegalStateException("Petstore has been initialized.");
        }
        petStore = new PetStore(name, firstkennel, lastkennel);
    }

    /**
     * Return the container for Petstore
     * @precond
     * @return  the dictionary for PetStore
     */
    public static PetStore getInstance(){
        if(petStore == null){
            throw new RuntimeException("PetStore was not initialized.");
        }
        return petStore;
    }
    public static void main(String[] args) {
    }
}
