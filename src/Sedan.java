public class Sedan extends MotorVehicle {

    double trunkSpaceLs;

    public Sedan(
            String make,
            String model,
            double avgSpeedKmh,
            int numberOfWheels,
            double engineDisplacementLs,
            double trunkSpaceLs
    ) {
        super(make, model, avgSpeedKmh, numberOfWheels, engineDisplacementLs);
        this.trunkSpaceLs = trunkSpaceLs;
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }
}
