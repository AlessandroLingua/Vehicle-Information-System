/**
 * Motorcycle.java
 * 
 * This class represents a motorcycle in the Car Rental Agency system.
 * It implements both the Vehicle interface (for common vehicle attributes)
 * and the MotorVehicle interface (for motorcycle-specific attributes such
 * as number of wheels and motorcycle type).
 * 
 * The class includes input validation to ensure that the number of wheels
 * is realistic and that the motorcycle type is one of the accepted values:
 * Sport, Cruiser, or Off-Road.
 * 
 * @author Ale
 * @version 1.0
 */
public class Motorcycle implements Vehicle, MotorVehicle {

    /** The make (manufacturer) of the motorcycle */
    private String make;

    /** The model of the motorcycle */
    private String model;

    /** The year of manufacture of the motorcycle */
    private int yearOfManufacture;

    /** The number of wheels on the motorcycle */
    private int numberOfWheels;

    /** The type of motorcycle (Sport, Cruiser, or Off-Road) */
    private String motorcycleType;

    /**
     * Constructs a new Motorcycle object with the specified make, model,
     * and year of manufacture.
     * 
     * @param make              the manufacturer of the motorcycle
     * @param model             the model name of the motorcycle
     * @param yearOfManufacture the year the motorcycle was manufactured
     */
    public Motorcycle(String make, String model, int yearOfManufacture) {
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
     * Sets the number of wheels with validation.
     * The number of wheels must be between 2 and 3 (inclusive).
     * 
     * @param wheels the number of wheels to set
     * @throws IllegalArgumentException if wheels is not between 2 and 3
     */
    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels < 2 || wheels > 3) {
            throw new IllegalArgumentException(
                "Error: Number of wheels must be 2 or 3.");
        }
        this.numberOfWheels = wheels;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * Sets the motorcycle type with validation.
     * Accepted values are: Sport, Cruiser, or Off-Road (case-insensitive).
     * 
     * @param type the motorcycle type to set
     * @throws IllegalArgumentException if the type is not valid
     */
    @Override
    public void setMotorcycleType(String type) {
        String normalized = type.trim().toLowerCase();
        if (!normalized.equals("sport") && !normalized.equals("cruiser")
                && !normalized.equals("off-road")) {
            throw new IllegalArgumentException(
                "Error: Motorcycle type must be Sport, Cruiser, or Off-Road.");
        }
        // Store with proper capitalization
        if (normalized.equals("off-road")) {
            this.motorcycleType = "Off-Road";
        } else {
            this.motorcycleType = normalized.substring(0, 1).toUpperCase()
                    + normalized.substring(1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }

    /**
     * Returns a formatted string representation of the motorcycle's details.
     * 
     * @return a string containing all motorcycle attributes
     */
    @Override
    public String toString() {
        return "========================================\n"
             + "       MOTORCYCLE DETAILS               \n"
             + "========================================\n"
             + "  Make             : " + make + "\n"
             + "  Model            : " + model + "\n"
             + "  Year             : " + yearOfManufacture + "\n"
             + "  Number of Wheels : " + numberOfWheels + "\n"
             + "  Motorcycle Type  : " + motorcycleType + "\n"
             + "========================================";
    }
}
