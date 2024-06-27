package com.example.flowersapp.flowers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.R;

import java.util.ArrayList;
import java.util.List;

public class FlowersAdapter extends
        RecyclerView.Adapter<FlowersViewHolder> {

    private List<Flower> flowers = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public FlowersAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FlowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLibro =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_flower, parent, false);
        return new FlowersViewHolder(itemLibro);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowersViewHolder holder, int position) {
        holder.bind(flowers.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
        // TODO(4. Como mejora, utilizar un DiffUtil para mejor rendimiento)
        notifyDataSetChanged();
    }

    public List<Flower> getLibros() {
        return this.flowers;
    }

    public interface OnItemClickListener {
        void onItemClick(Flower flower);
    }
}
