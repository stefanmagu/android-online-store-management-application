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
import com.example.tema2.roomDatabases.AppRoomDB;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recenzii);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


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

        SharedPreferences sharedPreferences = getSharedPreferences("dateUtilizatorLogat", MODE_PRIVATE);
        String numeUtilizatorLogat = sharedPreferences.getString("nume", "SharedPreferencesNumeError");
        String prenumeUtilizatorLogat = sharedPreferences.getString("prenume", "SharedPreferencesPrenumeError");
        String parolaUtilizatorLogat = sharedPreferences.getString("parola", "SharedPreferencesParolaError");

        tvNumeUtilizatorLogat.setText("Account:" + numeUtilizatorLogat + " " + prenumeUtilizatorLogat);

        btnSubmitRecenzie.setOnClickListener(view -> {
            String nume = etNumeRecenzie.getText().toString();
            String text = etTextRecenzie.getText().toString();
            float rating = rbRating.getRating();

            AppRoomDB dbInstance = AppRoomDB.getInstance(getApplicationContext());

            int idUtilizator = dbInstance.getUtilizatorDAO().getIdUtilizator(numeUtilizatorLogat, prenumeUtilizatorLogat, parolaUtilizatorLogat);
            Recenzie recenzie = new Recenzie(nume, text, rating, idUtilizator);

            if (isEditing) {
                recenzie.setIdRecenzie(recenzieToEdit.getIdRecenzie());
                dbInstance.getRecenzieDAO().updateRecenzie(recenzie);
            } else {
                dbInstance.getRecenzieDAO().insertRecenzie(recenzie);
            }

            setResult(RESULT_OK);
            finish();
        });
    }
}