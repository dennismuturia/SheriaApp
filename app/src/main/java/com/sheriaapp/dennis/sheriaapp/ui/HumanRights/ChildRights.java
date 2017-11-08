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
public class ChildRights extends Fragment {
    private DatabaseReference mChildrenRights;
    private ArrayList<String> childrenRightsList = new ArrayList<>();
    private ListView childrenRightsListView;




    public ChildRights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_child_rights, container, false);

        childrenRightsListView =  rootView.findViewById(R.id.child_rights);
        mChildrenRights = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("human_rights")
                .child("children_rights");


        mChildrenRights.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    childrenRightsList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,childrenRightsList);
                childrenRightsListView.setAdapter(terminateAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        return rootView;
    }

}
