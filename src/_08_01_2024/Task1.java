package _08_01_2024;

import java.util.*;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        m1();
        System.out.println("----------------------------------------------------------------");
        m2();
        System.out.println("----------------------------------------------------------------");
        m3();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Получение списка уникальных слов из списка строк, длина которых больше 4 символов");
        m6();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Cписок имен, отсортированных по возрасту");
        m7();
        System.out.println("----------------------------------------------------------------");
        System.out.println("суммы чисел, кратных 3 и 5, из списка чисел");
        m8();
        System.out.println("----------------------------------------------------------------");
        m9();
    }

    private static void m1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(el -> el % 2 != 0)
                .toList();
        System.out.println("Нечетные числа: " + evenNumbers);
    }

    private static void m2() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> num = strings.stream()
                .map(Integer::parseInt)
                .toList();
        System.out.println(num + " Преобразование списка строк в список чисел");
    }

    private static void m3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(Integer::sum).get();
        System.out.println("Сумма чисел " + numbers + " = " + sum);
    }

    private static void m6() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "cherry", "kiwi");
        List<String> wordList = words.stream()
                .distinct()
                .filter(el -> el.length() > 4)
                .toList();
        System.out.println(wordList);
    }

    private static void m7() {
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
        List<Person> sortPeople = people.stream()
                .sorted(Comparator.comparing(person -> person.age))
                .toList();
        System.out.println(sortPeople);
    }

    private static void m8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 15, 30);
        Optional<Integer> sumNumbers = numbers.stream()
                .filter(el -> el % 3 == 0 && el % 5 == 0)
                .reduce(Integer::sum);
        sumNumbers.ifPresent(el -> System.out.println("Сумма " + el));
    }

    private static void m9() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "grape");
        List<String> filter = words.stream()
                .filter(el -> el.startsWith("a"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("начинаются на 'a' " + filter);

        List<String> word = words.stream()
                .filter(el -> el.chars().distinct().count() == el.length())
                .toList();
        System.out.println("только уникальные символы " + word);
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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
