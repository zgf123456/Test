package com.zgf.Test.junit4.theories;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

/**
 * 定义Bewteen委托处理类
 * 
 * @author zgf
 *
 */
public class BetweenSupplier extends ParameterSupplier {

	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
		// 自定义实参值列表
		List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();

		// 获取注解变量
		Between between = sig.getAnnotation(Between.class);

		// 获取通过注解@Between传入的first值
		int first = between.first();

		// 获取通过注解@Between传入的last值
		int last = between.last();

		for (int i = first; i <= last; i++) {
			// PotentialAssignment.forValue(String name, Object value)
			// name为value的描述标记，没实际作用
			// value为实参可选值
			list.add(PotentialAssignment.forValue("name", i));
		}
		return list;
	}
}