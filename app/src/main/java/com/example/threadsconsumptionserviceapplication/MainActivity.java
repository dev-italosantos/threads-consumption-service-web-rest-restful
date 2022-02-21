package com.example.threadsconsumptionserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciarThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarThread = findViewById(R.id.btnIniciarThread);
    }

    public void iniciarThread(View view) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++ ) {
                Log.d("Thread", "contador:" + i);

                btnIniciarThread.setText("contador:" + i);

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