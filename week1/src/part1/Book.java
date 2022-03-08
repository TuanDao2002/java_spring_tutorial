package part1;

public class Book {
    // implement requirements A - D here
    private String bookID;
    private String title;
    private String author;
    private String borrowerID;

    public Book() {}

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.borrowerID = null;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    // method which allows the Book to be "returned" if it has been borrowed
    public boolean returnBook() {
        // if borrower ID has been set (ie. book has been borrowed)
        if (this.borrowerID != null) {
            // reset borrowerID to null and return true result
            this.borrowerID = null;
            return true;
        } else {
            // otherwise, book is not currently borrowed so return false result
            return false;
        }
    }

    public boolean borrow(String borrowerID) {
        if (this.borrowerID == null) {
            this.borrowerID = borrowerID;
            return true;
        }

        return false;
    }

    // format Book details to a String (useful for printing!)
    public String toString()
    {
        return String.format(
                "Book ID: %s\nTitle: %s\nAuthor: %s\nBorrowed by: %s\n",
                this.bookID, this.title, this.author,
                this.borrowerID != null ? this.borrowerID : "Available");
    }
}
