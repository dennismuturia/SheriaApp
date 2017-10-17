package com.sheriaapp.dennis.sheriaapp.ui.Police;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sheriaapp.dennis.sheriaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Arrested extends Fragment {


    public Arrested() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arrested, container, false);
    }

}
