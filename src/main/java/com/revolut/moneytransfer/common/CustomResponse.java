package com.revolut.moneytransfer.common;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CustomResponse {
	public static Response create(String message, Boolean requestStatus) {
		return Response.ok(message, MediaType.APPLICATION_JSON).header("AUTHORIZATION", "").header("MESSAGE", message)
				.header("REQEUSTSTATUS", requestStatus).header("FUNCTIONID", "").build();
	}

}