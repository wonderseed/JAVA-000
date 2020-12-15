package com.syria.rpcfx.client;

import com.alibaba.fastjson.JSON;
import com.syria.rpcfx.api.RpcfxRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class CreateAspectJ {
    @Pointcut("excution(* com.syria.rpcfx.client.create(..))")
    public void point(){};

   @Around("point()")
    public Object xx(ProceedingJoinPoint pj, Method method){
       RpcfxRequest request = new RpcfxRequest();
       request.setServiceClass(this.serviceClass.getName());
       request.setMethod(method.getName());
       request.setParams(params);

       RpcfxResponse response = post(request, url);

       // 这里判断response.status，处理异常
       // 考虑封装一个全局的RpcfxException

       return JSON.parse(response.getResult().toString());
   }

}
