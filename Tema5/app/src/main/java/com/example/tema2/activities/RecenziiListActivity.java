package com.example.tema2.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.adapters.RecenziiAdapter;
import com.example.tema2.models.Recenzie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecenziiListActivity extends AppCompatActivity {

    private static List<Recenzie> recenziiList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_recenzii);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        FloatingActionButton fabReturnRecenziiList = findViewById(R.id.fabReturnRecenziiList);
        ListView lvRecenzii = findViewById(R.id.lvRecenzii);
        Recenzie recenzie;


        recenzie = (Recenzie) getIntent().getSerializableExtra("recenzie");
        if(recenzie != null){
            recenziiList.add(recenzie);
        }

        RecenziiAdapter adapter = new RecenziiAdapter(getApplicationContext(),R.layout.view_recenzie,recenziiList,getLayoutInflater());
        lvRecenzii.setAdapter(adapter);

        fabReturnRecenziiList.setOnClickListener(view -> {
            finish();
        });


    }
}