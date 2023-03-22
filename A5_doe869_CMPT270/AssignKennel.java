// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



import java.util.NoSuchElementException;

public class AssignKennel implements Command{
    /**
     * Assign an animal to a kennel
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("-------Assigning a kennel to an animal-------");
        String animalID = IOAccess.getInstance().readString("Enter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is such animal with ID " + animalID);
        }

        if (anim.getAssignedKennel() != -1)
        {
            throw new IllegalStateException("Animal " + animalID + " is already assigned a kennel");
        }

        int kennelNumber = IOAccess.getInstance().readInt("Enter the kennel label for the animal: ");

        if (kennelNumber < PetStoreAccess.getInstance().getMinKennelLabel() || kennelNumber > PetStoreAccess.getInstance().getMaxKennelLabel())
        {
            throw new IllegalArgumentException(kennelNumber + " is not a valid value. Must be between " + PetStoreAccess.getInstance().getMinKennelLabel() + " and " + PetStoreAccess.getInstance().getMaxKennelLabel());
        }

        if (PetStoreAccess.getInstance().isOccupied(kennelNumber))
        {
            throw new IllegalStateException("Kennel is already assigned to an animal");
        } else
        {
            anim.setAssignedKennel(kennelNumber);
            PetStoreAccess.getInstance().assignAnimalToKennel(anim, kennelNumber);
        }
    }

}
