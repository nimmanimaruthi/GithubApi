package com.sample.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sample.githubapi.model.CommitRecord;
import com.sample.githubapi.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView receyclerView;
    private ProgressBar progressBar;
    private TextView txtMessage;
    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        setUpViewModel();
    }

    private void setUpViewModel() {
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MainActivityViewModel.class);

        viewModel.registerObserver().observe(this, commitRecords -> {
            if (commitRecords == null || commitRecords.isEmpty()) {
                // TODO display error message
            } else {
                // TODO display data on receylerview
            }
        });
    }

    private void initialise() {
        receyclerView = findViewById(R.id.recyclerView);
        txtMessage = findViewById(R.id.txtMessage);
        progressBar = findViewById(R.id.progressBar);
    }
}