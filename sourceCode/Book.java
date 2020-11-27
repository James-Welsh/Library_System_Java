/**
 * <h1>Book</h1>
 * Represents a book within the library that inherrits from the Resource class.
 * 
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-271
 * */
 
public class Book extends Resource {
    
    private String ISBN;
    private String edition;
    private String damages;
    private LibraryMember currentHolder;

    public Book(String resourceId, String title, String author,
            int publicationYear, int numberOfPages, String ISBN, String edition) {

        super(resourceId, title, author, publicationYear, numberOfPages);
        this.ISBN = ISBN;
        this.edition = edition;
        this.damages = "";
        this.currentHolder = null;
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
     * @return returns true if the book is in the library and flase otherwise.
     * */
    public boolean isAvailable() {
        return this.currentHolder == null;
    }

    /**
     * Updates the string that describes all danages to the book. If the book
     * has no damages it simply adds the damge report, otherwise the string is
     * preceded by a comman to seperate all the damage descriptions into a list.
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
     * Changes the current owner to a new one, or if there is no owner (i.e. 
     * currentHolder is set to null) an owner is attributed to the book.
     *
     * @param libraryMember The member of the library who the ownership of the
     *                      book is transferred to.
     * */
    public void setCurrentHolder(LibraryMember libraryMember) {
        this.currentHolder = libraryMember;
    }

    /**
     * Frees the book from it current owner and makes the book available to
     * other library members to take out.
     * */
    public void makeBookAvailible() {
        this.currentHolder = null;
    }
}
