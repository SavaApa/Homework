package _06_12_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap {
//    **Создайте HashMap<String, Integer>, переберите её и создайте List<Integer>,
//содержащий все значения HashMap.
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("aa", 3);
        stringIntegerMap.put("bb", 9);
        stringIntegerMap.put("cc", 5);
        stringIntegerMap.put("dd", 4);
        per(stringIntegerMap);
    }

    public static void per(Map<String, Integer> map){
        List<Integer> integers = new ArrayList<>();
        for (Map.Entry<String, Integer> integerEntry : map.entrySet()) {
            integers.add(integerEntry.getValue());
        }
        System.out.println(integers);
    }
}
