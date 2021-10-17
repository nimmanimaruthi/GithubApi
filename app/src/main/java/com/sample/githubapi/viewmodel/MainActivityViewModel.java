package com.sample.githubapi.viewmodel;

import android.app.Application;
import android.util.Log;

import com.sample.githubapi.di.module.RetroModule;
import com.sample.githubapi.model.CommitRecord;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private String TAG = MainActivityViewModel.class.getSimpleName();
    private Application application;

    public MainActivityViewModel() {
        //this.application = application;
    }

    private MutableLiveData<List<CommitRecord>> records = new MutableLiveData<>();

    public MutableLiveData<List<CommitRecord>> registerObserver() {
        return records;
    }

    public void fetchCommitRecords() {
        // TODO network call to fetch data
        RetroModule.provideApiService(RetroModule.getRetrofitInstance())
                .getCommitRecords("nimmanimaruthi", "GithubApi")
                .enqueue(new Callback<List<CommitRecord>>() {
                    @Override
                    public void onResponse(Call<List<CommitRecord>> call, Response<List<CommitRecord>> response) {
                        Log.v(TAG, "onResponse");
                    }

                    @Override
                    public void onFailure(Call<List<CommitRecord>> call, Throwable t) {
                        Log.v(TAG, "onFailure");
                    }
                });
    }
}
