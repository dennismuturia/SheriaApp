package com.sheriaapp.dennis.sheriaapp.ui.Marriage;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class Marriage extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation bottomNavigationMarriage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage);
        bottomNavigationMarriage = (AHBottomNavigation) findViewById(R.id.bottom_navigation_marriage);
        if (savedInstanceState==null){
            Christian christian = new Christian();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,christian).commit();
        }
        bottomNavigationMarriage.setOnTabSelectedListener(this);
        this.createNavItems();
    }
    private void createNavItems(){
       AHBottomNavigationItem christian = new AHBottomNavigationItem("Christian",R.drawable.christianity);
        AHBottomNavigationItem muslim = new AHBottomNavigationItem("Muslim",R.drawable.muslim);
        AHBottomNavigationItem hindu = new AHBottomNavigationItem("Hindu", R.drawable.hindu);

        //Adding the items to the nav bar
        bottomNavigationMarriage.addItem(christian);
        bottomNavigationMarriage.addItem(muslim);
        bottomNavigationMarriage.addItem(hindu);
        // Change colors
        bottomNavigationMarriage.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigationMarriage.setInactiveColor(Color.parseColor("#424242"));

        //setting the properties
        bottomNavigationMarriage.setDefaultBackgroundColor(Color.parseColor("#B71C1C"));
        //set the current item
        bottomNavigationMarriage.setCurrentItem(0);

    }
    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
            Christian christian = new Christian();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,christian).commit();
        }
        if (position==1){
            Muslim muslim = new Muslim();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,muslim).commit();
        }
        if (position==2){
            Hindu hindu = new Hindu();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,hindu).commit();
        }
    }
}
