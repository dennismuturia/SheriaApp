package com.sheriaapp.dennis.sheriaapp.sheriaap;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.sheriaapp.dennis.sheriaapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    //This willbe the timeout time for the splash screen
    public static int time_out = 3000;
    @Bind(R.id.myLogo)ImageView thisLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load our activity
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        //This will delay our activity based on the time allocated
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);

                finish();

            }

        }, time_out);



        getSupportActionBar().hide();

    }
}
