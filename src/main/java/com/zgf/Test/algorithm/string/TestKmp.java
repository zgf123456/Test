package com.zgf.Test.algorithm.string;

import java.util.Arrays;

import org.junit.Test;

public class TestKmp {
	public static void main(String[] args) {
		String source = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String target = "afafb";

		System.out.println("next数组"+Arrays.toString(buildNextArray(target)));

		int index = simpleMatch(source, target);
		System.out.println("匹配位置" + index);
		if (index != -1) {
			System.out.println(source.substring(index, index + target.length()));
		}

		index = kmpMatch(source, target);
		System.out.println("匹配位置" + index);
		if (index != -1) {
			System.out.println(source.substring(index, index + target.length()));
		}
	}
	
	@Test
	public void testBuildNextArray(){
		String target = "ababa";
		System.out.println("next数组"+Arrays.toString(buildNextArray(target)));
	}

	/**
	 * kmp匹配算法
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	private static int kmpMatch(String source, String target) {
		int index = -1;
		int sLen = source.length();
		int tLen = target.length();
		int comCount = 0;

		int[] nextValArray = buildNextArray(target);

		int sFlag = 0;
		int tFlag = 0;

		while (tFlag < tLen && sFlag < sLen) {
			comCount++;
			if (tFlag == -1 || source.charAt(sFlag) == target.charAt(tFlag)) {
				sFlag++;
				tFlag++;
			} else {
				tFlag = nextValArray[tFlag];
			}
		}

		System.out.println("KMP匹配计算次数" + comCount);
		if (tFlag == tLen) {
			index = sFlag - tLen;
		}
		return index;
	}

	/**
	 * 构建模式跳转表
	 * 
	 * @param target
	 * @return
	 */
	private static int[] buildNextArray(String target) {
		char[] p = target.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int j = 0;
		int k = -1;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	/**
	 * jian简单匹配算法
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	private static int simpleMatch(String source, String target) {
		int index = -1;
		int sFlag = 0;
		int sLen = source.length();
		int tLen = target.length();
		int comCount = 0;

		for (; sFlag <= (sLen - tLen); sFlag++) {
			int sPos = 0;
			int tFlag = 0;
			boolean isMatch = true;
			for (; tFlag < tLen; tFlag++, sPos++) {
				comCount++;
				if (source.charAt(sFlag + sPos) != target.charAt(tFlag)) {
					isMatch = false;
					break;
				}
			}

			if (isMatch) {
				index = sFlag;
				break;
			}
		}
		System.out.println("简单匹配计算次数" + comCount);
		return index;
	}
}
