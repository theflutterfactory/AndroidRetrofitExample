package com.protege.androiduserexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.User;
import com.protege.androiduserexample.view.UserSummaryView;

import java.util.ArrayList;

public class UserSummaryAdapter extends RecyclerView.Adapter<UserSummaryAdapter.ViewHolder> {

    private final ArrayList<User> userList;

    public UserSummaryAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }
    }

    @Override
    public UserSummaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_summary,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = userList.get(position);
        ((UserSummaryView)holder.itemView).setUserSummary(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
