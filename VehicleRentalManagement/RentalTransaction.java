package VehicleRentalManagement;
import java.time.LocalDate;

public class RentalTransaction {
    private String transactionId;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;
    private boolean isCompleted;

    public RentalTransaction(String transactionId, Customer customer, Vehicle vehicle, LocalDate rentalDate, int rentalDays) {
        if (transactionId == null || transactionId.isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or empty.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (rentalDate == null) {
            throw new IllegalArgumentException("Rental date cannot be null.");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }

        this.transactionId = transactionId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.returnDate = rentalDate.plusDays(rentalDays);
        this.totalCost = vehicle.calculateRentalCost(rentalDays);
        this.isCompleted = false;

        vehicle.rent(customer, rentalDays);
    }

    // Complete the transaction and return the vehicle
    public void completeRental() {
        if (isCompleted) {
            throw new IllegalStateException("Transaction is already completed.");
        }
        vehicle.returnVehicle();
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Customer: " + customer.getName() +
                ", Vehicle: " + vehicle.getModel() + ", Rental Date: " + rentalDate +
                ", Return Date: " + returnDate + ", Total Cost: $" + totalCost + ", Completed: " + isCompleted;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

}
