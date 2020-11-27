public class Main {
    public static void main(String[] args) {
        LibraryMember mem = new LibraryMember("12", "fir", "las", "em");
        Book book = new Book("123", "test", "person", 1997, 354, "asdf", "1st");
        book.printResourceDetails();
        System.out.println(book.isAvailable());
        book.addDamages("tear on thing");
        book.printResourceDetails();
        book.setCurrentHolder(mem);
        book.addDamages("new damage :0");
        book.printResourceDetails();
    }
}
