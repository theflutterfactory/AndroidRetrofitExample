package com.protege.androiduserexample;

import android.content.Intent;
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

    public static final String USER_ID_EXTRA = "user_id";

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        user = Parcels.unwrap(getIntent().getParcelableExtra(MainActivity.USER_EXTRA));

        if(user != null) {
            userDetailView.setUserDetails(user);

            toolbar.setTitle(user.getName());
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {

        }
    }

    @OnClick(R.id.view_posts)
    public void viewPosts() {
        if(user != null) {
            Intent intent = new Intent(this, UserPostsActivity.class);
            intent.putExtra(USER_ID_EXTRA, user.getId());
            startActivity(intent);
        }
    }
}
