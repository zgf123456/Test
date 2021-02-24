package com.zgf.Test.aligorthm.normal;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class PowxN {
    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println(powxN.myPow(2, -2147483648));
//        System.out.println(powxN.myPow(2, -2));
//        System.out.println(powxN.myPow(2, 10));
//        System.out.println(powxN.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        long n1 = n;
        if (n1 == 0) {
            return 1;
        } else if (n1 < 0) {
            x = 1 / x;
            n1 = Math.abs(n1);
        }

        HashMap<Long, Double> cacheMap = new HashMap<>();
        return myPoxX(x, n1, cacheMap);
    }

    public double myPoxX(double x, long n, HashMap<Long, Double> cacheMap) {
        Double aDouble = cacheMap.get(n);
        if (aDouble != null) {
            return aDouble;
        }

        long count = n / 2;
        long other = n % 2;

        double result = 1.0;
        if (n <= 3) {
            if (count == 1) {
                result = x * x;
            }
            if (other > 0) {
                result = result * x;
            }
            cacheMap.put(n, result);
            return result;
        } else {
            result = myPoxX(x, count, cacheMap) * myPoxX(x, count, cacheMap);
            if (other > 0) {
                result = result * x;
            }
            cacheMap.put(n, result);
            return result;
        }
    }
}
