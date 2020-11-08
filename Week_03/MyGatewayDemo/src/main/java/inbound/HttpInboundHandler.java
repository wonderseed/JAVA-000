package inbound;

import filter.HttpRequestFilter;
import filter.HttpRequestFilterIml;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import outbound.myHttpClient.HttpOutboundHandler;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private final String proxyServer;
    private HttpRequestFilter httpRequestFilter;
    private HttpOutboundHandler handler;

    public HttpInboundHandler(String proxyServer) {
        this.proxyServer = proxyServer;

        handler = new HttpOutboundHandler(this.proxyServer);
        httpRequestFilter = new HttpRequestFilterIml();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;

            if(httpRequestFilter != null){
                httpRequestFilter.filter(fullHttpRequest,ctx);
            }
            handler.handle(fullHttpRequest,ctx);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ReferenceCountUtil.release(msg);
        }

    }
}
