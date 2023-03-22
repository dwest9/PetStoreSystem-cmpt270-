package commands;

import sun.plugin.com.event.COMEventHandler;

public class CommandArguments{
    /**
     * The name of the student.
     */
    public String sName;
    /**
     * The student's SIN.
     */
    public String sSIN;
    /**
     * The NSID of the student.
     */
    public String sNSID;

    /**
     * The name of the manager.
     */
    public String mName;
    /**
     * The social insurance number of the manager.
     */
    public String mSIN;
    /**
     * The employee number of the manager.
     */
    public String mEN;

    /**
     * Response of the user to set whether a manager is a consultant or not.
     */
    public String response;

    /**
     *  the number of the bed.
     */
    public int bedNum;

    /**
     *  the name of the residence
     */
    public String rName;

    /**
     *  min Bed Label
     */

    public int minBedLabel;

    /**
     *  the max bed lable
     */

    public int maxBedLabel;

    public CommandArguments(){

    }
}
