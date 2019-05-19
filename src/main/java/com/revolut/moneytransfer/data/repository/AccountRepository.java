package com.revolut.moneytransfer.data.repository;

import com.revolut.moneytransfer.data.Account;

public class AccountRepository {

	public Account findById(String id) {
		return DataStore.findAccountById(id);
	}

	public boolean deductAmount(String id, Double amount) {
		// TODO Auto-generated method stub
	}

	public boolean addAmount(String id, Double amount) {
		// TODO Auto-generated method stub
		
	}
}
