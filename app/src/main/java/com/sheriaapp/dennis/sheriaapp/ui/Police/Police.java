package com.sheriaapp.dennis.sheriaapp.ui.Police;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class Police extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation bottomNavigationPolice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        bottomNavigationPolice = (AHBottomNavigation) findViewById(R.id.bottom_navigation_police);
        if (savedInstanceState==null){
            Arrested arrested = new Arrested();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,arrested).commit();
        }
        bottomNavigationPolice.setOnTabSelectedListener(this);
        this.createNavItem();
    }

    private void createNavItem() {
        AHBottomNavigationItem arrested = new AHBottomNavigationItem("Arrested",R.drawable.arrested);
        AHBottomNavigationItem rights = new AHBottomNavigationItem("Rights",R.drawable.rights);

        bottomNavigationPolice.addItem(arrested);
        bottomNavigationPolice.addItem(rights);

        bottomNavigationPolice.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));
        bottomNavigationPolice.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
            Arrested arrested = new Arrested();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,arrested).commit();
        }
        if (position==1){
           ArrestedRights arrestedRights = new ArrestedRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, arrestedRights).commit();
        }


    }
}
