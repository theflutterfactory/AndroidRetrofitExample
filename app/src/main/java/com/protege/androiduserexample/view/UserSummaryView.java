package com.protege.androiduserexample.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.protege.androiduserexample.model.User;

import butterknife.ButterKnife;

public class UserSummaryView extends CardView {
    public UserSummaryView(Context context) {
        super(context);
    }

    public UserSummaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setUserSummary(User user) {

    }
}
