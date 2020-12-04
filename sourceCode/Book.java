/**
 * Book
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
     * Gets the string representing the ISBN of a book.
     * 
	 * @return the string representation of the books ISBN.
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Sets the ISBN to the given string passed into the function.
	 * 
	 * @param ISBN	The string representation of the books ISBN
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	/**
	 * Gets the string representing the edition of the book
	 * 
	 * @return the getEdition string.
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the string value of the data member 'edition'.
	 * 
	 * @param edition	The integer representation of the edition. The code will then
	 * 					generate the edition string making sure that it is correct. The
	 * 					argument cannot be less than 1.
	 */
	public void setEdition(int edition) {
		if (edition < 1) {
			System.out.println("Edition cannot be less than 1");
		}
		
		String editionString = ""; //Initialise the string to set.
		int finalDigit = edition % 10; //last individual digit of an integer.
		
		if (edition == 11 || edition == 12 || edition == 13) {
			editionString = edition + "th Edition"; //11th, 12th, 13th		
		} else if (finalDigit == 1) {
			editionString += edition + "st Edition"; //1st
		} else if (finalDigit == 2) {
			editionString += edition + "nd Edition"; //2nd
		} else if (finalDigit == 3) {
			editionString += edition + "rd Edition"; //3rd
		}  else {
			editionString = edition + "th Edition"; //4th, 5th, 6th, 7th ,8th ,9th, 10th ...
		}
		
		this.edition = editionString;
	}

	/**
	 * Returns the string representing the damages.
	 * 
	 * @return all the damages to the book.
	 */
	public String getDamages() {
		return damages;
	}

	/**
	 * Gets the current library member loaning the book if it is in loan. Returns
	 * null otherwise.
	 * 
	 * @return the currentHolder LibraryMember object.
	 */
	public LibraryMember getCurrentHolder() {
		return currentHolder;
	}

	/**
	 * Changes the current owner to a new one, or if there is no owner (i.e. 
	 * currentHolder is set to null) an owner is attributed to the book. It
	 * will not let the libraryMember object be set to null. This can be done
	 * using the 'makeBookAvailable()' function.
	 *
	 * @param libraryMember The member of the library who the ownership of the
	 *                      book is transferred to.
	 * */
	public void setCurrentHolder(LibraryMember libraryMember) {
		if (libraryMember == null) {
			System.out.println("libraryMember parameter cannot be null.");
		} else if (!this.isAvailable()) {
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
