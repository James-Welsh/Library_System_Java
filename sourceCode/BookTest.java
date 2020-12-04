import org.junit.jupiter.api.Test;

/**
 * Test class for the Book class that also indirectly tests the 
 * Resource class as well.
 * 
 *  @author James Welsh
 */
class BookTest {
	private Book book = new Book();

	/**
	 * The test also tests the getLibrary() method as well as setLibrary().
	 * <p>
	 * It tests library cannot be set to null using the function, it can be
	 * set to a library object and that it can be change to another library
	 * object once library is already set as a library object.
	 */
	@Test
	void testSetLibrary() {
		assert book.getLibrary() == null; //Test test library initialised to correct value.
		
		//Test that getLibrary returns the exact same object in memory.
		Library testLibraryOne = new Library();
		book.setLibrary(testLibraryOne);
		assert book.getLibrary() == testLibraryOne;
		
		//Test it can set it when the library is already a non-null object.
		Library testLibraryTwo = new Library();
		book.setLibrary(testLibraryTwo);
		assert book.getLibrary() == testLibraryTwo;
		
		//Test library can not be set to null.
		book.setLibrary(null); //Should not work.
		assert book.getLibrary() == testLibraryTwo; //Should still be this object.
	}
	
	/**
	 * The test tests the getResourceId method as well as setResourceId().
	 * <p>
	 * Tests the initialised value, then that it handles strings of less than and
	 * more than 8 characters. Finally tests that an acceptable value is accepted
	 * and the resourceId data member is updated.
	 */
	@Test
	void testsetResourceId() {
		assert book.getResourceId().equals("00000000"); //Test initialised value.
		
		//Test resourceId cannot be less than 8 characters.
		book.setResourceId("1234");
		assert book.getResourceId().equals("00000000");
		
		//Test resourceId cannot be more than 8 characters.
		book.setResourceId("123456789A");
		assert book.getResourceId().equals("00000000");
		
		//Test resourceId is set when an 8 character string is given.
		book.setResourceId("12345678");
		assert book.getResourceId().equals("12345678");
	}
	
	/**
	 * The test tests the getTitle() method as well as setTitle().
	 * <p>
	 * Tests the initialised value before modifying the title and testing again.
	 */
	@Test
	void testSetTitle() {
		assert book.getTitle().equals("Title"); //Test standard initialisation value.
		
		//Test setting title.
		book.setTitle("A new title");
		assert book.getTitle().equals("A new title");
	}
	
	/**
	 * The test tests the getAuthor() method as well as setAuthor().
	 * <p>
	 * Tests the initialised value before modifying the author and testing again.
	 */
	@Test
	void testSetAuthor() {
		assert book.getAuthor().equals("Author"); //Test standard initialisation value.
		
		//Test setting author.
		book.setAuthor("A new author");
		assert book.getAuthor().equals("A new author");
	}
	
	/**
	 * The tests tests getPublicationYear() as well as setPublicationYear().
	 * <p>
	 * Tests the initial value before then testing that both positive and
	 * negative years are accepted.
	 */
	@Test
	void testSetPublicationYear() {
		assert book.getPublicationYear() == 1900; //Test standard initialisation value.
		
		//Test trying to a negative or BC year. This is allowed by design.
		book.setPublicationYear(-100);
		assert book.getPublicationYear() == -100;
		
		//Test a positive or AD year.
		book.setPublicationYear(1997);
		assert book.getPublicationYear() == 1997;
	}
	
	/**
	 * The test tests getnumberOfPages() as well as setNumberOfPages().
	 * <p>
	 * Tests the initial value before testing that the number of pages cannot be
	 * negative or zero. Finally it tests that for a positive integer numberOfPages
	 * is updated.
	 */
	@Test
	void testSetNumberOfPages() {
		assert book.getNumberOfPages() == 100; //Test standard initialisation value.
		
		//Test pages can not be negative.
		book.setNumberOfPages(-1);
		assert book.getNumberOfPages() == 100;
		
		//Test pages can not be zero.
		book.setNumberOfPages(0);
		assert book.getNumberOfPages() == 100;
			
		//Test pages can be set to a positive value.
		book.setNumberOfPages(350);
		assert book.getNumberOfPages() == 350;
		
	}
	
	//All of the super class (Resource) methods have been tested by this point.
	
	/**
	 * Tests getISBN() as well as setISBN().
	 * <p>
	 * Tests the initial value before updating it and testing again.
	 */
	@Test
	void testSetISBN() {
		assert book.getISBN().equals("978-3-16-148410-0"); //Test standard initialisation value.
		
		//Test it can be set to a new value
		book.setISBN("123-321-123-32-43");
		book.getISBN().equals("123-321-123-32-43");
		
	}
	
	/**
	 * Tests getEdition as well as setEdition().
	 * <p>
	 * Tests the initialised value before testing that it works for all editions 1 to 13
	 * and it doesn't allow zero or negative editions. It then chooses a few random edition
	 * integers.
	 */
	@Test
	void testSetEdition() {
		book.getEdition().equals("2nd Edition"); //Test standard initialisation value.
		
		//Test edition cannot be 0
		book.setEdition(0);
		book.getEdition().equals("2nd Edition");
		
		//Test edition cannot be negative
		book.setEdition(-1);
		book.getEdition().equals("2nd Edition");
		
		//Test for 1st
		book.setEdition(1);
		book.getEdition().equals("1st Edition");

		//Test for 2nd
		book.setEdition(2);
		book.getEdition().equals("2nd Edition");
		
		//Test for 3rd
		book.setEdition(3);
		book.getEdition().equals("3rd Edition");
		
		//Test for 4th
		book.setEdition(4);
		book.getEdition().equals("4th Edition");
		
		//Test for 5th
		book.setEdition(5);
		book.getEdition().equals("5th Edition");
		
		//Test for 6th
		book.setEdition(6);
		book.getEdition().equals("6th Edition");
		
		//Test for 7th
		book.setEdition(7);
		book.getEdition().equals("7th Edition");
		
		//Test for 8th
		book.setEdition(8);
		book.getEdition().equals("8th Edition");
		
		//Test for 9th
		book.setEdition(9);
		book.getEdition().equals("9th Edition");
		
		//Test for editions over 9
		book.setEdition(10);
		book.getEdition().equals("10th Edition");
		book.setEdition(11);
		book.getEdition().equals("11th Edition");
		book.setEdition(12);
		book.getEdition().equals("12th Edition");
		book.setEdition(13);
		book.getEdition().equals("13th Edition");
		book.setEdition(342);
		book.getEdition().equals("342nd Edition");
		book.setEdition(123421);
		book.getEdition().equals("123421st Edition");
		
	}
	
	/**
	 * This test tests both getCurrentHolder() and isAvailable() as well as
	 * setCurrentHolder().
	 * <p>
	 * Tests book cannot be set to null, it can be set if a member belonging to
	 * the same library as the book attempts to take it out and the book is available.
	 * It also tests that both book and member have to belong to the library and that
	 * the member cannot be changed if book is currently out on loan.
	 */
	@Test
	void testSetCurrentHolder() {
		Library libraryOne = new Library();
		Library libraryTwo = new Library();
		Book bookTwo = new Book();
		LibraryMember member = new LibraryMember();
		LibraryMember memberTwo = new LibraryMember();
		libraryOne.addLibraryMember(member);
		libraryOne.addLibraryMember(memberTwo);
		libraryOne.addResource(book);
		libraryTwo.addResource(bookTwo);
		
		assert book.getCurrentHolder() == null; //Test standard initialisation value.
		
		//Test libraryMember can be set if it's available and both book and member
		//belong to the same library.
		book.setCurrentHolder(member);
		assert book.getCurrentHolder() == member;
		
		//Test libraryMember cannot be set to null.
		book.setCurrentHolder(null);
		assert book.getCurrentHolder() == member;
		
		//Test libraryMember can not be assigned to a book if both are not members of
		//the same library.
		bookTwo.setCurrentHolder(member);
		assert bookTwo.getCurrentHolder() == null;
		
		//Test that a user cannot take out an unavailable book.
		book.setCurrentHolder(memberTwo);
		assert book.getCurrentHolder() == member;	
	}
	
	/**
	 * Tests the addDamages() and the getDamages methods.
	 *<p>
	 * Tests the initial value, that the initial damage can be set and then that
	 * subsequent damages are appended and separated by a comma.
	 */
	@Test
	void testAddDamages() {
		assert book.getDamages().equals(""); //Test standard initialisation value.
		
		//Add damages once.
		book.addDamages("damage one");
		assert book.getDamages().equals("damage one");
		
		//Add damages again.
		book.addDamages("damage two");
		assert book.getDamages().equals("damage one, damage two");
	}
	
	/**
	 * Tests the makeBookAvailable() method.
	 * <p>
	 * Tests initial value, sets a new holder and then checks that the function
	 * successfully sets the currentHolder to null.
	 */
	@Test
	void testMakeBookAvailable() {
		Library library = new Library();
		LibraryMember member = new LibraryMember();
		library.addLibraryMember(member);
		library.addResource(book);
		
		assert book.getCurrentHolder() == null; //Test initial value.
		
		//set new holder
		book.setCurrentHolder(member);
		assert book.getCurrentHolder() == member;
		
		//test makeBookAvailable()
		book.makeBookAvailible();
		assert book.getCurrentHolder() == null;
	}
}
