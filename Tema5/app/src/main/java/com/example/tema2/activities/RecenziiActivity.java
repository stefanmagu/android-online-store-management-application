package com.example.tema2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema2.R;
import com.example.tema2.models.Recenzie;

public class RecenziiActivity extends AppCompatActivity {

    EditText etNumeRecenzie;
    EditText etTextRecenzie;
    RatingBar rbRating;
    Button btnSubmitRecenzie;

    ActivityResultLauncher<Intent> recenziiLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recenzii);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumeRecenzie = findViewById(R.id.etNumeRecenzie);
        etTextRecenzie = findViewById(R.id.etTextRecenzie);
        rbRating = findViewById(R.id.rbRating);
        btnSubmitRecenzie = findViewById(R.id.btnSubmitRecenzie);

        recenziiLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            // nu primim nimic inapoi
        });

        btnSubmitRecenzie.setOnClickListener(view ->{
            Recenzie recenzie = new Recenzie(
                    etNumeRecenzie.getText().toString(),
                    etTextRecenzie.getText().toString(),
                    rbRating.getRating()
            );

            Intent intent = new Intent(getApplicationContext(), RecenziiListActivity.class);
            intent.putExtra("recenzie",recenzie);

            recenziiLauncher.launch(intent);
        });

    }

}