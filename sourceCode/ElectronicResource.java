/**
 * Represents an electronic resource at the library. This can be a ebook, pdf,
 * online paper etc. It contains an array of electronic devices that can be
 * used to access the resource and the format that the electronic resource is
 * in, this can be a pdf, ebook ...
 * <p>
 * An electronic resource belongs to one library and can have 0 or more
 * compatable devices.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-28
 */

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

    /**
     * Print the details of all devices that can be used to access the
     * electronic resouce regardless of whether they are available or not.
     * */
    public void printAllDevices() {
        for (ElectronicDevice electronicDevice : compatableDevices) {
            electronicDevice.printDeviceDetails();
        }
    }

    /** 
     * Prints the details of all available devices that can be used to access
     * the electronic resource.
     * */
    public void printAvailableDevices() {
        for (ElectronicDevice electronicDevice : compatableDevices) {
            if (electronicDevice.checkAvailability()) {
                electronicDevice.printDeviceDetails();
            } 
        }
    }

    /**
     * Adds an electronic device object to the list of compatable devices that
     * can be used to access the electronic resource.
     *
     * @param electronicDevice  An electronic device that can be used to access
     *                          the electronic resource.
     * */
    public void addDevice(ElectronicDevice electronicDevice) {
        if (electronicDevice == null) {
            System.out.println("Sorry you entered a null reference as a " +
                    "paramter, this is not allowed.");
        } else if (electronicDevice instanceof ElectronicDevice) {
            compatableDevices.add(electronicDevice);
        } else {
            System.out.println("The object you entered was not an electronic " +
                    "device.");
        }
    }
}
