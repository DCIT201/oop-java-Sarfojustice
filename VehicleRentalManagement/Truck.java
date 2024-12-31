package VehicleRentalManagement;
public class Truck extends Vehicle {
    private double loadCapacity; // Unique feature (in tons)

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be positive.");
        }
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days + (loadCapacity * 10.0 * days); // $10/ton per day
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailable()) {
            throw new IllegalStateException("Truck is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        if (isAvailable()) {
            throw new IllegalStateException("Truck is already available.");
        }
        setAvailable(true);
        System.out.println("Truck has been returned and is now available.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Load Capacity: " + loadCapacity + " tons";
    }
}
