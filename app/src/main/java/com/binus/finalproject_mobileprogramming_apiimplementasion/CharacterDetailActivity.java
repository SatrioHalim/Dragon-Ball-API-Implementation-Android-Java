package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView ivCharacterDetail;
    private TextView tvDetailName, tvDetailRace, tvDetailGender;
    private TextView tvDetailKi, tvDetailMaxKi, tvDetailAffiliation;
    private TextView tvDetailDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        toolbar = findViewById(R.id.toolbar);
        ivCharacterDetail = findViewById(R.id.ivCharacterDetail);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailRace = findViewById(R.id.tvDetailRace);
        tvDetailGender = findViewById(R.id.tvDetailGender);
        tvDetailKi = findViewById(R.id.tvDetailKi);
        tvDetailMaxKi = findViewById(R.id.tvDetailMaxKi);
        tvDetailAffiliation = findViewById(R.id.tvDetailAffiliation);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        if (getIntent().hasExtra("CHARACTER_NAME")) {
            String name = getIntent().getStringExtra("CHARACTER_NAME");
            String race = getIntent().getStringExtra("CHARACTER_RACE");
            String gender = getIntent().getStringExtra("CHARACTER_GENDER");
            String ki = getIntent().getStringExtra("CHARACTER_KI");
            String maxKi = getIntent().getStringExtra("CHARACTER_MAX_KI");
            String description = getIntent().getStringExtra("CHARACTER_DESCRIPTION");
            String imageUrl = getIntent().getStringExtra("CHARACTER_IMAGE");
            String affiliation = getIntent().getStringExtra("CHARACTER_AFFILIATION");

            tvDetailName.setText(name);
            tvDetailRace.setText(race);
            tvDetailGender.setText(gender);
            tvDetailKi.setText("Ki: " + ki);
            tvDetailMaxKi.setText("Max Ki: " + maxKi);
            tvDetailAffiliation.setText("Affiliation: " + affiliation);
            tvDetailDescription.setText(description);

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(name);
            }

            if (imageUrl != null && !imageUrl.isEmpty()) {
                Picasso.get().load(imageUrl).into(ivCharacterDetail);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}