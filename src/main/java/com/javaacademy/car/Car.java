package com.javaacademy.car;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start(int fuel) {
        engine.start(fuel);
    }
}
