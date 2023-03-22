// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09

/**
 * This is a Singleton program that controls the IOInterface Object
 */
public class IOAccess {
    private static InputOutputInterface input;

    private IOAccess() {}

    public static InputOutputInterface getInstance() {
        if (input == null) {
            InputOutputInterface input = new DialogIO();

            // this prompt the user either to use console or dialog to start program
            String[] chooseIO = {"Work On Console", "Work On Dialog"};
            int choice = input.readChoice(chooseIO);
            if (choice == 0) {
                IOAccess.input = new ConsoleIO();
            } else {
                IOAccess.input = input;
            }
        }
        return input;
    }
    public static void main(String[] args) {
    }

}

