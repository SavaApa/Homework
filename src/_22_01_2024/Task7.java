package _22_01_2024;

import java.io.*;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
//    Создайте сводку, включающую идентификатор стрима, название и рейтинг, и запишите ее в новый файл в формате "ID: Название - Рейтинг".
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\homework\\src\\_22_01_2024\\f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task.txt"))) {

            String filter = reader.lines()
                    .map(el -> el.split(", "))
                    .map(parts -> "ID: " + parts[0] + " Название: " + parts[0] + " - Рейтинг: " + parts[1])
                    .collect(Collectors.joining("\n"));

            writer.write(filter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
