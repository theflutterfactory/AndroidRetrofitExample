package com.protege.androiduserexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.view_posts)
    public void viewPosts() {

    }
}
