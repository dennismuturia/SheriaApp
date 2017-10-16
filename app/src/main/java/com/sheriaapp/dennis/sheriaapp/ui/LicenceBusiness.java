package com.sheriaapp.dennis.sheriaapp.ui;


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

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LicenceBusiness extends Fragment {
    private DatabaseReference mRegisterBusiness;
    private ValueEventListener mRegisterBusinessListener;
    private ArrayList<String> licProcedure=new ArrayList<>();
    private ListView mlistProcedure;

    public LicenceBusiness() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_licence_business, container, false);
        mlistProcedure = (ListView) rootView.findViewById(R.id.list_licence);

        mRegisterBusiness = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("business")
                .child("licencing_of_premises_and_trades");

        mRegisterBusinessListener = mRegisterBusiness.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    licProcedure.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,licProcedure);
                mlistProcedure.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }


}
