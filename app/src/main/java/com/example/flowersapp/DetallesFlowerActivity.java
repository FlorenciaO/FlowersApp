package com.example.flowersapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesFlowerActivity extends AppCompatActivity {

    public static final String KEY_PARAM_LIBRO = "LIBRO";

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
        // TODO(1. Obtener el libro desde el bundle)
        // TODO(2. Set up el source de image view segun tipo de ImageId)
        // TODO(3. Set up el nombre de la flor)
        // TODO(4. Set up la breve descripcion de la flor)
    }
}
