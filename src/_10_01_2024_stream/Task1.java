package _10_01_2024_stream;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Task1 {

    //    Фильтрация списка строк по длине.
//Сигнатура: List<String> filterByLength(List<String> input, int length);
    public static List<String> filterByLength(List<String> input, int length) {
        return input.stream()
                .filter(el -> el.length() == length)
                .toList();
    }

    //    2. Задача: Преобразование всех строк в верхний регистр.
//Сигнатура: List<String> toUpperCase(List<String> input);
    public static List<String> toUpperCase(List<String> input) {

        return input.stream()
                .map(String::toUpperCase)
                .toList();
    }

    //    3. Задача: Поиск первой строки, начинающейся на заданную букву.
//Сигнатура: Optional<String> findFirstStartingWith(List<String> input, char letter);
    public static Optional<String> findFirstStartingWith(List<String> input, char letter) {
        return input.stream()
                .filter(el -> el.startsWith(String.valueOf(letter)))
                .findFirst();
    }

//    Задача: Соединение строк через запятую.
//Сигнатура: String joinByComma(List<String> input);

    public static String joinByComma(List<String> input) {
        return String.join(",", input);
    }

//    5. Задача: Подсчёт количества строк, содержащих заданный символ.
//Сигнатура: long countContainingChar(List<String> input, char ch);

    public static long countContainingChar(List<String> input, char ch) {

        return input.stream()
                .filter(el -> el.indexOf(ch) != -1)
                .count();
    }

    //    Целые числа (Integers):
//6. Задача: Найти сумму всех чисел в списке.
//Сигнатура: int sumOfList(List<Integer> input);
    public static int sumOfList(List<Integer> input) {
        return input.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    //    7. Задача: Получить список квадратов чисел.
//Сигнатура: List<Integer> getSquares(List<Integer> input);
    public static List<Integer> getSquares(List<Integer> input) {
        return input.stream()
                .map(el -> el * el)
                .toList();
    }

    //    Задача: Фильтрация чисел, больших заданного значения.
//Сигнатура: List<Integer> filterGreaterThan(List<Integer> input, int minValue);
    public static List<Integer> filterGreaterThan(List<Integer> input, int minValue) {
        return input.stream()
                .filter(el -> el > minValue)
                .toList();
    }

    //    9. Задача: Проверка, содержит ли список заданное число.
//Сигнатура: boolean containsNumber(List<Integer> input, int number);
    public static boolean containsNumber(List<Integer> input, int number) {
        return input.contains(number);
    }

    //    10. Задача: Найти максимальное число в списке.
//Сигнатура: Optional<Integer> findMax(List<Integer> input);
    public static Optional<Integer> findMax(List<Integer> input) {
        return input.stream()
                .max(Integer::compareTo);
    }

    //11. Задача: Преобразование списка символов в список строк.
//Сигнатура: List<String> convertToStringList(List<Character> input);
    public static List<String> convertToStringList(List<Character> input) {
        return input.stream()
                .map(String::valueOf)
                .toList();
    }

    //    12. Задача: Фильтрация символов по ASCII-значению.
//Сигнатура: List<Character> filterByAsciiValue(List<Character> input, int ascii);
    public static List<Character> filterByAsciiValue(List<Character> input, int ascii) {
        return input.stream()
                .filter(el -> el == ascii)
                .toList();
    }

    //    13. Задача: Проверка, все ли символы в списке заглавные.
//Сигнатура: boolean areAllUpperCase(List<Character> input);
    public static boolean areAllUpperCase(List<Character> input) {
        return input.stream()
                .allMatch(Character::isUpperCase);
    }

    //14. Задача: Найти первый повторяющийся символ.
//Сигнатура: Optional<Character> findFirstDuplicate(List<Character> input);
    public static Optional<Character> findFirstDuplicate(List<Character> input) {
        Set<Character> characters = new HashSet<>();
        return input.stream()
                .filter(ch -> !characters.add(ch))
                .findFirst();
    }

    //    15. Задача: Получить обратный список символов.
//Сигнатура: List<Character> reverseList(List<Character> input);
    public static List<Character> reverseList(List<Character> input) {
        List<Character> characters = input.stream()
                .collect(Collectors.toList());

        Collections.reverse(characters);
        return characters;
    }

//    Числа с плавающей точкой (Floats):
//16. Задача: Найти минимальное число в списке.
//Сигнатура: Optional<Float> findMin(List<Float> input);

    public static Optional<Float> findMin(List<Float> input) {
        return input.stream()
                .min(Float::compareTo);
    }

//    17. Задача: Получить список чисел, умноженных на заданное число.
//Сигнатура: List<Float> multiplyBy(List<Float> input, float multiplier);

    public static List<Float> multiplyBy(List<Float> input, float multiplier) {
        return input.stream()
                .map(el -> el * multiplier)
                .toList();
    }

//    18. Задача: Отфильтровать числа, меньшие заданного значения.
//Сигнатура: List<Float> filterLessThan(List<Float> input, float value);

    public static List<Float> filterLessThan(List<Float> input, float value) {
        return input.stream()
                .filter(el -> el < value)
                .toList();
    }

//    19. Задача: Проверить, содержит ли список отрицательные числа.
//Сигнатура: boolean containsNegative(List<Float> input);

    public static boolean containsNegative(List<Float> input) {
        return input.stream()
                .anyMatch(n -> n < 0);
    }

//    20. Задача: Округление всех чисел в списке до ближайшего целого.
//Сигнатура: List<Integer> roundNumbers(List<Float> input);

    public static List<Integer> roundNumbers(List<Float> input) {
        return input.stream()
                .map(Math::round)
                .collect(Collectors.toList());
    }

//    Задача: Найти количество уникальных элементов в списке.
//Сигнатура: <T> long countUnique(List<T> input);

    public static <T> long countUnique(List<T> input) {
        return input.stream()
                .distinct()
                .count();
    }

//    22. Задача: Определить, является ли список отсортированным.
//Сигнатура: <T extends Comparable<T>> boolean isSorted(List<T> input);

    public static <T extends Comparable<T>> boolean isSorted(List<T> input) {
        return IntStream.range(0, input.size() - 1)
                .allMatch(el -> input.get(el).compareTo(input.get(el + 1)) <= 0);
    }

//    23. Задача: Получить последний элемент списка, если он существует.
//Сигнатура: <T> Optional<T> getLastElement(List<T> input);

    public static <T> Optional<T> getLastElement(List<T> input) {
        return input.stream()
                .reduce((one, two) -> two);
    }

//24. Задача: Перемешать элементы списка.
//Сигнатура: <T> List<T> shuffleList(List<T> input);

    public static <T> List<T> shuffleList(List<T> input) {
        List<T> list = input.stream()
                .collect(Collectors.toList());
        Collections.shuffle(list);

        return list;
    }

//    25. Задача: Подсчитать частоту каждого элемента в списке.
//Сигнатура: <T> Map<T, Long> countFrequency(List<T> input);

    public static <T> Map<T, Long> countFrequency(List<T> input) {
        return input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
