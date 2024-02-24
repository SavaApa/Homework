package _21_01_2024_test;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class BookRepositoryImplement implements BookRepository {
    private final List<Book> list;

    public BookRepositoryImplement() {
        this.list = new ArrayList<>();
    }

    public void addToList(Book book) {
        list.add(book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return list.stream()
                .filter(el -> Objects.equals(el.getId(), id))
                .findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null || book.getAuthor() == null || book.getTitle() == null) {
            throw new IllegalArgumentException();
        }
        list.add(book);
        return book;
    }

    @Override
    public void deleteById(String id) {
        list.removeIf(el -> Objects.equals(el.getId(), id));
    }

    @Override
    public boolean existsById(String id) {
        return list.stream()
                .anyMatch(el -> Objects.equals(el.getId(), id));
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return list.stream()
                .filter(el -> Objects.equals(el.getAuthor(), author))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        if(title == null){
            throw new IllegalArgumentException();
        }
        return list.stream()
                .filter(el -> Objects.equals(el.getTitle(), title))
                .findFirst();
    }

    @Override
    public List<Book> findContainingTitle(String title) {
        return list.stream()
                .filter(el -> el.getTitle().contains(title))
                .toList();
    }
}
