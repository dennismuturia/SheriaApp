package com.sheriaapp.dennis.sheriaapp.ui.Traffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.sheriaapp.dennis.sheriaapp.R;

public class Traffic extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {

    }
}
