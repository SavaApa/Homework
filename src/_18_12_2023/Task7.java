package _18_12_2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task7 {
    //    Создайте функциональный интерфейс TextAnalyzer с методом analyze, который принимает
//    текст и анализирует его, возвращая результат анализа.
//Напишите метод, который принимает строку и TextAnalyzer, и
// подсчитывает количество уникальных слов в тексте.
    public static void main(String[] args) {
        String str = "Guitar is instrument and Piano is instrument";
        TextAnalyzer textAnalyzer = s -> {
            String[] strings = s.split(" ");
            int count = 0;
            Set<String> hMap = new HashSet<>(Arrays.asList(strings));
            for (String s1 : hMap) {
                for (String string : strings) {
                    if (Objects.equals(s1, string)) {
                        count++;
                    }
                }
            }
            return count;
        };
        System.out.println(result(str, textAnalyzer));
    }

    public static int result(String s, TextAnalyzer analyzer) {
        return analyzer.analyze(s);
    }
}

@FunctionalInterface
interface TextAnalyzer {
    int analyze(String str);
}
