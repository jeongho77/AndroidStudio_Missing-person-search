package com.example.finalpjt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class SelectActivity extends MainActivity{
    private WebView webView2;
    Button turn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        webView2 = findViewById(R.id.webView2);
        turn = findViewById(R.id.turn3);

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView2.setWebViewClient(new WebViewClient());

        webView2.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

        webView2.loadUrl("https://www.safe182.go.kr/home/lcm/lcmMssList.do?rptDscd=2");

        turn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
