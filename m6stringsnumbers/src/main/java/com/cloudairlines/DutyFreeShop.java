package com.cloudairlines;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DutyFreeShop {

    public static void main(String[] args) {

        double total = 0;
        total += 7.6;
        total += 7.8;
        System.out.println(total); // 15.4? no!

        if(Math.abs(15.4 - total) < 0.00001) {
            System.out.println("true");
        }

        BigDecimal num1 = new BigDecimal("7.6");
        BigDecimal num2 = new BigDecimal("7.8");

        System.out.println(num1.add(num2));
        System.out.println(num1.divide(num2, RoundingMode.HALF_DOWN));

    }
}
