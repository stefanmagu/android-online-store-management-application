package com.example.tema2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.models.Utilizator;

public class ProduseActivity extends AppCompatActivity {

    Toolbar categoriiToolbar;
    TextView tvWelcome;
    LinearLayout llTelefon;
    LinearLayout llLaptop;
    LinearLayout llFrigider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produse);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        categoriiToolbar = findViewById(R.id.tbCategorii);
        categoriiToolbar.setTitle("Categorii");
        setSupportActionBar(categoriiToolbar);

        Intent intent = getIntent();
        Utilizator utilizator = (Utilizator) intent.getSerializableExtra("data");

        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText("Welcome " + utilizator.getNume() + " " + utilizator.getPrenume() + "!");

        llTelefon = findViewById(R.id.llTelefon);
        llLaptop = findViewById(R.id.llLaptop);
        llFrigider = findViewById(R.id.llFrigider);

        llTelefon.setOnClickListener(view -> {
            Intent intentTelefon = new Intent(getApplicationContext(), TelefoaneActivity.class);
            startActivity(intentTelefon);
        });

        llLaptop.setOnClickListener(view -> {
            Intent intentLaptop = new Intent(getApplicationContext(), LaptopuriActivity.class);
            startActivity(intentLaptop);
        });

        llFrigider.setOnClickListener(view -> {
            //TO DO: acelasi lucru ca eventurile pentru llTelefon si llLaptop
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categorii_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.idLogOutMenu) {
            finish();
        }
        if (item.getItemId() == R.id.idRecenzieMenu) {
            Intent intent = new Intent(getApplicationContext(), RecenziiActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.idVouchereMenu) {
            Intent intent = new Intent(getApplicationContext(), VouchereActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
