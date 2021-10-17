package com.sample.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView receyclerView;
    private ProgressBar progressBar;
    private TextView txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        setUpViewModel();
    }

    private void setUpViewModel() {

    }

    private void initialise() {
        receyclerView = findViewById(R.id.recyclerView);
        txtMessage = findViewById(R.id.txtMessage);
        progressBar = findViewById(R.id.progressBar);
    }
}