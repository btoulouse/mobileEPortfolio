package com.example.portfolio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porfolio.R;

public class MainActivity extends AppCompatActivity {

    //Global Variables
    final PDBHandler dbHandler = new PDBHandler(this, null, null, 2);
    EditText mUserName;
    EditText pPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets user entered text to variable
        mUserName = findViewById(R.id.userName);
        pPassword = findViewById(R.id.password);

        // About Us Button Press
        Button aButton = findViewById(R.id.aboutUs);
        aButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AboutUs.class)));
        //End About Us button press

        // Create Profile Button Press
        Button cButton = findViewById(R.id.createProfile);
        cButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CreateProfile.class)));
        // End Create Profile button press

        // initiate a rating bar & get rating number from a rating bar
        final RatingBar simpleRatingBar = findViewById(R.id.ratingBar);
        final float ratingNumber = simpleRatingBar.getRating();

        // Rate Us Button Press
        Button rButton = findViewById(R.id.rateUs);
        rButton.setOnClickListener(view -> {
            simpleRatingBar.setRating(ratingNumber);
            Toast.makeText(MainActivity.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
        });
        // End Rate Us button press
    }

    // Function to check if entered username/ password are found. If so Open to User Database
    @SuppressLint("SetTextI18n")
    public void load(View v) {

        // user entered text to string
        String name = mUserName.getText().toString();
        String pass = pPassword.getText().toString();

        Portfolio user = dbHandler.searchUser(name);

        if (user.getName().equals(name) && user.getPass().equals(pass))
        {
            Intent intent = new Intent(getApplicationContext(), UserDataBaseInfo.class);
            intent.putExtra("Login", name);
            // start the Intent
            startActivity(intent);
        }
        else if (!user.getName().equals(name) || !user.getPass().equals(pass)
                    || user.getName().equals(null) || user.getPass().equals(null))
        {
            showToast("Profile not Found");
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
    }

    // Pop up to display message
    private void showToast (String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}

