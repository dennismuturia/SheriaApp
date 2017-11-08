package com.sheriaapp.dennis.sheriaapp.ui.HumanRights;


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
public class FundamentalRights extends Fragment {
    private ArrayList<String> fundamentalRightsList = new ArrayList<>();
    private ListView fundamentalRightsListView;



    public FundamentalRights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_fundamental_rights, container, false);

        fundamentalRightsListView =  rootView.findViewById(R.id.fundamental_rights);
        DatabaseReference mFundamentalRights = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("human_rights")
                .child("R_and_F_Principles");


        mFundamentalRights.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    fundamentalRightsList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,fundamentalRightsList);
                fundamentalRightsListView.setAdapter(terminateAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        return rootView;
    }

}
