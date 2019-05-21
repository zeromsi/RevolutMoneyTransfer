package com.revolut.test.unit.service;

import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.junit.Before;
import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.repository.DataStore;

public class TransferServiceTest {

	@Before
	public void setUp() throws MalformedURLException, ServletException, LifecycleException, InterruptedException {
		DataStore.accounts.add(new Account("00123", 500.00, "Shahidul", 808767506000L, "user_001", "user_002"));
		DataStore.accounts.add(new Account("00124", 1000.00, "Munem", 808767506000L, "user_001", "user_002"));
		DataStore.branches.add(new Branch("001", "Dhaka"));
	}

}
