package com.zgf.Test.design.decorator;

public class Test {
	public static void main(String[] args) {
		BasicPack basicPack = new BasicPack(new Tea("龙井茶"));
		System.out.println(basicPack.getTea());
		
		PaperBagPack paperBagPack = new PaperBagPack(basicPack);
		System.out.println(paperBagPack.getTea());
		
		MetalPack metalPack = new MetalPack(paperBagPack);
		System.out.println(metalPack.getTea());
		
	}
}
