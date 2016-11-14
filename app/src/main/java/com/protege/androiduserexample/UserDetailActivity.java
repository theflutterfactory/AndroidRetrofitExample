package com.protege.androiduserexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.protege.androiduserexample.model.User;
import com.protege.androiduserexample.view.UserDetailView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailActivity extends AppCompatActivity {

    @BindView(R.id.user_detail_view)
    UserDetailView userDetailView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        User user = Parcels.unwrap(getIntent().getParcelableExtra(MainActivity.USER_EXTRA));
        userDetailView.setUserDetails(user);

        toolbar.setTitle(user.getName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.view_posts)
    public void viewPosts() {

    }
}
