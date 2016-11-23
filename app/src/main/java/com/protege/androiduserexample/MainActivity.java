package com.protege.androiduserexample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.protege.androiduserexample.adapter.UserSummaryAdapter;
import com.protege.androiduserexample.api.EndpointInterface;
import com.protege.androiduserexample.event.UserSummaryEvent;
import com.protege.androiduserexample.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private UserSummaryAdapter adapter;

    private ArrayList<User> userList;

    public static final String USER_EXTRA = "USER";

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        collapsingToolbarLayout.setTitle(getString(R.string.users));

        userList = new ArrayList<>();
        adapter = new UserSummaryAdapter(userList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        populateUserList();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.users);
    }

    private void populateUserList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndpointInterface endpointInterface =
                retrofit.create(EndpointInterface.class);

        Call<List<User>> users = endpointInterface.getUser();
        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressBar.setVisibility(View.GONE);
                userList.addAll(response.body());
                getSupportActionBar().setSubtitle(String.format(getString(R.string.total),
                        userList.size()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("Main", "Error: " + t.getCause());
            }
        });
    }

    @Subscribe
    public void onUserSummaryClicked(UserSummaryEvent event) {
        Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
        intent.putExtra(USER_EXTRA, Parcels.wrap(event.getUser()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
            startActivity(intent, oc2.toBundle());
        } else {
            startActivity(intent);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
