package com.example.tema2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProduseActivity extends AppCompatActivity {

    Toolbar categoriiToolbar;
    TextView tvWelcome;

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
        tvWelcome.setText("Welcome " + utilizator.getNume() +" "+ utilizator.getPrenume()+"!");
       // Toast.makeText(this, "Received: " + utilizator.getNume() + " " + utilizator.getPrenume()+ "  " + utilizator.getParola(), Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categorii_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.idLogOutMenu){
            finish();
        }
        if(item.getItemId() == R.id.idRecenzieMenu){
            Intent intent = new Intent(getApplicationContext(),RecenziiActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.idVouchereMenu){
            Intent intent = new Intent(getApplicationContext(),VouchereActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
