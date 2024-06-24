package com.example.flowersapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowersapp.flowers.Flower;

public class DetallesFlowerActivity extends AppCompatActivity {

    public static final String KEY_PARAM_FLOWER = "FLOWER";

    private ImageView imageView;
    private TextView nombreTv;
    private TextView descTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_flower);

        imageView = findViewById(R.id.flor_image_view);
        nombreTv = findViewById(R.id.flor_nombre_text_view);
        descTv = findViewById(R.id.flor_desc_text_view);

        setupUI();
    }

    private void setupUI() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Flower flor = (Flower) bundle.getSerializable(KEY_PARAM_FLOWER);
            switch (flor.getImagenId()) {
                case FLOR1:
                    imageView.setImageResource(R.drawable.flor1);
                    break;
                case FLOR2:
                    imageView.setImageResource(R.drawable.flor2);
                    break;
                case FLOR3:
                    imageView.setImageResource(R.drawable.flor3);
                    break;
                case FLOR4:
                    imageView.setImageResource(R.drawable.flor4);
                    break;
                case PLACEHOLDER:
                    imageView.setImageResource(R.drawable.placeholder);
                    break;
            }
            nombreTv.setText(flor.getNombre());
            descTv.setText(flor.getDescripcion());
        }
    }
}
