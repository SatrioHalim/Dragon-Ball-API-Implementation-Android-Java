package com.binus.finalproject_mobileprogramming_apiimplementasion;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ItemViewHolder> {
    ArrayList<DragonBallCharacter> characters;

    public CharacterAdapter(ArrayList<DragonBallCharacter> charactersData){
        this.characters = charactersData;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRowName, tvRowRace;
        public ImageView ivImageURL;
        public ItemViewHolder(View characterRowView){
            super(characterRowView);
            tvRowName = characterRowView.findViewById(R.id.tvRowName);
            tvRowRace = characterRowView.findViewById(R.id.tvRowRace);
            ivImageURL = characterRowView.findViewById(R.id.ivImageURL);
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
        holder.tvRowRace.setText("Race : " + currentCharacter.race);
        Picasso.get().load(currentCharacter.imageURL).into(holder.ivImageURL);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, CharacterDetailActivity.class);

                // Kirim data character ke detail activity
                intent.putExtra("CHARACTER_NAME", currentCharacter.name);
                intent.putExtra("CHARACTER_RACE", currentCharacter.race);
                intent.putExtra("CHARACTER_GENDER", currentCharacter.gender);
                intent.putExtra("CHARACTER_KI", currentCharacter.ki);
                intent.putExtra("CHARACTER_MAX_KI", currentCharacter.maxKi);
                intent.putExtra("CHARACTER_DESCRIPTION", currentCharacter.description);
                intent.putExtra("CHARACTER_IMAGE", currentCharacter.imageURL);
                intent.putExtra("CHARACTER_AFFILIATION", currentCharacter.affiliation);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
