package com.protege.androiduserexample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Slide;
import android.view.Gravity;

import com.protege.androiduserexample.model.User;
import com.protege.androiduserexample.view.UserDetailView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.OnClick;

public class UserDetailActivity extends BaseActivity {

    @BindView(R.id.user_detail_view)
    UserDetailView userDetailView;

    public static final String USER_ID_EXTRA = "user_id";

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        user = Parcels.unwrap(getIntent().getParcelableExtra(MainActivity.USER_EXTRA));
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.LEFT);
            slide.setDuration(300);
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }

        if(user != null) {
            userDetailView.setUserDetails(user);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_user_details;
    }

    @Override
    public String getToolbarTitle() {
        return user == null ? getString(R.string.unknown_user) : user.getName();
    }

    @OnClick(R.id.view_posts)
    public void viewPosts() {
        if(user != null) {
            Intent intent = new Intent(this, UserPostsActivity.class);
            intent.putExtra(USER_ID_EXTRA, user.getId());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                startActivity(intent, oc2.toBundle());
            } else {
                startActivity(intent);
            }
        }
    }
}
