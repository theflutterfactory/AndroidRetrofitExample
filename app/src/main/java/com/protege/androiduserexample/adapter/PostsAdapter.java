package com.protege.androiduserexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.protege.androiduserexample.R;
import com.protege.androiduserexample.model.Post;
import com.protege.androiduserexample.view.UserPostView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private final ArrayList<Post> postList;

    public PostsAdapter(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }
    }

    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_post,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = postList.get(position);
        ((UserPostView)holder.itemView).setUserPost(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
