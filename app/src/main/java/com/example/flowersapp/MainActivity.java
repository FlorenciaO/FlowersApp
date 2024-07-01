package com.example.flowersapp;

import static com.example.flowersapp.DetallesFlowerActivity.KEY_PARAM_FLOWER;

import android.content.Intent;
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
                Intent intent = new Intent(MainActivity.this, DetallesFlowerActivity.class);
                intent.putExtra(KEY_PARAM_FLOWER, flor);
                startActivity(intent);
            }
        });

        floresRV.setAdapter(flowersAdapter);
        flowersAdapter.setFlowers(getFlores());
    }

    private List<Flower> getFlores() {
        return new ArrayList<Flower>() {{
            add(new Flower(1, getString(R.string.flor1_nombre), getString(R.string.flor1_desc), Flower.ImagenId.FLOR1));
            add(new Flower(2,getString(R.string.flor2_nombre), getString(R.string.flor2_desc), Flower.ImagenId.FLOR2));
            add(new Flower(3, getString(R.string.flor3_nombre), getString(R.string.flor3_desc), Flower.ImagenId.FLOR3));
            add(new Flower(4, getString(R.string.flor4_nombre), getString(R.string.flor4_desc), Flower.ImagenId.FLOR4));
        }};
    }
}
