package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SearchPlanetActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etPlanetName;
    private RadioGroup rgStatus;
    private Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_planet);
        // Setup Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Planet");

        // Initialize views
        etPlanetName = findViewById(R.id.etPlanetName);
        rgStatus = findViewById(R.id.rgStatus);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void performSearch() {
        String name = etPlanetName.getText().toString().trim();
        String status = getSelectedStatus();

        // Validasi
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter search criteria", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kirim data ke CharacterResultsActivity
        Intent intent = new Intent(this, PlanetResultsActivity.class);
        intent.putExtra("SEARCH_NAME", name);
        intent.putExtra("SEARCH_STATUS", status);
        startActivity(intent);
    }
    private String getSelectedStatus() {
        int selectedId = rgStatus.getCheckedRadioButtonId();

        if (selectedId == R.id.rbDestroyed) {
            return "Destroyed";
        } else if (selectedId == R.id.rbIntact) {
            return "Intact";
        }
        return "Destroyed";
    }
}