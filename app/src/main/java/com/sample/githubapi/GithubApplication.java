package com.sample.githubapi;

import android.app.Application;

import com.sample.githubapi.di.AppComponent;
import com.sample.githubapi.di.DaggerAppComponent;

public class GithubApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
