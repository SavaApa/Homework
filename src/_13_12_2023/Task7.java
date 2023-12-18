package _13_12_2023;

import java.util.HashMap;
import java.util.Map;

public class Task7 {
//    Инвертируйте Map<String, String>, чтобы ключи стали значениями, а значения ключами.
//  public static Map<String, String> invert(Map<String, String> map)
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "f");
        map.put("b", "e");
        map.put("c", "d");
        System.out.println(invert(map));
    }

    public static Map<String, String> invert(Map<String, String> map){
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        return newMap;
    }
}
