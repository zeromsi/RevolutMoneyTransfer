package com.revolut.moneytransfer.data.repository;

import com.revolut.moneytransfer.data.Account;

public class AccountRepository {

	public Account findById(String id) {
		return DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().orElse(null);
	}

	synchronized public void deductAmount(String id, Double amount) throws Exception {
			DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().get()
					.deductAmount(amount);
	}

	synchronized public void addAmount(String id, Double amount) throws Exception {
			DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().get()
					.addAmount(amount);
	}
}
