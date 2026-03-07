/**
 * Vehicle.java
 * 
 * This interface defines the contract for all vehicle types in the
 * Car Rental Agency system. Any class that implements this interface
 * must provide concrete implementations for retrieving the vehicle's
 * make, model, and year of manufacture.
 * 
 * @author Ale
 * @version 1.0
 */
public interface Vehicle {

    /**
     * Retrieves the make (manufacturer) of the vehicle.
     * 
     * @return the make of the vehicle as a String
     */
    String getMake();

    /**
     * Retrieves the model of the vehicle.
     * 
     * @return the model of the vehicle as a String
     */
    String getModel();

    /**
     * Retrieves the year of manufacture of the vehicle.
     * 
     * @return the year of manufacture as an integer
     */
    int getYearOfManufacture();
}
