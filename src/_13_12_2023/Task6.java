package _13_12_2023;

import java.util.HashMap;
import java.util.Map;

public class Task6 {
//    Создайте Map<String, String>, добавьте в него несколько пар ключ-значение,
//  затем найдите определенный ключ и замените его значение.
//  Map<String, String> map = new HashMap<>();
//         map.put("A", "C");
//         map.put("B", "D");
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
         map.put("A", "C");
         map.put("B", "D");
        System.out.println(values(map, "A", "C"));

    }

    public static Map<String, String> values(Map<String, String> map, String key, String value){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(key.equals(entry.getKey())){
                entry.setValue(value);
            }
        }
        return map;
    }
}
