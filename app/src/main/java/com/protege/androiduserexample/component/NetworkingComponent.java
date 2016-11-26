package com.protege.androiduserexample.component;

import com.protege.androiduserexample.MainActivity;
import com.protege.androiduserexample.UserPostsActivity;
import com.protege.androiduserexample.model.AppModule;
import com.protege.androiduserexample.model.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface NetworkingComponent {
    void inject(MainActivity activity);
    void inject(UserPostsActivity activity);
}
