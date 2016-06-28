package com.zgf.Test.junit4.rules;

import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ //
		TestRuleBase.class //
		, TestRuleExternalResource.class //
		, TestRuleErrorCollector.class //
		, TestWatcher.class //
		, TestRuleName.class //
})
public class TestRuleSuit {

}
