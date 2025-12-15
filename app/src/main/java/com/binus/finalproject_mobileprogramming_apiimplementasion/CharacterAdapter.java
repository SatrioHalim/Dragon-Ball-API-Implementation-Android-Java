package com.binus.finalproject_mobileprogramming_apiimplementasion;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ItemViewHolder> {

    ArrayList<DragonBallCharacter> characters;
    public CharacterAdapter(ArrayList<DragonBallCharacter> charactersData){
        this.characters = charactersData;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRowName, tvRowRace;
        public ItemViewHolder(View characterRowView){
            super(characterRowView);
            tvRowName = characterRowView.findViewById(R.id.tvRowName);
            tvRowRace = characterRowView.findViewById(R.id.tvRowRace);
        }
    }
    @NonNull
    @Override
    public CharacterAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_row_view,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ItemViewHolder holder, int position) {
        DragonBallCharacter currentCharacter = characters.get(position);
        holder.tvRowName.setText(currentCharacter.name);
        holder.tvRowRace.setText(currentCharacter.race);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
