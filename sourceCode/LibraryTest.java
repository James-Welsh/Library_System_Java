
import org.junit.jupiter.api.Test;

class LibraryTest {
	private Library library = new Library();
	private Book book = new Book();
	private ElectronicResource electronicResource = new ElectronicResource();
	private LibraryMember member = new LibraryMember();
	private ElectronicDevice device = new ElectronicDevice();
	
	@Test
	void testSetLibraryName() {
		//Test initial value.
		library.getLibraryName().equals("name");
		
		//Test setLibraryName.
		library.setLibraryName("new name");
		library.getLibraryName().equals("new name");
	}

	@Test
	void testContainsResource() {
		library.addResource(book);
		
		//Attempt to pass null as a parameter.
		assert !library.containsResource(null);
		
		//Search for a resource not in the library.
		assert !library.containsResource(electronicResource);
		
		//Search for a resource in the library.
		assert library.containsResource(book);
	}

	@Test
	void testContainsLibraryMember() {
		LibraryMember newMember = new LibraryMember();
		library.addLibraryMember(member);
		
		//Attempt to pass null as a parameter.
		assert !library.containsLibraryMember(null);
		
		//Search for a non library member.
		assert !library.containsLibraryMember(newMember);
		
		//Search for a member that exists in the library.
		assert library.containsLibraryMember(member);
	}

	@Test
	void testEditResourceTitle() {
		library.addResource(electronicResource);
		
		//Try pass a resource not in the library.
		assert book.getTitle().equals("Title");
		library.editResourceTitle(book, "test title");
		assert book.getTitle().equals("Title");
		
		//Pass a resource that does exist in the library.
		assert electronicResource.getTitle().equals("Title");
		library.editResourceTitle(electronicResource, "test title");
		assert electronicResource.getTitle().equals("test title");
	}

	@Test
	void testFindResource() {
		//Test parameter cannot be null.
		assert library.findResource(null) == null;
		
		//Test with empty array.
		assert library.findResource(book) == null;
		
		//Test with book in the library.
		library.addResource(book);
		assert library.findResource(book) == book;
		
		//Test with non empty array and resource not in library.
		assert library.findResource(electronicResource) == null;
	}

	/**
	 * This test also tests number of resources by proxy
	 */
	@Test
	void testRemoveResource() {
		//Remove a resource in the library.
		library.addResource(book);
		library.addResource(electronicResource);
		
		assert library.numberOfResources() == 2;
		assert library.containsResource(book);
		library.removeResource(book);
		assert !library.containsResource(book);
		assert library.numberOfResources() == 1;
		
		//Remove final resource
		assert library.numberOfResources() == 1;
		assert library.containsResource(electronicResource);
		library.removeResource(electronicResource);
		assert !library.containsResource(electronicResource);
		assert library.numberOfResources() == 0;
	}

	@Test
	void testRemoveResourceByIndex() {
		library.addResource(electronicResource);
		library.addResource(book);
		
		//Try index out of range
		assert library.numberOfResources() == 2;
		assert library.containsResource(book);
		assert library.containsResource(electronicResource);
		library.removeResourceByIndex(3);
		library.removeResourceByIndex(-1);
		assert library.numberOfResources() == 2;
		assert library.containsResource(book);
		assert library.containsResource(electronicResource);
		
		//Remove a resource in the library.
		assert library.numberOfResources() == 2;
		assert library.containsResource(book);
		library.removeResourceByIndex(1);
		assert !library.containsResource(book);
		assert library.numberOfResources() == 1;
		
		//Remove final resource
		assert library.numberOfResources() == 1;
		assert library.containsResource(electronicResource);
		library.removeResourceByIndex(0);
		assert !library.containsResource(electronicResource);
		assert library.numberOfResources() == 0;
	}

	@Test
	void testAddResource() {
		//Test it can not be null. All other uses have been tested in other
		//methods within this unit test.
		assert library.getLibraryResources().isEmpty();
		library.addResource(null);
		assert library.getLibraryResources().isEmpty();
	}

	@Test
	void testAddLibraryMember() {
		//Test library member cannot be null.
		assert library.getLibraryMembers().isEmpty();
		library.addLibraryMember(null);
		assert library.getLibraryMembers().isEmpty();
		
		//Test that library member is added correctly.
		library.addLibraryMember(member);
		assert library.getLibraryMembers().size() == 1;
		assert member.getLibrary() == library;
	}

	@Test
	void testAddElectronicDevice() {
		//Test device cannot be null.
		assert library.getLibraryDevices().isEmpty();
		library.addElectronicDevice(null);
		assert library.getLibraryDevices().isEmpty();
		
		//Test that device is added correctly.
		library.addElectronicDevice(device);
		assert library.getLibraryDevices().size() == 1;
		assert device.getLibrary() == library;
	}

	@Test
	void testLendBook() {
		//Test that neither parameters can be null.
		library.addResource(book);
		library.addLibraryMember(member);
		
		library.lendBook(book, null);
		assert book.isAvailable();			//Check book has not been lent.
		library.lendBook(null, member);
		assert member.getBooks().isEmpty();	//Check member does not have book.
		
		//Test that both book and member have to belong to the library.
		Book newBook = new Book();
		LibraryMember newMember = new LibraryMember();
		
		library.lendBook(newBook, member); //Book does not belong to library.
		assert newBook.isAvailable();
		assert member.getBooks().isEmpty();
		
		library.lendBook(book, newMember); //Member does not belong to library.
		assert book.isAvailable();
		assert newMember.getBooks().isEmpty();
		
		//Test that book must be available.
		library.addLibraryMember(newMember);
		book.setCurrentHolder(member);
		library.lendBook(book, newMember);
		assert book.getCurrentHolder() == member;
		assert newMember.getBooks().isEmpty();
		
		//test that function works for correct parameter values.
		book.makeBookAvailible();
		assert member.getBooks().isEmpty();
		assert book.getCurrentHolder() == null;
		library.lendBook(book, member);
		assert member.getBooks().size() == 1;
		assert book.getCurrentHolder() == member;
		
		//Test that no more than 5 books can be on loan to a single user.
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book();
		library.addResource(book1);
		library.addResource(book2);
		library.addResource(book3);
		library.addResource(book4);
		library.addResource(book5);
		assert member.numberOfBooksOnLoan() == 1;
		library.lendBook(book1, member);
		assert member.numberOfBooksOnLoan() == 2;
		library.lendBook(book2, member);
		assert member.numberOfBooksOnLoan() == 3;
		library.lendBook(book3, member);
		assert member.numberOfBooksOnLoan() == 4;
		library.lendBook(book4, member);
		assert member.numberOfBooksOnLoan() == 5;
		library.lendBook(book5, member);
		assert member.numberOfBooksOnLoan() == 5;
		
	}

	@Test
	void testReturnBook() {
		//Test it with correct environment.
		library.addResource(book);
		library.addLibraryMember(member);
		library.lendBook(book, member);
		
		//Test damages are added when true.
		assert book.getCurrentHolder() == member;
		assert member.numberOfBooksOnLoan() == 1;
		library.returnBook(book, true, "Big damages");
		assert book.getCurrentHolder() == null;
		assert member.numberOfBooksOnLoan() == 0;
		assert book.getDamages().equals("Big damages");
		
		//Test damages are not added when false.
		library.lendBook(book, member);
		assert book.getCurrentHolder() == member;
		assert member.numberOfBooksOnLoan() == 1;
		library.returnBook(book, false, "no damages");
		assert book.getCurrentHolder() == null;
		assert member.numberOfBooksOnLoan() == 0;
		assert book.getDamages().equals("Big damages");
		
		
	}

	@Test
	void testSendMessage() {
		library.addLibraryMember(member);
		library.addResource(book);
		
		//Test user does not receive message with no books on loan.
		library.sendMessage("No one will receive this :(");
		assert member.getMessages().isEmpty();
		
		//Test they do receive the message when loaning a book.
		library.lendBook(book, member);
		library.sendMessage("You will receive this");
		assert member.getMessages().size() == 1;
		assert member.getMessages().get(0).equals("You will receive this");
	}

}
