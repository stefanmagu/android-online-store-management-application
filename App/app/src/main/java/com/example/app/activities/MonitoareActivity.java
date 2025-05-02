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
import com.example.app.adapters.MonitoareAdapter;
import com.example.app.httpsManagers.HttpsManager;
import com.example.app.models.Monitor;
import com.example.app.parsers.MonitorJsonParser;

import java.util.ArrayList;
import java.util.List;

public class MonitoareActivity extends AppCompatActivity {
    private final String jsonURL = "https://jsonkeeper.com/b/FGFQ";
    private ListView lvMonitoare;
    private static List<Monitor> monitoare = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monitoare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMonitoare = findViewById(R.id.lvMonitoare);

        MonitoareAdapter adapter = new MonitoareAdapter(getApplicationContext(),R.layout.view_produs,monitoare,getLayoutInflater());
        lvMonitoare.setAdapter(adapter);

        lvMonitoare.setOnItemClickListener((parent, view, position, id) -> {
            String text = "Ai achizitionat produsul " + monitoare.get((int)id).getNume()+"!";
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(jsonURL);
                String rezultat = httpsManager.procesare();

                runOnUiThread(() -> {
                    monitoare.clear();
                    monitoare.addAll(MonitorJsonParser.getMonitoare(rezultat));
                    adapter.notifyDataSetChanged();
                });
            }
        };
        thread.start();

    }
}