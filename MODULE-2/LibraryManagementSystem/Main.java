import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Library
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Comic");
            System.out.println("3. Add a Member");
            System.out.println("4. Display All Books");
            System.out.println("5. Display All Members");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1: // Add a Book
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Number of Pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Book book = new Book(title, author, isbn, pages) {
                        @Override
                        public void displayDetails() {
                            System.out.println("Book Title: " + getTitle());
                            System.out.println("Author: " + getAuthor());
                            System.out.println("ISBN: " + getIsbn());
                            System.out.println("Number of Pages: " + getNumberOfPages());
                        }
                    };
                    library.addBook(book);
                    break;

                case 2: // Add a Comic
                    System.out.print("Enter Comic Title: ");
                    String comicTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String comicAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String comicIsbn = scanner.nextLine();
                    System.out.print("Enter Number of Pages: ");
                    int comicPages = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Series Name: ");
                    String seriesName = scanner.nextLine();
                    System.out.print("Is it Mature Content (true/false): ");
                    boolean isMatureContent = scanner.nextBoolean();
                    scanner.nextLine();  // Consume newline

                    Comic comic = new Comic(comicTitle, comicAuthor, comicIsbn, comicPages, seriesName, isMatureContent);
                    library.addBook(comic);
                    break;

                case 3: // Add a Library Member
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Member Email: ");
                    String email = scanner.nextLine();

                    LibraryMember member = new LibraryMember(memberName, memberId, email);
                    library.addMember(member);
                    break;

                case 4: // Display All Books
                    System.out.println("\n--- All Books ---");
                    library.displayAllBooks();
                    break;

                case 5: // Display All Members
                    System.out.println("\n--- All Members ---");
                    library.displayAllMembers();
                    break;

                case 6: // Exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
