package com.example.tema2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.models.Recenzie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecenziiActivity extends AppCompatActivity {
    EditText etNumeRecenzie;
    EditText etTextRecenzie;
    RatingBar rbRating;
    Button btnSubmitRecenzie;

    boolean isEditing = false;
    Recenzie recenzieToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recenzii);

        etNumeRecenzie = findViewById(R.id.etNumeRecenzie);
        etTextRecenzie = findViewById(R.id.etTextRecenzie);
        rbRating = findViewById(R.id.rbRating);
        btnSubmitRecenzie = findViewById(R.id.btnSubmitRecenzie);

        Intent intent = getIntent();
        if (intent.hasExtra("edit")) {
            isEditing = true;
            recenzieToEdit = (Recenzie) intent.getSerializableExtra("edit");

            etNumeRecenzie.setText(recenzieToEdit.getNume());
            etTextRecenzie.setText(recenzieToEdit.getRecenzie());
            rbRating.setRating(recenzieToEdit.getRating());
        }

        TextView tvNumeUtilizatorLogat = findViewById(R.id.tvNumeUtilizatorLogat);

        SharedPreferences sharedPreferences = getSharedPreferences("dateUtilizator", MODE_PRIVATE);
        String numeUtilizatorLogat = sharedPreferences.getString("nume", "SharedPreferencesNumeError");
        String prenumeUtilizatorLogat = sharedPreferences.getString("prenume", "SharedPreferencesPrenumeError");

        tvNumeUtilizatorLogat.setText("Account:" + numeUtilizatorLogat + " " + prenumeUtilizatorLogat);


        btnSubmitRecenzie.setOnClickListener(view -> {
            String nume = etNumeRecenzie.getText().toString();
            String text = etTextRecenzie.getText().toString();
            float rating = rbRating.getRating();

            Recenzie recenzie = new Recenzie(nume, text, rating);

            Intent resultIntent = new Intent();
            if (isEditing) {
                resultIntent.putExtra("edit", recenzie);
            } else {
                resultIntent.putExtra("recenzie", recenzie);
            }
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}