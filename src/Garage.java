import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {

    Vehicle[] parkingSpots;

    public Garage() {
        parkingSpots = new Vehicle[100];
    }

    public Vehicle removeVehicleAtSpot(int i) {
        if (this.parkingSpots[i] == null) {
            throw new RuntimeException("No car in spot " + i);
        }
        else {
            Vehicle v = this.parkingSpots[i];
            this.parkingSpots[i] = null;
            return v;
        }
    }

    public void parkVehicleInSpot(Vehicle v, int i) {
        if (this.parkingSpots[i] == null) {
            this.parkingSpots[i] = v;
        }
        else {
            throw new RuntimeException("Car already in spot " + i);
        }
    }


}
