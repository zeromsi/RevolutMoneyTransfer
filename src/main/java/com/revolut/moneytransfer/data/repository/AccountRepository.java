package com.revolut.moneytransfer.data.repository;

import com.revolut.moneytransfer.data.Account;

public class AccountRepository {

	public Account findById(String id) {
		return DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().orElse(null);
	}

	 public void deductAmount(String id, Double amount) throws Exception {
			DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().get()
					.deductAmount(amount);
	}

	 public void addAmount(String id, Double amount){
			DataStore.accounts.stream().filter(account -> id.equals(account.getId())).findAny().get()
					.addAmount(amount);
	}
}
