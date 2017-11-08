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
public class Contract extends Fragment {
    private DatabaseReference mContractEmployment;
    private ArrayList<String> contractList = new ArrayList<>();
    private ListView contractLaws;
    private DatabaseReference mRequirementContract;
    private ArrayList<String> requirementContractList = new ArrayList<>();
    private ListView requirementContractListView;
    private DatabaseReference mContractElements;
    private ArrayList<String> contractElementsList = new ArrayList<>();
    private ListView contractElementsListView;





    public Contract() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contract, container, false);
        contractLaws =  rootView.findViewById(R.id.contractService);

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

                setDynamicHeight(contractLaws);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        requirementContractListView =  rootView.findViewById(R.id.requirementsContract);

        mRequirementContract = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("contracts_service_have");
        mRequirementContract.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    requirementContractList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,requirementContractList);
                requirementContractListView.setAdapter(conAdapter);

                setDynamicHeight(requirementContractListView);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        contractElementsListView =  rootView.findViewById(R.id.elements);

        mContractElements = FirebaseDatabase
                .getInstance()
                .getReference("laws")
                .child("employment")
                .child("valid_contracts_elements");
        mContractElements.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot condataSnapShot:dataSnapshot.getChildren()){
                    contractElementsList.add(condataSnapShot.getValue().toString());
                }

                ArrayAdapter conAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,contractElementsList);
                contractElementsListView.setAdapter(conAdapter);

                setDynamicHeight(contractElementsListView);

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
