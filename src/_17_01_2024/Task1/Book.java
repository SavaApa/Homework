package _17_01_2024.Task1;

import java.util.List;

public class Book {
    private final String title;
    private final List<String> authors;

    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

}
