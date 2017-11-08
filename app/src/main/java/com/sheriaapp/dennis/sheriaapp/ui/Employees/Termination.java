package com.sheriaapp.dennis.sheriaapp.ui.Employees;


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
public class Termination extends Fragment {
    private DatabaseReference mTerminate;
    private ArrayList<String> terminateList = new ArrayList<>();
    private ListView terminateListView;
    private DatabaseReference mTerminateNotice;
    private ArrayList<String> terminateNoticeList = new ArrayList<>();
    private ListView terminateNoticeListView;
    private DatabaseReference mTerminateUnfair;
    private ArrayList<String> terminateUnfairList = new ArrayList<>();
    private ListView terminateUnfairListView;


    public Termination() {
        // Required empty public constructor
    }
    //notice_termination
    //termination
    //unfair_termination

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_termination, container, false);

        terminateListView =  rootView.findViewById(R.id.termination);
        mTerminate = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("termination")
                .child("termination");

        mTerminate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    terminateList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,terminateList);
                terminateListView.setAdapter(terminateAdapter);

                setDynamicHeight(terminateListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        terminateNoticeListView =  rootView.findViewById(R.id.notice);
        mTerminateNotice = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("termination")
                .child("notice_termination");

        mTerminateNotice.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    terminateNoticeList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,terminateNoticeList);
                terminateNoticeListView.setAdapter(terminateAdapter);

                setDynamicHeight(terminateNoticeListView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        terminateUnfairListView =  rootView.findViewById(R.id.unfair);
        mTerminateUnfair = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("termination")
                .child("unfair_termination");

        mTerminateUnfair.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot terminate : dataSnapshot.getChildren()){
                    terminateUnfairList.add(terminate.getValue().toString());
                }
                ArrayAdapter terminateAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,terminateUnfairList);
                terminateUnfairListView.setAdapter(terminateAdapter);

                setDynamicHeight(terminateUnfairListView);
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
