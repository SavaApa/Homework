package _24_01_2024_file;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    /**
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */
    public static void main(String[] args) throws RuntimeException {
        List<Book> books;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_24_01_2024\\taski.txt"));

            books = reader.lines()
                    .map(line -> {
                        String[] parts = line.split(", ");
                        return new Book(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("template.ser");//out -> это куда то отдает наружу....в какой то файл..
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(books);
            fileOut.close();
            out.close();
            System.out.println("Получилось");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Main1 {

    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) {
        List<Book> books;
        try {
            FileInputStream fileIn = new FileInputStream("template.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            books = (List<Book>) in.readObject();
            List<Book> list = books.stream()
                    .filter(el -> el.getYear() > 1900)
                    .toList();
            try {
                FileOutputStream fileOut = new FileOutputStream("filter_template.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(list);
                fileOut.close();
                out.close();
                System.out.println("Получилось");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main2 {

    /**
     * Отфильтруйте книги с ценой выше определенной суммы. Сериализуйте отфильтрованный список книг в файл.
     */
    public static void main(String[] args) {
        List<Book> book;

        try {
            FileInputStream fileIn = new FileInputStream("template.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            book = (List<Book>) in.readObject();
            List<Book> list = book.stream()
                    .filter(el -> el.getPrice() > 400)
                    .toList();

            try {
                FileOutputStream fileOut = new FileOutputStream("filter_price_template.ser");//out -> это куда то отдает наружу....в какой то файл..
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(list);
                fileOut.close();
                out.close();
                System.out.println("Получилось");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main3 {

    /**
     * Агрегируйте данные, например, подсчитайте среднюю цену книг по каждому автору. Сериализуйте результаты в файл.
     */
    public static void main(String[] args) {
        List<Book> book;

        try {
            FileInputStream fileIn = new FileInputStream("template.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            book = (List<Book>) in.readObject();
            Map<String, Double> map = book.stream()
                    .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getPrice)));

            try {
                FileOutputStream fileOut = new FileOutputStream("filter_price_author_template.ser");//out -> это куда то отдает наружу....в какой то файл..
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(map);
                fileOut.close();
                out.close();
                System.out.println("Получилось");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

