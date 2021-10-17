package com.sample.githubapi.viewmodel;

import com.sample.githubapi.model.CommitRecord;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<CommitRecord>> records = new MutableLiveData<>();

    public MutableLiveData<List<CommitRecord>> registerObserver() {
        return records;
    }
}
