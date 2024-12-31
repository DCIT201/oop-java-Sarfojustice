package VehicleRentalManagement;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerId;
    private String name;
    private String contactInfo;
    private List<RentalTransaction> rentalHistory;

    public Customer(String customerId, String name, String contactInfo) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new IllegalArgumentException("Contact information cannot be null or empty.");
        }

        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.rentalHistory = new ArrayList<>();
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    // Add rental transaction to history
    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    // Check if customer is eligible for rentals (e.g., no outstanding rentals)
    public boolean isEligibleForRental() {
        for (RentalTransaction transaction : rentalHistory) {
            if (!transaction.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Contact: " + contactInfo;
    }
}
