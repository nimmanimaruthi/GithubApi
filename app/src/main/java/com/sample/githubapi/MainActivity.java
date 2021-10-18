package com.sample.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sample.githubapi.adapter.CommitAdapter;
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
            progressBar.setVisibility(View.GONE);
            if (commitRecords == null || commitRecords.isEmpty()) {
                txtMessage.setVisibility(View.VISIBLE);
                receyclerView.setVisibility(View.GONE);
            } else {
                txtMessage.setVisibility(View.GONE);
                receyclerView.setVisibility(View.VISIBLE);
                receyclerView.setAdapter(new CommitAdapter(commitRecords));
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        viewModel.fetchCommitRecords();
    }

    private void initialise() {
        receyclerView = findViewById(R.id.recyclerView);
        txtMessage = findViewById(R.id.txtMessage);
        progressBar = findViewById(R.id.progressBar);
        receyclerView.setLayoutManager(new LinearLayoutManager(this));
        receyclerView.addItemDecoration(new DividerItemDecoration(
                        this, DividerItemDecoration.VERTICAL));
    }
}