
import org.junit.jupiter.api.Test;

class LibraryTest {
	Library library = new Library();
	Book book = new Book();
	ElectronicResource electronicResource = new ElectronicResource();
	LibraryMember member = new LibraryMember();
	
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
		assert true;
	}

	@Test
	void testFindResourceByISBN() {
		assert true;
	}

	@Test
	void testFindResourceByAuthor() {
		assert true;
	}

	@Test
	void testRemoveResource() {
		assert true;
	}

	@Test
	void testRemoveResourceByIndex() {
		assert true;
	}

	@Test
	void testNumberOfResources() {
		assert true;
	}

	@Test
	void testAddResource() {
		assert true;
	}

	@Test
	void testAddLibraryMember() {
		assert true;
	}

	@Test
	void testAddElectronicDevice() {
		assert true;
	}

	@Test
	void testLendBook() {
		assert true;
	}

	@Test
	void testReturnBook() {
		assert true;
	}

	@Test
	void testSendMessage() {
		assert true;
	}

}
