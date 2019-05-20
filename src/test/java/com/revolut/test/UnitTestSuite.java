package com.revolut.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.revolut.test.unit.data.AccountTest;
import com.revolut.test.unit.repository.AccountRepositoryTest;
@RunWith(Suite.class)
@SuiteClasses({AccountRepositoryTest.class,AccountTest.class})
public class UnitTestSuite {
	

}
