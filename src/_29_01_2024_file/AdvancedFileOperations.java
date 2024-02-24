package _29_01_2024_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedFileOperations {

    public static void main(String[] args) throws IOException {
        countWordsInFile();
        findTxtFilesInDirectory();
        copyLastParagraphUsingRandomAccess();
    }

    // Усложненное Задание 1: Работа с классом File

    /**
     * Написать метод, который читает файл "example.txt",
     * подсчитывает количество слов в файле и записывает это количество
     * в новый файл "word_count.txt". Использовать BufferedReader и BufferedWriter
     * для эффективной работы с текстом.
     */
    public static void countWordsInFile() throws IOException {
        File file = new File("example.txt");
        file.createNewFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter("word_count.txt"))) {

            long count = reader.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .count();
            writer.write(String.valueOf(count));
        }
    }

    // Усложненное Задание 2: Работа с классом Path

    /**
     * Написать метод, который ищет все файлы с расширением ".txt"
     * в текущей директории и её поддиректориях. Результаты поиска
     * (пути к файлам) записать в файл "found_files.txt".
     */
    public static void findTxtFilesInDirectory() throws IOException {
        String rootPath = System.getProperty("user.dir");// эта строка гарантирует, что поиск будет выполняться в текущей директории, откуда запущена программа.

        List<String> fileList = Files.list(Paths.get(rootPath))
                .filter(Files::isRegularFile)// оставляет обычный файл
                .map(Path::toString)
                .filter(string -> string.endsWith(".txt"))
                .collect(Collectors.toList());

        Files.write(Paths.get("found_files.txt"), fileList);

        fileList.forEach(System.out::println);
    }


    // Усложненное Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, переходит к последнему абзацу
     * в файле и копирует его содержимое в новый файл "last_paragraph.txt".
     */
    public static void copyLastParagraphUsingRandomAccess() throws IOException {
        try (RandomAccessFile sourceFile = new RandomAccessFile("example.txt", "r");
             RandomAccessFile destinationFile = new RandomAccessFile("last_paragraph.txt", "rw")) {
            long position = sourceFile.length() - 1;

            while (position >= 0) {
                sourceFile.seek(position);
                char currentChar = (char) sourceFile.read();
                destinationFile.write(currentChar);

                if (currentChar == '\n' || currentChar == '\r') {
                    break;
                }

                position--;
            }
        }
    }
}