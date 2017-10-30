package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sheriaapp.dennis.sheriaapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Disclaimer extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.continueToBot)Button goToBot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        ButterKnife.bind(this);

        goToBot.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == goToBot){
            Intent intent = new Intent(Disclaimer.this, ChatArea.class);
            startActivity(intent);
        }
    }
}