package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.Window;
import android.view.WindowManager;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);

        logo logo = new logo();
        logo.start();
    }
    private class logo extends Thread {
        public void run() {
            try {
                sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent in = new Intent(FirstActivity.this, MainActivity.class);
            startActivity(in);
            FirstActivity.this.finish();
        }
    }
}