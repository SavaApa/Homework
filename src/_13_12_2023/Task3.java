package _13_12_2023;

import java.util.Stack;

public class Task3 {
//    Реализуйте функцию, которая использует Stack<String> для реверса строки.
//  public static String reverse(String str)
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("ab");

        System.out.println(reverse(stack));
    }

    public static String reverse(Stack<String> stack){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stack.get(stack.size() -1)).reverse();
        return stringBuilder.toString();
    }
}
