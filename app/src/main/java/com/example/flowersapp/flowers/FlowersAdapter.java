package com.example.flowersapp.flowers;

import android.util.Log;
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

    private static final String TAG = "FlowersAdapter";

    private List<Flower> flowers = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public FlowersAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Este metodo se llama cuando el RecyclerView necesita una nueva vista, es decir, hay un item nuevo.
     */
    @NonNull
    @Override
    public FlowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLibro =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_flower, parent, false);
        Log.d(TAG, "onCreateViewHolder");
        return new FlowersViewHolder(itemLibro);
    }

    /**
     * Este metodo es llamado por el Recyclerview para mostrar la data en la posicion especificada.
     * Se debe actualizar la vista en base al item.
     */
    @Override
    public void onBindViewHolder(@NonNull FlowersViewHolder holder, int position) {
        holder.bind(flowers.get(position), onItemClickListener);
        Log.d(TAG, "onBindViewHolder");
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

    public List<Flower> getFloresLista() {
        return this.flowers;
    }

    public interface OnItemClickListener {
        void onItemClick(Flower flower);
    }
}
