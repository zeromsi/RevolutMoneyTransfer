package com.revolut.moneytransfer.data;

public class Branch {
	private String branchId;
	private String branchName;

	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Branch(String branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

}
