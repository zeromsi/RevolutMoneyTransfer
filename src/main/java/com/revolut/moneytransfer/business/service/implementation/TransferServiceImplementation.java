package com.revolut.moneytransfer.business.service.implementation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;
import com.revolut.moneytransfer.business.service.TransferService;
import com.revolut.moneytransfer.common.ExceptionMessage;


@Path("transfers")
@Stateless
public class TransferServiceImplementation implements TransferService{

	TransferBean transferBean;
	
	@Inject
	public TransferServiceImplementation() {
		this.transferBean = new TransferBeanImplementation();
	}

    @Override
	public Response create(final TransferVM transfer) {
    	try {
    	transferBean.transfer(transfer);
    	 return Response.status(Status.ACCEPTED).build();
    	}catch(Exception e) {
    		if(e.getMessage().equals(ExceptionMessage.INSUFFICIENT_AMOUNT_EXCEPTION.getValue())) {
    			return	Response.status(Status.NOT_ACCEPTABLE).entity(ExceptionMessage.INSUFFICIENT_AMOUNT_EXCEPTION.getValue()).build();
    		}else if(e.getMessage().equals(ExceptionMessage.INVALID_ACCOUNT_EXCEPTION.getValue())) {
    			return Response.status(Status.BAD_GATEWAY).entity(ExceptionMessage.INVALID_ACCOUNT_EXCEPTION.getValue()).build();
    		}else if(e.getMessage().equals(ExceptionMessage.INVALID_BRANCH_EXCEPTION.getValue())) {
    			return Response.status(Status.BAD_REQUEST).entity(ExceptionMessage.INVALID_BRANCH_EXCEPTION.getValue()).build();
    		}else {
    			return Response.status(Status.BAD_REQUEST).build();
    		}
    		
    	}
    }
		
}
