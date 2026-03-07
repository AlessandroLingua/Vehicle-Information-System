import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * VehicleInformationSystem.java
 * 
 * This is the main driver class for the Car Rental Agency's Vehicle
 * Information System. It provides an interactive console-based menu
 * that allows users to create different types of vehicles (Car,
 * Motorcycle, and Truck), input their details, and display the
 * information for all registered vehicles.
 *
 * @author Alessandro Lingua
 * @version 1.0
 */
public class VehicleInformationSystem {

    /** List to store all created vehicle objects using the Vehicle interface */
    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    /** Scanner object for reading user input */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main method that serves as the entry point of the program.
     * It displays a menu and processes user selections in a loop
     * until the user chooses to exit.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("*   VEHICLE INFORMATION SYSTEM      *");
        System.out.println("*   Car Rental Agency Application   *");
        System.out.println("*************************************\n");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    createCar();
                    break;
                case 2:
                    createMotorcycle();
                    break;
                case 3:
                    createTruck();
                    break;
                case 4:
                    displayAllVehicles();
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you for using the Vehicle "
                        + "Information System. Goodbye!");
                    break;
                default:
                    System.out.println("\nError: Invalid choice. "
                        + "Please select a number between 1 and 5.\n");
            }
        }

        scanner.close();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Add a Car");
        System.out.println("2. Add a Motorcycle");
        System.out.println("3. Add a Truck");
        System.out.println("4. Display All Vehicles");
        System.out.println("5. Exit");
    }

    /**
     * Prompts the user to enter car-specific details, creates a Car object,
     * and adds it to the vehicle list. Includes error handling for invalid
     * input values.
     */
    private static void createCar() {
        System.out.println("\n--- Add a New Car ---");

        String make = getStringInput("Enter car brand: ");
        String model = getStringInput("Enter car model: ");
        int year = getIntInput("Enter year of manufacture: ");

        Car car = new Car(make, model, year);

        // Set number of doors with error handling
        boolean validDoors = false;
        while (!validDoors) {
            try {
                int doors = getIntInput("Enter number of doors (2-6): ");
                car.setNumberOfDoors(doors);
                validDoors = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Set fuel type with error handling
        boolean validFuel = false;
        while (!validFuel) {
            try {
                String fuel = getStringInput(
                    "Enter fuel type (Petrol/Diesel/Electric): ");
                car.setFuelType(fuel);
                validFuel = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicleList.add(car);
        System.out.println("Car added successfully!\n");
    }

    /**
     * Prompts the user to enter motorcycle-specific details, creates a
     * Motorcycle object, and adds it to the vehicle list. Includes error
     * handling for invalid input values.
     */
    private static void createMotorcycle() {
        System.out.println("\n--- Add a New Motorcycle ---");

        String make = getStringInput("Enter motorcycle brand: ");
        String model = getStringInput("Enter motorcycle model: ");
        int year = getIntInput("Enter year of manufacture: ");

        Motorcycle motorcycle = new Motorcycle(make, model, year);

        // Set number of wheels with error handling
        boolean validWheels = false;
        while (!validWheels) {
            try {
                int wheels = getIntInput("Enter number of wheels (2-3): ");
                motorcycle.setNumberOfWheels(wheels);
                validWheels = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Set motorcycle type with error handling
        boolean validType = false;
        while (!validType) {
            try {
                String type = getStringInput(
                    "Enter motorcycle type (Sport/Cruiser/Off-Road): ");
                motorcycle.setMotorcycleType(type);
                validType = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicleList.add(motorcycle);
        System.out.println("Motorcycle added successfully!\n");
    }

    /**
     * Prompts the user to enter truck-specific details, creates a Truck
     * object, and adds it to the vehicle list. Includes error handling
     * for invalid input values.
     */
    private static void createTruck() {
        System.out.println("\n--- Add a New Truck ---");

        String make = getStringInput("Enter truck brand: ");
        String model = getStringInput("Enter truck model: ");
        int year = getIntInput("Enter year of manufacture: ");

        Truck truck = new Truck(make, model, year);

        // Set cargo capacity with error handling
        boolean validCapacity = false;
        while (!validCapacity) {
            try {
                double capacity = getDoubleInput(
                    "Enter cargo capacity (in tons): ");
                truck.setCargoCapacity(capacity);
                validCapacity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Set transmission type with error handling
        boolean validTransmission = false;
        while (!validTransmission) {
            try {
                String transmission = getStringInput(
                    "Enter transmission type (Manual/Automatic): ");
                truck.setTransmissionType(transmission);
                validTransmission = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicleList.add(truck);
        System.out.println("Truck added successfully!\n");
    }

    /**
     * Displays the details of all vehicles currently stored in the system.
     * Uses polymorphism through the Vehicle interface and the overridden
     * toString() method in each concrete class.
     */
    private static void displayAllVehicles() {
        System.out.println("\n--- All Registered Vehicles ---");

        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles have been registered yet.\n");
            return;
        }

        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println("\nVehicle #" + (i + 1));
            System.out.println(vehicleList.get(i).toString());
        }
        System.out.println();
    }

    /**
     * Helper method to safely read an integer value from the user.
     * Handles InputMismatchException if the user enters non-numeric data.
     * 
     * @param prompt the message to display to the user
     * @return the integer value entered by the user
     */
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Helper method to safely read a double value from the user.
     * Handles InputMismatchException if the user enters non-numeric data.
     * 
     * @param prompt the message to display to the user
     * @return the double value entered by the user
     */
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Helper method to read a non-empty string from the user.
     * 
     * @param prompt the message to display to the user
     * @return the string value entered by the user
     */
    private static String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Error: Input cannot be empty.");
        }
    }
}
