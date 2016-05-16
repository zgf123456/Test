package com.zgf.Test.design.decorator;

/**
 * 铁桶包装
 * 
 * @author zgf
 *
 */
public class MetalPack extends TeaPack {
	private TeaPack teaPack;

	public MetalPack(TeaPack teaPack) {
		this.teaPack = teaPack;
	}

	@Override
	public String getTea() {
		return "铁桶包装[" + teaPack.getTea() + "]";
	}

}
