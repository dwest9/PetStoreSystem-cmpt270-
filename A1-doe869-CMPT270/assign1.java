//NAME: David Emmanuel
//NSID: doe869
//STUDENT ID: 11298443
//COURSE NUMBER: cmpt270


public class assign1 {

    public static void main(String[] args) {

        /*
        purpose:
            computing the calculation of any student course grade using the grading percentage provided
        return:
            returns the total course grade score
         */


        //  For the exercises
        int exe_1 = 21; int exe_2 = 18; int exe_3 = 17; int exe_4 = 18;
        int exe_5 = 19; int exe_6 = 13; int exe_7 = 17; int exe_8 = 19;
        int exe_9 = 18; int exe_10 = 22;

        // all exercises here are out of 25
        int per = 25;

        // this adds up all exercises and divides it by 25 then multiplying it by 10
        // to compute the calculation for exercises

        int exercises = (exe_1 + exe_2 + exe_3 + exe_4 + exe_5 + exe_6
                + exe_7 + exe_8 + exe_9 + exe_10)/per * 10 ;


        // For the assignments
        int score_1 = 42;  int max_1 = 49;
        int score_2 = 42;  int max_2 = 45;
        int score_3 = 42;  int max_3 = 42;
        int score_4 = 19;  int max_4 = 22;
        int score_5 = 27;  int max_5 = 38;
        int score_6 = 22;  int max_6 = 38;
        int score_7 = 63;  int max_7 = 73;


        // this multiplies the 5% of each assignment and add up all together
        double _5per = 0.05;
        double assignments = (_5per * score_1 / max_1 + _5per * score_2 / max_2 + _5per * score_3 / max_3
                + _5per * score_4 / max_4 + _5per * score_5 / max_5 + _5per * score_6 / max_6 + _5per * score_7 / max_7);

        // midterm score
        double midterm = 83.2;

       // final exam score
        double finalexam = 94.1;

        // course grade using the percentage of 35%,20%,20%,25%
        double courseGrade = assignments * 100.0
                + 0.2 * exercises
                + 0.2 * midterm
                + 0.25 * finalexam;

        System.out.println("SCENARIO 4: The values in the given example above.");
        // displays the student name to the console
        System.out.println("Student: Einstein , Albert");

        //  displays each Exercise score to the console
        System.out.println("  Exercises:  " + exe_1 + ", " + exe_2 + ", " + exe_3 + ", "
                + exe_4 + ", " + exe_5 + ", " + exe_6 + ", " + exe_7 + ", " + exe_8 + ", "
                + exe_9 + ", " + exe_10);

        // displays each Assigment score to the console
        System.out.println("  Assignments:  " + score_1 + "/" + max_1  + ", " + score_2 + "/" + max_2 + ", "
                + score_3 + "/" + max_3 + ", " + score_4 + "/" + max_4 + ", " + score_5 + "/" + max_5 + ", "
                + score_6 + "/" + max_6 + ", " + score_7 + "/" + max_7);

        int courseDisplay = (int) Math.round(courseGrade);

        System.out.println("  Midterm:  " + midterm);
        System.out.println("  Final:  " + finalexam);
        System.out.println("Grade: "+courseDisplay);

    }
}
