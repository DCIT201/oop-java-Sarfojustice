package VehicleRentalManagement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create the rental agency
        RentalAgency rentalAgency = new RentalAgency("Fast Wheels Rental");

        // Add vehicles to the fleet
        rentalAgency.addVehicle(new Car("CAR001", "Toyota Corolla", 50, true));
        rentalAgency.addVehicle(new Car("CAR002", "Honda Civic", 45, false));
        rentalAgency.addVehicle(new Motorcycle("MOTO001", "Yamaha R3", 30, true));
        rentalAgency.addVehicle(new Motorcycle("MOTO002", "Kawasaki Ninja", 35, false));
        rentalAgency.addVehicle(new Truck("TRUCK001", "Ford F-150", 80, 3.0));

        // Create customers
        Customer customer1 = new Customer("CUST001", "John Doe", "john.doe@example.com");
        Customer customer2 = new Customer("CUST002", "Jane Smith", "jane.smith@example.com");

        // Display available vehicles
        System.out.println("Available Vehicles:");
        List<Vehicle> availableVehicles = rentalAgency.listAvailableVehicles();
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }

        // Rent a car for John Doe
        System.out.println("\nRenting a vehicle for " + customer1.getName() + "...");
        RentalTransaction transaction1 = rentalAgency.rentVehicle("TRANS001", customer1, "CAR001", 3);
        System.out.println("Transaction Details:");
        System.out.println(transaction1);


        // Attempt to rent a motorcycle for Jane Smith
        // Attempt to rent a motorcycle for Jane Smith
        System.out.println("\nRenting a vehicle for " + customer2.getName() + "...");
        RentalTransaction transaction2 = rentalAgency.rentVehicle("TRANS002", customer2, "MOTO001", 5);
        System.out.println("Transaction Details:");
        System.out.println(transaction2);


        // Display customers details
        System.out.println("\nCustomer Details:");
        System.out.println(customer1);
        System.out.println(customer2);


        // Display available vehicles after rental
        System.out.println("\nAvailable Vehicles After Rental:");
        availableVehicles = rentalAgency.listAvailableVehicles();
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }

        // Return the car rented by John Doe
        System.out.println("\nReturning vehicle for John Doe...");
        rentalAgency.returnVehicle("TRANS001");

        // Display available vehicles after return
        System.out.println("\nAvailable Vehicles After Return:");
        availableVehicles = rentalAgency.listAvailableVehicles();
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }

        // Return the motorcycle rented by Jane Smith
        System.out.println("\nReturning vehicle for Jane Smith...");
        rentalAgency.returnVehicle("TRANS002");

        // Display final status of the rental agency
        System.out.println("\nFinal Rental Agency Status:");
        System.out.println(rentalAgency);
    }
}
