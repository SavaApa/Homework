package _06_12_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Overkill {
//    **Создайте TreeMap<String, Integer> и переберите его, создавая HashMap<Integer, String>,
//включающий только те записи, где значение больше 50.
    public static void main(String[] args) {
        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>();
        stringIntegerTreeMap.put("A", 51);
        stringIntegerTreeMap.put("Aa", 4);
        stringIntegerTreeMap.put("Av", 3);
        stringIntegerTreeMap.put("Ad", 1);
        System.out.println(overkill(stringIntegerTreeMap));
    }

    public static HashMap<Integer, String> overkill(TreeMap<String, Integer> map){
        HashMap<Integer, String> stringHashMap = new HashMap<>();
        for (Map.Entry<String, Integer> stringEntry : map.entrySet()) {
            if(stringEntry.getValue() > 50){
                stringHashMap.put(stringEntry.getValue(), stringEntry.getKey());
            }
        }
        return stringHashMap;
    }
}
