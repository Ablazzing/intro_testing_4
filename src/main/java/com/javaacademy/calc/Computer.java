package com.javaacademy.calc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Computer {
    private static final double FOOT_FORMULA_MULTIPLAYER = 10.764;
    public static List<Double> historyCompute = new ArrayList<>();
    private Calc calc;

    /**
     * Вычисление площади прямоугольника
     */
    public double computeSquare(int lengthMeter, int widthMeter, SquareType squareType) {
        double resultSquareMeters = calc.multiply(lengthMeter, widthMeter);
        if (squareType == SquareType.METERS) {
            historyCompute.add(resultSquareMeters);
            return resultSquareMeters;
        } else if (squareType == SquareType.FOOTS) {
            double squareMetersToFoots = convertSquareMetersToFoots(resultSquareMeters);
            historyCompute.add(resultSquareMeters);
            return squareMetersToFoots;
        }
        throw new InvalidParameterException("Нет системы перевода в этот тип измерения: " + squareType.name());
    }

    private double convertSquareMetersToFoots(double squareMeters) {
        return squareMeters * FOOT_FORMULA_MULTIPLAYER;
    }
}
