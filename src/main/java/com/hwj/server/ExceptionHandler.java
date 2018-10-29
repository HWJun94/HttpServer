package com.hwj.server;

import io.netty.channel.ChannelHandlerContext;

public interface ExceptionHandler {

    public void handle(ChannelHandlerContext ctx, ServerException e);

}
