package com.protege.androiduserexample.event;

import com.protege.androiduserexample.model.User;

public class UserSummaryEvent {

    private User user;

    public UserSummaryEvent(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
