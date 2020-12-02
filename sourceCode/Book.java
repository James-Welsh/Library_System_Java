/**
 * <h1>Book</h1>
 * Represents a book within the library that inherits from the Resource class.
 * This class adds an ISBN for the book, the edition, a string representing
 * damages and the current LibraryMember holding the book. A book can be held
 * by 0 or 1 LibraryMembers.
 * 
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-27
 * */
 
public class Book extends Resource {
    
    private String ISBN;
    private String edition;
    private String damages;
    private LibraryMember currentHolder;
    
    /**
     * A generic constructor for the class that initialises the data members
     * to sane values.
     */
    public Book() {
    	super();
    	this.ISBN = "978-3-16-148410-0";
    	this.edition = "2nd edition";
    	this.damages = "";
    	this.currentHolder = null;
    }

    /**
     * A constructor that can be used to easily set values for every data
     * member upon initialisation of an object. Mainly used for testing.
     *
     * @param library			The library object that contains the book.
     * @param resourceId		The identification number for the book.
     * @param title				The title of the book.
     * @param author			The author of the book.
     * @param publicationYear	The year of the books publication.
     * @param numberOfPages		The number of pages contained within the book.
     * @param ISBN				The string representation of the books ISBN.
     * @param edition			The specific edition of the book.
     */
    public Book(Library library, String resourceId, String title, String author,
            int publicationYear, int numberOfPages, String ISBN, String edition) {

        super(library, resourceId, title, author, publicationYear, numberOfPages);
        this.ISBN = ISBN;
        this.edition = edition;
        this.damages = "";
        this.currentHolder = null;
    }

    /**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the value of the data member 'edition'.
	 * 
	 * @param edition	The integer representation of the edition. The code will then
	 * 					generate the edition string making sure that it is correct. The
	 * 					argument cannot be less than 1.
	 */
	public void setEdition(int edition) {
		if (edition < 1) {
			System.out.println("Edition cannot be less than 1");
		}
		
		String editionString = "";
		int finalDigit = edition % 10;
		
		if (finalDigit == 1) {
			editionString += edition + "st Edition";
		} else if (finalDigit == 2) {
			editionString += edition + "nd Edition";
		} else if (finalDigit == 3) {
			editionString += edition + "rd Edition";
		} else {
			editionString = edition + "th Edition";
		}
		
		this.edition = editionString;
	}

	/**
	 * @return the damages
	 */
	public String getDamages() {
		return damages;
	}

	/**
	 * @return the currentHolder
	 */
	public LibraryMember getCurrentHolder() {
		return currentHolder;
	}

	/**
	 * Changes the current owner to a new one, or if there is no owner (i.e. 
	 * currentHolder is set to null) an owner is attributed to the book.
	 *
	 * @param libraryMember The member of the library who the ownership of the
	 *                      book is transferred to.
	 * */
	public void setCurrentHolder(LibraryMember libraryMember) {
	    if (!this.isAvailable()) {
	    	System.out.println("Sorry, this book already belongs to another member.");
	    } else if (libraryMember.getLibrary() != super.getLibrary()) {
	    	//If the libraryMember does not belong to the same library as the book.
	    	System.out.println("This user attempting to take out the book is not " +
	    			"currently a member of the library.");
	    } else {
	    	this.currentHolder = libraryMember;
	    	System.out.println("Owner successfully set.");
	    }
	}

	/**
     * Prints the data stored in all the Book class data members,as well as all
     * the data stored in the Books parent class, Resource, data members in an
     * easy to read format.
     * */
    @Override
    public void printResourceDetails() {
        String damages;
        String currentHolder;

        if (this.damages.length() == 0) {
            damages = "There is currently no damage to this book.";
        } else {
            damages = this.damages;
        }

        if (this.isAvailable()) {
            currentHolder = "This book is available at the library";
        } else {
            currentHolder = "This book is currently not available. It is on " + 
                " loan to " + this.currentHolder.getFullName();
        }

        super.printResourceDetails();
        System.out.println("ISBN: " + this.ISBN + "\n" + "Edition: " +
                this.edition + "\n" + "Damages: " + damages + "\n" + 
                "Availability: " + currentHolder);
    }

    /**
     * Checks if a book is currently on loan to a library member.
     *
     * @return returns true if the book is in the library and false otherwise.
     * */
    public boolean isAvailable() {
        return (this.currentHolder == null);
    }

    /**
     * Updates the string that describes all damages to the book. If the book
     * has no damages it simply adds the damage report, otherwise the string is
     * preceded by a commas to separate all the damage descriptions into a list.
     *
     * @param damages   A text description of the new damages to the book to
     *                  append to the damage description.
     * */
    public void addDamages(String damages) {
        if (this.damages.length() == 0) {
            this.damages += damages;
        } else {
            this.damages += ", " + damages;
        }
    }

    /**
     * Frees the book from it current owner and makes the book available to
     * other library members to take out.
     * */
    public void makeBookAvailible() {
        this.currentHolder = null;
    }
}
