public class Bicycle extends Vehicle {

    public Bicycle(String make, String model, double avgSpeedKmh) {
        super(make, model, avgSpeedKmh);
    }

    public void makeNoise() {
        System.out.println("crrrt ccrrt crrt");
    }

    public void screamAtMotorist() {
        System.out.println("SHARE THE ROAD!");
    }
}
