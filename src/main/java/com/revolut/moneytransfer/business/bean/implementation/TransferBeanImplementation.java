package com.revolut.moneytransfer.business.bean.implementation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
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
	public boolean transfer(TransferVM transfer) throws Exception {
		Account accountFrom=new Account();
		Account accountTo=new Account();
		Branch branch=new Branch();
		accountFrom=accountRepository.findById(transfer.getAccountFrom());
		accountTo=accountRepository.findById(transfer.getAccountTo());
		branch=branchRepository.findById(transfer.getBranch());
		
		if(accountFrom!=null && accountTo!=null) {
			if(branch!=null) {

				if(accountFrom.checkBalance(transfer.getAmount())) {
					synchronized (this) {
						if(accountRepository.deductAmount(accountFrom.getId(),transfer.getAmount())) {
							if(accountRepository.addAmount(accountTo.getId(),transfer.getAmount())) {
								transferRepository.transfer(accountTo,accountFrom,transfer.getAmount(),branch);
								return true;
							}else {
									
								throw new Exception("Please Try Again!");
							}
						}
					}
				}

				throw new Exception("Insuficient Amount!");
			}

			throw new Exception("There's no such branch!");
			
		}

		throw new Exception("Please Insert Valid Account Id!");

	}

}
