/**
 * CarVehicle.java
 * 
 * This interface extends the behavior specific to car-type vehicles.
 * It defines methods for setting and retrieving the number of doors
 * and the fuel type of a car. Classes implementing this interface
 * must provide concrete logic for these car-specific attributes.
 * 
 * @author Ale
 * @version 1.0
 */
public interface CarVehicle {

    /**
     * Sets the number of doors for the car.
     * 
     * @param doors the number of doors to set
     */
    void setNumberOfDoors(int doors);

    /**
     * Retrieves the number of doors of the car.
     * 
     * @return the number of doors as an integer
     */
    int getNumberOfDoors();

    /**
     * Sets the fuel type for the car.
     * 
     * @param fuelType the fuel type (Petrol, Diesel, or Electric)
     */
    void setFuelType(String fuelType);

    /**
     * Retrieves the fuel type of the car.
     * 
     * @return the fuel type as a String
     */
    String getFuelType();
}
