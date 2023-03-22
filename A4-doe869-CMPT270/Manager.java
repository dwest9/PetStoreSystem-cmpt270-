// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



/**
 * this a class of a staff member with the manager specialty.
 */
public class Manager extends StaffMember {
    /**
     * this an instance with the given information
     *
     * @param fName      first name of the staff member
     * @param lName      last name of the staff member
     * @param sin        social insurance number of the staff member
     * @param employeeID the staff member employmentID
     */
    public Manager(String fName, String lName, String sin, String employeeID) {
        super(fName, lName, sin, employeeID);
    }

    /**
     * @return a string representation of the Manager
     */
    public String toString() {
        return "Manager: " + super.toString();
    }

    /**
     *test out the methods
     */
    public static void main(String[] args){

        String reason = " constructor + toString()";
        Manager m = new Manager("Chandler","Bing", "55745", "cb234");
        String result = m.toString();
        String expected = "Manager: Last Name: Bing, First Name: Chandler, SIN: 55745, Employee ID: cb234";
        if (!result.equals(expected)){
            System.out.println("Error: Expected: " + expected + "Obtained: " + result + " (" + reason + ")" );
        }

        System.out.println("*** Test Complete ***");
    }

}

