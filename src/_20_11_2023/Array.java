package _20_11_2023;

public class Array {
    public static int arr(int[] number){
        int max = 0;
        int secondLarg = 0;
        int thirdLarg = 0;
        for (int i = 0; i < number.length; i++) {
            if(number[i] > max){
                secondLarg = max;
                max = number[i];
            }else if(number[i] > secondLarg){
                thirdLarg = secondLarg;
                secondLarg = number[i];
            }else if(number[i] > thirdLarg){
                thirdLarg = number[i];
            }
            // в этом месте я застрял
        }

        return thirdLarg;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 3, 5, 6, 7};
        System.out.println(Array.arr(array1));
    }
}
