package com.javaacademy.it;

import com.javaacademy.car.Car;
import com.javaacademy.car.Engine;
import org.junit.jupiter.api.Test;

public class CarIT {

    @Test
    public void startSuccess() {
        Engine engine = new Engine();
        Car car = new Car(engine);
        car.start(100);
    }
}
