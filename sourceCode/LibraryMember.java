/**
 * Represents a member of the library with the ability to borrow and return
 * books, and use elecctronic devices to access electronic resources. Each
 * user has a membership Id, a first and last name, an email, a list of books on
 * loan and a list of meeages.
 * <p>
 * Each user beongs to only one library but can have zero or many books.
 *
 * @author James Welsh
 * @version 1.0
 * @since 2020-11-28
 * */

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

    /**
     * Changes the users email address. It checks that the String enetered
     * contains an "@" and is therefore deemed to be a vaild email address.
     *
     * @param email A string representing the library members email address. It
     *              must contain the '@' character at some point in it.
     * */
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Please enter a valid email address.");
        }
    }

    /**
     * Prints all the data members of the class in an easy to read format.
     * */
    public void printMemberDetails() {
        System.out.println("Member Id: " + this.memberId + "\nFirst Name: " +
                this.firstName + "\nLast Name: " + this.lastName + "\nEmail: " +
                this.email + "\nBooks: " );
        for (Book book : books) {
            book.printResourceDetails();
        }
        System.out.println("Messages: ");
        this.printMessages();
    }

    /**
     * gets the library members fullname.
     *
     * @return library members full name.
     * */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Prints all the users messages. If there are no messages it prints an
     * appropriate string instead.
     * */
    public void printMessages() {
        if (this.messages.isEmpty()) {
            System.out.println("You currently have no messages.");
        } else {
            for (String message : messages) {
                System.out.println(message);    
            }
        }
    }

    /**
     * Adds a book to the users list of books 
     * */
    public void addBook(Book book) {
        d
    }
}
