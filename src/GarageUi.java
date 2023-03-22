import javax.swing.*;
import java.util.Arrays;

public class GarageUi {

    private Garage garage;

    public GarageUi() {
        this.garage = new Garage();
    }

    public void showMainMenu() {
        String[] options = {"Add vehicle", "Remove vehicle", "Show vehicles"};
        String option = (String) JOptionPane.showInputDialog(
                null,
                "Select the operation",
                "Op Select",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (option.equals("Add vehicle")) {
            showAddVehicleDialog();
        } else if (option.equals("Remove vehicle")) {
            showRemoveVehicleDialog();
        } else {
            showListVehiclesDialog();
        }
    }

    private void showAddVehicleDialog() {
        String make = JOptionPane.showInputDialog("Enter the make of the vehicle");
        String model = JOptionPane.showInputDialog("Enter the model of the vehicle");
        String speedStr = JOptionPane.showInputDialog("Enter the speed");
        double speed = Double.parseDouble(speedStr);
        String spotStr = JOptionPane.showInputDialog("Enter the spot to park it");
        int spot = Integer.parseInt(spotStr);

        Vehicle v = new Vehicle(make, model, speed);
        this.garage.parkVehicleInSpot(v, spot);
        JOptionPane.showMessageDialog(null, "Parked vehicle " + v + " in spot " + spot);
    }

    private void showRemoveVehicleDialog() {
        String spotStr = JOptionPane.showInputDialog("Enter the spot to remove from");
        int spot = Integer.parseInt(spotStr);
        Vehicle v = this.garage.removeVehicleAtSpot(spot);
        JOptionPane.showMessageDialog(null, "Removed vehicle " + v + " from spot " + spot);
    }

    private void showListVehiclesDialog() {
        String message = Arrays.toString(this.garage.parkingSpots);
        JOptionPane.showMessageDialog(null, message);
    }

}
