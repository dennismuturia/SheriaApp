package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sheriaapp.dennis.sheriaapp.R;

public class BusinessActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    AHBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        bottomNavigation= (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();

    }
    private void createNavItems(){
        //creating the nav items
        AHBottomNavigationItem register = new AHBottomNavigationItem("register", R.drawable.ic_business_center_black_24dp);
        AHBottomNavigationItem licence = new AHBottomNavigationItem("licence", R.drawable.ic_assignment_black_24dp);

        //Adding them to the bar
        bottomNavigation.addItem(register);
        bottomNavigation.addItem(licence);
        //setting the properties
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));
        //set the current item
        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        //populates the view holder when the button is clicked
        if (position==0){
            RegisterBusiness registerBusiness = new RegisterBusiness();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,registerBusiness).commit();
        }

        if (position==1){
            LicenceBusiness licenceBusiness = new LicenceBusiness();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id, licenceBusiness).commit();
        }

    }

}
