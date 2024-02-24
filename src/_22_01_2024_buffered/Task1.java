package _22_01_2024_buffered;

import java.io.*;
import java.util.List;

public class Task1 {
//    Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            List<String> filteredLines = reader.lines()
                    .filter(s -> Double.parseDouble(s.split(", ")[1]) > 4.5)
                    .toList();

            for (String line : filteredLines) {
                writer.write(line);
                writer.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
