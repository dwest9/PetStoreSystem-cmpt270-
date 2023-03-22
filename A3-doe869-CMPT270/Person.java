// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09




public class Person {
/**
 * This is a class of a person that has an attribute of a first name,
 * last name and insurance number
 */

    /**
     * first attribute for first name of a person
     */
    private String P_firstname;

    /**
     * second attribute for last name of a person
     */
    private String P_lastname;

    /**
     * third attribute for the social insurance number of a person
     */
    private String P_SIN;


    /**
     *
     * This initiate the case of a person first_name, last_name and sin_number
     * @param first_name the person first name
     * @param last_name the person last name
     * @param sin_num the person social insurance number
     */
    public Person(String first_name, String last_name, String sin_num ){
        this.P_firstname = first_name;
        this.P_lastname = last_name;
        this.P_SIN = sin_num;

    }

    // this gets back the first name of a person
    public String getP_firstname() {
        return P_firstname;
    }

    // this gets back the last name of a person
    public String getP_lastname() {
        return P_lastname;
    }

    // this gets back the social insurance number of a person
    public String getP_SIN() {
        return P_SIN;
    }

    // this changes the first name of a person
    public void setP_firstname(String p_firstname) {
        P_firstname = p_firstname;
    }

    // this changes the last name of a person
    public void setP_lastname(String p_lastname) {
        P_lastname = p_lastname;
    }
   // this changes the social number of a person
    public void setP_SIN(String p_SIN) {
        P_SIN = p_SIN;
    }

    /**
     * this returns a String representation of the properties of a person.
     */

    public String toString(){
        return P_firstname + " " + P_lastname + " " + P_SIN;
    }

    public static void main(String[] arg){

        // testing all the methods with the first testing of a person
        String first_name = "Chris";
        String last_name =  "Andrew";
        String sin_num = "98765432";
        Person person = new Person(first_name, last_name, sin_num);

        String result = person.getP_firstname();
        String reason = "joining the constructor with getP_firstName()";
        String expected = first_name;
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with getP_lastName()";
        result = person.getP_lastname();
        expected = last_name;
        if( ! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with setP_firstName()";
        expected = "David";
        person.setP_firstname(expected);
        //  The result gets the new firstname being set already
        result = person.getP_firstname();
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "joining the constructor with setP_lastName()";
        expected = "James";
        person.setP_lastname(expected);
        //  The result gets the new lastname being set already
        result = person.getP_lastname();
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }
        reason = "joining the constructor with P_SIN()";
        result = person.getP_SIN();
        expected = sin_num;
        if(! result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        reason = "the constructor with toString()";
        expected = "David" + " " + "James" + " " + "98765432";
        result = person.toString();
        if(!result.equals(expected)) {
            System.out.println("Expected: " + expected + "Result: "+ result + "(" + reason + ")");
        }

        /**
         *  Testing all the methods with second sample of a person
         */


        person = new Person("Mary", "Bella", "09532165");

        if (person.getP_firstname() != "Mary"){
            System.out.println("Test failed for getP_firstname()");
        }

        if(person.getP_lastname() != "Bella"){
            System.out.println("Test failed for getP_lastname()");
        }

        expected = "09532165";
        result = person.getP_SIN();
        if(result != expected){
            System.out.println("Test failed for getSIN");
        }

        person.setP_firstname("Mabella");
        person.setP_lastname("Eve");
        String c = person.toString();
        if(!c.equals("Mabella" + " " + "Eve" + " " + "09532165")){
            System.out.println("Test failed for setP_firstname, setP_lastname, P_SIN");
        }



        System.out.println("*** Test complete ***");
    }
}
