package com.sheriaapp.dennis.sheriaapp.ui.HumanRights;


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
public class OtherRights extends Fragment {
    private DatabaseReference mSocioRights;
    private ArrayList<String> socioRightsList = new ArrayList<>();
    private ListView socioRightsListView;
    private DatabaseReference mConsumerRights;
    private ArrayList<String> consumerRightsList = new ArrayList<>();
    private ListView consumerRightsListView;


    public OtherRights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_other_rights, container, false);

        socioRightsListView =  rootView.findViewById(R.id.sociorights);

        mSocioRights = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("human_rights")
                .child("socio_economic");
        mSocioRights.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    socioRightsList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,socioRightsList);
                socioRightsListView.setAdapter(conAdapter);

                setDynamicHeight(socioRightsListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        consumerRightsListView =  rootView.findViewById(R.id.consumer);

        mConsumerRights = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("human_rights")
                .child("consumer_rights");
        mConsumerRights.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    consumerRightsList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,consumerRightsList);
                consumerRightsListView.setAdapter(conAdapter);

                setDynamicHeight(consumerRightsListView);

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
