import java.util.LinkedList;
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



public class ShowEmptyKennels implements Command {
    /**
     * Display all empty kennels in the store
     */
    public void execute()
    {

        IOAccess.getInstance().outputString("The following are the available kennels");
        LinkedList<Integer> kennels = PetStoreAccess.getInstance().availableKennels();

        if (kennels.size() == 0){
            IOAccess.getInstance().outputString("KennelEmpty");
        }
        else {
            for (Integer kennelLabel : kennels) {
                IOAccess.getInstance().outputString("kennel# " + kennelLabel);
            }
        }
    }

}
