package com.example.magicpinfeed;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.magicpinfeed.utils.CommonMethods;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CommonMethods.isNetworkConnected(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent feedIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(feedIntent);
                SplashScreen.this.finish();

            }
        }, 2000);
    }
}
