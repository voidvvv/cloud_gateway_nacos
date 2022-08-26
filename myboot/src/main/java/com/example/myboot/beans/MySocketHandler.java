package com.example.myboot.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname MySocketHandler
 * @Description
 * @Date 2022/8/23 19:45
 * @Created by voidvvv
 */
@Component
public class MySocketHandler extends AbstractWebSocketHandler {
    private static List<WebSocketSession> sessions;

    static {
        sessions = new ArrayList<>();
    }

    public MySocketHandler() {
        super();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished");
        sessions.add(session);

        Map<String, Object> attributes = session.getAttributes();
        HttpHeaders handshakeHeaders = session.getHandshakeHeaders();
        System.out.println(handshakeHeaders);
        List<String> cookie = handshakeHeaders.get("cookie");
        System.out.println(cookie);
        System.out.println(attributes);
        System.out.println(session.getUri());
        session.close();;

        ArrayList<Integer> list = new ArrayList<>();
//        list.toArray(new int[10]);

        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("handleMessage");

        super.handleMessage(session, message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("handleTextMessage");
//        session.sendMessage(new TextMessage("nihao"));

        for(WebSocketSession se:sessions){
            if (se.isOpen()){
                se.sendMessage(message);
            }else {
                se.close();
                sessions.remove(se);
            }
        }
        super.handleTextMessage(session, message);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        System.out.println("handleBinaryMessage");
        session.sendMessage(new PongMessage(ByteBuffer.allocate(10)));
        super.handleBinaryMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        System.out.println("handlePongMessage");
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("handleTransportError");
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("afterConnectionClosed");
        super.afterConnectionClosed(session, status);
//        session.close();
        sessions.remove(session);


        for(WebSocketSession se:sessions){
            se.sendMessage(new TextMessage(""));
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }
}
