package com.revolut.moneytransfer.common;

public enum ExceptionType {

	INSUFFICIENT_AMOUNT_EXCEPTION("Insufficient Amount"),
	INVALID_BRANCH_EXCEPTION("Please Insert Valid Branch!"),
	INVALID_ACCOUNT_EXCEPTION("Please Insert Valid Account Id!");

	private String value;

	private ExceptionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
