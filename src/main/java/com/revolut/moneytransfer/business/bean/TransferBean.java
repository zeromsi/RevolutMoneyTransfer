package com.revolut.moneytransfer.business.bean;

import javax.ejb.Stateless;

import com.revolut.moneytransfer.business.TransferVM;


@Stateless
public interface TransferBean {

	void transfer(TransferVM transfer) throws Exception;

}
