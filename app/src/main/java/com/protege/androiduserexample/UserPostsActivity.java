package com.protege.androiduserexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.protege.androiduserexample.adapter.PostsAdapter;
import com.protege.androiduserexample.model.Post;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserPostsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private PostsAdapter adapter;

    private ArrayList<Post> postLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_posts);
        ButterKnife.bind(this);

        toolbar.setTitle(getString(R.string.posts));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        postLists = new ArrayList<>();
        adapter = new PostsAdapter(postLists);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
