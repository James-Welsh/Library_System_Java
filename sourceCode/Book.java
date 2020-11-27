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
                " loan to: " + this.currentHolder;
        }

        super.printResourceDetails();
        System.out.println("ISBN: " + this.ISBN + "\n" + "Edition: " +
                this.edition + "\n" + "Damages: " + damages + "\n" + 
                "Availability: " + currentHolder);
    }

    public boolean isAvailable() {
        return this.currentHolder == null;
    }

    public void addDamages(String damages) {
        if (this.damages.length() == 0) {
            this.damages += damages;
        } else {
            this.damages += ", " + damages;
        }
    }

    public void setCurrentHolder(LibraryMember libraryMember) {
        this.currentHolder = libraryMember;
    }
}
