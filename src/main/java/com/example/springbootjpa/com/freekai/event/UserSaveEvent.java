package com.example.springbootjpa.com.freekai.event;

public class UserSaveEvent {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public UserSaveEvent setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserSaveEvent(String userId) {
        this.userId = userId;
    }
}
