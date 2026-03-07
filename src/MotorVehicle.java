/**
 * MotorVehicle.java
 * 
 * This interface defines the behavior specific to motorcycle-type vehicles.
 * It includes methods for setting and retrieving the number of wheels
 * and the type of motorcycle. Classes implementing this interface must
 * provide concrete implementations of these motorcycle-specific attributes.
 * 
 * @author Ale
 * @version 1.0
 */
public interface MotorVehicle {

    /**
     * Sets the number of wheels for the motorcycle.
     * 
     * @param wheels the number of wheels to set
     */
    void setNumberOfWheels(int wheels);

    /**
     * Retrieves the number of wheels of the motorcycle.
     * 
     * @return the number of wheels as an integer
     */
    int getNumberOfWheels();

    /**
     * Sets the type of motorcycle.
     * 
     * @param type the type of motorcycle (Sport, Cruiser, or Off-Road)
     */
    void setMotorcycleType(String type);

    /**
     * Retrieves the type of the motorcycle.
     * 
     * @return the motorcycle type as a String
     */
    String getMotorcycleType();
}
