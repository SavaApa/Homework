package _04_12_2023;

import java.util.*;

public class MapEx {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("aaaaa", "AAAAA");
//        map.put("cccc", "CCCCC");
//        map.put("dd", "BBBBB");
//        map.put("ddd", "DDDDD");
//        map.put("ee", "EEEEE");
//        map.put("fffffff", "FFFF");
//        map.put("bbb", "BBBBB");
//        map.put("abc", "cba");
//        findCount(map);
//        reverse((map));
//
//        Map<String, Integer> mapSI = new HashMap<>();
//        mapSI.put("Ab", 1);
//        mapSI.put("B", 2);
//        mapSI.put("Ac", 3);
//        mapSI.put("D", 4);
//        mapSI.put("Ad", 5);
//        mapSI.put("E", 6);
//        int sum = countSum(mapSI);
//        System.out.println("Cуммa всех значений " + sum);
//
//        math(mapSI);
//
//
//        Map<Integer, List<String>> integerListMap = new HashMap<>();
//        integerListMap.put(2, new ArrayList<>(Arrays.asList("trak", "mapa", "java")));
//        integerListMap.put(4, new ArrayList<>(Arrays.asList("Gazon", "Harri Potterr", "Sava")));
//        integerListMap.put(7, new ArrayList<>(Arrays.asList("arka", "Ozon", "ukrop")));
//        for (Map.Entry<Integer, List<String>> map1 : integerListMap.entrySet()) {
//            for (String string : map1.getValue()) {
//                if (start(string)) {
//                    System.out.println(string + " начинаются с гласной буквы");
//                }
//            }
//        }
//
//        charList(integerListMap);
//
//        Map<Integer, Integer> integerMap = new HashMap<>();
//        integerMap.put(2, 0);
//        integerMap.put(14, 11);
//        integerMap.put(4, 3);
//        integerMap.put(35, 33);
//        maxKey(integerMap);

        Map<Integer, Integer> integerMap1 = new HashMap<>();
        integerMap1.put(2, 0);
        integerMap1.put(14, 11);
        integerMap1.put(4, 3);
        integerMap1.put(35, 33);

        raznica(integerMap1);

    }

    //    HashMap<String, String>: Найдите количество пар ключ-значение,
//    где длина ключа равна длине значения.
    public static void findCount(Map<String, String> map) {
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.length() == value.length()) {
                count++;

            }
        }
        System.out.println("Найдите количество пар ключ-значение, где длина ключа равна длине значения: " + count);
    }

    //  HashMap<String, Integer>: Подсчитайте сумму всех значений,
//  соответствующих ключам, начинающимся на букву 'A'.
    public static int countSum(Map<String, Integer> map) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("A")) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

//    HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из
//    соответствующего списка, которые начинаются с гласной буквы.

    public static boolean start(String string) {
        List<Character> abc = new ArrayList<>(Arrays.asList('a', 'o', 'i', 'e', 'u', 'A', 'O', 'I', 'E', 'U'));
        return abc.contains((string.charAt(0)));
    }

    //    HashMap<Integer, Integer>: Найдите ключ с максимальным значением и выведите эту пару.
    public static void maxKey(Map<Integer, Integer> map) {
        int max = 0;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()) {
            List<Integer> integers = new ArrayList<>();
            integers.add(integerEntry.getKey());
            for (Integer integer : integers) {
                if (integer > max) {
                    max = integer;

                }
            }
        }
        System.out.print("ключ с максимальным значениям " + max + " Значения " + map.get(max));

    }

    //    HashMap<String, String>: Определите, содержит ли HashMap такую пару
//    ключ-значение, где ключ является обратной строкой значения (например, ключ "abc", значение "cba").
    public static void reverse(Map<String, String> map) {
        Map<String, String> stringStringMap = new HashMap<>();
        for (Map.Entry<String, String> str : map.entrySet()) {
            String key = str.getKey();
            String value = str.getValue();
            StringBuilder sb = new StringBuilder(value);
            if (sb.reverse().toString().equals(key)) {
                stringStringMap.put(str.getKey(), str.getValue());
            }
        }
        System.out.println(stringStringMap);
    }

//   HashMap<String, Integer>: Переберите HashMap и преобразуйте его в HashMap<String, String>,
//   где каждое значение - это строковое представление исходного числа, умноженного на 2.

    public static void math(Map<String, Integer> map) {
        Map<String, String> stringStringMap = new HashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            int value = stringIntegerEntry.getValue() * 2;
            String valueStr = String.valueOf(value);
            stringStringMap.put(stringIntegerEntry.getKey(), valueStr);
        }
        System.out.println(stringStringMap + " значения умноженное на два");
    }

    //    HashMap<Integer, List<String>>: Создайте второй HashMap<Integer, Integer>,
//    где каждый ключ - это ключ из исходного HashMap, а значение - общее
//    количество символов во всех строках списка этого ключа.
    public static void charList(Map<Integer, List<String>> map) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> listEntry : map.entrySet()) {
            int key = listEntry.getKey();
            List<String> strings = listEntry.getValue();
            int temp = 0;
            for (String s : strings) {
                temp += s.length();
            }
            integerMap.put(key, temp);
        }
        System.out.println(integerMap);
    }

    //    HashMap<Integer, Integer>: Найдите все пары ключ-значение, где ключ минус значение является простым числом.
    public static void raznica(Map<Integer, Integer> map){
        Map<Integer, Integer> integerMap2 = new HashMap<>();

        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()){
            int key = integerEntry.getKey();
            int values = integerEntry.getValue();
            int raz = key - values;
            if(number1(raz)){
                integerMap2.put(key, values);
            }
        }
        System.out.println(integerMap2);
    }

    public static boolean number1(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
