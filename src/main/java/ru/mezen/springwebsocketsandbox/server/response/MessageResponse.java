package ru.mezen.springwebsocketsandbox.server.response;

import java.util.Date;

public class MessageResponse {

    private String name;
    private String message;
    private Date date;

    public MessageResponse() {

    }

    public MessageResponse(String name, String message, Date date) {
        this.name = name;
        this.message = message;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
