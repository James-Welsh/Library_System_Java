/**
 * Represents an electronic device within the library with data members
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
     * Fetches the data stored in the library data member.
     * 
	 * @return the library object.
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * Sets the library object stored in the library data member.
	 * 
	 * @param library	The library to set. This cannot be null.
	 */
	public void setLibrary(Library library) {
		if (library == null) {
			System.out.println("library parameter cannot be null.");
		} else {
			this.library = library;
		}
	}

	/**
	 * Fetches the string representing the deviceId.
	 * 
	 * @return the deviceId data member.
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * Sets the string representing the device. It checks all the argument
	 * is a valid diviceId.
	 * 
	 * @param deviceId	The deviceId to set. This must be 8 characters and cannot
	 * 					be the same as another devices deviceId that is currently
	 * 					belonging to the same library.
	 */
	public void setDeviceId(String deviceId) {
		boolean IdAllowed = true; //A flag to keep track of whether the value passes tests.
		
		if (deviceId.length() != 8) {
			//If deviceId is not 8 characters long.
			System.out.println("Sorry, the deviceId must be 8 characters long.");
			IdAllowed = false;
		}
		
		for (ElectronicDevice device : this.library.getLibraryDevices()) {
			//For every device in the library.
			if (deviceId.equals(device.getDeviceId())) {
				//If the deviceId passed as an argument is the same as a device in the
				//library.
				System.out.println("Sorry device Id already exists.");
				IdAllowed = false;
			}
		}
		if (IdAllowed) {
			//If deviceId passed all test and so is allowed.
			this.deviceId = deviceId;
		}
	}

	/**
	 * Gets the string representing the devices location within the library.
	 * 
	 * @return the deviceLocation string.
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
	 * Gets the string representing device type.
	 * 
	 * @return the deviceType string.
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 *  Sets the deviceType data member to a string passed in.
	 *  
	 * @param deviceType	The string representation of he device type.
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 *  Checks if a device is currently being used by a library member or not.
	 *
	 *  @return A boolean representing whether a device is available or not.
	 *          Returns true if the device is available or false otherwise.
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
