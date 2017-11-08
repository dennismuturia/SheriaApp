package com.sheriaapp.dennis.sheriaapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.sheriaapp.dennis.sheriaapp.R;

public class FindLawyer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_lawyer);

        WebView myWebView = new WebView(this);
        setContentView(myWebView);

        String url = "http://online.lsk.or.ke/index.php/advocate-by-specialisation";

        myWebView.loadUrl(url);
    }
}
