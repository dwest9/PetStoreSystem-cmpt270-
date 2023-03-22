// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09

public class AddStaff implements Command {

    /**
     * Read info for a new staff member, and add them to dictionary of all staff
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("-------Adding Staff to Store-------");

        String fName = IOAccess.getInstance().readString("Enter the staff member's first name: ");

        String lName = IOAccess.getInstance().readString("Enter the staff member's last name: ");

        String staffSIN = IOAccess.getInstance().readString("Enter the staff member's SIN: ");

        String staffID = IOAccess.getInstance().readString("Enter the staff member's employee ID: ");
        if (StaffMapAccess.getInstance().containsKey(staffID))
        {
            throw new IllegalStateException("Staff not added. Already have staff with employee number " + staffID);
        }

        String response = IOAccess.getInstance().readString("Is the staff member a manager? (yes or no): ");

        StaffMember newStaff;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
        {
            newStaff = new Manager(fName, lName, staffSIN, staffID);
        } else
        {
            newStaff = new StaffMember(fName, lName, staffSIN, staffID);
        }

        // check to make sure the staff employee ID doesn't already exist
        StaffMember result = StaffMapAccess.getInstance().put(staffID, newStaff);
        if (result != null)
        {
            // if put() returns a reference, then a manager was already stored with the same EN,
            // so put it back, and signal an error.
            StaffMapAccess.getInstance().put(staffID, result); // put the original manager back
            throw new IllegalStateException("Staff was already in dictionary, even though containsKey failed. Staff " + fName + " " + lName + " not entered.");
        }
    }
}
