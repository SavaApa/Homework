package _22_01_2024;

import java.io.*;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
//        Найдите стримы с минимальным рейтингом и выведите их в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            List<String> lines = reader.lines().toList();


            double minRating = lines.stream()
                    .mapToDouble(line -> Double.parseDouble(line.split(", ")[1]))
                    .min()
                    .orElse(0.0);


            List<String> minRatingStreams = lines.stream()
                    .filter(line -> Double.parseDouble(line.split(", ")[1]) == minRating)
                    .toList();

            for (String s : minRatingStreams) {
                writer.write(s);
                writer.newLine();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

