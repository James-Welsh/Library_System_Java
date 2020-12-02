import java.util.ArrayList;

public class Library {
    
    private ArrayList<LibraryMember> libraryMembers;
    private ArrayList<Resource> libraryResources;
    private ArrayList<ElectronicDevice> libraryDevices;
    private String libraryName;
    
    /**
     * Takes no parameters and creates a generic library with the name 'name'.
     */
    public Library() {
    	this.libraryName = "name";
    	this.libraryMembers = new ArrayList<LibraryMember>();
    	this.libraryResources = new ArrayList<Resource>();
    	this.libraryDevices = new ArrayList<ElectronicDevice>();
    }

    /**
     * Sets the libraryName upon initialisation of the object to the parameter provided.
     * 
     * @param libraryName	The string representing the name of the library.
     */
    public Library(String libraryName) {
        this.libraryName = libraryName;
    	this.libraryMembers = new ArrayList<LibraryMember>();
    	this.libraryResources = new ArrayList<Resource>();
    	this.libraryDevices = new ArrayList<ElectronicDevice>();
    }

	/**
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}

	/**
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/**
	 * @return the libraryMembers
	 */
	public ArrayList<LibraryMember> getLibraryMembers() {
		return libraryMembers;
	}

	/**
	 * @return the libraryResources
	 */
	public ArrayList<Resource> getLibraryResources() {
		return libraryResources;
	}

	/**
	 * @return the libraryDevices
	 */
	public ArrayList<ElectronicDevice> getLibraryDevices() {
		return libraryDevices;
	}
	
	/**
	 * 
	 */
	public void printLibraryDetails() {
		System.out.println("Library Name: " + this.libraryName);
		this.printAllMembers();
		this.printAllResources();
		this.printAllDevices();
	}
	
	/**
	 * 
	 */
	public void printAllMembers() {
		System.out.println("Members:\n");
		if (this.libraryMembers.isEmpty()) {
			System.out.println("There are currently no members.");
		} else {
			for (LibraryMember member : libraryMembers) {
				member.printMemberDetails();
			}
		}
	}
	
	/**
	 * 
	 */
	public void printAllResources() {
		System.out.println("Resources:\n");
		if (this.libraryResources.isEmpty()) {
			System.out.println("There are currently no resources.");
		} else {
			for (Resource resource : libraryResources) {
				resource.printResourceDetails();
			}
		}
	}
	
	/**
	 * 
	 */
	public void printAllDevices() {
		System.out.println("Electronic Devices:\n");
		if (this.libraryDevices.isEmpty()) {
			System.out.println("There are currently no devices.");
		} else {
			for (ElectronicDevice electronicDevice : libraryDevices) {
				electronicDevice.printDeviceDetails();
			}
		}
	}
	
	/**
	 * 
	 */
	public void printAvailableDevices() {
		boolean foundDevice = false;
		
		System.out.println("Available Electronic Devices:\n");
		if (this.libraryDevices.isEmpty()) {
			System.out.println("There are currently no available devices.");
		} else {
			for (ElectronicDevice electronicDevice : libraryDevices) {
				if (electronicDevice.isAvailable()) {
					electronicDevice.printDeviceDetails();
					foundDevice = true;
				}
			}
		}
		
		if (!foundDevice) {
			System.out.println("There are currently no available devices.");
		}
	}
	
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public boolean containsResource(Resource resource) {
		return (this.libraryResources.contains(resource));
	}
	
	/**
	 * 
	 * @param resource
	 * @param newTitle
	 */
	public void editResourceTitle(Resource resource, String newTitle) {
		if (this.containsResource(resource)) {
			resource.setTitle(newTitle);
		} else {
			System.out.println("Resource does not exist in the library.");
		}
	}
	
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public Resource findResource(Resource resource) {
		if (this.libraryResources.isEmpty()) {
			System.out.println("There are no resources to search.");
			return null;
		} else if (this.containsResource(resource)) {
			return resource;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param ISBN
	 */
	public void findResourceByISBN(String ISBN) {
		int numberOfResourcesFound = 0;
		
		if (this.libraryResources.isEmpty()) {
			System.out.println("There are no resources to search.");
		} else {
			for (Resource resource : libraryResources) {
				if (resource instanceof Book) {
					if (((Book) resource).getISBN().equals(ISBN)) {
						resource.printResourceDetails();
						numberOfResourcesFound++;
					}
				}
			}
		}
		
		if (numberOfResourcesFound == 0) {
			System.out.println("No resources found matching that ISBN");
		} else {
			System.out.println("Number Of Resources Found: " + numberOfResourcesFound);
		}
	}
	
	/**
	 * 
	 * @param author
	 */
	public void findResourceByAuthor(String author) {
		int numberOfResourcesFound = 0;
		
		if (this.libraryResources.isEmpty()) {
			System.out.println("There are no resources to search.");
		} else {
			for (Resource resource : libraryResources) {
				if (resource.getAuthor().equals(author)) {
					resource.printResourceDetails();
					numberOfResourcesFound++;
				}
			}
		}
		
		if (numberOfResourcesFound == 0) {
			System.out.println("No resources found matching that author.");
		} else {
			System.out.println("Number Of Resources Found: " + numberOfResourcesFound);
		}
	}
	
	/**
	 * 
	 * @param resource
	 */
	public void removeResource(Resource resource) {
		if (this.libraryResources.isEmpty()) {
			System.out.println("There are no resources to remove.");
		} else if (this.libraryResources.contains(resource)) {
			this.libraryResources.remove(resource);
		} else {
			System.out.println("Resouce not in library.");
		}
	}
	
	
	
}
