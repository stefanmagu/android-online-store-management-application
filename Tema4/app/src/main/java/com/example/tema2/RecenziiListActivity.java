package com.example.tema2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecenziiListActivity extends AppCompatActivity {

    TextView tvNumeListaRecenzie;
    TextView tvTextListaRecenzie;
    TextView tvRatingListaRecenzie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recenzii_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNumeListaRecenzie = findViewById(R.id.tvNumeListaRecenzie);
        tvTextListaRecenzie = findViewById(R.id.tvTextListaRecenzie);
        tvRatingListaRecenzie = findViewById(R.id.tvRatingListaRecenzie);

        Intent intent = getIntent();
        Recenzie recenzie = (Recenzie) intent.getSerializableExtra("recenzie");
        Log.i("Recenzie",recenzie.toString());

        tvNumeListaRecenzie.setText(recenzie.getNume());
        tvTextListaRecenzie.setText(recenzie.getRecenzie());
        tvRatingListaRecenzie.setText(recenzie.getRating() + "/5.0");

    }
}