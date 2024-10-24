package com.javaacademy.unit.calc;

import com.javaacademy.calc.Calc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Тестирование калькулятора")
public class CalcTest {

    @Test
    @DisplayName("Успешное сложение")
    public void add() {
        Calc calc = new Calc();
        int result = calc.add(10, 10);
        if (result != 20) {
            throw new RuntimeException("Ожидалось 20, а результат: " + result);
        }
    }

    @Test
    @DisplayName("Успешное деление")
    public void divideSuccess() {
        Calc calc = new Calc();
        int result = calc.divide(4, 2);
//        if (result != 2) {
//            throw new RuntimeException("Ожидалось 2, а результат: " + result);
//        }
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("Деление на ноль выкидывающие исключение")
    public void divideFailure() {
        Calc calc = new Calc();
        Assertions.assertThrows(Exception.class, () -> calc.divide(4, 0));

//        try {
//            calc.divide(4, 0);
//            throw new RuntimeException("Не выкинулось исключение");
//        } catch (ArithmeticException e) {
//            System.out.println("Все ок");
//        }
    }

    @Test
    @DisplayName("Успешное умножение")
    public void multiply() {
        Calc calc = new Calc();
        int result = calc.multiply(3, 3);
        if (result != 9) {
            throw new RuntimeException("Ожидалось 9, а результат: " + result);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calc_test.csv", delimiter = ';', numLinesToSkip = 1)
    public void multiplyFromCsvSuccess(Integer number1, Integer number2, Integer expected) {
        System.out.printf("number1: %s, number2: %s, expected: %s \n", number1, number2, expected);
        Calc calc = new Calc();
        int result = calc.multiply(number1, number2);

        Assertions.assertEquals(expected, result);
    }
}
