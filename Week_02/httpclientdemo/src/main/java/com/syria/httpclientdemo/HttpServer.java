package com.syria.httpclientdemo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServer {
    @RequestMapping("/doGetControllerOne")
    public String doGetControllerOne(){
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123";
    }
}
