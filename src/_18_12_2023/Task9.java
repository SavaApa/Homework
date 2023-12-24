package _18_12_2023;

import java.util.Arrays;

public class Task9 {
//    Создайте функциональный интерфейс ArrayRotator с методом rotate,
//    который выполняет циклический сдвиг элементов массива.
//Напишите метод, который принимает массив и ArrayRotator и шаг сдвига, и
// выполняет сдвиг массива на заданную позицию влево.
    public static void main(String[] args) {
        int t = 4;
        int[] newArray = {1, 2, 3, 4, 5};
        ArrayRotator arrayRotator = array ->{
            for (int i = 0; i < t; i++) {
                int temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
            return array;
        };

        System.out.println(Arrays.toString(element(newArray, arrayRotator, t)));
    }

    public static int[] element(int[] array, ArrayRotator rotator, int t){
        return rotator.rotate(array);
    }
}

@FunctionalInterface
interface ArrayRotator{
    int[] rotate(int[] a);
}
