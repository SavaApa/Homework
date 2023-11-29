package _20_11_2023;

import java.util.Arrays;

public class Book {
    String nameBook;
    String author;
    int yearOfPublication;

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        System.out.println(yearOfPublication > 50);
        this.yearOfPublication = yearOfPublication;
    }
}

class Reader extends Book {
    String name;
    int age;
    String[] book;

    public void takeBook() {
        String[] newBook = new String[book.length + 1];
        for (int i = 0; i < book.length; i++) {
            newBook[i] = book[i];
        }
        newBook[newBook.length - 1] = nameBook;
    }

    public void backBook() {
        book[1] = null;
    }
}

class Librarian extends Reader {
    static String[] nameLib;
    int workExperience;
    String[] validBooks;

    public void issueBook() {
        String[] newBookLib = new String[book.length + 1];
        for (int i = 0; i < book.length; i++) {
            newBookLib[i] = book[i];
        }
        newBookLib[newBookLib.length - 1] = validBooks[2];
    }

    public void acceptBook() {
        String[] accept = new String[validBooks.length + 1];
        for (int i = 0; i < validBooks.length; i++) {
            accept[i] = validBooks[i];
        }
        accept[accept.length - 1] = book[3];
    }
}

class Library extends Librarian {
    String nameLibrary;
    String streetAddress;
    static String[] nameLibrarian;

    public void addLibrarian() {
        String[] newLibrarian = new String[nameLibrarian.length + 1];
        for (int i = 0; i < nameLibrarian.length; i++) {
            newLibrarian[i] = nameLibrarian[i];
        }
        newLibrarian[newLibrarian.length - 1] = Arrays.toString(nameLib);
    }

    public static boolean librarianSearch() {
        boolean lib = false;
        for (String name : nameLibrarian) {
            if(nameLibrarian == nameLib){
                lib = true;
            }
        }

        return lib;
    }
}


