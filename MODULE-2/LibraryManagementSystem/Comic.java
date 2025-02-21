public class Comic extends Book {
    private String seriesName;
    private boolean isMatureContent;

    public Comic(String title, String author, String isbn, int numberOfPages, String seriesName, boolean isMatureContent) {
        super(title, author, isbn, numberOfPages);
        this.seriesName = seriesName;
        this.isMatureContent = isMatureContent;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public boolean isMatureContent() {
        return isMatureContent;
    }

    public void setMatureContent(boolean matureContent) {
        isMatureContent = matureContent;
    }

    @Override
    public void displayDetails() {
        System.out.println("Comic Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("Series: " + seriesName);
        System.out.println("Mature Content: " + (isMatureContent ? "Yes" : "No"));
    }
}
