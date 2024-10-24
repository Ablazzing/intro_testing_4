package com.javaacademy.it;

import com.javaacademy.calc.Calc;
import com.javaacademy.calc.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static com.javaacademy.calc.SquareType.*;

@DisplayName("Тестируем компьютер")
public class ComputerIT {
    private static double resultTest;

    @BeforeEach
    public void clear() {
        Computer.historyCompute.clear();
    }

    @Test
    public void calcNotNull() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        Assertions.assertNotNull(computer.getCalc());
    }

    @Test
    @DisplayName("Успешное вычисление квадратных метров")
    public void computeSquareMetersSuccess() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        int givenLength = 4;
        int givenWidth = 4;

        double result = computer.computeSquare(givenLength, givenWidth, METERS);

        double expected = 16;
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(1, Computer.historyCompute.size());
    }

    @Test
    @DisplayName("Успешное вычисление квадратных футов")
    public void computeSquareFootsSuccess() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        double result = computer.computeSquare(1, 1, FOOTS);

        Assertions.assertEquals(10.764, result);
        Assertions.assertEquals(1, Computer.historyCompute.size());
    }

    @Test
    //@Disabled
    @DisplayName("Ошибка вычисления квадратных ярдов")
    public void computeSquareYardsFailure() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        Assertions.assertThrows(
                InvalidParameterException.class,
                () -> computer.computeSquare(1, 1, YARDS)
        );
        Assertions.assertEquals(0, Computer.historyCompute.size());
    }
}
