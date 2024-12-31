package VehicleRentalManagement;
public interface Rentable {
    void rent(Customer customer, int days); // Rent a vehicle
    void returnVehicle();                   // Return a vehicle
}
