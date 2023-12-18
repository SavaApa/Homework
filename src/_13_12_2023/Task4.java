package _13_12_2023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task4 {
//    //  Печать элементов Queue в обратном порядке
//    public static void printInReverse(Queue<String> queue)
    public static void main(String[] args) {
        Queue<String> str = new LinkedList<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");

        printInReverse(str);
    }

    public static void printInReverse(Queue<String> queue){
        Stack<String> stack = new Stack<>();
        stack.addAll(queue);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
