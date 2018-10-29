package com.hwj;

import com.hwj.handler.NBIotHandlerDemo;
import com.hwj.server.HttpRequestDispatcher;
import com.hwj.server.Router;
import com.hwj.server.core.HttpServer;

public class NBIotServer {

    public static void main(String[] args) throws Exception {
        Router router = new Router();
        router.handler("/", new NBIotHandlerDemo())
                .handler("/home", new NBIotHandlerDemo());

        HttpRequestDispatcher rd = new HttpRequestDispatcher(router);
        HttpServer server = new HttpServer(rd);
        server.start();
    }
}
