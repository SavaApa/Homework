package _11_12_2023;

import java.util.*;

public class task {
    public static void main(String[] args) {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("AA", "aa");
        stringStringMap.put("AB", "ab");
        stringStringMap.put("AC", "aa");

        Map<String, String> stringStringMap1 = new HashMap<>();
        stringStringMap1.put("AA", "aa");
        stringStringMap1.put("Am", "aa");
        stringStringMap1.put("Aq", "aa");
        System.out.println(mergeMapsIfUniqueKeys(stringStringMap, stringStringMap1));
        System.out.println();
        System.out.println(countUniqueValues(stringStringMap));
    }
//    void printMap(Map<String, String> map) {
//} Вывести все ключи и значения
    public static void mapOutput(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "Value: " + entry.getValue());
        }
    }

// Set<String> findKeysByValue(Map<String, String> map, String value) {
//} Найти ключи, значения которых равны заданной строке.
    public static Set<String> findKeysByValue(Map<String, String> map, String value){
        Set<String> result = new HashSet<>();
        for (String str: map.keySet()) {
            if(Objects.equals(str, value)){
                result.add(str);
            }
        }
        return result;
    }

    //Map<String, String> mergeMapsIfUniqueKeys(Map<String, String> map1, Map<String, String> map2) {
    // }Объединить две мапы, если у них нет одинаковых ключей.
    public static Map<String, String> mergeMapsIfUniqueKeys(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> mergeMap = new HashMap<>(map1);
        mergeMap.putAll(map2);
        return mergeMap;
    }

//    Map<String, String> invertMap(Map<String, String> map) {
//}Инвертировать мапу (ключи становятся значениями и наоборот).
    public static Map<String, String> invertMap(Map<String, String> map){
        Map<String, String> stringStringMap = new HashMap<>();
        for (Map.Entry<String, String> stringEntry : map.entrySet()) {
            stringStringMap.put(stringEntry.getValue(), stringEntry.getKey());
        }
        return stringStringMap;
    }

    //int countUniqueValues(Map<String, String> map) {}Найти количество уникальных значений в мапе
    public static int countUniqueValues(Map<String, String> map) {
        Set<String> set = new HashSet<>(map.values());
        return set.size();
    }

// Set<String> findAllValues(Set<Map<Integer, String>> setOfMaps) {
//}Вывести все строки, которые являются значениями в любой из мап.

}
