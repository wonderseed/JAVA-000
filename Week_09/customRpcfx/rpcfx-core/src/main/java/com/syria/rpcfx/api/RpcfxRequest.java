package com.syria.rpcfx.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RpcfxRequest {

    private String serviceClass;

    private String method;

    private Object[] params;
}