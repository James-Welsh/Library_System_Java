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

	private Library library;
    private String deviceId;
    private String deviceLocation;
    private String deviceType;
    private boolean isAvailable;
    
    /**
     * A generic constructor for the class that initialises the data members
     * to sane values.
     */
    public ElectronicDevice() {
    	this.library = null;
    	this.deviceId = "";
    	this.deviceLocation = "";
    	this.deviceType = "";
    	this.isAvailable = true;
    	
    }
    
    /**
     * A constructor that can be used to easily set values for every data
     * member upon initialisation of an object. Mainly used for testing.
     * 
     * @param library			The library to which the device belongs.
     * @param deviceId			The devices Id number.
     * @param deviceLocation	The location of the device within the Library.
     * @param deviceType		The type of device "eReader", "PC", etc...
     */
    public ElectronicDevice(Library library, String deviceId, String deviceLocation,
    		String deviceType) {
        
    	this.library = library;
        this.deviceId = deviceId;
        this.deviceLocation = deviceLocation;
        this.deviceType = deviceType;
        this.isAvailable = true;
    }

    /**
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(Library library) {
		if (library == null) {
			System.out.println("library parameter cannot be null.");
		} else {
			this.library = library;
		}
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the deviceLocation
	 */
	public String getDeviceLocation() {
		return deviceLocation;
	}

	/**
	 * Changes the location of the device, for example if the device gets moved
	 * to a new location in the library then it's location can be updated to
	 * reflect this.
	 *
	 * @param newLocation   A string representing the new location that the
	 *                      device will now reside.
	 * */
	public void setDeviceLocation(String newLocation) {
	    this.deviceLocation = newLocation;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 *  Checks if a device is currently being used by a library member or not.
	 *
	 *  @return A boolean representing whether a device is available or not.
	 *          Returns true if the device is availble or false otherwise.
	 * */
	public boolean isAvailable() {
	    return this.isAvailable;
	}

	/**
	 * Updates the devices availability status.
	 *
	 * @param isAvailable   takes a boolean value: true if device is available,
	 *                      false if the device is being used.
	 * */
	public void setIsAvailable(boolean isAvailable) {
	    this.isAvailable = isAvailable;
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
}
