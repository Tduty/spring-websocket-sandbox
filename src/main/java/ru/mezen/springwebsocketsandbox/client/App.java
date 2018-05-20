package ru.mezen.springwebsocketsandbox.client;

import ru.mezen.springwebsocketsandbox.client.websocket.DefaultMessageHandler;
import ru.mezen.springwebsocketsandbox.client.websocket.WebSocketConnector;

import java.net.URI;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) {
        try {
            new Client(new URI("ws://localhost:8080/chat")).run();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
