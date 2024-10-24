package com.javaacademy.car;

public class Engine {

    //Spy
    public void start(int fuel) {
        //spy
        if (fuel == 100) {
            System.out.println("Двигатель завелся");
            return;
        }

        if (fuel < 10_000) {
            throw new RuntimeException("Мало бензина (косяк джуна)");
        }
        System.out.println("Двигатель завелся");
    }

//    //Mock
//    public void start(int fuel) {
//
//    }
}
