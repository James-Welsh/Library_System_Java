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
		if (resource == null) {
			System.out.println("resource parameter cannot be null.");
			return false;
		}
		return (this.libraryResources.contains(resource));
	}
	
	/**
	 * 
	 * @param member
	 * @return
	 */
	public boolean containsLibraryMember(LibraryMember member) {
		if (member == null) {
			System.out.println("member parameter cannot be null.");
			return false;
		}
		return (this.libraryMembers.contains(member));
	}
	
	/**
	 * 
	 * @param resource
	 * @param newTitle
	 */
	public void editResourceTitle(Resource resource, String newTitle) {
		if (resource == null) {
			System.out.println("resource parameter cannot be null.");
		} else if (this.containsResource(resource)) {
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
		if (resource == null) {
			System.out.println("resource parameter cannot be null.");
			return null;
		} else if (this.libraryResources.isEmpty()) {
			System.out.println("Resource does not exist in the library.");
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
		if (resource == null) {
			System.out.println("resource parameter cannot be null.");
		} else if (this.libraryResources.isEmpty()) {
			System.out.println("There are no resources to remove.");
		} else if (this.libraryResources.contains(resource)) {
			this.libraryResources.remove(resource);
		} else {
			System.out.println("Resouce not in library.");
		}
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeResourceByIndex(int index) {
		if (index < this.libraryResources.size() && index >= 0) {
			this.libraryResources.remove(index);
		} else {
			System.out.println("Index proovided does not exist.");
		}
	}
	
	/**
	 * 
	 */
	public void printAvailableBooks() {
		for (Resource resource : libraryResources) {
			if (resource instanceof Book) {
				if (((Book) resource).isAvailable()) {
					((Book)resource).printResourceDetails();
				}
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int numberOfResources() {
		return this.libraryResources.size();
	}
	
	/**
	 * 
	 * @param resource
	 */
	public void addResource(Resource resource) {
		if (resource == null) {
			System.out.println("resource parameter cannot be null");
		} else {
			this.libraryResources.add(resource);
			resource.setLibrary(this);
		}
	}
	
	/**
	 * 
	 * @param member
	 */
	public void addLibraryMember(LibraryMember member) {
		if (member == null) {
			System.out.println("member parameter cannot be null");
		} else {
			this.libraryMembers.add(member);
			member.setLibrary(this);
		}
	}
	
	/**
	 * 
	 * @param device
	 */
	public void addElectronicDevice(ElectronicDevice device) {
		if (device == null) {
			System.out.println("device parameter cannot be null");
		} else {
			this.libraryDevices.add(device);
			device.setLibrary(this);
		}
	}
	
	/**
	 * 
	 * @param book
	 * @param member
	 */
	public void lendBook(Book book, LibraryMember member) {
		if (book == null || member == null) {
			System.out.println("Neither of the parameters can be a null value.");
		} else if (!this.containsLibraryMember(member)) {
			System.out.println("Member does not exist in library.");	
		} else if (!this.containsResource(book)) {
			System.out.println("Book does not exist in library.");
		} else if (!book.isAvailable()){
			System.out.println("Book is curently unavailable.");
		} else if (member.numberOfBooksOnLoan() >= 5) {
			System.out.println("You can not take out more than 5 books at any one time");
		} else {
			member.addBook(book);
			book.setCurrentHolder(member);
			System.out.println("Book successfully loaned.");
		}
	}
	
	/**
	 * 
	 * @param book
	 * @param addDamages
	 * @param damages
	 */
	public void returnBook(Resource book, boolean addDamages, String damages) {
		if (book == null) {
			System.out.println("book parameter cannot be null.");
		} else if (!this.containsResource(book)) {
			System.out.println("Resource does not exist in this library.");
		} else if (book instanceof ElectronicResource) {
			System.out.println("Electronic resource is not a book and cannot be returned.");
		} else if (addDamages) {
			((Book)book).addDamages(damages);
			((Book)book).getCurrentHolder().returnBook((Book)book);
			System.out.println("Book returned, and damages added.");
		} else {
			((Book)book).getCurrentHolder().returnBook((Book)book);
			System.out.println("Book returned with no new damages");
		}
	}
	
	/**
	 * 
	 * @param message
	 */
	public void sendMessage(String message) {
		for (LibraryMember member : libraryMembers) {
			if (member.numberOfBooksOnLoan() > 0) {
				member.reviceMessage(message);
			}
		}
	}
	
	/**
	 * 
	 */
	public void printAllPhysicalResources() {
		boolean foundResource = false;
		
		for (Resource resource : libraryResources) {
			if (resource instanceof Book) {
				foundResource = true;
				((Book)resource).printResourceDetails();
			}
		}
		
		if (!foundResource) {
			System.out.println("Library contains no physical resources :(");
		}
	}
	
	/**
	 * 
	 */
	public void printAllElectronicResources() {
		boolean foundResource = false;
		
		for (Resource resource : libraryResources) {
			if (resource instanceof ElectronicResource) {
				foundResource = true;
				((ElectronicResource)resource).printResourceDetails();
			}
		}
		
		if (!foundResource) {
			System.out.println("Library contains no electronic resources :(");
		}
	}
}
