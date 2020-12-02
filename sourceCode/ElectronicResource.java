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
     * A constructor that can be used to easily set values for every data
     * member upon initialisation of an object. Mainly used for testing.
     *
     * @param library					The library object that contains the electronic resource.
     * @param resourceId				The identification number for the electronic resource.
     * @param title						The title of the electronic resource.
     * @param author					The author of the electronic resource.
     * @param publicationYear			The year of the electronic resources publication.
     * @param numberOfPages				The number of pages contained within the electronic resource.
     * @param electronicResourceType	The type of electronic resource.
     */
    public ElectronicResource(Library library, String resourceId, String title, String author,
            int publicationYear, int numberOfPages, String electronicResourceType) {

        super(library, resourceId, title, author, publicationYear, numberOfPages);
        this.electronicResourceType = electronicResourceType;
        this.compatableDevices = new ArrayList<ElectronicDevice>();
    }

    /**
	 * @return the electronicResourceType
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
		
		boolean allowedValue = false;
		
		for (String value : allowedValues) {
			if (electronicResourceType.toLowerCase().equals(value)) {
				allowedValue = true;
				break;
			}
		}
		
		if (allowedValue) {
			this.electronicResourceType = electronicResourceType.toLowerCase();
		} else {
			System.out.println("Reource type " + electronicResourceType + " does not exist.");
		}
	}

	/**
	 * @return the compatableDevices
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
            System.out.println("Sorry you entered a null reference as a " +
                    "paramter, this is not allowed.");
        } else if (electronicDevice instanceof ElectronicDevice) {
            compatableDevices.add(electronicDevice);
        } else {
            System.out.println("The object you entered was not an electronic " +
                    "device.");
        }
    }
}
