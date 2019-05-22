package com.revolut.moneytransfer.data;

import java.util.Date;

import com.revolut.moneytransfer.common.ExceptionType;

public class Account{
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

	 public void deductAmount(Double amount) throws Exception {
		if (checkBalanceAvailability(amount)) {
			this.setBalance(this.getBalance() - amount);
			return;
		} else {
			throw new Exception(ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue());
		}
	}

	 public void addAmount(Double amount) {
		this.setBalance(this.getBalance() + amount);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", ownersName=" + ownersName + ", dob=" + dob
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", lastUpdatedAt=" + lastUpdatedAt
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdatedAt == null) ? 0 : lastUpdatedAt.hashCode());
		result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result + ((ownersName == null) ? 0 : ownersName.hashCode());
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
		Account other = (Account) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdatedAt == null) {
			if (other.lastUpdatedAt != null)
				return false;
		} else if (!lastUpdatedAt.equals(other.lastUpdatedAt))
			return false;
		if (lastUpdatedBy == null) {
			if (other.lastUpdatedBy != null)
				return false;
		} else if (!lastUpdatedBy.equals(other.lastUpdatedBy))
			return false;
		if (ownersName == null) {
			if (other.ownersName != null)
				return false;
		} else if (!ownersName.equals(other.ownersName))
			return false;
		return true;
	}

}
