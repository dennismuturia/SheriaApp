package com.sheriaapp.dennis.sheriaapp.ui.Traffic;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class Traffic extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation trafficBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        trafficBottomNav = (AHBottomNavigation) findViewById(R.id.bottom_navigation_traffic);
        if (savedInstanceState==null){
            accident_person accidentPerson = new accident_person();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,accidentPerson).commit();
        }
        trafficBottomNav.setOnTabSelectedListener(this);
        this.createNavItems();
    }
    private void createNavItems(){
        //creating the nav items
        AHBottomNavigationItem traffic = new AHBottomNavigationItem("offences", R.drawable.traffic_light);
        AHBottomNavigationItem accidentCar = new AHBottomNavigationItem("Car_on_Car", R.drawable.accident);
        AHBottomNavigationItem accidentPerson = new AHBottomNavigationItem("Car_on_Person", R.drawable.accident_person);

        //Adding them to the bar
        trafficBottomNav.addItem(traffic);
     trafficBottomNav.addItem(accidentCar);
        trafficBottomNav.addItem(accidentPerson);
        //setting the properties
        trafficBottomNav.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));
        //set the current item
        trafficBottomNav.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
            accident_person accidentPerson = new accident_person();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,accidentPerson).commit();
        }
        if(position==1){
            AccidentCar accidentCar = new AccidentCar();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,accidentCar).commit();
        }
        if (position ==2){
            Offences trafficOffences = new Offences();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,trafficOffences).commit();
        }

    }
}
