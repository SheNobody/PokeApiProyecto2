package com.example.pokeapiproyecto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapiproyecto.R;
import com.example.pokeapiproyecto.data.PokemonShort;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<PokemonShort> items;
    PokemonItemListener listener;
    public PokemonAdapter(List<PokemonShort> items, PokemonItemListener listener) {
        this.items = items;
        this.listener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home, parent, false);
        return new PokemonViewHolder(view, listener);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PokemonViewHolder) {
            ((PokemonViewHolder) holder).decorateWith(items.get(position));
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<PokemonShort> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    public PokemonShort getItem(int position) {
        if(items == null || items.size() <= position) return null;
        return items.get(position);
    }
}
