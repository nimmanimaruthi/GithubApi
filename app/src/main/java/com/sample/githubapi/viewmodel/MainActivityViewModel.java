package com.sample.githubapi.viewmodel;

import android.util.Log;

import com.sample.githubapi.GithubApplication;
import com.sample.githubapi.apiservice.ApiService;
import com.sample.githubapi.model.CommitRecord;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private String TAG = MainActivityViewModel.class.getSimpleName();
    @Inject
    ApiService apiService;

    private MutableLiveData<List<CommitRecord>> records = new MutableLiveData<>();

    public MutableLiveData<List<CommitRecord>> registerObserver() {
        GithubApplication.getAppComponent().inject(this);
        return records;
    }

    public void fetchCommitRecords() {
        apiService.getCommitRecords("nimmanimaruthi", "GithubApi")
                .enqueue(new Callback<List<CommitRecord>>() {
                    @Override
                    public void onResponse(Call<List<CommitRecord>> call, Response<List<CommitRecord>> response) {
                        records.setValue(response.body());
                        records.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CommitRecord>> call, Throwable t) {
                        records.postValue(null);
                    }
                });
    }
}
