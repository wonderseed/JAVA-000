package outbound.myHttpClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpOutboundHandler {

    private CloseableHttpClient httpClient;
    private String backendUrl;

    public HttpOutboundHandler(String backendUrl) {
        this.backendUrl = backendUrl.endsWith("/")?backendUrl.substring(0,backendUrl.length()-1):backendUrl;
        httpClient = HttpClientBuilder.create().build();
    }

    public void handle(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx) throws IOException {

        final  String url = this.backendUrl+fullHttpRequest.uri();

        HttpGet httpGet = new HttpGet();
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000).build();

            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("相应状态为：" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应长度为：" + responseEntity.getContentLength());
                System.out.println("相应内容为：" + EntityUtils.toString(responseEntity));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

//    private void fetchGet(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx, String url) {
//        final HttpGet httpGet = new HttpGet(url);
//
//    }


    //    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//    HttpGet httpGet = new HttpGet("http://localhost:8801");
//    CloseableHttpResponse response = null;
//        try{
//        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
//                .setConnectionRequestTimeout(5000).build();
//
//        httpGet.setConfig(requestConfig);
//        response = httpClient.execute(httpGet);
//        HttpEntity responseEntity = response.getEntity();
//        System.out.println("相应状态为："+response.getStatusLine());
//        if(responseEntity!=null){
//            System.out.println("响应长度为："+responseEntity.getContentLength());
//            System.out.println("相应内容为："+ EntityUtils.toString(responseEntity));
//        }
//    } catch (
//    IOException e) {
//        e.printStackTrace();
//    }

}
