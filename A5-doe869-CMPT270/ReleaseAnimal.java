// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.NoSuchElementException;

public class ReleaseAnimal implements Command {
    /**
     * Release an animal from the store
     */
    public void execute()
    {

        String animalID = IOAccess.getInstance().readString("Enter the animals ID: ");

        Animal animal = AnimalMapAccess.getInstance().get(animalID);

        if(animal == null){  //this checks if the animal id is valid
            throw new NoSuchElementException("There is no animal with such an ID %s".formatted(animalID));
        }

        PetStoreAccess.getInstance().freeKennel(animal.getAssignedKennel());
        animal.setAssignedKennel(-1);

    }

}
