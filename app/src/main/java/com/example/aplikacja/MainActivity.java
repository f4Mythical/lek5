package com.example.aplikacja;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        poleNumer.addTextChangedListener(
                new android.text.TextWatcher() {
                    @Override
                    public void afterTextChanged(android.text.Editable editable) {
                        String tekst = editable.toString();
                        if (!tekst.isEmpty()) {
                            int numer = Integer.parseInt(tekst);
                            if (numer >= 1 && numer <= obrazy.length) {
                                aktualny = numer - 1;
                                obrazek.setImageResource(obrazy[aktualny]);
                            }else {
                                poleNumer.setText("" + (aktualny + 1));
                            }
                        }
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) { }
                }
        );




        przelacznikTlo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                glowneTlo.setBackgroundColor(Color.parseColor("#1565c0"));
            } else {
                glowneTlo.setBackgroundColor(Color.parseColor("#00796B"));
            }
        });
    }
}