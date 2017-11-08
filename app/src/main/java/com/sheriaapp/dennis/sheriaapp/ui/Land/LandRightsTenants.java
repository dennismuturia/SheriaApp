package com.sheriaapp.dennis.sheriaapp.ui.Land;


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
public class LandRightsTenants extends Fragment {
    private DatabaseReference mLandRightsTenants;
    private ArrayList<String> landRightsTenantsList = new ArrayList<>();
    private ListView landRightsTenantsListView;
    private DatabaseReference mLandRightsLandLord;
    private ArrayList<String> landRightsLandLordList = new ArrayList<>();
    private ListView landRightsLandLordListView;



    public LandRightsTenants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_land_rights_tenants, container, false);

        landRightsTenantsListView = (ListView) rootView.findViewById(R.id.tenant);

        mLandRightsTenants = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("land")
                .child("tenants_rights");

        mLandRightsTenants.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    landRightsTenantsList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,landRightsTenantsList);
                landRightsTenantsListView.setAdapter(adapter);
                setDynamicHeight(landRightsTenantsListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        landRightsLandLordListView = (ListView) rootView.findViewById(R.id.LandLordrights);

        mLandRightsLandLord = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("land")
                .child("land_lord_rights");

        mLandRightsLandLord.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    landRightsLandLordList.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,landRightsLandLordList);
                landRightsLandLordListView.setAdapter(adapter);

                setDynamicHeight(landRightsLandLordListView);

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
