import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book with ISBN " + isbn + " has been removed.");
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public void displayAllMembers() {
        for (LibraryMember member : members) {
            System.out.println(member);
        }
    }
}
