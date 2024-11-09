package com.example.tema2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    ListView lvRecenzii;
    private int pozitieRecenzieInLista = -1;
    ActivityResultLauncher<Intent> recenziiLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recenzii);

        FloatingActionButton fabAddRecenziiList = findViewById(R.id.fabAddRecenziiList);
        lvRecenzii = findViewById(R.id.lvRecenzii);

        RecenziiAdapter adapter = new RecenziiAdapter(this, R.layout.view_recenzie, recenziiList, getLayoutInflater());
        lvRecenzii.setAdapter(adapter);

        recenziiLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Intent data = result.getData();

                if (data.hasExtra("edit")) { // edit
                    Recenzie editedRecenzie = (Recenzie) data.getSerializableExtra("edit");
                    if (pozitieRecenzieInLista != -1) {
                        recenziiList.set(pozitieRecenzieInLista, editedRecenzie);
                        pozitieRecenzieInLista = -1;
                    }
                } else if (data.hasExtra("recenzie")) { // add
                    Recenzie newRecenzie = (Recenzie) data.getSerializableExtra("recenzie");
                    recenziiList.add(newRecenzie);
                }
                adapter.notifyDataSetChanged();
            }
        });

        fabAddRecenziiList.setOnClickListener(view -> {
            Intent addIntent = new Intent(getApplicationContext(), RecenziiActivity.class);
            recenziiLauncher.launch(addIntent);
        });

        lvRecenzii.setOnItemClickListener((adapterView, view, position, l) -> {
            pozitieRecenzieInLista = position;
            Intent editIntent = new Intent(getApplicationContext(), RecenziiActivity.class);
            editIntent.putExtra("edit", recenziiList.get(pozitieRecenzieInLista));
            recenziiLauncher.launch(editIntent);
        });
    }
}