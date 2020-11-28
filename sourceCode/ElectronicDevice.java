/**
 * Respresents an electronic device within the library with data members
 * representing the unique Id, its location in the library, the device type (
 * computer, tablet etc.), and whether the device is currently being used by
 * a library member or not.
 * <p>
 * Each device belongs to one library and can be used to access 0 or more
 * electronic resources.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-28
 * */

public class ElectronicDevice {

    private String deviceId;
    private String deviceLocation;
    private String deviceType;
    private boolean isAvailable;
    
    public ElectronicDevice(String deviceId, String deviceLocation, String deviceType) {
        
        this.deviceId = deviceId;
        this.deviceLocation = deviceLocation;
        this.deviceType = deviceType;
        this.isAvailable = true;
    }

    /**
     * Prints all the devices data members in an easy to read format.
     * */
    public void printDeviceDetails() {
        String availability;

        if (this.isAvailable) {
            availability = "Available.";
        } else {
            availability = "Currently unavailable.";
        }

        System.out.println("Device Id: " + this.deviceId + "\nDevice Loacation:"
                + this.deviceLocation + "\nDevice Type: " + this.deviceType +
                "\nAvailability: " + availability);
    }

    /**
     * Updates the devices availability status.
     *
     * @param isAvailable   takes a boolean value: true if device is available,
     *                      false if the device is being used.
     * */
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Changes the location of the device, for example if the device gets moved
     * to a new location in the library then it's location can be updated to
     * reflect this.
     *
     * @param newLocation   A string representing the new location that the
     *                      device will now reside.
     * */
    public void changeLocation(String newLocation) {
        this.deviceLocation = newLocation;
    }

    /**
     *  Checks if a device is currently being used by a library member or not.
     *
     *  @return A boolean representing whether a device is available or not.
     *          Returns true if the device is availble or false otherwise.
     * */
    public boolean checkAvailability() {
        return this.isAvailable;
    }
}
