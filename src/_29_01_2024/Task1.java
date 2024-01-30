package _29_01_2024;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {
    public static void main(String[] args) throws IOException {
        copyFileUsingFileStreams();
        copyFileUsingPath();
        copyFileUsingRandomAccessFile();
    }

    // Задание 1: Работа с классом File

    /**
     * Написать метод, который создает файл с именем
     * "example.txt" в текущей директории, затем считывает
     * этот файл с использованием FileInputStream и записывает
     * его содержимое в новый файл "copy_example.txt" с использованием FileOutputStream.
     */
    public static void copyFileUsingFileStreams() throws IOException {
        File file = new File("example.txt");

        try (FileInputStream input = new FileInputStream(file.getName());
             FileOutputStream outputStream = new FileOutputStream("copy_example.txt")) {
            int data;
            while ((data = input.read()) != -1) {
                outputStream.write(data);
            }
        }
    }


    // Задание 2: Работа с классом Path

    /**
     * Написать метод, который использует Path и Files
     * для копирования файла "example.txt" в новый файл "copy_example_path.txt".
     * Проверить, существует ли файл "example.txt" перед копированием.
     */
    public static void copyFileUsingPath() throws IOException {
        File file = new File("example.txt");
        if (file.exists()) {
            Files.copy(Paths.get(file.toURI()), Paths.get("copy_example_path.txt"));
            System.out.println("Файл существует.");
        } else {
            System.out.println("Файл не существует.");
        }
    }

    // Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, читает первые 20 байт и записывает
     * их в новый файл "random_access_copy.txt".
     */
    public static void copyFileUsingRandomAccessFile() throws IOException {
        RandomAccessFile random = new RandomAccessFile("example.txt", "rw");
        FileOutputStream out = new FileOutputStream("random_access_copy.txt");

        byte[] bytes = new byte[20];
        while (random.read() != -1) {
            out.write(bytes);
        }
    }
}
