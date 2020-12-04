/**
 * Represents an electronic resource at the library. This can be a ebook, pdf,
 * online paper etc. It contains an array of electronic devices that can be
 * used to access the resource and the format that the electronic resource is
 * in, this can be a pdf, ebook ...
 * <p>
 * An electronic resource belongs to one library and can have 0 or more
 * compatable devices.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-28
 */

import java.util.ArrayList;


public class ElectronicResource extends Resource {
    
    private ArrayList<ElectronicDevice> compatableDevices;
    private String electronicResourceType;
    
    
    /**
     * A generic constructor for the class that initialises the data members
     * to sane values.
     */
    public ElectronicResource() {
    	super();
    	this.electronicResourceType = "";
    	this.compatableDevices = new ArrayList<ElectronicDevice>();
    }

    /**
     * Gets the electronicResourceType.
     * 
	 * @return the electronicResourceType string.
	 */
	public String getElectronicResourceType() {
		return electronicResourceType;
	}

	/**
	 * Sets the electronic resource type of the object and ensures that the type
	 * is allowed or warns the user.
	 * 
	 * @param electronicResourceType	the electronicResourceType to set must be an
	 * 									"online paper", a "pdf" or an "ebook".
	 */
	public void setElectronicResourceType(String electronicResourceType) {
		String[] allowedValues = {"online paper", "pdf", "ebook"};
		
		boolean allowedValue = false; //A flag to keep track if the argument is allowed or not.
		
		for (String value : allowedValues) {
			if (electronicResourceType.toLowerCase().equals(value)) {
				//Check value is one of the allowed values.
				allowedValue = true; //update flag.
				break; // stop loop.
			}
		}
		
		if (allowedValue) {
			//If value was allowed.
			this.electronicResourceType = electronicResourceType.toLowerCase();
		} else {
			//If value was not allowed.
			System.out.println("Reource type " + electronicResourceType + " does not exist.");
		}
	}

	/**
	 * Gets the array of compatableDevices that the ElectronicResources can be viewed
	 * on.
	 * 
	 * @return the compatableDevices ArrayList of ElectronicDevices.
	 */
	public ArrayList<ElectronicDevice> getCompatableDevices() {
		return compatableDevices;
	}

	/**
     * Print the details of all devices that can be used to access the
     * electronic resource regardless of whether they are available or not.
     * */
    public void printAllDevices() {
        for (ElectronicDevice electronicDevice : compatableDevices) {
            electronicDevice.printDeviceDetails();
        }
    }

    /** 
     * Prints the details of all available devices that can be used to access
     * the electronic resource.
     * */
    public void printAvailableDevices() {
        for (ElectronicDevice electronicDevice : compatableDevices) {
            if (electronicDevice.isAvailable()) {
                electronicDevice.printDeviceDetails();
            } 
        }
    }

    /**
     * Adds an electronic device object to the list of compatible devices that
     * can be used to access the electronic resource.
     *
     * @param electronicDevice  An electronic device that can be used to access
     *                          the electronic resource.
     * */
    public void addDevice(ElectronicDevice electronicDevice) {
        if (electronicDevice == null) {
        	//object cannot be passed as null.
            System.out.println("Sorry you entered a null reference as a " +
                    "paramter, this is not allowed.");
        } else if (electronicDevice instanceof ElectronicDevice) {
        	//Check object type.
            compatableDevices.add(electronicDevice);
        } else {
            System.out.println("The object you entered was not an electronic " +
                    "device.");
        }
    }
}
