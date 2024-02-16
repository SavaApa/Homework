package _14_02_2024;

public class Taski {

    //    Сложение (add): Принимает два числа и возвращает их сумму.
    public int add(int a, int b) {
        return a + b;
    }

    //    Вычитание (subtract): Принимает два числа и возвращает результат их вычитания.
    public int subtract(int a, int b) {
        return a - b;
    }

    //    Умножение (multiply): Принимает два числа и возвращает их произведение.
    public int multiply(int a, int b) {
        return a * b;
    }

    //    Деление (divide): Принимает два числа и возвращает результат деления первого на второе.
//    Необходимо обработать случай деления на ноль.
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    //  Возведение в степень (power): Принимает основание и показатель степени,
//  возвращает результат возведения числа в степень.
    public int power(int a, int b) {
        if (b < 1) {
            throw new ArithmeticException();
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    //    Факториал (factorial): Принимает число и возвращает его факториал.
//    Должна быть обработка отрицательных чисел.
    public int factorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        if (a == 0 || a == 1) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }

    //    Модуль числа (absolute): Принимает число и возвращает его абсолютное значение.
    public int absolute(int a) {
        return (a < 0) ? -a : a;
    }

    //    Логарифм (logarithm): Принимает основание логарифма и число, для
//    которого необходимо вычислить логарифм.
    public int logarithm(int base, int num) {
        if (base <= 0 || base == 1 || num <= 0) {
            throw new ArithmeticException();
        }

        int temp = 0;
        int power = 1;

        while (power < num) {
            power *= base;
            temp++;
        }

        if (power != num) {
            throw new ArithmeticException();
        }

        return temp;
    }

    //Синус (sin): Принимает угол в радианах и возвращает его синус.
    public double sin(double a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        int iterations = 10;
        double result = 0;

        for (int i = 0; i < iterations; i++) {
            result += ((i % 2 == 0 ? 1 : -1) * powerDouble(a, 2 * i + 1)) / factorial(2 * i + 1);
        }
        return result;
    }

    private double powerDouble(double base, int num) {
        double result = 1.0;
        for (int i = 0; i < num; i++) {
            result *= base;
        }
        return result;
    }
}
