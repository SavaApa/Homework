package _15_01_2024;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        // Задача 1: Собрать элементы потока в список.
        Stream<String> names = Stream.of("Alice", "Bob", "Charle");
        System.out.println(list(names));
        // Задача 2: Удалить дубликаты из списка и собрать их в множество.
        List<String> name = Arrays.asList("Alice", "Alice", "Bob");
        System.out.println(tList(name));
        // Задача 3: Группировка строк по длине.
        System.out.println(map(name));
        // Задача 4: Подсчет повторяющихся элементов и создание мапа.
        System.out.println(stringLongMap(name));
        // Задача 5: Собрать только уникальные элементы в список.
        System.out.println(getUnique(name));
        // Задача 6: Объединение элементов в строку с максимальной длиной.
        System.out.println(getMaxString(name));
        // Задача 7: Разбиение строки на символы и сбор их в множество.
        String s = "hello";
        System.out.println(getString(s));
        // Задача 8: Построение кастомной мапы из элементов.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(stringIntegerMap(integers));
        // Задача 9: Подсчет суммы значений объектов.
        Stream<Person> personStream = Stream.of(
                new Person("Alice", 25),
                new Person("Bob", 34),
                new Person("Charlie", 11)
        );
        System.out.println(sumAge(personStream));
        // Задача 10: Группировка по критерию и подсчет среднего.
        Stream<Person> personStream1 = Stream.of(
                new Person("Alice", 25),
                new Person("Bob", 34),
                new Person("Charlie", 11)
        );
        System.out.println(averageAgeByName(personStream1));
    }

    public static <T> List<T> list(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }

    public static <T> Set<T> tList(List<T> list) {
        return new HashSet<>(list);
    }

    public static Map<Integer, List<String>> map(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static Map<String, Long> stringLongMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()));
    }

    public static List<String> getUnique(List<String> strings) {
        return strings.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), ArrayList::new));
    }

    public static Optional<String> getMaxString(List<String> strings) {
        return strings.stream().max(Comparator.comparingInt(String::length));
    }

    public static List<Character> getString(String name) {
        return name.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> stringIntegerMap(List<Integer> people) {
        return people.stream().collect(Collectors.toMap(el -> "key" + el, el -> el + 2));
    }

    public static int sumAge(Stream<Person> personStream) {
        return personStream.mapToInt(Person::getAge).sum();
    }

    public static Map<String, Double> averageAgeByName(Stream<Person> person) {
        return person.collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}