/**
 * Test class for the LibraryMember class.
 * 
 *  @author James Welsh
 */

import org.junit.jupiter.api.Test;

class LibraryMemberTest {
	
	private LibraryMember member =  new LibraryMember();
	private Library library = new Library();
	private Book book = new Book();

	/**
	 * Tests both the setLibraryMember() and getLibraryMember() methods.
	 * <p>
	 * Tests library cannot be set to null, it can be set to a Library
	 * object and the initial value.
	 */
	@Test
	void testSetLibrary() {
		//Test initial value;
		assert member.getLibrary() == null;
		
		//set library to new library object.
		member.setLibrary(library);
		assert member.getLibrary() == library;
		
		//Check it cannot be set to null.
		member.setLibrary(null);
		assert member.getLibrary() == library;
		
	}

	/**
	 * Tests both the setMemberId() and getMemberId() methods.
	 * <p>
	 * Tests initial value, an allowed value, that two devices cannot have
	 * the same ID, and that the Id must be 8 characters long.
	 */
	@Test
	void testSetMemberId() {
		LibraryMember member2 = new LibraryMember();
		library.addLibraryMember(member);
		library.addLibraryMember(member2);
		member.setLibrary(library);
		member2.setLibrary(library);
		
		//Test initial value.
		assert member.getMemberId().equals("000000");
		
		//Set allowed deviceID for device
		member.setMemberId("12345678");
		assert member.getMemberId().equals("12345678");
		
		//Test two devices cannot have the same ID
		member2.setMemberId("12345678");
		assert member2.getMemberId().equals("000000");
		
		//Test too short an ID
		member2.setMemberId("12345");
		assert member2.getMemberId().equals("000000");
		
		//Test too long an ID
		member2.setMemberId("12345678999");
		assert member2.getMemberId().equals("000000");
	}

	/**
	 * Tests both the setFirstName() and getFirstName() methods.
	 * <p>
	 * Tests initial value and that firstName can be set to another string.
	 */
	@Test
	void testSetFirstName() {
		//Test initial value.
		assert member.getFirstName().equals("fName");
		
		//Test changing first name.
		member.setFirstName("New fName");
		assert member.getFirstName().equals("New fName");
	}

	/**
	 * Tests both the setLastName() and getLastName() methods.
	 * <p>
	 * Tests initial value and that lastName can be set to another string.
	 */
	@Test
	void testSetLastName() {
		//Test initial value.
		assert member.getLastName().equals("lName");
		
		//Test changing last name.
		member.setLastName("New lName");
		assert member.getLastName().equals("New lName");
	}

	/**
	 * Tests both the setEmail() and getEmail() methods.
	 * <p>
	 * Tests initial value, and that an email has to contain an "@" character.
	 */
	@Test
	void testSetEmail() {
		//Test initial value.
		assert member.getEmail().equals("email@email");
		
		//Try change email to string without @ character.
		member.setEmail("testEmail");
		assert member.getEmail().equals("email@email");
		
		//Try change email to allowed value
		member.setEmail("test@email.com");
		assert member.getEmail().equals("test@email.com");
	}
	
	/**
	 * Tests both the receiveMessafe() and geMessages() methods.
	 * <p>
	 * Tests initial value and that messages can be received and retrieved.
	 */
	@Test
	void testGetMessages() {
		member.reviceMessage("test");
		member.reviceMessage("test2");
		
		assert member.getMessages().size() == 2;
		assert member.getMessages().get(0).equals("test");
		assert member.getMessages().get(1).equals("test2");
	}

	/**
	 * Tests getFullName() method.
	 * <p>
	 * Tests that function returns the correct value.
	 */
	@Test
	void testGetFullName() {
		member.setFirstName("James");
		member.setLastName("Welsh");
		
		//Test function
		assert member.getFullName().equals("James Welsh");
	}

	/**
	 * Tests addBook() method.
	 * <p>
	 * Tests initial value, a book can be added and that an unavailable book
	 * cannot be added.
	 */
	@Test
	void testAddBook() {
		member.setLibrary(library);
		book.setLibrary(library);
		LibraryMember newMember = new LibraryMember();
		newMember.setLibrary(library);
		
		//Test initial value
		assert member.getBooks().isEmpty();
		
		//Successfully add a book.
		member.addBook(book);
		assert member.getBooks().size() == 1;
		assert member.getBooks().get(0) == book;
		
		//Try to add an unavailable book.
		newMember.addBook(book);
		assert newMember.getBooks().isEmpty();
	}
	
	/**
	 * Tests returnFunction() method.
	 * <p>
	 * Tests returning a book the member does not have on loan and returning a
	 * book that a member does have on loan.
	 */
	@Test
	void testReturnBook() {
		Book newBook = new Book();
		member.setLibrary(library);
		book.setLibrary(library);
		newBook.setLibrary(library);
		
		member.addBook(book);
		
		//Test returning a book member does not have.
		assert member.getBooks().size() == 1;
		member.returnBook(newBook);
		assert member.getBooks().size() == 1;
		
		//Return current book
		assert member.getBooks().size() == 1;
		member.returnBook(book);
		assert member.getBooks().size() == 0;
	}

	/**
	 * Tests both the numberOfBooksOnLoan() method.
	 * <p>
	 * Tests initial value, value when one book is added and value when another
	 * book is added.
	 */
	@Test
	void testNumberOfBooksOnLoan() {
		Book newBook = new Book();
		member.setLibrary(library);
		book.setLibrary(library);
		newBook.setLibrary(library);
		
		//Test 0 books.
		assert member.numberOfBooksOnLoan() == 0;
		
		//Test for adding a book.
		member.addBook(book);
		assert member.numberOfBooksOnLoan() == 1;
		
		//Add another book.
		member.addBook(newBook);
		assert member.numberOfBooksOnLoan() == 2;
	}

}
