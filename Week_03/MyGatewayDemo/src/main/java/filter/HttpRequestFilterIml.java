package filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestFilterIml extends ChannelInboundHandlerAdapter implements HttpRequestFilter {
    public void filter(FullHttpRequest fullHttpRequest, ChannelHandlerContext handlerContext) {
        fullHttpRequest.headers().set("nio","lyq");
    }
}
