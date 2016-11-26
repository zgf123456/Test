package com.zgf.Test.java;

import java.math.BigDecimal;

public class TestUUID {
	public static void main(String[] args) {
		// System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		// 签名前金额兼容处理
		BigDecimal amountYuan = new BigDecimal(100).divide(new BigDecimal(100));
		BigDecimal setScale = amountYuan.setScale(2);
		System.out.println(setScale.toString());
	}
}
