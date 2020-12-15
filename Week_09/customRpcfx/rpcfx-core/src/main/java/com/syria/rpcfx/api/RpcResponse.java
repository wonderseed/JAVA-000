package com.syria.rpcfx.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RpcResponse {
    private Object result;

    private boolean status;

    private Exception exception;

}
