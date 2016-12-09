package com.protege.androiduserexample.event;

import android.view.View;

import com.protege.androiduserexample.model.User;

public class UserSummaryEvent {

    private User user;

    private View transitionView;

    public UserSummaryEvent(User user, View transitionView){
        this.transitionView = transitionView;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public View getTransitionView() { return transitionView; }
}
