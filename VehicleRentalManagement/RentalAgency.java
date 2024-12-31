package VehicleRentalManagement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private String agencyName;
    private List<Vehicle> fleet;
    private List<RentalTransaction> transactions;

    public RentalAgency(String agencyName) {
        if (agencyName == null || agencyName.isEmpty()) {
            throw new IllegalArgumentException("Agency name cannot be null or empty.");
        }
        this.agencyName = agencyName;
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    // List all available vehicles
    public List<Vehicle> listAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Rent a vehicle
    public RentalTransaction rentVehicle(String transactionId, Customer customer, String vehicleId, int rentalDays) {
        if (!customer.isEligibleForRental()) {
            throw new IllegalStateException("Customer is not eligible for rental.");
        }

        Vehicle vehicle = null;
        for (Vehicle v : fleet) {
            if (v.getVehicleId().equals(vehicleId)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null || !vehicle.isAvailable()) {
            throw new IllegalStateException("Vehicle is not available.");
        }

        RentalTransaction transaction = new RentalTransaction(transactionId, customer, vehicle, LocalDate.now(), rentalDays);
        transactions.add(transaction);
        customer.addRentalTransaction(transaction);

        return transaction;
    }

    // Return a vehicle
    public void returnVehicle(String transactionId) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                transaction.completeRental();
                return;
            }
        }
        throw new IllegalArgumentException("Transaction ID not found.");
    }

    @Override
    public String toString() {
        return "Rental Agency: " + agencyName + ", Fleet Size: " + fleet.size() + ", Transactions: " + transactions.size();
    }
}

