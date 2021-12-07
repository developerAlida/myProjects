package com.techelevator.ui;

import java.math.BigDecimal;

public class BigDollar {
    static BigDecimal oneDollar = new BigDecimal("1.00");
    static BigDecimal twoDollar = new BigDecimal("2.00");
    static BigDecimal fiveDollar = new BigDecimal("5.00");
    static BigDecimal tenDollar = new BigDecimal("10.00");

    public BigDollar(BigDecimal oneDollar, BigDecimal twoDollar, BigDecimal fiveDollar, BigDecimal tenDollar) {
        BigDollar.oneDollar = oneDollar;
        BigDollar.twoDollar = twoDollar;
        BigDollar.fiveDollar = fiveDollar;
        BigDollar.tenDollar = tenDollar;
    }

    public static BigDecimal getOneDollar() {
        return oneDollar;
    }

    public static BigDecimal getTwoDollar() {
        return twoDollar;
    }

    public static BigDecimal getFiveDollar() {
        return fiveDollar;
    }

    public static  BigDecimal getTenDollar() {
        return tenDollar;
    }




}



