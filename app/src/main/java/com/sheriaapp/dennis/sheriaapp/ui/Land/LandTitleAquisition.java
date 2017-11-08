package com.sheriaapp.dennis.sheriaapp.ui.Land;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class LandTitleAquisition extends Fragment {
    private DatabaseReference mLandTitleAquisition;
    private ArrayList<String> landTitleAquisitionsList = new ArrayList<>();
    private ListView landTitleAquisitionListView;


    public LandTitleAquisition() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_land_title_aquisition, container, false);

        landTitleAquisitionListView = (ListView) rootView.findViewById(R.id.list_title_acquire);

        mLandTitleAquisition = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("land")
                .child("land_acquistion");

        mLandTitleAquisition.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    landTitleAquisitionsList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,landTitleAquisitionsList);
                landTitleAquisitionListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }

}
