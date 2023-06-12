    package com.example.finalpjt;

    import android.annotation.SuppressLint;
    import android.os.Bundle;
    import android.view.View;
    import android.webkit.WebSettings;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import android.widget.Button;


    public class PrecautionsActivity extends MainActivity{
        private WebView webView;
        Button turn;

        @SuppressLint("MissingInflatedId")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_precaution);

            webView = findViewById(R.id.webView3);
            turn = findViewById(R.id.turn4);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView.setWebViewClient(new WebViewClient());

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {

                }
            });

            webView.loadUrl("https://www.safe182.go.kr/cont/homeLogContents.do?contentsNm=182_miss_main");

            turn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
