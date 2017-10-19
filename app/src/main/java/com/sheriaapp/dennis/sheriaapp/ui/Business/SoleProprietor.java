package com.sheriaapp.dennis.sheriaapp.ui.Business;


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
public class SoleProprietor extends Fragment {
    private DatabaseReference mSoleProprietor;
    private ArrayList<String> mListSoleProprietor = new ArrayList<>();
    private ListView mListViewSoleProprietor;

    public SoleProprietor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_sole_proprietor, container, false);

        mListViewSoleProprietor = (ListView) rootView.findViewById(R.id.list_proprietor);

        mSoleProprietor = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("business")
                .child("register_a_business");

        mSoleProprietor.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    mListSoleProprietor.add(data.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,mListSoleProprietor);
                mListViewSoleProprietor.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }

}
