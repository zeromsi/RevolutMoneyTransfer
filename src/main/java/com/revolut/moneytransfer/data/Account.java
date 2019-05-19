package com.revolut.moneytransfer.data;

import java.io.Serializable;
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

	public Account(String id, Double balance, String ownersName, Long dob, Long createdAt, String createdBy,
			Long lastUpdatedAt, String lastUpdatedBy) {
		super();
		this.id = id;
		this.balance = balance;
		this.ownersName = ownersName;
		this.dob = dob;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.lastUpdatedAt = lastUpdatedAt;
		this.lastUpdatedBy = lastUpdatedBy;
	}
	// TODO Auto-generated constructor stub
	

	
	
	public Account(String id) {
		super();
		this.id = id;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public boolean checkBalance(Double amount) {
		if(this.getBalance()<amount) {
			return false;
		}else {
			return true;
		}
		
	}

}
