package _15_01_2024_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        //Напишите метод, который принимает список чисел и возвращает сумму квадратов всех нечетных чисел в списке.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfSquaresOfOddNumbers(numbers));
        //Напишите метод, который принимает список строк и возвращает список уникальных слов, отсортированных в лексикографическом порядке.
        List<String> strings = List.of("Adult", "Teenager", "Adult", "People", "Computers");
        System.out.println(uniqueSortedWords(strings));
        //Напишите метод, который принимает список строк и возвращает список строк, содержащих
        // только уникальные символы (т.е. символы, которые не повторяются в строке).
        System.out.println(uniqueChars(strings));
        //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
        System.out.println(longestString(strings));
    }

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream().
                collect(Collectors.filtering(el -> el % 2 != 0,
                        Collectors.summingInt(Integer::intValue)));
    }

    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), ArrayList::new));
    }

    public static List<String> uniqueChars(List<String> strings) {

        return strings.stream()
                .collect(Collectors.filtering(
                        el -> el.chars().distinct().count() == el.length(),
                        Collectors.toList()
                ));
    }

    public static String longestString(List<String> strings) {
        return String.valueOf(strings.stream()
                .max(Comparator.comparingInt(String::length)
                ));
    }
}

