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

    public void printResourceDetails() {
        System.out.println("ResourceId: " + this.resourceId + "\n" + "Title: " +
                this.title + "\n" + "Author: " + this.author + "\n" +
                "Year Published: " + this.publicationYear + "\n" + "Pages: " +
                this.numberOfPages);
    }
}
