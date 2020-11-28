/**
 * Represents a resource at the library and is the parent class to
 * ElectronicResource (online paper, pdf, e-book) and Book. The class defines
 * data members resourceId, title, author, publicationYear and numberOfPages that
 * are revlevant to both ElectronicResources and Books.
 * <p>
 * One Resource is related to only one Library.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-18
 * */

public abstract class Resource {
    
    private String resourceId;
    private String title;
    private String author;
    private int publicationYear;
    private int numberOfPages;

    public Resource(String resourceId, String title, String author,
            int publicationYear, int numberOfPages) {
        
        this.resourceId = resourceId;
        this.title =  title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    /**
     * print all the data members in a easy to read format.
     * */
    public void printResourceDetails() {
        System.out.println("ResourceId: " + this.resourceId + "\n" + "Title: " +
                this.title + "\n" + "Author: " + this.author + "\n" +
                "Year Published: " + this.publicationYear + "\n" + "Pages: " +
                this.numberOfPages);
    }
}
