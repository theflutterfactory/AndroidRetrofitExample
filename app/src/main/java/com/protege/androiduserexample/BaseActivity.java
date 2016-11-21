package com.protege.androiduserexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Nullable
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        toolbar.setTitle(getToolbarTitle());
        setSupportActionBar(toolbar);
    }

    public abstract int getLayout();

    public abstract String getToolbarTitle();

}
