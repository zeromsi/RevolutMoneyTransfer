package com.revolut.moneytransfer.business;

public class TransferVM{
	private String accountTo;
	private String accountFrom;
	private Double amount;
	private String branch;
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public TransferVM(String accountTo, String accountFrom, Double amount, String branch) {
		super();
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.amount = amount;
		this.branch = branch;
	}
	
	
	public TransferVM() {
		super();
	}
	@Override
	public String toString() {
		return "TransferVM [accountTo=" + accountTo + ", accountFrom=" + accountFrom + ", amount=" + amount
				+ ", branch=" + branch + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountFrom == null) ? 0 : accountFrom.hashCode());
		result = prime * result + ((accountTo == null) ? 0 : accountTo.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
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
		TransferVM other = (TransferVM) obj;
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
		return true;
	}
	
	
}
