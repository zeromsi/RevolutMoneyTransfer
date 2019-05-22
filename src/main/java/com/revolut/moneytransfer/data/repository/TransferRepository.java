package com.revolut.moneytransfer.data.repository;

import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.Transfer;

public class TransferRepository {

	public void transfer(Account accountTo, Account accountFrom, Double amount, Branch branch) throws Exception{
		DataStore.transfers.add(new Transfer(accountTo, accountFrom, amount, branch));
	}
}
