package com.sheriaapp.dennis.sheriaapp.ui.HumanRights;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class HumanRights extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation bottomNavigationLand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_rights);
        bottomNavigationLand =  findViewById(R.id.bottom_navigation_humanrights);
        if (savedInstanceState==null){
            ChildRights childRights = new ChildRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, childRights).commit();
        }
        bottomNavigationLand.setOnTabSelectedListener(this);
        this.createNavElements();
    }
    private void createNavElements(){
        //creating nav elements
        AHBottomNavigationItem childrenRights = new AHBottomNavigationItem("Child Rights", R.drawable.child);
        AHBottomNavigationItem fundamental = new AHBottomNavigationItem("Fundamentals Rights", R.drawable.f_r);
        AHBottomNavigationItem otherRights = new AHBottomNavigationItem("OtherRights", R.drawable.other);
        //populating the bottom nav bar
        bottomNavigationLand.addItem(childrenRights);
        bottomNavigationLand.addItem(fundamental);
        bottomNavigationLand.addItem(otherRights);
        //setting the properties
        bottomNavigationLand.setDefaultBackgroundColor(Color.parseColor("#B71C1C"));
        // Change colors
        bottomNavigationLand.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigationLand.setInactiveColor(Color.parseColor("#424242"));
        //set the current item
        bottomNavigationLand.setCurrentItem(0);


    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
            ChildRights childRights = new ChildRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, childRights).commit();
        }
        if (position==1){
            FundamentalRights fundamentalRights = new FundamentalRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, fundamentalRights).commit();
        }
        if (position==2){
           OtherRights otherRights = new OtherRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, otherRights).commit();
        }
    }
}
