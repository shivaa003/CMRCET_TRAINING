import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);  // Thread pool with 3 threads

    public static void main(String[] args) {
        // Launch the GUI on the EDT (Event Dispatch Thread) using SwingUtilities
        javax.swing.SwingUtilities.invokeLater(() -> {
            LibraryAppGUI app = new LibraryAppGUI();  // Instantiate the Swing-based GUI
            app.setVisible(true);  // Make the window visible
        });

        // Create library object and scanner for input
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display menu in the console
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Comic");
            System.out.println("3. Add a Member");
            System.out.println("4. Display All Books");
            System.out.println("5. Display All Members");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());  // Handle invalid input for menu choice
                switch (choice) {
                    case 1: // Add a Book
                        executorService.submit(() -> {
                            try {
                                // Collect input for a new Book
                                System.out.print("Enter Book Title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter Author: ");
                                String author = scanner.nextLine();
                                System.out.print("Enter ISBN: ");
                                String isbn = scanner.nextLine();
                                System.out.print("Enter Number of Pages: ");
                                int pages = Integer.parseInt(scanner.nextLine());

                                // Create and add the Book to the library
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
                                System.out.println("Book added successfully.");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input for number of pages.");
                            }
                        });
                        break;

                    case 2: // Add a Comic
                        executorService.submit(() -> {
                            try {
                                // Collect input for a new Comic
                                System.out.print("Enter Comic Title: ");
                                String comicTitle = scanner.nextLine();
                                System.out.print("Enter Author: ");
                                String comicAuthor = scanner.nextLine();
                                System.out.print("Enter ISBN: ");
                                String comicIsbn = scanner.nextLine();
                                System.out.print("Enter Number of Pages: ");
                                int comicPages = Integer.parseInt(scanner.nextLine());
                                System.out.print("Enter Series Name: ");
                                String seriesName = scanner.nextLine();
                                System.out.print("Is it Mature Content (true/false): ");
                                boolean isMatureContent = Boolean.parseBoolean(scanner.nextLine());

                                // Create and add the Comic to the library
                                Comic comic = new Comic(comicTitle, comicAuthor, comicIsbn, comicPages, seriesName, isMatureContent);
                                library.addBook(comic);
                                System.out.println("Comic added successfully.");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input for number of pages.");
                            }
                        });
                        break;

                    case 3: // Add a Library Member
                        executorService.submit(() -> {
                            try {
                                // Collect input for a new Library Member
                                System.out.print("Enter Member Name: ");
                                String memberName = scanner.nextLine();
                                System.out.print("Enter Member ID: ");
                                String memberId = scanner.nextLine();
                                System.out.print("Enter Member Email: ");
                                String email = scanner.nextLine();

                                // Create and add the Member to the library
                                LibraryMember member = new LibraryMember(memberName, memberId, email);
                                library.addMember(member);
                                System.out.println("Member added successfully.");
                            } catch (Exception e) {
                                System.out.println("Error adding member: " + e.getMessage());
                            }
                        });
                        break;

                    case 4: // Display All Books
                        executorService.submit(() -> {
                            System.out.println("\n--- Displaying All Books ---");
                            library.displayAllBooks();
                        });
                        break;

                    case 5: // Display All Members
                        executorService.submit(() -> {
                            System.out.println("\n--- Displaying All Members ---");
                            library.displayAllMembers();
                        });
                        break;

                    case 6: // Exit
                        running = false;
                        executorService.shutdown(); // Shut down the executor service
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
