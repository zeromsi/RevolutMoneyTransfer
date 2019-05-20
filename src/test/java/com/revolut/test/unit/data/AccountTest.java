package com.revolut.test.unit.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.common.ExceptionMessage;
import com.revolut.moneytransfer.data.Account;

public class AccountTest {
	Account account;

	@Before
	public void setUp() {
		account=new Account("1", 300.00, "Hasan", new Date().getTime(), "user_001", "user_001");
	}
	
	@Test
	public void givenValueGreaterThanAccountBalance_whenCallingCheckBalanceAvailabilityIfReturnsFalse_thenFalse(){
		assertEquals("fail: Should return false", false,account.checkBalanceAvailability(400.00));

	}
	
	@Test
	public void givenValueSmallerThanAccountBalance_whenCallingCheckBalanceAvailabilityIfReturnsTrue_thenTrue(){
		assertEquals("fail: Should return true", true,account.checkBalanceAvailability(100.00));

	}
	@Test
	public void givenValueSmallerThanAccountBalance_whenCallingDeductAmountIfThrowsNoException_thenTrue() throws Exception {
		account.deductAmount(80.00);
		Double amount=220.00;
		assertEquals("fail: Should return true",amount,account.getBalance());
	}
	
	@Test
	public void givenValueGreaterThanAccountBalance_whenCallingDeductAmountIfThrowsException_thenTrue() {
		try {
			account.deductAmount(500.00);
		} catch (Exception e) {
			assertEquals("fail: Should return true",ExceptionMessage.INSUFFICIENT_AMOUNT_EXCEPTION.getValue(),e.getMessage());
		}

	}
}
