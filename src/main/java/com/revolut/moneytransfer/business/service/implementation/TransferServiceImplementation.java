package com.revolut.moneytransfer.business.service.implementation;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.revolut.moneytransfer.business.TransferVM;
import com.revolut.moneytransfer.business.bean.TransferBean;
import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;
import com.revolut.moneytransfer.business.service.TransferService;
import com.revolut.moneytransfer.common.ExceptionType;
import com.revolut.moneytransfer.common.ServerResponse;

@Path("transfers")
@Stateless
public class TransferServiceImplementation implements TransferService {

	TransferBean transferBean;

	public TransferServiceImplementation() {
		this.transferBean = new TransferBeanImplementation();
	}

	@Override
	public Response create(final TransferVM transfer) {
		try {
			transferBean.transfer(transfer);
			return Response.status(Status.ACCEPTED).build();
		} catch (Exception e) {
			if (e.getMessage().equals(ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue())) {
				return ServerResponse.response(ExceptionType.INSUFFICIENT_AMOUNT_EXCEPTION.getValue(),
						Status.NOT_ACCEPTABLE, "/transfers");
			} else if (e.getMessage().equals(ExceptionType.INVALID_ACCOUNT_EXCEPTION.getValue())) {
				return ServerResponse.response(ExceptionType.INVALID_ACCOUNT_EXCEPTION.getValue(), Status.BAD_REQUEST,
						"/transfers");
			} else if (e.getMessage().equals(ExceptionType.INVALID_BRANCH_EXCEPTION.getValue())) {
				return ServerResponse.response(ExceptionType.INVALID_BRANCH_EXCEPTION.getValue(), Status.BAD_REQUEST,
						"/transfers");
			}
			return ServerResponse.response(e.getMessage(), Status.EXPECTATION_FAILED, "/transfers");

		}
	}

}
