package org.example.lesson4;

import java.util.Arrays;

public class Triangle {
//    public static void main(String[] args) {
//
//        try {
//            System.out.println(areaCalculation(0,20,30));
//        } catch (MyException e) {
//            throw new RuntimeException(e);
//        }    }
    public double areaCalculation(int a, int b, int c) throws MyException {
        if(a <= 0 || b <= 0 || c <= 0) throw new MyException("Это не треугольник");
        int p = (a + b + c) / 2;

        int value = (p*(p - a)*(p - b)*(p - c));
        double result = Math.sqrt(value);

        return result;
    }


   }