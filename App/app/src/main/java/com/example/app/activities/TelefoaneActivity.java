package com.example.app.activities;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app.R;
import com.example.app.adapters.TelefoaneAdapter;
import com.example.app.httpsManagers.HttpsManager;
import com.example.app.models.Telefon;
import com.example.app.parsers.TelefonJsonParser;

import java.util.ArrayList;
import java.util.List;

public class TelefoaneActivity extends AppCompatActivity {

    private static List<Telefon> telefoane = new ArrayList<>();
    private ListView lvTelefoane;
    private final String jsonURL = "https://jsonkeeper.com/b/41DF";

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



        lvTelefoane = findViewById(R.id.lvTelefoane);

        TelefoaneAdapter adapter = new TelefoaneAdapter(getApplicationContext(),R.layout.view_produs,telefoane,getLayoutInflater());
        lvTelefoane.setAdapter(adapter);

        lvTelefoane.setOnItemClickListener((parent, view, position, id) -> {
            String text = "Ai achizitionat produsul " + telefoane.get((int)id).getNume()+"!";
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(jsonURL);
                String rezultat = httpsManager.procesare();

                runOnUiThread(() -> {
                    telefoane.clear();
                    telefoane.addAll(TelefonJsonParser.getTelefoane(rezultat));
                    adapter.notifyDataSetChanged();
                });
            }
        };
        thread.start();

    }
}