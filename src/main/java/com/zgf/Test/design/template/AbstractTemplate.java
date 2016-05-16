package com.zgf.Test.design.template;

/**
 * 模板方法模式
 * @author zgf
 *
 */
public abstract class AbstractTemplate {
	public final void templateMethod(){
		System.out.println("template parent method start");
		ovrrideMethod();
		System.out.println("template parent method end");
	}
	
	protected abstract void ovrrideMethod();
}
