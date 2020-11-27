import java.util.ArrayList;

public class ElectronicResource extends Resource {
    
    private ArrayList<ElectronicDevice> compatableDevices;
    private String electronicResourceType;

    public ElectronicResource(String resourceId, String title, String author,
            int publicationYear, int numberOfPages, String electronicResourceType) {

        super(resourceId, title, author, publicationYear, numberOfPages);
        this.electronicResourceType = electronicResourceType;
        this.compatableDevices = new ArrayList<ElectronicDevice>();
    }
}
