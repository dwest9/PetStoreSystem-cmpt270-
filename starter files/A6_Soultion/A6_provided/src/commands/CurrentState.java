package commands;

import containers.ManagerMapAccess;

import containers.ResidenceAccess;
import containers.StudentMapAccess;
import java.util.Collection;
import entities.Manager;
import entities.Student;

/**
 * Command to obtain a String representation of the current state of the system. The current state
 * is placed in the curState field.
 */
public class CurrentState extends CommandStatus implements Command {
    /**
     * A string containing the current state of the system.
     */
    private String curState;

    /**
     * Obtain the current state of the system and place the string in curState.
     */
    public void findCurState() {
        curState = "\nThe students in the system are \n";
        Collection<Student> students = StudentMapAccess.getInstance().values();
        for (Student p : students)
            curState = curState + p;
        curState = curState + "\nThe managers in the system are \n";
        Collection<Manager> managers = ManagerMapAccess.getInstance().values();
        for (Manager d : managers)
            curState = curState + d;
        curState = curState + "\nThe residence is " + ResidenceAccess.getInstance();
        successful = true;
    }

    /**
     * Return a string containing the state of the system.
     *
     * @precond wasSuccessful()
     * @return a string containing the state of the system
     */
    public String getCurState() {
        if (!wasSuccessful())
            throw new RuntimeException("The method findCurState() must be "
                    + "invoked before this method");
        return curState;
    }

    @Override
    public void execute() {
        curState = "\nThe students in the system are \n";
        Collection<Student> students = StudentMapAccess.getInstance().values();
        for (Student p : students)
            curState = curState + p;
        curState = curState + "\nThe managers in the system are \n";
        Collection<Manager> managers = ManagerMapAccess.getInstance().values();
        for (Manager d : managers)
            curState = curState + d;
        curState = curState + "\nThe residence is " + ResidenceAccess.getInstance();
        successful = true;
    }
}
