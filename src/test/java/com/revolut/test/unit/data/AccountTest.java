package com.revolut.test.unit.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.revolut.moneytransfer.common.ExceptionType;
import com.revolut.moneytransfer.data.Account;


public class AccountTest {
	Account account;

	@Before
	public void setUp() {
		account=new Account("1", 300.00, "Hasan", new Date().getTime(), "user_001", "user_001");
	}
	
	@Test
	public void givenValueGreaterThanAccountBalance_whenCallingCheckBalanceAvailabilityIfSuccessful_thenFalse(){
		assertEquals("fail: Should return false", false,account.checkBalanceAvailability(400.00));

	}
	
	@Test
	public void givenValueSmallerThanAccountBalance_whenCallingCheckBalanceAvailabilityIfSuccessful_thenTrue(){
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
			assertEquals("fail: Should return true",ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue(),e.getMessage());
		}

	}
	
	@Test
	public void givenAmount_whenCallingAddMountIfAmountGotAdded_thenTrue() {
		account.addAmount(500.00);
		Double currentAmount=800.00;
		assertEquals("fail: Should return true",currentAmount,account.getBalance());
		
	}
}
