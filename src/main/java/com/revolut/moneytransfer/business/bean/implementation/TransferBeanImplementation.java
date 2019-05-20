package com.revolut.moneytransfer.business.bean.implementation;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
import com.revolut.moneytransfer.common.ExceptionMessage;
import com.revolut.moneytransfer.data.Account;
import com.revolut.moneytransfer.data.Branch;
import com.revolut.moneytransfer.data.repository.AccountRepository;
import com.revolut.moneytransfer.data.repository.BranchRepository;
import com.revolut.moneytransfer.data.repository.TransferRepository;

@Stateless
public class TransferBeanImplementation implements TransferBean {

	TransferRepository transferRepository;
	AccountRepository accountRepository;
	BranchRepository branchRepository;

	@Inject
	public TransferBeanImplementation() {
		super();
		this.transferRepository = new TransferRepository();
		this.accountRepository = new AccountRepository();
		this.branchRepository = new BranchRepository();
	}

	@Override
	public void transfer(TransferVM transfer) throws Exception {
		Account accountFrom = accountRepository.findById(transfer.getAccountFrom());
		Account accountTo = accountRepository.findById(transfer.getAccountTo());
		Branch branch = branchRepository.findById(transfer.getBranch());
		if (accountFrom != null && accountTo != null) {
			if (branch != null) {
					synchronized (this) {
						accountRepository.deductAmount(accountFrom.getId(), transfer.getAmount());
						accountRepository.addAmount(accountTo.getId(), transfer.getAmount());
						transferRepository.transfer(accountTo, accountFrom, transfer.getAmount(), branch);
						return;
					}
				}

			throw new Exception(ExceptionMessage.INVALID_BRANCH_EXCEPTION.getValue());
		}
		throw new Exception(ExceptionMessage.INVALID_ACCOUNT_EXCEPTION.getValue());

	}

}
