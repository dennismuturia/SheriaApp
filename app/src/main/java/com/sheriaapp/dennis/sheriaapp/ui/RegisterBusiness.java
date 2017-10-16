package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sheriaapp.dennis.sheriaapp.R;


public class RegisterBusiness extends Fragment {

    public RegisterBusiness() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register_business, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }


}
