package _21_01_2024_test;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Setter
    @Getter
    private String id;
    @Getter
    @Setter
    private String title;
    @Setter
    @Getter
    private String author;
    private boolean isLent;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isLent = false;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isLent=" + isLent +
                '}';
    }
}
