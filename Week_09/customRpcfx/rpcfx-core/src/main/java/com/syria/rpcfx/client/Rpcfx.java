package com.syria.rpcfx.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class Rpcfx {
    static {
        ParserConfig.getGlobalInstance().addAccept("com.syria");
    }



    public static <T> T create(final Class<T> serviceClass,final String url){

        return
    }





}
