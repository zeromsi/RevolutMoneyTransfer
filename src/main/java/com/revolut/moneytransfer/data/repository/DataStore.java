package com.revolut.moneytransfer.data.repository;

import java.util.concurrent.CopyOnWriteArrayList;

import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.Transfer;

public class DataStore {

	public static CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();
	public static CopyOnWriteArrayList<Transfer> transfers = new CopyOnWriteArrayList<>();
	public static CopyOnWriteArrayList<Branch> branches = new CopyOnWriteArrayList<>();

	public static void init() {
		accounts.add(new Account("00123", 500.00, "Shahidul", 808767506000L, "user_001", "user_002"));
		accounts.add(new Account("00124", 1000.00, "Munem", 808767506000L, "user_001", "user_002"));

		branches.add(new Branch("001", "Dhaka"));
		branches.add(new Branch("002", "London"));

		transfers.add(new Transfer(accounts.get(0), accounts.get(1), 50.00, branches.get(0)));
		transfers.add(new Transfer(accounts.get(1), accounts.get(0), 50.00, branches.get(1)));
		
	}

}
