package com.sheriaapp.dennis.sheriaapp.ui.Marriage;

import android.content.Context;
import android.net.Uri;
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


public class Hindu extends Fragment {
    private DatabaseReference mCeremony;
    private ArrayList<String> ceremonyList = new ArrayList<>();
    private ListView ceremonyListView;
    private DatabaseReference mConditions;
    private ArrayList<String> conditionstList = new ArrayList<>();
    private ListView conditionsListView;
    private DatabaseReference mDivorce;
    private ArrayList<String> divorceList = new ArrayList<>();
    private ListView divorceListView;


    public Hindu() {
        // Required empty public constructor
    }
    //ceremony
    //conditions
    //grounds for divorce

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_hindu, container, false);

        ceremonyListView =  rootView.findViewById(R.id.ceremony);

        mCeremony= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriages")
                .child("hindu_marriages")
                .child("ceremony");
        mCeremony.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    ceremonyList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,ceremonyList);
                ceremonyListView.setAdapter(conAdapter);

                setDynamicHeight(ceremonyListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        conditionsListView =  rootView.findViewById(R.id.conditions);

        mConditions= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriage")
                .child("hindu_marriages")
                .child("conditions");
        mConditions.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    conditionstList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,conditionstList);
                conditionsListView.setAdapter(conAdapter);

                setDynamicHeight(conditionsListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        divorceListView =  rootView.findViewById(R.id.divorce);

        mDivorce= FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("marriages")
                .child("hindu_marriages")
                .child("ground_for_divorce");
        mDivorce.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    divorceList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,divorceList);
                divorceListView.setAdapter(conAdapter);

                setDynamicHeight(divorceListView);

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
