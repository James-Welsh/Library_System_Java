import java.util.ArrayList;

public class LibraryMember {

    private String memberId;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Book> books;
    private ArrayList<String> messages;

    public LibraryMember(String memberId, String firstName, String lastName,
            String email) {

        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.books = new ArrayList<Book>();
        this.messages = new ArrayList<String>();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
