package com.zgf.Test.design.decorator;

/**
 * 纸袋包装
 * 
 * @author zgf
 *
 */
public class PaperBagPack extends TeaPack {
	private TeaPack teaPack;

	public PaperBagPack(TeaPack teaPack) {
		this.teaPack = teaPack;
	}

	@Override
	public String getTea() {
		return "纸袋包装[" + teaPack.getTea() + "]";
	}

}
