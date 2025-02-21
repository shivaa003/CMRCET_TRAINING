public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private int numberOfPages;

    public Book(String title, String author, String isbn, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public abstract void displayDetails();
}
