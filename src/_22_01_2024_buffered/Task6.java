package _22_01_2024_buffered;

import java.io.*;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
//   Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "- Low Rated".
//   Запишите результаты в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            String filter = reader.lines()
                    .map(el -> el.split(", "))
                    .filter(s -> Double.parseDouble(s[1]) < 4.7)
                    .map(el -> el[0] + " " + el[1] + " - Low Rated")
                    .collect(Collectors.joining("\n"));

            writer.write(filter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
