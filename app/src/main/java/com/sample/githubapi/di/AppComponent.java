package com.sample.githubapi.di;

import com.sample.githubapi.di.module.RetroModule;
import com.sample.githubapi.viewmodel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface AppComponent {
    void inject(MainActivityViewModel mainActivityViewModel);
}
