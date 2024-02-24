package _21_01_2024_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class BookRepositoryImplementationTest {
    private static final BookRepositoryImplement BOOK_REPOSITORY_IMPLEMENT = new BookRepositoryImplement();
    private static final Book book1 = new Book("1", "title1", "author1");
    private static final Book book2 = new Book("2", "title2", "author2");
    private static final Book book3 = new Book("3", "title3", "author3");

    @BeforeEach
    public void setUp() {
        BOOK_REPOSITORY_IMPLEMENT.getList().clear();
        BOOK_REPOSITORY_IMPLEMENT.addToList(book1);
        BOOK_REPOSITORY_IMPLEMENT.addToList(book2);
        BOOK_REPOSITORY_IMPLEMENT.addToList(book3);
    }

    @Test
    void findByIdTest() {
        Assertions.assertEquals(Optional.of(book1), BOOK_REPOSITORY_IMPLEMENT.findById("1"));
    }

    @Test
    void findByIdValidTest() {
        Assertions.assertTrue(BOOK_REPOSITORY_IMPLEMENT.findById("99").isEmpty());
    }

    @Test
    void findAllTest() {
        List<Book> result = BOOK_REPOSITORY_IMPLEMENT.findAll();
        Assertions.assertEquals(Arrays.asList(book1, book2, book3), result);
    }

    @Test
    void saveTest() {
        Book book = new Book("4", "title4", "author4");
        BOOK_REPOSITORY_IMPLEMENT.save(book);
        Assertions.assertTrue(BOOK_REPOSITORY_IMPLEMENT.getList().contains(book));
    }

    @Test
    void saveValidTest() {
        Book book = new Book(null, "title4", "author4");
        Assertions.assertThrows(IllegalArgumentException.class, () -> BOOK_REPOSITORY_IMPLEMENT.save(book));
    }

    @Test
    void deleteByIdTest() {
        BOOK_REPOSITORY_IMPLEMENT.deleteById("4");
        List<Book> resultList = BOOK_REPOSITORY_IMPLEMENT.getList();
        Assertions.assertFalse(resultList.stream().anyMatch(el -> el.getId().equals("4")));
    }

    @Test
    void existsByIdTest() {
        Assertions.assertTrue(BOOK_REPOSITORY_IMPLEMENT.existsById("1"));
    }

    @Test
    void existsByIdValidTest() {
        Assertions.assertFalse(BOOK_REPOSITORY_IMPLEMENT.existsById("100"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BOOK_REPOSITORY_IMPLEMENT.existsById(null));
    }

    @Test
    void findByAuthorTest() {
        List<Book> books = BOOK_REPOSITORY_IMPLEMENT.findByAuthor("author2");
        Assertions.assertTrue(books.stream().anyMatch(el -> Objects.equals(el.getAuthor(), "author2")));
    }

    @Test
    void findByAuthorValidTest() {
        List<Book> books = BOOK_REPOSITORY_IMPLEMENT.findByAuthor("author100");
        Assertions.assertFalse(books.stream().anyMatch(el -> Objects.equals(el.getAuthor(), "author100")));

        Assertions.assertThrows(IllegalArgumentException.class, () -> BOOK_REPOSITORY_IMPLEMENT.findByAuthor(null));
    }

    @Test
    void findByTitleTest() {
        Assertions.assertEquals(Optional.of(book1), BOOK_REPOSITORY_IMPLEMENT.findByTitle("title1"));
    }

    @Test
    void findByTitleValidTest() {
        Assertions.assertTrue(BOOK_REPOSITORY_IMPLEMENT.findByTitle("99").isEmpty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> BOOK_REPOSITORY_IMPLEMENT.findByTitle(null));
    }

    @Test
    void findContainingTitle() {
        List<Book> books = BOOK_REPOSITORY_IMPLEMENT.findContainingTitle("title1");
        Assertions.assertTrue(books.contains(book1));
    }
}