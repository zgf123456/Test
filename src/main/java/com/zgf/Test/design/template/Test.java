package com.zgf.Test.design.template;

public class Test {
	public static void main(String[] args) {
		AbstractTemplate template = new SubTemplate1();
		template.templateMethod();
	}
}
