package com.sheriaapp.dennis.sheriaapp.ui.Business;

import android.content.Context;
import android.net.Uri;
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


public class RegisterBusiness extends Fragment {
    private DatabaseReference mRegisterBusiness;
    private ArrayList<String> mListRegisterBusiness = new ArrayList<>();
    private ListView mListRegister;

    public RegisterBusiness() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register_business, container, false);
        mListRegister= (ListView) rootView.findViewById(R.id.list_register);
        mRegisterBusiness = FirebaseDatabase.getInstance()
                .getReference("laws")
                .child("business")
                .child("procedure_of_registration_of_company");
        mRegisterBusiness.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                mListRegisterBusiness.add(snapshot.getValue().toString());
            }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,mListRegisterBusiness);
                mListRegister.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }


}
