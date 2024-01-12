package _10_01_2024;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main extends Task1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Lana", "Tom", "Artur", "Linda", "Sara");
        System.out.println(filterByLength(strings, 5));
        System.out.println("----------------------------------------");
        System.out.println(toUpperCase(strings));
        System.out.println("----------------------------------------");
        System.out.println(findFirstStartingWith(strings, 'L'));
        System.out.println("----------------------------------------");
        System.out.println(joinByComma(strings));
        System.out.println("----------------------------------------");
        System.out.println(countContainingChar(strings, 'L'));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8);
        System.out.println(sumOfList(numbers));
        System.out.println("----------------------------------------");
        System.out.println(getSquares(numbers));
        System.out.println("----------------------------------------");
        System.out.println(filterGreaterThan(numbers, 7));
        System.out.println("----------------------------------------");
        System.out.println(containsNumber(numbers, 7));
        System.out.println("----------------------------------------");
        System.out.println(findMax(numbers));

        List<Character> characters = Arrays.asList('A', 'B', 'H', 'H', 'A', 'C');
        System.out.println(convertToStringList(characters));
        System.out.println("----------------------------------------");
        System.out.println(filterByAsciiValue(characters, 97));
        System.out.println("----------------------------------------");
        System.out.println(areAllUpperCase(characters));
        System.out.println("----------------------------------------");
        System.out.println(findFirstDuplicate(characters));
        System.out.println("-----------------------------------------");
        System.out.println(reverseList(characters));

        List<Float> floats = Arrays.asList(1.3f, 4.5f, 5.6f, -7.8f, 4.5f);
        System.out.println(findMin(floats));
        System.out.println("-----------------------------------------");
        System.out.println(multiplyBy(floats, 2));
        System.out.println("-----------------------------------------");
        System.out.println(filterLessThan(floats, 8.2f));
        System.out.println("-----------------------------------------");
        System.out.println(containsNegative(floats));
        System.out.println("-----------------------------------------");
        System.out.println(countUnique(numbers));
        System.out.println("-----------------------------------------");
        System.out.println(isSorted(characters));
        System.out.println("-----------------------------------------");
        System.out.println(getLastElement(numbers));
        System.out.println("-----------------------------------------");
        System.out.println(shuffleList(numbers));
        System.out.println("-----------------------------------------");
        System.out.println(countFrequency(numbers));
    }
}
