package com.example.helloworld.HelloWorld.model;

public class Message {
    public Message(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
