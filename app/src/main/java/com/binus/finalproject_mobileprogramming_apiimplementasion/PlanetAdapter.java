package com.binus.finalproject_mobileprogramming_apiimplementasion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetAdapter  extends RecyclerView.Adapter<PlanetAdapter.ItemViewHolder> {
    ArrayList<DragonBallPlanet> planets;

    public PlanetAdapter(ArrayList<DragonBallPlanet> planets) {
        this.planets = planets;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRowNamePlanet,tvRowStatus;
        public ItemViewHolder(@NonNull View planetRowView) {
            super(planetRowView);
            tvRowNamePlanet = planetRowView.findViewById(R.id.tvRowNamePlanet);
            tvRowStatus = planetRowView.findViewById(R.id.tvRowStatus);
        }
    }
    @NonNull
    @Override
    public PlanetAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_row_view,parent,false);
        return new ItemViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.ItemViewHolder holder, int position) {
        DragonBallPlanet currentPlanet = planets.get(position);
        holder.tvRowNamePlanet.setText(currentPlanet.name);
        if(currentPlanet.isDestroyed){
            holder.tvRowStatus.setText("Destroyed");
        } else {
            holder.tvRowStatus.setText("Intact");
        }
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }


}
