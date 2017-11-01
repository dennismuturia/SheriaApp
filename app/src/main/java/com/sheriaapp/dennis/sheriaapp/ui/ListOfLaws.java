package com.sheriaapp.dennis.sheriaapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sheriaapp.dennis.sheriaapp.R;

import butterknife.Bind;

public class ListOfLaws extends AppCompatActivity {
    @Bind(R.id.myRecyclerView)RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_laws);
    }
}
