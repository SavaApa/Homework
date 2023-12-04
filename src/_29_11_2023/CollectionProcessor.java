package _29_11_2023;

import java.time.LocalDate;
import java.util.*;

public class CollectionProcessor {
    public static void main(String[] args) {


        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Harry Potter", "John", Genre.FANTASY, BookStatus.LOST, LocalDate.of(2002, 9, 11), 200);
        books.add(book1);
//
        List<Magazine> magazines = new ArrayList<>();
        Magazine magazine1 = new Magazine("JavaCore", "Mark", Genre.BIOGRAPHY, 4, LocalDate.of(2023, 12, 23), true);
        magazines.add(magazine1);
//        LibraryCatalogue = new LibraryCatalogue(books, magazines);
//        System.out.println(libraryCatalogue);
//
//
//        List<LibraryItem> borrowedItems = new ArrayList<>();
//        User user = new User("Jake", "11", borrowedItems);
//        System.out.println(user);
//
//
//        List<LibraryItem> managedItems = new ArrayList<>();
//        Librarian = new Librarian("John", "9", managedItems);
//
//        System.out.println(librarian);

        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(book1);
        libraryItems.add(magazine1);
        printAllItems(libraryItems);
        listItemsByGenre(libraryItems, Genre.FANTASY);
        sortByTitle(libraryItems);
        filterByAuthor(libraryItems, "Mark");
        countItemsByStatus(libraryItems, BookStatus.LOST);
        updateStatus(libraryItems, BookStatus.LOST, BookStatus.AVAILABLE);
        displayItemCount(libraryItems);
        calculateAveragePageCount(books);
    }

    static void printAllItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    static void listItemsByGenre(List<LibraryItem> items, Genre genre) {
        for (LibraryItem item : items) {
            if (item.getGenre() == genre) {
                System.out.println(item);
            }
        }
    }

    static void sortByTitle(List<LibraryItem> items) {
        items.sort(Comparator.comparing(LibraryItem::getTitle));
        for (LibraryItem item : items) {
            System.out.println(item.getTitle());
        }
    }

    static void filterByAuthor(List<LibraryItem> items, String author) {
        for (LibraryItem item : items) {
            if (Objects.equals(item.getAuthor(), author)) {
                System.out.println(item);
            }
        }
    }

    static void countItemsByStatus(List<LibraryItem> items, BookStatus status) {
        int count = 0;
        for (LibraryItem item : items) {
            if(item instanceof Book){
                if(((Book) item).getStatus().equals(status)){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

    static void updateStatus(List<LibraryItem> items, BookStatus oldStatus, BookStatus newStatus){
        for (LibraryItem item : items) {
            if (item instanceof Book temp) {
                if (temp.getStatus().equals(oldStatus)) {
                    temp.setStatus(newStatus);
                }
            }
        }
    }

    static void displayItemCount(List<LibraryItem> items){
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            count ++;
        }
        System.out.println("количество элементов: " + count);
    }

    static void calculateAveragePageCount(List<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPageCount();
        }
        System.out.println(sum);
    }

    static void addItemToList(List<LibraryItem> items, LibraryItem item) {
        items.add(item);
    }

    static void removeItemFromList(List<LibraryItem> items, LibraryItem item) {
        items.remove(item);
    }

    static void removeLostItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Book temp) {
                if (temp.getStatus().equals(BookStatus.LOST)) {
                    items.remove(item);
                }
            }
        }
    }
}
