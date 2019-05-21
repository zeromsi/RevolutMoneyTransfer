package com.revolut.test.unit.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;
import com.revolut.moneytransfer.common.ExceptionType;
import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.repository.DataStore;

public class TransferBeanTest {
	TransferBean transferBean;
	public TransferBeanTest() {
	this.transferBean=new TransferBeanImplementation();
	}

	
	@Before
	public void setUp() {
		DataStore.accounts.add(new Account("00123", 500.00, "Shahidul", 808767506000L, "user_001", "user_002"));
		DataStore.accounts.add(new Account("00124", 1000.00, "Munem", 808767506000L, "user_001", "user_002"));
		DataStore.branches.add(new Branch("001", "Dhaka"));
	}
	
	@Test
	public void givenValueGreaterThanAccountBalance_whenCallingTransferIfThrowsINSUFFICIENT_AMOUNT_EXCEPTION_thenTrue() {
		try {
			transferBean.transfer(new TransferVM("00124", "00123", 550.00, "001"));
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue(),e.getMessage());
		}

	}
	

	@Test
	public void givenValueSmallerThanAccountBalanceButInvalidAccountToId_whenCallingTransferIfThrowsINVALID_ACCOUNT_EXCEPTION_thenTrue() {
		try {
			transferBean.transfer(new TransferVM("00125", "00123", 50.00, "001"));
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionType.INVALID_ACCOUNT_EXCEPTION.getValue(),e.getMessage());
		}

	}
	
	@Test
	public void givenValueSmallerThanAccountBalanceButInvalidAccountFromId_whenCallingTransferIfThrowsINVALID_ACCOUNT_EXCEPTION_thenTrue() {
		try {
			transferBean.transfer(new TransferVM("00124", "00125", 50.00, "001"));
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionType.INVALID_ACCOUNT_EXCEPTION.getValue(),e.getMessage());
		}

	}
	

	@Test
	public void givenValueSmallerThanAccountBalanceButInvalidBranchId_whenCallingTransferIfThrowsINVALID_BRANCH_EXCEPTION_thenTrue() {
		try {
			transferBean.transfer(new TransferVM("00124", "00123", 50.00, "002"));
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionType.INVALID_BRANCH_EXCEPTION.getValue(),e.getMessage());
		}

	}
	
	@Test
	public void givenValueSmallerThanAccountBalanceAndValidAccountToAndAccountFromIdAndValidBranchId_whenCallingTransferIfSeccessful_thenTrue() throws Exception {
		int previousSize=DataStore.transfers.size();
			transferBean.transfer(new TransferVM("00124", "00123", 50.00, "001"));
			int currentSize=DataStore.transfers.size();
			assertEquals("fail: Should return true",previousSize+1,currentSize);
	
	}
}
