package com.hwj.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

public class HttpRequestDispatcher implements RequestDispatcher {
    private Router router;

    public HttpRequestDispatcher(Router router) {
        this.router = router;
    }

    @Override
    public void dispatch(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        HttpMethod requestMethod = request.method();
        if (requestMethod == HttpMethod.GET || requestMethod == HttpMethod.POST) {
            if (router == null)
                throw new Exception("There should be a Router and not null!");
            router.handle(ctx, request);
        } else {
            send405Response(ctx, request);
        }

    }

    private void send405Response(ChannelHandlerContext ctx, FullHttpRequest request) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.METHOD_NOT_ALLOWED);
        ChannelFuture future = ctx.writeAndFlush(response);
        future.addListener(ChannelFutureListener.CLOSE);
    }
}
