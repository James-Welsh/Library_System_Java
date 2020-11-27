import java.util.ArrayList;

public class Library {
    
    private ArrayList<LibraryMember> libraryMembers;
    private ArrayList<Resource> libraryResources;
    private ArrayList<ElectronicDevice> libraryDevices;
    private String libraryName;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }
}
