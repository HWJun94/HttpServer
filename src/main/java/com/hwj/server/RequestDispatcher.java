package com.hwj.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface RequestDispatcher {

    public void dispatch(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception;
}
