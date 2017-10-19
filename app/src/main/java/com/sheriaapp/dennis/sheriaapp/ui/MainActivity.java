package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.ui.Business.BusinessActivity;
import com.sheriaapp.dennis.sheriaapp.ui.Court.CourtProcess;
import com.sheriaapp.dennis.sheriaapp.ui.Employees.Employee;
import com.sheriaapp.dennis.sheriaapp.ui.Land.Land;
import com.sheriaapp.dennis.sheriaapp.ui.Marriage.Marriage;
import com.sheriaapp.dennis.sheriaapp.ui.Police.Police;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.chatWithBot)Button ChatBot;
    @Bind(R.id.card_business) CardView myBusiness;
    @Bind(R.id.card_land)
    CardView myLand;
    @Bind(R.id.card_court) CardView myCourt;
    @Bind(R.id.card_marriage) CardView myMarriage;
    @Bind(R.id.card_employment) CardView myEmployment;
    @Bind(R.id.card_police) CardView myPolice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        myBusiness.setOnClickListener(this);
        myLand.setOnClickListener(this);
        myCourt.setOnClickListener(this);
        myMarriage.setOnClickListener(this);
        myEmployment.setOnClickListener(this);
        myPolice.setOnClickListener(this);
        ChatBot.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchmenu, menu);
        MenuItem menuItem = menu.findItem(R.id.searchLaws);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String User = query;
                Intent intent = new Intent(MainActivity.this, ListOfLaws.class);
                intent.putExtra("User", User);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        if (view == myBusiness){
            Intent intent = new Intent(MainActivity.this, BusinessActivity.class);
            startActivity(intent);
        }
        if (view==myLand){
            Intent intent = new Intent(MainActivity.this,Land.class);
            startActivity(intent);
        }
        if (view == ChatBot){
            Intent intent = new Intent(MainActivity.this, ChatArea.class);
            startActivity(intent);
        }
        if (view==myPolice){
            Intent intent = new Intent(MainActivity.this,Police.class);
            startActivity(intent);
        }
        if (view==myCourt){
            Intent intent = new Intent(MainActivity.this,CourtProcess.class);
            startActivity(intent);
        }
        if (view==myEmployment){
            Intent intent = new Intent(MainActivity.this,Employee.class);
            startActivity(intent);
        }
        if (view==myMarriage){
            Intent intent = new Intent(MainActivity.this,Marriage.class);
            startActivity(intent);
        }



    }

}
