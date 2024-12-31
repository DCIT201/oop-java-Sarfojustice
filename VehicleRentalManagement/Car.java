package VehicleRentalManagement;
public class Car extends Vehicle{
    private boolean hasAirConditioning;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasAirConditioning) {
            cost += 15.0 * days; // Additional cost for air conditioning
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
            throw new IllegalStateException("Car is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        if (isAvailable()) {
            throw new IllegalStateException("Car is already available.");
        }
        setAvailable(true);
        System.out.println("Car has been returned and is now available.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Air Conditioning: " + (hasAirConditioning ? "Yes" : "No");
    }
}
