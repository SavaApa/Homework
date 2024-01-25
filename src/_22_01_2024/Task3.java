package _22_01_2024;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
//        Отсортируйте стримы по рейтингу от наибольшего к наименьшему и
//        запишите результаты в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            List<String> sortedLines = new java.util.ArrayList<>(reader.lines()
                    .sorted(Comparator.comparingDouble(line -> Double.parseDouble(line.split(", ")[1])))
                    .toList());
            Collections.reverse(sortedLines);

            for (String s : sortedLines) {
                writer.write(s);
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
