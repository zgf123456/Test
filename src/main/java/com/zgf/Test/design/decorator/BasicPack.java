package com.zgf.Test.design.decorator;

/**
 * 基础包装茶
 * 
 * @author zgf
 *
 */
public class BasicPack extends TeaPack {
	private Tea tea;

	public BasicPack(Tea tea) {
		this.tea = tea;
	}

	@Override
	public String getTea() {
		return tea.getName();
	}
}
