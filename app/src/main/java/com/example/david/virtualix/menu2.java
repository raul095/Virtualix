package com.example.david.virtualix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class menu2 extends Fragment {

    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.home, container, false);
        wv = (WebView) V.findViewById(R.id.hwebview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/www/home.html");
        return V;
    }
}
