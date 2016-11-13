package com.protege.androiduserexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.User;

import java.util.ArrayList;

public class UserSummaryAdapter extends RecyclerView.Adapter<UserSummaryAdapter.ViewHolder> {

    private ArrayList<User> userList;

    public UserSummaryAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView userName;
        public TextView company;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            userName = (TextView) v.findViewById(R.id.username);
            company = (TextView) v.findViewById(R.id.company);
        }
    }

    @Override
    public UserSummaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_summary,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.userName.setText("Username: " + user.getUsername());
        holder.company.setText("Company: " + user.getCompany().getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
