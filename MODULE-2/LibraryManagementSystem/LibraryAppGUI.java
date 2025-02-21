import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryAppGUI extends JFrame {

    private Library library;
    private JTextArea textArea;

    public LibraryAppGUI() {
        library = new Library();
        setTitle("Library Management System");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create text area for displaying information
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the navigation panel with buttons
        JPanel navPanel = createNavPanel();
        add(navPanel, BorderLayout.WEST);
    }

    // Create navigation panel with buttons
    private JPanel createNavPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(52, 152, 219));  // Color of the navigation panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Add padding around panel

        // Create buttons (No images/icons now)
        panel.add(createButton("Add Book"));
        panel.add(Box.createVerticalStrut(10));  // Add space between buttons
        panel.add(createButton("Add Comic"));
        panel.add(Box.createVerticalStrut(10));  // Add space between buttons
        panel.add(createButton("Add Member"));
        panel.add(Box.createVerticalStrut(10));  // Add space between buttons
        panel.add(createButton("Display All Books"));
        panel.add(Box.createVerticalStrut(10));  // Add space between buttons
        panel.add(createButton("Display All Members"));
        panel.add(Box.createVerticalStrut(10));  // Add space between buttons
        panel.add(createButton("Exit"));

        return panel;
    }

    // Create a styled button
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));  // Stylish font
        button.setBackground(new Color(41, 128, 185));  // Flat button color
        button.setForeground(Color.WHITE);  // White text
        button.setFocusPainted(false);  // Remove focus border
        button.setBorderPainted(false);  // Remove border
        button.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center button text
        button.setPreferredSize(new Dimension(150, 40));  // Set consistent button size

        // Add hover effect (optional)
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219));  // Lighter color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185));  // Original color when mouse exits
            }
        });

        // Button actions
        if (text.equals("Add Book")) {
            button.addActionListener(e -> openAddBookDialog());
        } else if (text.equals("Add Comic")) {
            button.addActionListener(e -> openAddComicDialog());
        } else if (text.equals("Add Member")) {
            button.addActionListener(e -> openAddMemberDialog());
        } else if (text.equals("Display All Books")) {
            button.addActionListener(e -> displayAllBooks());
        } else if (text.equals("Display All Members")) {
            button.addActionListener(e -> displayAllMembers());
        } else if (text.equals("Exit")) {
            button.addActionListener(e -> System.exit(0));
        }

        return button;
    }

    private void openAddBookDialog() {
        // Dialog for adding a book
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField isbnField = new JTextField(20);
        JTextField pagesField = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Book Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Pages:"));
        panel.add(pagesField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Enter Book Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                int pages = Integer.parseInt(pagesField.getText());

                Book book = new Book(title, author, isbn, pages) {
                    @Override
                    public void displayDetails() {
                        textArea.append("Book Title: " + getTitle() + "\n");
                        textArea.append("Author: " + getAuthor() + "\n");
                        textArea.append("ISBN: " + getIsbn() + "\n");
                        textArea.append("Number of Pages: " + getNumberOfPages() + "\n");
                        textArea.append("-------------------------------------\n");
                    }
                };
                library.addBook(book);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input for pages!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void openAddComicDialog() {
        // Dialog for adding a comic
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField isbnField = new JTextField(20);
        JTextField pagesField = new JTextField(20);
        JTextField seriesField = new JTextField(20);
        JCheckBox matureCheckBox = new JCheckBox("Mature Content");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Comic Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Pages:"));
        panel.add(pagesField);
        panel.add(new JLabel("Series:"));
        panel.add(seriesField);
        panel.add(new JLabel("Mature Content:"));
        panel.add(matureCheckBox);

        int option = JOptionPane.showConfirmDialog(this, panel, "Enter Comic Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                int pages = Integer.parseInt(pagesField.getText());
                String series = seriesField.getText();
                boolean isMature = matureCheckBox.isSelected();

                Comic comic = new Comic(title, author, isbn, pages, series, isMature);
                library.addBook(comic);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input for pages!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void openAddMemberDialog() {
        // Dialog for adding a member
        JTextField nameField = new JTextField(20);
        JTextField idField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Member Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Member ID:"));
        panel.add(idField);
        panel.add(new JLabel("Member Email:"));
        panel.add(emailField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Enter Member Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String id = idField.getText();
            String email = emailField.getText();

            LibraryMember member = new LibraryMember(name, id, email);
            library.addMember(member);
        }
    }

    private void displayAllBooks() {
        textArea.setText("");  // Clear previous content
        library.displayAllBooks();
    }

    private void displayAllMembers() {
        textArea.setText("");  // Clear previous content
        library.displayAllMembers();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryAppGUI frame = new LibraryAppGUI();
            frame.setVisible(true);
        });
    }
}
