import java.util.ArrayList;

/**
 * Represents a member of the library with the ability to borrow and return
 * books.
 * Each user has a membership Id, a first and last name, an email, a list of books on
 * loan and a list of messages.
 * <p>
 * Each user belongs to only one library but can have zero or many books.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-28
 * */
public class LibraryMember {

	private Library library;
    private String memberId;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Book> books;
    private ArrayList<String> messages;
    
    public LibraryMember() {
    	this.library = null;
        this.memberId = "000000";
        this.firstName = "fName";
        this.lastName = "lName";
        this.email = "email@email";
        this.books = new ArrayList<Book>();
        this.messages = new ArrayList<String>();
    }

	/**
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * @param library 	The library member to set, cannot be null.
	 */
	public void setLibrary(Library library) {
		if (library == null) {
			System.out.println("library parameter cannot be null.");
		} else {
			this.library = library;
		}
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	
	/**
	 * 
	 * Sets the value of memberId. This must be a string of length 8 and cannot be the same
	 * as any other member of the library.
	 * 
	 * @param memberId	The memberId string to set.
	 */
	public void setMemberId(String memberId) {
		boolean isAllowed = true; //track if memberId is allowed.
		
		if (memberId.length() != 8) {
			//If not 8 characters long
			System.out.println("Sorry, the members Id must be 8 characters long.");
			isAllowed = false; //update flag.

		}
		
		for (LibraryMember member : this.library.getLibraryMembers()) {
			if (memberId.equals(member.getMemberId())) {
				//if member already exists with identical Id.
				System.out.println("Sorry member Id already exists.");
				isAllowed = false; //update flag.
			}
		}
		if (isAllowed) {
			//If memberId is valid.
			this.memberId = memberId;
		}
	}
	
    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
     * Changes the users email address. It checks that the String entered
     * contains an "@" and is therefore deemed to be a valid email address.
     *
     * @param email A string representing the library members email address. It
     *              must contain the '@' character at some point in it.
     * */
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Please enter a valid email address.");
        }
    }

	/**
	 * @return the books
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}

	/**
	 * @return the messages
	 */
	public ArrayList<String> getMessages() {
		return messages;
	}

    /**
     * Prints all the data members of the class in an easy to read format.
     * */
    public void printMemberDetails() {
        System.out.println("Member Id: " + this.memberId + "\nFirst Name: " +
                this.firstName + "\nLast Name: " + this.lastName + "\nEmail: " +
                this.email + "\nBooks: " );
        for (Book book : books) {
            book.printResourceDetails();
        }
        System.out.println("Messages: ");
        this.printMessages();
    }

    /**
     * gets the library members full name.
     *
     * @return library members full name.
     * */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Prints all the users messages. If there are no messages it prints an
     * appropriate string instead.
     * */
    public void printMessages() {
        if (this.messages.isEmpty()) {
        	//If there are no messages
            System.out.println("You currently have no messages.");
        } else {
        	//If there are messages to print.
            for (String message : messages) {
                System.out.println(message);    
            }
        }
    }
    
    /**
     * Adds a message to the users list of messages.
     * 
     * @param message	The message the user is receiving. Cannot be an empty
     * 					string.
     */
    public void reviceMessage(String message) {
    	if (message.length() > 0) {
    		//If string is not empty.
    		this.messages.add(message);
    	} else {
    		//If string is empty.
    		System.out.println("Message must contain at least one character.");
    	}
    }

    /**
     * Adds a book to the users list of books and sets the member as its holder.
     * If the book is not available then the user is shown an appropriate
     * message.
     *
     * @param book  The book the user is attempting to take out.
     * */
    public void addBook(Book book) {
        if (book.isAvailable()) {
        	//If book has no current member taking it out on loan.
            book.setCurrentHolder(this);
            this.books.add(book);
        } else {
        	//If book is not available.
            System.out.println("The book you are trying to borrow is currently "
                    + "not available.");
        }
    }

    /**
     * Allows the library member to return the book back to the library, where
     * it will be available for another member to take out.
     *
     * @param book  The book the user is attempting to return.
     * */
    public void returnBook(Book book) {
        if (!this.books.contains(book)) {
        	//If the member does not have the book on loan.
            System.out.println("Sorry, you are not currently a holder of this " +
                    "book and therefore cannot return it.");
        } else {
        	//If member currently has book on loan.
        	book.makeBookAvailible();
        	this.books.remove(book);
        	System.out.println("Book successfully returned!");
        }
        
    }

    /**
     * Prints details on all of the books the user currently has on loan. If the
     * user has no books an appropriate message is shown.
     * */
    public void printBooks() {
    	if (this.books.isEmpty()) {
    		//If no books on loan.
    		System.out.println("Sorry, you currently have no books on loan.");
    	} else {
    		//If user has books on loan print them.
	    	for (Book book : books) {
				book.printResourceDetails();
			}
    	}
    }
    
    /**
     *	Gets the number of books the user currently has on loan.
     *
     * @return The number of books the libraryMember currently has out on loan.
     */
    public int numberOfBooksOnLoan() {
    	return this.books.size();
    }
}
