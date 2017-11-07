package com.sheriaapp.dennis.sheriaapp.ui.Marriage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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
public class Christian extends Fragment {
    private DatabaseReference mCeremony;
    private ArrayList<String> ceremonyList = new ArrayList<>();
    private ListView ceremonyListView;
    private DatabaseReference mRegister;
    private ArrayList<String> registerList = new ArrayList<>();
    private ListView registerListView;
    private DatabaseReference mAge;
    private ArrayList<String> ageList = new ArrayList<>();
    private ListView ageListView;
    private DatabaseReference mCertificate;
    private ArrayList<String> certificateList = new ArrayList<>();
    private ListView certificateListView;
    private DatabaseReference mRequirements;
    private ArrayList<String> requirementsList = new ArrayList<>();
    private ListView requirementsListView;
    private DatabaseReference mWitnesses;
    private ArrayList<String> witnessesList = new ArrayList<>();
    private ListView witnessesListView;

    public Christian() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_christian, container, false);
        //ceremony database call
        ceremonyListView = (ListView) rootView.findViewById(R.id.ceremony);


       mCeremony = FirebaseDatabase.getInstance()
                .getReference("laws")
               .child("marriages")
                .child("christian_marriages")
                .child("ceremony");

        mCeremony.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    ceremonyList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,ceremonyList);
                ceremonyListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(ceremonyListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //registration database call
        registerListView = rootView.findViewById(R.id.register);
        mRegister = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("marriages")
                .child("christian_marriages")
                .child("registry_and_cost");

        mRegister.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    registerList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,registerList);
                registerListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(registerListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //database call for marriage age
        ageListView = rootView.findViewById(R.id.age);
        mAge = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("marriages")
                .child("christian_marriages")
                .child("marriage_age");

        mAge.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    ageList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,ageList);
                ageListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(ageListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //database call for marriage certificate
        certificateListView = rootView.findViewById(R.id.certificate);
        mCertificate = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("marriages")
                .child("christian_marriages")
                .child("marriage_certificate");

        mCertificate.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    certificateList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,certificateList);
                certificateListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(certificateListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //database call for marriage witnesses
        witnessesListView = rootView.findViewById(R.id.witness);
        mWitnesses = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("marriages")
                .child("christian_marriages")
                .child("witnesses");

        mWitnesses.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    witnessesList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,witnessesList);
                witnessesListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(witnessesListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //database call for marriage requirements
        requirementsListView = rootView.findViewById(R.id.requirements);
        mRequirements = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("marriages")
                .child("christian_marriages")
                .child("requirements");

        mRequirements.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    requirementsList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,requirementsList);
                requirementsListView.setAdapter(adapter);
                //set dynamic height for all listviews
                setDynamicHeight(requirementsListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }

    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

}
