/**
 * Car.java
 * 
 * This class represents a car in the Car Rental Agency system.
 * It implements both the Vehicle interface (for common vehicle attributes)
 * and the CarVehicle interface (for car-specific attributes such as
 * number of doors and fuel type).
 * 
 * The class includes input validation to ensure that the number of doors
 * falls within a realistic range and that the fuel type is one of the
 * accepted values: Petrol, Diesel, or Electric.
 * 
 * @author Ale
 * @version 1.0
 */
public class Car implements Vehicle, CarVehicle {

    /** The make (manufacturer) of the car */
    private String make;

    /** The model of the car */
    private String model;

    /** The year of manufacture of the car */
    private int yearOfManufacture;

    /** The number of doors on the car */
    private int numberOfDoors;

    /** The fuel type of the car (Petrol, Diesel, or Electric) */
    private String fuelType;

    /**
     * Constructs a new Car object with the specified make, model,
     * and year of manufacture.
     * 
     * @param make              the manufacturer of the car
     * @param model             the model name of the car
     * @param yearOfManufacture the year the car was manufactured
     */
    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMake() {
        return make;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Sets the number of doors for the car with validation.
     * The number of doors must be between 2 and 6 (inclusive).
     * 
     * @param doors the number of doors to set
     * @throws IllegalArgumentException if doors is not between 2 and 6
     */
    @Override
    public void setNumberOfDoors(int doors) {
        if (doors < 2 || doors > 6) {
            throw new IllegalArgumentException(
                "Error: Number of doors must be between 2 and 6.");
        }
        this.numberOfDoors = doors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * Sets the fuel type for the car with validation.
     * Accepted values are: Petrol, Diesel, or Electric (case-insensitive).
     * 
     * @param fuelType the fuel type to set
     * @throws IllegalArgumentException if the fuel type is not valid
     */
    @Override
    public void setFuelType(String fuelType) {
        String normalized = fuelType.trim().toLowerCase();
        if (!normalized.equals("petrol") && !normalized.equals("diesel")
                && !normalized.equals("electric")) {
            throw new IllegalArgumentException(
                "Error: Fuel type must be Petrol, Diesel, or Electric.");
        }
        // Store with proper capitalization
        this.fuelType = normalized.substring(0, 1).toUpperCase()
                + normalized.substring(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Returns a formatted string representation of the car's details.
     * 
     * @return a string containing all car attributes
     */
    @Override
    public String toString() {
        return "========================================\n"
             + "         CAR DETAILS                    \n"
             + "========================================\n"
             + "  Make             : " + make + "\n"
             + "  Model            : " + model + "\n"
             + "  Year             : " + yearOfManufacture + "\n"
             + "  Number of Doors  : " + numberOfDoors + "\n"
             + "  Fuel Type        : " + fuelType + "\n"
             + "========================================";
    }
}
