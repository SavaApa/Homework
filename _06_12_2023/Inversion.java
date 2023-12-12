package _06_12_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inversion {
    //    **Создайте HashMap<Integer, String> и перепишите его в TreeMap<String, Integer>,
//инвертируя ключи и значения.
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        map.put(4, "dd");
        System.out.println(invert(map));

    }

    public static TreeMap<String, Integer> invert(HashMap<Integer, String> map){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> stringEntry : map.entrySet()){
            treeMap.put(stringEntry.getValue(), stringEntry.getKey());
        }
        return  treeMap;
    }
}
