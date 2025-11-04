package com.example.aplikacja;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button przyciskPrev, przyciskNext;
    private EditText poleNumer;
    private Switch przelacznikTlo;
    private ImageView obrazek;
    private LinearLayout glowneTlo;
    private int[] obrazy = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4};
    private int aktualny = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glowneTlo = findViewById(R.id.main);
        obrazek = findViewById(R.id.imageView2);
        przyciskPrev = findViewById(R.id.buttonPrev);
        przyciskNext = findViewById(R.id.buttonNext);
        poleNumer = findViewById(R.id.ImageNumber);
        przelacznikTlo = findViewById(R.id.switchBlue);

        obrazek.setImageResource(obrazy[aktualny]);
        poleNumer.setText("" + (aktualny + 1));

        przyciskPrev.setOnClickListener(v -> {
            aktualny--;
            if (aktualny < 0) aktualny = obrazy.length - 1;
            obrazek.setImageResource(obrazy[aktualny]);
            poleNumer.setText("" + (aktualny + 1));
        });

        przyciskNext.setOnClickListener(v -> {
            aktualny++;
            if (aktualny >= obrazy.length) aktualny = 0;
            obrazek.setImageResource(obrazy[aktualny]);
            poleNumer.setText("" + (aktualny + 1));
        });



        przelacznikTlo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                glowneTlo.setBackgroundColor(Color.parseColor("#1565c0"));
            } else {
                glowneTlo.setBackgroundColor(Color.parseColor("#00796B"));
            }
        });
    }
}