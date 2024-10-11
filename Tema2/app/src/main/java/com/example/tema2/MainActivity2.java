package com.example.tema2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private Button button;

    private boolean isShowingCats = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            if (isShowingCats) {
                imageView1.setImageResource(R.drawable.dog1);
                imageView2.setImageResource(R.drawable.dog2);
                imageView3.setImageResource(R.drawable.dog3);
                imageView4.setImageResource(R.drawable.dog4);
                imageView5.setImageResource(R.drawable.dog5);
            } else {
                imageView1.setImageResource(R.drawable.pisica1);
                imageView2.setImageResource(R.drawable.pisica2);
                imageView3.setImageResource(R.drawable.pisica3);
                imageView4.setImageResource(R.drawable.pisica4);
                imageView5.setImageResource(R.drawable.pisica5);
            }
            isShowingCats = !isShowingCats;
        });
    }
}
