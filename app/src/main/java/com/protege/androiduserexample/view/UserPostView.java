package com.protege.androiduserexample.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.Post;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserPostView extends CardView {
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.body)
    TextView body;

    public UserPostView(Context context) {
        super(context);
    }

    public UserPostView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setUserPost(Post post) {
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}
