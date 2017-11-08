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
public class Muslim extends Fragment {
    private DatabaseReference mFeatures;
    private ArrayList<String> featuresList = new ArrayList<>();
    private ListView featuresListView;
    private DatabaseReference mProcedure;
    private ArrayList<String> procedureList = new ArrayList<>();
    private ListView procedureListView;
    private DatabaseReference mRequirements;
    private ArrayList<String> requirementsList = new ArrayList<>();
    private ListView requirementsListView;



    public Muslim() {
        // Required empty public constructor
    }
//ESSENTIAL FEATURES
    //PROCEDURE OF MARRIAGE
    //REQUIREMENTS FOR MARRIAGE

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_muslim, container, false);

        featuresListView =  rootView.findViewById(R.id.contractService);

        mFeatures= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriage")
                .child("muslim_marriage")
                .child("essential_features");
        mFeatures.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    featuresList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,featuresList);
                featuresListView.setAdapter(conAdapter);

                setDynamicHeight(featuresListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        procedureListView =  rootView.findViewById(R.id.contractService);

        mProcedure = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriage")
                .child("muslim_marriage")
                .child("procedure_of_marriage");
        mProcedure.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    procedureList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,procedureList);
                procedureListView.setAdapter(conAdapter);

                setDynamicHeight(procedureListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        requirementsListView =  rootView.findViewById(R.id.contractService);

        mRequirements = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriage")
                .child("muslim_marriage")
                .child("requirements_for_marriage");
        mRequirements.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    requirementsList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,requirementsList);
                requirementsListView.setAdapter(conAdapter);

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
