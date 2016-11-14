package com.protege.androiduserexample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailView extends LinearLayout {
    @BindView(R.id.username)
    TextView userName;

    @BindView(R.id.website)
    TextView webSite;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.phone_number)
    TextView phoneNumber;

    @BindView(R.id.street)
    TextView street;

    @BindView(R.id.suite)
    TextView suite;

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.zip_code)
    TextView zipCode;

    public UserDetailView(Context context) {
        super(context);
    }

    public UserDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setUserDetails(User user){

    }
}
