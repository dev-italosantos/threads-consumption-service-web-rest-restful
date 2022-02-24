package com.example.threadsconsumptionserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciarThread;
    private int numero;
    private boolean stopExecucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarThread = findViewById(R.id.btnIniciarThread);
    }

    public void startThread(View view) {
        stopExecucao = false;
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public void nextLayout(View view) {
        Intent intent = new Intent(MainActivity.this, AssincronaActivity.class);
        startActivity(intent);
    }

    public void stopThread(View view) {
        stopExecucao = true;
    }

    class MyThread extends Thread {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++ ) {

                if (stopExecucao)
                    return;

                numero = i;

                Log.d("Thread", "contador:" + i);

                runOnUiThread(() -> btnIniciarThread.setText("contador: " + numero));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }
    }
}