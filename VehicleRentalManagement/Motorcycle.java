package VehicleRentalManagement;
public class Motorcycle extends Vehicle {
    private boolean hasHelmet;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasHelmet) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmet = hasHelmet;
    }

    public boolean hasHelmet() {
        return hasHelmet;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasHelmet) {
            cost += 5.0 * days; // Additional cost for helmet
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailable()) {
            throw new IllegalStateException("Motorcycle is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        if (isAvailable()) {
            throw new IllegalStateException("Motorcycle is already available.");
        }
        setAvailable(true);
        System.out.println("Motorcycle has been returned and is now available.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Helmet: " + (hasHelmet ? "Yes" : "No");
    }
}
