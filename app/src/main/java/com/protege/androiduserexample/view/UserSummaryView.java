package com.protege.androiduserexample.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.event.UserSummaryEvent;
import com.protege.androiduserexample.model.User;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserSummaryView extends CardView {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.username)
    TextView userName;

    @BindView(R.id.company)
    TextView company;

    @BindView(R.id.profile_photo)
    ImageView profilePhoto;

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

    public void setUserSummary(final User user) {
        name.setText(user.getName());
        userName.setText(String.format(getContext().getString(R.string.username),
                user.getUsername()));
        company.setText(String.format(getContext().getString(R.string.company),
                user.getCompany().getName()));

        Picasso.with(getContext())
                .load(getContext().getString(R.string.test_url))
                .placeholder(ContextCompat.getDrawable(getContext(),R.drawable.profile_placeholder))
                .into(profilePhoto);

        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new UserSummaryEvent(user));
            }
        });
    }
}
