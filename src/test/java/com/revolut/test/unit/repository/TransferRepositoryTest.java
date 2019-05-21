package com.revolut.test.unit.repository;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.Transfer;
import com.revolut.moneytransfer.data.repository.DataStore;
import com.revolut.moneytransfer.data.repository.TransferRepository;

public class TransferRepositoryTest {

	TransferRepository transferRepository;
	
	public TransferRepositoryTest() {
		this.transferRepository=new TransferRepository();
	}
	
	@Before
	public void setUp() {
		DataStore.accounts.add(new Account("00123", 500.00, "Shahidul", 808767506000L, "user_001", "user_002"));
		DataStore.accounts.add(new Account("00124", 1000.00, "Munem", 808767506000L, "user_001", "user_002"));

		DataStore.branches.add(new Branch("001", "Dhaka"));
		DataStore.transfers.add(new Transfer(DataStore.accounts.get(0), DataStore.accounts.get(1), 50.00, DataStore.branches.get(0)));
	}
	

	@Test
	public void givenValidData_whenCallingTranhsferIfRecordGotAdded_thenTrue() {
		int previousSize=DataStore.transfers.size();
		transferRepository.transfer(DataStore.accounts.get(0), DataStore.accounts.get(1), 50.00, DataStore.branches.get(0));
		int currentSize=DataStore.transfers.size();
		assertEquals("fail: Should return true",previousSize+1,currentSize);
	}

}
