package com.revolut.moneytransfer.business.bean;

import java.util.concurrent.ExecutionException;
import javax.ejb.Stateless;
import com.revolut.moneytransfer.business.TransferVM;


@Stateless
public interface TransferBean {

	boolean transfer(TransferVM transfer) throws Exception;

}
