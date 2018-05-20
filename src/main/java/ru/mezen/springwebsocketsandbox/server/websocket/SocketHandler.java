package ru.mezen.springwebsocketsandbox.server.websocket;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.mezen.springwebsocketsandbox.server.request.MessageRequest;
import ru.mezen.springwebsocketsandbox.server.request.NameRequest;
import ru.mezen.springwebsocketsandbox.server.response.MessageResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private Gson gson = new Gson();
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        if (sessions.contains(session)) {
            MessageRequest messageRequest = gson.fromJson(message.getPayload(), MessageRequest.class);
            sendMessageInAllSession(messageRequest.getName(), messageRequest.getMessage());
        } else {
            NameRequest nameRequest = gson.fromJson(message.getPayload(), NameRequest.class);
            sendMessageInSession(session, "Server", "Вы подключились к чату!");
            sendMessageInAllSession("Server", "Подключился пользователь с именем " + nameRequest.getName());
            sessions.add(session);
        }
    }

    private void sendMessageInAllSession(String name, String message) throws IOException {
        MessageResponse messageResponse = new MessageResponse(name, message, new Date());
        String messageJson = gson.toJson(messageResponse);
        for(WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(new TextMessage(messageJson));
        }
    }

    private void sendMessageInSession(WebSocketSession session, String name, String message) throws IOException {
        MessageResponse messageResponse = new MessageResponse(name, message, new Date());
        String messageJson = gson.toJson(messageResponse);
        session.sendMessage(new TextMessage(messageJson));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sendMessageInSession(session, "Server", "Введите имя!");
    }

}
