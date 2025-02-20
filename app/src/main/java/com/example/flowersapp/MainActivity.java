package com.example.flowersapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.flowers.Flower;
import com.example.flowersapp.flowers.FlowersAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView floresRV;
    private FlowersAdapter flowersAdapter;
    private Button agregarItemBtn;
    private int idContador = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAdapter();
        agregarItemBtn = findViewById(R.id.agregar_item);
        agregarItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Flower> newList = (ArrayList<Flower>) flowersAdapter.getFloresLista();
                newList.add(new Flower(idContador, getString(R.string.flor_nombre_ejemplo, idContador), getString(R.string.flor_desc_ejemplo), Flower.ImagenId.PLACEHOLDER));
                idContador++;
                flowersAdapter.setFlowers(newList);
            }
        });
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
        flowersAdapter.setFlowers(getFlowers());
    }

    private List<Flower> getFlowers() {
        return new ArrayList<Flower>() {{
            add(new Flower(1, getString(R.string.flor1_nombre), getString(R.string.flor1_desc), Flower.ImagenId.FLOR1));
            add(new Flower(2, getString(R.string.flor2_nombre), getString(R.string.flor2_desc), Flower.ImagenId.FLOR2));
            add(new Flower(3, getString(R.string.flor3_nombre), getString(R.string.flor3_desc), Flower.ImagenId.FLOR3));
        }};
    }
}
