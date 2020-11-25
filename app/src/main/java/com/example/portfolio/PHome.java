package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.porfolio.R;

public class PHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_home);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String url = intent.getStringExtra("url");
        Intent intent2 = new Intent(getApplicationContext(), CreateContent.class);
        String link = intent.getStringExtra("link");
        Intent intent3 = new Intent(getApplicationContext(), LinkedActivity.class);

        // View Button Press
        Button mButton = findViewById(R.id.webPage);
        mButton.setOnClickListener(view -> {
            intent2.putExtra("url", url);
            // start the Intent
            startActivity(intent2);
        });
        // Map Button Press
        Button qButton = findViewById(R.id.mapButton);
        qButton.setOnClickListener(view -> startActivity(new Intent(PHome.this, MapsActivity.class)));
        // LinkedIn Button Press
        Button lButton = findViewById(R.id.linkButton);
        lButton.setOnClickListener(view -> {
            intent3.putExtra("link", link);
            // start the Intent
            startActivity(intent3);
        });
        // Calendar Button Press
        Button cButton = findViewById(R.id.calendarButton);
        cButton.setOnClickListener(view -> startActivity(new Intent(PHome.this, Calendar.class)));
        // Bio Button Press
        Button fButton = findViewById(R.id.createBio);
        fButton.setOnClickListener(view -> startActivity(new Intent(PHome.this, Create.class)));
        // Log Out Button Press
        Button hButton = findViewById(R.id.logOutP);
        hButton.setOnClickListener(view -> startActivity(new Intent(PHome.this, MainActivity.class)));

    }
}
