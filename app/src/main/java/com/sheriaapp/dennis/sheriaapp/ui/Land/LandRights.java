package com.sheriaapp.dennis.sheriaapp.ui.Land;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.sheriaapp.dennis.sheriaapp.R;

import java.util.ArrayList;


public class LandRights extends Fragment {
    private DatabaseReference mLandRights;
    private ArrayList<String> landRightsList = new ArrayList<>();
    private ListView landRightsListView;



    public LandRights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_land_rights, container, false);

        return rootView;
    }



}
