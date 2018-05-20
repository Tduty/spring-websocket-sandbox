package ru.mezen.springwebsocketsandbox.client.websocket;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mezen.springwebsocketsandbox.client.Client;
import ru.mezen.springwebsocketsandbox.client.response.MessageResponse;

public class DefaultMessageHandler implements MessageHandler {

    private Gson gson;

    public DefaultMessageHandler() {
        gson = new Gson();
    }

    @Override
    public void handle(String message) {
        MessageResponse messageResponse = gson.fromJson(message, MessageResponse.class);
        System.out.println(
                messageResponse.getDate() + " --- "
                + messageResponse.getName() + ": "
                + messageResponse.getMessage()
        );
    }

}
