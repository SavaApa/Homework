package _18_12_2023;

public class Task1 {
    //    Создайте функциональный интерфейс StringLength с методом getLength, который принимает строку и возвращает её длину.
//Напишите метод, который принимает строку и StringLength интерфейс и выводит длину строки.
    public static void main(String[] args) {
        str(str1 -> System.out.println(str1.length()), "Misha");
    }

    public static void str(StringLength s, String str1) {
        s.getLength(str1);
    }

}
@FunctionalInterface
interface StringLength {
    void getLength(String str);
}
