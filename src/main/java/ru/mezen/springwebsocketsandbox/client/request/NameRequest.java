package ru.mezen.springwebsocketsandbox.client.request;

public class NameRequest {

    public String name;

    public NameRequest() {

    }

    public NameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
