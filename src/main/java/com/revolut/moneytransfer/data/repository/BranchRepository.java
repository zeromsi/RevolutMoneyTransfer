package com.revolut.moneytransfer.data.repository;

import com.revolut.moneytransfer.data.Branch;

public class BranchRepository {
	public Branch findById(String id) {
		return DataStore.findBranchById(id);
	}

}
