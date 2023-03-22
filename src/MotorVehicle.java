public class MotorVehicle extends Vehicle {

    private int numberOfWheels;
    private double engineDisplacementLs;

    public MotorVehicle(
            String make,
            String model,
            double avgSpeedKmh,
            int numberOfWheels,
            double engineDisplacementLs
    ) {
        super(make, model, avgSpeedKmh);
        this.numberOfWheels = numberOfWheels;
        this.engineDisplacementLs = engineDisplacementLs;
    }

    public void makeNoise() {
        System.out.println("Vroom vroom");
    }

    public void startEngine() {
        System.out.println("Engine started vroom voom");
    }
}
