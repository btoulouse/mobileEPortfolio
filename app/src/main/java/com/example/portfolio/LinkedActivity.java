package com.example.portfolio;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.example.porfolio.R;

public class LinkedActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_in);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String link = intent.getStringExtra("link");

        // Code that opens up LinkedIn from userDB
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://" + link);
    }
    // For testing!!!! Uncomment when needed
/*
    private void showToast (String text) {
        Toast.makeText(com.example.portfolio.LinkedActivity.this, text, Toast.LENGTH_SHORT).show();
    }
 */
}