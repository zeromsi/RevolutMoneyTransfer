package com.revolut.test.unit.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.common.ExceptionType;
import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.repository.AccountRepository;
import com.revolut.moneytransfer.data.repository.DataStore;

public class AccountRepositoryTest {
	
	AccountRepository accountRepository;
	
	
	public AccountRepositoryTest() {
		super();
		this.accountRepository = new AccountRepository();
	}

	@Before
	public void setUp() {
		DataStore.accounts.add(new Account("00123", 500.00, "Shahidul", 808767506000L, "user_001", "user_002"));
	}

	@Test
	public void givenValidAccountId_whenCallingFindByIdIfReturnsAccount_thenTrue() {
		Account account=accountRepository.findById("00123");
		assertEquals("fail: Should return true", "00123",account.getId());
	}
	
	@Test
	public void givenInvalidAccountId_whenCallingFindByIdIfReturnsNull_thenTrue() {
		Account account=accountRepository.findById("0013");
		assertEquals("fail: Should return true", null,account);
	}
	
	@Test
	public void givenValueSmallerThanAccountBalance_whenCallingDeductAmountIfThrowsNoException_thenTrue() throws Exception {
		Double amount=accountRepository.findById("00123").getBalance()-80.00;
		accountRepository.deductAmount("00123",80.00);
		assertEquals("fail: Should return true",amount,accountRepository.findById("00123").getBalance());
	}
	
	
	@Test
	public void givenValueGreaterThanAccountBalance_whenCallingDeductAmountIfThrowsException_thenTrue() throws Exception {
		try {
			accountRepository.deductAmount("00123",800.00);
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue(),e.getMessage());
		}
	}
	
	@Test
	public void givenAmount_whenCallingAddMountIfAmountGotAdded_thenTrue() {
		Double expectedValue=accountRepository.findById("00123").getBalance()+500;
		accountRepository.addAmount("00123",500.00);
		assertEquals("fail: Should return true",expectedValue,accountRepository.findById("00123").getBalance());
		
	}

}

