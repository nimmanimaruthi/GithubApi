package com.sample.githubapi.viewmodel;

import android.app.Application;

import com.sample.githubapi.model.CommitRecord;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private Application application;

    public MainActivityViewModel(Application application) {
        this.application = application;
    }

    private MutableLiveData<List<CommitRecord>> records = new MutableLiveData<>();

    public MutableLiveData<List<CommitRecord>> registerObserver() {
        return records;
    }

    public void fetchCommitRecords() {
        // TODO network call to fetch data
    }
}
