package com.example.portfolio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porfolio.R;

public class UserDataBaseInfo extends AppCompatActivity {

    EditText nameBox;
    EditText phoneBox;
    EditText addressBox;
    EditText emailBox;
    EditText linkBox;
    EditText urlBox;

    final PDBHandler dbHandler = new PDBHandler(this, null, null, 2);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_database_info);

        // Log Out Button Press
        Button hButton = findViewById(R.id.logOut);
        hButton.setOnClickListener(view -> startActivity(new Intent(UserDataBaseInfo.this, MainActivity.class)));

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String name = intent.getStringExtra("Login");

        // Sets text fields to variables
        nameBox = findViewById(R.id.editText3);
        phoneBox = findViewById(R.id.editText4);
        addressBox = findViewById(R.id.editText5);
        emailBox = findViewById(R.id.editText6);
        linkBox = findViewById(R.id.editText7);
        urlBox = findViewById(R.id.editText8);

        Portfolio user = dbHandler.searchUser(name);

        // Populates text fields to User info
        nameBox.setText(user.getName());
        phoneBox.setText((user.getPhone()));
        addressBox.setText(user.getAddress());
        emailBox.setText(user.getEmail());
        linkBox.setText(user.getLink());
        urlBox.setText(user.getUrl());

        Intent intent2 = new Intent(getApplicationContext(), PHome.class);

        // Continue Button Press
        Button aButton = findViewById(R.id.logIn);
        aButton.setOnClickListener(view -> {
            // Passes values to activity PHome
            intent2.putExtra("url", user.getUrl());
            intent2.putExtra("link", user.getLink());
            // start the Intent
            startActivity(intent2);
        });

        // DELETE USER FROM SQLite ****************************
        Button dButton = findViewById(R.id.removeUser);
        dButton.setOnClickListener(view -> {

            boolean result = dbHandler.deleteUser(user.getName());

            if (result)
            {
                showToast("User Deleted");
                startActivity(new Intent(UserDataBaseInfo.this, MainActivity.class));
            }
            else
                showToast("User not found.");
        });
    }

    // Pop up to display message
    private void showToast (String text) {
        Toast.makeText(UserDataBaseInfo.this, text, Toast.LENGTH_SHORT).show();
            }
}


