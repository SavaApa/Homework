package _22_01_2024_buffered;

import java.io.*;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
// Соберите все названия стримов в одну длинную строку, разделяя их запятыми, и запишите эту строку в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            String s = reader.lines()
                    .map(el -> el.split(", ")[0])
                    .collect(Collectors.joining(","));

            writer.write(s);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
