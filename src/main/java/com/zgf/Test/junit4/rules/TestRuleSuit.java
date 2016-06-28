package com.zgf.Test.junit4.rules;

import java.util.concurrent.TimeUnit;

import org.junit.ClassRule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ //
		TestRuleBase.class //
		, TestRuleExternalResource.class //
		, TestRuleErrorCollector.class //
		, TestWatcher.class //
		, TestRuleName.class //
		, TestRuleTimeout.class //
		, TestRuleChain.class //
})
public class TestRuleSuit {
	/**
	 * 全部子测试的时间相加，不超出设置时间
	 */
	@ClassRule
	public static TestRule globalTimeout = new Timeout(2000, TimeUnit.MILLISECONDS);
}
