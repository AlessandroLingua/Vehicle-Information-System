/**
 * Truck.java
 * 
 * This class represents a truck in the Car Rental Agency system.
 * It implements both the Vehicle interface (for common vehicle attributes)
 * and the TruckVehicle interface (for truck-specific attributes such as
 * cargo capacity and transmission type).
 * 
 * The class includes input validation to ensure that the cargo capacity
 * is a positive value and that the transmission type is one of the
 * accepted values: Manual or Automatic.
 * 
 * @author Ale
 * @version 1.0
 */
public class Truck implements Vehicle, TruckVehicle {

    /** The make (manufacturer) of the truck */
    private String make;

    /** The model of the truck */
    private String model;

    /** The year of manufacture of the truck */
    private int yearOfManufacture;

    /** The cargo capacity of the truck in tons */
    private double cargoCapacity;

    /** The transmission type of the truck (Manual or Automatic) */
    private String transmissionType;

    /**
     * Constructs a new Truck object with the specified make, model,
     * and year of manufacture.
     * 
     * @param make              the manufacturer of the truck
     * @param model             the model name of the truck
     * @param yearOfManufacture the year the truck was manufactured
     */
    public Truck(String make, String model, int yearOfManufacture) {
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
     * Sets the cargo capacity with validation.
     * The cargo capacity must be a positive value.
     * 
     * @param capacity the cargo capacity in tons
     * @throws IllegalArgumentException if capacity is not positive
     */
    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Error: Cargo capacity must be a positive value.");
        }
        this.cargoCapacity = capacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Sets the transmission type with validation.
     * Accepted values are: Manual or Automatic (case-insensitive).
     * 
     * @param transmissionType the transmission type to set
     * @throws IllegalArgumentException if the transmission type is not valid
     */
    @Override
    public void setTransmissionType(String transmissionType) {
        String normalized = transmissionType.trim().toLowerCase();
        if (!normalized.equals("manual") && !normalized.equals("automatic")) {
            throw new IllegalArgumentException(
                "Error: Transmission type must be Manual or Automatic.");
        }
        // Store with proper capitalization
        this.transmissionType = normalized.substring(0, 1).toUpperCase()
                + normalized.substring(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     * Returns a formatted string representation of the truck's details.
     * 
     * @return a string containing all truck attributes
     */
    @Override
    public String toString() {
        return "========================================\n"
             + "         TRUCK DETAILS                  \n"
             + "========================================\n"
             + "  Make             : " + make + "\n"
             + "  Model            : " + model + "\n"
             + "  Year             : " + yearOfManufacture + "\n"
             + "  Cargo Capacity   : " + cargoCapacity + " tons\n"
             + "  Transmission     : " + transmissionType + "\n"
             + "========================================";
    }
}
