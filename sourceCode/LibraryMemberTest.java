
import org.junit.jupiter.api.Test;

class LibraryMemberTest {
	
	private LibraryMember member =  new LibraryMember();
	private Library library = new Library();
	private Book book = new Book();

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

	@Test
	void testSetFirstName() {
		//Test initial value.
		assert member.getFirstName().equals("fName");
		
		//Test changing first name.
		member.setFirstName("New fName");
		assert member.getFirstName().equals("New fName");
	}

	@Test
	void testSetLastName() {
		//Test initial value.
		assert member.getLastName().equals("lName");
		
		//Test changing last name.
		member.setLastName("New lName");
		assert member.getLastName().equals("New lName");
	}

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
	
	@Test
	void testGetMessages() {
		member.reviceMessage("test");
		member.reviceMessage("test2");
		
		assert member.getMessages().size() == 2;
		assert member.getMessages().get(0).equals("test");
		assert member.getMessages().get(1).equals("test2");
	}

	@Test
	void testGetFullName() {
		member.setFirstName("James");
		member.setLastName("Welsh");
		
		//Test function
		assert member.getFullName().equals("James Welsh");
	}

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
