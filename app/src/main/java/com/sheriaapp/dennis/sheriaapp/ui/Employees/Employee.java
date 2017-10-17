package com.sheriaapp.dennis.sheriaapp.ui.Employees;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.sheriaapp.dennis.sheriaapp.R;

public class Employee extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    private AHBottomNavigation bottomNavEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        bottomNavEmployee = (AHBottomNavigation) findViewById(R.id.bottom_navigation_employee);
        bottomNavEmployee.setOnTabSelectedListener(this);
        this.createNavItems();
    }
    private void createNavItems(){
        //creating nav elements
        AHBottomNavigationItem contract = new AHBottomNavigationItem("contract",R.drawable.contract);
        AHBottomNavigationItem termination = new AHBottomNavigationItem("Terminated", R.drawable.people);
        AHBottomNavigationItem EmployeeRights = new AHBottomNavigationItem("Employee_Rights", R.drawable.employeework);
       //adding them to the bottom nav bar
        bottomNavEmployee.addItem(contract);
        bottomNavEmployee.addItem(termination);
        bottomNavEmployee.addItem(EmployeeRights);
        //setting the properties
        bottomNavEmployee.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));
        //set the current item
        bottomNavEmployee.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if (position==0){
            Contract contract = new Contract();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,contract).commit();
        }
        if (position==1){
            EmployeeRights employeeRights = new EmployeeRights();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,employeeRights).commit();
        }
        if (position==2){
            Termination terminate = new Termination();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,terminate).commit();
        }

    }
}
