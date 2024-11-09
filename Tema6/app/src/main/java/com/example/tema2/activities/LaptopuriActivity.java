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
import com.example.tema2.models.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaptopuriActivity extends AppCompatActivity {

    private static List<Laptop> laptopuri;
    private ListView lvLaptopuri;

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


        laptopuri = new ArrayList<>(Arrays.asList(
                new Laptop(1, "Laptop1", 123, 46, R.drawable.laptop),
                new Laptop(2, "Laptop2 gaming", 234, 374, R.drawable.laptop),
                new Laptop(3, "Laptop3", 87345, 45, R.drawable.laptop),
                new Laptop(5, "Laptop4", 6672.23f, 3, R.drawable.laptop),
                new Laptop(6, "Laptop5 pro", 456.27f, 83, R.drawable.laptop),
                new Laptop(7, "Laptop6", 8395.92f, 2, R.drawable.laptop)
        ));

        lvLaptopuri = findViewById(R.id.lvLaptopuri);

        LaptopuriAdapter adapter = new LaptopuriAdapter(getApplicationContext(),R.layout.view_produs,laptopuri,getLayoutInflater());
        lvLaptopuri.setAdapter(adapter);
    }
}