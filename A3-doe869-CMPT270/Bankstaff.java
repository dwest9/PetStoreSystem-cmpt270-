// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



public class Bankstaff {
/**
 * This is a class of a Bankstaff similiar to that of "Person class" but with one added attribute of first name,
 * last name, insurance number and employee ID number
 */


    /**
     * first attribute for first name of the staff
     */

    private String First_name;

    /**
     * second attribute for last name of the staff
     */

    private String Last_name;

    /**
     * third attribute for the social insurance number of the staff
     */

    private String Sin_num;

    /**
     * fourth attribute for employee ID number of the staff
     */

    private String ID_number;


    /**
     * this initiate the staff first name, last name, social number and ID number
     * @param f_name the first name of the staff
     * @param l_name the last name of the staff
     * @param sinNUM the social insurance number of the staff
     * @param ID_num the staff ID number
     */
    public Bankstaff(String f_name, String l_name, String sinNUM, String ID_num){
        this.First_name = f_name;
        this.Last_name = l_name;
        this.Sin_num = sinNUM;
        this.ID_number = ID_num;
    }

    // this gets back the first name of the bank staff
    public String getFirst_name() {
        return First_name;
    }

    // this gets back the last name of the bank staff
    public String getLast_name() {
        return Last_name;
    }

    // this gets back the social insurance number of the bank staff
    public String getSin_num() {
        return Sin_num;
    }

    // this gets back the ID number of the bank staff
    public String getID_number() {
        return ID_number;
    }

    // this changes the first name of the bank staff
    public void setFirst_name(String first_name) {
        this.First_name = first_name;
    }

    // this changes the last name of the bank staff
    public void setLast_name(String last_name) {
        this.Last_name = last_name;
    }

    // this changes the social number of the bank staff
    public void setSin_num(String sin_num) {
        this.Sin_num = sin_num;
    }

    // this changes the ID number of the bank staff
    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    /**
     * this returns a String representation of the properties of the bankstaff.
     */

    public String toString(){
        return First_name + " " + Last_name + " " + Sin_num + " " + ID_number;
    }


    /**
     * this a method for testing the Bankstaff class
     */

    public static void main(String[] arg){

        // testing all the methods with the first testing of the employee
        String f_name = "Chris";
        String l_name =  "Andrew";
        String sinNUM = "98765432";
        String ID_num = "87654321";
        Bankstaff employee = new Bankstaff(f_name, l_name, sinNUM, ID_num);

        String result = employee.getFirst_name();
        String reason = "joining the constructor with getFirst_Name()";
        String expected = f_name;
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with getLast_name()";
        result = employee.getLast_name();
        expected = l_name;
        if( ! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with setFirst_name()";
        expected = "David";
        employee.setFirst_name(expected);
        //  The result gets the new firstname being set already
        result = employee.getFirst_name();
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with setLast_name()";
        expected = "James";
        employee.setLast_name(expected);
        //  The result gets the new lastname being set already
        result = employee.getLast_name();
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with Sin_num()";
        result = employee.getSin_num();
        expected = sinNUM;
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "the constructor with toString()";
        expected = "David" + " " + "James" + " " + "98765432" + " " + "87654321";
        result = employee.toString();
        if(!result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }


        /**
         *  Testing all the methods with second sample of a staff
         */

        employee = new Bankstaff("Mary", "Bella", "09532165", "76543211");

        if (employee.getFirst_name() != "Mary"){
            System.out.println("Test failed for getFirst_name()");
        }

        if(employee.getLast_name() != "Bella"){
            System.out.println("Test failed for getLast_name()");
        }

        expected = "09532165";
        result = employee.getSin_num();
        if(result != expected){
            System.out.println("Test failed for getSin_num");
        }

        expected = "76543211";
        result = employee.getID_number();
        if(result != expected){
            System.out.println("Test failed for getID_number");
        }

        employee.setFirst_name("Janet");
        employee.setLast_name("Eve");
        String c = employee.toString();
        if(!c.equals("Janet" + " " + "Eve" + " " + "09532165" + " " + "76543211")){
            System.out.println("Test failed for setFirst_name, setLast_name, Sin_num, ID_number");
        }

        System.out.println("*** Test complete ***");

    }
}
