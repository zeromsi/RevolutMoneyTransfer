package com.revolut.moneytransfer.data;

import java.util.Date;
import java.util.UUID;

public class Transfer {
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
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", accountTo=" + accountTo + ", accountFrom=" + accountFrom + ", amount=" + amount
				+ ", branch=" + branch + ", transferTime=" + transferTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountFrom == null) ? 0 : accountFrom.hashCode());
		result = prime * result + ((accountTo == null) ? 0 : accountTo.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((transferTime == null) ? 0 : transferTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (accountFrom == null) {
			if (other.accountFrom != null)
				return false;
		} else if (!accountFrom.equals(other.accountFrom))
			return false;
		if (accountTo == null) {
			if (other.accountTo != null)
				return false;
		} else if (!accountTo.equals(other.accountTo))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (transferTime == null) {
			if (other.transferTime != null)
				return false;
		} else if (!transferTime.equals(other.transferTime))
			return false;
		return true;
	}

	
}
