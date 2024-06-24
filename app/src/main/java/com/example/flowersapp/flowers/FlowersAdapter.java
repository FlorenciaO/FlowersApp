package com.example.flowersapp.flowers;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void setNewFlowers(List<Flower> newFlowers) {
        /*
        Al llamar al metodo dispatchUpdatesTo(RecyclerView.Adapter) se envia la lista actualizada.
        El objeto DiffResult que se devuelve del cálculo de diferencias envía los cambios al adapter y
        le notifica los cambios.
         */
        final DiffUtilCallback diffCallback = new DiffUtilCallback(this.flowers, newFlowers);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.flowers.clear();
        this.flowers.addAll(newFlowers);
        diffResult.dispatchUpdatesTo(this);
    }

    public List<Flower> getLibros() {
        return this.flowers;
    }

    public interface OnItemClickListener {
        void onItemClick(Flower flower);
    }

    private class DiffUtilCallback extends DiffUtil.Callback {
        List<Flower> oldList;
        List<Flower> newList;

        public DiffUtilCallback(List<Flower> oldList, List<Flower> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        // Usar este metodo para saber si se trata de un item nuevo
        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Flower oldItem = oldList.get(oldItemPosition);
            Flower newItem = newList.get(newItemPosition);
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        // Usar este metodo para comparar el contenido del item
        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Flower oldItem = oldList.get(oldItemPosition);
            Flower newItem = newList.get(newItemPosition);
            return Objects.equals(oldItem.getDescripcion(), newItem.getDescripcion());
        }
    }
}
