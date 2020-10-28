package com.syria.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HttpServer.class })
public class HttpClient {
    @Test
    public void doGetTestOne() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:12345/doGetControllerOne");
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000)
                    .setRedirectsEnabled(true)
                    .build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);

            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为：" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应长度为：" + responseEntity.getContentLength());
                System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
