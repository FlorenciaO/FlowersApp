package com.example.flowersapp.flowers;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.R;

import java.util.ArrayList;
import java.util.List;

public class FlowersAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Flower> flowers = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public FlowersAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 1:
                viewHolder = new FlowersImparViewHolder(layoutInflater.inflate(R.layout.item_flower_impar, parent, false));
                break;
            case 0:
                viewHolder = new FlowersParViewHolder(layoutInflater.inflate(R.layout.item_flower_par, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Flower flor = flowers.get(position);
        switch (getItemViewType(position)) {
            case 1:
                FlowersImparViewHolder viewHolder1 = (FlowersImparViewHolder) holder;
                viewHolder1.bind(flor, onItemClickListener);
                break;
            case 0:
                FlowersParViewHolder viewHolder2 = (FlowersParViewHolder) holder;
                viewHolder2.bind(flor, onItemClickListener);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2; // Retorna 0 si es par, 1 si es impar
    }

    public void setLibros(List<Flower> flowers) {
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
