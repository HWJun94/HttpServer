package com.hwj.server;

import io.netty.handler.codec.http.HttpResponseStatus;

public class ServerException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private HttpResponseStatus status;
    private String content;


    //constructor
    public ServerException(HttpResponseStatus status) {
        this(status, null, null);
    }

    public ServerException(HttpResponseStatus status, String content) {
        this(status, content, null);
    }

    public ServerException(HttpResponseStatus status, String content, Throwable t) {
        super(content == null ? status.reasonPhrase() : content, t);
        this.status = status;
        this.content = content == null ? status.reasonPhrase() : content;
    }

    public HttpResponseStatus getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
