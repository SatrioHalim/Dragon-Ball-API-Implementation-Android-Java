package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlanetDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView ivPlanetDetail;
    private TextView tvPlanetName, tvPlanetStatus, tvPlanetDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        toolbar = findViewById(R.id.toolbar);
        ivPlanetDetail = findViewById(R.id.ivPlanetDetail);
        tvPlanetName = findViewById(R.id.tvPlanetName);
        tvPlanetStatus = findViewById(R.id.tvPlanetStatus);
        tvPlanetDescription = findViewById(R.id.tvPlanetDescription);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        if (getIntent().hasExtra("PLANET_NAME")) {

            String name = getIntent().getStringExtra("PLANET_NAME");
            Boolean isDestroyed = getIntent().getBooleanExtra("PLANET_ISDESTROYED", false);
            String description = getIntent().getStringExtra("PLANET_DESCRIPTION");
            String imageUrl = getIntent().getStringExtra("PLANET_IMAGE");

            tvPlanetName.setText(name);
            tvPlanetDescription.setText(description);

            if (isDestroyed) {
                tvPlanetStatus.setText("Destroyed");

            } else {
                tvPlanetStatus.setText("Intact");
            }

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(name);
            }

            if (imageUrl != null && !imageUrl.isEmpty()) {
                Picasso.get().load(imageUrl).into(ivPlanetDetail);
            } else {
                // Set default planet image
                ivPlanetDetail.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}