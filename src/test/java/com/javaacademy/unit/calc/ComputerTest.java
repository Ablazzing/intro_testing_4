package com.javaacademy.unit.calc;

import com.javaacademy.calc.Calc;
import com.javaacademy.calc.Computer;
import com.javaacademy.calc.SquareType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ComputerTest {

    @Test
    public void computeSquareMetersSuccess() {
        Calc mock = Mockito.mock(Calc.class);
        Mockito.when(mock.multiply(2, 2)).thenReturn(4);
        Computer computer = new Computer(mock);
        double result = computer.computeSquare(2, 2, SquareType.METERS);

        double expected = 4;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void computeSquareMetersSuccess2() {
        Calc calcSpy = Mockito.spy(Calc.class);

        Mockito.when(calcSpy.multiply(2, 2)).thenReturn(4);
        Computer computer = new Computer(calcSpy);
        double result = computer.computeSquare(2, 2, SquareType.METERS);

        double expected = 4;
        Assertions.assertEquals(expected, result);

        double result2 = computer.computeSquare(3, 3, SquareType.METERS);
        double expected2 = 9;

        Assertions.assertEquals(expected2, result2);

    }
}
