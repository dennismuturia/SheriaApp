package com.sheriaapp.dennis.sheriaapp.ui.Police;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.sheriaapp.dennis.sheriaapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArrestedRights extends Fragment {
    private DatabaseReference mArrestedRights;
    private ArrayList<String> arrestedRightsList = new ArrayList<>();
    private ListView arrestedRightsListView;




    public ArrestedRights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_arrested_rights, container, false);

        return rootView;
    }

}
