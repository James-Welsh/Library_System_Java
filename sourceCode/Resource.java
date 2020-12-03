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
    
	private Library library;
    private String resourceId;
    private String title;
    private String author;
    private int publicationYear;
    private int numberOfPages;
    
    /**
     * A generic constructor for the class that initialises the data members
     * to sane values.
     */
    public Resource() {
    	this.library = null;
    	this.resourceId = "00000000";
    	this.title = "Title";
    	this.author = "Author";
    	this.publicationYear = 1900;
    	this.numberOfPages = 100;
    }

    /**
     * A constructor that can be used to easily set values for every data
     * member upon initialisation of an object. Mainly used for testing.
     * 
     * @param library			The library object that contains the resource.
     * @param resourceId		The identification number for the resource.
     * @param title				The title of the resource.
     * @param author			The author of the resource.
     * @param publicationYear	The year of the resources publication.
     * @param numberOfPages		The number of pages contained within the resource.
     */
    public Resource(Library library, String resourceId, String title,
    		String author, int publicationYear, int numberOfPages) {
        
    	this.library = library;
        this.resourceId = resourceId;
        this.title =  title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

	/**
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(Library library) {
		if (library == null) {
			System.out.println("library parameter cannot be null.");
		} else {
			this.library = library;
		}
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * A resourceId must be at 8 characters long.
	 * 
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		if (resourceId.length() == 8) {
			this.resourceId = resourceId;
		} else {
			System.out.println("resourceId must be 8 characters long.");
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publicationYear
	 */
	public int getPublicationYear() {
		return publicationYear;
	}

	/**
	 * @param publicationYear 	The publicationYear to set a negative year
	 * 							denotes years B.C. and positive years A.C.						
	 */
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * Sets the number of pages a resource has. It cannot be less than 1.
	 * 
	 * @param numberOfPages the numberOfPages to set. Must be greater than 0.
	 */
	public void setNumberOfPages(int numberOfPages) {
		if (numberOfPages > 0) {
			this.numberOfPages = numberOfPages;
		} else {
			System.out.println("A resource can not have less than one page.");
		}
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
