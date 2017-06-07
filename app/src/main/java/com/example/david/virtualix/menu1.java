package com.example.david.virtualix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.david.virtualix.R.id.mcwebview;

public class menu1 extends Fragment {

    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.miscursos, container, false);

        wv = (WebView) V.findViewById(mcwebview);


        wv.setWebViewClient(new MyCustomWebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);

        wv.loadUrl("file:///android_asset/www/principal.html");
        return V;
    }

    private class MyCustomWebViewClient extends WebViewClient {

        public boolean shouldOvrrideLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
