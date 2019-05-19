package com.revolut.moneytransfer.business.service.implementation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;
import com.revolut.moneytransfer.business.service.TransferService;
import com.revolut.moneytransfer.data.repository.DataStore;


@Path("transfers")
@Stateless
public class TransferServiceImplementation implements TransferService{

	TransferBean transferBean;
	
	@Inject
	public TransferServiceImplementation() {
		this.transferBean = new TransferBeanImplementation();
	}

    @Override
	public Response create(final TransferVM transfer) throws Exception {
		transferBean.transfer(transfer);
		return null;
    }
		
}
