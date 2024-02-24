package _18_12_2023_functionalInterface;

import java.util.Arrays;

public class Task8 {
//   Создайте функциональный интерфейс NumberProcessor с ме
//   тодом process, который выполняет операцию над массивом чисел.
//Напишите метод, который принимает массив чисел и NumberProcessor,
// и возвращает массив после умножения каждого элемента на -1
    public static void main(String[] args) {
        int[] newArray = {1, 2, 3, 4};
        NumberProcessor numberProcessor = array ->{
            for (int i = 0; i < array.length; i++) {
                array[i] *= -1;
            }

            return array;
        };
        System.out.println(Arrays.toString(method(newArray, numberProcessor)));
    }

    public static int[] method(int[] numberArray, NumberProcessor processor){
        return processor.process(numberArray);
    }
}

@FunctionalInterface
interface  NumberProcessor{
    int[] process(int[] number);
}
