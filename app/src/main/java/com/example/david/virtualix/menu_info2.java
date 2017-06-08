package com.example.david.virtualix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class menu_info2 extends Fragment {

    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.quienes_somos, container, false);
        wv = (WebView) V.findViewById(R.id.qswebview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/www/info2.html");
        return V;
    }
}