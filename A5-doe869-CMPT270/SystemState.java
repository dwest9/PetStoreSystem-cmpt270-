// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



import java.util.Collection;

public class SystemState implements Command {
    /**
     *this shows the systems state
     */
    public void execute()
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
        IOAccess.getInstance().outputString(result);
    }
}
