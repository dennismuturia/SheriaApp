package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.ImageView;

import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.ui.Business.BusinessActivity;
import com.sheriaapp.dennis.sheriaapp.ui.Land.Land;

import butterknife.Bind;
import butterknife.ButterKnife;





public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.chatWithBot)Button ChatBot;
    @Bind(R.id.businessImage)
    ImageView myBusiness;
    @Bind(R.id.landImage) ImageView myLand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        ChatBot.setOnClickListener(this);

        myBusiness.setOnClickListener(this);
        myLand.setOnClickListener(this);

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
    }

}
