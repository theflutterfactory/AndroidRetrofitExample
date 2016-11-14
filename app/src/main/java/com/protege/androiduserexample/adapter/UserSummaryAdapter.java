package com.protege.androiduserexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.protege.androiduserexample.MainActivity;
import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserSummaryAdapter extends RecyclerView.Adapter<UserSummaryAdapter.ViewHolder> {

    private ArrayList<User> userList;
    private Context context;
    private MainActivity.OnUserClicked userClickedListener;

    public UserSummaryAdapter(Context context, ArrayList<User> userList,
                              MainActivity.OnUserClicked userClickedListener) {
        this.userList = userList;
        this.context = context;
        this.userClickedListener = userClickedListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.username)
        TextView userName;

        @BindView(R.id.company)
        TextView company;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
        final User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.userName.setText(String.format(context.getString(R.string.username),
                user.getUsername()));
        holder.company.setText(String.format(context.getString(R.string.company),
                user.getCompany().getName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userClickedListener.onUserClick(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
