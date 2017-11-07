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
public class Contract extends Fragment {
    private DatabaseReference mContractEmployment;
    private ArrayList<String> contractList = new ArrayList<>();
    private ListView contractLaws;
    private DatabaseReference mContractService;
    private ArrayList<String> contractServiceList = new ArrayList<>();
    private ListView contractServiceListView;





    public Contract() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contract, container, false);
        contractLaws =  rootView.findViewById(R.id.list_contract);

        mContractEmployment= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("contracts_of_service");
        mContractEmployment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    contractList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,contractList);
                contractLaws.setAdapter(conAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        contractServiceListView =  rootView.findViewById(R.id.list_contract);

        mContractEmployment= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("contracts_of_service");
        mContractEmployment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    contractList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,contractList);
                contractLaws.setAdapter(conAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }

}
