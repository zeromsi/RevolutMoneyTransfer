package com.revolut.moneytransfer.common;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CreateResponse {
    public static Response CreateResponse(String message, Boolean requestStatus){
        return Response
                        .ok(message, MediaType.WILDCARD_TYPE)
                        .header("AUTHORIZATION", "")
                        .header("MESSAGE", message)
                        .header("REQEUSTSTATUS", requestStatus)
                        .header("FUNCTIONID", "")
                        .build();
    }
  
}