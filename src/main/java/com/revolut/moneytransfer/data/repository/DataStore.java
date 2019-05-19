package com.revolut.moneytransfer.data.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.Transfer;

public class DataStore {

	public static CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();
	public static List<Transfer> transfers = new ArrayList<>();
	public static List<Branch> branches = new ArrayList<>();

	public static void init() {
		accounts = (CopyOnWriteArrayList<Account>) Arrays.asList(
				new Account("00123", 500.00, "Shahidul", 808767506000L, new Date().getTime() - 100000L, "user_001",
						new Date().getTime(), "user_002"),
				new Account("00124", 1000.00, "Munem", 808767506000L, new Date().getTime() - 120000L, "user_001",
						new Date().getTime(), "user_002"));
		branches = Arrays.asList(new Branch("001", "Dhaka"), new Branch("002", "London"));
		transfers = Arrays.asList(new Transfer(accounts.get(0), accounts.get(1), 50.00, branches.get(0)),
				new Transfer(accounts.get(1), accounts.get(0), 50.00, branches.get(1)));
	}

	public static Account findAccountById(String id) {
		return accounts.stream().filter(account -> id.equals(account.getId())).findAny().orElse(null);
	}

	public static Branch findBranchById(String id) {
		return branches.stream().filter(branch -> id.equals(branch.getId())).findAny().orElse(null);
	}

}
