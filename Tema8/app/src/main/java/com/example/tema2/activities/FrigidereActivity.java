package com.example.tema2.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.adapters.FrigidereAdapter;
import com.example.tema2.adapters.TelefoaneAdapter;
import com.example.tema2.httpsManagers.HttpsManager;
import com.example.tema2.models.Frigider;
import com.example.tema2.parsers.FrigiderJsonParser;
import com.example.tema2.parsers.TelefonJsonParser;

import java.util.ArrayList;
import java.util.List;

public class FrigidereActivity extends AppCompatActivity {

    private ListView lvFrigidere;
    private List<Frigider> frigidere = new ArrayList<>();
    private final  String jsonURL = "https://www.jsonkeeper.com/b/GTN8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frigidere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvFrigidere = findViewById(R.id.lvFrigidere);

        FrigidereAdapter adapter = new FrigidereAdapter(getApplicationContext(),R.layout.view_produs,frigidere,getLayoutInflater());
        lvFrigidere.setAdapter(adapter);

        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(jsonURL);
                String rezultat = httpsManager.procesare();

                runOnUiThread(() -> {
                    frigidere.clear();
                    frigidere.addAll(FrigiderJsonParser.getfrigidere(rezultat));
                    adapter.notifyDataSetChanged();
                });
            }
        };
        thread.start();
    }
}