package com.example.app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app.R;
import com.example.app.models.Utilizator;
import com.example.app.roomDatabases.AppRoomDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> launcher;
    List<Utilizator> utilizatori = new ArrayList<>();

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
        EditText etNume = findViewById(R.id.etNume);
        EditText etPrenume = findViewById(R.id.etPrenume);
        EditText etParola = findViewById(R.id.etParola);
        Button btnRegister = findViewById(R.id.btnRegister);

        etNume.setText("Magu");
        etPrenume.setText("Stefan");
        etParola.setText("Parola");

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            // neimplementat
            // nu primim nimic din ProduseActivity
        });

        btnSubmit.setOnClickListener(event -> {
            String nume = etNume.getText().toString();
            String prenume = etPrenume.getText().toString();
            String parola = etParola.getText().toString();

            if(nume.isEmpty() || prenume.isEmpty() || parola.isEmpty()) {
                Toast.makeText(this, "Completeaza toate campurile!", Toast.LENGTH_LONG).show();
                return;
            }

            Utilizator utilizator = new Utilizator(nume,prenume,parola);
            createSharedPreferencesUtilizator(utilizator);

            if(utilizatorExists(utilizator)) {
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ProduseActivity.class);
                intent.putExtra("data",utilizator);
                launcher.launch(intent);
            } else{
                Toast.makeText(this, "Nume sau parola gresita!", Toast.LENGTH_SHORT).show();
            }

        });

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });


    }

    public boolean utilizatorExists(Utilizator utilizator){
        AppRoomDB dbInstance = AppRoomDB.getInstance(getApplicationContext());
        utilizatori = dbInstance.getUtilizatorDAO().getUtilizatori();

       return utilizatori.contains(utilizator);
    }

    public void createSharedPreferencesUtilizator(Utilizator utilizator){
        SharedPreferences sharedPreferences = getSharedPreferences("dateUtilizatorLogat",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nume",utilizator.getNume());
        editor.putString("prenume",utilizator.getPrenume());
        editor.putString("parola",utilizator.getParola());

        editor.apply();
    }
}