package _29_11_2023;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalogue implements Searchable {
    private List<Book> books;
    private List<Magazine> magazines;

    public LibraryCatalogue(List<Book> books, List<Magazine> magazines) {
        this.books = books;
        this.magazines = magazines;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }

    @Override
    public String toString() {
        return "LibraryCatalogue{" +
                "books=" + books +
                ", magazines=" + magazines +
                '}';
    }

    @Override
    public List<LibraryItem> findByTitle(String title) {
        return null;
    }

    @Override
    public List<LibraryItem> findByAuthor(String author) {
        return null;
    }

    @Override
    public List<LibraryItem> findByGenre(Genre genre) {
        return null;
    }
}
