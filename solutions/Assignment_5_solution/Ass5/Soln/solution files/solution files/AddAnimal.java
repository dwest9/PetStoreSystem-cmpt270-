/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Solution for Assignment 5 Question 5
 */

public class AddAnimal implements Command
{
    /**
     * Executes the command - Collects information on a new animal, then adds the animal to the dictionary of all animals
     */
    public void execute()
    {
        String name = IOAccess.getInstance().readString("-------Adding Animal to Residence-------\nEnter the name of the animal: ");
        String animalID = IOAccess.getInstance().readString("Enter the animal ID of the animal: ");
        String animalType = IOAccess.getInstance().readString("Enter the type of animal: ");

        if (AnimalMapAccess.getInstance().containsKey(animalID))
        {
            throw new IllegalStateException("Animal with ID " + animalID + " already exists");
        }

        Animal anim = new Animal(name, animalID, animalType);
        Animal result = AnimalMapAccess.getInstance().put(animalID, anim);

        // checking to make sure insertion into the Map worked
        if (result != null)
        {
            AnimalMapAccess.getInstance().put(animalID, result);  // put the original animal back in
            throw new IllegalStateException("Animal was already in dictionary, even though containsKey failed. Animal " + name + " not entered.");
        }
    }

    /**
     * Main method for performing simple testing of the command
     * @param args not used
     */
    public static void main(String[] args) {
        Command addAnimal = new AddAnimal();
        addAnimal.execute();
        for (Animal anim: AnimalMapAccess.getInstance().values()) {
            IOAccess.getInstance().outputString(anim.toString());
        }
    }
}
