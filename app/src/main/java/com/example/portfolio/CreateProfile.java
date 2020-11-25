package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porfolio.R;

public class CreateProfile extends AppCompatActivity {

    TextView idView;
    EditText nameBox;
    EditText passBox;
    EditText phoneBox;
    EditText addressBox;
    EditText emailBox;
    EditText faceBox;
    EditText urlBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Sets user entered input to variables
        idView = findViewById(R.id.userID);
        nameBox = findViewById(R.id.userName);
        passBox = findViewById(R.id.userPass);
        phoneBox = findViewById(R.id.userPhone);
        addressBox = findViewById(R.id.userAddress);
        emailBox = findViewById(R.id.userEmail);
        faceBox = findViewById(R.id.userLink);
        urlBox = findViewById(R.id.userURL);

        final PDBHandler dbHandler = new PDBHandler(this, null, null, 2);

        // ADD USER  Button*************************
        Button aButton = findViewById(R.id.addUser);
        aButton.setOnClickListener(view -> {

            // Saves user entered data into Portfolio class
            Portfolio user = new Portfolio(nameBox.getText().toString(),passBox.getText().toString(),phoneBox.getText().toString(),
                    addressBox.getText().toString(), emailBox.getText().toString(), faceBox.getText().toString(),
                    urlBox.getText().toString());

            dbHandler.addUser(user);
            nameBox.setText("");
            passBox.setText("");
            phoneBox.setText("");
            addressBox.setText("");
            emailBox.setText("");
            faceBox.setText("");
            urlBox.setText("");
            showToast("Profile Created");
        });
        // Return Home Button Press
        Button hButton = findViewById(R.id.returnHome);
        hButton.setOnClickListener(view -> startActivity(new Intent(CreateProfile.this, MainActivity.class)));
    }

    // Pop up to display message
    private void showToast (String text) {
        Toast.makeText(CreateProfile.this, text, Toast.LENGTH_SHORT).show();
    }
}
