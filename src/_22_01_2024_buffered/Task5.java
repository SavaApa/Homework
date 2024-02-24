package _22_01_2024_buffered;

import java.io.*;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
//        Измените названия всех стримов, добавив к ним префикс "Stream-" и
//        запишите обновленные названия в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            String s = reader.lines()
                    .map(el -> el.split(", "))
                    .map(el -> "Stream- " + el[0] + " " + el[1])
                    .collect(Collectors.joining("\n"));

            writer.write(s);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
