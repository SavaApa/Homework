package _18_12_2023_functionalInterface;

public class Task5 {
    //   Создайте функциональный интерфейс Logger с методом log, который принимает строку и выводит её в консоль.
//Напишите метод, который использует Logger для логирования различных сообщений.
    public static void main(String[] args) {
        getLogger(System.out::println);
    }

    public static void getLogger(Logger logg){
        logg.log("Java homework");
    }
}
@FunctionalInterface
interface Logger{
    void log(String s);
}
