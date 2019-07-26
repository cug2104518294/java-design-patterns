package com.iluwatar.chain;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RequestHandler
 */
public abstract class RequestHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

    private RequestHandler next;

    public RequestHandler() {
        LOGGER.info("RequestHandler无参构造函数");
    }

    public RequestHandler(RequestHandler next) {
        LOGGER.info("RequestHandler构造函数");
        this.next = next;
    }

    /**
     * Request handler
     */
    public void handleRequest(Request req) {
        String content = JSONObject.toJSONString(req);
        System.out.println("handleRequest: " + content);
        System.out.println("next: " + next);
        if (next != null) {
            next.handleRequest(req);
        } else {
            System.out.println("当前没有handler能处理请求");
        }
    }

    protected void printHandling(Request req) {
        LOGGER.info("{} handling request \"{}\"", this, req);
    }

    @Override
    public abstract String toString();
}
