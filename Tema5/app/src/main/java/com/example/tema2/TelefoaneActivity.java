package com.example.tema2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelefoaneActivity extends AppCompatActivity {

    private static List<Telefon> telefoane;
    private ListView lvTelefoane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telefoane);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Telefon telefon = new Telefon(1,"Telefon",123,23,R.drawable.smartphone);
        telefoane = new ArrayList<>(Arrays.asList(
                new Telefon(1, "Telefon1", 123, 4, R.drawable.smartphone),
                new Telefon(2, "Telefon2 premium", 234, 374, R.drawable.smartphone),
                new Telefon(3, "Telefon3", 345, 5, R.drawable.smartphone),
                new Telefon(5, "Telefon4", 672.23f, 556, R.drawable.smartphone),
                new Telefon(6, "Telefon5", 156.27f, 853, R.drawable.smartphone),
                new Telefon(7, "Telefon6 premium", 395.92f, 8, R.drawable.smartphone)
        ));

        lvTelefoane = findViewById(R.id.lvTelefoane);

        TelefoaneAdapter adapter = new TelefoaneAdapter(getApplicationContext(),R.layout.view_produs,telefoane,getLayoutInflater());
        lvTelefoane.setAdapter(adapter);
    }
}