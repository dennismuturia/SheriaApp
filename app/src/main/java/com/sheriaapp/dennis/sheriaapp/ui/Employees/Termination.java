package com.sheriaapp.dennis.sheriaapp.ui.Employees;


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
public class Termination extends Fragment {
    private DatabaseReference mTerminate;
    private ArrayList<String> terminateList = new ArrayList<>();
    private ListView terminateListView;


    public Termination() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_termination, container, false);

        terminateListView = (ListView) rootView.findViewById(R.id.list_terminate);
        mTerminate = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("termination_of_contracts");

        mTerminate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    terminateList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,terminateList);
                terminateListView.setAdapter(terminateAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        return rootView;
    }

}
