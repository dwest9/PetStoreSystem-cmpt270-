
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import javax.swing.JFrame;


import containers.StaffMapAccess;
import entities.StaffMember;

/**
 * The frame for the window to display the information for a staff member, and takes operations on the
 * staff member.
 */
public class StaffMemberFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * This Creates the frame to display the information for the staff member.
     * @param empID the ID of the staff member
     * @precond ID of a staff member
     */
    public StaffMemberFrame(String empID)
    {
        StaffMember staffMember = StaffMapAccess.getInstance().get(empID);
        if (staffMember != null)
        {
            setTitle(staffMember.getEmployeeID() + " (" + empID + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            StaffMemberPanel panel = new StaffMemberPanel(staffMember);
            add(panel);
        } else
        {
            throw new RuntimeException("Invalid ID " + empID);
        }
    }

    public static final long serialVersionUID = 1;
}

