package com.revolut.test.unit.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.repository.BranchRepository;
import com.revolut.moneytransfer.data.repository.DataStore;

public class BranchRepositoryTest {
	BranchRepository branchRepository;

	public BranchRepositoryTest() {
		this.branchRepository = new BranchRepository();
	}

	@Before
	public void setUp() {
		DataStore.branches.add(new Branch("101", "Dhaka"));
	}

	@Test
	public void givenValidBranchId_whenCallingFindByIdIfReturnsBranch_thenTrue() {
		Branch branch = branchRepository.findById("101");
		assertEquals("fail: Should return true", "101", branch.getId());
	}

	
	@Test
	public void givenInvalidBranchId_whenCallingFindByIdIfReturnsNull_thenTrue() {
		Branch branch = branchRepository.findById("123");
		assertEquals("fail: Should return true",null, branch);
	}

}
