package com.revolut.moneytransfer.common;

import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
public class ServerResponse {
	
	public static Response response(String message, Status status, String url) {
		HashMap<String, String> response = new HashMap<>();
		response.put("timestamp", new Date() + "");
		response.put("status", status.getStatusCode()+"");
		response.put("error",status.toString());
		response.put("message", message);
		response.put("path", url);
		return Response.status(status.getStatusCode()).entity(response).build();
	}
}