package com.zgf.Test.junit4;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

/**
 * 测试集合
 * @author zgf
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestAssertion.class
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSuit {

}

