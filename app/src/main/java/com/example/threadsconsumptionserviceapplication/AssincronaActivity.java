package com.example.threadsconsumptionserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class AssincronaActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assincrona);

        progressBar = findViewById(R.id.progressBar);
    }

    private void startAsyncTask(View view) {

    }
}