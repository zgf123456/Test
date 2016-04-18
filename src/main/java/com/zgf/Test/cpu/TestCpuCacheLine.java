package com.zgf.Test.cpu;

import java.util.Random;

/**
 * CPU缓存行对性能影响测试
 */
public class TestCpuCacheLine {
	public static void main(String[] args) {
		int d_1 = 1024 * 1024;
		int d_2 = 62;
		long[][] longs = new long[d_1][];

		Random r = new Random();
		for (int i = 0; i < d_1; i++) {
			longs[i] = new long[d_2];
			for (int j = 0; j < d_2; j++) {
				longs[i][j] = r.nextLong();
			}
		}

		long start = System.currentTimeMillis();
		long sum = 0;		
		for (int i = 0; i < d_1; i++) {
			for (int j = 0; j < d_2; j++) {
				sum += longs[i][j];
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(">>>" + sum + "," + (end - start));
		
		long start1 = System.currentTimeMillis();
		long sum1 = 0;
		for (int j = 0; j < d_2; j++) {
			for (int i = 0; i < d_1; i++) {
				sum1 += longs[i][j];
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println(">>>" + sum1 + "," + (end1 - start1));
	}
}
