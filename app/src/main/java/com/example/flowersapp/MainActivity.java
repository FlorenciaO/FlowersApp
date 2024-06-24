package com.example.flowersapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.flowers.Flower;
import com.example.flowersapp.flowers.FlowersAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView floresRV;
    private FlowersAdapter flowersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAdapter();
    }

    private void setupAdapter() {
        floresRV = findViewById(R.id.flower_recycler_view);

        flowersAdapter = new FlowersAdapter(new FlowersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Flower flor) {
                // TODO(1. Abrir DetallersFlowerActivity con la flor como parametro)
            }
        });

        floresRV.setAdapter(flowersAdapter);
        flowersAdapter.setLibros(getLibros());
    }

    private List<Flower> getLibros() {
        return new ArrayList<Flower>() {{
            add(new Flower(1, getString(R.string.flor1_nombre), getString(R.string.flor1_desc), Flower.ImagenId.FLOR1));
            add(new Flower(2,getString(R.string.flor2_nombre), getString(R.string.flor2_desc), Flower.ImagenId.FLOR2));
            add(new Flower(3, getString(R.string.flor3_nombre), getString(R.string.flor3_desc), Flower.ImagenId.FLOR3));
        }};
    }
}
