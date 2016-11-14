package com.protege.androiduserexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.protege.androiduserexample.adapter.UserSummaryAdapter;
import com.protege.androiduserexample.api.EndpointInterface;
import com.protege.androiduserexample.model.User;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private UserSummaryAdapter adapter;

    private ArrayList<User> userList;

    public static final String USER_EXTRA = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.users);
        setSupportActionBar(toolbar);

        userList = new ArrayList<>();
        adapter = new UserSummaryAdapter(this, userList, new OnUserClicked() {
            @Override
            public void onUserClick(User user) {
                Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
                intent.putExtra(USER_EXTRA, Parcels.wrap(user));
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        populateUserList();
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
                getSupportActionBar().setSubtitle(userList.size() + " total");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("Main", "Error: " + t.getCause());
            }
        });
    }

    public interface OnUserClicked {
        void onUserClick(User user);
    }
}
