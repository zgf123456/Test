package com.zgf.Test.junit4.theories;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

/**
 * 固定参数处理器
 * 
 * @author zgf
 *
 */
public class AllValueSupplier extends ParameterSupplier {

	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
		List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
		// 内定提供固定的可用实参值表
		for (int i = 0; i <= 100; i++) {
			list.add(PotentialAssignment.forValue("name", i));
		}
		return list;
	}

}
