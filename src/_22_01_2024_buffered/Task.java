package _22_01_2024_buffered;

import java.io.*;

public class Task {
    public static void main(String[] args) {
//        Прочитайте файл и посчитайте средний рейтинг всех стримов.
//        Запишите результат в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            double s = reader.lines()
                    .map(el -> el.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0.0);
            writer.write(String.valueOf(s));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
