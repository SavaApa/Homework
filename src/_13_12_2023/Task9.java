package _13_12_2023;

import java.util.Arrays;

public class Task9 {
//    - Написать функцию, которая проверяет, являются ли две строки анаграммами друг друга.
//  public boolean areAnagrams(String str1, String str2)
    public static void main(String[] args) {
        System.out.println(areAnagrams("апорт", ""));
    }

    public static boolean areAnagrams(String str1, String str2){
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}
