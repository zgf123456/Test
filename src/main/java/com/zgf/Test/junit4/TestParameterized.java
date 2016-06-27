package com.zgf.Test.junit4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 输入参数测试
 * 
 * @author zgf
 *
 */
@RunWith(Parameterized.class)
public class TestParameterized {
	/**
	 * 定义测试参数，与构造函数对应
	 * 
	 * @return
	 */
//	// 多维参数格式1 - 集合 + 数组
//	@Parameters
//	public static Collection<Object[]> data() {
//		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
//	}
	
	// 多维参数格式2 - 二维数组
	// * {index} - the current parameter index
    // * {0} - the first parameter value
    // * {1} - the second parameter value
	@Parameters(name="{index}:Fibonacci.compute({0})={1}") // name定义显示格式，无特殊意义
	public static Object[][] data() {
		return new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } };
	}

//	// 一维参数格式1 - Iterable
//	@Parameters
//	public static Iterable<? extends Object> data() {
//	    return Arrays.asList("first test", "second test");
//	}

//	// 多维参数格式2 - 数组	
//	@Parameters
//	public static Object[] data() {
//	    return new Object[] { "first test", "second test" };
//	}
	

	// // 方式1 - 构造方式注入
	// private int fInput;
	// private int fExpected;
	//
	// public TestParameterized(int input, int expected) {
	// fInput = input;
	// fExpected = expected;
	// }

	// //方式2 - 使用注解，字段类型不能是private
	@Parameter // first data value (0) is default
	public /* NOT private */ int fInput;

	@Parameter(value = 1)
	public /* NOT private */ int fExpected;

	@Test
	public void test() {
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}

	static class Fibonacci {
		public static int compute(int n) {
			int result = 0;

			if (n <= 1) {
				result = n;
			} else {
				result = compute(n - 1) + compute(n - 2);
			}

			return result;
		}
	}
}
