package com.zgf.Test.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试集合
 * @author zgf
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestAssertion.class,
  TestException.class,
  TestIgnoring.class,
  TestTimeout.class
})
public class TestSuit {

}

