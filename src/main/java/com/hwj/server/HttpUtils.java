package com.hwj.server;

import io.netty.handler.codec.http.QueryStringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String getPathFromURI(String uri) {
        QueryStringDecoder decoder = new QueryStringDecoder(uri);
        String path = decoder.path();
        logger.debug("QueryPath: {}", path);
        return path;
    }
}
