package _24_01_2024;

import java.io.Serializable;

class Book implements Serializable {
    private final int id;
    private final String title;
    private final String author;
    private final int year;
    private final double price;

    public Book(int id, String title, String author, int year, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }


    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
