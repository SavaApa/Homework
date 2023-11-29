package _20_11_2023;

import java.util.Arrays;

public class InvertArray {
    public static void invert(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] array1 = new int[]{2, 3, 5, 6, 7};
        InvertArray.invert(array1);
        System.out.println(Arrays.toString(array1));
    }
}
