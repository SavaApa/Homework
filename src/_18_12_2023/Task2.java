package _18_12_2023;

public class Task2 {
    //    Создайте функциональный интерфейс NumberOperation с методом operate,
//    который принимает два целых числа и возвращает целое число.
//Напишите методы для выполнения базовых арифметических операций
// (сложение, вычитание, умножение, деление) с использованием этого интерфейса.
    public static void main(String[] args) {
        operation((a, b) -> System.out.println(a + b), 5, 5);
        operation((a, b) -> System.out.println(a - b), 5, 5);
        operation((a, b) -> System.out.println(a * b), 5, 5);
        operation((a, b) -> System.out.println(a / b), 5, 5);
    }

    public static void operation(NumberOperation numOper, int a, int b){
        numOper.operate(a, b);
    }
}

@FunctionalInterface
interface NumberOperation{
    void operate(int num1, int num2);
}
