package com.example.tema2.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.models.Utilizator;
import com.example.tema2.roomDatabases.AppRoomDB;

public class RegisterActivity extends AppCompatActivity {

    Button btnBackToLogin;
    Button btnRegisterSubmit;
    EditText etRegisterNume;
    EditText etRegisterPrenume;
    EditText etRegisterParola;
    EditText etConfirmParola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etRegisterNume = findViewById(R.id.etRegisterNume);
        etRegisterPrenume = findViewById(R.id.etRegisterPrenume);
        etRegisterParola = findViewById(R.id.etRegisterParola);
        etConfirmParola = findViewById(R.id.etConfirmParola);

        btnBackToLogin = findViewById(R.id.btnBackToLogin);
        btnBackToLogin.setOnClickListener(view -> finish());

        btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);
        btnRegisterSubmit.setOnClickListener(view -> {
            if(etRegisterNume.getText().toString().isEmpty() || etRegisterPrenume.getText().toString().isEmpty() || etRegisterParola.getText().toString().isEmpty() || etConfirmParola.getText().toString().isEmpty()){
                Toast.makeText(this, "Unul din campuri este gol!", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!etRegisterParola.getText().toString().equals(etConfirmParola.getText().toString())){
                Toast.makeText(this, "Parolele nu sunt identice!", Toast.LENGTH_SHORT).show();
                return;
            }
            Utilizator utilizator = new Utilizator(
                    etRegisterNume.getText().toString(),
                    etRegisterPrenume.getText().toString(),
                    etConfirmParola.getText().toString()
            );
            AppRoomDB dbInstance = AppRoomDB.getInstance(getApplicationContext());
            boolean userExists = dbInstance.getUtilizatorDAO().userExists(utilizator.getNume(), utilizator.getPrenume(), utilizator.getParola()) > 0;

            if (userExists){
                Toast.makeText(this, "Utilizatorul deja exista!", Toast.LENGTH_SHORT).show();
            }else{
                dbInstance.getUtilizatorDAO().insertUtilizator(utilizator);
                Toast.makeText(this, "Utilizator inregistrat cu succes!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}