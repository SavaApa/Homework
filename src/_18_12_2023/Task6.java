package _18_12_2023;

import java.util.Arrays;

public class Task6 {
    // Создайте функциональный интерфейс ArrayTransformer с методом transform, который принимает массив
//целых чисел и выполняет операцию возведения каждого элемента в квадрат.
//Напишите метод, который принимает массив и ArrayTransformer, и изменяет
// массив, возведя каждый его элемент в квадрат.
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4};
        ArrayTransformer arrTrans = a -> {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * a[i];
            }
            return a;
        };
        System.out.println(Arrays.toString(operation(arrTrans, number)));
    }

    public static int[] operation(ArrayTransformer transformer, int[] a) {
        return transformer.transform(a);
    }
}
@FunctionalInterface
interface ArrayTransformer {
    int[] transform(int[] number);
}
