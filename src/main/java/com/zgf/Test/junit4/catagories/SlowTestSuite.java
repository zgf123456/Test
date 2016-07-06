package com.zgf.Test.junit4.catagories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
//@ExcludeCategory(FastTests.class)
@SuiteClasses({ TestA.class, TestB.class })
public class SlowTestSuite {

}
