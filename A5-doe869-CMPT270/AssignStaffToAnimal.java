// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.NoSuchElementException;

public class AssignStaffToAnimal implements Command{
    /**
     * Assign a staff member to an animal, and the animal to the staff member
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("-------Assigning staff to an animal-------");
        String animalID = IOAccess.getInstance().readString("Enter the animalID of the animal: ");

        Animal anim = AnimalMapAccess.getInstance().get(animalID);
        if (anim == null)
        {
            throw new NoSuchElementException("There is no such animal with ID  " + animalID);
        }

        String staffID = IOAccess.getInstance().readString("Enter the employee number of the staff member: ");
        StaffMember staffMember = StaffMapAccess.getInstance().get(staffID);
        if (staffMember == null)
        {
            throw new NoSuchElementException("There is no staff with employee ID " + staffID);
        } else
        {
            anim.addStaff(staffMember);
            staffMember.assignAnimal(anim);
        }
    }

}
