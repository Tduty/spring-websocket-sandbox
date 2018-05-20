package ru.mezen.springwebsocketsandbox.client.request;

import java.util.Date;

public class MessageRequest {

    private String name;
    private String message;

    public MessageRequest() {

    }

    public MessageRequest(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
