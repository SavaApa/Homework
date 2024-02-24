package _14_02_2024_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskiTest {

    private static final Taski TASKI = new Taski();
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_0 = 0;

    @Test
    void addTest() {
        Assertions.assertEquals(5, TASKI.add(NUM_2, NUM_3));
        Assertions.assertEquals(NUM_0, TASKI.add(NUM_0, NUM_0));
        Assertions.assertEquals(-5, TASKI.add(-105, 100));
    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(-1, TASKI.subtract(NUM_2, NUM_3));
        Assertions.assertEquals(NUM_0, TASKI.subtract(NUM_0, NUM_0));
        Assertions.assertEquals(-8, TASKI.subtract(-5, NUM_3));
    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(6, TASKI.multiply(NUM_2, NUM_3));
        Assertions.assertEquals(NUM_0, TASKI.multiply(NUM_0, NUM_0));
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(5, TASKI.divide(10, NUM_2));
        Assertions.assertEquals(NUM_0, TASKI.divide(NUM_0, NUM_2));
    }

    @Test
    void divWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> TASKI.divide(NUM_2, 0));
    }

    @Test
    void powerTest() {
        Assertions.assertEquals(25, TASKI.power(5, NUM_2));
        Assertions.assertEquals(-125, TASKI.power(-5, NUM_3));
    }

    @Test
    void powerWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> TASKI.power(NUM_2, -2));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(6, TASKI.factorial(NUM_3));
    }

    @Test
    void factorialWithExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI.factorial(-NUM_2));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(NUM_3, TASKI.absolute(NUM_3));
        Assertions.assertEquals(NUM_3, TASKI.absolute(-NUM_3));
    }

    @Test
    void logarithmTest() {
        Assertions.assertEquals(NUM_3, TASKI.logarithm(NUM_2, 8));
    }

    @Test
    void logarithmInvalidTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> TASKI.logarithm(NUM_0, NUM_0));
        Assertions.assertThrows(ArithmeticException.class, () -> TASKI.logarithm(NUM_2, NUM_0));
        Assertions.assertThrows(ArithmeticException.class, () -> TASKI.logarithm(NUM_2, 5));
    }

    @Test
    void sinTest() {
        double sin = Math.toRadians(30);
        Assertions.assertEquals(0.5, TASKI.sin(sin), 0.01);
        Assertions.assertEquals(0, TASKI.sin(0), 0.01);
    }

    @Test
    void sinInvalidTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI.sin(-NUM_2));
    }
}