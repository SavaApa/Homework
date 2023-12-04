package _27_11_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(2);
        number.add(13);
        number.add(1);
        number.add(3);
        number.add(7);
        number.add(10);
//        sort1(number);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Coconut");
        strings.add("Computer");
        strings.add("Sto");
        strings.add("Java");
        findPairNumber(number, 17);
        int[] number1 = {3, 9, 2, 1};
        findPairNumber1(number1, 12);
        counter(number1);
        System.out.println();
        counterList(number);
        System.out.println();
        dublle1(number);
        System.out.println();
        sort(number1);
        System.out.println();
        System.out.println();
        removingElements(strings, "Stop");
        System.out.println();
        stringConcatenation(strings);
        System.out.println();
        arrayReplacement(number, 7);
        System.out.println();
        stringLength(strings);



    }

//   Дан массив/коллекция целых чисел и целое число X. Найти пару чисел в массиве/коллекции, сумма которых равна X.

    public static void findPairNumber(ArrayList<Integer> number, int x) {

        for (int i = 0; i < number.size() - 1; i++) {
            for (int j = i + 1; j < number.size(); j++) {
                if (number.get(i) + number.get(j) == x) {
                    System.out.println("find number = " + number.get(i) + " " + number.get(j));
                    break;
                }
            }
        }

    }

    public static void findPairNumber1(int[] number, int x) {
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] + number[j] == x) {
                    System.out.println("find number = " + number[i] + " " + number[j]);
                    break;
                }
            }
        }
    }

//  Дан массив/коллекция целых чисел. Необходимо подсчитать, сколько раз каждый элемент встречается в массив/коллекции.

    public static void counter(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int number = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    number++;
                }

            }
            System.out.println("количество повторений = " + number + " " + arr[i]);
        }
    }

    public static void counterList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int number = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (Objects.equals(arr.get(i), arr.get(j))) {
                    number++;
                }
            }
            System.out.println("количество повторений = " + number + " " + arr.get(i));
        }
    }

    //    - Дан массив/коллекция. Удалить все дубликаты из массива/коллекции.
    public static void dublle(int[] number) {
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] == number[j]) {
                    number[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(number));
    }

    public static void dublle1(ArrayList<Integer> numbers) {

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (Objects.equals(numbers.get(i), numbers.get(j))) {
                    numbers.remove(i);
                }
            }
        }
        System.out.println(numbers);

    }

    //- Дан массив/коллекция целых чисел. Необходимо переставить элементы массив/коллекции в обратном порядке.
    public static void sort(int[] number) {
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j < number.length - i - 1; j++) {
                if (number[j + 1] < number[j]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        for (int i = number.length - 1; i >= 0; i--) {
            System.out.println(number[i]);
        }

    }

    public static void sort1(ArrayList<Integer> number) {

        for (int i = 0; i < number.size() - 1; i++) {
            for (int j = 0; j < number.size() - i - 1; j++) {
                if (number.get(j + 1) < number.get(j)) {
                    int temp = number.get(j);
                    number.set(j, number.get(j + 1));
                    number.set(j + 1, temp);
                }
            }
        }
        for (int i = number.size() - 1; i >= 0; i--) {
            System.out.println(number.get(i));
        }
    }

    //- Реализовать метод, который удаляет все вхождения заданной строки из List<String>.
    public static void removingElements(ArrayList<String> str, String string) {
        for (int i = 0; i < str.size(); i++) {
            if (Objects.equals(str.get(i), string)) {
                str.remove(string);
            }
            System.out.println(str.get(i));
        }
    }

    //- Составить метод, который объединяет все строки из List в одну большую строку.
    public static void stringConcatenation(ArrayList<String> str) {
        String res = "";
        for (int i = 0; i < str.size(); i++) {
            res += String.valueOf(str.get(i));
        }
        System.out.println(res);
    }

    //    - Дан List 1,написать метод который создает List 2, содержащий только те числа из List 1, которые больше заданного значения.
    public static void arrayReplacement(ArrayList<Integer> number, int numb) {
        ArrayList<Integer> number1 = new ArrayList<>();
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i) > numb) {
                number1.add(number.get(i));
            }
        }
        System.out.println(number1);
    }

    //    - Написать метод, который преобразует List<String> в List<Integer>, представляющих длину каждой строки.
    public static void stringLength(ArrayList<String> str) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String string : str) {
            int len = string.length();
            result.add(len);
        }
        System.out.println(result);
    }


}




