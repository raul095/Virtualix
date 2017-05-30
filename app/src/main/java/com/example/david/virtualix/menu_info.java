package com.example.david.virtualix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;

/**
 * Created by David on 29/05/2017.
 */

public class menu_info extends Fragment {

    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.info_fp, container, false);

        wv = (WebView) V.findViewById(R.id.webview);
        wv.loadUrl("file:///android_asset/www/info1.html");
        return V;
    }
}