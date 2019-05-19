package com.revolut.moneytransfer.data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Transfer implements Serializable{
	private String id;
	private Account accountTo;
	private Account accountFrom;
	private Double amount;
	private Branch branch;
	private Long transferTime;
	
	public Account getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}
	public Account getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}
	public Transfer(Account accountTo, Account accountFrom, Double amount, Branch branch) {
		super();
		this.id = UUID.randomUUID().toString();
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.amount = amount;
		this.branch = branch;
		this.transferTime = new Date().getTime();
	}

	
}
