package com.revolut.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revolut.test.unit.bean.TransferBeanTest;
import com.revolut.test.unit.data.AccountTest;
import com.revolut.test.unit.repository.AccountRepositoryTest;
import com.revolut.test.unit.repository.BranchRepositoryTest;
import com.revolut.test.unit.repository.TransferRepositoryTest;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, AccountRepositoryTest.class, BranchRepositoryTest.class,
		TransferRepositoryTest.class, TransferBeanTest.class })
public class UnitTestSuite {

}
