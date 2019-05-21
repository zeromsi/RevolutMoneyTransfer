package com.revolut.moneytransfer.data;

import java.io.Serializable;
import java.util.Date;

import com.revolut.moneytransfer.common.ExceptionType;

public class Account implements Serializable {
	private String id;
	private Double balance;
	private String ownersName;
	private Long dob;
	private Long createdAt;
	private String createdBy;
	private Long lastUpdatedAt;
	private String lastUpdatedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getOwnersName() {
		return ownersName;
	}

	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}

	public Long getDob() {
		return dob;
	}

	public void setDob(Long dob) {
		this.dob = dob;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Long lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Account(String id, Double balance, String ownersName, Long dob, String createdBy, String lastUpdatedBy) {
		super();
		this.id = id;
		this.balance = balance;
		this.ownersName = ownersName;
		this.dob = dob;
		this.createdAt = new Date().getTime();
		this.createdBy = createdBy;
		this.lastUpdatedAt = new Date().getTime();
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public boolean checkBalanceAvailability(Double amount) {
		if (this.getBalance() < amount) {
			return false;
		} else {
			return true;
		}

	}

	synchronized public void deductAmount(Double amount) throws Exception {
		if (checkBalanceAvailability(amount)) {
			this.setBalance(this.getBalance() - amount);
			return;
		} else {
			throw new Exception(ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue());
		}
	}

	synchronized public void addAmount(Double amount) {
		this.setBalance(this.getBalance() + amount);
	}

}
