package com.protege.androiduserexample.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.Address;
import com.protege.androiduserexample.model.User;
import com.squareup.picasso.Picasso;

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

    @BindView(R.id.profile_photo)
    ImageView profilePhoto;

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
        Picasso.with(getContext())
                .load("http://bit.ly/2f7pckl")
                .placeholder(ContextCompat.getDrawable(getContext(),R.drawable.profile_placeholder))
                .into(profilePhoto);

        Context context = getContext();
        userName.setText(String.format(context.getString(R.string.username), user.getUsername()));
        webSite.setText(String.format(context.getString(R.string.website), user.getWebsite()));
        email.setText(String.format(context.getString(R.string.email), user.getEmail()));
        phoneNumber.setText(String.format(context.getString(R.string.phone), user.getPhone()));

        //TODO Address could go into a separate view class if necessary
        Address address = user.getAddress();
        street.setText(String.format(context.getString(R.string.street), address.getStreet()));
        suite.setText(String.format(context.getString(R.string.suite), address.getSuite()));
        city.setText(String.format(context.getString(R.string.city), address.getCity()));
        zipCode.setText(String.format(context.getString(R.string.zip), address.getZipcode()));
    }
}
