package com.example.portfolio;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porfolio.R;

public class CreateContent extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String url = intent.getStringExtra("url");

        // Code that opens up web page from userDB
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://" + url);
    }

    // For testing!!!! Uncomment when needed
    /*
    private void showToast (String text) {
        Toast.makeText(com.example.portfolio.CreateContent.this, text, Toast.LENGTH_SHORT).show();
    }
     */
}