package com.example.flowersapp.flowers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.R;

public class FlowersParViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nombreTv;
    ImageView abrirIv;

    public FlowersParViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.flor_image_view);
        nombreTv = itemView.findViewById(R.id.nombre_text_view);
        abrirIv = itemView.findViewById(R.id.ver_mas_text_view);
    }

    public void bind(Flower flower, FlowersAdapter.OnItemClickListener onItemClickListener, int position) {
        nombreTv.setText(flower.getNombre());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });
        abrirIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });

        switch (flower.getImagenId()) {
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
    }
}
