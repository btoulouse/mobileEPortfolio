package com.example.portfolio;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porfolio.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Create extends AppCompatActivity {
    private static String FILE_NAME = null;

    EditText fEditText;
    EditText cEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Sets text boxes to variables
       fEditText = findViewById(R.id.fileName);
       cEditText = findViewById(R.id.fileContent);

    }

    public void save(View v) {
        //converts user entered text to string
        String name = fEditText.getText().toString();
        String content = cEditText.getText().toString();
        FILE_NAME = name + ".txt";
        String nLine = "\n";

        try {
            // Writes to file
            FileWriter myOutWriter = new FileWriter(getFilesDir() + "/" + FILE_NAME, true);
            myOutWriter.write(content);
            myOutWriter.write(nLine);
            myOutWriter.close();

            // Cleares boexs
            fEditText.getText().clear();
            cEditText.getText().clear();
            // confirms path and that file has been written to
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(View v) {
        FileInputStream fis;
        // sets FILE_NAME to user entered text
        String name = fEditText.getText().toString();
        FILE_NAME = name + ".txt";
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            //loop through file saving to sb variable
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            // Loads content from variable into text view
            cEditText.setText(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function For testing Uncomment when needed
    /*
    private void showToast (String text) {
        Toast.makeText(Create.this, text, Toast.LENGTH_SHORT).show();
    }
    */
}
