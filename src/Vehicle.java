import java.util.List;

public  class Vehicle {

    public String make;
    public String model;
    public double avgSpeedKmh;


    public Vehicle(String make, String model, double avgSpeedKmh) {
        this.make = make;
        this.model = model;
        this.avgSpeedKmh = avgSpeedKmh;
    }


    public void moveForward(int meters) {
        System.out.println("Moved forward " + meters + " meters");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", avgSpeedKmh=" + avgSpeedKmh +
                '}';
    }
}
