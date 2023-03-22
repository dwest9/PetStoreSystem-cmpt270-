
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import javax.swing.JFrame;

/**
 * The frame for the window to enter data for a new staff member, and the creation of the staff member.
 */
public class StaffMemberAddFrame extends JFrame
{
    /**
     * The width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 350;

    /**
     * This Creates the frame to add a new staff member
     */
    public StaffMemberAddFrame()
    {
        setTitle("Adding Of Staff Member");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffMemberAddPanel panel = new StaffMemberAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
