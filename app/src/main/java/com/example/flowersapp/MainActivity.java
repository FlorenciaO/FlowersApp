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
    private Button eliminarPrimeroBtn;
    private Button eliminarUltimoBtn;
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
                List<Flower> listaPrevia = flowersAdapter.getFloresLista();
                ArrayList<Flower> newList = new ArrayList<>( listaPrevia );
                Flower primerElemento = new Flower(newList.get(0));
                Flower segundoElemento = new Flower(newList.get(1));

                primerElemento.setNombre("NUEVO NOMBRE"); // --> Se va a ejecutar el onBindViewHolder()
                segundoElemento.setDescripcion("NUEVA DESCRIPCION"); // --> No se va a ejecutar el onBindViewHolder()

                newList.set(0, primerElemento);
                newList.set(1, segundoElemento);

                // Modificamos elemento 3 - Imagen
                Flower tercerElemento = new Flower(newList.get(2));
                tercerElemento.setImagenId(Flower.ImagenId.FLOR2); // --> Se va a ejecutar el onBindViewHolder()
                newList.set(2, tercerElemento);

                flowersAdapter.setNewFlowers(newList);
            }
        });

        eliminarPrimeroBtn = findViewById(R.id.eliminar_primero);
        eliminarUltimoBtn = findViewById(R.id.eliminar_ultimo);

        eliminarPrimeroBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List<Flower> listaPrevia = flowersAdapter.getFloresLista();
                        ArrayList<Flower> newList = new ArrayList<>( listaPrevia );

                        newList.remove(0);

                        flowersAdapter.setNewFlowers(newList);
                    }
                }
        );
        eliminarUltimoBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List<Flower> listaPrevia = flowersAdapter.getFloresLista();
                        ArrayList<Flower> newList = new ArrayList<>( listaPrevia );

                        newList.remove(newList.size() - 1);
                        flowersAdapter.setNewFlowers(newList);
                    }
                }
        );
    }

    private void setupAdapter() {
        floresRV = findViewById(R.id.flower_recycler_view);

        flowersAdapter = new FlowersAdapter(new FlowersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Flower florNueva = flowersAdapter.getFloresLista().get(position);
                Intent intent = new Intent(MainActivity.this, DetallesFlowerActivity.class);
                intent.putExtra(KEY_PARAM_FLOWER, florNueva);
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
