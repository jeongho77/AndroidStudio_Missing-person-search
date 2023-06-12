    package com.example.finalpjt;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.telephony.PhoneNumberFormattingTextWatcher;
    import android.view.View;
    import android.webkit.WebSettings;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import android.widget.Button;
    import android.widget.TextView;

    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;


    public class MainActivity extends AppCompatActivity {
        private WebView webView;
        TextView profileName, profileEmail, profileUsername, profilePassword, report;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");
            myRef.setValue("Success");


            webView = findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView.setWebViewClient(new WebViewClient());

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {

                }
            });

            webView.loadUrl("http://192.168.1.2:8080/JSP-2023/test3.jsp");

            Intent intent = getIntent();
            String nameUser = intent.getStringExtra("name");
            String emailUser = intent.getStringExtra("email");
            String usernameUser = intent.getStringExtra("username");
            String passwordUser = intent.getStringExtra("password");


            Button btnNewActivity = (Button) findViewById(R.id.Main_select);
            btnNewActivity.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent;

                    intent = new Intent(getApplicationContext(),
                           SelectActivity.class);

                    startActivity(intent);
                }
            });

            Button user = (Button) findViewById(R.id.Main_user);
            user.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.putExtra("name", nameUser);
                    intent.putExtra("email", emailUser);
                    intent.putExtra("username", usernameUser);
                    intent.putExtra("password", passwordUser);
                    startActivity(intent);
                }
            });

            Button btnNewActivity2 = (Button) findViewById(R.id.main_);
            btnNewActivity2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent;

                    intent = new Intent(getApplicationContext(),
                            PrecautionsActivity.class);

                    startActivity(intent);
                }
            });

            Button report = findViewById(R.id.report);
            report.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    String tel = "tel:182";

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel));
                    startActivity(intent);
                }
            });
        }
    }