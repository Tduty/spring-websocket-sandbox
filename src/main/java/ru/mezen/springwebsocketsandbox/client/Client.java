package ru.mezen.springwebsocketsandbox.client;

import com.google.gson.Gson;
import ru.mezen.springwebsocketsandbox.client.request.MessageRequest;
import ru.mezen.springwebsocketsandbox.client.request.NameRequest;
import ru.mezen.springwebsocketsandbox.client.websocket.DefaultMessageHandler;
import ru.mezen.springwebsocketsandbox.client.websocket.WebSocketConnector;

import java.net.URI;
import java.util.Scanner;

public class Client {

    private String name;
    private WebSocketConnector webSocketConnector;
    private Gson gson;

    public Client(URI uri) {
        webSocketConnector = new WebSocketConnector(uri, new DefaultMessageHandler());
        gson = new Gson();
    }

    public void run() {
        webSocketConnector.connect();
        Scanner scanner = new Scanner(System.in);
        sendName(scanner);
        while (true) {
            String line = scanner.nextLine();
            MessageRequest messageRequest = new MessageRequest(name, line);
            String message = gson.toJson(messageRequest);
            webSocketConnector.sendMessage(message);
        }
    }

    private void sendName(Scanner scanner) {
        String name = scanner.nextLine();
        NameRequest nameRequest = new NameRequest(name);
        String message = gson.toJson(nameRequest);
        webSocketConnector.sendMessage(message);
        this.name = name;
    }

}
