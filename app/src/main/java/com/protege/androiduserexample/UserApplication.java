package com.protege.androiduserexample;

import android.app.Application;

import com.protege.androiduserexample.component.DaggerNetworkingComponent;
import com.protege.androiduserexample.component.NetworkingComponent;
import com.protege.androiduserexample.model.AppModule;
import com.protege.androiduserexample.model.RetrofitModule;

public class UserApplication extends Application {

    private NetworkingComponent networkingComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkingComponent = DaggerNetworkingComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    NetworkingComponent getNetworkingComponent() {
        return networkingComponent;
    }
}
