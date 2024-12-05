package com.example.tema2.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.adapters.LaptopuriAdapter;
import com.example.tema2.httpsManagers.HttpsManager;
import com.example.tema2.models.Laptop;
import com.example.tema2.parsers.LaptopJsonParser;
import com.example.tema2.parsers.TelefonJsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaptopuriActivity extends AppCompatActivity {

    private static List<Laptop> laptopuri = new ArrayList<>();
    private ListView lvLaptopuri;
    private final String jsonURL = "https://www.jsonkeeper.com/b/9NST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_laptopuri);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        lvLaptopuri = findViewById(R.id.lvLaptopuri);

        LaptopuriAdapter adapter = new LaptopuriAdapter(getApplicationContext(),R.layout.view_produs,laptopuri,getLayoutInflater());
        lvLaptopuri.setAdapter(adapter);

        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(jsonURL);
                String rezultat = httpsManager.procesare();

                runOnUiThread(() -> {
                    laptopuri.clear();
                    laptopuri.addAll(LaptopJsonParser.getTelefoane(rezultat));
                    adapter.notifyDataSetChanged();
                });
            }
        };
        thread.start();


    }
}