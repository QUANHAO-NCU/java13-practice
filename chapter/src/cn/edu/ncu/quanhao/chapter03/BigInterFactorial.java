package cn.edu.ncu.quanhao.chapter03;

import java.math.BigInteger;

public class BigInterFactorial {
    public static void main(String[] args) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= 1000; i++) {
            result = result.multiply(new BigInteger("" + i));
        }
        System.out.println(result);
    }
}
