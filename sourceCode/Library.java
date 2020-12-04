import java.util.ArrayList;

/**
 * Library
 * Represents the Library object that will be used to store users, devices, and resources
 * as well as functionality to manipulate data within these objects stored.
 * 
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-27
 * */
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
	 * Prints all library data in an easy to read format.
	 */
	public void printLibraryDetails() {
		System.out.println("Library Name: " + this.libraryName);
		this.printAllMembers();
		this.printAllResources();
		this.printAllDevices();
	}
	
	/**
	 * Prints all members in the library.
	 */
	public void printAllMembers() {
		System.out.println("Members:\n");
		if (this.libraryMembers.isEmpty()) {
			//If there are no members to print.
			System.out.println("There are currently no members.");
		} else {
			//If there are members to print.
			for (LibraryMember member : libraryMembers) {
				//print all members.
				member.printMemberDetails();
			}
		}
	}
	
	/**
	 * Prints all resources in the Library.
	 */
	public void printAllResources() {
		System.out.println("Resources:\n");
		if (this.libraryResources.isEmpty()) {
			//If there are no resources to print.
			System.out.println("There are currently no resources.");
		} else {
			//If there are resources to print.
			for (Resource resource : libraryResources) {
				//print all resources.
				resource.printResourceDetails();
			}
		}
	}
	
	/**
	 * Prints all devices in the library.
	 */
	public void printAllDevices() {
		System.out.println("Electronic Devices:\n");
		if (this.libraryDevices.isEmpty()) {
			//If there are no devices to print.
			System.out.println("There are currently no devices.");
		} else {
			//If there are devices to print.
			for (ElectronicDevice electronicDevice : libraryDevices) {
				//print all devices.
				electronicDevice.printDeviceDetails();
			}
		}
	}
	
	/**
	 * Print all devices that are available.
	 */
	public void printAvailableDevices() {
		boolean foundDevice = false;
		
		System.out.println("Available Electronic Devices:\n");
		if (this.libraryDevices.isEmpty()) {
			//If there are no devices to print.
			System.out.println("There are currently no available devices.");
		} else {
			//If there are devices to print.
			for (ElectronicDevice electronicDevice : libraryDevices) {
				if (electronicDevice.isAvailable()) {
					//Print device if it is available.
					electronicDevice.printDeviceDetails();
					foundDevice = true;
				}
			}
		}
		
		if (!foundDevice) {
			//If there were devices in the library but none of them were available.
			System.out.println("There are currently no available devices.");
		}
	}
	
	/**
	 * Check that library contains resource object.
	 * 
	 * @param resource	The resource object to search for.
	 * @return	returns true if resource found and false otherwise.
	 */
	public boolean containsResource(Resource resource) {
		if (resource == null) {
			//Prevent passing null reference.
			System.out.println("resource parameter cannot be null.");
			return false;
		}
		return (this.libraryResources.contains(resource));
	}
	
	/**
	 * Check that library contains member object.
	 * 
	 * @param member	The LibraryMember object to search for.
	 * @return true if member is found, false otherwise.
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
	 * @param resource	The Resource object to edit the title of.
	 * @param newTitle	The new string to set the title to.
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
	 * Searches for resource and returns appropriate value.
	 * 
	 * @param resource	the Resource object to search for.
	 * @return	returns the Resource object if found or null otherwise.
	 */
	public Resource findResource(Resource resource) {
		if (resource == null) {
			//If searching for null reference.
			System.out.println("resource parameter cannot be null.");
			return null;
		} else if (this.libraryResources.isEmpty()) {
			//If library has no resources.
			System.out.println("Resource does not exist in the library.");
			return null;
		} else if (this.containsResource(resource)) {
			//If library contains the resource object.
			return resource;
		} else {
			//if library does not contain the resource object.
			return null;
		}
	}

	
	/**
	 * Searches for and prints Books with the ISBN searched for.
	 * 
	 * @param ISBN	The string representing the ISBn to search for.
	 */
	public void findResourceByISBN(String ISBN) {
		int numberOfResourcesFound = 0; //initialise variable to 0
		
		if (this.libraryResources.isEmpty()) {
			//If there are no resources to search.
			System.out.println("There are no resources to search.");
		} else {
			//If there are resources to search.
			for (Resource resource : libraryResources) {
				if (resource instanceof Book) {
					//If resource is a Book.
					if (((Book) resource).getISBN().equals(ISBN)) {
						//Compare ISBNs
						resource.printResourceDetails();
						numberOfResourcesFound++; //Resources found increases by 1.
					}
				}
			}
		}
		
		if (numberOfResourcesFound == 0) {
			//If no resources were found.
			System.out.println("No resources found matching that ISBN");
		} else {
			//Print how many resources where found in the end.
			System.out.println("Number Of Resources Found: " + numberOfResourcesFound);
		}
	}
	
	/**
	 * Searches for and prints Resources with the author searched for.
	 * 
	 * @param author	The author to search for
	 */
	public void findResourceByAuthor(String author) {
		int numberOfResourcesFound = 0; //initialise variable to 0
		
		if (this.libraryResources.isEmpty()) {
			//If there are no resources to search.
			System.out.println("There are no resources to search.");
		} else {
			for (Resource resource : libraryResources) {
				if (resource.getAuthor().equals(author)) {
					//If authors match
					resource.printResourceDetails();
					numberOfResourcesFound++; //Resources found increases by 1.
				}
			}
		}
		
		if (numberOfResourcesFound == 0) {
			//If no resources found with given author.
			System.out.println("No resources found matching that author.");
		} else {
			//Print how many resources where found in the end if at least 1 was found.
			System.out.println("Number Of Resources Found: " + numberOfResourcesFound);
		}
	}
	
	/**
	 * Removes the resource passes as a parameter.
	 * 
	 * @param resource	The resource to remove.
	 */
	public void removeResource(Resource resource) {
		if (resource == null) {
			//If resource passed is null.
			System.out.println("resource parameter cannot be null.");
		} else if (this.libraryResources.isEmpty()) {
			//If no resources to remove.
			System.out.println("There are no resources to remove.");
		} else if (this.libraryResources.contains(resource)) {
			//If resource exists.
			this.libraryResources.remove(resource);
		} else {
			//If resource does not exist.
			System.out.println("Resouce not in library.");
		}
	}
	
	/**
	 * Remove resource by index.
	 * 
	 * @param index	The index of the resource to remove. Must be in range.
	 */
	public void removeResourceByIndex(int index) {
		if (index < this.libraryResources.size() && index >= 0) {
			//If index out of range of the ArrayList.
			this.libraryResources.remove(index);
		} else {
			System.out.println("Index proovided does not exist.");
		}
	}
	
	/**
	 * prints all available books in an easy to read format.
	 */
	public void printAvailableBooks() {
		for (Resource resource : libraryResources) {
			if (resource instanceof Book) {
				//If resource id of type Book.
				if (((Book) resource).isAvailable()) {
					//Call the specific printResourceDetails method for Book.
					((Book)resource).printResourceDetails();
				}
			}
		}
	}
	
	/**
	 * Returns the number of resources in the library.
	 * 
	 * @return the integer representing the number of resources.
	 */
	public int numberOfResources() {
		return this.libraryResources.size();
	}
	
	/**
	 * Adds a resource to the library.
	 * 
	 * @param resource	The Resource object to add. Cannot be null.
	 */
	public void addResource(Resource resource) {
		if (resource == null) {
			//If resource is null.
			System.out.println("resource parameter cannot be null");
		} else {
			this.libraryResources.add(resource);
			resource.setLibrary(this);
		}
	}
	
	/**
	 * Adds a member to the library.
	 * 
	 * @param member	The LibraryMember object to add. Cannot be null.
	 */
	public void addLibraryMember(LibraryMember member) {
		if (member == null) {
			//If member is null.
			System.out.println("member parameter cannot be null");
		} else {
			this.libraryMembers.add(member);
			member.setLibrary(this);
		}
	}
	
	/**
	 * Adds a device to the library.
	 * 
	 * @param device	The ElectronicDevice object to add.
	 */
	public void addElectronicDevice(ElectronicDevice device) {
		if (device == null) {
			//If device is null.
			System.out.println("device parameter cannot be null");
		} else {
			this.libraryDevices.add(device);
			device.setLibrary(this);
		}
	}
	
	/**
	 * Lends a book to a member provided all checks are passed.
	 * 
	 * @param book		Must belong to the library, not be null and be currently available.
	 * @param member	Must belong to the library, not be null, and have less than 5 books
	 * 					currently on loan. 
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
	 * Returns a book to the library and records damages if needed.
	 * 
	 * @param book			Must be currently on loan, not null, and belong to the library.
	 * @param addDamages	A boolean. true if damages are to be added and false otherwise.
	 * @param damages		The string representing the new damage to add to the books
	 * 						damages string.
	 */
	public void returnBook(Resource book, boolean addDamages, String damages) {
		if (book == null) {
			//book cannot be null.
			System.out.println("book parameter cannot be null.");
		} else if (!this.containsResource(book)) {
			//If book exists in library.
			System.out.println("Resource does not exist in this library.");
		} else if (book instanceof ElectronicResource) {
			//If resource is not a book.
			System.out.println("Electronic resource is not a book and cannot be returned.");
		} else if (addDamages) {
			//if damages are to be added.
			((Book)book).addDamages(damages);
			((Book)book).getCurrentHolder().returnBook((Book)book);
			System.out.println("Book returned, and damages added.");
		} else {
			//If damages are not to be added.
			((Book)book).getCurrentHolder().returnBook((Book)book);
			System.out.println("Book returned with no new damages");
		}
	}
	
	/**
	 * Sends a message to all LibraryMembers belonging to the library that currently have
	 * a book on loan.
	 * 
	 * @param message	The message string to send to members.
	 */
	public void sendMessage(String message) {
		for (LibraryMember member : libraryMembers) {
			if (member.numberOfBooksOnLoan() > 0) {
				//If member has a book on loan.
				member.reviceMessage(message);
			}
		}
	}
	
	/**
	 * prints all physical resources (Books) in an easy to read format.
	 */
	public void printAllPhysicalResources() {
		boolean foundResource = false; //track if Book object exists.
		
		for (Resource resource : libraryResources) {
			if (resource instanceof Book) {
				//If Resource is a Book
				foundResource = true; //update flag.
				((Book)resource).printResourceDetails();
			}
		}
		
		if (!foundResource) {
			//If no Books were found.
			System.out.println("Library contains no physical resources :(");
		}
	}
	
	/**
	 * prints all electronic resources in an easy to read format.
	 */
	public void printAllElectronicResources() {
		boolean foundResource = false; //track if ElectronicResource object exists.
		
		for (Resource resource : libraryResources) {
			if (resource instanceof ElectronicResource) {
				//If Resource id ElectronicResource
				foundResource = true; //update flag
				((ElectronicResource)resource).printResourceDetails();
			}
		}
		
		if (!foundResource) {
			//if no ElectronicResources were found.
			System.out.println("Library contains no electronic resources :(");
		}
	}
}
