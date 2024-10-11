package com.example.tema2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText etName = findViewById(R.id.etName);
        EditText etPrenume = findViewById(R.id.etPrenume);
        EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);


        btnSubmit.setOnClickListener(event -> {
            String showedText = "Nume: " + etName.getText().toString() +
                    " Prenume: " + etPrenume.getText().toString() +
                    " Numar telefon: " + etPhoneNumber.getText().toString();
            Toast.makeText(this, showedText, Toast.LENGTH_LONG).show();
        });
    }
}