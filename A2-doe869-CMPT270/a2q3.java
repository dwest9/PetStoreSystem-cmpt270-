// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


import java.util.Scanner;
/**
 * This class implements a Java program that allows the user to play a
 * Number Square Rotation Game. The game allows the user to rotate a
 * sub-square of the 3 x 3 array of integers, until the array matches
 * with the goal.
*/

public class a2q3 {

       /* this is the goal array */
       static final int[][] goal = {
               {1, 1, 1},
               {2, 2, 2},
               {3, 3, 3}
       };

    /**
     * Purpose:This method displays the player's array
     * param: arr The player's array to display
     */

    static void displaySquare(int[][] arr) {
           for(int i = 0; i < arr.length; i++) {
                  for(int j = 0; j < arr[i].length; j++) {
                         System.out.print(arr[i][j] + " ");
                  }
                  System.out.println();
           }
           System.out.println();
    }

    /**
     * Purpose: This method checks if the array and the goal array are the same
     * param: arr The player's array
     * return: True if the player's array and the goal array are the same, false otherwise
    */

    static boolean Square_check(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != goal[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Purpose: This method rotates the given sub-square of the player's array to the left by 1.
     * param: arr The player's array to rotate
     * param: subSquare The sub-square of the array to rotate
    */

    static void leftRotate(int[][] arr, int subSquare) {
        // this gets the top-left indexes of selected sub-square [i,j]

        int i = 0, j = 0;
        if(subSquare == 1)
            j = 1;
        else if(subSquare == 2)
            i = 1;
        else if(subSquare == 3) {
            i = 1;
            j = 1;
        }

        int tp = arr[i][j];
        arr[i][j] = arr[i][j + 1]; // top-right to top-left
        arr[i][j + 1] = arr[i + 1][j + 1]; // bottom-right to top-right
        arr[i + 1][j + 1] = arr[i + 1][j]; // bottom-left to bottom-right
        arr[i + 1][j] = tp;
    }

    /**
     * This method rotates the given sub-square of the player's array to the right by 1.
     * param: arr The player's array to rotate
     * param: subSquare The sub-square of the array to rotate
     */

    static void rightRotate(int[][] arr, int subSquare) {
        // this gets the top-left indexes of selected sub-square [i,j]

        int i = 0, j = 0;
        if(subSquare == 1)
            j = 1;
        else if(subSquare == 2)
            i = 1;
        else if(subSquare == 3) {
            i = 1;
            j = 1;
        }

        int tp = arr[i][j];
        arr[i][j] = arr[i + 1][j]; // from bottom-left to top-left
        arr[i + 1][j] = arr[i + 1][j + 1]; // from bottom-right to bottom-left
        arr[i + 1][j + 1] = arr[i][j + 1]; // top-right to bottom-right
        arr[i][j + 1] = tp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //the player's array
        int[][] arr = {
                {1, 2, 1},
                {1, 3, 2},
                {3, 3, 2}
        };

        //the game message
        System.out.println("Number Square Rotation Game\n");

        System.out.println("Initial position:");
        displaySquare(arr);


        // this infinite loop stops only if the player wins
        while(true) {
            //Prompt user to enter move
            System.out.print("Enter move: ");
            String move = input.nextLine();

            //Split user input into array
            String[] data = move.split(" ");

            // this checks if users input contains only 2 values
            if(data.length != 2) {
                System.out.println("Invalid input");
                continue;
            }

            //variable to hold the direction, 'L' or 'R'
            char direction = data[0].charAt(0);

            //variable to hold the sub-square
            int subSquare = 0;

            try {
                subSquare = Integer.parseInt(data[1]);
            } catch(Exception e) {
                //displays error message if not correct
                System.out.println("Incorrect input");
                continue;
            }

            //test if sub-square input is in range
            if(subSquare >= 0 && subSquare <= 3) {
                //test if direction is 'L'
                if(direction == 'L') {
                    leftRotate(arr, subSquare);

                } //if not, test if direction is 'R'
                else if(direction == 'R') {
                    rightRotate(arr, subSquare);
                }
                else {
                    //if not 'L' or 'R', displays error message
                    System.out.println("Incorrect input");
                    continue;
                }
            } else {
                System.out.println("Incorrect input");
                continue;
            }

            // this displays player's array after the rotation
            System.out.println();
            displaySquare(arr);

            // this checks if player's array and goal array are the same
            if(Square_check(arr)) {
                // then if so, displays the winning message
                System.out.println("You win!");
                break;
            }
        }
    }
}
