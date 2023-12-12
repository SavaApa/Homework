package _06_12_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task {


    public static void main(String[] args) {
        Map<String, Integer> nameAge = new HashMap<>();

        nameAge.put("Lana", 34);
        nameAge.put("Tom", 24);
        nameAge.put("Jana", 12);
        doubleAge(nameAge);

        Map<Integer, String> user = new HashMap<>();
        user.put(99, "Lana");
        user.put(101, "Tom");
        user.put(105, "Jana");
        filterId(user);

        Map<User, String> userStringMap = new TreeMap<>();
        userStringMap.put(new User("Sava", 23), "S");
        userStringMap.put(new User("Lana", 18), "L");
        System.out.println(userStringMap);

        Map<User, String> nameStringMap = new TreeMap<>();
        nameStringMap.put(new User("Sava", 23), "s");
        nameStringMap.put(new User("Anna", 20), "a");
        System.out.println(nameStringMap);
    }

    /*
    **Создайте HashMap<String, Integer>, заполните его парами
"имя-возраст". Используйте цикл for-each для удвоения возраста каждого человека.
     */

    public static void doubleAge(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> age : map.entrySet()) {
            System.out.println(age.getValue() * 2);
        }
    }


     /*
    ***Создайте HashMap<Integer, String>, представляющий
"ID-имя пользователя". Используйте цикл для фильтрации
пользователей с ID больше 100 и копируйте их в TreeMap.
     */

    public static void filterId(Map<Integer, String> map) {
        Map<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> map1 : map.entrySet()) {
            if(map1.getKey() > 100){
                treeMap.put(map1.getKey(), map1.getValue());
            }
        }
        System.out.println(treeMap);
    }
}


