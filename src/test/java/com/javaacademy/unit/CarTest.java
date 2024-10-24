package com.javaacademy.unit;

import com.javaacademy.car.Car;
import com.javaacademy.car.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarTest {

    @Test
    public void startSuccess() {
        Engine engineMock = Mockito.mock(Engine.class);
        Car car = new Car(engineMock);

        Assertions.assertDoesNotThrow(() -> car.start(100));
    }

    @Test
    public void startFailure() {
        Engine engineMock = Mockito.mock(Engine.class);
        Mockito.doThrow(RuntimeException.class).when(engineMock).start(-1);

        Car car = new Car(engineMock);
        //Mockito.when(engineMock.start(-1)).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> car.start(-1));
    }
}
