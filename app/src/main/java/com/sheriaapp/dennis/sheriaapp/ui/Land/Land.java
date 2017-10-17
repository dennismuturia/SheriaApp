package com.sheriaapp.dennis.sheriaapp.ui.Land;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class Land extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation bottomNavigationLand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        bottomNavigationLand= (AHBottomNavigation) findViewById(R.id.bottom_navigation_land);
        bottomNavigationLand.setOnTabSelectedListener(this);
        this.createNavElements();
    }
    private void createNavElements(){
        //creating nav elements
        AHBottomNavigationItem landAquistion = new AHBottomNavigationItem("Buy Land", R.drawable.agent);
        AHBottomNavigationItem landRights = new AHBottomNavigationItem("Land Right", R.drawable.rights);
        AHBottomNavigationItem landlordTenant = new AHBottomNavigationItem("Tenants&LandLords", R.drawable.landlord);
        AHBottomNavigationItem title = new AHBottomNavigationItem("Title Deed", R.drawable.title);
        //populating the bottom nav bar
        bottomNavigationLand.addItem(landAquistion);
        bottomNavigationLand.addItem(landRights);
        bottomNavigationLand.addItem(landlordTenant);
        bottomNavigationLand.addItem(title);
        //setting the properties
        bottomNavigationLand.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));
        //set the current item
        bottomNavigationLand.setCurrentItem(0);


    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
           LandAquistion landAquistion = new LandAquistion();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, landAquistion).commit();
        }
        if (position==1){
            LandRights landRights = new LandRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,landRights).commit();
        }
        if (position==2){
            LandRightsTenants landRightsTenants = new LandRightsTenants();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,landRightsTenants).commit();
        }
        if (position==3){
            LandTitleAquisition landTitleAquisition = new LandTitleAquisition();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, landTitleAquisition).commit();
        }

    }
}
