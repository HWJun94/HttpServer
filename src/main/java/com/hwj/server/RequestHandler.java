package com.hwj.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface RequestHandler {

    public void handle(ChannelHandlerContext ctx, FullHttpRequest request);
}
