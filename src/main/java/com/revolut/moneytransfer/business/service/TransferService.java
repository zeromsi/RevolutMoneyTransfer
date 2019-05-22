package com.revolut.moneytransfer.business.service;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revolut.moneytransfer.business.TransferVM;

@Stateless
public interface TransferService {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final TransferVM transfer) throws Exception;

}
