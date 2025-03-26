public class Book {
    private String bookName;       // Changed from "title"
    private String writerName;     // Changed from "author"
    private String uniqueId;       // Changed from "ISBN"
    private int yearOfPublication; // Changed from "yearPublished"

    // No-argument constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String bookName, String writerName, String uniqueId, int yearOfPublication) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.uniqueId = uniqueId;
        this.yearOfPublication = yearOfPublication;
    }

    // Getters
    public String getBookName() {
        return bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    // Setters
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    // Override equals(Object) to compare writerName and uniqueId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;               // Same reference
        if (obj == null || !(obj instanceof Book)) return false;
        
        Book otherBook = (Book) obj;
        return this.writerName.equals(otherBook.writerName) 
               && this.uniqueId.equals(otherBook.uniqueId);
    }

    // Override toString() to provide a custom string representation
    @Override
    public String toString() {
        return "Book Name: " + bookName
             + ", Writer: " + writerName
             + ", Unique ID: " + uniqueId
             + ", Year Published: " + yearOfPublication;
    }
}
