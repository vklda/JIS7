package homework.collections.library.model;

import java.util.Objects;

public class Book {
    private String author;
    private String bookName;

    public Book(String author, String bookName) {
        this.author = author;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(bookName, book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, bookName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
