package com.hwj.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private static final Logger logger = LoggerFactory.getLogger(Router.class);
    private static Map<String, RequestHandler> handlers = new HashMap<>();
    private ExceptionHandler exceptionHandler;

    //constructor
    public Router() {
        this.exceptionHandler = new DefaultExceptionHandler();
    }

    public Router(ExceptionHandler eHandler) {
        this.exceptionHandler = eHandler;
    }

    public Router handler(String path, RequestHandler rh) {
        if (!handlers.containsKey(path))
            handlers.put(path, rh);
        return this;
    }

    public void handle(ChannelHandlerContext ctx, FullHttpRequest request) {
        String path = HttpUtils.getPathFromURI(request.uri());
        if (handlers.containsKey(path)) {
            RequestHandler handler = handlers.get(path);
            handler.handle(ctx, request);
        } else {
            //handle exception
            ServerException e = new ServerException(HttpResponseStatus.NOT_FOUND, "Querypath has no Requesthandler!");
            exceptionHandler.handle(ctx, e);
            logger.warn("Warn:", e);
        }
    }
}
