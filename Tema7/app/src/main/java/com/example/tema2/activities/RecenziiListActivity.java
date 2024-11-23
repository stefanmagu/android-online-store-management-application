package com.example.tema2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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
import com.example.tema2.models.Utilizator;
import com.example.tema2.roomDatabases.AppRoomDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecenziiListActivity extends AppCompatActivity {
    private static List<Recenzie> recenziiList = new ArrayList<>();
    ListView lvRecenzii;
    private int pozitieRecenzieInLista = -1;
    ActivityResultLauncher<Intent> recenziiLauncher;
    TextView tvNameOfListView;

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

        tvNameOfListView = findViewById(R.id.tvNameOfListView);
        SharedPreferences sharedPreferences = getSharedPreferences("dateUtilizatorLogat", MODE_PRIVATE);
        String numeUtilizatorLogat = sharedPreferences.getString("nume", "SharedPreferencesNumeError");
        String prenumeUtilizatorLogat = sharedPreferences.getString("prenume", "SharedPreferencesPrenumeError");

        String detaliiReview = tvNameOfListView.getText() + " " + numeUtilizatorLogat + " " + prenumeUtilizatorLogat;
        tvNameOfListView.setText(detaliiReview);

        FloatingActionButton fabAddRecenziiList = findViewById(R.id.fabAddRecenziiList);
        lvRecenzii = findViewById(R.id.lvRecenzii);

        populateListByUserLogged();
        RecenziiAdapter adapter = new RecenziiAdapter(this, R.layout.view_recenzie, recenziiList, getLayoutInflater());
        lvRecenzii.setAdapter(adapter);

        recenziiLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                populateListByUserLogged();
                adapter.clear();
                adapter.addAll(recenziiList);
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
        lvRecenzii.setOnItemLongClickListener((adapterView, view, position, id) -> {
            AppRoomDB dbInstance = AppRoomDB.getInstance(getApplicationContext());

            Recenzie selectedRecenzie = recenziiList.get(position);

            dbInstance.getRecenzieDAO().deleteRecenzie(selectedRecenzie.getIdRecenzie());

            populateListByUserLogged();

            RecenziiAdapter adapter1 = (RecenziiAdapter) lvRecenzii.getAdapter();
            adapter1.clear();
            adapter1.addAll(recenziiList);
            adapter1.notifyDataSetChanged();

            Toast.makeText(this, "Review deleted", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    public void populateListByUserLogged() {
        SharedPreferences sharedPreferences = getSharedPreferences("dateUtilizatorLogat", MODE_PRIVATE);
        String numeUtilizatorLogat = sharedPreferences.getString("nume", "SharedPreferencesNumeError");
        String prenumeUtilizatorLogat = sharedPreferences.getString("prenume", "SharedPreferencesPrenumeError");
        String parolaUtilizatorLogat = sharedPreferences.getString("parola", "SharedPreferencesParolaError");

        AppRoomDB instance = AppRoomDB.getInstance(getApplicationContext());
        int idUtilizatorLogat = instance.getUtilizatorDAO().getIdUtilizator(numeUtilizatorLogat, prenumeUtilizatorLogat, parolaUtilizatorLogat);
        recenziiList = instance.getRecenzieDAO().getRecenziiUtilizatorLogged(idUtilizatorLogat);
    }
}