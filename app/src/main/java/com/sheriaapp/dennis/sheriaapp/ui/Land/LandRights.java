package com.sheriaapp.dennis.sheriaapp.ui.Land;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
        landRightsListView = (ListView) rootView.findViewById(R.id.list_licence);

        mLandRights = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("land")
                .child("land_ ");

        mLandRights.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    landRightsList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,landRightsList);
                landRightsListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }



}
