// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO implements InputOutputInterface{

    private final Scanner input = new Scanner(System.in);


    /**
     *  this displays a prompt to the console and read strings
     * @param prompt the string to be displayed as a prompt
     * @return the String read
     */
    @Override
    public String readString(String prompt) {

        System.out.println(prompt);

        return input.nextLine();
    }


    /**
     * this displays the prompt and reads integer
     * @param prompt the string to be displayed as a prompt
     *
     * @return the int read
     */
    @Override
    public int readInt(String prompt) {

        int integer = 0;
        boolean readInteger;

        readInteger = true;
        try {
            System.out.println(prompt);
            integer = input.nextInt();

        } catch (InputMismatchException e) {
            readInteger = false;
            input.nextLine();
            System.out.println("Invalid input: enter integer");
            return readInt(prompt);
        }
        input.nextLine();
        return integer;
    }

    /**this displays a list of choices/options and read the integer
     * representing the choice
     *
     * @param options an array with the options that are presented to the user
     * @return the int specifying the array index for the option selected by the user
     */
    @Override
    public int readChoice(String[] options) {
        String option = " ";

        for (int i = 0; i < options.length; i++) {
            option = option + "\n" + i + ": " + options[i];
        }
        option = option + "\nEnter a valid option: ";
        int value = readInt(option);
        if(value < 0 || value >= options.length){
            outputString("You gave an input" + value + "that is not between 0 and %d" + (options.length) + "try again.%n\n");
            return readChoice(options);
        }
        else {return value;}
    }

    /**Output the String parameter.
     *
     * @param outString the string whose value is to be displayed
     */
    @Override
    public void outputString(String outString) {
        System.out.println(outString);

    }

    /**
     * testing all methods above
     * @param args
     */
    public static void main(String[] args){

        ConsoleIO consoleIO = new ConsoleIO();

        consoleIO.outputString("Welcome to Wakanda Cinemas! What movie would you like to watch? ");
        consoleIO.readString("Enter the movie name: ");
        int Adult = consoleIO.readInt("How many adults are going to watch?: ");

        int child = 0;
        String[] choice = {"YES", "NO"};
        consoleIO.outputString("Are they going to be children? (if yes enter 0, else enter 1):");
        int answer = consoleIO.readChoice(choice);
        if(answer == 0) {
            child = consoleIO.readInt("How many children are going to watch?: ");
        }

        String[] time = {"time 1","time 2", "time 3", "time 4", "time 5", "time 6"};
        consoleIO.outputString("Please choose from(0-5) to choose a movie time..");
        int movieTime = consoleIO.readChoice(time);

        consoleIO.outputString("Your movie is by %s:00pm, with %d adults and %d child/children.".formatted(time[movieTime], Adult, child));
        consoleIO.outputString("Thank you for using Wakanda Cinemas.");
    }
}


