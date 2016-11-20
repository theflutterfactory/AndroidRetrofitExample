package com.protege.androiduserexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.event.UserSummaryEvent;
import com.protege.androiduserexample.model.User;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserSummaryAdapter extends RecyclerView.Adapter<UserSummaryAdapter.ViewHolder> {

    private final ArrayList<User> userList;

    public UserSummaryAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.username)
        TextView userName;

        @BindView(R.id.company)
        TextView company;

        @BindView(R.id.profile_photo)
        ImageView profilePhoto;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public UserSummaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_summary,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        final User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.userName.setText(String.format(context.getString(R.string.username),
                user.getUsername()));
        holder.company.setText(String.format(context.getString(R.string.company),
                user.getCompany().getName()));

        //Todo create an interesting placeholder
        Picasso.with(context)
                .load("http://bit.ly/2f7pckl")
                .into(holder.profilePhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new UserSummaryEvent(user));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
