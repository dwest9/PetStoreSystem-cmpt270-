// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09

public class AddAnimal implements Command {


    /**
     * Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void execute() {
        IOAccess.getInstance().outputString("-------Adding Animal to PetStore-------");

        String name = IOAccess.getInstance().readString("Enter the name of the animal: ");

        String animalID = IOAccess.getInstance().readString("Enter the animal ID of the animal: ");

        String animalType = IOAccess.getInstance().readString("Enter the type of animal: ");

        if (AnimalMapAccess.getInstance().containsKey(animalID)) {
            throw new IllegalStateException("Animal with ID " + animalID + " already exists");
        }

        Animal anim = new Animal(name, animalID, animalType);
        Animal result = AnimalMapAccess.getInstance().put(animalID, anim);

        // checking to make sure insertion into the Map worked
        if (result != null) {
            AnimalMapAccess.getInstance().put(animalID, result);  // put the original animal back in
            throw new IllegalStateException("Animal was already in dictionary, even though containsKey failed. Animal " + name + " not entered.");
        }
    }
}

