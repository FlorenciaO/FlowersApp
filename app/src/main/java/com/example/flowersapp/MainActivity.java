package com.example.flowersapp;

import static com.example.flowersapp.DetallesFlowerActivity.KEY_PARAM_FLOWER;

import android.content.Intent;
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
    private Button modificarItemBtn;
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
                List<Flower> newList = new ArrayList<>( flowersAdapter.getFloresLista() );
                newList.add(new Flower(idContador, getString(R.string.flor_nombre_ejemplo), getString(R.string.flor_desc_ejemplo), Flower.ImagenId.PLACEHOLDER));
                idContador++;
                flowersAdapter.setNewFlowers(newList);
            }
        });
        modificarItemBtn = findViewById(R.id.modificar_item1);
        modificarItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Flower> newList = new ArrayList<>( flowersAdapter.getFloresLista() );
                newList.get(0).setNombre("NUEVO NOMBRE"); // --> Se va a ejecutar el onBindViewHolder()
                newList.get(1).setDescripcion("NUEVA DESCRIPCION"); // --> No se va a ejecutar el onBindViewHolder()

                flowersAdapter.setNewFlowers(newList);
            }
        });

        // TODO(Completar los de eliminar primero y ultimo, y ver qué sucede)
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
        }, getFlowers());

        floresRV.setAdapter(flowersAdapter);
    }

    private List<Flower> getFlowers() {
        return new ArrayList<Flower>() {{
            add(new Flower(1, getString(R.string.flor1_nombre), getString(R.string.flor1_desc), Flower.ImagenId.FLOR1));
            add(new Flower(2, getString(R.string.flor2_nombre), getString(R.string.flor2_desc), Flower.ImagenId.FLOR2));
            add(new Flower(3, getString(R.string.flor3_nombre), getString(R.string.flor3_desc), Flower.ImagenId.FLOR3));
        }};
    }
}
