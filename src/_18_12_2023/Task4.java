package _18_12_2023;

public class Task4 {
    //Создайте функциональный интерфейс UpperCaseConverter с методом convert, который преобразует
// строку в верхний регистр.
//Напишите метод, который принимает строку и UpperCaseConverter
// интерфейс, и преобразует её в верхний регистр
    public static void main(String[] args) {
        getConvert(s -> System.out.println(s.toUpperCase()), "hello");
    }
    public static void getConvert(UpperCaseConverter converter, String s){
        converter.convert(s);
    }
}
@FunctionalInterface
interface UpperCaseConverter {
    void convert(String str);
}
