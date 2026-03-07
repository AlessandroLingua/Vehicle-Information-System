/**
 * TruckVehicle.java
 * 
 * This interface defines the behavior specific to truck-type vehicles.
 * It includes methods for setting and retrieving the cargo capacity
 * and the transmission type. Classes implementing this interface must
 * provide concrete implementations of these truck-specific attributes.
 * 
 * @author Ale
 * @version 1.0
 */
public interface TruckVehicle {

    /**
     * Sets the cargo capacity for the truck.
     * 
     * @param capacity the cargo capacity in tons
     */
    void setCargoCapacity(double capacity);

    /**
     * Retrieves the cargo capacity of the truck.
     * 
     * @return the cargo capacity in tons as a double
     */
    double getCargoCapacity();

    /**
     * Sets the transmission type for the truck.
     * 
     * @param transmissionType the transmission type (Manual or Automatic)
     */
    void setTransmissionType(String transmissionType);

    /**
     * Retrieves the transmission type of the truck.
     * 
     * @return the transmission type as a String
     */
    String getTransmissionType();
}
